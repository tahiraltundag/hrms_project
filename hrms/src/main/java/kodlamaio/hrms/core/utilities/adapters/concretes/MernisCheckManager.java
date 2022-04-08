package kodlamaio.hrms.core.utilities.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapters.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.entities.concretes.JobSeeker;

@Service
public class MernisCheckManager implements MernisCheckService{

	@Override
	public Result checkIfRealPerson(JobSeeker jobSeeker) throws Exception {
		return new SuccessResult();
	}

}
