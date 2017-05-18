package tesouro;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BTN {
	
	private static int PRECO_UNITARIO_PRECISION = 6;
	
	public double calculaPrecoUnitario(double PUAnterior, double TR){	
	
		double PUAtualizado = new BigDecimal(PUAnterior).setScale(PRECO_UNITARIO_PRECISION, RoundingMode.FLOOR).doubleValue() * TR;
		return new BigDecimal(PUAtualizado).setScale(PRECO_UNITARIO_PRECISION, RoundingMode.FLOOR).doubleValue();
		
	}

	public double calculaJuros(double PUAnterior, double TR, double taxaAoAno, double qtdMeses) {
		
		double precoUnitario = this.calculaPrecoUnitario(PUAnterior, TR);
		double fatorJuros = this.calculaFatorJuros(taxaAoAno, qtdMeses);
		
		return precoUnitario*fatorJuros;
	}
	
	private double calculaFatorJuros(double taxaAoAno, double qtdMeses){
		
		double fatorPercentPlusOne = new BigDecimal(taxaAoAno).divide(new BigDecimal(100)).doubleValue() + 1;
		double expoente = qtdMeses/12;
		double fatorJuros = Math.pow(fatorPercentPlusOne, expoente) - 1;
		
		return fatorJuros;
	}
}
