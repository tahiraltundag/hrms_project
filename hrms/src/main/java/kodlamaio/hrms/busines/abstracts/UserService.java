package kodlamaio.hrms.busines.abstracts;

import kodlamaio.hrms.core.utilities.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

public interface UserService {

	Result add(User user);
	DataResult<User> findByEmail(String email);
}
