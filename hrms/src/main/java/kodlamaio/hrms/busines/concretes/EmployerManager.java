package kodlamaio.hrms.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.busines.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.HrmsCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verification.abstracts.MailVerificationService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	EmployerDao employerDao;
	MailVerificationService mailVerificationService;
	HrmsCheckService hrmsCheckService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,
								MailVerificationService mailVerificationService,
								HrmsCheckService hrmsCheckService) {
		super();
		this.employerDao = employerDao;
		this.mailVerificationService = mailVerificationService;
		this.hrmsCheckService = hrmsCheckService;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listelendi");
	}
	/*
	tanım 1:
	ilk basta method isminden de anlasılacagı üzere sistemde benim suan girecegim email var mı? diyor ve bunu kontrol ediyoruz.
	burada employerDao ya git emaili bul diyor. hangi email? kullanıcının girecegi email oda findByEmil(email) buraya
	yazıyoruz gidip emaili bulursa eger sonuc basarısız oluyor yani girilen emailin null a esit olması gerekir ve biz
	burada girilen email null a esit degilse diyoruz yani girilen mailin birebir aynısı varsa hata verecektir ama 
	null olsaydı yani null bos demek oyle bir deger yok demek yani girilen email yoksa, benzersiz bir email girilmis demektir 
	bu sarttan gecmis olur islem basarılı olur.
	
	tanım 2:
	ilk olarak bir işlem sonucunu kontrol edecegimiz icin mothodun dondurecegi deger Result yani sonuc. method ismi ise yapacagımız ise gore
	kendimiz belirliyoruz. isEmailExist = yani girilecek email sistemde var mı? kayıtlı mı? diye kontrol edecegiz ve parametre olarak kulla-
	nıcının girecegi seyin tanımını yazıyoruz tanımı onune ise o yazılacak seyin integer degerinde mi string degerinde mi yoksa baska bir 
	formatta mı olacagını belirtiyoruz.
	
	ikinci olarak if koşulu yazıyoruz çünkü şartlar dogruyas ne yanlışa ne yapacagını belirlemek icin.
	
	ücüncü olarak if koşulu icine employerDao interface sinin findByEmail methodunu calıstır diyoruz ne icin kullanıcını girecegi email(email)
	icin ve != işeretini kullanıyoruz bu işaret eşit degilse anlamına geliyor. null ise boş demek olmayan demek. yani diyoruz ki kullanıcının
	girecegi email bos degil ise yani girdigi mail sisteme daha once kaydedilmiş ise if in icine gir demek oluyor buda email daha once siste-
	me kayıt edildigi anlamına geliyor. eger ki null a eşit ise de daha once boyle bir e posta girilmemiş ve sisteme kaydedilmemiş yani bun-
	un sonunda islem basarılı diyip sisteme uyarı gonderecek.
	 
	*/
	@Override
	public Result isEmailExist(String email) {
		if(this.employerDao.findByEmail(email) != null) {
			return new ErrorResult("Bu E-posta sisteme kayıtlı, lütfen baska bir E-posta deneyiniz");
		}
		return new SuccessResult();
	}
	
	/*
	burada iş vereni sisteme kaydetmemiz gerekiyor ve tüm şartlar başarılıysa iş vereni sisteme kaydediyoruz.
	
	ilk if: burada yukarıda kontrolünü sagladıgımız metodun sorgusunu yapacagız. ! = değil , this = calıstırmak demek isEmailExist ise yu-
	karıdaki method demek yani yukarıdaki methodu calıstırıyoruz ve parantez icinde employer.getEmail() yazıyoruz buda iş verenin emailini
	getir demek ve parantezi kapatıp nokta isSuccess() = başarılı mı? demek. yani yukarıdaki methodu cagırdıgımız zaman bu metodun sonucu 
	basarılımı diyoruz ilk basta this in önünde yazan ünlem işareti ise bu sorguya şu anlamı getiriyor: bu işlem başarılı degil ise 
	ErrorResult(); bu methodu calıstır diyoruz ve bir sonraki sorguya geciyoruz. tum sorguları basarılı oldugu taktirde kullanıcı sisteme 
	kaydedilecek
	
	ikinci if: burada hrmsCheckService interface inin checkIfRealPerson methodu başarılı mı? diyoruz kim için iş veren için tabi baştaki
	ünlemi ekleyince bu method başarılı degil ise if in icindeki methodu calıstır basarılıysa sorun yok bir sonraki if e gecer.
	
	ücüncü if: burada mailVerificationService interface inin verifyMail metodu başarılı mı? diyoruz kim için iş verenin mail adresi için
	tabi bastaki ünlemi ekleyice bu metod başarılı degil ise if in icindeki metodu calıstır, basarılıysa sorun yok bir sonfraki işleme gecer
	
	son iki satırda yazan kod ise tüm şartlar başarılıysa employerDao yu calıstır ve sisteme kaydet kimi iş vereni ve sonra tüm if koşullarını 
	gectigi icin SuccessResult(); methodunu calıstır ve mesajı ver
	
	*/
	@Override
	public Result add(Employer employer) throws Exception {
		if(!this.isEmailExist(employer.getEmail()).isSuccess()) {
			return new ErrorResult("E-posta zaten var");
		}
		
		if(!this.hrmsCheckService.checkIfRealPerson(employer).isSuccess()) {
			return new ErrorResult("İş veren HRMS personelinden onaylanmadı");
		}
		
		if(!this.mailVerificationService.verifyEmail(employer.getEmail()).isSuccess()) {
			return new ErrorResult("E-postanızı kontrol edin lutfen");
		}
		this.employerDao.save(employer);
		return new SuccessResult("İş veren sisteme kaydedildi");
	}

}




