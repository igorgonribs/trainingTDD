package br.com.treinamento.tdd.modelo;

import java.time.LocalDateTime;

public final class CandleStick {

	private final double oppening;
	private final double closure;
	private final double max;
	private final double min;
	private final double vol;
	private final LocalDateTime date;
	
	public CandleStick(double oppening, double closure, double max, double min, double vol,
			LocalDateTime date) {
		
		if(max < min) {
			throw new IllegalArgumentException("Max must be greater the min");
		}
		this.oppening = oppening;
		this.closure = closure;
		this.max = max;
		this.min = min;
		this.vol = vol;
		this.date = date;
	}
	public double getOppening() {
		return oppening;
	}
	public double getClosure() {
		return closure;
	}
	public double getMax() {
		return max;
	}
	public double getMin() {
		return min;
	}
	public double getVol() {
		return vol;
	}
	public LocalDateTime getDate() {
		return date;
	}
	
	public boolean isHigh() {
		return this.oppening < this.closure;
	}
	
	public boolean isLow() {
		return this.oppening > this.closure;
	}
}