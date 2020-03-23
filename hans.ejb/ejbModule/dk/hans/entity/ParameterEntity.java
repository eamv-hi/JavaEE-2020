package dk.hans.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import dk.hans.dto.ParameterDTO;

/**
 * Entity implementation class for Entity: Parameter
 *
 */
@Entity

public class ParameterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	   
	@Id
	private String key;
	private String value;

	public ParameterEntity() {
		super();
	}
	public ParameterEntity(ParameterDTO dto) {
		super();
		this.key = dto.getKey();
		this.value = dto.getValue();
	}
	
	public ParameterDTO toDto() {
		return new ParameterDTO(key, value);
	}
	
	public String getKey() {
		return this.key;
	}
	public void setKey(String key) {
		this.key = key;
	}   
	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Parameter [key=" + key + ", value=" + value + "]";
	}
   
}
