package kodlamaio.hrms.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.busines.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verification.abstracts.MailVerificationService;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	private MernisCheckService mernisCheckService;
	private MailVerificationService mailVerificationService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,
							MernisCheckService mernisCheckService,
							MailVerificationService mailVerificationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisCheckService = mernisCheckService;
		this.mailVerificationService = mailVerificationService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"iş arayanlar listelendi");
	}

	
	public Result isEmailExist(String email) {
		if(this.jobSeekerDao.findByEmail(email) != null) {
			return new ErrorResult("Bu E posta sisteme kayıtlı, lütfen baska bir e posta deneyiniz");
		}
		return new SuccessResult();
	}
	
	
	public Result isNationalityId(String nationalityId) {
		if(this.jobSeekerDao.findByNationalityId(nationalityId) != null) {
			return new ErrorResult("Yanlıs tc kinlik no su girdiniz.");
		}
		return new SuccessResult();
	}

	@Override
	public Result add(JobSeeker jobSeeker) throws Exception {
		
		if(!this.isEmailExist(jobSeeker.getEmail()).isSuccess() || !this.isNationalityId(jobSeeker.getNationalityId()).isSuccess()) {
			return new ErrorResult("Hatalı");
		}
		
		if(!this.mernisCheckService.checkIfRealPerson(jobSeeker).isSuccess()) {
			
			return new ErrorResult("Kişi gecerli degil");
			
			//mernis dogrulaması tamamlanmıstır
		}
		
		if(!this.mailVerificationService.verifyEmail(jobSeeker.getEmail()).isSuccess()) {
			return new ErrorResult("E-postanızı kontrol edin lutfen");
		}
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("iş arayan eklendi");
		
	}
	

}











