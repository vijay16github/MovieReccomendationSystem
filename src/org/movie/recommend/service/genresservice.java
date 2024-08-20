package org.movie.recommend.service;

import java.util.List;
import java.util.Map;

import org.movie.recommend.model.GenresModel;
import org.movie.recommend.model.MovieMasterModel;
import org.movie.recommend.repository.GenresRepository;

public class genresservice {
	GenresRepository gRepo=new GenresRepository();
	public boolean isBulkAddGenres()
	{
		return gRepo.isBulkAddGenres();
	}
	public List<GenresModel> getAllGenres()
	{
		return gRepo.getAllGenres();
	}
	public boolean isAddGenres(GenresModel gModel)
	{
		boolean b=gRepo.isAddGenres(gModel);
		return b;
	}
	public List<GenresModel> getAllMovieGenres()
	{
		return gRepo.getAllMovieGenres();
	}
	public int getgenreid(String name)
	{
		return gRepo.getgenreid(name);
	}
    public boolean isAddMovGen(GenresModel gModel)
    {
    	return gRepo.isAddMovGen(gModel);
    }
    public int getAutomMovID() {
    	return gRepo.getMovieIdAutomatic();
    }
    public boolean isJoinMovGen(GenresModel gModel)
    {
    	return gRepo.isJoinMovGen(gModel);
    		
    }
	
}
