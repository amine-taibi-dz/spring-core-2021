package dz.acs.forth.services;

import java.math.BigDecimal;

public class FacturationNegativeException extends RuntimeException {
    BigDecimal erreurMontant;
	public FacturationNegativeException(BigDecimal montant) {
		erreurMontant = montant;
	}

	private static final long serialVersionUID = 2836971915279815947L;
 
	
}
