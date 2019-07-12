package br.com.treinamento.tdd.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*; 

public class CandleStickFactoryTest {

	@Test
	public void sequnciaNegociacoes() {
		LocalDateTime hoje = LocalDateTime.now();

		Negociacao n1 = new Negociacao(10, 10, hoje);
		Negociacao n2 = new Negociacao(20, 50, hoje);
		Negociacao n3 = new Negociacao(30, 40, hoje);
		Negociacao n4 = new Negociacao(15, 19, hoje);

		List<Negociacao> lista = Arrays.asList(n1, n2, n3, n4);

		CandleStickFactory fabrica = new CandleStickFactory();
		CandleStick candle = fabrica.geraCandleStickParaData(lista, hoje);
		
		assertEquals(30, candle.getMaximo(), 0.0001);
		assertEquals(10, candle.getMinimo(), 0.0001);
		assertEquals(10, candle.getAbertura(), 0.0001);
		assertEquals(15, candle.getFechamento(), 0.0001);
		assertEquals(2585, candle.getVolume(), 0.0001);
		assertEquals(hoje, candle.getData());
	}
	
	@Test
	public void geraComNegociacaoUnica() {
		LocalDateTime hoje = LocalDateTime.now();

		Negociacao n1 = new Negociacao(10, 10, hoje);
		List<Negociacao> lista = Arrays.asList(n1);

		CandleStickFactory fabrica = new CandleStickFactory();
		CandleStick candle = fabrica.geraCandleStickParaData(lista, hoje);
		
		assertEquals(10, candle.getMaximo(), 0.0001);
		assertEquals(10, candle.getMinimo(), 0.0001);
		assertEquals(10, candle.getAbertura(), 0.0001);
		assertEquals(10, candle.getFechamento(), 0.0001);
		assertEquals(100, candle.getVolume(), 0.0001);
		assertEquals(hoje, candle.getData());
	}

	@Test
	public void geraComNenhmaNegociacao() {
		LocalDateTime hoje = LocalDateTime.now();

		List<Negociacao> lista = new ArrayList<Negociacao>();

		CandleStickFactory fabrica = new CandleStickFactory();
		CandleStick candle = fabrica.geraCandleStickParaData(lista, hoje);
		
		assertEquals(0, candle.getMaximo(), 0.0001);
		assertEquals(0, candle.getMinimo(), 0.0001);
		assertEquals(0, candle.getAbertura(), 0.0001);
		assertEquals(0, candle.getFechamento(), 0.0001);
		assertEquals(0, candle.getVolume(), 0.0001);
		assertEquals(hoje, candle.getData());
	}
}
