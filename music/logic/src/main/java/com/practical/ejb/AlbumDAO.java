package com.practical.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.practical.domain.Album;

@Stateless
@LocalBean
public class AlbumDAO extends EntityDAO<Album> implements IAlbumDAO {

	public AlbumDAO() {
		super(Album.class);
	}
}
