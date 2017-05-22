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
        assertNotNull(ntnb.calculaFator());
    }

}
