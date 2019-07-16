package org.litefrw.core.utils;

import org.litefrw.core.exception.beans.BeanInstantiationException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class BeanUtils {
    public static <T> T newInstance(Class clazz) throws BeanInstantiationException {
        Assert.notNull(clazz, "Class must not be null");
        try {
            return (T) instantiateByConstructor(clazz.getConstructor());
        } catch (NoSuchMethodException e) {
            throw new BeanInstantiationException(clazz, "No default constructor", e);
        }
    }

    private static <T> T instantiateByConstructor(Constructor<T> ctor, Object... args) throws BeanInstantiationException {
        try {
            return ctor.newInstance(args);
        } catch (InstantiationException e) {
            throw new BeanInstantiationException(ctor.getDeclaringClass(),
                    "Is it an abstract class?", e);
        } catch (IllegalAccessException e) {
            throw new BeanInstantiationException(ctor.getDeclaringClass(),
                    "Is the constructor accessible?", e);
        } catch (InvocationTargetException e) {
            throw new BeanInstantiationException(ctor.getDeclaringClass(),
                    "Constructor threw exception", e.getTargetException());
        }
    }
}
