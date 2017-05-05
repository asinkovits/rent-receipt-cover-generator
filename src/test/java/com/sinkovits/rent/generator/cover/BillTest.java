package com.sinkovits.rent.generator.cover;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BillTest {

	private Bill bill;

	@Before
	public void setUp() {
		this.bill = new Bill();
	}

	@Test
	public void canStoreData() {
		// Given
		String testLabel = "Test bill item";
		int testValue = 200;

		// When
		bill.setLabel(testLabel);
		bill.setValue(testValue);

		// Then
		assertThat(bill.getLabel(), equalTo(testLabel));
		assertThat(bill.getValue(), equalTo(testValue));
	}
}
