public class StudentManager extends UserManager{
	public void buyCourse(Student user) {
		System.out.println("Merhaba " + user.getFullName() + ", "+ user.getBuyCourses() + " isimli kursu satın aldın!");		
	}
	
}
