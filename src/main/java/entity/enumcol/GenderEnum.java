package entity.enumcol;

public enum GenderEnum {
	
	MALE("M","Male"),
	FEMALE("F","Female");
	
	private String description;
	private String code;
	
	
	private GenderEnum(String code, String description) {
		this.description = description;
		this.code = code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}
	
	

}
