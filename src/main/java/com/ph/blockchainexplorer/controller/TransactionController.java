package com.ph.blockchainexplorer.controller;

import com.ph.blockchainexplorer.dto.TransactionInfoDTO;
import com.ph.blockchainexplorer.dto.TransactionListDTO;
import com.ph.blockchainexplorer.dto.TransactionListDTO2;
import com.ph.blockchainexplorer.entity.Transaction;
import com.ph.blockchainexplorer.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transaction")
@CrossOrigin
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
        List<Transaction> transactions = transactionService.selectTransaction();
        List<TransactionListDTO> transactionListDTOS = transactions.stream().map(transaction -> {
            TransactionListDTO transactionListDTO =new TransactionListDTO();
            transactionListDTO.setTxhash(transaction.getTxhash());
            transactionListDTO.setTime(transaction.getTime());
            transactionListDTO.setAmount(transaction.getAmount());
            return transactionListDTO;
        }).collect(Collectors.toList());

        return transactionListDTOS;
    }


    @GetMapping("/getTransaction2")
    public List<TransactionListDTO2> getTransaction2(){
        List<Transaction> transactions = transactionService.selectTransaction2();
        List<TransactionListDTO2> transactionListDTOS2 = transactions.stream().map(transaction2 -> {
            TransactionListDTO2 transactionListDTO2 = new TransactionListDTO2();
            transactionListDTO2.setTxhash(transaction2.getTxhash());
            transactionListDTO2.setTime(transaction2.getTime());
            transactionListDTO2.setAmount(transaction2.getAmount());
            return transactionListDTO2;
        }).collect(Collectors.toList());

        return transactionListDTOS2;
    }

}
