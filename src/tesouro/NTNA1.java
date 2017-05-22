package tesouro;

public class NTNA1 {

	public double calculaPrecoUnitarioAmortizacao(double dolarA, double dolarB, double valorEmissao, double percentAmortizacao) {
		
	
		return dolarA/dolarB * this.calculaVL(valorEmissao, percentAmortizacao);
	}
	
	private double calculaVL(double valorEmissao, double percentAmortizacao){
		
		return valorEmissao*percentAmortizacao;
	}
}
