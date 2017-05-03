package com.sinkovits.rent.generator;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class PdfGenerator {

	public static final String FOP_XCONF = "classpath:fop.xconf";
	public static final String TEMPLATE = "classpath:invoice2fo.xsl";

	private TransformerFactory transformerFactory;
	private FopFactory fopFactory;
	private ResourceLoader resourceLoader;

	public void generate(Path input, Path output) {
		Resource template = resourceLoader.getResource(TEMPLATE);
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

	@Autowired
	public void setTransformerFactory(TransformerFactory transformerFactory) {
		this.transformerFactory = transformerFactory;
	}

	@Autowired
	public void setFopFactory(FopFactory fopFactory) {
		this.fopFactory = fopFactory;
	}

	@Autowired
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

}
