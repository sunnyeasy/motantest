package com.easy.a.rpc;

import com.easy.b.springboot.BServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BServiceApplication.class)
public class RpcAServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(RpcAServiceTest.class);

    @Autowired
    private RpcAService rpcAService;

//    @Autowired
//    private BHelloService bHelloService;
//
//    @Test
//    public void helloB() {
//        bHelloService.helloB();
//    }

    @Test
    public void helloA() throws InterruptedException {
//        Thread.sleep(30000);

        String s = rpcAService.helloA(1);
        logger.info("s={}", s);
    }
}
