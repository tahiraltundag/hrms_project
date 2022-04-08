package kodlamaio.hrms.core.utilities.adapters.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.concretes.Employer;

public interface HrmsCheckService {
	Result checkIfRealPerson(Employer employer) throws Exception;
}
