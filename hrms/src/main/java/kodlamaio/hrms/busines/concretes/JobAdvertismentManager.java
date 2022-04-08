package kodlamaio.hrms.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.busines.abstracts.JobAdvertismentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertismentDao;
import kodlamaio.hrms.entities.dtos.JobAdvertismentDto;
import kodlamaio.hrms.entities.entities.concretes.JobAdvertisment;

@Service
public class JobAdvertismentManager implements JobAdvertismentService{

	JobAdvertismentDao jobAdvertismentDao;
	CityDao cityDao;
	EmployerDao employerDao;
	
	@Autowired
	public JobAdvertismentManager(JobAdvertismentDao jobAdvertismentDao, CityDao cityDao, EmployerDao employerDao) {
		super();
		this.jobAdvertismentDao = jobAdvertismentDao;
		this.cityDao = cityDao;
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<JobAdvertisment>> getAll() {
		return new SuccessDataResult<List<JobAdvertisment>>(this.jobAdvertismentDao.findAll(),"İş ilanları listelendi");
	}

	@Override
	public Result add(JobAdvertismentDto jobAdvertismentDto) {
		
		JobAdvertisment jobAdvertisment = new JobAdvertisment();
		jobAdvertisment.setActive(jobAdvertisment.isActive()?true:false); //buna true parametresi geçilebilir ancak swagger kısmında 
		                                                                  //false denemek için boş bıraktım. Bu sayede false atayabildim.
		jobAdvertisment.setMinSalary(jobAdvertismentDto.getMinSalary());
		jobAdvertisment.setMaxSalary(jobAdvertismentDto.getMaxSalary());
		jobAdvertisment.setDescription(jobAdvertismentDto.getDescription());
		jobAdvertisment.setOpenPosition(jobAdvertismentDto.getOpenPosition());
		jobAdvertisment.setApplicationDeadline(jobAdvertismentDto.getApplicationDeadline());
		jobAdvertisment.setReleaseDateTime(jobAdvertismentDto.getReleaseDateTime());
		
		jobAdvertisment.setCity(this.cityDao.findCityById(jobAdvertismentDto.getCityId()));
		jobAdvertisment.setCity(this.cityDao.findCityByCityName(jobAdvertismentDto.getCityName()));
		
		jobAdvertisment.setEmployer(this.employerDao.findEmployerById(jobAdvertismentDto.getEmployerId())); //ileride yazılacak manipülasyonlar 
																									//id üzerinde gerçekleşir.(update, delete gibi)
		jobAdvertisment.setEmployer(this.employerDao.findByCompanyName(jobAdvertismentDto.getCityName()));
		
		this.jobAdvertismentDao.save(jobAdvertisment);
		return new SuccessResult("İş ilanı eklendi");
		
	}

	@Override
	public DataResult<List<JobAdvertisment>> findAllActives() {
		return new SuccessDataResult<List<JobAdvertisment>>(this.jobAdvertismentDao.findAllByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisment>> findAllCompanyNameAndIsActive(String companyName) {
		return new SuccessDataResult<List<JobAdvertisment>>(this.jobAdvertismentDao.findAllByEmployer_CompanyNameAndIsActiveTrue(companyName),"İlanlar listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisment>> findAllByOrderByApplicationDeadlineAsc() {
		return new SuccessDataResult<List<JobAdvertisment>>(this.jobAdvertismentDao.findAllByOrderByApplicationDeadlineAsc(),"İş ilanları tarihe gore listelendi");
	}

}
