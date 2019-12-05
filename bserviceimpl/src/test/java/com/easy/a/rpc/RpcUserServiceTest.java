package com.easy.a.rpc;

import com.alibaba.fastjson.JSONObject;
import com.easy.b.springboot.BServiceApplication;
import com.easy.common.vo.BaseRpcVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BServiceApplication.class)
public class RpcUserServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(RpcUserServiceTest.class);

    @Autowired
    private RpcUserService rpcUserService;

    @Test
    public void getUser() throws InterruptedException {
        try {
            BaseRpcVo vo = rpcUserService.getUser(null);
            logger.info("vo={}", JSONObject.toJSON(vo));

        } catch (Exception e) {
            logger.error("getUser exception, ", e);
        }

        Thread.sleep(1000000);

    }
}
