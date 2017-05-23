package tesouro;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class NTNB {

    private static int VNA_PRECISION = 6;

    public double calculaFator(double ipca, double ipcai, double dc, double dct) {

        double expoente = new BigDecimal(dc).divide( new BigDecimal(dct), new MathContext(100)).doubleValue();
        double base = new BigDecimal(ipca).divide(new BigDecimal(ipcai), new MathContext(100)).doubleValue();
        return Math.pow(base, expoente);

    }

    public double calculaVNA(double ipca, double ipcai, double dc, double dct, double VN) {

        double fator = calculaFator(ipca, ipcai, dc, dct);
        double parametroIpca = new BigDecimal(ipca).divide(new BigDecimal(ipcai), new MathContext(100)).doubleValue();

        return new BigDecimal(fator * parametroIpca * VN).setScale(VNA_PRECISION, RoundingMode.FLOOR).doubleValue();
    }

    public double calculaFatorJuros() {
        return 0;
    }
}
