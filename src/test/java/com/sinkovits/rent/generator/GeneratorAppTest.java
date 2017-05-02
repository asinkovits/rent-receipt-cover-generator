package com.sinkovits.rent.generator;

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

}
