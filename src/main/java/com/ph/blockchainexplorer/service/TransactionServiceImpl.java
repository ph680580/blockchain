package com.ph.blockchainexplorer.service;


import com.ph.blockchainexplorer.dao.TransactionMapper;
import com.ph.blockchainexplorer.dto.TransactionListDTO;
import com.ph.blockchainexplorer.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionMapper transactionMapper;


    @Override
    public List<Transaction> selectTransaction() {
        List<Transaction> transactions = transactionMapper.selectTransaction();
        return transactions;
    }
}
