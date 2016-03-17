package com.proyecto01.pacakge;

public class Product {

	int id;
	String pname;
	int qty;	
	String category;
	int uprice;
	int tprice;
	static int ctprice;
		

	public Product(int id, String pname, int qty, String category, int uprice, int tprice) {
		this.id = id;
		this.pname = pname;
		this.qty = qty;
		this.category = category;
		this.uprice = uprice;
		this.tprice = qty*uprice;
	}
	
	
	public Product() {
		
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPname() {
		return pname;
	}

	
	public void setPname(String pname) {
		this.pname = pname;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		tprice=Product.calTprice(qty,uprice);
		this.qty = qty;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getUprice() {
		return uprice;
	}


	public void setUprice(int uprice) {
		this.uprice = uprice;
	}


	public int getTprice() {
		return tprice;
	}

	
	public void setTprice(int tprice) {
		this.tprice = tprice;
	}
	
	private static int calTprice(int qty, int uprice){
		ctprice=qty*uprice;
		return ctprice;
		
	}



	public String toString(){
		return id + pname  + qty  + category + uprice +tprice ;
		}
	
		
	
}
