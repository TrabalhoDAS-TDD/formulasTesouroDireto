package tesouro;

public class LTN {

	public double calculaPrecoUnitario(double taxaIndicativa) {
			
		double denominador = Math.pow(1 + taxaIndicativa, (double)1/252);
		double precoUnitario = 1000/denominador;
		
		return precoUnitario;
	}

}
