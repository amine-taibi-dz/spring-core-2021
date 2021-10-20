package dz.acs.forth.utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class TimeAspect {
	@Before("execution(public java.math.BigDecimal dz.acs.forth.services.*.facturer(..))")
	public void timingServiceAdvice(){
		//System.out.println("timingServiceAdvice facturation");
	}

}
