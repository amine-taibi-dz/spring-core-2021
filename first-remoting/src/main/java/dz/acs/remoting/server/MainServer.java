package dz.acs.remoting.server;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainServer {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		try {
			Thread.sleep(600_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
