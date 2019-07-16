package org.litefrw.beans.exception;

public class BeanDefinitionRegistryException extends BeanException {

    private String beanName;

    public BeanDefinitionRegistryException(String message) {
        super(message);
    }

    public BeanDefinitionRegistryException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanDefinitionRegistryException(String message, String beanName) {
        super(message);
        this.beanName = beanName;
    }

    public BeanDefinitionRegistryException(String message, Throwable cause, String beanName) {
        super(message, cause);
        this.beanName = beanName;
    }
}
