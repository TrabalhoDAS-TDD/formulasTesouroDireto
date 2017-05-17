package tesouro;

public class LFT {

    public double calculaTaxaSelicDoDia(double taxaDivulgada) {

        double taxaSelic = Math.pow(((taxaDivulgada/100) + 1), (1/252)) - 1;
        return taxaSelic;
    }
}
