package com.practical.ejb;

import java.util.Date;

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
	
	public Artist createArtist(String name, Date date, String country) {
		Artist artist = new Artist();
		artist.setName(name);
		artist.setDate(date);
		artist.setCountry(country);
		entityManager.persist(artist);
		return artist;
	}
	
	public Artist updateArtist (String name, Date date, String country, Artist artist) {
		artist.setName(name);
		artist.setDate(date);
		artist.setCountry(country);
		entityManager.merge(artist);
		return artist;
	}
	
	public int removeArtist (Artist artist) {
		entityManager.remove(artist);
		return 1;
	}

}
