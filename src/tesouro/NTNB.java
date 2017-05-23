package tesouro;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class NTNB {

    private static int VNA_PRECISION = 6;
    private static int FATOR_JUROS_PRECISION = 8;

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

    public double calculaFatorJuros(double i, double n, double dcp, double dct) {

        double expoenteTotal = new BigDecimal(dcp).divide(new BigDecimal(dct), new MathContext(100)).doubleValue();
        double expoenteInterno = new BigDecimal(n).divide(new BigDecimal(12), new MathContext(100)).doubleValue();
        double taxa = new BigDecimal(i).divide(new BigDecimal(100)).doubleValue() + 1;
        double base = Math.pow(taxa, expoenteInterno);

        return new BigDecimal(Math.pow(base, expoenteTotal)).setScale(FATOR_JUROS_PRECISION, RoundingMode.FLOOR).doubleValue();
    }
}
