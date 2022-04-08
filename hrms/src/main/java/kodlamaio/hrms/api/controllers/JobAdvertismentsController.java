package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.busines.abstracts.JobAdvertismentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.JobAdvertismentDto;
import kodlamaio.hrms.entities.entities.concretes.JobAdvertisment;

@RestController
@RequestMapping("/api/jobadvertisments")
public class JobAdvertismentsController {

	private JobAdvertismentService jobAdvertismentService;
	
	@Autowired
	public JobAdvertismentsController(JobAdvertismentService jobAdvertismentService) {
		super();
		this.jobAdvertismentService = jobAdvertismentService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisment>> getAll(){
		return this.jobAdvertismentService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertismentDto jobAdvertismentDto) {
		return this.jobAdvertismentService.add(jobAdvertismentDto);
	}
	
	@GetMapping("/findAllActives")
	public DataResult<List<JobAdvertisment>> findAllActives(){
		return this.jobAdvertismentService.findAllActives();
	}
	
	@GetMapping("/findAllCompanyNameAndIsActive")
	public DataResult<List<JobAdvertisment>> findAllCompanyNameAndIsActive(@RequestParam("companyName") String companyName){
		return this.jobAdvertismentService.findAllCompanyNameAndIsActive(companyName);
	}
	
	@GetMapping("/findAllOrderByApplicationDeadlineAsc")
	public DataResult<List<JobAdvertisment>> findAllOrderByApplicationDeadlineAsc(){
		return this.jobAdvertismentService.findAllByOrderByApplicationDeadlineAsc();
	}
	
}







