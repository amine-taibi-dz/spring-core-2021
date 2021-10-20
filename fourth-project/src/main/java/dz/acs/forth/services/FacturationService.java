package dz.acs.forth.services;

import java.math.BigDecimal;

public interface FacturationService {
	
	BigDecimal facturer(BigDecimal montant);
	String sendFacturationEmail();

}
