package com.easy.cloud.core.cache.redis.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * <p>
 * redis切面类
 * </p>
 *
 * @author daiqi 创建时间 2018年4月12日 下午1:51:49
 */
@Aspect
@Order(value = 50)
@Component
public class EcRedisAspect {

	@Pointcut("@com.easy.cloud.core.cache.redis.annotation.EcRedisAnnotation)")
	public void redisAspect() {

	}

	@Around(value = "redisAspect()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		return null;
	}

	@AfterThrowing(value = "redisAspect()", throwing = "ex")
	public void afterThrowing(Throwable ex) {
		throw new RuntimeException(ex);
	}
}
