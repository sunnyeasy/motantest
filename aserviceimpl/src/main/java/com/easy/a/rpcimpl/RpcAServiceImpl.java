package com.easy.a.rpcimpl;

import com.easy.a.rpc.RpcAService;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MotanService
public class RpcAServiceImpl implements RpcAService {
    private static final Logger logger = LoggerFactory.getLogger(RpcAServiceImpl.class);

    public String helloA(Integer a) {
        logger.info("Hello A");
        return "Hello A";
    }
}
