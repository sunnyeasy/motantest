package com.easy.b.rpcImpl;

import com.easy.b.rpc.RpcPayService;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;

@MotanService
public class RpcPayServiceImpl implements RpcPayService {
    public String aliPay(Long money) {
        return String.valueOf(System.currentTimeMillis());
    }
}
