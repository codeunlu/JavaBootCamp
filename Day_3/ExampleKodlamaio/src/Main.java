public class Main {

	public static void main(String[] args) {
		
		// User oluşturuldu 
		User user = new User();
		user.setId(1);
		user.setFullName("Mustafa üNLÜ");
		user.setEmail("mstf_unlu@hotmail.com");
		user.setPassword("12345");
		user.setPasswordVerification("12345");
		
		// Student oluşturuldu 
		Student student = new Student();
		student.setId(1);
		student.setFullName("Hazar Gül");
		student.setEmail("hazargul@hotmail.com");
		student.setPassword("12345");
		student.setPasswordVerification("12345");
		student.setBuyCourses("Java Eğitimi");
		
		// Instructor oluşturuldu 
		Instructor instructor = new Instructor();
		instructor.setId(1);
		instructor.setFullName("Kamil Sulak");
		instructor.setEmail("kamilsulak@hotmail.com");
		instructor.setPassword("12345");
		instructor.setPasswordVerification("12345");
		instructor.setInstructorCourses("Java Eğitimi");
		
		//User manager işlemleri
		UserManager userManager = new UserManager();
		User[] users = {
				user,
				student,
				instructor
		};
		// Üye eklendi
		userManager.addMultipleUser(users);
		System.out.println("*******************");
		
		// Üyeler listelendi
		userManager.listUser(users);
		System.out.println("*******************");
		
		// Student manager işlemleri
		StudentManager studentManager = new StudentManager();
		//Student manager add işlemi
		studentManager.addUser(student);
		studentManager.buyCourse(student);
		
		System.out.println("******************");
		
		// Instructor manager işlemleri
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.addCourse(instructor);
		
	}

}
