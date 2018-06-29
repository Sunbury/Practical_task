package com.practical;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.practical.domain.Artist;
import com.practical.ejb.ArtistDAO;

@Named
@RequestScoped
public class RemoveBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Artist artist;
	
	@EJB
	ArtistDAO artistDAO;
	
	public void removeArtist() {
		artistDAO.remove(artist);
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
}
