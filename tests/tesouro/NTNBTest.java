package tesouro;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NTNBTest {

    private static final double PRECISION10 = 0.0000000001;
    private static final double PRECISION8 = 0.00000001;
    private static final double PRECISION6 = 0.000001;

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

    @Test
    public void calculaVNANotNullTest(){

        assertNotNull(getCalculoVNA());

    }

    @Test
    public void calculaVNAArredondamentoTest(){

        assertNotEquals(getCalculoVNA(), 1.2359613677234655, PRECISION10);
        assertEquals(getCalculoVNA(), 1.2359613677234655, PRECISION6);

    }

    @Test
    public void calculaFatorJurosNotNull(){

        assertNotNull(getFatorJuros());

    }

    @Test
    public void calculaFatorJurosArredondamentoTest(){

        assertNotEquals(getFatorJuros(), 1.0003611538246018, PRECISION10);
        assertEquals(getFatorJuros(), 1.0003611538246018, PRECISION8);

    }

    @Test
    public void calculaJurosNotNullTest(){

        assertNotNull(getJuros());

    }

    @Test
    public void calculaJurosArredondamentoTest(){

        assertNotEquals(getJuros(), 0.0003612619565000323, PRECISION10);
        assertEquals(getJuros(), 0.0003612619565000323, PRECISION8);

    }

    public double getJuros(){

        double vna = 1.00031;
        return ntnb.calculaJuros(vna, getFatorJuros());
    }

    public double getFatorJuros(){

        double i = 0.34;
        double n = 2;
        double dcp = 30;
        double dct = 47;

        return  ntnb.calculaFatorJuros(i, n, dcp, dct);

    }


    public double getCalculoVNA(){
        double ipca = 0.38;
        double ipcai = 0.33;
        double dc = 8;
        double dct = 16;
        double VN = 1.000231232;

        return ntnb.calculaVNA(ipca, ipcai, dc, dct, VN);
    }

}
