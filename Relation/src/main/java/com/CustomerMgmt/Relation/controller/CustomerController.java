package com.CustomerMgmt.Relation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.CustomerMgmt.Relation.model.Customer;
import com.CustomerMgmt.Relation.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	CustomerService customerService;
 
	@GetMapping("/home")
	public String test() {
		System.out.println("jfhvjkcx");
		return "Customerform.jsp";
	}

	@GetMapping("/listId")
	public String FindCustomerByid(@RequestParam("Id") int Id, Model model) {
		Optional<Customer> customer = customerService.findById(Id);
		model.addAttribute("Customer", customer);
		System.out.println(customer);
		return "list-customer";
	}

	@GetMapping("/add")
	public String AddCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("Customer", customer);
		return "Customerform.jsp";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("Customer") Customer customer) {
		customerService.save(customer);
		return "redirect:/listAll";
	}

	@GetMapping("/update")
	public String UpdateCustomer(@RequestParam("Id") int Id, Model model) {
		Customer customer = customerService.getCustomerById(Id).get();
		System.out.println("update kar raha hu" + customer);
		model.addAttribute("Customer", customer);
		return "Customerform.jsp";
	}

	@GetMapping("/listAll")
	public String FindAllCustomer(Model model) {
		List<Customer> customers = customerService.getAllCustomer();
		model.addAttribute("Customers", customers);
		return "list-customer.jsp";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("Id") int id) {
		customerService.deleteById(id);
		return "redirect:/listAll";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam("firstName") String firstName, Model model) {
		if (!firstName.isEmpty()) {
			List<Customer> customer = customerService.search(firstName);
			model.addAttribute("Customer", customer);
			System.out.println("first nmae search" + firstName);
			return "Customerform.jsp";
		}
		return "redirect:/listAll";
	}
}
