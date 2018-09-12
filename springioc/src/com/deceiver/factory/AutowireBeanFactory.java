package com.deceiver.factory;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Deceiver
 * Date: 2018-09-09
 * Time: 23:41
 */

import com.deceiver.BeanDefinition;
import com.deceiver.BeanReference;
import com.deceiver.PropertyValue;

import java.lang.reflect.Field;

/**
 * 实现自动注入和递归注入(spring 的标准实现类 DefaultListableBeanFactory)
 */
public class AutowireBeanFactory extends AbstractBeanFactory{


    /**
     * 根据bean 定义创建实例， 并将实例作为key， bean定义作为value存放，并调用 addPropertyValue 方法 为给定的bean的属性进行注入
     * @param beandefinition
     * @return
     * @throws Exception
     */
    @Override
    protected Object doCreateBean(BeanDefinition beandefinition) throws Exception {
        Object bean = beandefinition.getBeanClass().newInstance();
        addPropertyValue(bean, beandefinition);
        return null;
    }

    /**
     * 给定一个bean定义和一个bean实例，为给定的bean中的属性注入实例。
     * @param bean
     * @param beandefinition
     * @throws Exception
     */
    protected void addPropertyValue(Object bean, BeanDefinition beandefinition) throws Exception{
        // 循环给定 bean 的属性集合
        for (PropertyValue pv : beandefinition.getPropertyValues().getPropertyValueList()){
            // 根据给定属性名字获取 bean中的属性对象
            Field field = bean.getClass().getDeclaredField(pv.getName());
            // 设置属性的访问权
            field.setAccessible(true);
            // 获取bean定义中的属性对象
            Object value = pv.getValue();
            // 判断这个对象是否 BeanReference对象 --> 对应ref而不是value
            if (value instanceof BeanReference){
                // 强转
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            // 反射注入bean的属性
            field.set(bean, value);
        }
    }
}
