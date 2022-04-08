package kodlamaio.hrms.entities.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employers","cities","job_advertisments","jobAdvertisments"})
@Table(name="cities")
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="city_name")
	private String cityName;
	
	@Column(name="contry_name")
	private String contryName;
	
	@OneToMany(mappedBy="city")		//bir şehirde bircok iş ilanı olabilir ama bir iş ilanı bircok sehirde olamaz
	private List<JobAdvertisment> jobAdvertisment;

	public City() {
		super();
	}

	public City(int id, String cityName, String contryName, List<JobAdvertisment> jobAdvertisment) {
		super();
		this.id = id;
		this.cityName = cityName;
		this.contryName = contryName;
		this.jobAdvertisment = jobAdvertisment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getContryName() {
		return contryName;
	}

	public void setContryName(String contryName) {
		this.contryName = contryName;
	}

	public List<JobAdvertisment> getJobAdvertisment() {
		return jobAdvertisment;
	}

	public void setJobAdvertisment(List<JobAdvertisment> jobAdvertisment) {
		this.jobAdvertisment = jobAdvertisment;
	}

	
	
}
