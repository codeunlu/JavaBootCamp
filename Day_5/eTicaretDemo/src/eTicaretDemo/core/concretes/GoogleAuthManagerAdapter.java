package eTicaretDemo.core.concretes;

import eTicaretDemo.GoogleAuth.GoogleAuthManager;
import eTicaretDemo.core.abstracts.GoogleAuthService;

public class GoogleAuthManagerAdapter implements GoogleAuthService{
	
	@Override
	public void accountRegister(String email) {
		GoogleAuthManager googleAuthManager = new GoogleAuthManager();
		googleAuthManager.register(email);
	}

}
