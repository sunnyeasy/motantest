package com.easy.common.motan.filter;

import com.easy.common.code.AnwserCode;
import com.easy.common.exception.BaseException;
import com.easy.common.exception.BusinessException;
import com.easy.common.vo.BaseRpcVo;
import com.weibo.api.motan.core.extension.Activation;
import com.weibo.api.motan.core.extension.SpiMeta;
import com.weibo.api.motan.exception.MotanBizException;
import com.weibo.api.motan.filter.Filter;
import com.weibo.api.motan.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SpiMeta(name = "serverExceptionFilter")
public class ServerExceptionFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(ServerExceptionFilter.class);

    /**
     * 只对provider有效
     * */
    public Response filter(Caller<?> caller, Request request) {
        if (false == caller instanceof Provider) {
            return caller.call(request);
        }

        // 检查rpc返回类型
        CheckRpcReturnTypeFuncVo funcVo = checkRpcReturnType(caller, request);
        if (!funcVo.check) {
            logger.error("rpc接口定义错误, url={}#{}", request.getInterfaceName(), request.getMethodName());

            DefaultResponse eresponse = new DefaultResponse();
            BusinessException exception = new BusinessException(new AnwserCode(AnwserCode.RPC_DEFINE_ERROR.getCode(),
                    String.format("RPC接口(%s#%s)定义错误", request.getInterfaceName(), request.getMethodName())));
            if (exception.getCause() != null) {
                eresponse.setException(new MotanBizException("provider call process error", exception.getCause()));
            } else {
                eresponse.setException(new MotanBizException("provider call process error", exception));
            }
            return eresponse;
        }

        Response response = caller.call(request);

        if (null == response.getException()) {
            // 接口未抛出异常，正常返回
            return response;
        } else {
            // 接口抛出异常
            logger.error("rpc调用异常, url={}#{}", request.getInterfaceName(), request.getMethodName(), response.getException());
            return exceptionToRpcVo(caller, request, response, funcVo);
        }
    }

    private class CheckRpcReturnTypeFuncVo {
        public boolean check;
        public Method callerMethod;
        public Class<?> callerReturnType;
    }

    /**
     * 检查rpc返回类型
     * 1.不能是void
     * 2.必须是BaseRpcVo子类
     * */
    private CheckRpcReturnTypeFuncVo checkRpcReturnType(Caller<?> caller, Request request) {
        CheckRpcReturnTypeFuncVo funcVo = new CheckRpcReturnTypeFuncVo();
        if(false == caller instanceof AbstractProvider) {
            logger.error("caller不是AbstractProvider对象, url={}#{}, class={}", request.getInterfaceName(), request.getMethodName(), caller.getClass().getName());
            funcVo.check = false;
            return funcVo;
        }

        AbstractProvider provider = (AbstractProvider) caller;
        Method method = provider.lookupMethod(request.getMethodName(), request.getParamtersDesc());
        if (null == method) {
            logger.error("rpc找不到接口中的方法, url={}#{}", request.getInterfaceName(), request.getMethodName());
            funcVo.check = false;
            return funcVo;
        }

        Class<?> returnType = method.getReturnType();
        if (returnType.getName().equals("void")) {
            logger.error("rpc方法返回类型是void, url={}#{}", request.getInterfaceName(), request.getMethodName());
            funcVo.check = false;
            return funcVo;
        }

        if (!BaseRpcVo.class.isAssignableFrom(returnType)) {
            logger.error("rpc方法返回类型错误, url={}#{}", request.getInterfaceName(), request.getMethodName());
            funcVo.check = false;
            return funcVo;
        }

        funcVo.check = true;
        funcVo.callerReturnType = returnType;
        funcVo.callerMethod = method;
        return funcVo;
    }

    private Response exceptionToRpcVo(Caller<?> caller, Request request, Response response, CheckRpcReturnTypeFuncVo funcVo) {
        Class<?> returnType = funcVo.callerReturnType;
        if (returnType.getName().equals("void")) {
            logger.error("rpc方法返回类型是void, url={}#{}", request.getInterfaceName(), request.getMethodName());
            return response;
        }

        Object value;
        try {
            value = returnType.newInstance();
        } catch (InstantiationException e) {
            logger.error("创建返回对象异常, url={}#{}", request.getInterfaceName(), request.getMethodName(), e);
            return response;
        } catch (IllegalAccessException e) {
            logger.error("创建返回对象异常, url={}#{}", request.getInterfaceName(), request.getMethodName(), e);
            return response;
        }

        AnwserCode anwserCode = BaseException.getExceptionInfo(response.getException());

        boolean hasAnwserCode = false;
        Class clz = returnType;
        while (!clz.equals(Object.class)) {
            Field[] fields = clz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                if (fields[i].getType().equals(AnwserCode.class)) {
                    fields[i].setAccessible(true);
                    try {
                        fields[i].set(value, anwserCode);
                    } catch (IllegalAccessException e) {
                        logger.error("修改anwserCode异常, url={}#{}", request.getInterfaceName(), request.getMethodName(), e);
                        return response;
                    }
                    hasAnwserCode = true;
                    break;
                }
            }

            if (hasAnwserCode) {
                break;
            }

            clz = clz.getSuperclass();
        }

        if (!hasAnwserCode) {
            logger.error("返回对象不存在anwserCode字段, class={}", returnType.getName());
            throw new BusinessException(AnwserCode.RPC_DEFINE_ERROR);
        }

        return new DefaultResponse(value);
    }
}
