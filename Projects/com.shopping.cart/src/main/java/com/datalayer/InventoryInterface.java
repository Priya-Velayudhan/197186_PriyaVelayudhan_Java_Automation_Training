package com.datalayer;

import java.util.List;

import com.applayer.Product;

public interface InventoryInterface {

	List<Product> searchProductsByName(String name);

	Product getProductById(int productId);

	List<Product> getAvailableProducts();
}
