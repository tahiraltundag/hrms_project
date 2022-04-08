package kodlamaio.hrms.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.busines.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService{

	private ResumeDao resumeDao;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao) {
		super();
		this.resumeDao = resumeDao;
	}
	
	@Override
	public DataResult<List<Resume>> findAll() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(),"Öz geçmişler listelendi");
	}

	@Override
	public Result add(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("Özgeçmiş sisteme kaydedildi");
	}

	@Override
	public DataResult<List<Resume>> findById(int id) {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAllById(id));
	}

}





