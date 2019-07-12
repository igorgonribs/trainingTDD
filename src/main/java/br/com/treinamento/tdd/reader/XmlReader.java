package br.com.treinamento.tdd.reader;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.time.LocalDateTimeConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.treinamento.tdd.modelo.CandleStick;
import br.com.treinamento.tdd.modelo.CandleStickFactory;
import br.com.treinamento.tdd.modelo.Negotiation;

public class XmlReader {

	public static void main(String[] args) {
		Negotiation negotiation = new Negotiation(10, 10, LocalDateTime.now());

		XStream stream = new XStream(new DomDriver());
		stream.alias("Negotiation", Negotiation.class);
		stream.alias("CandleStick", CandleStick.class);
		stream.registerLocalConverter(Negotiation.class, "date", new LocalDateTimeConverter());
		String xml1 = stream.toXML(negotiation);
		
		System.out.println("Negotiation as a XML: ");
		System.out.println(xml1);

		List<Negotiation> list = Arrays.asList(negotiation);
		CandleStickFactory candleFactory = new CandleStickFactory();
		CandleStick  candle = candleFactory.generateCandleStickParaData(list, LocalDateTime.now());
		String xml2 = stream.toXML(candle);
		
		System.out.println("\nCandleStick as a XML: ");
		System.out.println(xml2);
	}
}
