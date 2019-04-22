package com.ph.blockchainexplorer.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ph.blockchainexplorer.blockapi.BitcoinApi;
import com.ph.blockchainexplorer.blockapi.BitcoinJsonRpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
public class TempController {

    @Autowired
    private BitcoinApi bitcoinApi;

    @Autowired
    private BitcoinJsonRpcClient bitcoinJsonRpcClient;

    @GetMapping("/test")
    public void test() throws Throwable {
//        JSONObject chainInfo = bitcoinApi.getChainInfo();
//        String txhash="41f65db3b3d0e1a9cd8cf09bc09a4bea85e874f1b38616c844b45f03b74593eb";
//        JSONObject transaction = bitcoinApi.getTransaction(txhash);
//        String blockhash = "000000000000004b1aecd12119a19e38efdce8c385f89a5d3a7698427108a2ee";
//        JSONObject block = bitcoinApi.getBlock(blockhash);
//        JSONObject noTxBlock = bitcoinApi.getNoTxBlock(blockhash);
//        String blockhash2 = "00000000000000a727d074e9d1cc0a225540eb40693d6aa15d702b0bd96d378b";
//        JSONArray blockHeaders = bitcoinApi.getBlockHeaders(10, blockhash2);
//        JSONObject mempoolInfo = bitcoinApi.getMempoolInfo();
//        JSONObject mempoolContents = bitcoinApi.getMempoolContents();
//        String blockHashByHeight = bitcoinJsonRpcClient.getBlockHashByHeight(1489445);
        String address = "mwt9LmdatUcksGQ8eEbKbbPnczUmTq4G9h";
        Double balanceAmount = bitcoinJsonRpcClient.getBalance(address);

    }








}
