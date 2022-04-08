package kodlamaio.hrms.core.utilities.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapters.abstracts.HrmsCheckService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.entities.concretes.Employer;

@Service
public class HrmsCheckManager implements HrmsCheckService{

	@Override
	public Result checkIfRealPerson(Employer employer) throws Exception {
		return new SuccessResult();
	}

}
