package com.practical.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.practical.domain.Song;

@Stateless
@LocalBean
public class SongDAO extends EntityDAO<Song> implements ISongDAO {

	public SongDAO() {
		super(Song.class);
	}

}
