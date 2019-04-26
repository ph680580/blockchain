package com.ph.blockchainexplorer.dao;

import com.ph.blockchainexplorer.dto.TransactionListDTO;
import com.ph.blockchainexplorer.entity.Transaction;

import java.util.List;

public interface TransactionMapper {
    int deleteByPrimaryKey(String txid);

    int truncate();

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(String txid);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);

    List<Transaction> selectTransaction();

}