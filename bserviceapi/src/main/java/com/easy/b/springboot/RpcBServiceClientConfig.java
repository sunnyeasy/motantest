package com.easy.b.springboot;

import com.easy.b.rpc.RpcPayService;
import com.easy.common.MotanBeanConfig;
import com.easy.common.constants.BServiceConstants;
import com.weibo.api.motan.config.springsupport.BasicRefererConfigBean;
import com.weibo.api.motan.config.springsupport.RefererConfigBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RpcBServiceClientConfig {
    @Bean
    public BasicRefererConfigBean bServiceRefererConfig() {
        return MotanBeanConfig.getBasicRefererConfigBean(BServiceConstants.GROUP_NAME_CLIENT, BServiceConstants.APPLICATION_NAME, BServiceConstants.APPLICATION_NAME);
    }

    @Bean
    public RefererConfigBean<RpcPayService> rpcPayService(@Qualifier("bServiceRefererConfig") BasicRefererConfigBean bServiceRefererConfig) {
        RefererConfigBean<RpcPayService> bean = new RefererConfigBean<RpcPayService>();
        bean.setVersion(RpcPayService.VERSION);
        bean.setInterface(RpcPayService.class);
        bean.setBasicReferer(bServiceRefererConfig);
        return bean;
    }

}
