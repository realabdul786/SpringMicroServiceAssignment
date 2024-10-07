
package com.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entity.Order;
import com.repo.OrderRepo;

@Service
public class OrderService {

	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	RestTemplate restTemp;
	
	@Autowired
	ProductFeignService productFeign;
	
	public String placeOrder(int oid, String userName, String prodName, int quantity)
	{
		
		if(userName == null || prodName == null || quantity <= 0)
			return "Pass valid arguments";
		
		// restTemplate for UserService
		int userId = restTemp.getForObject("http://USER-MICRO-SERVICE/user/usersbyname/" + userName, Integer.class);
		if(userId == -1)
			return "Username not found in DB";
	
		// FeignClient for Product service
		int prodId = productFeign.getpIdByName(prodName);
		if(prodId ==-1)
			return "Product name not found in DB";
		
		boolean orderIsPresent = false;
		Order order = new Order();
		order.setUid(userId);
		order.setPid(prodId);
		order.setQuantity(quantity);
		if(oid != -1) {

			order.setOid(oid);
			Optional<Order> fetchedOrder =  orderRepo.findById(oid);
			orderIsPresent = fetchedOrder.isPresent();
		}
		
		if(orderIsPresent)
			return "Order ID already exists";
		orderRepo.save(order);
		return "Order placed successfully";
	}
	
	public Order getOrderById(int oid)
	{
		Optional<Order> fetchedOrder = orderRepo.findById(oid);
		if(fetchedOrder.isPresent())
		{
			return fetchedOrder.get();
		}
		else
		{
			return null;
		}
	}
	
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}
}
