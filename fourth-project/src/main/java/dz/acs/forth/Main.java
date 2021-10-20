package dz.acs.forth;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dz.acs.forth.config.AppConfig;
import dz.acs.forth.model.AppUser;

public class Main {

	public static void main(String[] args) {
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
		
		int rowCount = jdbcTemplate.queryForObject("select count(*) from app_user", Integer.class);
		System.out.println(rowCount);
		
		
		AppUser appUser = jdbcTemplate.queryForObject("SELECT * FROM APP_USER WHERE ID=?",
				new Object[] {2}, new RowMapper<AppUser>() {
			@Override
			public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new AppUser(
						rs.getLong("ID"),
						rs.getString("NAME"),
						rs.getString("USER_NAME"),
						rs.getString("PASSWORD"));				
			}
		});	
		
		System.out.println(appUser);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//FacturationService fs = ctx.getBean(FacturationService.class);
		//FacturationService fs = (FacturationService)ctx.getBean("facturationServiceImpl");
		
		//FacturationService monFs = (FacturationService)ctx.getBean("monFacturationService");
		//FacturationService fs0 = (FacturationService)ctx.getBean("fact-ser-zero");
		

//		System.out.println(String.format("Montant à facturer %s avec tva réguliere!",
//				monFs.facturer(BigDecimal.valueOf(10_000L)).toPlainString() ));
//		

//		System.out.println(String.format("Montant à facturer %s avec tva réguliere!",
//					fs.facturer(BigDecimal.valueOf(10_000L)).toPlainString() ));
//		
//		
//		System.out.println( fs.sendFacturationEmail());
//		
//		System.out.println(String.format("Montant à facturer %s avec tva zero!",
//				fs0.facturer(BigDecimal.valueOf(10_000L)).toPlainString() ));
//		
		ctx.registerShutdownHook();
	}

}
