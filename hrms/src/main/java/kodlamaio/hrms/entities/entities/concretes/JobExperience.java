package kodlamaio.hrms.entities.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_experience")
public class JobExperience {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_experience_id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="job_position")
	private String jobPosition;
	
	@Column(name="date_of_start")
	private LocalDate dateOfStart;
	
	@Column(name="is_leave")
	private boolean isLeave;
	
	@Column(name="date_of_end")
	private LocalDate dateOfEnd;

	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;

	public JobExperience() {
		super();
	}

	public JobExperience(int id, String companyName, String jobPosition, LocalDate dateOfStart, boolean isLeave,
			LocalDate dateOfEnd, Resume resume) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.jobPosition = jobPosition;
		this.dateOfStart = dateOfStart;
		this.isLeave = isLeave;
		this.dateOfEnd = dateOfEnd;
		this.resume = resume;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}

	public LocalDate getDateOfStart() {
		return dateOfStart;
	}

	public void setDateOfStart(LocalDate dateOfStart) {
		this.dateOfStart = dateOfStart;
	}

	public boolean isLeave() {
		return isLeave;
	}

	public void setLeave(boolean isLeave) {
		this.isLeave = isLeave;
	}

	public LocalDate getDateOfEnd() {
		return dateOfEnd;
	}

	public void setDateOfEnd(LocalDate dateOfEnd) {
		this.dateOfEnd = dateOfEnd;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
	
	
	
}
