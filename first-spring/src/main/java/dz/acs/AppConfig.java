package dz.acs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import dz.acs.spring.FirstBean;
@EnableCaching
@Configuration
@PropertySource(value = {"jdbc.properties"})
@ComponentScan(basePackages = "dz.acs")
public class AppConfig {

	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.username}")
	private String username;
	 
	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean factory = new EhCacheManagerFactoryBean();
		factory.setConfigLocation(new ClassPathResource("ehcache.xml"));
		factory.setShared(true);
		return factory;
	}
	
	@Bean	
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	 
	private DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		
		return dataSource;
	}

	@Bean
	public FirstBean monBean1() {
		return new FirstBean();
	}
	@Bean
	@Primary
	public FirstBean fb() {
		return new FirstBean();
	}
	
	@Bean
	public FirstBean lastBean() {
		return new FirstBean();
	}
}
