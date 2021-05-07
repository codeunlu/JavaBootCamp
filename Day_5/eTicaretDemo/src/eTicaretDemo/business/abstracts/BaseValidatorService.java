package eTicaretDemo.business.abstracts;

import eTicaretDemo.entities.concretes.Customer;

public interface BaseValidatorService {
	boolean isValid(Customer customer);
}
