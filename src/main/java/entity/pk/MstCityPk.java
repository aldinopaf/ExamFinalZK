package entity.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MstCityPk  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cityCode;
	
	public MstCityPk() {
		// TODO Auto-generated constructor stub
	}
	
	public MstCityPk(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

}
