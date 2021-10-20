package dz.acs.forth;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dz.acs.forth.services.FacturationNegativeException;
import dz.acs.forth.services.FacturationService;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class MyFacturationTests {
	
	@Autowired
	@Qualifier("facturationService")
	FacturationService fsRegular;
	
	@Test
	public void testFacturationRegular(){
		BigDecimal res = fsRegular.facturer(BigDecimal.valueOf(10_000L));
		assertEquals("Erreur de facturation", res.intValue(), 11_700);
	}
	
	@Test
	public void testFacturationZero(){
		BigDecimal res = fsRegular.facturer(BigDecimal.valueOf(0L));
		assertEquals("Erreur de facturation montant nulle", res.intValue(), 0);
	}
	
	@Test
	public void testFacturationNegatif(){
		//BigDecimal res = fsRegular.facturer(BigDecimal.valueOf(-100L));
		
		assertThrows(FacturationNegativeException.class, 
				()->fsRegular.facturer(BigDecimal.valueOf(-100L)));
		
		/*assertThrows(FacturationNegativeException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				fsRegular.facturer(BigDecimal.valueOf(-100L));
			}
		});*/
		//assertEquals("Erreur de facturation montant nulle", res.intValue(), 0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Autowired
//	@Qualifier("fact-ser-zero")
//	FacturationService fsZero;
	
	
	
//	@Test
//	public void testFacturationZero(){
//		BigDecimal res = fsZero.facturer(BigDecimal.valueOf(10_000L));
//		assertEquals(null, res, 10_000L);
//	}

}
