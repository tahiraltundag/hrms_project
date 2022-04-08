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
import kodlamaio.hrms.busines.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {

	private SchoolService schoolService;
	
	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@GetMapping("/findAll")
	public DataResult<List<School>> findAll(){
		return this.schoolService.findAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}
	
	@GetMapping("/findallbyresumeidgraduatedate")
	public DataResult<List<School>> findAllByResume_IdOrderByGraduateDate(@RequestParam int resumeId){
		return this.schoolService.findAllByResume_IdOrderByGraduateDate(resumeId);
	}
	
	@GetMapping("/findallbyresumeidgraduatedatedesc")
	public DataResult<List<School>> findAllByResume_IdOrderByGraduateDateDesc(@RequestParam int resumeId,@RequestParam Direction direction){
		return this.schoolService.findAllByResume_IdOrderByGraduateDateDesc(resumeId, direction);
	}
}










