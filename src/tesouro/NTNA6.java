package tesouro;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NTNA6 {

	public double calculaValorNominalAtualizado(double dolarA, double dolarB, double valorEmissao) {
		BigDecimal valorNominal = new BigDecimal(dolarA/dolarB*valorEmissao);
		return valorNominal.setScale(6, RoundingMode.FLOOR).doubleValue();
	}

}
