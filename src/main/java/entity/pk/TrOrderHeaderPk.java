package entity.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TrOrderHeaderPk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String noNota;

	public TrOrderHeaderPk() {
		// TODO Auto-generated constructor stub
	}
	
	public TrOrderHeaderPk(String noNota) {
		super();
		this.noNota = noNota;
	}

	public String getNoNota() {
		return noNota;
	}

	public void setNoNota(String noNota) {
		this.noNota = noNota;
	}
	
	
	
}
