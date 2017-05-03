package com.sinkovits.rent.generator;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class InvoiceTest {

	private Invoice invoice;
	
	@Before
	public void setUp(){
		this.invoice = new Invoice();
	}
	
	@Test
	public void canSetBaseData() {
		// Given
		String testDate = "2010.01.01.";
		String testHeader = "Test invoice";
		String testLandlord = "John Doe";
		int testRentValue = 200;
		String testRentValueText = "Two hundred";
		String testTenant = "Jane Doe";

		// When
		invoice.setDate(testDate);
		invoice.setHeader(testHeader);
		invoice.setLandlord(testLandlord);
		invoice.setRentValue(testRentValue);
		invoice.setRentValueText(testRentValueText);
		invoice.setTenant(testTenant);

		// Then
		assertThat(invoice.getDate(), equalTo(testDate));
		assertThat(invoice.getHeader(), equalTo(testHeader));
		assertThat(invoice.getLandlord(), equalTo(testLandlord));
		assertThat(invoice.getRentValue(), equalTo(testRentValue));
		assertThat(invoice.getRentValueText(), equalTo(testRentValueText));
		assertThat(invoice.getTenant(), equalTo(testTenant));
	}

	@Test
	public void canSetBillData() {
		// Given
		Bill testBill = new Bill();

		// When
		invoice.addBill(testBill);

		// Then
		assertThat(invoice.getBill(0), equalTo(testBill));

	}

	@Test
	public void canSetMultipleBillData() {
		// Given
		Bill testBill1 = new Bill();
		Bill testBill2 = new Bill();

		// When
		invoice.addBill(testBill1);
		invoice.addBill(testBill2);

		// Then
		assertThat(invoice.getBill(0), equalTo(testBill1));
		assertThat(invoice.getBill(1), equalTo(testBill2));
	}
}
