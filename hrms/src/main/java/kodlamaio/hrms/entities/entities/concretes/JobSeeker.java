package kodlamaio.hrms.entities.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import kodlamaio.hrms.core.utilities.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity     //Bu anotasyonla kabaca diyoruz ki bu classımız db’de bir table’ı ifade eder .
@Table(name="job_seekers")     //bu anotasyon da jpa’den gelir ve db’de table’ımızın isminin ne olmasını istediğimizi seçeriz.
public class JobSeeker extends User{
	
	@Column(name="first_name")    //anotasyonu ile db’deki column’un isminin ne olacağını söyledik yoksa default kendi koyar
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nationality_id")
	private String nationalityId;
	
	@Column(name="birth_of_year")
	private String birthOfYear;

	public JobSeeker() {
		
	}
	public JobSeeker(String firstName, String lastName, String nationalityId, String birthOfYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.birthOfYear = birthOfYear;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(String nationalityId) {
		this.nationalityId = nationalityId;
	}

	public String getBirthOfYear() {
		return birthOfYear;
	}

	public void setBirthOfYear(String birthOfYear) {
		this.birthOfYear = birthOfYear;
	}
	
 
}
