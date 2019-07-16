package org.litefrw.beans.factory;


import org.litefrw.beans.exception.BeanDefinitionException;
import org.litefrw.beans.exception.BeanDefinitionRegistryException;

public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws BeanDefinitionRegistryException;
    void removeBeanDefinition(String beanName) throws BeanDefinitionException;
    BeanDefinition getBeanDefinition(String beanName) throws BeanDefinitionException;
    boolean containsBeanDefinition(String beanName);
    int getBeanDefinitionCount();
    String[] getBeanDefinitaionNames();
}
