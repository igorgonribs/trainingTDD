package br.com.treinamento.tdd.modelo;

import java.time.LocalDateTime;

public final class Negotiation {

	private final double price;
	private final int quantity;
	private final LocalDateTime date;
	
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public LocalDateTime getDate() {
		return date;
	}
	
	public Negotiation(double price, int quantity, LocalDateTime date) {
		if(price < 0) {
			throw new IllegalArgumentException("Price cannot be negative");
		}
		if(quantity <= 0) {
			throw new IllegalArgumentException("Quantity cannot be negative or zero");
		}
		if(date == null) {
			throw new IllegalArgumentException("Date cannot be null");
		}
		this.price = price;
		this.quantity = quantity;
		this.date = date;
	}
	
	public double getVol() {
		return this.price*this.quantity;
	}
	
}
