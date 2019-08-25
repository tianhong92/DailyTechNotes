package com.tianhong.demo.IOCDemo;

import com.tianhong.demo.IOCDemo.BeanInit.Bean3;
import com.tianhong.demo.IOCDemo.BeanInit.TestBean;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

/**
 * Created by TianhongWang on 2019/8/7
 */
public class MyIocContainerTest {
    private MyIocContainer iocContainer = new MyIocContainer();

    @Before
    public void before() {
        iocContainer.setBean(Audi.class, "audi");
        iocContainer.setBean(Buick.class, "buick");
        iocContainer.setBean(ZhangSan.class, "zhangsan", "audi");
        iocContainer.setBean(LiSi.class, "lisi", "buick");
    }

    @Test
    public void getBean() {
        Human zhangsan = (Human)iocContainer.getBean("zhangsan");
        zhangsan.goHome();
        Human lisi = (Human) iocContainer.getBean("lisi");
        lisi.goHome();

    }

    @Test
    public void getBeanTest() throws FileNotFoundException {
        // 通过构造方法实例化bean
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        TestBean testBean = context.getBean("testBean", TestBean.class);
        testBean.sayHello();

        // 通过静态方法实例化bean
        TestBean testBean2 = context.getBean("testBean2", TestBean.class);
        System.out.println("testBean2 = " + testBean2);

        // 通过实例方法实例化bean
        Bean3 bean3 = context.getBean("bean3", Bean3.class);
        System.out.println("bean3 = " + bean3);

        // 通过别名
        TestBean beana = context.getBean("testBean_1", TestBean.class);
        System.out.println("alias = "+beana);
        TestBean beanb = context.getBean("testBean_2", TestBean.class);
        System.out.println("alias = "+beanb);
        TestBean beanc = context.getBean("testBean_3", TestBean.class);
        System.out.println("alias = "+beanc);
    }
}