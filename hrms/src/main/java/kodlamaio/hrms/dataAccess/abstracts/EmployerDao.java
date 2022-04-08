package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	//findById = bu metot her cagrıldıgında gercekten database gider objeyi oradan getirir. yani emaili getirir
	
	Employer findByEmail(String email);
	Employer findByWebSite(String webSite);
	Employer findByCompanyName(String companyName);
	Employer findEmployerById(int id);
	Employer findEmployerByCompanyName(String companyName);
	
}
