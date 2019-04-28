package com.ph.blockchainexplorer.service;

import com.ph.blockchainexplorer.entity.Block;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlockService {
    Block getBlockDetai(String blockhash);

    List<Block> selectRecent();

    List<Block> selectRecent2();



}
