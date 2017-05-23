package tesouro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NTNA3Test {
	
	NTNA3 ntn;
	private static final double PRECISION6 = 0.000001;
	private static final double PRECISION8 = 0.00000001;

	@Before
	public void setUp() throws Exception {
		ntn = new NTNA3();
	}

	@Test
	public void calculaValorNominalTest() {
		double valorNominal = ntn.calculaValorNominal(2.849, 2.512);
		assertEquals(1134.156050955414013, valorNominal, PRECISION6);
		assertNotEquals(1134.156050955414013, valorNominal, PRECISION8);
	}
	
	@Test
	public void calculaJurosTest(){
		double juros = ntn.calculaJuros(2.849, 2.512, 10.54, 7);
		assertEquals(69.7316906936465, juros, PRECISION6);
		assertNotEquals(69.7316906936465, juros, PRECISION8);
	}

}
