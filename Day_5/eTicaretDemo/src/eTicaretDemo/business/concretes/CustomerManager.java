package eTicaretDemo.business.concretes;

import eTicaretDemo.business.abstracts.CustomerService;
import eTicaretDemo.core.concretes.GoogleAuthManagerAdapter;
import eTicaretDemo.core.concretes.MailManager;
import eTicaretDemo.dataAccess.concretes.BaseCustomerDao;
import eTicaretDemo.entities.concretes.Customer;

public class CustomerManager implements CustomerService{
	
	BaseCustomerDao baseCustomerDao;
	MailManager mailManager;
	BaseValidatorManager baseValidator;
	GoogleAuthManagerAdapter googleAuth;
	
	public CustomerManager(BaseCustomerDao baseCustomerDao, MailManager mailManager, BaseValidatorManager baseValidator) {
		this.baseCustomerDao = baseCustomerDao;
		this.baseValidator = baseValidator;
		this.mailManager = mailManager;
	}
	
	public CustomerManager(GoogleAuthManagerAdapter googleAuth) {
		this.googleAuth = googleAuth;
	}
	
	@Override
	public void register(Customer customer) {
		if(baseValidator.isValid(customer) && baseCustomerDao.check(customer)) {
			baseCustomerDao.add(customer);
			mailManager.sendMail(customer.getEmail(), customer.getActiveCode());
		}
	}
	
	@Override
	public void google(String email) {
		googleAuth.accountRegister(email);
	}

	@Override
	public void active(String code) {
		baseCustomerDao.active(code);
	}

	@Override
	public void login(String email, String password) {
		baseCustomerDao.login(email, password);				
	}

}
