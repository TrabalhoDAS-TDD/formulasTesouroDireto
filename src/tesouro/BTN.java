package tesouro;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BTN {
	
	private static int PRECO_UNITARIO_PRECISION = 6;
	
	public double calculaPrecoUnitario(double PUAnterior, double TR){	
	
		double PUAtualizado = new BigDecimal(PUAnterior).setScale(PRECO_UNITARIO_PRECISION, RoundingMode.FLOOR).doubleValue() * TR;
		return new BigDecimal(PUAtualizado).setScale(PRECO_UNITARIO_PRECISION, RoundingMode.FLOOR).doubleValue();
		
	}

	public double calculaJuros() {
		// TODO Auto-generated method stub
		return 0;
	}
}
