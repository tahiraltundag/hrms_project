package kodlamaio.hrms.core.utilities.verification.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verification.abstracts.MailVerificationService;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;

@Service
public class MailVerificationManager implements MailVerificationService{

	
	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public MailVerificationManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		
	}
	
	@Override
	public void sendEmail(String firstName) {
		System.out.println(this.jobSeekerDao.findByFirstName(firstName) +"Kullanıcısına dogrulama maili gonderildi");
		
	}

	@Override
	public Result verifyEmail(String email) {
		if(this.jobSeekerDao.getByEmail(email) != null) {
		return new ErrorResult("E-posta adresi sisteme kayıtlı. Baska bir e-posta adresi deneyiniz.");
		}
		return new SuccessResult();
	}

	
}
