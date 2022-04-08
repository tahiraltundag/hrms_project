package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.busines.abstracts.UserService;
import kodlamaio.hrms.core.utilities.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping(value="/api/users")
public class UsersController {   //playground için yazıldı
	
	UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping(value="/getall")
	public DataResult<User> findByEmail(String email){
		return this.userService.findByEmail(email);
	}
	
	@PostMapping(value="/add")
	public Result add(@RequestBody User user) {
		return this.userService.add(user);
	}

}
