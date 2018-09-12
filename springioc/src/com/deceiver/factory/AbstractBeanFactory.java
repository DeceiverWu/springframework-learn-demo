package com.deceiver.factory;

import com.deceiver.BeanDefinition;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Deceiver
 * Date: 2018-09-09
 * Time: 23:19
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private ConcurrentHashMap<String, BeanDefinition> map = new ConcurrentHashMap<String, BeanDefinition>();


    /**
     * 根据bean的名称获取bean， 如果没有，则抛出异常 如果有， 则从bean定义对象获取bean实例
     * @param name bean 名称
     * @return
     * @throws Exception
     */
    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = map.get(name);
        if (beanDefinition == null){
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null){
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        map.put(name, beanDefinition);
    }

    /**
     * 减少一个bean
     */
    abstract Object doCreateBean(BeanDefinition beandefinition) throws Exception;
}
