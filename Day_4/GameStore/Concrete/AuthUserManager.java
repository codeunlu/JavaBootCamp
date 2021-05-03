package Concrete;

import Abstract.BaseUserManager;
import Abstract.UserCheckService;
import Entities.User;

public class AuthUserManager extends BaseUserManager {
	
	private UserCheckService userCheckService;
	
	public AuthUserManager(UserCheckService userCheckService) {
		this.userCheckService = userCheckService;		
	}
	
	@Override
	public void add(User user) {
		if(userCheckService.checkIfRealUser(user)) {
			System.out.println(user.getFirstName()+" ismiyle üye oluşturuldu.");
		}else {
			System.out.println("Üye bilgilerinde hata vardır!");
		}
	}
}
