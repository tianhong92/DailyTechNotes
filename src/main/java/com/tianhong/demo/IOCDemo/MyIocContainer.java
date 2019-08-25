package com.tianhong.demo.IOCDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by TianhongWang on 2019/8/7
 * 1. 所有Bean生命周期交由Ioc容器管理
 * 2. 所有被依赖的Bean通过构造方法执行注入
 * 3. 被依赖的Bean需优先创建
 */

public class MyIocContainer {

    private Map<String, Object> beans = new ConcurrentHashMap<String, Object>();

    /**
     * 根据beanId 获取一个bean
     * @param beanId beanId
     * @return 返回bean
     */

    public Object getBean(String beanId) {
        return beans.get(beanId);
    }

    /**
     * 委托Ioc容器创建一个bean
     * @param clazz 需要创建的bean的class
     * @param beanId beanId
     * @param paramBeanIds 要创建的bean的构造方法需要传入的beanIds们参数
     */

    public void setBean(Class<?> clazz, String beanId, String... paramBeanIds) {
        // 1. 组装构造方法需要的参数值
        Object[] paramValues = new Object[paramBeanIds.length];
        for (int i = 0; i < paramBeanIds.length; i++) {
            paramValues[i] = beans.get(paramBeanIds[i]);
        }

        // 2. 调用构造方法实例化bean
        Object bean = null;
        for (Constructor<?> constructor : clazz.getConstructors()) {
            try {
                bean = constructor.newInstance(paramValues);
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
        }
        if(bean == null) {
            throw new RuntimeException("找不到合适的构造方法去实例化bean");
        }
        // 3. 将实例化的bean放入beans
        beans.put(beanId, bean);
    }
}
