package com.ph.blockchainexplorer.service;

import com.ph.blockchainexplorer.dto.TransactionListDTO;
import com.ph.blockchainexplorer.entity.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> selectTransaction();

    List<Transaction> selectTransaction2();

}
