package tesouro;


import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


import static org.junit.Assert.*;


public class LFTTest {

    LFT lft;
    private static final double PRECISION2 = 0.01;
    private static final double PRECISION8 = 0.00000001;
    private static final double PRECISION10 = 0.0000000001;
    private static final double PRECISION6 = 0.000001;
    private static final double VNB = 1.000231232;


    @Before
    public void setUp(){
        lft = new LFT();
    }

    @Test
    public void calculaTaxaSelicDoDiaNotNullTest(){
        double taxaDivulgada = 11.25;
        assertNotNull(lft.calculaTaxaSelicDoDia(taxaDivulgada));
    }

    @Test
    public void calculaTaxaSelicDoDiaArredondamentoTest(){
        double taxaDivulgada = 0.112521200021523511;
        double taxaSelicDia = lft.calculaTaxaSelicDoDia(taxaDivulgada);
        assertEquals(lft.getTaxaDivulgada(), 0.11123123123, PRECISION2);
        assertNotEquals(lft.getTaxaDivulgada(), 0.11123123123, PRECISION6);
        assertEquals(taxaSelicDia, 0.0000043698749274, PRECISION8);
        assertNotEquals(taxaSelicDia, 0.0000043698749274, PRECISION10);
    }

    @Test
    public void calculaFatorCNotNullTest() throws ParseException {
        assertNotNull(lft.calculaFatorC(getDataSelic()));
    }

    @Test
    public void calculaFatorCArredondamentoTest() throws ParseException {
        double fatorC = lft.calculaFatorC(getDataSelic());
        assertNotEquals(fatorC, 1.000882699898792, PRECISION10);
        assertEquals(fatorC, 1.000882699898792, PRECISION8);
    }

    @Test
    public void calculaVNANotNullTest() throws ParseException {
        HashMap fatorCDataBase = getDataSelic();
        assertNotNull(lft.calculaVNA(VNB, fatorCDataBase));
    }

    @Test
    public void calculaVNAArredondamentoTest() throws ParseException {
        HashMap fatorCDataBase = getDataSelic();
        double VNA = lft.calculaVNA(VNB, fatorCDataBase);
        assertNotEquals(VNA, 1.0011141261061742, PRECISION10);
        assertEquals(VNA, 1.0011141261061742, PRECISION6);
    }

    public void calculaVnaANotNullTest() {
        assertNotNull(lft.calculaVNAA());
    }

    public HashMap<Date, Double> getDataSelic() throws ParseException {
        HashMap<Date, Double> dataSelics = new HashMap<>();
        Date data1 = new SimpleDateFormat("dd-MM-yyyy").parse("16-05-2017");
        Date data2 = new SimpleDateFormat("dd-MM-yyyy").parse("17-05-2017");

        dataSelics.put(data1, 11.212313121);
        dataSelics.put(data2, 12.312312313);
        return  dataSelics;
    }


}
