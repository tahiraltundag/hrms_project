package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.busines.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/jobexperiences")
public class JobExperiencesController {

	private JobExperienceService jobExperienceService;
	
	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@GetMapping("/findall")
	public DataResult<List<JobExperience>> findAll(){
		return this.jobExperienceService.findAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.add(jobExperience);
	}
	
	@GetMapping("/findallbyresumeiddateofend")
	public DataResult<List<JobExperience>> findAllByResume_IdOrderByDateOfEnd(@RequestParam int resumeId){
		return this.findAllByResume_IdOrderByDateOfEnd(resumeId);
	}
	
	@GetMapping("/findallbyresumeiddateofenddesc")
	public DataResult<List<JobExperience>> findAllByResume_IdOrderDateOfEndDesc(@RequestParam int resumeId,@RequestParam Direction direction){
		return this.findAllByResume_IdOrderDateOfEndDesc(resumeId,direction);
	}
	
}








