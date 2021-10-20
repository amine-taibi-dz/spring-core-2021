package dz.acs.spring;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.MethodMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={TestConfig.class})
@TestPropertySource(/*value = { "/etc/home/test-jdbc.properties"},*/ 
		properties={"username=ataibi", "password=pass"})
@ActiveProfiles("dev")
public class TestInWork {
	
	
	@Value("${username}")
	private String username;
	
	@Value("${password}")
	private String password;
	
	
	@Test
	public void testLogin()  {
		assertEquals("ataibi", username);
		assertEquals("pass", password);
		//assertTrue(loginBean.login(username,password))
	}
	@Autowired
	private SecondBean secondBean;
	
	@DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
	@Test	
	public void testCalculateSecondBean() throws Exception {
		assertEquals("Bon résultat : ", 42,  secondBean.calculate());
	}
	
	@DirtiesContext(methodMode = MethodMode.BEFORE_METHOD)
	@Test	
	public void testResultSecondBean() throws Exception {
		assertEquals("42*42 est  à la bonne valeur",42*42,  secondBean.result());
	}
}
