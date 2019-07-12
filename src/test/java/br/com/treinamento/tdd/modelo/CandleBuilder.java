package br.com.treinamento.tdd.modelo;

import java.time.LocalDateTime;

public class CandleBuilder {

	private double oppening;
	private double closure;
	private double max;
	private double min;
	private double vol;
	private LocalDateTime date;

	public CandleBuilder withOppening(double oppening) {
		this.oppening = oppening;
		return this;
	}

	public CandleBuilder withClosure(double closure) {
		this.closure = closure;
		return this;
	}

	public CandleBuilder withMax(double max) {
		this.max = max;
		return this;
	}

	public CandleBuilder withMin(double min) {
		this.min = min;
		return this;
	}

	public CandleBuilder withVol(double vol) {
		this.vol = vol;
		return this;
	}

	public CandleBuilder withDate(LocalDateTime date) {
		this.date = date;
		return this;
	}

	public CandleStick generateCandleStick() {
		return new CandleStick(oppening, closure, max, min, vol, date);
	}
}
