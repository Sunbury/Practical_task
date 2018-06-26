package com.practical;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	private Artist artist;
	private Album album;
	private Song song;
	
	
	@EJB
	ArtistDAO artistDAO;
	@EJB
	AlbumDAO albumDAO;
	@EJB
	SongDAO songDAO;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	
	
	public void createArtist() {
		artist = new Artist();
		artist.setName("Some Artist");
		try {
			artist.setDateFound(dateFormat.parse("17/07/1989"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		artist.setCountry("USA");
		album = new Album();
		album.setName("Some Album");
		try {
			album.setDateRelease(dateFormat.parse("17/07/1989"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		album.setGenre("genre");
		album.setArtist(artist);
		song= new Song();
		song.setName("Some Song");
		song.setNumber(1);
		song.setAlbum(album);
	}
	
	public void createData(){
		createArtist();
		artistDAO.create(artist);
		albumDAO.create(album);
		songDAO.create(song);
	}
}
