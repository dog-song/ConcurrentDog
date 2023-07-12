package com.dogsong.common;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 通知处理上下文信息
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/7/12
 */
@Slf4j
public class NoticeHandlerContext extends ConcurrentHashMap<String, Object> {

    private static final long serialVersionUID = -7723401814458456310L;

    protected static Class<? extends NoticeHandlerContext> contextClass = NoticeHandlerContext.class;

    protected static final ThreadLocal<? extends NoticeHandlerContext> THREAD_LOCAL = ThreadLocal.withInitial(() -> {
        try {
            return contextClass.newInstance();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    });

    public static void setContextClass(Class<? extends NoticeHandlerContext> clazz) {
        contextClass = clazz;
    }

    public static NoticeHandlerContext getCurrentContext() {
        return THREAD_LOCAL.get();
    }

    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defaultResponse) {
        Boolean b = (Boolean) get(key);
        return Objects.isNull(b) ? defaultResponse : b;
    }

    public void set(String key) {
        put(key, Boolean.TRUE);
    }

    public void set(String key, Object value) {
        if (value != null) {
            put(key, value);
        } else {
            remove(key);
        }
    }

    /**
     * unsets the threadLocal context
     */
    public void unset() {
        THREAD_LOCAL.remove();
    }

    public NoticeHandlerContext() {
        super();
    }
}
