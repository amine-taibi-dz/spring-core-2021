package dz.acs.forth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import dz.acs.forth.services.FacturationService;
import dz.acs.forth.services.FacturationServiceImpl;
import dz.acs.forth.services.TvaService;
import dz.acs.forth.services.TvaServiceImpl;

@Configuration
@PropertySource(value = {"app.properties"})
public class TestConfig {
	@Bean//("tva-ser")
	public TvaService tvaService() {
		TvaServiceImpl ts = new TvaServiceImpl();
		//ts.setTauxTva(0);
		return ts;
	}
	
	@Bean//("fact-ser")
	public FacturationService facturationServiceTauxZero() {
		return new FacturationServiceImpl(tvaService());
	}
	
	@Bean
	public FacturationService facturationService() {
		return new FacturationServiceImpl(tvaService());
	}
}
