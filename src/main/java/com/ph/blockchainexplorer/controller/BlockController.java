package com.ph.blockchainexplorer.controller;

import com.alibaba.fastjson.JSONObject;
import com.ph.blockchainexplorer.blockapi.BitcoinApi;
import com.ph.blockchainexplorer.blockapi.BitcoinJsonRpcClient;
import com.ph.blockchainexplorer.dao.BlockMapper;
import com.ph.blockchainexplorer.dto.BlockDetailDTO;
import com.ph.blockchainexplorer.dto.BlockListDTO;
import com.ph.blockchainexplorer.entity.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/block")
@CrossOrigin
public class BlockController {

    @Autowired
    private BitcoinApi bitcoinApi;

    @Autowired
    private BitcoinJsonRpcClient bitcoinJsonRpcClient;

    @Autowired
    private BlockMapper blockMapper;

    @Value("${blockchain.recentCount}")
    private Integer recentCount;

    @GetMapping("/getRecentBlocks")
    public List<BlockListDTO> getRecentBlocks() throws Throwable {

        String bestBlockhash = bitcoinJsonRpcClient.getBestBlockhash();
        String bestBlockhash1 = bestBlockhash;
        List<BlockListDTO> blockListDTOS =new LinkedList<>();
        for(int i =0;i<10;i++){
            JSONObject block =bitcoinApi.getNoTxBlock(bestBlockhash1);
            BlockListDTO blockListDTO = new BlockListDTO();
            blockListDTO.setHeight(block.getInteger("height"));
            Long time = block.getLong("time");
            Date date = new Date(time * 1000);
            blockListDTO.setTime(date);
            blockListDTO.setTxSize(block.getJSONArray("tx").size());
            blockListDTO.setSizeOnDisk(block.getLong("size"));
            blockListDTOS.add(blockListDTO);
            bestBlockhash1 = block.getString("previousblockhash");
        }

        return blockListDTOS;

//        List<Block> blocks = blockMapper.selectRecent();
//        List<BlockListDTO> blockListDTOS = blocks.stream().map(block -> {
//            BlockListDTO blockListDTO = new BlockListDTO();
//            blockListDTO.setHeight(block.getHeight());
//            blockListDTO.setTime(block.getTime().getTime());
//            blockListDTO.setTxSize(block.getTxSize());
//            blockListDTO.setSizeOnDisk(block.getSizeOnDisk());
//            return blockListDTO;
//        }).collect(Collectors.toList());
//
//        return blockListDTOS;


//        bitcoinApi.getBlockHeaders(recentCount,bestBlockhash)
    }


    @GetMapping("/getRecentBlocksById")
    public List<BlockListDTO> getRecentBlocksById(@RequestParam Integer blockchainId){
        return null;
    }

    @GetMapping("/getRecentBlocksByNameType")
    public List<BlockListDTO> getRecentBlocksByNameType(@RequestParam String name,
                                                        @RequestParam String type){
        return null;
    }

    @GetMapping("/getBlockDetailByHash")
    public BlockDetailDTO getBlockDetailByHash(@RequestParam String blockhash){
        return null;
    }

    @GetMapping("/getBlockDetailByHeight")
    public BlockDetailDTO getBlockDetailByHeight(@RequestParam Integer blockheight){
        return null;
    }
}
