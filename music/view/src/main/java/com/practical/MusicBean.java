package com.practical;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.practical.domain.Album;
import com.practical.domain.Artist;
import com.practical.domain.Song;
import com.practical.ejb.AlbumDAO;
import com.practical.ejb.ArtistDAO;
import com.practical.ejb.SongDAO;

@Named
@SessionScoped
public class MusicBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Artist> artists = new ArrayList<>();
	private List<Album> albums = new ArrayList<>();
	private List<Song> songs = new ArrayList<>();
	
	@EJB
	ArtistDAO artistDAO;
	@EJB
	AlbumDAO albumDAO;
	@EJB
	SongDAO songDAO;
	

	public List<Artist> getArtists() {
		artists = artistDAO.findAll();
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
	
}
