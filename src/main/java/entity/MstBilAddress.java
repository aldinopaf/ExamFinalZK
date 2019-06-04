package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import component.BaseEntity;
import entity.enumcol.GenderEnum;
import entity.enumcol.ProductCategoryEnum;
import entity.pk.MstBilAddressPk;


@Entity
@Table(name="mst_biladdress")
@IdClass(value=MstBilAddressPk.class)

public class MstBilAddress extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7865347181874217794L;

	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="address_name")
	private String addressName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="job")
	private String job;
	
	private String username;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
}
