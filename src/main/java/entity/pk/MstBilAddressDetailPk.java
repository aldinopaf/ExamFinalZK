package entity.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MstBilAddressDetailPk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2720306797018779237L;

	private String detailId;

	public MstBilAddressDetailPk(String detailId) {
		this.detailId = detailId;
	}
	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}
}
