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
public class OperationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Artist artist = new Artist(); 
	private Album album = new Album();
	private Song song = new Song();
	private long artistId;
	private long albumId;
	private long songId;
	private Artist artistUpdate;
	private Album albumUpdate;

	@EJB
	ArtistDAO artistDAO;
	@EJB
	AlbumDAO albumDAO;
	@EJB
	SongDAO songDAO;
	
	
	public void addArtist(){
		artistDAO.create(artist);
	}
	
	public void addAlbum() {
		Artist artist = artistDAO.find(Artist.class, artistId);
		album.setArtist(artist);
		albumDAO.create(album);
	}
	
	public void addSong() {
		Album album = albumDAO.find(Album.class, albumId);
		song.setAlbum(album);
		songDAO.create(song);
	}
	
	public Artist FoundArtist() {
		Artist artist = artistDAO.find(Artist.class, artistId);
		return artist;
	}
	
	public void selectOneMenuListener(ValueChangeEvent event) {
	    artistId =Long.valueOf((String) event.getNewValue()).longValue();
	    artistUpdate = artistDAO.find(Artist.class, artistId);
	}
	
	public void selectOneMenuListener2(ValueChangeEvent event) {
	    albumId =Long.valueOf((String) event.getNewValue()).longValue();
		for(Album albumS : artistUpdate.getAlbum()) {
			if (albumS.getId().equals(albumId)) {
				albumUpdate = albumS;
			}
		}
	}
	
	public void editArtist(){
		artistDAO.update(artist);
	}
	
	public void editAlbum() {
		Artist artist = artistDAO.find(Artist.class, artistId);
		album.setArtist(artist);
		albumDAO.update(album);
	}
	
	public void editSong() {
		song.setAlbum(albumUpdate);
		songDAO.update(song);
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

	public Artist getArtistUpdate() {
		return artistUpdate;
	}

	public void setArtistUpdate(Artist artistUpdate) {
		this.artistUpdate = artistUpdate;
	}

	public Album getAlbumUpdate() {
		return albumUpdate;
	}

	public void setAlbumUpdate(Album albumUpdate) {
		this.albumUpdate = albumUpdate;
	}
	
}
