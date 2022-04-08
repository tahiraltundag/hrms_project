package kodlamaio.hrms.entities.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import kodlamaio.hrms.core.utilities.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity  //Bu anotasyonla kabaca diyoruz ki bu classımız db’de bir table’ı ifade eder .
@Table(name="employers")      //bu anotasyon da jpa’den gelir ve db’de table’ımızın isminin ne olmasını istediğimizi seçeriz.
public class Employer extends User{

	@Column(name="company_name")   //anotasyonu ile db’deki column’un isminin ne olacağını söyledik yoksa default kendi koyar
	private String companyName;
	
	@Column(name="web_site")
	private String webSite;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@OneToMany(mappedBy="employer")		//iş verenin bircok iş ilanı olabilir ama bir iş ilanının bircok iş vereni olamaz
	private List<JobAdvertisment> jobAdvertisment;  

	public Employer() {
		
	}
	public Employer(String companyName, String webSite, String phoneNumber, List<JobAdvertisment> jobAdvertisment) {
		super();
		this.companyName = companyName;
		this.webSite = webSite;
		this.phoneNumber = phoneNumber;
		this.jobAdvertisment = jobAdvertisment;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<JobAdvertisment> getJobAdvertisment() {
		return jobAdvertisment;
	}
	public void setJobAdvertisment(List<JobAdvertisment> jobAdvertisment) {
		this.jobAdvertisment = jobAdvertisment;
	}
	
}
