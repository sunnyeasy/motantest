package com.easy.a.rpc;

import com.easy.common.vo.BaseRpcVo;

public interface RpcUserService {
    String VERSION = "1.0";

    BaseRpcVo getUser(Long id);
}
