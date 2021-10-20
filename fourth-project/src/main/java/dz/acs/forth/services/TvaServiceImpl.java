package dz.acs.forth.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
@Service
@PropertySource(value = {"app.properties"})
public class TvaServiceImpl implements TvaService {

	@Value("${taux.tva}") 
	private Integer tauxTva ;
	
	
	public Integer getTauxTva() {
		return tauxTva;
	}


	public void setTauxTva(Integer tauxTva) {
		this.tauxTva = tauxTva;
	}


	@Override
	public BigDecimal loadTva() {
		//Fait les claculs  et recupère la taux de TVA
		if(tauxTva !=null) {
			return BigDecimal.valueOf((tauxTva*1.0)/100.0);	
		}else {
			return BigDecimal.valueOf(0.19);	
		}
		
	}

}
