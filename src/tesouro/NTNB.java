package tesouro;

import java.math.BigDecimal;
import java.math.MathContext;

public class NTNB {

    public double calculaFator(double ipca, double ipcai, double dc, double dct) {

        double expoente = new BigDecimal(dc).divide( new BigDecimal(dct), new MathContext(100)).doubleValue();
        double base = new BigDecimal(ipca).divide(new BigDecimal(ipcai), new MathContext(100)).doubleValue();
        return Math.pow(base, expoente);

    }

    public double calculaVNA() {
        return 0;
    }
}
