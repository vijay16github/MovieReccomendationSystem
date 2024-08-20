package org.movie.recommend.service;

import java.util.List;

import org.movie.recommend.model.UserModel;
import org.movie.recommend.repository.UserRepository;

public class UserService {
	UserRepository uRepo=new UserRepository();
	public boolean isUserValid(String username,String upassword)
	{
		boolean b=uRepo.isUserValid(username, upassword);
		return b;
	}
	
	public List<UserModel> getAllUserWatchHistory()
	{
		return uRepo.getAllUserWatchHistory();
	}
    public List<UserModel> GetAllUsers()
    {
    	return uRepo.GetAllUsers();
    }
    public boolean isAssignMovieToUser(UserModel umodel)
    {
    	return uRepo.isAssignMovieToUser(umodel);
    }
}
