package kodlamaio.hrms.busines.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.concretes.Skill;

public interface SkillService {

	DataResult<List<Skill>> findAll();
	Result add(Skill skill);
	
}
