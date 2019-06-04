package entity.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MstBilAddressPk implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2647745465798546929L;
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
