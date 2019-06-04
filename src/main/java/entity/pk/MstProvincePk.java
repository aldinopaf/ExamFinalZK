package entity.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MstProvincePk  implements Serializable{

	private static final long serialVersionUID = 1L;

	private String provinceCode;
	
	public MstProvincePk() {
		// TODO Auto-generated constructor stub
	}
	public MstProvincePk(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

}
