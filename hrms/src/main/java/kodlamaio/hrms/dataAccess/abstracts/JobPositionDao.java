package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	
	JobPosition findById(int id);
	JobPosition findByTitles(String titles);
	List<JobPosition> getByIdAndTitles(int id,String titles);

}
