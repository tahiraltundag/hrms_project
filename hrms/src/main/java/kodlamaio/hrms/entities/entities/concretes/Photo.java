package kodlamaio.hrms.entities.entities.concretes;

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
@Table(name="photos")
public class Photo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="photo_url")
	private String photoUrl;
	
	
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;



	public Photo() {
		super();
	}



	public Photo(int id, String photoUrl, Resume resume) {
		super();
		this.id = id;
		this.photoUrl = photoUrl;
		this.resume = resume;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getPhotoUrl() {
		return photoUrl;
	}



	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}



	public Resume getResume() {
		return resume;
	}



	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
	
	
}
