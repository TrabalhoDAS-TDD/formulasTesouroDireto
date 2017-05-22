package tesouro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NTNA3Test {
	
	NTNA3 ntn;
	private static final double PRECISION6 = 0.000001;

	@Before
	public void setUp() throws Exception {
		ntn = new NTNA3();
	}

	@Test
	public void calculaValorNominalTest() {
		double valorNominal = ntn.calculaValorNominal(2.849, 2.512);
		assertEquals(1134.156050, valorNominal, PRECISION6);
	}
	
	@Test
	public void calculaJurosTest(){
		double juros = ntn.calculaJuros();
		assertEquals(0, juros, PRECISION6);
	}

}
