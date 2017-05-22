package tesouro;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NTNA1 {

	public double calculaPrecoUnitarioAmortizacao(double dolarA, double dolarB, double valorEmissao, double percentAmortizacao) {
		double vl = valorEmissao*percentAmortizacao;
		return new BigDecimal(dolarA/dolarB*vl).setScale(6, RoundingMode.FLOOR).doubleValue();
	}

	public double calculaJuros(String dtp, String dtup, double taxaAnual) {
		return 0;
	}
}
