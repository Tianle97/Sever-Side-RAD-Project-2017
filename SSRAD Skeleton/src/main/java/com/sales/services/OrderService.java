package com.sales.services;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.exceptions.NotCIdException;

import com.sales.exceptions.NotPIdException;
import com.sales.exceptions.NullCIdException;

import com.sales.exceptions.NullPIdException;
import com.sales.exceptions.QtyException;
import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.repositories.CustomerInterface;
import com.sales.repositories.OrderInterface;
import com.sales.repositories.ProductInterface;


@Service
public class OrderService {

@Autowired
private OrderInterface orderinterface;
@Autowired
private ProductInterface productinterface;
@Autowired 
private CustomerInterface customerinterface;

private Customer c;
private Product p;

private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
private Date date = new Date();

public ArrayList<Order> getOrder() {
	ArrayList<Order> o = (ArrayList<Order>) orderinterface.findAll();
	return o;
}

public Order save(Order o1) throws NullCIdException,NullPIdException, NotCIdException,NotPIdException, QtyException {
	c = customerinterface.findOne(o1.getCust().getcId());
	p = productinterface.findOne(o1.getProd().getpId());
	
	if (c == null)
	{
		throw new NullCIdException("No such customer: 1234 ");
	}
	else if (p == null) {
		throw new NullPIdException("No such product: 2001 ");
	}
	
	else if (o1.getCust().getcId() != c.getcId())
	{
		throw new NotCIdException("Customer Id doesn't exist:");
	}
	else if (o1.getProd().getpId() != p.getpId())
	{
		throw new NotPIdException("Product Id doesn't exist: ");
	}
	else if(o1.getQty() > p.getQtyInStock())
	{
		throw new QtyException("Quantity too large: Product stock = 109");
	}
	else
	{
		p.setQtyInStock(p.getQtyInStock() - o1.getQty());
		o1.setOrderDate(dateFormat.format(date));
		o1.getCust().setcName(c.getcName());
		o1.getProd().setpDesc(p.getpDesc());
	
		orderinterface.save(o1);
		return orderinterface.save(o1);
	}
	
	
}
}