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

import com.sales.exceptions.NotCIdException;

import com.sales.exceptions.NotPIdException;
import com.sales.exceptions.NullCIdException;

import com.sales.exceptions.NullPIdException;
import com.sales.exceptions.QtyException;
import com.sales.models.Order;
import com.sales.services.OrderService;



@Controller
public class OrderController {
	
	@Autowired
	private OrderService os;
	
	@RequestMapping(value="/showOrders", method=RequestMethod.GET)
	public String showOrders(Model model, HttpServletRequest h)
	{
		ArrayList<Order> o1 = os.getOrder();
		for(int o=0;o<o1.size();o++)
		{
			System.out.println("ooooooo" + o1.get(o).toString());
		}
		model.addAttribute("o1", o1);
		return "showOrders";
	}
	
	@RequestMapping(value = "/addOrder", method=RequestMethod.GET)
	public String getOrder(Model model, HttpServletRequest h)
	{
		Order o = new Order();
		model.addAttribute("o1", o);
		System.out.println("HTTP Request 111= " + h.getMethod());
		return "addOrder";
	}
	
	@RequestMapping(value = "/addOrder",method=RequestMethod.POST)
	public String postProduct1(@Valid@ModelAttribute("o1") Order o,BindingResult result,HttpServletRequest h,Model model)
	{
		if (result.hasErrors())
		{
			return "addOrder";
		}else{
			try{
				System.out.println("HTTP Request = " + h.getMethod());
				os.save(o);
				ArrayList<Order> o1 = os.getOrder();
				for(int i=0;i<o1.size();i++)
				{
					System.out.println("oooooo" + o1.get(i).toString());
				}
				model.addAttribute("o1", o1); 
				return "showOrders";
			} catch (NullCIdException | NullPIdException |NotCIdException |NotPIdException | QtyException e) {
				e.printStackTrace();
				model.addAttribute("message", e.getMessage());
				model.addAttribute("cid", o.getCust().getcId());
				model.addAttribute("pid", o.getProd().getpId());
				model.addAttribute("Qty", o.getQty());
				return "errorpage1";
				
				
				
				
			}
		}
		
 	}
}


