package br.com.treinamento.tdd.reader;

import java.time.LocalDateTime;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.time.LocalDateTimeConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.treinamento.tdd.modelo.Negotiation;

public class XmlReader {

	public static void main(String[] args) {
		Negotiation negotiation = new Negotiation(10, 10, LocalDateTime.now());
		
		XStream stream = new XStream(new DomDriver());
		stream.registerLocalConverter(Negotiation.class, "date", new LocalDateTimeConverter());
		String xml = stream.toXML(negotiation);
		System.out.println(xml);
	}
}
