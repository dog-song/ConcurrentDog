package com.dogsong.adapter.handler.extend;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * ExtendAdapterDataModelRegistry
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/6/30
 */
@Slf4j
@Component
public class ExtendAdapterDataModelRegistry {

    public static final ConcurrentMap<String, ExtendAdapterService> extendMap = new ConcurrentHashMap<>();

    @Autowired(required = false)
    public void setExtendMap(List<ExtendAdapterService> services) {
        if (CollectionUtils.isNotEmpty(services)) {
            services.forEach(this::register);
        }
    }

    private void register(ExtendAdapterService service) {
        if (service.getTransCode() == null) {
            return;
        }
        Assert.notNull(service, "ExtendAdapterService must not be null.");
        extendMap.put(service.getTransCode(), service);
        log.info("registered ExtendAdapterService: {} for type: {} .", service.getClass().getName(), service.getTransCode());
    }

    public static ExtendAdapterService getExtendService(String transCode) {
        return extendMap.get(transCode);
    }

}
