package tesouro;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NTNA1 {

	public double calculaPrecoUnitarioAmortizacao(double dolarA, double dolarB, double valorEmissao, double percentAmortizacao) {
		double precoUnitario = dolarA/dolarB * this.calculaVL(valorEmissao, percentAmortizacao);
		return new BigDecimal(precoUnitario).setScale(6, RoundingMode.FLOOR).doubleValue();
	}
	
	private double calculaVL(double valorEmissao, double percentAmortizacao){
		return valorEmissao*percentAmortizacao;
	}
}
