package com.readyidu.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

/**
 * 获取上下文， 为非webbean 装载 service map对象
 *
 * @author yuzhang
 */
public class ContextUtils {
    private static ApplicationContext applicationContext;

    private static Logger log = LoggerFactory.getLogger(ContextUtils.class);

    public static void setApplicationContext(
            ApplicationContext applicationContext) {
        synchronized (ContextUtils.class) {
            log.debug("setApplicationContext, notifyAll");
            ContextUtils.applicationContext = applicationContext;
            ContextUtils.class.notifyAll();
        }
    }

    public static ApplicationContext getApplicationContext() {
        synchronized (ContextUtils.class) {
            while (applicationContext == null) {
                try {
                    log.debug("getApplicationContext, wait...");
                    ContextUtils.class.wait(60000);
                    if (applicationContext == null) {
                        log.warn(
                                "Have been waiting for ApplicationContext to be set for 1 minute",
                                new Exception());
                    }
                } catch (InterruptedException ex) {
                    log.debug("getApplicationContext, wait interrupted");
                }
            }
            return applicationContext;
        }
    }

//    public static Object getBean(String name) {
//        return getApplicationContext().getBean(name);
//    }
}
