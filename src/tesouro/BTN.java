package tesouro;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class BTN {
	
	
	public double calculaPrecoUnitario(HashMap<Date, Double> tr, double precoUnitario){
		
		for(Date data : tr.keySet()){
			precoUnitario *= tr.get(data);
		}
		return new BigDecimal(precoUnitario).setScale(6, RoundingMode.DOWN).doubleValue();	
	}

	public double calculaJuros(HashMap<Date, Double> tr, double precoUnitario, double taxaAoAno, int qtdMeses) throws ParseException {
		 
		//Pedaço de código para quando programa estiver rodando
		
		/*
		Scanner leia = new Scanner(System.in);
		
		String dataEntrada;
		Double taxaReferencia;
		
		for(int i = 0; i < qtdMeses; i++){
			dataEntrada = leia.nextLine();
			taxaReferencia = leia.nextDouble();
			tr.put(new SimpleDateFormat("dd-MM-yyyy").parse(dataEntrada), taxaReferencia);
		}
		*/
		
		
		
		for(Date data : tr.keySet()){
			precoUnitario *= new BigDecimal(tr.get(data)).setScale(6, RoundingMode.FLOOR).doubleValue();
		}
		
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
