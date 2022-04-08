package kodlamaio.hrms.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.busines.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"İş Pozisyonları listelendi");
	}

	@Override
	public Result isJobPositionExist(String titles) {
		if(this.jobPositionDao.findByTitles(titles) != null) {
			return new ErrorResult("Bu iş pozisyonu daha once sisteme eklenmiş. Lutfen başka bir iş pozisyonu ekleyiniz.");
		}
		return new SuccessResult();
	}
	
	@Override
	public Result add(JobPosition jobPosition) {
		if(!this.isJobPositionExist(jobPosition.getTitles()).isSuccess()) {
			return new ErrorResult("Bu iş pozisyonu zaten var");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu sisteme kaydedildi");
	}

}





