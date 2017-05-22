package tesouro;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;

import java.util.Date;
import java.util.HashMap;

public class BTN {
	
	
	public double calculaPrecoUnitario(HashMap<Date, Double> tr, double precoUnitario){
		
		for(Date data : tr.keySet()){
			precoUnitario *= tr.get(data);
		}
		return new BigDecimal(precoUnitario).setScale(6, RoundingMode.DOWN).doubleValue();	
	}

	public double calculaJuros(HashMap<Date, Double> tr, double precoUnitario, double taxaAoAno, int qtdMeses) throws ParseException {
		 
		precoUnitario = this.calculaPrecoUnitario(tr, precoUnitario);
		double fatorJuros = this.calculaFatorJuros(taxaAoAno, qtdMeses);
		return new BigDecimal(precoUnitario*fatorJuros).setScale(6, RoundingMode.DOWN).doubleValue();
	}
	
	public double calculaFatorJuros(double taxaAoAno, int qtdMeses){
		
		double fatorPercentPlusOne = new BigDecimal(taxaAoAno).divide(new BigDecimal(100)).doubleValue() + 1;
		double expoente = (double)qtdMeses/12;
		BigDecimal fatorJuros = new BigDecimal(Math.pow(fatorPercentPlusOne, expoente) - 1);
		
		return fatorJuros.setScale(8, RoundingMode.CEILING).doubleValue();
	}

	public double calculaPrincipal() {
		
		return 0;
	}
}
