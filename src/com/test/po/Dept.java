package com.test.po;

public class Dept {
	private int ID;
	private String name;
	private String address;
	
	public Dept(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public String toString() {
		return "Dept [ID=" + ID + ", name=" + name + ", address=" + address + "]";
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Dept(int iD, String name, String address) {
		super();
		ID = iD;
		this.name = name;
		this.address = address;
	}
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
}
