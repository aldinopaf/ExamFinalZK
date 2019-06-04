package entity.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MstDepartmentPk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7576341279877475712L;
	private Integer id;
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return this.id;
	}
	
}
