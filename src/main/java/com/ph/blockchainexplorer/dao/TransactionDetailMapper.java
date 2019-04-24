package com.ph.blockchainexplorer.dao;


import com.ph.blockchainexplorer.entity.TransactionDetail;
import com.ph.blockchainexplorer.entity.TransactionDetailKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionDetailMapper {
    int deleteByPrimaryKey(TransactionDetailKey key);

    int truncate();

    int insert(TransactionDetail record);

    int insertSelective(TransactionDetail record);

    TransactionDetail selectByPrimaryKey(TransactionDetailKey key);

    int updateByPrimaryKeySelective(TransactionDetail record);

    int updateByPrimaryKey(TransactionDetail record);

    List<TransactionDetail> selectByAddress(@Param("address") String address);
}