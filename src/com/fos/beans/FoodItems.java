package com.fos.beans;


public class FoodItems {
	private int fid;
	private String fname;
	private String type;
	private int qty;
	private double price;
	 
	public FoodItems(){}
	public FoodItems(int fid, String fname, String type,int qty, double price) {
		
		this.fid = fid;
		this.fname = fname;
		this.type = type;
		this.qty = qty;
		this.price = price;
		
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String toString()
	{
		return fid+"\t"+fname+"\t"+ type +"\t"+ qty +"\t"+price;
	}

}
