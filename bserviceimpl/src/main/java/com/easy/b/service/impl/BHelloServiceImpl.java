package com.easy.b.service.impl;

import com.easy.a.rpc.RpcAService;
import com.easy.b.service.BHelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BHelloServiceImpl implements BHelloService {
    private static final Logger logger = LoggerFactory.getLogger(BHelloServiceImpl.class);

//    @Autowired
//    private RpcAService rpcAService;
//
    public void helloB() {
//        String s = rpcAService.helloA(1);
//        logger.info("s={}", s);
    }
}
