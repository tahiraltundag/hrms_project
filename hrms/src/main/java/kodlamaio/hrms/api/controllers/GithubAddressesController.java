package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.busines.abstracts.GithubAddressService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.concretes.GithubAddress;

@RestController
@RequestMapping("/api/githubaddresses")
public class GithubAddressesController {

	private GithubAddressService githubAddressService;
	
	@Autowired
	public GithubAddressesController(GithubAddressService githubAddressService) {
		super();
		this.githubAddressService = githubAddressService;
	}
	
	@GetMapping("/findall")
	public DataResult<List<GithubAddress>> findAll(){
		return this.githubAddressService.findAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody GithubAddress githubAddress) {
		return this.githubAddressService.add(githubAddress);
	}
	
}
