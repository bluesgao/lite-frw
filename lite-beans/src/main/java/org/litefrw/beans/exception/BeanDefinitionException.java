package org.litefrw.beans.exception;

public class BeanDefinitionException extends BeanException {
    private String beanName;
    private Class beanClass;

    public BeanDefinitionException(String name) {
        super("No bean named '" + name + "' is defined");
        this.beanName = name;
    }

    public BeanDefinitionException(Class<?> type) {
        super("No unique bean of type [" + type.getName() + "] is defined");
        this.beanClass = type;
    }
}
