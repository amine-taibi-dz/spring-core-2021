package dz.acs.remoting.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import dz.acs.remoting.service.CabBookingService;



@Configuration
@ComponentScan(basePackages = {"dz.acs.remoting.server","dz.acs.remoting.service"})
public class AppConfig {
	@Autowired
	@Bean
	public RmiServiceExporter exporter(CabBookingService implementation) {

		// Expose a service via RMI. Remote object URL is:
		// rmi://<HOST>:<PORT>/<SERVICE_NAME>
		// 1099 is the default port

		Class<CabBookingService> serviceInterface = CabBookingService.class;
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setServiceInterface(serviceInterface);
		exporter.setService(implementation);
		exporter.setServiceName(serviceInterface.getSimpleName());
		exporter.setRegistryPort(1099);
		return exporter;
	}
}
