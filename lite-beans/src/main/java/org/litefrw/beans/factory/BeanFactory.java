package org.litefrw.beans.factory;

import org.litefrw.beans.exception.BeanDefinitionException;
import org.litefrw.beans.exception.BeanException;

public interface BeanFactory {
    <T> T getBean(String name, Class<T> type) throws BeanException;
    <T> T getBean(Class<T> type) throws BeanException;
    Object getBean(String name, Object... args) throws BeanException;
    boolean containsBean(String beanName);
    Class getType(String beanName) throws BeanDefinitionException;

}
