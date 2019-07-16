package org.litefrw.beans.factory;


import org.litefrw.beans.exception.BeanException;

public abstract class AbstractBeanFactory extends SingletonBeanRegistry implements BeanFactory {

    @Override
    public <T> T getBean(String name, Class<T> type) throws BeanException {
        return doGetBean(name, type, null);
    }

    @Override
    public <T> T getBean(Class<T> type) throws BeanException {
        return doGetBean(type.getName(), type, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeanException {
        return doGetBean(name, null, args);
    }

    protected <T> T doGetBean(final String name, final Class<T> type, final Object[] args) throws BeanException {
        return (T) super.getBean(name);
    }
}
