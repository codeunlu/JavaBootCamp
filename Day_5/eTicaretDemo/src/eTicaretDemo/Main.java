package eTicaretDemo;

import eTicaretDemo.business.abstracts.CustomerService;
import eTicaretDemo.business.concretes.BaseValidatorManager;
import eTicaretDemo.business.concretes.CustomerManager;
import eTicaretDemo.core.concretes.GoogleAuthManagerAdapter;
import eTicaretDemo.core.concretes.MailManager;
import eTicaretDemo.dataAccess.concretes.BaseCustomerDao;
import eTicaretDemo.entities.concretes.Customer;

public class Main {

	public static void main(String[] args) {
		
		Customer customer = new Customer();
		customer.setId(1);
		customer.setIsActive(false);
		customer.setEmail("mstf_unlu@hotmail.com");
		customer.setPassword("123456");
		customer.setFirstName("Mustafa");
		customer.setLastName("UNLU");
		
		Customer customer2 = new Customer(1,false,"Mustafa","ÜNLÜ","mstf_unlu@hotmail.com","123456");
		
		CustomerService customerManager = new CustomerManager(
				new BaseCustomerDao(), 
				new MailManager(),
				new BaseValidatorManager());
		
		customerManager.register(customer);
		customerManager.active(customer.getActiveCode());
				
		System.out.println("----------------------------------------------");
		
		customerManager.login("mstf_unlu@hotmail.com", "1234");
		
		System.out.println("----------------------------------------------");
		
		customerManager.register(customer2);

		
		System.out.println("---------------------------");
		
		CustomerService customerManager2 = new CustomerManager(new GoogleAuthManagerAdapter());
		customerManager2.google("uckafacom@gmail.com");
				

	}

}
