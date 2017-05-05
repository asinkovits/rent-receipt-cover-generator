package com.sinkovits.rent.generator.cover;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class InvoiceReader {

	private JAXBContext jaxbContext;
	private Unmarshaller jaxbUnmarshaller;

	public InvoiceReader() {
		try {
			jaxbContext = JAXBContext.newInstance(Invoice.class);
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException ex) {
			throw new RuntimeException(ex);
		}
	}

	public Invoice read(File data) {
		try {
			return (Invoice) jaxbUnmarshaller.unmarshal(data);
		} catch (JAXBException ex) {
			throw new RuntimeException(ex);
		}
	}
}
