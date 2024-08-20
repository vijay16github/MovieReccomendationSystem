package org.movie.recommend.service;

import java.util.List;

import org.movie.recommend.model.GenresModel;
import org.movie.recommend.model.MovieMasterModel;
import org.movie.recommend.model.UserModel;
import org.movie.recommend.repository.MovieRepository;

public class moviemasterservice {
	MovieRepository mRepo=new MovieRepository();
	public boolean isAddMovie(MovieMasterModel model)
	{
		boolean b=mRepo.isAddMovie(model);
		return b;
	}
	public List<MovieMasterModel> getAllMovies()
	{
		return mRepo.getAllMovies();
	}
    public int getMovId(String name)
    {
    	return mRepo.getmovie(name);
    }
    public int getUserIdAutomatic()
    {
    	return mRepo.getUserIdAutomatic();
    }
    public boolean isAddUser(UserModel umodel)
    {
        return mRepo.isAddUser(umodel);	
    }
	public GenresModel getConcat(String movtit) {
		
		return mRepo.getConcatGenres(movtit);
	}
	public GenresModel SearchByGenres(String gentitle)
	{
		return mRepo.SearchByGenres(gentitle);
	}
	
}
