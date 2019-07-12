package br.com.treinamento.tdd.modelo;

import java.time.LocalDateTime;

public final class Negociacao {

	private final double preco;
	private final int quantidade;
	private final LocalDateTime data;
	
	public double getPreco() {
		return preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public LocalDateTime getData() {
		return data;
	}
	
	public Negociacao(double preco, int quantidade, LocalDateTime data) {
		if(preco < 0) {
			throw new IllegalArgumentException("Preço não pode ser negativo");
		}
		if(quantidade <= 0) {
			throw new IllegalArgumentException("Quantidade não pode ser negativa ou zero");
		}
		if(data == null) {
			throw new IllegalArgumentException("Data não pode ser nula");
		}
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}
	
	public double getVolume() {
		return this.preco*this.quantidade;
	}
	
}
