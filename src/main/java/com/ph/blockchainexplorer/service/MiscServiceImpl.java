package com.ph.blockchainexplorer.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ph.blockchainexplorer.blockapi.BitcoinApi;
import com.ph.blockchainexplorer.dao.BlockMapper;
import com.ph.blockchainexplorer.entity.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MiscServiceImpl implements MiscService {

    @Autowired
    private BitcoinApi bitcoinApi;

    @Autowired
    private BlockMapper blockMapper;

    @Async
    @Override
    public void importFromHeight(Integer blockHeight, Boolean isClean) {

    }

    @Async
    @Override
    public void importFromHash(String blockHash, Boolean isClean) {
        if (isClean){
            blockMapper.truncate();
        }

        String temphash = blockHash;

        while (temphash != null && !temphash.isEmpty()){
            JSONObject blockOrigin = bitcoinApi.getBlock(temphash);
            Block block = new Block();
            block.setBlockhash(blockOrigin.getString("hash"));
            block.setBlockchainId(2);
            block.setHeight(blockOrigin.getInteger("height"));
            Long time = blockOrigin.getLong("time");
            Date date = new Date(time * 1000);
            block.setTime(date);
            JSONArray tx = blockOrigin.getJSONArray("tx");
            block.setTxSize(tx.size());
            block.setSizeOnDisk(blockOrigin.getLong("size"));
            block.setDifficulty(blockOrigin.getDouble("difficulty"));
            block.setPrevBlockhash(blockOrigin.getString("previousblockhash"));
            block.setNextBlockhash(blockOrigin.getString("nextblockhash"));
            block.setMerkleRoot(blockOrigin.getString("merkleroot"));
            blockMapper.insert(block);

            temphash = blockOrigin.getString("nextblockhash");
        }
    }
}
