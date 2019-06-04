package entity.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class MstUserPk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7576341279877475712L;
	
	private String id;
	
	public MstUserPk() {
		// TODO Auto-generated constructor stub
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return this.id;
	}
	
}
