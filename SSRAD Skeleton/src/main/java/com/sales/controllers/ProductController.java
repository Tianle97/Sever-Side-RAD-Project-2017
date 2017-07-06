package com.sales.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller

public class ProductController {
@Autowired	
	ProductService ps;
//删掉了原来的GET方法

@RequestMapping(value = "/showProducts", method=RequestMethod.GET)
public String showProduct(HttpServletRequest h,Model model)
{
	ArrayList<Product> p1 = ps.getProduct();//ps.getProduct()是ProductService内的class.Alldata，
	for(int i=0;i < p1.size();i++)
	{
		System.out.println("12321412" + p1.get(i).toString());	
	}
	model.addAttribute("p1",p1);
	return "showProducts";
	}

@RequestMapping(value = "/addProduct", method=RequestMethod.GET)
public String getProduct(HttpServletRequest h, Model model)
{
	Product p = new Product();
	model.addAttribute("p1", p);
	System.out.println("HTTP Request 111= " + h.getMethod());
	return "addProduct";
	}


@RequestMapping(value = "/addProduct", method=RequestMethod.POST)
public String postProduct1(@Valid @ModelAttribute("p1") Product p, BindingResult result,HttpServletRequest h, Model model){
//BindingResult必须要在Product p后面  不知道
	if (result.hasErrors()){
		
		return "addProduct";
	}
	System.out.println("HTTP Request = " + h.getMethod());
	ps.save(p);
	ArrayList<Product> p1 = ps.getProduct();
	for(int i=0;i < p1.size();i++)
	{
		System.out.println("iiiii" + p1.get(i).toString());	
	}
	model.addAttribute("p1",p1);
	

	
	    return "showProducts";
	
}


	





}
