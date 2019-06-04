package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import component.BaseEntity;
import entity.pk.MstProvincePk;

@Entity
@Table(name="mst_province")
@IdClass(value=MstProvincePk.class)
public class MstProvince extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="province_code")
	private String provinceCode;
	@Column(name="province_name")
	private String provinceName;

	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
}
