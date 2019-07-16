package org.litefrw.beans.factory;

public interface BeanRegistry {
    void registerBean(String beanName, Object bean);
    Object getBean(String beanName);
    boolean containsBean(String beanName);
    int getBeanCount();
    String[] getBeanNames();
}
