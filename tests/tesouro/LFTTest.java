package tesouro;


import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.*;


public class LFTTest {

    LFT lft;
    private static final double PRECISION2 = 0.01;
    private static final double PRECISION8 = 0.08;

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
        assertEquals(lft.getTaxaDivulgada(), 0.11, PRECISION2);
        assertEquals(taxaSelicDia, 0.000423141235133, PRECISION8);
    }

    @Test
    public void calculaFatorCNotNullTest() throws ParseException {
        assertNotNull(lft.calculaFatorC(getDataSelic()));
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
