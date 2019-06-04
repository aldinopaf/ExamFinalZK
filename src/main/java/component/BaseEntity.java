package component;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
	
	@Column(name="created_date")
	private Date createdDate;// = LocalDateTime.now();
	@Column(name="created_user")
	private String createdUser;
	@Column(name="updated_date")
	private Date updatedDate;
	@Column(name="updated_user")
	private String updatedUser;
	@Column(name="deleted")
	private Boolean deleted = false;
	

//	public abstract void setId(Integer id);
//	public abstract Integer getId();
	
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getUpdatedUser() {
		return updatedUser;
	}
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
//	public LocalDateTime getCreatedDate() {
//		return createdDate;
//	}
//	public void setCreatedDate(LocalDateTime createdDate) {
//		this.createdDate = createdDate;
//	}
//	public LocalDateTime getUpdatedDate() {
//		return updatedDate;
//	}
//	public void setUpdatedDate(LocalDateTime updatedDate) {
//		this.updatedDate = updatedDate;
//	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Boolean getDeleted() {
		return deleted;
	}

}
