package br.com.treinamento.tdd.modelo;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

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
		
		Assert.assertEquals(30, candle.getMaximo(), 0.0001);
		Assert.assertEquals(10, candle.getMinimo(), 0.0001);
		Assert.assertEquals(10, candle.getAbertura(), 0.0001);
		Assert.assertEquals(15, candle.getFechamento(), 0.0001);
		Assert.assertEquals(2585, candle.getVolume(), 0.0001);
		Assert.assertEquals(hoje, candle.getData());
	}

}
