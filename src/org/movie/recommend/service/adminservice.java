package org.movie.recommend.service;

import org.movie.recommend.repository.AdminRepository;

public class adminservice {
	AdminRepository ARepo=new AdminRepository();
	
	public boolean isAdminValid(String id,String pass)
	{

		boolean b=ARepo.idAdminValid(id, pass);
		return b;
	}
    public boolean changepass(String id,String pass)
    {
    	boolean b=ARepo.changepass(id, pass);
    	return b;
    }
}
