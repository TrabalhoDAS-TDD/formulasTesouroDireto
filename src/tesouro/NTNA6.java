package tesouro;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NTNA6 {

	public double calculaValorNominalAtualizado(double dolarA, double dolarB, double valorEmissao) {
		BigDecimal valorNominal = new BigDecimal(dolarA/dolarB*valorEmissao);
		return valorNominal.setScale(6, RoundingMode.FLOOR).doubleValue();
	}

	public double calculaJuros(double dolarA, double dolarB, double valorEmissao, String dtp, String dtup, double taxaAnual) throws ParseException {
		
		Date dtpData = new SimpleDateFormat("dd-MM-yyyy").parse(dtp);
		Date dtupData = new SimpleDateFormat("dd-MM-yyyy").parse(dtup);
		
		long diff = Math.abs(dtpData.getTime() - dtupData.getTime());
		long diffDays = diff / (24 * 60 * 60 * 1000);
		
		BigDecimal fatorJuros = new BigDecimal(((double)diffDays/360) * (taxaAnual/100));
		fatorJuros = fatorJuros.setScale(8, RoundingMode.CEILING);
		
		BigDecimal valorNominal = new BigDecimal(this.calculaValorNominalAtualizado(dolarA, dolarB, valorEmissao));
		BigDecimal juros = fatorJuros.multiply(valorNominal);
		
		return juros.setScale(6, RoundingMode.FLOOR).doubleValue();
		

	}

}
