package org.litefrw.beans.factory;

import org.litefrw.beans.exception.BeanDefinitionException;
import org.litefrw.beans.exception.BeanDefinitionRegistryException;
import org.litefrw.core.utils.Assert;
import org.litefrw.core.utils.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultBeanFactory extends AbstractBeanFactory implements BeanDefinitionRegistry {
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(64);

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws BeanDefinitionRegistryException {
        Assert.hasText(beanName, "beanName must not be empty");
        Assert.notNull(beanDefinition, "BeanDefinition must not be null");

        Object oldBeanDefinition = beanDefinitionMap.get(beanName);
        if (oldBeanDefinition == null) {
            beanDefinitionMap.put(beanName, beanDefinition);
        } else {
            throw new BeanDefinitionRegistryException(beanName,
                    "Cannot register bean definition [" + beanDefinition + "] for bean '" + beanName +
                            "': There is already [" + oldBeanDefinition + "] bound.");
        }
    }

    @Override
    public void removeBeanDefinition(String beanName) throws BeanDefinitionException {
        Assert.hasText(beanName, "beanName must not be empty");

        BeanDefinition removedBeanDefinition = beanDefinitionMap.remove(beanName);
        if (removedBeanDefinition == null) {
            throw new BeanDefinitionException(beanName);
        }
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeanDefinitionException {
        Assert.hasText(beanName, "beanName must not be empty");
        return beanDefinitionMap.get(beanName);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        Assert.hasText(beanName, "beanName must not be empty");
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public int getBeanDefinitionCount() {
        return beanDefinitionMap.size();
    }

    @Override
    public String[] getBeanDefinitaionNames() {
        return StringUtils.toStringArray(beanDefinitionMap.keySet());
    }

    @Override
    public Class getType(String beanName) throws BeanDefinitionException {
        Assert.hasText(beanName, "beanName must not be empty");
        Object beanInstance = getBean(beanName);
        if (beanInstance != null) {
            return beanInstance.getClass();
        }
        return null;
    }
}
