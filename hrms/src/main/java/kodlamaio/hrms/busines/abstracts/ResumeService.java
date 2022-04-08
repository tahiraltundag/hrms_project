package kodlamaio.hrms.busines.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.concretes.Resume;

public interface ResumeService {

	DataResult<List<Resume>> findAll();
	Result add(Resume resume);
	
	DataResult<List<Resume>> findById(int id);
	
}
