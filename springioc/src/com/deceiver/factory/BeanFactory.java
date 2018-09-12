package com.deceiver.factory;

import com.deceiver.BeanDefinition;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Deceiver
 * Date: 2018-09-09
 * Time: 16:29
 */
public interface BeanFactory {

    /**
     * 根据bean的名称从容器中获取bean对象
     *
     * @param name bean 名称
     * @return bean实例
     * @throws Exception 异常
     */
    Object getBean(String name) throws Exception;

    /**
     * 将bean注册到容器中
     *
     * @param name bean 名称
     * @param bean bean 实例
     * @throws Exception 异常
     */
    void registerBeanDefinition(String name, BeanDefinition bean) throws Exception;
}
