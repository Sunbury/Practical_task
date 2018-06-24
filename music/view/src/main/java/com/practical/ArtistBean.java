package com.practical;

import java.io.Serializable;

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
			artist = artistManagerBean.createActor();
	}
	
	public void createAlbum() {
		if(album == null)
			album = albumManagerBean.createAlbum();
	}
	
	public void createSong() {
		if(song == null)
			song = songManagerBean.createSong();
	}
	
}
