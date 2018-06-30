package com.practical;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.practical.domain.Album;
import com.practical.domain.Artist;
import com.practical.domain.Song;
import com.practical.ejb.AlbumDAO;
import com.practical.ejb.ArtistDAO;
import com.practical.ejb.SongDAO;

@Named
@ViewScoped
public class RemoveBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Artist artist;
	private Album album;
	private Song song;
	private long artistId;
	private long albumId;
	private long songId;
	
	
	@EJB
	ArtistDAO artistDAO;
	@EJB
	AlbumDAO albumDAO;
	@EJB
	SongDAO songDAO;
	
	public boolean removeArtist() {
		artist = artistDAO.find(Artist.class, artistId);
		artistDAO.remove(artist);
		return true;
	}
	
	
	public boolean removeAlbum() {
		for(Album albumS : artist.getAlbum()) {
			if (albumS.getId().equals(albumId)) {
				album = albumS;
			}
		}
		albumDAO.remove(album);
		return true;
	}
	
	public boolean removeSong() {
		for(Song songS : album.getSong()) {
			if (songS.getId().equals(songId)) {
				song = songS;
			}
		}
		songDAO.remove(song);
		return true;
	}
	
	public void selectOneMenuListener(ValueChangeEvent event) {
	    artistId =Long.valueOf((String) event.getNewValue()).longValue();
	    artist = artistDAO.find(Artist.class, artistId);
	}
	
	public void selectOneMenuListener2(ValueChangeEvent event) {
	    albumId =Long.valueOf((String) event.getNewValue()).longValue();
		for(Album albumS : artist.getAlbum()) {
			if (albumS.getId().equals(albumId)) {
				album = albumS;
			}
		}
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public long getArtistId() {
		return artistId;
	}

	public void setArtistId(long artistId) {
		this.artistId = artistId;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}


	public Song getSong() {
		return song;
	}


	public void setSong(Song song) {
		this.song = song;
	}


	public long getSongId() {
		return songId;
	}


	public void setSongId(long songId) {
		this.songId = songId;
	}
	
}
