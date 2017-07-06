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

import com.sales.models.Customer;

import com.sales.services.CustomerService;

@Controller
public class CustomerController {
@Autowired
	private CustomerService cs;

@RequestMapping(value = "/showCustomers", method=RequestMethod.GET)
public String showCustomer(Model model, HttpServletRequest h)
{
	ArrayList<Customer> c1 = cs.getCustomer();
	for(int i=0;i<c1.size();i++)
	{
		System.out.println("1111111" + c1.get(i).toString());
	}
	model.addAttribute("c1", c1);
	return "showCustomers";
	}

@RequestMapping(value = "/addCustomer", method=RequestMethod.GET)
public String getCustomer(HttpServletRequest h, Model model)
{
	Customer c = new Customer();
	model.addAttribute("c1", c);
	System.out.println("HTTP Request 222= " + h.getMethod());
	return "addCustomer";
}
@RequestMapping(value = "addCustomer", method=RequestMethod.POST)
public String postCustomer(@Valid @ModelAttribute("c1") Customer c,BindingResult result,HttpServletRequest h, Model model)
{

	if (result.hasErrors()){
		return "addCustomer";
	}
	System.out.println("zzzzz" + h.getMethod());
	cs.save(c);
	ArrayList<Customer> c1 = cs.getCustomer();
	for(int a=0;a<c1.size();a++)
	{
		System.out.println("aaaaaa" + c1.get(a).toString());
	}
	model.addAttribute("c1", c1);
	
	return "showCustomers";
}




}
