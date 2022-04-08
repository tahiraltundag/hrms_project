package kodlamaio.hrms.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.busines.abstracts.PhotoService;
import kodlamaio.hrms.busines.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.CloudService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PhotoDao;
import kodlamaio.hrms.entities.entities.concretes.Photo;


@Service
public class PhotoManager implements PhotoService{

	private PhotoDao photoDao;
	private CloudService cloudService;
	ResumeService resumeService;
	
	@Autowired
	public PhotoManager(PhotoDao photoDao,CloudService cloudService,ResumeService resumeService) {
		super();
		this.photoDao = photoDao;
		this.cloudService = cloudService;
		this.resumeService = resumeService;
	}
	
	@Override
	public DataResult<List<Photo>> findAll() {
		return new SuccessDataResult<List<Photo>>(this.photoDao.findAll(),"Fotograflar listelendi");
	}

	@Override
	public Result add(Photo photo,MultipartFile multipartFile) {
		
		var result = this.cloudService.uploadPhoto(multipartFile).getData();
		
		photo.setPhotoUrl(result.get("url"));
		
		this.photoDao.save(photo);
		return new SuccessResult("Fotograf eklendi");
	}

}
