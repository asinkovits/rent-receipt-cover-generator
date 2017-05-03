package com.sinkovits.rent.generator;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.transform.TransformerFactory;

import org.apache.fop.apps.FopFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.xml.sax.SAXException;

@Configuration
public class TestsConfiguration {

	@Autowired
	private ResourceLoader resourceLoader;
	
	@Bean
	public PdfGenerator genertaor(){
		return new PdfGenerator();
	}

	@Bean
	public TransformerFactory transformerFactory() {
		return TransformerFactory.newInstance();
	}
	
	@Bean
	public FopFactory fopFactory() throws SAXException, IOException, URISyntaxException {
		Resource fopConfigResource = resourceLoader.getResource(PdfGenerator.FOP_XCONF);
		return FopFactory.newInstance(new URI("."), fopConfigResource.getInputStream());
	}
}
