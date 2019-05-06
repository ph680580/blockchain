package com.ph.blockchainexplorer.controller;

import com.ph.blockchainexplorer.dao.TransactionDetailMapper;
import com.ph.blockchainexplorer.entity.TransactionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactionDetail")
@CrossOrigin
public class TransactionDetailController {

    @Autowired(required = false)
    private TransactionDetailMapper transactionDetailMapper;

    @GetMapping("/getTxDetailList")
    public List<TransactionDetail> getTransactionDetailList(@RequestParam(required = false) String txid){
        List<TransactionDetail> transactionDetailList = transactionDetailMapper.getTransactionDetailList(txid);
        return transactionDetailList;
    }

}
