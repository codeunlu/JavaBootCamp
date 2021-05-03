package Abstract;

// İmportlar 
import Entities.User;

public interface UserCheckService {
	boolean checkIfRealUser(User user);
}
