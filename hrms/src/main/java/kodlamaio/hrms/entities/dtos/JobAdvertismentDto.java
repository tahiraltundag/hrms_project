package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertismentDto {

	private int id;
	private int cityId;
	private int employerId;
	private String description;
	private String cityName;
	private int minSalary;
	private int maxSalary;
	private String companyName;
	private Date applicationDeadline;
	private int openPosition;
	private boolean isActive;
	private LocalDateTime releaseDateTime = LocalDateTime.now();
	
	public JobAdvertismentDto() {
		
	}
	
	public JobAdvertismentDto(int id, int cityId, int employerId, String description, String cityName, int minSalary,
			int maxSalary, String companyName, Date applicationDeadline, int openPosition, boolean isActive,
			LocalDateTime releaseDateTime) {
		super();
		this.id = id;
		this.cityId = cityId;
		this.employerId = employerId;
		this.description = description;
		this.cityName = cityName;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.companyName = companyName;
		this.applicationDeadline = applicationDeadline;
		this.openPosition = openPosition;
		this.isActive = isActive;
		this.releaseDateTime = releaseDateTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getEmployerId() {
		return employerId;
	}
	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}
	public int getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Date getApplicationDeadline() {
		return applicationDeadline;
	}
	public void setApplicationDeadline(Date applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}
	public int getOpenPosition() {
		return openPosition;
	}
	public void setOpenPosition(int openPosition) {
		this.openPosition = openPosition;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public LocalDateTime getReleaseDateTime() {
		return releaseDateTime;
	}
	public void setReleaseDateTime(LocalDateTime releaseDateTime) {
		this.releaseDateTime = releaseDateTime;
	}
	
	
}
