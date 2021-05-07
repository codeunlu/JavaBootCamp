package eTicaretDemo.business.abstracts;

import eTicaretDemo.entities.concretes.Customer;

public interface CustomerService {
	void register(Customer customer);
	void active(String code);
	void login(String email, String password);
	void google(String email);
}
