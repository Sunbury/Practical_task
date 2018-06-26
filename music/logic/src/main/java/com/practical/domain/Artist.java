package com.practical.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ARTIST_ID")
	private Long id;
	
	@Size(max = 30)
	private String name;
   
	@Temporal(TemporalType.DATE)
	private Date dateFound;
	
	@Size(max = 30)
	private String country;
	
	@OneToMany(mappedBy = "artist")
	private List<Album> album;

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

	public Date getDateFound() {
		return dateFound;
	}

	public void setDateFound(Date dateFound) {
		this.dateFound = dateFound;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Album> getAlbum() {
		return album;
	}

	public void setAlbum(List<Album> album) {
		this.album = album;
	}


	
	
}
