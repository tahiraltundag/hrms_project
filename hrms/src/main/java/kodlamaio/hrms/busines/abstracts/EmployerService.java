package kodlamaio.hrms.busines.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	Result isEmailExist(String email);
	Result add(Employer employer) throws Exception;
}
