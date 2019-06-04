package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import component.BaseEntity;
import entity.pk.MstCityPk;

@Entity
@Table(name="mst_city")
@IdClass(value=MstCityPk.class)
public class MstCity extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="city_code")
	private String cityCode;
	@Column(name="city_name")
	private String cityName;
	@Column(name="province_code")
	private String provinceCode;

	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
}
