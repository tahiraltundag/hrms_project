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
@Table(name="schools")
public class School {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="education_start_date")
	private LocalDate educationStartDate;
	
	@Column(name="is_graduate")
	private boolean isGraduate;
	
	@Column(name="graduate_date")
	private LocalDate graduateDate;
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;

	public School() {
		super();
	}

	public School(int id, String schoolName, String departmentName, LocalDate educationStartDate, boolean isGraduate,
			LocalDate graduateDate, Resume resume) {
		super();
		this.id = id;
		this.schoolName = schoolName;
		this.departmentName = departmentName;
		this.educationStartDate = educationStartDate;
		this.isGraduate = isGraduate;
		this.graduateDate = graduateDate;
		this.resume = resume;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public LocalDate getEducationStartDate() {
		return educationStartDate;
	}

	public void setEducationStartDate(LocalDate educationStartDate) {
		this.educationStartDate = educationStartDate;
	}

	public boolean isGraduate() {
		return isGraduate;
	}

	public void setGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}

	public LocalDate getGraduateDate() {
		return graduateDate;
	}

	public void setGraduateDate(LocalDate graduateDate) {
		this.graduateDate = graduateDate;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
	
	
}
