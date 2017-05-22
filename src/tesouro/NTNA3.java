package tesouro;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NTNA3 {

	public double calculaValorNominal(double dolarA, double dolarB) {	
		double valorNominal = dolarA/dolarB*1000;
		return new BigDecimal(valorNominal).setScale(6, RoundingMode.FLOOR).doubleValue();
		
	}

	public double calculaJuros(double dolarA, double dolarB, double taxaAnual, int meses) {
		
		return 0;
	}

}
