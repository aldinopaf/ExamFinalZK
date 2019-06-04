package entity.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TrOrderDetailPk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String detailId;
	
	public TrOrderDetailPk() {
		// TODO Auto-generated constructor stub
	}
	
	public TrOrderDetailPk(String detailId) {
		this.detailId = detailId;
	}

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

}
