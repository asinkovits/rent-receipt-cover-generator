package com.sinkovits.rent.generator.cover;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "invoice")
public class Invoice {

	private String header;
	private String date;
	private String landlord;
	private int rentValue;
	private String rentValueText;
	private String tenant;
	private List<Bill> bills = new ArrayList<>();

	@XmlElement
	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	@XmlElement
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@XmlElement
	public String getLandlord() {
		return landlord;
	}

	public void setLandlord(String landlord) {
		this.landlord = landlord;
	}

	@XmlElement
	public int getRentValue() {
		return rentValue;
	}

	public void setRentValue(int rentValue) {
		this.rentValue = rentValue;
	}

	@XmlElement
	public String getRentValueText() {
		return rentValueText;
	}

	public void setRentValueText(String rentValueText) {
		this.rentValueText = rentValueText;
	}

	@XmlElement
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

	@XmlElement(name = "bill")
	public List<Bill> getBills() {
		return bills;
	}
}
