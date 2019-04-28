package com.ph.blockchainexplorer.service;

import com.ph.blockchainexplorer.dao.BlockMapper;
import com.ph.blockchainexplorer.entity.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockMapper blockMapper;


    @Override
    public Block getBlockDetai(String blockhash) {
        Block block = blockMapper.selectByPrimaryKey(blockhash);
        return block;
    }

    @Override
    public List<Block> selectRecent() {
        List<Block> blocks =blockMapper.selectRecent();
        return blocks;
    }

    @Override
    public List<Block> selectRecent2() {
        List<Block> blocks2 = blockMapper.selectRecent2();
        return blocks2;
    }


}
