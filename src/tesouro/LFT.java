package tesouro;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class LFT {

    private static int TAXA_DIVULGADA_PRECISION = 2;
    private static int TAXA_SELIC_DO_DIA_PRECISION = 8;
    double taxaDivulgada;


    public double calculaTaxaSelicDoDia(double taxaDivulgada) {
        setTaxaDivulgada(taxaDivulgada);
        double taxaDivulgadaPerCentPlus = (getTaxaDivulgada()/100) + 1;
        double expoente = new BigDecimal(1).divide(new BigDecimal(252), new MathContext(100)).doubleValue();
        BigDecimal taxaSelic = new BigDecimal(Math.pow(taxaDivulgadaPerCentPlus, expoente) - 1);
        return taxaSelic.setScale(TAXA_SELIC_DO_DIA_PRECISION, BigDecimal.ROUND_FLOOR).doubleValue();
    }

    public void setTaxaDivulgada(double taxaDivulgada) {
        BigDecimal bigDecimalValue = new BigDecimal(taxaDivulgada);
        this.taxaDivulgada = bigDecimalValue.setScale(TAXA_DIVULGADA_PRECISION, RoundingMode.FLOOR).doubleValue();
    }

    public double getTaxaDivulgada() {
        return taxaDivulgada;
    }
}
