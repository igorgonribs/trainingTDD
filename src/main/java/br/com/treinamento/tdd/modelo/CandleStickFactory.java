package br.com.treinamento.tdd.modelo;

import java.util.List;
import java.time.LocalDateTime;

public class CandleStickFactory {

	public CandleStick generateCandleStickParaData(List<Negotiation> negotiations, LocalDateTime date) {
		double oppening = negotiations.isEmpty() ? 0 : negotiations.get(0).getPrice();
		double closure = negotiations.isEmpty() ? 0 : negotiations.get(negotiations.size() - 1).getPrice();
		
		double vol = 0;
		double min = negotiations.isEmpty() ? 0 : negotiations.get(0).getPrice();
		double max = negotiations.isEmpty() ? 0 : negotiations.get(0).getPrice();
		
		for(Negotiation negotiation : negotiations) {
			vol += negotiation.getVol();
			if(negotiation.getPrice() > max) {
				max = negotiation.getPrice(); 
			}
			if(negotiation.getPrice() < min) {
				min = negotiation.getPrice(); 
			}
		}
		
		return new CandleStick(oppening, closure, max, min, vol, date);
	}
}
