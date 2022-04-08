package kodlamaio.hrms.entities.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="resumes")
public class Resume {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	
	
	
	@OneToMany(mappedBy="resume")
	private List<School> school;
	
	@OneToMany(mappedBy="resume")
	private List<JobExperience> jobExperience;
	
	@OneToMany(mappedBy="resume")
	private List<Language> language;
	
	@OneToMany(mappedBy="resume")
	private List<GithubAddress> githubAddress;
	
	@OneToMany(mappedBy="resume")
	private List<LinkedinAddress> linkedinAddress;
	
	@OneToMany(mappedBy="resume")
	private List<Skill> skill;
	
	@OneToMany(mappedBy="resume")
	private List<Photo> photo;

	
	public Resume() {
		super();
	}

	public Resume(int id, String coverLetter, List<School> school, List<JobExperience> jobExperience,
			List<Language> language, List<GithubAddress> githubAddress, List<LinkedinAddress> linkedinAddress,
			List<Skill> skill, List<Photo> photo) {
		super();
		this.id = id;
		this.coverLetter = coverLetter;
		this.school = school;
		this.jobExperience = jobExperience;
		this.language = language;
		this.githubAddress = githubAddress;
		this.linkedinAddress = linkedinAddress;
		this.skill = skill;
		this.photo = photo;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	public List<School> getSchool() {
		return school;
	}

	public void setSchool(List<School> school) {
		this.school = school;
	}

	public List<JobExperience> getJobExperience() {
		return jobExperience;
	}

	public void setJobExperience(List<JobExperience> jobExperience) {
		this.jobExperience = jobExperience;
	}

	public List<Language> getLanguage() {
		return language;
	}

	public void setLanguage(List<Language> language) {
		this.language = language;
	}

	public List<GithubAddress> getGithubAddress() {
		return githubAddress;
	}

	public void setGithubAddress(List<GithubAddress> githubAddress) {
		this.githubAddress = githubAddress;
	}

	public List<LinkedinAddress> getLinkedinAddress() {
		return linkedinAddress;
	}

	public void setLinkedinAddress(List<LinkedinAddress> linkedinAddress) {
		this.linkedinAddress = linkedinAddress;
	}

	public List<Skill> getSkill() {
		return skill;
	}

	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}

	public List<Photo> getPhoto() {
		return photo;
	}

	public void setPhoto(List<Photo> photo) {
		this.photo = photo;
	}
	
	
	
}





