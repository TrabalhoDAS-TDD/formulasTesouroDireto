package tesouro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BTNTest {
	
	BTN btn;

	@Before
	public void setUp() throws Exception {
		btn = new BTN();
	}

	@Test
	public void test() {
		double precoUnitario = btn.calculaPrecoUnitario(200, 1.5);
		assertEquals(300, precoUnitario, 0.0001);
	}

}
