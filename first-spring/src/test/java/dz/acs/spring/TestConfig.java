package dz.acs.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
	@Bean
    SecondBean secondBean() {
		return new SecondBean();
	}
}
