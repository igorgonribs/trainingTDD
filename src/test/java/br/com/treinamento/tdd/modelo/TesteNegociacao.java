package br.com.treinamento.tdd.modelo;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class TesteNegociacao {

	@Test(expected=IllegalArgumentException.class)
	public void precoNegativo() {
		Negociacao n1 = new Negociacao(-1, 1, LocalDateTime.now());
	}

	@Test(expected=IllegalArgumentException.class)
	public void dataNula() {
		Negociacao n1 = new Negociacao(10, 1, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void quantidadeZeroOuNegativa() {
		Negociacao n1 = new Negociacao(10, -1, LocalDateTime.now());
		Negociacao n2 = new Negociacao(10, 0, LocalDateTime.now());
	}
}
