package com.applayer;

public class Product {
	private int productId;
	private String productName;
	private String productCategory;
	private double price;

	public Product(int productId, String productName, String productCategory, double price) {
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", price=" + price + "]";
	}

}
