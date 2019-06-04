package entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import component.BaseEntity;
import entity.pk.MstBilAddressDetailPk;
import entity.pk.MstBilAddressPk;

@Entity
@Table(name="mst_BilAddressDetail")
@IdClass(value=MstBilAddressDetailPk.class)
public class MstBilAddressDetail extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7377887040760024335L;

	@Id
	@Column(name="detail_id")
	private String detailId;
	@Column(name="address_name")
	private String addressName;
	@Column(name="postal_code")
	private String postalCode;
	@Column(name="city")
	private String city;
	@Column(name="province")
	private String province;
	@Column(name="home_address")
	private String home_address;
	@Column(name="workAddress")
	private String workAddress;
	
	public MstBilAddressDetail() {
		// TODO Auto-generated constructor stub
	}
	public String getDetailId() {
		return detailId;
	}
	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}
	public String getAddress() {
		return addressName;
	}
	public void setAddress(String addressName) {
		this.addressName = addressName;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getHome_address() {
		return home_address;
	}
	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}
	public String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
}
