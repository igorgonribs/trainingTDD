package br.com.treinamento.tdd.modelo;

import java.time.LocalDateTime;

import org.junit.Test;

public class TestNegociacao {

	@SuppressWarnings("unused")
	private Negotiation n1;

	@Test(expected = IllegalArgumentException.class)
	public void precoNegativo() {
		n1 = new Negotiation(-1, 1, LocalDateTime.now());
	}

	@Test(expected = IllegalArgumentException.class)
	public void dateNull() {
		n1 = new Negotiation(10, 1, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void quantityZeroOrNegative() {
		n1 = new Negotiation(10, -1, LocalDateTime.now());
		n1 = new Negotiation(10, 0, LocalDateTime.now());
	}
}
