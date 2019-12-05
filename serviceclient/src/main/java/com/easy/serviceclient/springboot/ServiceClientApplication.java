package com.easy.serviceclient.springboot;

import com.alibaba.fastjson.JSONObject;
import com.easy.a.rpc.RpcUserService;
import com.easy.common.vo.BaseRpcVo;
import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackages = "com.easy")
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class ServiceClientApplication {
    private static final Logger logger = LoggerFactory.getLogger(ServiceClientApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ServiceClientApplication.class, args);
        MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);

        RpcUserService bean = applicationContext.getBean(RpcUserService.class);
        BaseRpcVo user = bean.getUser(100L);
        logger.info("user={}", JSONObject.toJSON(user));
    }

}
