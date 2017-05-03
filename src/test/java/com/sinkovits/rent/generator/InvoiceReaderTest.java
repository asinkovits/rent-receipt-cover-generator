package com.sinkovits.rent.generator;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class InvoiceReaderTest {

	private InvoiceReader reader;

	@Before
	public void setUp() {
		this.reader = new InvoiceReader();
	}

	@Test
	public void testDeserializeInvoice() {
		// Given
		File testXmlData = new File("src/test/resources/testInvoice.xml");
		String testDate = "2010.01.01.";
		String testHeader = "Test invoice";
		String testLandlord = "John Doe";
		int testRentValue = 200;
		String testRentValueText = "Two hundred";
		String testTenant = "Jane Doe";

		// When
		Invoice invoice = reader.read(testXmlData);
		// Then
		assertThat(invoice, notNullValue());
		assertThat(invoice.getDate(), equalTo(testDate));
		assertThat(invoice.getHeader(), equalTo(testHeader));
		assertThat(invoice.getLandlord(), equalTo(testLandlord));
		assertThat(invoice.getRentValue(), equalTo(testRentValue));
		assertThat(invoice.getRentValueText(), equalTo(testRentValueText));
		assertThat(invoice.getTenant(), equalTo(testTenant));
	}
}
