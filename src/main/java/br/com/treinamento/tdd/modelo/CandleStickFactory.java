package br.com.treinamento.tdd.modelo;

import java.util.List;
import java.time.LocalDateTime;

public class CandleStickFactory {

	public CandleStick geraCandleStickParaData(List<Negociacao> negociacoes, LocalDateTime data) {
		double abertura = negociacoes.get(0).getPreco();
		double fechamento = negociacoes.get(negociacoes.size() - 1).getPreco();
		
		double volume = 0;
		
		for(Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();
		}
		
		return new CandleStick(abertura, fechamento, maximo, minimo, volume, data);
	}
}
