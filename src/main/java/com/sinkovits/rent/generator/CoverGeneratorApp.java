package com.sinkovits.rent.generator;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.transform.TransformerFactory;

import org.apache.fop.apps.FopFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.xml.sax.SAXException;

import com.sinkovits.rent.generator.cover.PdfGenerator;

@SpringBootApplication
public class CoverGeneratorApp implements CommandLineRunner {

	public static final String TEMPLATE = "classpath:invoice2fo.xsl";

	@Bean
	public PdfGenerator pdfGenerator(ResourceLoader resourceLoader) throws SAXException, IOException, URISyntaxException {
		PdfGenerator generator = new PdfGenerator();
		generator.setTemplateFile(TEMPLATE);
		Resource fopConfigResource = resourceLoader.getResource(PdfGenerator.FOP_XCONF);
		generator.setFopFactory(FopFactory.newInstance(new URI("."), fopConfigResource.getInputStream()));
		generator.setTransformerFactory(TransformerFactory.newInstance());
		generator.setResourceLoader(resourceLoader);
		return generator;
	}

	@Autowired
	private PdfGenerator generator;

	public static void main(String[] args) {
		SpringApplication.run(CoverGeneratorApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 Path workDir = Paths.get(args[0]);
		 generator.generate(workDir.resolve(args[1]),
		 workDir.resolve(args[2]));
	}

}
