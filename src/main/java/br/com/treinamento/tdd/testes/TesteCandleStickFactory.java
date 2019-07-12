package br.com.treinamento.tdd.testes;

import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;

import br.com.treinamento.tdd.modelo.CandleStick;
import br.com.treinamento.tdd.modelo.CandleStickFactory;
import br.com.treinamento.tdd.modelo.Negociacao;

public class TesteCandleStickFactory {

	public static void main(String[] args) {
		LocalDateTime hoje = LocalDateTime.now();
		
		Negociacao n1 = new Negociacao(10, 10, hoje);
		Negociacao n2 = new Negociacao(20, 50, hoje);
		Negociacao n3 = new Negociacao(30, 40, hoje);
		Negociacao n4 = new Negociacao(15, 19, hoje);
		
		List<Negociacao> lista = Arrays.asList(n1, n2, n3, n4);
		
		CandleStickFactory fabrica = new CandleStickFactory();
		CandleStick candle = fabrica.geraCandleStickParaData(lista, hoje);
		
		System.out.println("Abertura: " + candle.getAbertura());
		System.out.println("Fechamento: " + candle.getFechamento());
		System.out.println("Maximo: " + candle.getMaximo());
		System.out.println("Minimo: " + candle.getMinimo());
		System.out.println("Volume: " + candle.getVolume());
	}
}
