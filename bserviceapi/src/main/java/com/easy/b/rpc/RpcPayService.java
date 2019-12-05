package com.easy.b.rpc;

public interface RpcPayService {
    String VERSION = "1.0";

    String aliPay(Long money);
}
