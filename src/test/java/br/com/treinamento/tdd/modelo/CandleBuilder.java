package br.com.treinamento.tdd.modelo;

import java.time.LocalDateTime;

public class CandleBuilder {

	private double abertura;
	private double fechamento;
	private double maximo;
	private double minimo;
	private double volume;
	private LocalDateTime data;
	
	public CandleBuilder comAbertura(double abertura) {
		this.abertura = abertura;
		return this;
	}
	public CandleBuilder comFechamento(double fechamento) {
		this.fechamento = fechamento;
		return this;
	}
	public CandleBuilder comMaximo(double maximo) {
		this.maximo = maximo;
		return this;
	}
	public CandleBuilder comMinimmo(double minimo) {
		this.minimo = minimo;
		return this;
	}
	public CandleBuilder comVolume(double volume) {
		this.volume = volume;
		return this;
	}
	public CandleBuilder comData(LocalDateTime data) {
		this.data = data;
		return this;
	}
	public CandleStick geraCandleStick() {
		return new CandleStick(abertura, fechamento, maximo, minimo, volume, data);
	}
}
