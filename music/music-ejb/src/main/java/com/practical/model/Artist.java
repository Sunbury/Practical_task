package com.practical.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Artist
 *
 */
@Entity
@Table(name = "artist")
public class Artist implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Artist() {
		super();
	}
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(max = 30)
	private String name;
   
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dateFound;
	
	@NotNull
	@Size(max = 30)
	private String country;
	
	@OneToMany(mappedBy = "artist")
	private Set<Album> album = new HashSet<Album>();

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

	public Date getDate() {
		return dateFound;
	}

	public void setDate(Date date) {
		this.dateFound = date;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Album> getAlbum() {
		return album;
	}

	public void setAlbum(Set<Album> album) {
		this.album = album;
	}
	
	
}
