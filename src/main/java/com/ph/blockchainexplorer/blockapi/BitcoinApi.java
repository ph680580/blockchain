package com.ph.blockchainexplorer.blockapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="bitcoin",url = "http://localhost:18332")
public interface BitcoinApi {

    //区块链接口
    @GetMapping("/rest/chaininfo.json")
    JSONObject getChainInfo();

    //交易的接口
    @GetMapping("/rest/tx/{txhash}.json")
    JSONObject getTransaction(@PathVariable("txhash")String txhash);

    //区块的接口
    @GetMapping("/rest/block/{blockhash}.json")
    JSONObject getBlock(@PathVariable("blockhash") String blockhash);

    //区块哈希的接口
    @GetMapping("/rest/block/notxdetails/{blockhash}.json")
    JSONObject getNoTxBlock(@PathVariable("blockhash") String blockhash);

    //区块头的接口
    @GetMapping("/rest/headers/{count}/{blockhash}.json")
    JSONArray getBlockHeaders(@PathVariable("count") Integer count, @PathVariable("blockhash") String blockhash);

    //有关交易内存的信息
    @GetMapping("/rest/mempool/info.json")
    JSONObject getMempoolInfo();

    @GetMapping("/rest/mempool/contents.json")
    JSONObject getMempoolContents();




}
