package tesouro;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NTNBTest {

    private  NTNB ntnb;

    @Before
    public void setup(){
        ntnb = new NTNB();
    }

    @Test
    public void calculaFatorNTNBNotNullTest(){
        double ipca = 0.38;
        double ipcai = 0.33;
        double dc = 8;
        double dct = 16;
        assertNotNull(ntnb.calculaFator(ipca, ipcai, dc, dct));
    }

}
