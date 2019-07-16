package org.litefrw.beans.factory;

import org.litefrw.core.utils.Assert;
import org.litefrw.core.utils.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonBeanRegistry implements BeanRegistry {

    private final Map<String, Object> singletonObjectMap = new ConcurrentHashMap<String, Object>(64);

    @Override
    public void registerBean(String beanName, Object bean) {
        Assert.notNull(beanName, "'beanName' must not be null");

        synchronized (singletonObjectMap) {
            Object oldObject = singletonObjectMap.get(beanName);
            if (oldObject != null) {
                throw new IllegalStateException("Could not register object [" + bean +
                        "] under bean name '" + beanName + "': there is already object [" + oldObject + "] bound");
            }

            singletonObjectMap.put(beanName, (bean != null ? bean : new Object()));
        }
    }

    @Override
    public Object getBean(String beanName) {
        Assert.notNull(beanName, "'beanName' must not be null");
        synchronized (singletonObjectMap) {
            return singletonObjectMap.get(beanName);
        }
    }

    @Override
    public boolean containsBean(String beanName) {
        Assert.notNull(beanName, "'beanName' must not be null");
        synchronized (singletonObjectMap) {
            Object obj = singletonObjectMap.get(beanName);
            return obj != null ? true : false;
        }
    }

    @Override
    public int getBeanCount() {
        synchronized (singletonObjectMap) {
            return singletonObjectMap.size();
        }
    }

    @Override
    public String[] getBeanNames() {
        synchronized (singletonObjectMap) {
            return StringUtils.toStringArray(singletonObjectMap.keySet());
        }
    }
}
