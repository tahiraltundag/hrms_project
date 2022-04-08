package kodlamaio.hrms.busines.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.concretes.LinkedinAddress;

public interface LinkedinAddressService {

	DataResult<List<LinkedinAddress>> findAll();
	Result add(LinkedinAddress linkedinAddress);
	
}
