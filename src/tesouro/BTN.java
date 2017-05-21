package tesouro;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BTN {
	
	
	public double calculaPrecoUnitario(double PUAnterior, double TR){	
	
		PUAnterior = new BigDecimal(PUAnterior).setScale(6, RoundingMode.FLOOR).doubleValue();
		double PUAtualizado = PUAnterior * TR;
		return new BigDecimal(PUAtualizado).setScale(6, RoundingMode.FLOOR).doubleValue();
		
	}

	public double calculaJuros(double PUAnterior, double TR, double taxaAoAno, int qtdMeses) {
		
		double precoUnitario = this.calculaPrecoUnitario(PUAnterior, TR);
		double fatorJuros = this.calculaFatorJuros(taxaAoAno, qtdMeses);
		
		return precoUnitario*fatorJuros;
	}
	
	public double calculaFatorJuros(double taxaAoAno, int qtdMeses){
		
		double fatorPercentPlusOne = new BigDecimal(taxaAoAno).divide(new BigDecimal(100)).doubleValue() + 1;
		double expoente = (double)qtdMeses/12;
		BigDecimal fatorJuros = new BigDecimal(Math.pow(fatorPercentPlusOne, expoente) - 1);
		
		return fatorJuros.setScale(8, RoundingMode.CEILING).doubleValue();
	}
}
