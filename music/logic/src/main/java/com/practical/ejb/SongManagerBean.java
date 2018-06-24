package com.practical.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.practical.domain.Song;

@Stateless
@LocalBean
public class SongManagerBean {

	@PersistenceContext(unitName = "musicPU")
	private EntityManager entityManager;
	
	public Song createSong() {
		Song song = new Song();
		entityManager.persist(song);
		return song;
	}
}
