package com.sinkovits.rent.generator.cover;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.fop.apps.MimeConstants;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { TestsConfiguration.class })
public class PdfGeneratorIT {

	@Autowired
	private PdfGenerator generator;

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	private Path testInput;
	private Path testOutput;

	@Before
	public void setUp() throws IOException {
		this.testInput = Paths.get("src/test/resources/testInvoice.xml");
		this.testOutput = Paths.get(folder.newFile("testoutput.pdf").getAbsolutePath());
	}

	@Test
	public void exampleTest() throws IOException {
		// When
		generator.generate(testInput, testOutput);

		// Then
		File file = testOutput.toFile();
		assertTrue(file.exists());
		assertTrue(file.isFile());
		assertThat(file.length(), greaterThan(0L));
		assertThat(Files.probeContentType(testOutput), equalTo(MimeConstants.MIME_PDF));
	}
}
