package com.practical;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.practical.domain.Album;
import com.practical.domain.Artist;
import com.practical.domain.Song;
import com.practical.ejb.AlbumDAO;
import com.practical.ejb.ArtistDAO;
import com.practical.ejb.SongDAO;

@Named
@RequestScoped
public class OperationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Artist artist = new Artist(); 

	@EJB
	ArtistDAO artistDAO;
	@EJB
	AlbumDAO albumDAO;
	@EJB
	SongDAO songDAO;
	
	
	public void addArtist(){
		artistDAO.create(artist);
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
}
