package kodlamaio.hrms.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.busines.abstracts.LinkedinAddressService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LinkedinAddressDao;
import kodlamaio.hrms.entities.entities.concretes.LinkedinAddress;

@Service
public class LinkedinAddressManager implements LinkedinAddressService{

	private LinkedinAddressDao linkedinAddressDao;
	
	@Autowired
	public LinkedinAddressManager(LinkedinAddressDao linkedinAddressDao) {
		super();
		this.linkedinAddressDao = linkedinAddressDao;
	}
	
	@Override
	public DataResult<List<LinkedinAddress>> findAll() {
		return new SuccessDataResult<List<LinkedinAddress>>(this.linkedinAddressDao.findAll(),"Linkedin Adresleri listelendi");
	}

	@Override
	public Result add(LinkedinAddress linkedinAddress) {
		this.linkedinAddressDao.save(linkedinAddress);
		return new SuccessResult("Linkedin Adresi sisteme eklendi");
	}

}
