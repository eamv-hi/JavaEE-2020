package dk.hans.dto;

import java.io.Serializable;

public class ParameterDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String key;
	private String value;
	
	public ParameterDTO() {
		super();
	}
	
	public ParameterDTO(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "ParameterDTO [key=" + key + ", value=" + value + "]";
	}
	

}
