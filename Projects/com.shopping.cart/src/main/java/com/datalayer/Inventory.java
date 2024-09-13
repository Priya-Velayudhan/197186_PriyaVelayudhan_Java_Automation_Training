package com.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.applayer.Product;
import com.servicelayer.DBConnection;

public class Inventory implements InventoryInterface {
	private List<Product> products;
	Connection conn;
	ResultSet resultset;
	PreparedStatement ps;

	public Inventory() {

		products = new ArrayList<>();
		conn = DBConnection.getConnection();

	}

	public List<Product> searchProductsByName(String name) {
		products.clear();

		String Query = "Select *  from products where ProductName like" + "'" + "%" + name + "%" + "'";
		try {
			ps = conn.prepareStatement(Query);
			resultset = ps.executeQuery();
			String pname, pcategory;
			int id;
			double price;
			while (resultset.next()) {
				id = resultset.getInt("ProductId");
				pname = resultset.getString("ProductName").trim();
				pcategory = resultset.getString("ProductCategory").trim();
				price = resultset.getInt("ProductPrice");
				products.add(new Product(id, pname, pcategory, price));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return products.stream().filter(product -> product.getProductName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());

	}

	public Product getProductById(int productId) {
		String Query = "Select *  from products where ProductId=" + "'" + productId + "'";

		try {
			ps = conn.prepareStatement(Query);
			resultset = ps.executeQuery();
			String pname, pcategory;
			int id;
			double price;
			while (resultset.next()) {
				id = resultset.getInt("ProductId");
				pname = resultset.getString("ProductName").trim();
				pcategory = resultset.getString("ProductCategory").trim();
				price = resultset.getInt("ProductPrice");
				products.add(new Product(id, pname, pcategory, price));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return products.stream().filter(product -> product.getProductId() == productId).findFirst().orElse(null);
	}

	public List<Product> getAvailableProducts() {
		String Query = "Select *  from products";

		try {
			ps = conn.prepareStatement(Query);
			resultset = ps.executeQuery();
			String pname, pcategory;
			int id;
			double price;
			while (resultset.next()) {
				id = resultset.getInt("ProductId");
				pname = resultset.getString("ProductName").trim();
				pcategory = resultset.getString("ProductCategory").trim();
				price = resultset.getInt("ProductPrice");
				products.add(new Product(id, pname, pcategory, price));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return products;
	}

}
