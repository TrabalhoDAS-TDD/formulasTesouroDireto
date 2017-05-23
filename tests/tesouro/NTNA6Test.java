package tesouro;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

public class NTNA6Test {
	
	private static final double PRECISION6 = 0.000001;
	
	NTNA6 ntn;

	@Before
	public void setUp() throws Exception {
		ntn = new NTNA6();
	}

	@Test
	public void calculaValorNominalAtualizadoTest() {
		double valorNominal = ntn.calculaValorNominalAtualizado(2.849, 2.512, 1098.07);
		assertEquals(1245.382734872611465, valorNominal, PRECISION6);
	}
	
	@Test
	public void calculaJurosTest() throws ParseException{
		double juros = ntn.calculaJuros(2.849, 2.512, 1098.07, "22-03-2017", "29-05-2017", 10.54);
		assertEquals(24.79418785910526, juros, PRECISION6);
	}
}
