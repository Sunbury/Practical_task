package com.practical.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.practical.domain.Artist;

@Stateless
@LocalBean
public class ArtistDAO extends EntityDAO<Artist> implements IArtistDAO {
	

}
