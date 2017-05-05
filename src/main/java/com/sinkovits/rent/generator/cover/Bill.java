package com.sinkovits.rent.generator.cover;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bill")
public class Bill {

	private String label;
	private int value;

	@XmlElement
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@XmlElement
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
