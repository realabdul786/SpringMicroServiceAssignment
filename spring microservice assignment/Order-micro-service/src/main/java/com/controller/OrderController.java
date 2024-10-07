package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Order;
import com.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	OrderService service;
	
	@PostMapping(value = "orders", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String placeOrder(@RequestBody Map<String, Object> map)
	{
		int oid = -1;
		if(map.containsKey("oid"))
			oid = Integer.parseInt(map.get("oid").toString());
		
		String uname = null;
		if(map.containsKey("username"))
			uname = map.get("username").toString();
		
		String pname = null;
		if(map.containsKey("productname"))
			pname = map.get("productname").toString();
		
		int quantity = -1;
		if(map.containsKey("quantity"))
			quantity = Integer.parseInt(map.get("quantity").toString());
		
		return service.placeOrder(oid, uname, pname, quantity);
	}
	
	@GetMapping(value = "orders/{oid}", produces = MediaType.APPLICATION_JSON_VALUE )
	public Object getOrderById(@RequestParam("oid") int id)
	{
		Order o = service.getOrderById(id);
		if(o==null)
			return "Order not found";
		return o;
	}
	
	@GetMapping(value = "orders", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Order> getAll(){
		return service.getAllOrders();
	}
	
	
}
