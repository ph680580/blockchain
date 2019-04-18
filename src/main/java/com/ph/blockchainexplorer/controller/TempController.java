package com.ph.blockchainexplorer.controller;

import com.alibaba.fastjson.JSONObject;
import com.ph.blockchainexplorer.blockapi.BitcoinApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
public class TempController {

    @Autowired
    private BitcoinApi bitcoinApi;

    @GetMapping("/test")
    public void test(){
        JSONObject chainInfo = bitcoinApi.getChainInfo();
    }








}
