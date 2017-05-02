package com.sinkovits.rent.generator;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class GeneratorAppTest {

	private GeneratorApp app;

	@Before
	public void setUp() {
		this.app = new GeneratorApp();
	}

	@Test
	public void canApplicationExecute() {
		app.execute();
	}

	@Test
	public void canSetBaseData() {
		// Given
		String testDate = "2010.01.01";
		String testHeader = "Test invoice";
		String testLandlord = "John Doe";
		int testRentValue = 200;
		String testRentValueText = "Two hundred";
		String testTenant = "Jane Doe";

		// When
		app.setDate(testDate);
		app.setHeader(testHeader);
		app.setLandlord(testLandlord);
		app.setRentValue(testRentValue);
		app.setRentValueText(testRentValueText);
		app.setTenant(testTenant);

		// Then
		assertThat(app.getDate(), equalTo(testDate));
		assertThat(app.getHeader(), equalTo(testHeader));
		assertThat(app.getLandlord(), equalTo(testLandlord));
		assertThat(app.getRentValue(), equalTo(testRentValue));
		assertThat(app.getRentValueText(), equalTo(testRentValueText));
		assertThat(app.getTenant(), equalTo(testTenant));
	}

	@Test
	public void canSetBillData() {
		// Given
		Bill testBill = new Bill();
		
		// When
		app.addBill(testBill);
		
		// Then
		assertThat(app.getBill(0), equalTo(testBill));
		
	}

	@Test
	public void canSetMultipleBillData() {
		// Given
		Bill testBill1 = new Bill();
		Bill testBill2 = new Bill();
		
		// When
		app.addBill(testBill1);
		app.addBill(testBill2);
		
		// Then
		assertThat(app.getBill(0), equalTo(testBill1));
		assertThat(app.getBill(1), equalTo(testBill2));
	}
}
