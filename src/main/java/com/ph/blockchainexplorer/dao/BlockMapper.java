package com.ph.blockchainexplorer.dao;



import com.ph.blockchainexplorer.entity.Block;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlockMapper {
    int deleteByPrimaryKey(String blockhash);

    int truncate();

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(String blockhash);

    List<Block> selectRecent();

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    List<Block> selectRecent2();

    List<Block> search(@Param("data") String data);
}