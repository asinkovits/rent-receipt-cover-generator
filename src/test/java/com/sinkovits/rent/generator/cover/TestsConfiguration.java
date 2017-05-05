package com.sinkovits.rent.generator.cover;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.transform.TransformerFactory;

import org.apache.fop.apps.FopFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.xml.sax.SAXException;

public class TestsConfiguration {

	@Bean
	public PdfGenerator genertaor(FopFactory fopFactory, TransformerFactory transformerFactory, ResourceLoader resourceLoader){
		PdfGenerator gen = new PdfGenerator();
		gen.setTemplateFile("classpath:invoice2fo.xsl");
		gen.setFopFactory(fopFactory);
		gen.setTransformerFactory(transformerFactory);
		gen.setResourceLoader(resourceLoader);
		return gen;
	}

	@Bean
	public TransformerFactory transformerFactory() {
		return TransformerFactory.newInstance();
	}
	
	@Bean
	public FopFactory fopFactory(ResourceLoader resourceLoader) throws SAXException, IOException, URISyntaxException {
		Resource fopConfigResource = resourceLoader.getResource(PdfGenerator.FOP_XCONF);
		return FopFactory.newInstance(new URI("."), fopConfigResource.getInputStream());
	}
}
