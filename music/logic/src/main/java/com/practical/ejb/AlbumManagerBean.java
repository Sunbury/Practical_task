package com.practical.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.practical.domain.Album;

@Stateless
@LocalBean
public class AlbumManagerBean {

	@PersistenceContext(unitName = "musicPU")
	private EntityManager entityManager;
	
	public Album createAlbum() {
		Album album = new Album();
		entityManager.persist(album);
		return album;
	}
}
