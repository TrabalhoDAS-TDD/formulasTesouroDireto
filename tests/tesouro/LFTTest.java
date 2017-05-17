package tesouro;


import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

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




}
