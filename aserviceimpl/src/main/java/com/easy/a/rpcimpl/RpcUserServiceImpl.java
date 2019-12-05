package com.easy.a.rpcimpl;

import com.easy.a.rpc.RpcUserService;
import com.easy.b.rpc.RpcPayService;
import com.easy.common.vo.BaseRpcVo;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import org.springframework.beans.factory.annotation.Autowired;

@MotanService
public class RpcUserServiceImpl implements RpcUserService {

    @Autowired
    private RpcPayService rpcPayService;

    public BaseRpcVo getUser(Long id) {
        BaseRpcVo vo = new BaseRpcVo();
//        return String.valueOf(System.currentTimeMillis());

        rpcPayService.aliPay(100L);
        return vo;
    }
}
