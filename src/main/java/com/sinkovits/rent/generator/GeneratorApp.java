package com.sinkovits.rent.generator;

import java.util.ArrayList;
import java.util.List;

public class GeneratorApp {

	public static void main(String[] args) {
		new GeneratorApp().execute();
	}

	private String header;
	private String date;
	private String landlord;
	private int rentValue;
	private String rentValueText;
	private String tenant;
	private List<Bill> bills = new ArrayList<>();

	public void execute() {
		
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLandlord() {
		return landlord;
	}

	public void setLandlord(String landlord) {
		this.landlord = landlord;
	}

	public int getRentValue() {
		return rentValue;
	}

	public void setRentValue(int rentValue) {
		this.rentValue = rentValue;
	}

	public String getRentValueText() {
		return rentValueText;
	}

	public void setRentValueText(String rentValueText) {
		this.rentValueText = rentValueText;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public void addBill(Bill testBill) {
		bills.add(testBill);
	}

	public Bill getBill(int index) {
		return bills.get(index);
	}

}
