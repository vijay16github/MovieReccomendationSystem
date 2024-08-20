package org.movie.recommend.repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.movie.recommend.config.DBHelper;
import org.movie.recommend.model.UserModel;

public class UserRepository extends DBHelper{
	private List<UserModel> list=new ArrayList<UserModel>();
	public boolean isUserValid(String username,String upassword)
	{
		try
		{
			stmt=conn.prepareStatement("select *from user where username=? and upassword=?");
			stmt.setString(1, username);
			stmt.setString(2, upassword);
			try(ResultSet rs=stmt.executeQuery())
			{
				if(rs.next())
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
		}
		return false;	
		}
	   
	   public List<UserModel> getAllUserWatchHistory()
	   {
		   List<UserModel> users=new ArrayList<>();
		   try
		   {
			   stmt=conn.prepareStatement(" select uwh.usermovid,m.movid,m.movtitle,u.userid,u.username from movie m inner join userwatchhistory uwh on m.movid=uwh.movid inner join user u on u.userid=uwh.userid");
			   rs=stmt.executeQuery();
			   while(rs.next())
			   {
				   UserModel umodel=new UserModel();
				   umodel.setUsermovid(rs.getInt(1));
				   umodel.setMovid(rs.getInt(2));
				   umodel.setMovtitle(rs.getString(3));
				   umodel.setGenid(rs.getInt(4));
				   umodel.setGentitle(rs.getString(5));
				   list.add(umodel);
			   }
			   return list.size() > 0 ? list : null;
			   
		   }
		   catch(Exception ex)
		   {
			   
			   System.out.println("Exception is"+ex);
		   }
		   return users;
		   
	   }
	  public List<UserModel> GetAllUsers()
	  {
		  List<UserModel> users=new ArrayList<>();
		  try
		  {
			  stmt=conn.prepareStatement("select *from user");
			  rs=stmt.executeQuery();
			  while(rs.next())
			  {
				  UserModel umodel=new UserModel();
				  umodel.setUserid(rs.getInt(1));
				  umodel.setUsername(rs.getString(2));
				  umodel.setUpassword(rs.getString(3));
				  umodel.setUcontact(rs.getString(4));
				  umodel.setUage(rs.getInt(5));
				  list.add(umodel);
				  
			  }
			  return list.size() > 0 ? list :null;
		  }
		  catch(Exception ex)
		  {
			  System.out.println("Exception ex"+ex);
		  }
		  return users;
	  }
	   public boolean isAssignMovieToUser(UserModel umodel)
	   {
		   try
		   {
			   stmt=conn.prepareStatement("insert into userwatchhistory values(?,?,'0')");
			   stmt.setInt(1, umodel.getUserid());
			   stmt.setInt(2, umodel.getMovid());
			   int value=stmt.executeUpdate();
			   return value > 0 ? true : false;
			   
			   
		   }
		   catch(Exception ex)
		   {
			   System.out.println("Error is"+ex);
			   return false;
		   }
			   
	   }

}
