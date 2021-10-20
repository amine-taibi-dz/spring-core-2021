package dz.acs.forth.services;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service("facturationServiceImpl")
public class FacturationServiceImpl implements FacturationService,InitializingBean, ApplicationContextAware{
	private TvaService tvaService;
	private ApplicationContext applicationContext;
	
	//
	@Override
	public BigDecimal facturer(BigDecimal montant) {
		if(montant.signum() ==-1) {
			throw new FacturationNegativeException(montant);
		}
		return montant.multiply(BigDecimal.ONE.add(tvaService.loadTva()));
	}
	
	
	@Autowired	
	public FacturationServiceImpl(@Qualifier("tvaServiceImpl")TvaService tvaService) {
		this.tvaService = tvaService;
		
	}
	
	public FacturationServiceImpl() {
		
	}
	public TvaService getTvaService() {
		return tvaService;
	}

	public void setTvaService(TvaService tvaService) {
		this.tvaService = tvaService;
	}
	
	@PostConstruct
	public void callMyPostConstruct() {
		System.out.println("call My PostConstruct in FacturationServiceImpl");
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("call My afterPropertiesSet in FacturationServiceImpl");		
		
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext; 
		
	}


	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}


	@Override
	public String sendFacturationEmail()  {
		String content ="empty";
		Resource emailTemplate = applicationContext.getResource("classpath:email.template.txt");
		InputStream inputStream = null;
		try {
			inputStream = emailTemplate.getInputStream();
			byte[] bytes = inputStream.readAllBytes();
			content = new String(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(inputStream !=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}	
			}			
		}
		return content;
	}
	
	
	

	

}
