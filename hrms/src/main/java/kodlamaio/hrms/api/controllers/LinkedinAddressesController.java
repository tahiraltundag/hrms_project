package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.busines.abstracts.LinkedinAddressService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.concretes.LinkedinAddress;

@RestController
@RequestMapping("/api/linkedinaddresses")
public class LinkedinAddressesController {

	private LinkedinAddressService linkedinAddressService;
	
	@Autowired
	public LinkedinAddressesController(LinkedinAddressService linkedinAddressService) {
		super();
		this.linkedinAddressService = linkedinAddressService;
	}
	
	@GetMapping("/findall")
	public DataResult<List<LinkedinAddress>> findAll(){
		return this.linkedinAddressService.findAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody LinkedinAddress linkedinAddress) {
		return this.linkedinAddressService.add(linkedinAddress);
	}
	
}
