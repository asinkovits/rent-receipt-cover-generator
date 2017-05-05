package com.sinkovits.rent.generator.cover;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import static org.springframework.util.Assert.notNull;

public class PdfGenerator {

	public static final String FOP_XCONF = "classpath:fop.xconf";

	private TransformerFactory transformerFactory;
	private FopFactory fopFactory;
	private ResourceLoader resourceLoader;
	private String templateFile;

	public void generate(Path input, Path output) {
		notNull(templateFile, "Template file is not set!");
		notNull(input, "Input path is not set!");
		notNull(output, "Output path is not set!");
		Resource template = resourceLoader.getResource(templateFile);
		try (BufferedReader in = Files.newBufferedReader(input);
				OutputStream out = new BufferedOutputStream(Files.newOutputStream(output));
				InputStream templateInputStream = template.getInputStream()) {
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);
			Transformer transformer = transformerFactory.newTransformer(new StreamSource(templateInputStream));
			Source src = new StreamSource(in);
			Result res = new SAXResult(fop.getDefaultHandler());
			transformer.transform(src, res);
		} catch (TransformerException | FOPException | IOException ex) {
			throw new RuntimeException("PDF generation failed!", ex);
		}
	}

	public void setTransformerFactory(TransformerFactory transformerFactory) {
		this.transformerFactory = transformerFactory;
	}

	public void setFopFactory(FopFactory fopFactory) {
		this.fopFactory = fopFactory;
	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public void setTemplateFile(String templateFile) {
		this.templateFile = templateFile;
	}
}
