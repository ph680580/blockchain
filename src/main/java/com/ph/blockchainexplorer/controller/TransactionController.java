package com.ph.blockchainexplorer.controller;

import com.ph.blockchainexplorer.dto.TransactionInfoDTO;
import com.ph.blockchainexplorer.dto.TransactionListDTO;
import com.ph.blockchainexplorer.entity.Transaction;
import com.ph.blockchainexplorer.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/getRecentTransactionsById")
    public List<TransactionListDTO> getRecentTransactionsById(@RequestParam Integer blockchainId){
        return null;
    }

    @GetMapping("/getRecentTransactionsByNameType")
    public List<TransactionListDTO> getRecentTransactionsByNameType(@RequestParam String name,
                                                                    @RequestParam String type){
        return null;
    }

    @GetMapping("/getTransactionInfoByTxid")
    public TransactionInfoDTO getTransactionInfoByTxid(@RequestParam String txid){
        return null;
    }

    @GetMapping("/getTransactionInfoByTxhash")
    public TransactionInfoDTO getTransactionInfoByTxhash(@RequestParam String txhash){
        return null;
    }

    @GetMapping("/getTransaction")
    public List<TransactionListDTO> getTransaction(){
//        List<Block> blocks =blockService.selectRecent();
        List<Transaction> transactions = transactionService.selectTransaction();
        List<TransactionListDTO> transactionListDTOS = transactions.stream().map(transaction -> {
            TransactionListDTO transactionListDTO =new TransactionListDTO();
            transactionListDTO.setTxhash(transactionListDTO.getTxhash());
            transactionListDTO.setTime(transactionListDTO.getTime());
            transactionListDTO.setAmount(transactionListDTO.getAmount());
            return transactionListDTO;
        }).collect(Collectors.toList());

        return transactionListDTOS;
    }

}
