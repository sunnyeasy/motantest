package com.easy.b.rpc;

import com.easy.a.springboot.AServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AServiceApplication.class)
public class RpcPayServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(RpcPayServiceTest.class);

    @Autowired
    private RpcPayService rpcPayService;

    @Test
    public  void pay() {
        String s = rpcPayService.aliPay(100L);
        logger.info("s={}", s);
    }
}
