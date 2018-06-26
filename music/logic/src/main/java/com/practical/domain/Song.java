package com.practical.domain;

import java.io.Serializable;
import javax.persistence.*;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SONG_ID")
	private Long id;
	
	@Size(max = 60)
	private String name;
   
	private int number;
	
	@ManyToOne
	@JoinColumn(name = "ALBUM_ID", nullable = false)
	private Album album;

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

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	
}
