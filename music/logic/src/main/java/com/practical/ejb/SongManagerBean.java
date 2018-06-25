package com.practical.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.practical.domain.Album;
import com.practical.domain.Song;

@Stateless
@LocalBean
public class SongManagerBean {

	@PersistenceContext(unitName = "musicPU")
	private EntityManager entityManager;
	
	public Song createSong(String name, int number, Album album) {
		Song song = new Song();
		song.setName(name);
		song.setNumber(number);
		song.setAlbum(album);
		entityManager.persist(song);
		return song;
	}
	
	public Song updateSong(String name, int number, Song song) {
		song.setName(name);
		song.setNumber(number);
		entityManager.merge(song);
		return song;
	}
	
	public int removeSong(Song song) {
		entityManager.remove(song);
		return 1;
	}
}
