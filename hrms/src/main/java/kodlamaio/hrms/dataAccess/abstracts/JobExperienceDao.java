package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>{

	List<JobExperience> findAllByResume_IdOrderByDateOfEnd(int resumeId);
	
	List<JobExperience> findAllByResume_IdOrderByDateOfEndDesc(int resumeId);
	
}
