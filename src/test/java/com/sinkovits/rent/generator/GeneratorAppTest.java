package com.sinkovits.rent.generator;

import static org.hamcrest.Matchers.equalTo;
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

	public void canSetInvoiceData() {
		Invoice testInvoice = new Invoice();
		
//		app.setInvoice(testInvoice);
//		
//		assertThat(app.getInvoice(), equalTo(testInvoice));
	}
}
