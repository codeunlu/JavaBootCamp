package eTicaretDemo.business.concretes;

import eTicaretDemo.business.abstracts.BaseValidatorService;
import eTicaretDemo.core.concretes.FormValidatorManager;
import eTicaretDemo.entities.concretes.Customer;

public class BaseValidatorManager extends FormValidatorManager implements BaseValidatorService{

	@Override
	public boolean isValid(Customer customer) {
		if(!isInput(customer.getFirstName(),"İsim alanı 2 karakterden az olamaz.")) {
			return false;
		}
		if(!isInput(customer.getLastName(),"Soyisim alanı 2 karakterden az olamaz.")) {
			return false;
		}
		if(!isEmail(customer.getEmail())) {
			return false;
		}
		if(!isPassword(customer.getPassword())) {
			return false;
		}
		System.out.println("Tüm alanlar sorunsuzdur.");
		return true;
	}

}
