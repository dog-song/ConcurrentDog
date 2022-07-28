package com.dogsong.utils;

import com.dogsong.commons.Constants;
import org.slf4j.MDC;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * 线程日志TraceId设置工具类
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/25
 */
public class ThreadMdcUtil {

    public static void setTraceIdIfAbsent() {
        if (MDC.get(Constants.TRACE_ID) == null) {
            setTraceId();
        }
    }

    public static void setTraceId() {
        MDC.put(Constants.TRACE_ID, UUIDUtil.build());
    }

    public static void setTraceId(String traceId) {
        MDC.put(Constants.TRACE_ID, traceId);
    }

    public static String getTraceId() {
        return MDC.get(Constants.TRACE_ID);
    }

    public static void clear() {
        MDC.clear();
    }

    public static <T> Callable<T> wrap(final Callable<T> callable, final Map<String, String> context) {
        return () -> {
            if (context == null) {
                clear();
            } else {
                MDC.setContextMap(context);
            }
            setTraceIdIfAbsent();
            try {
                return callable.call();
            } finally {
                clear();
            }
        };
    }

    public static Runnable wrap(final Runnable runnable, final Map<String, String> context) {
        return () -> {
            if (context == null) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            setTraceIdIfAbsent();
            try {
                runnable.run();
            } finally {
                clear();
            }
        };
    }

}
