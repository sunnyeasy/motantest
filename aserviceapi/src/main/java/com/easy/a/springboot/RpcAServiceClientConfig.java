package com.easy.a.springboot;

import com.easy.a.rpc.RpcAService;
import com.easy.a.rpc.RpcUserService;
import com.easy.common.MotanBeanConfig;
import com.easy.common.constants.AServiceConstants;
import com.weibo.api.motan.config.springsupport.BasicRefererConfigBean;
import com.weibo.api.motan.config.springsupport.RefererConfigBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RpcAServiceClientConfig {
    @Bean
    public BasicRefererConfigBean aServiceRefererConfig() {
        return MotanBeanConfig.getBasicRefererConfigBean(AServiceConstants.GROUP_NAME_CLIENT, AServiceConstants.APPLICATION_NAME, AServiceConstants.APPLICATION_NAME);
    }

    @Bean
    public RefererConfigBean<RpcAService> rpcAService(@Qualifier("aServiceRefererConfig") BasicRefererConfigBean aServiceRefererConfig) {
        RefererConfigBean<RpcAService> bean = new RefererConfigBean<>();
        bean.setVersion(RpcAService.VERSION);
        bean.setInterface(RpcAService.class);
        bean.setBasicReferer(aServiceRefererConfig);
        return bean;
    }

    @Bean
    public RefererConfigBean<RpcUserService> rpcUserService(@Qualifier("aServiceRefererConfig") BasicRefererConfigBean aServiceRefererConfig) {
        RefererConfigBean<RpcUserService> bean = new RefererConfigBean<>();
        bean.setVersion(RpcUserService.VERSION);
        bean.setInterface(RpcUserService.class);
        bean.setBasicReferer(aServiceRefererConfig);
        return bean;
    }
}
