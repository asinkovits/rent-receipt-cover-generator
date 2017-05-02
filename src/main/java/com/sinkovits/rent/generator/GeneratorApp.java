package com.sinkovits.rent.generator;

public class GeneratorApp {

	public static void main(String[] args) {
		new GeneratorApp().execute();
	}

	private Invoice invoice;

	public void execute() {
		
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}
