package tesouro;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

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
	public void calculaPrecoUnitarioTest() throws java.text.ParseException {
		double precoUnitario = btn.calculaPrecoUnitario(getTr(), 2456.23);
		assertEquals(11.2676603774, precoUnitario, PRECISION6);
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
	
	public HashMap<Date, Double> getTr() throws java.text.ParseException{
		HashMap<Date, Double> tr = new HashMap<>();
		Date data1 = new SimpleDateFormat("dd-MM-yyyy").parse("16-02-2017");
        Date data2 = new SimpleDateFormat("dd-MM-yyyy").parse("17-03-2017");
        
        tr.put(data1, 0.0302);
        tr.put(data2, 0.1519);
        
        return tr;
	}
}
