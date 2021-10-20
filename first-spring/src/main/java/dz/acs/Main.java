package dz.acs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dz.acs.model.AppUser;
import dz.acs.spring.service.UserService;


public class Main {


	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		UserService us = ctx.getBean(UserService.class);
		AppUser ua = us.getUserById(1);
		System.out.println(ua);
		
		ua = us.getUserById(1);		
		System.out.println(ua);
		
		ua = us.getUserById(1);		
		System.out.println(ua);
		
		ua = us.getUserById(1);
		System.out.println(ua);

		/*
		JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate",JdbcTemplate.class);
		System.out.println(jdbcTemplate);

		int resRow = jdbcTemplate.update("INSERT INTO APP_USER (NAME,USER_NAME,PASSWORD) VALUES (?,?,?)","Mohamed Mahmoud","mam","pswd");
		System.out.println(resRow);
		AppUser appUser = jdbcTemplate.queryForObject("SELECT * FROM APP_USER WHERE ID=?",new Object[] {1}, new RowMapper<AppUser>() {
			@Override
			public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new AppUser(rs.getLong("ID"),
				rs.getString("NAME"),rs.getString("USER_NAME"),rs.getString("PASSWORD"));				
			}
		});		

		System.out.println(appUser);
		 */



		//		FirstBean fb = (FirstBean)ctx.getBean("monBean1");
		//		Resource emailtemp = fb.getCtx().getResource("classpath:/test/email.template.0");
		//
		//		InputStream is = null;
		//		try {
		//			is = emailtemp.getInputStream();
		//			byte[] readAllBytes = is.readAllBytes();
		//			String content = new String(readAllBytes);
		//			System.out.println(content);
		//			
		//		} catch (Exception e) {
		//
		//		}finally {
		//			try {
		//				is.close();
		//			} catch (IOException e) {
		//				e.printStackTrace();
		//			}
		//		}
		//		System.out.println("monBean1 -> " + fb);
		//
		//		fb = ctx.getBean("fb",FirstBean.class);
		//		System.err.println("fb ->" + fb);
		//
		//		fb = ctx.getBean(FirstBean.class);
		//		System.err.println("fb ->" + fb);
		//
		//		fb = (FirstBean)ctx.getBean("lastBean");
		//		System.out.println(String.format("lastBean -> %s",  fb.toString()));

		ctx.registerShutdownHook();

	}
}
