package org.litefrw.beans.factory;

public interface BeanDefinition {
    // bean 对应的Class
    void setType(Class type);
    Class getType();

    //bean 名称
    void setName(String name);
    String getName();
}
