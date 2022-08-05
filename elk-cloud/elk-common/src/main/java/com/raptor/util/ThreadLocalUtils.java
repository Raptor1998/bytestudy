package com.raptor.util;

import cn.hutool.core.util.IdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/28  21:32
 */
public class ThreadLocalUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadLocalUtils.class);
    private static ThreadLocal<String> traceIdThreadLocal = new ThreadLocal();

    private ThreadLocalUtils() {
    }

    public static void setTraceId(String traceId) {
        traceIdThreadLocal.set(traceId);
    }

    public static String getTraceId() {
        if (null == traceIdThreadLocal.get()) {
            traceIdThreadLocal.set(IdUtil.fastSimpleUUID());
        }

        return (String)traceIdThreadLocal.get();
    }

    public static void removeTraceId() {
        traceIdThreadLocal.remove();
    }
}
