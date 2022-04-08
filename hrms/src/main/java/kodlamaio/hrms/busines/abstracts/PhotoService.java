package kodlamaio.hrms.busines.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.concretes.Photo;

public interface PhotoService {

	DataResult<List<Photo>> findAll();
	Result add(Photo photo,MultipartFile multipartFile);
	
}
