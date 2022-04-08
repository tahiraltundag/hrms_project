package kodlamaio.hrms.busines.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.concretes.Language;

public interface LanguageService {

	DataResult<List<Language>> findAll();
	Result add(Language language);
	
}
