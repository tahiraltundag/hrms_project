package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{
	//findById = bu metot her cagrıldıgında gercekten database gider objeyi oradan getirir. yani emaili getirir
	
	JobSeeker getByEmail(String email);
	JobSeeker getByNationalityId(String nationalityId);
	JobSeeker findByEmail(String email);
	JobSeeker findByNationalityId(String nationalityId);
	
	//iş arayanlar listelensin ve bu liste isime gore ve tc kimlik numarasına gore olsun
	List<JobSeeker> getByFirstNameAndNationalityId(String firstName,int nationalityId);
	JobSeeker findByFirstName(String firstName);
	
}
