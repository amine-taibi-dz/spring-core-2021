package dz.acs.forth.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import dz.acs.forth.services.FacturationService;
import dz.acs.forth.services.FacturationServiceImpl;
import dz.acs.forth.services.TvaService;
import dz.acs.forth.services.TvaServiceImpl;

@Configuration
@ComponentScan(basePackages = {"dz.acs.forth"})
@PropertySource(value = {"jdbc.properties"})
@EnableAspectJAutoProxy
public class AppConfig {


	@Bean	
	public DataSource dataSource(@Value("${jdbc.username}") String username,
			@Value("${jdbc.password}") String password,
			@Value("${jdbc.url}") String url,
			@Value("${jdbc.driverClassName}") String dcn) {
		DriverManagerDataSource ds = new DriverManagerDataSource(url, username, password);
		ds.setDriverClassName(dcn);
		return ds;

	}

	@Bean
	@Autowired
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);

	}

	@Bean("tva-ser-zero")
	public TvaService tvaService() {
		TvaServiceImpl ts = new TvaServiceImpl();
		ts.setTauxTva(0);
		return ts;
	}

	@Bean("fact-ser-zero")
	public FacturationService facturationServiceTauxZero() {
		return new FacturationServiceImpl(tvaService());
	}





}
