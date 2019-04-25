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
//        String txhash = "4e8103035441c375860f9d0006dc70a50157d1047c7b22c678431a204ad65ddb";
//        JSONObject transaction = bitcoinApi.getTransaction(txhash);
//        String blockhash = "0000000000000345e5f2d118e21918861fdd66d07b7d15522778778403c32296";
//        JSONObject block = bitcoinApi.getBlock(blockhash);
//        JSONObject noTxBlock = bitcoinApi.getNoTxBlock(blockhash);
//        String blockhash2 = "00000000000000a727d074e9d1cc0a225540eb40693d6aa15d702b0bd96d378b";
//        JSONArray blockHeaders = bitcoinApi.getBlockHeaders(10, blockhash2);
//        JSONObject mempoolInfo = bitcoinApi.getMempoolInfo();
//        JSONObject mempoolContents = bitcoinApi.getMempoolContents();
//        String blockHashByHeight = bitcoinJsonRpcClient.getBlockHashByHeight(1489445);
//        String address = "mwt9LmdatUcksGQ8eEbKbbPnczUmTq4G9h";
//        Double balanceAmount = bitcoinJsonRpcClient.getBalance(address);

          String txid = "d574f343976d8e70d91cb278d21044dd8a396019e6db70755a0a50e4783dba38";
//        Integer n = 0;
//        JSONObject utxo = bitcoinApi.getUTXO(txid, n);
          JSONObject rawTransaxtion = bitcoinJsonRpcClient.getRawTransaxtion(txid);

    }
}
