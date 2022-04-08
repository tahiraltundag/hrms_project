package kodlamaio.hrms.core.utilities.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.utilities.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByEmail(String email);
	
}
