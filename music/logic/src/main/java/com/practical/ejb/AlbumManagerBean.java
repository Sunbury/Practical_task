package com.practical.ejb;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.practical.domain.Album;
import com.practical.domain.Artist;

@Stateless
@LocalBean
public class AlbumManagerBean {

	@PersistenceContext(unitName = "musicPU")
	private EntityManager entityManager;
	


	public Album create(Album album, String name, Date dateRelease, String genre, Artist artist) {
		album.setName(name);
		album.setDateRelease(dateRelease);
		album.setGenre(genre);
		album.setArtist(artist);
		return album;
	}

	public Album update(Album album, String name, Date dateRelease, String genre) {
		album.setName(name);
		album.setDateRelease(dateRelease);
		album.setGenre(genre);
		return album;
	}

	public int remove(Album album) {
		// TODO Auto-generated method stub
		return 1;
	}

	public Album read() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
