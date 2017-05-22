package tesouro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NTNA1Test {
	
	NTNA1 ntn;
	private static final double PRECISION6 = 0.000001;

	@Before
	public void setUp() throws Exception {
		ntn = new NTNA1();
	}

	@Test
	public void calculaPrecoUnitarioAmortizacaoTest() {
		double precoUnitario = ntn.calculaPrecoUnitarioAmortizacao();
		assertEquals(0, precoUnitario, PRECISION6);
	}

}