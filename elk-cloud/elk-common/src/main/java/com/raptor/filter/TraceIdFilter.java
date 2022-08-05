package com.raptor.filter;

import cn.hutool.core.util.IdUtil;
import com.raptor.util.ThreadLocalUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/28  21:25
 */
@Order(1)
@WebFilter(urlPatterns = "/*",filterName = "traceIdFilter")
public class TraceIdFilter implements Filter {
    public final static String MDC_TRACE_ID = "traceId";
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String traceId = httpRequest.getHeader(MDC_TRACE_ID);
        if (StringUtils.isBlank(traceId)) {
            traceId = IdUtil.fastSimpleUUID();;
        }
        System.out.println(this.getClass().getName()+" traceId " + traceId);
        MDC.put(MDC_TRACE_ID, traceId);
        ThreadLocalUtils.setTraceId(traceId);
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader(MDC_TRACE_ID, traceId);
        chain.doFilter(request, response);
    }

}
