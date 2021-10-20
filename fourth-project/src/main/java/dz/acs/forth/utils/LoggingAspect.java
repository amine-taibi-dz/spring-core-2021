package dz.acs.forth.utils;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class LoggingAspect {
	
	private static final Logger log = Logger.getLogger(LoggingAspect.class.getCanonicalName());
	
	
//	@Before(value="execution(public java.math.BigDecimal dz.acs.forth.services.*.facturer(..))",argNames = "jp")
//	public void logBeforeAdvicee(JoinPoint jp){
//		log.info("xxxxxxxxxxxxxxxxxxxxx Before " + jp.toShortString());
//		
//	}
	
	
	@Before(value="execution(public * dz.acs.forth.services.*.*(..))",argNames = "jp")
	public void logBeforeAdvicee(JoinPoint jp){
		log.info("xxxxxxxxxxxxxxxxxxxxx Before " + jp.toShortString());
		
	}
	@AfterReturning(value="execution(public * dz.acs.forth.services.*.*(..))",returning =  "res")
	public void logAfterReturningAdvice(Object res){
		log.info("xxxxxxxxxxxxxxxxxxxxx After " +" res = "+res);
		//System.out.println("xxxxxxxxxxxxxxxx timingServiceAdvice facturation");
	}
	
//	@AfterReturning(value="execution(public java.math.BigDecimal dz.acs.forth.services.*.facturer(..))",returning =  "res")
//	public void logAfterReturningAdvice(Object res){
//		log.info("xxxxxxxxxxxxxxxxxxxxx After " +" res = "+res);
//		//System.out.println("xxxxxxxxxxxxxxxx timingServiceAdvice facturation");
//	}

}
