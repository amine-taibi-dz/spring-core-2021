package dz.acs.remoting.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import dz.acs.remoting.service.CabBookingService;



@Configuration
@ComponentScan(basePackages = {"dz.acs.remoting.client"})
public class AppConfigClient {
	
	 @Bean 
	 public RmiProxyFactoryBean service() {
	        RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
	        rmiProxyFactory.setServiceUrl("rmi://localhost:1099/CabBookingService");
	        rmiProxyFactory.setServiceInterface(CabBookingService.class);
	        return rmiProxyFactory;
	    }
}
