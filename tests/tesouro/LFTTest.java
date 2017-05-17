package tesouro;


import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;


public class LFTTest {

    LFT lft;

    @Before
    public void setUp(){
        lft = new LFT();
    }

    @Test
    public void calculaTaxaSelicDoDiaNotNullTest(){
        BigDecimal taxaDivulgada = new BigDecimal(11.25);
        assertNotNull(lft.calculaTaxaSelicDoDia(taxaDivulgada));
    }




}
