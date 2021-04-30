public class User {
	private int id;
	private String fullName;
	private String email;
	private String password;
	private String passwordVerification;
	
	
	public User() {
		
	}
	public User(int id, String fullName, String email, String password, String passwordVerification) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.passwordVerification = passwordVerification;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordVerification() {
		return passwordVerification;
	}
	public void setPasswordVerification(String passwordVerification) {
		this.passwordVerification = passwordVerification;
	}
	
}
