package com.sinkovits.rent.generator.cover;

import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PdfGeneratorTest {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	private PdfGenerator pdfGenerator;

	@Before
	public void setUp() {
		this.pdfGenerator = new PdfGenerator();
	}

	@Test
	public void templateFileIsNotSet() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Template file is not set!");
		pdfGenerator.generate(null, null);
	}

	@Test
	public void inputIsNotSet() {
		pdfGenerator.setTemplateFile("template");
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Input path is not set!");
		pdfGenerator.generate(null, Paths.get("output"));

	}

	@Test
	public void outputIsNotSet() {
		pdfGenerator.setTemplateFile("template");
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Output path is not set!");
		pdfGenerator.generate(Paths.get("input"), null);

	}
}
