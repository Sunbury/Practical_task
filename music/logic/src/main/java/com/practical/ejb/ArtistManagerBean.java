package com.practical.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.practical.domain.Artist;

@Stateless
@LocalBean
public class ArtistManagerBean {
	
	@PersistenceContext(unitName = "musicPU")
	private EntityManager entityManager;

	public ArtistManagerBean() {
	}
	
	public Artist createActor() {
		Artist artist = new Artist();
		entityManager.persist(artist);
		return artist;
	}

}
