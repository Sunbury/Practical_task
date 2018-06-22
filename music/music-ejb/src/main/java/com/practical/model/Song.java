package com.practical.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Song
 *
 */
@Entity
@Table(name = "song")
public class Song implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Song() {
		super();
	}
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(max = 60)
	private String name;
   
	@NotNull
	private int number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}
