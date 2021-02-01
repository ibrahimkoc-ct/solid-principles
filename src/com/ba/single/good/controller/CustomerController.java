package com.ba.single.good.controller;

import java.util.List;

import com.ba.single.good.entity.Customer;
import com.ba.single.good.service.CustomerServiceImpl;

public class CustomerController {

	private CustomerServiceImpl serviceImpl;

	public CustomerController(CustomerServiceImpl serviceImpl) {
		this.serviceImpl = serviceImpl;
	}

	public String addCustomer(Customer customer) {
		return serviceImpl.addCustomer(customer);
		
	}

	public String deleteCustomer(int id) {
		return serviceImpl.deleteCustomer(id);
		
	}

	public String updateCustomer(Customer customer) {
		return serviceImpl.updateCustomer(customer);
		
	}

	public List<Customer> listCustomer(){
		return serviceImpl.listCustomer();
		
	}

}
