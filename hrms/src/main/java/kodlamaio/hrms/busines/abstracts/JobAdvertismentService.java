package kodlamaio.hrms.busines.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.JobAdvertismentDto;
import kodlamaio.hrms.entities.entities.concretes.JobAdvertisment;

public interface JobAdvertismentService {

	DataResult<List<JobAdvertisment>> getAll();
	Result add(JobAdvertismentDto jobAdvertismentDto);
	
	DataResult<List<JobAdvertisment>> findAllActives();   //iş ilanlarının data sonucunu listele, aktif olanlarının hepsini bul
	
	DataResult<List<JobAdvertisment>> findAllCompanyNameAndIsActive(String companyName); //bir şirkete ait aktif olan tum iş ilanlarını bul
	
	DataResult<List<JobAdvertisment>> findAllByOrderByApplicationDeadlineAsc();  //tüm aktif iş ilanlarını tarihe gore listele
																				  //siparişlerin(binevi iş ilanları) son başvuru 
																				  //tarihlerini listele 
	 
	
}
