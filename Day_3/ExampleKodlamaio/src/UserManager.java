public class UserManager {
	
	public void addUser(User user) {
		
		if(user.getPassword() == user.getPasswordVerification()) {
			System.out.println(user.getFullName() +" isimli üye eklenmiştir.");
		}else {
			System.out.println("Girmiş olduğunuz şifreler uyuşmuyor!");
		}
		
	}
	public void addMultipleUser(User[] users) {
		for(User user:users) {
			addUser(user);
		}
	}
	
	public void listUser(User[] users) {
		System.out.println("Üye Listesi");
		System.out.println("**************");
		for(User user : users) {
			System.out.println(user.getFullName());
		}
	}
	
	public void getir() {
		System.out.println("Ortak konfik");
	}

}
