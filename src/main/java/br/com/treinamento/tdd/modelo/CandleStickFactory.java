package br.com.treinamento.tdd.modelo;

import java.util.List;
import java.time.LocalDateTime;

public class CandleStickFactory {

	public CandleStick geraCandleStickParaData(List<Negociacao> negociacoes, LocalDateTime data) {
		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(negociacoes.size() - 1).getPreco();
		
		double volume = 0;
		double minimo = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double maximo = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		
		for(Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();
			if(negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco(); 
			}
			if(negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco(); 
			}
		}
		
		return new CandleStick(abertura, fechamento, maximo, minimo, volume, data);
	}
}
