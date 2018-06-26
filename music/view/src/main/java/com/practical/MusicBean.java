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
import com.practical.ejb.AlbumManagerBean;
import com.practical.ejb.ArtistManagerBean;
import com.practical.ejb.SongManagerBean;

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
	ArtistManagerBean artistManagerBean;
	@EJB
	AlbumManagerBean albumManagerBean;
	@EJB
	SongManagerBean songManagerBean;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public void createArtist() {
		if(artist == null)
			try {
				artist = artistManagerBean.createArtist("Some Artist", dateFormat.parse("17/07/1989"), "USA");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(album == null)
			try {
				album = albumManagerBean.createAlbum("Some ALbum",dateFormat.parse("17/07/1989"), "genre", artist);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if(song == null)
			song = songManagerBean.createSong("Some Song", 1, album);
	}
	
}
