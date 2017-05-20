package tesouro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BTNTest {
	
	BTN btn;
	private static final double PRECISION6 = 0.000001;

	@Before
	public void setUp() throws Exception {
		btn = new BTN();
	}

	@Test
	public void calculaPrecoUnitarioTest() {
		double precoUnitario = btn.calculaPrecoUnitario(2456.23423423, 0.0764);
		assertEquals(187.656295495172, precoUnitario, PRECISION6);
	}
	
	@Test
	public void calculaJurosTest(){
		double juros = btn.calculaJuros(2456.23423423,  0.0764, 10.57, 5);
		assertEquals(0.042754835219696, juros, PRECISION6);
		
	}

}
