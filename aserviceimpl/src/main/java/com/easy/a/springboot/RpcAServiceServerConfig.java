package com.easy.a.springboot;

import com.easy.a.rpc.RpcAService;
import com.easy.a.rpc.RpcUserService;
import com.easy.common.MotanBeanConfig;
import com.easy.common.constants.AServiceConstants;
import com.weibo.api.motan.config.springsupport.BasicServiceConfigBean;
import com.weibo.api.motan.config.springsupport.ServiceConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RpcAServiceServerConfig {
    public static final String MOTAN_RPC_PORT = "9990";

    @Bean
    public BasicServiceConfigBean basicServiceConfig() {
        BasicServiceConfigBean bean = new BasicServiceConfigBean();

        bean.setExport(MotanBeanConfig.MOTAN_RPC_SERVERPROTOCOL_NAME + ":" + MOTAN_RPC_PORT);
        bean.setGroup(AServiceConstants.GROUP_NAME_SERVER);
        bean.setAccessLog(false);
        bean.setShareChannel(true);
        bean.setModule(AServiceConstants.APPLICATION_NAME);
        bean.setApplication(AServiceConstants.APPLICATION_NAME);
        bean.setRegistry(MotanBeanConfig.MOTAN_RPC_REGISTRY_NAME);
        return bean;
    }

    @Bean
    public ServiceConfigBean<RpcAService> rpcAservice(@Autowired RpcAService rpcAService) {
        ServiceConfigBean<RpcAService> bean = new ServiceConfigBean<RpcAService>();
        bean.setInterface(RpcAService.class);
        bean.setVersion(RpcAService.VERSION);
        bean.setRef(rpcAService);
        bean.setFilter("serverExceptionFilter");
        return bean;
    }

    @Bean
    public ServiceConfigBean<RpcUserService> rpcUserService(@Autowired RpcUserService rpcUserService) {
        ServiceConfigBean<RpcUserService> bean = new ServiceConfigBean<RpcUserService>();
        bean.setInterface(RpcUserService.class);
        bean.setVersion(RpcUserService.VERSION);
        bean.setRef(rpcUserService);
        bean.setFilter("serverExceptionFilter");
        return bean;
    }

//    @Bean
//    public AnnotationBean motanAnnotationBean() {
//        AnnotationBean motanAnnotationBean = new AnnotationBean();
//        motanAnnotationBean.setPackage("com.easy.rpc");
//        return motanAnnotationBean;
//    }

}
