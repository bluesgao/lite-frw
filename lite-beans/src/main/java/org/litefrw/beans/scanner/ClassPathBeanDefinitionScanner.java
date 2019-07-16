package org.litefrw.beans.scanner;

import org.litefrw.beans.factory.BeanDefinitionRegistry;

/**
 * 将注解过的类，扫描添加到beanDefinitionRegistry中
 */
public class ClassPathBeanDefinitionScanner {
    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }
}
