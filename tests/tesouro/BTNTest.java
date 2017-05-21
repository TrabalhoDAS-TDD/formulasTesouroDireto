package tesouro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BTNTest {
	
	BTN btn;
	private static final double PRECISION6 = 0.000001;
	private static final double PRECISION8 = 0.00000001;

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
		double juros = btn.calculaJuros(2456.23423423,  0.0764, 10.57, 6);
		assertEquals(9.668560031775195, juros, PRECISION6);
		
	}
	
	@Test
	public void calculaFatorJurosTest(){
		double fatorJuros = btn.calculaFatorJuros(10.57, 6);
		assertEquals(0.05152270541344, fatorJuros, PRECISION8);
	}

}
