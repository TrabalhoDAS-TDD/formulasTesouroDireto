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
		long precoUnitario = btn.calculaPrecoUnitario();
		assertEquals(0, precoUnitario);
	}

}
