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
	
	public Album createAlbum(String name, Date dateRelease, String genre, Artist artist) {
		Album album = new Album();
		album.setName(name);
		album.setDateRelease(dateRelease);
		album.setGenre(genre);
		album.setArtist(artist);
		entityManager.persist(album);
		return album;
	}
	
	public Album updateAlbum(String name, Date dateRelease, String genre, Album album) {
		album.setName(name);
		album.setDateRelease(dateRelease);
		album.setGenre(genre);
		entityManager.merge(album);
		return album;
	}
	
	public int removeAlbum(Album album) {
		entityManager.remove(album);
		return 1;
	}
	
	
}
