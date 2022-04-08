package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.entities.concretes.GithubAddress;

public interface GithubAddressDao extends JpaRepository<GithubAddress, Integer>{

}
