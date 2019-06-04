package entity.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

import entity.MstCity;

@Embeddable
public class MstEmployeePk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 582960602268862421L;
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
