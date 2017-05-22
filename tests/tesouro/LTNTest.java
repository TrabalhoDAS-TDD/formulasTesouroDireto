package tesouro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LTNTest {
	
	private static double PRECISION6 = 0.000001;

	@Before
	public void setUp() throws Exception {
		LTN ltn = new LTN();
	}

	@Test
	public void calculaPrecoUnitarioTest() {
		double precoUnitario = LTN.calculaPrecoUnitario();
		assertEquals(0, precoUnitario, PRECISION6);
	}

}
