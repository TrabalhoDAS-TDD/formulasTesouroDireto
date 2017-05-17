package tesouro;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LFT {

    private static int TAXA_DIVULGADA_PRECISION = 2;
    double taxaDivulgada;


    public double calculaTaxaSelicDoDia(double taxaDivulgada) {
        setTaxaDivulgada(taxaDivulgada);
        double taxaSelic = Math.pow(((taxaDivulgada/100) + 1), (1/252)) - 1;
        return taxaSelic;
    }

    public void setTaxaDivulgada(double taxaDivulgada) {
        BigDecimal bigDecimalValue = new BigDecimal(taxaDivulgada);
        this.taxaDivulgada = bigDecimalValue.setScale(TAXA_DIVULGADA_PRECISION, RoundingMode.FLOOR).doubleValue();
    }

    public double getTaxaDivulgada() {
        return taxaDivulgada;
    }
}
