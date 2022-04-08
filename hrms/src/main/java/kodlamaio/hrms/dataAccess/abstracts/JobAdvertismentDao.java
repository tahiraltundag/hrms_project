package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.entities.concretes.JobAdvertisment;

public interface JobAdvertismentDao extends JpaRepository<JobAdvertisment, Integer>{

	//aktif iş ilanları
	List<JobAdvertisment> findAllByIsActiveTrue();  //aktif olanların tumunu bul ve listele
	
	//Bir firmaya ait tum aktif iş ilanları listelenebilmelidir.
	List<JobAdvertisment> findAllByEmployer_CompanyNameAndIsActiveTrue(@Param("companyName") String companyName);
	
	List<JobAdvertisment> findAllByOrderByApplicationDeadlineAsc();
	
}
