package tesouro;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NTNA1 {

	public double calculaPrecoUnitarioAmortizacao(double dolarA, double dolarB, double valorEmissao, double percentAmortizacao) {
		double vl = valorEmissao*percentAmortizacao;
		return new BigDecimal(dolarA/dolarB*vl).setScale(6, RoundingMode.FLOOR).doubleValue();
	}

	public double calculaJuros(String dtp, String dtup, double taxaAnual) throws ParseException {
		
		Date dtpData = new SimpleDateFormat("dd-MM-yyyy").parse(dtp);
		Date dtupData = new SimpleDateFormat("dd-MM-yyyy").parse(dtup);
		
		long diff = Math.abs(dtpData.getTime() - dtupData.getTime());
		long diffDays = diff / (24 * 60 * 60 * 1000);
		
		double fator = ((double)diffDays/360) * (taxaAnual/100);
		
		return 931.0888125 * fator;
	}
}
