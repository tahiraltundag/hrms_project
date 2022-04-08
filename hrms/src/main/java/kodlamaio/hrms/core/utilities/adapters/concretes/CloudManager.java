package kodlamaio.hrms.core.utilities.adapters.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.adapters.abstracts.CloudService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudManager implements CloudService{

	private final Cloudinary cloudinary;
	
	public CloudManager() {  				//Parametresiz constructor olduğuna dikkat et
		
		Map<String,String> valuesMap = new HashMap<String,String>();
		valuesMap.put("cloud_name", "di8nuoc05");
		valuesMap.put("api_key", "392461483616474");
		valuesMap.put("api_secret", "WTTr-TQy20uUK0vZKhsTsMu0zJE");
		
		cloudinary = new Cloudinary(valuesMap);
		
	}
	
	@Override
	public DataResult<Map<String, String>> uploadPhoto(MultipartFile multipartFile) {
		
		File file;
		
		try {
			file = convert(multipartFile);
			
			@SuppressWarnings("unchecked")
			Map<String,String> result = this.cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			file.delete();
			
			return new SuccessDataResult<>(result);
		}
		catch (IOException e) {
			
			e.printStackTrace();
			
			return new ErrorDataResult<>("Dosya yukelenemiyor");
		}
		
	}
	
	private File convert(MultipartFile multipartFile) throws IOException{
		
		File file = new File(multipartFile.getOriginalFilename());
		
		FileOutputStream stream = new FileOutputStream(file);
		stream.write(multipartFile.getBytes());
		stream.close();
		
		return file;
		
	}

}











