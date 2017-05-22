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
		double valorNominal = ntn.calculaValorNominal();
		assertEquals(0, valorNominal, PRECISION6);
	}

}
