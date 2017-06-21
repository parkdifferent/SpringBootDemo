package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by admin on 2017/6/2.
 */
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.applicationContext=applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return ApplicationContextHolder.applicationContext;
    }

    public static Object getBean(String beanName) {

        return getApplicationContext().getBean(beanName);

    }



    public static void cleanHolder() {

        applicationContext = null;

    }
}
