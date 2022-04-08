package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.entities.concretes.LinkedinAddress;

public interface LinkedinAddressDao extends JpaRepository<LinkedinAddress, Integer>{

}
