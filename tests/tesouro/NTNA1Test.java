package tesouro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NTNA1Test {
	
	NTNA1 ntn;
	private static final double PRECISION8 = 0.00000001;
	private static final double PRECISION6 = 0.000001;

	@Before
	public void setUp() throws Exception {
		ntn = new NTNA1();
	}

	@Test
	public void calculaPrecoUnitarioAmortizacaoTest() {
		double precoUnitario = ntn.calculaPrecoUnitarioAmortizacao(2.849, 2.512, 2345.58, 0.35);
		assertEquals(931.0888125, precoUnitario, PRECISION6);
		assertNotEquals(931.0888125, precoUnitario, PRECISION8);
	}

}
