package kodlamaio.hrms.busines.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.concretes.JobExperience;

public interface JobExperienceService {
	
	DataResult<List<JobExperience>> findAll();
	Result add(JobExperience jobExperience);
	
	DataResult<List<JobExperience>> findAllByResume_IdOrderByDateOfEnd(int resumeId);
	DataResult<List<JobExperience>> findAllByResume_IdOrderByDateOfEndDesc(int resumeId);
	
}
