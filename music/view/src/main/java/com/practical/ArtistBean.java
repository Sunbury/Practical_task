package com.practical;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.practical.domain.Album;
import com.practical.domain.Artist;
import com.practical.domain.Song;
import com.practical.ejb.AlbumManagerBean;
import com.practical.ejb.ArtistManagerBean;
import com.practical.ejb.SongManagerBean;

@Named
@SessionScoped
public class ArtistBean implements Serializable {

	private Artist artist;
	private Album album;
	private Song song;
	
	@EJB
	ArtistManagerBean artistManagerBean;
	@EJB
	AlbumManagerBean albumManagerBean;
	@EJB
	SongManagerBean songManagerBean;
	
	public void createArtist() {
		if(artist == null)
			artist = artistManagerBean.createArtist("Some Artist", new Date(1994,05,21), "USA");
	}
	
	public void createAlbum() {
		if(album == null)
			album = albumManagerBean.createAlbum("Some ALbum", new Date(1994,05,21), "genre", artist);
	}
	
	public void createSong() {
		if(song == null)
			song = songManagerBean.createSong("Some Song", 1, album);
	}
	
}
