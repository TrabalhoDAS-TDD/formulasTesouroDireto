package tesouro;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;


public class BTNTest {
	
	BTN btn;
	private static final double PRECISION2 = 0.01;
	private static final double PRECISION6 = 0.000001;
	private static final double PRECISION8 = 0.00000001;

	@Before
	public void setUp() throws Exception {
		btn = new BTN();
	}

	@Test
	public void calculaPrecoUnitarioTest() throws java.text.ParseException {
		double precoUnitario = btn.calculaPrecoUnitario(getTrs(), 2456.23);
		assertEquals(5820.167027437864, precoUnitario, PRECISION6);
	}
	
	@Test
	public void calculaJurosTest() throws ParseException{
		double juros = btn.calculaJuros(getTrs(),  2456.23, 10.57, 6);
		assertEquals(299.8707778836832, juros, PRECISION6);
		
	}
	
	@Test
	public void calculaFatorJurosTest(){
		double fatorJuros = btn.calculaFatorJuros(10.57, 6);
		assertEquals(0.05152270541344, fatorJuros, PRECISION8);
	}
	
	@Test
	public void calculaPrincipalTest() throws ParseException{
		double resultadoPrincipal = btn.calculaPrincipal(getTrs(), 2456.23, 5);
		assertEquals(29100.84, resultadoPrincipal, PRECISION2);
	}
	
	public HashMap<Date, Double> getTrs() throws java.text.ParseException{
		HashMap<Date, Double> tr = new HashMap<>();
		
		
		//Teste para quantidade de 6 meses
		tr.put(new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2016"), 1.1320);
		tr.put(new SimpleDateFormat("dd-MM-yyyy").parse("01-02-2016"), 1.0957);
		tr.put(new SimpleDateFormat("dd-MM-yyyy").parse("01-03-2016"), 1.2168);
		tr.put(new SimpleDateFormat("dd-MM-yyyy").parse("01-04-2016"), 1.1304);
		tr.put(new SimpleDateFormat("dd-MM-yyyy").parse("01-05-2016"), 1.1533);
		tr.put(new SimpleDateFormat("dd-MM-yyyy").parse("01-06-2016"), 1.2043);
        
        return tr;
	}
}
