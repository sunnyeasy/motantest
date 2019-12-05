package com.easy.b.springboot;

import com.easy.b.rpc.RpcPayService;
import com.easy.common.MotanBeanConfig;
import com.easy.common.constants.BServiceConstants;
import com.weibo.api.motan.config.springsupport.BasicServiceConfigBean;
import com.weibo.api.motan.config.springsupport.ServiceConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RpcBServiceServerConfig {
    public static final String MOTAN_RPC_PORT = "9996";

    @Bean
    public BasicServiceConfigBean basicServiceConfig() {
        BasicServiceConfigBean bean = new BasicServiceConfigBean();

        bean.setExport(MotanBeanConfig.MOTAN_RPC_SERVERPROTOCOL_NAME + ":" + MOTAN_RPC_PORT);
        bean.setGroup(BServiceConstants.GROUP_NAME_SERVER);
        bean.setAccessLog(false);
        bean.setShareChannel(true);
        bean.setModule(BServiceConstants.APPLICATION_NAME);
        bean.setApplication(BServiceConstants.APPLICATION_NAME);
        bean.setRegistry(MotanBeanConfig.MOTAN_RPC_REGISTRY_NAME);
        return bean;
    }

    @Bean
    public ServiceConfigBean<RpcPayService> rpcPayService(@Autowired RpcPayService rpcPayService) {
        ServiceConfigBean<RpcPayService> bean = new ServiceConfigBean<RpcPayService>();
        bean.setInterface(RpcPayService.class);
        bean.setVersion(RpcPayService.VERSION);
        bean.setRef(rpcPayService);
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
