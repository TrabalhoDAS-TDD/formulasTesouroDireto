package tesouro;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;


public class LFT {

    private static int TAXA_DIVULGADA_PRECISION = 2;
    private static int TSELIC_TC_PRECISION = 8;
    private static int VNA_VNB_PRECISION = 6;
    private double taxaDivulgada;
    private double VNB;



    public double calculaTaxaSelicDoDia(double taxaDivulgada) {
        setTaxaDivulgada(taxaDivulgada);
        double taxaDivulgadaPerCentPlus = (getTaxaDivulgada()/100) + 1;
        double expoente = new BigDecimal(1).divide(new BigDecimal(252), new MathContext(100)).doubleValue();
        BigDecimal taxaSelic = new BigDecimal(Math.pow(taxaDivulgadaPerCentPlus, expoente) - 1);
        return taxaSelic.setScale(TSELIC_TC_PRECISION, RoundingMode.FLOOR).doubleValue();

    }

    public void setTaxaDivulgada(double taxaDivulgada) {
        BigDecimal bigDecimalValue = new BigDecimal(taxaDivulgada);
        this.taxaDivulgada = bigDecimalValue.setScale(TAXA_DIVULGADA_PRECISION, RoundingMode.FLOOR).doubleValue();
    }

    public double getTaxaDivulgada() {
        return taxaDivulgada;
    }

    public double calculaFatorC(HashMap<Date, Double> dataSelic) {
        double fatorC = 1;
        for (Date data : dataSelic.keySet()){;
            fatorC *= (1 + calculaTaxaSelicDoDia(dataSelic.get(data)));
        }
        BigDecimal bigDecimalValue = new BigDecimal(fatorC);
        return bigDecimalValue.setScale(TSELIC_TC_PRECISION, RoundingMode.FLOOR).doubleValue();
    }

    public double calculaVNA(double VNB, HashMap fatorCDataBase) {

        double fatorC = calculaFatorC(fatorCDataBase);
        BigDecimal bigDecimalVNB = new BigDecimal(VNB);
        setVNB(bigDecimalVNB.setScale(VNA_VNB_PRECISION, RoundingMode.FLOOR).doubleValue());
        double VNA = VNB * fatorC;
        BigDecimal bigDecimalValueVNA = new BigDecimal(VNA);
        return bigDecimalValueVNA.setScale(VNA_VNB_PRECISION, RoundingMode.FLOOR).doubleValue();

    }



    public void setVNB(double VNB) {
        this.VNB = VNB;
    }

    public double calculaVNAA(HashMap<Date, Double> dataSelic, double VE, double DU, double DUt, double tac, double p, double n) {

        double fatorC = calculaFatorC(dataSelic);
        double taxaFatorUm = 1 + new BigDecimal(tac).divide(new BigDecimal(100), new MathContext(100)).doubleValue();
        double expoente = new BigDecimal(DU).divide(new BigDecimal(DUt), new MathContext(100)).doubleValue();
        double taxaFatorUmDia = Math.pow(taxaFatorUm, expoente);
        double taxaSubtratora = Math.pow((1+tac), expoente);
        double CxVE = new BigDecimal(fatorC * VE).setScale(TSELIC_TC_PRECISION, RoundingMode.FLOOR).doubleValue();
        double fatorUm = CxVE * taxaFatorUmDia;
        double multiplicativo = new BigDecimal(1).divide(new BigDecimal(p-n), new MathContext(100)).doubleValue();
        double fatorDois = (fatorC * VE * taxaSubtratora) * multiplicativo;
        double vnaA = fatorUm - fatorDois;
        return vnaA;
    }
}
