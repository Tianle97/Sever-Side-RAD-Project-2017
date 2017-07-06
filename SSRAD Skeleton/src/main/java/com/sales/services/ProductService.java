package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Product;
import com.sales.repositories.ProductInterface;

@Service
public class ProductService {
	
@Autowired
private ProductInterface productinterface;

public ArrayList<Product> getProduct() {
	ArrayList<Product> p = (ArrayList<Product>) productinterface.findAll();
	//把interface中需要find的值全部找到，然后全部赋值到ArrayList<Product> p内，然后输出 p.
	return p;
}

public Product save(Product p1) {
	productinterface.save(p1);
	return productinterface.save(p1);
}

}
