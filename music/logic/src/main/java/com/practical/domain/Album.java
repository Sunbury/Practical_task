package com.practical.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ALBUM_ID")
	private Long id;
   
	@Size(max = 40)
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date dateRelease;
	
	@Size(max = 40)
	private String genre;
	
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "ARTIST_ID", nullable=true)
	private Artist artist;
	
	@OneToMany(mappedBy = "album", cascade = CascadeType.REMOVE, fetch=FetchType.EAGER)
	private List<Song> song;

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

	public List<Song> getSong() {
		return song;
	}

	public void setSong(List<Song> song) {
		this.song = song;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", name=" + name + ", dateRelease=" + dateRelease + ", genre=" + genre + ", artist="
				+ artist + ", song=" + song + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
