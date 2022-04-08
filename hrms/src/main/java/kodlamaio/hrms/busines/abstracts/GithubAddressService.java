package kodlamaio.hrms.busines.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.concretes.GithubAddress;

public interface GithubAddressService {

	DataResult<List<GithubAddress>> findAll();
	Result add(GithubAddress githubAddress);
	
}
