package org.litefrw.beans.exception;

public class BeanInstantiationException extends BeanException {
    private Class beanClass;

    public BeanInstantiationException(Class type) {
        super(String.format("Could not instantiate bean class [{}]", type.getName()));
        this.beanClass = type;
    }

    public BeanInstantiationException(Class type, String msg, Throwable cause) {
        super(String.format("Could not instantiate bean class [{}]:{}", type.getName(), msg), cause);
        this.beanClass = type;
    }
}
