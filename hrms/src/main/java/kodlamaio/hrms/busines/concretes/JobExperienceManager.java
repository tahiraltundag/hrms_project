package kodlamaio.hrms.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.busines.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService{

	private JobExperienceDao jobExperienceDao;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}
	
	@Override
	public DataResult<List<JobExperience>> findAll() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(),"İş Deneyimeleri listelendi");
	}

	@Override
	public Result add(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("İş deneyimi eklendi");
	}

	@Override
	public DataResult<List<JobExperience>> findAllByResume_IdOrderByDateOfEnd(int resumeId) {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAllByResume_IdOrderByDateOfEnd(resumeId),"İş arayanların deneyimleri tarihe gore listelendi");
	}

	@Override
	public DataResult<List<JobExperience>> findAllByResume_IdOrderByDateOfEndDesc(int resumeId) {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAllByResume_IdOrderByDateOfEndDesc(resumeId),"İş arayanların deneyimleri tarihe gore tersten listelendi");
	}

}










