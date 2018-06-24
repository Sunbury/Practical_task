package com.practical.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Album
 *
 */
@Entity
@Table(name = "album")
public class Album implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Album() {
		super();
	}
	
	@Id
	@GeneratedValue
	private Long id;
   
	@NotNull
	@Size(max = 40)
	private String name;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dateRelease;
	
	@NotNull
	@Size(max = 40)
	private String genre;
	
	@ManyToOne
	@JoinColumn(name = "parent_id", nullable = false)
	private Artist artist;
	
	@OneToMany(mappedBy = "album")
	private Set<Song> song = new HashSet<Song>();

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

	public Date getDateRelease() {
		return dateRelease;
	}

	public void setDateRelease(Date dateRelease) {
		this.dateRelease = dateRelease;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	
	
}
