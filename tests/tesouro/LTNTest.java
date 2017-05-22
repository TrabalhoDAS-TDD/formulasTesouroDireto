package tesouro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LTNTest {
	
	LTN ltn;
	private static double PRECISION6 = 0.000001;

	@Before
	public void setUp() throws Exception{
		ltn = new LTN();
	}
	
	
	@Test
	public void calculaPrecoUnitarioTest() {
		double precoUnitario = ltn.calculaPrecoUnitario();
		assertEquals(0, precoUnitario, PRECISION6);
	}

}
