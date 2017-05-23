package tesouro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LTNTest {
	
	LTN ltn;
	private static double PRECISION6 = 0.000001;
	private static double PRECISION8 = 0.00000001;

	@Before
	public void setUp() throws Exception{
		ltn = new LTN();
	}
	
	
	@Test
	public void calculaPrecoUnitarioTest() {
		double precoUnitario = ltn.calculaPrecoUnitario(9.7351);
		assertEquals(990.6254920747908, precoUnitario, PRECISION6);
		assertNotEquals(990.6254920747908, precoUnitario, PRECISION8);
	}

}
