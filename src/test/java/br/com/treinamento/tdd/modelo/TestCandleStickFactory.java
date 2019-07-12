package br.com.treinamento.tdd.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*; 

public class TestCandleStickFactory {

	@Test
	public void creationOfNegotiations() {
		LocalDateTime today = LocalDateTime.now();

		Negotiation n1 = new Negotiation(10, 10, today);
		Negotiation n2 = new Negotiation(20, 50, today);
		Negotiation n3 = new Negotiation(30, 40, today);
		Negotiation n4 = new Negotiation(15, 19, today);

		List<Negotiation> list = Arrays.asList(n1, n2, n3, n4);

		CandleStickFactory factory = new CandleStickFactory();
		CandleStick candle = factory.geraCandleStickParaData(list, today);
		
		assertEquals(30, candle.getMax(), 0.0001);       
		assertEquals(10, candle.getMin(), 0.0001);       
		assertEquals(10, candle.getOppening(), 0.0001);  
		assertEquals(15, candle.getClosure(), 0.0001);   
		assertEquals(2585, candle.getVol(), 0.0001);      
		assertEquals(today, candle.getDate());           
	}
	
	@Test
	public void generateCandleWithSingleNegotiation() {
		LocalDateTime today = LocalDateTime.now();

		Negotiation n1 = new Negotiation(10, 10, today);
		List<Negotiation> lista = Arrays.asList(n1);

		CandleStickFactory fabrica = new CandleStickFactory();
		CandleStick candle = fabrica.geraCandleStickParaData(lista, today);
		
		assertEquals(10, candle.getMax(), 0.0001);
		assertEquals(10, candle.getMin(), 0.0001);
		assertEquals(10, candle.getOppening(), 0.0001);
		assertEquals(10, candle.getClosure(), 0.0001);
		assertEquals(100, candle.getVol(), 0.0001);
		assertEquals(today, candle.getDate());
	}

	@Test
	public void generateCandleWithNoNegotiation() {
		LocalDateTime today = LocalDateTime.now();

		List<Negotiation> negotiationList = new ArrayList<Negotiation>();

		CandleStickFactory factory = new CandleStickFactory();
		CandleStick candle = factory.geraCandleStickParaData(negotiationList, today);
		
		assertEquals(0, candle.getMax(), 0.0001);       
		assertEquals(0, candle.getMin(), 0.0001);       
		assertEquals(0, candle.getOppening(), 0.0001);  
		assertEquals(0, candle.getClosure(), 0.0001);   
		assertEquals(0,  candle.getVol(), 0.0001);      
		assertEquals(today, candle.getDate());           
	}
}
