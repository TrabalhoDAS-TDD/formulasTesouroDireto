package tesouro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BTNTest {
	
	BTN btn;
	private static final double PRECISION_PU = 0.01;

	@Before
	public void setUp() throws Exception {
		btn = new BTN();
	}

	@Test
	public void test() {
		double precoUnitario = btn.calculaPrecoUnitario(2456.23423423, 0.0764);
		assertEquals(187.656295, precoUnitario, PRECISION_PU);
	}

}
