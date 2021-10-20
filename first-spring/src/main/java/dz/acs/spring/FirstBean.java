package dz.acs.spring;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class FirstBean implements InitializingBean, ApplicationContextAware {
	
	private ApplicationContext ctx;
	
	public ApplicationContext getCtx() {
		return ctx;
	}

	public void setCtx(ApplicationContext ctx) {
		this.ctx = ctx;
	}

	public FirstBean() {
		System.out.println("constructing ....");
	}
	
	@PostConstruct
	public void init() {
	 System.out.println("initing ....");	
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet called ...");
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		setCtx(applicationContext);
		
	}
}
