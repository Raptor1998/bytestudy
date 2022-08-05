package com.raptor.config;

import com.raptor.filter.TraceIdFilter;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/28  21:29
 */
@Component
public class OpenFeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String traceId = MDC.get(TraceIdFilter.MDC_TRACE_ID);
        System.out.println("OpenFeignRequestInterceptor traceId " + traceId);
        requestTemplate.header(TraceIdFilter.MDC_TRACE_ID, traceId);
    }
}
