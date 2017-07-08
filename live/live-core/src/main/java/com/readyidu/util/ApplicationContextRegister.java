package com.readyidu.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 系统启动时，将上下文保存到 ContextUtils 中
 * @author yuzhang
 *
 */
public class ApplicationContextRegister implements ApplicationContextAware {

	private static Logger log = LoggerFactory.getLogger(ContextUtils.class);

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ContextUtils.setApplicationContext(applicationContext);
		log.debug("ApplicationContext registed");
	}
}