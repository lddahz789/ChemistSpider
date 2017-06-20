package com.lyn.ChemistSpider.bean;

public class Product {
	
	private long id;
	private String productName;
	private String productPrice;
	private String retailPrice;
	private String brand;
	private String productId;

	
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(String retailPrice) {
		this.retailPrice = retailPrice;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", retailPrice=" + retailPrice + ", brand=" + brand + ", productId=" + productId + "]";
	}

	

}
