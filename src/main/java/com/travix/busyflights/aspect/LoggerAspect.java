package com.travix.busyflights.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
	
	private static final Logger LOG = LoggerFactory.getLogger(LoggerAspect.class);
	
	@Before("execution(* com.travix.busyflights.service.provider.*.*(..))")
	public void beforeServiceProvide(JoinPoint jp) throws Throwable {
		LOG.info("**** Calling provider - " + jp.getTarget().getClass().getName() + " - " + jp.getSignature().getName());
	}
	
	@After("execution(* com.travix.busyflights.service.provider.*.*(..))")
	public void afterServiceProvide(JoinPoint jp) throws Throwable {
		LOG.info("**** Finished provider - " + jp.getTarget().getClass().getName() + " - " + jp.getSignature().getName());
	}
}
