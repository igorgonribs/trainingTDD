package br.com.treinamento.tdd.modelo;

import java.time.LocalDateTime;

import org.junit.Test;

public class TestCandleStick {

	@SuppressWarnings("unused")
	CandleStick candle;
	
	@Test(expected= IllegalArgumentException.class)
	public void maxGreaterThenMin() {
		CandleBuilder cb = new CandleBuilder();
		candle = cb.withOppening(10).withClosure(15).withMax(2).withMin(8)
				.withDate(LocalDateTime.now()).withVol(100).generateCandleStick();
	}
}
