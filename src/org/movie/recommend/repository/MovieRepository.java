package org.movie.recommend.repository;
import org.movie.recommend.config.DBConfig;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.movie.recommend.config.DBHelper;
import org.movie.recommend.model.GenresModel;
import org.movie.recommend.model.MovieMasterModel;
import org.movie.recommend.model.UserModel;

import com.mysql.cj.jdbc.CallableStatement;

public class MovieRepository extends DBHelper {
	private List<MovieMasterModel> list=new ArrayList<MovieMasterModel>();
	private List<GenresModel> list1=new ArrayList<GenresModel>();
	private int userid=0;
	
	
       public boolean isAddMovie(MovieMasterModel model)
       {
    	   try
    	   {
    		   stmt=conn.prepareStatement("insert into movie values('0',?,?,?,?,?,?)");
    		   stmt.setString(1, model.getMovtitle());
    		   stmt.setInt(2, model.getMovyear());
    		   stmt.setInt(3, model.getMovtime());
    		   stmt.setString(4, model.getMovlang());
    		   stmt.setString(5, model.getMovdtrel());
    		   stmt.setString(6, model.getMovrelcountry());
    		   int value=stmt.executeUpdate();
    		   return value>0 ? true:false;
    		   
    		   
    		   
    	   }
    	   catch(Exception ex)
    	   {
    		   System.out.println("Error is"+ex);
    		   return false;
    	   }
       }
       public List<MovieMasterModel> getAllMovies()
       {
    	   try
    	   {
    		   stmt=conn.prepareStatement("select *from movie");
    		   rs=stmt.executeQuery();
    		   while(rs.next())
    		   {
    			   MovieMasterModel model=new MovieMasterModel();
    			   model.setMovid(rs.getInt(1));
    			   model.setMovtitle(rs.getString(2));
    			   model.setMovyear(rs.getInt(3));
    			   model.setMovtime(rs.getInt(4));
    			   model.setMovlang(rs.getString(5));
    			   model.setMovdtrel(rs.getString(6));
    			   model.setMovrelcountry(rs.getString(7));
    			   list.add(model);
    		   }
    		   return list.size()> 0 ? list : null;
    		   
    		   
    	   }
    	   catch(Exception ex)
    	   {
    		   System.out.println("Exception is"+ex);
    		   return null;
    	   }
       }
       public int getmovie(String name)
       {
    	   try
    	   {
    		   stmt=conn.prepareStatement("select movid from movie where movtitle=?");
    		   stmt.setString(1, name);
    		   rs=stmt.executeQuery();
    		   if(rs.next())
    		   {
    			   return rs.getInt(1);
    		   }
    		   else
    		   {
    			   return -1;
    		   }
    		   
    	   }
    	   catch(Exception ex)
    	   {
    		   System.out.println("Exception is"+ex);
    		   return -1;
    	   }
       }
       public int getUserIdAutomatic()
       {
    	   try
    	   {
    		   stmt=conn.prepareStatement("select max(userid) from user");
    		   rs=stmt.executeQuery();
    		   if(rs.next())
    		   {
    			   this.userid=rs.getInt(1);
    		   }
    		   ++userid;
    		   return userid;
    		   
    	   }
    	   catch(Exception ex)
    	   {
    		   return 0;
    		   
    	   }
       }
       public boolean isAddUser(UserModel umodel)
       {
    	   try
    	   {
    		   clst= conn.prepareCall("{call saveuser1(?,?,?,?,?,?)}");
    		   clst.setInt(1, umodel.getUserid());
    		   clst.setString(2, umodel.getUsername());
    		   clst.setString(3, umodel.getUpassword());
    		   clst.setString(4, umodel.getUcontact());
    		   clst.setInt(5, umodel.getUage());
    		   clst.setInt(6, umodel.getMovid());
    		   boolean b=clst.execute();
    		   return !b;
    		  
    		   
    	   }
    	   catch(Exception ex)
    	   {
    		   System.out.println("Exception"+ex);
    		   return false;
    	   }
          }
//       public List<GenresModel> getConcatGenres()
//       {
//    	   List<GenresModel> genres=new ArrayList<>();
//    	   try
//    	   {
//    		   stmt=conn.prepareStatement("select m.movtitle,m.movyear,m.movtime,m.movlang,m.movdtrel,m.movrelcountry,group_concat(g.gentitle) from movie m inner join moviegenres mg on mg.movid=m.movid inner join genres g on g.genid=mg.genid where m.movtitle=? group by m.movtitle,m.movyear,m.movtime,m.movlang,m.movdtrel,m.movrelcountry");
//    		   rs=stmt.executeQuery();
//    		   while(rs.next())
//    		   {
//    			   GenresModel gModel=new GenresModel();
//    			   gModel.setMovtitle(rs.getString(1));
//    			   gModel.setMovyear(rs.getInt(2));
//    			   gModel.setMovtime(rs.getInt(3));
//    			   gModel.setMovlang(rs.getString(4));
//    			   gModel.setMovdtrel(rs.getString(5));
//    			   gModel.setMovrelcountry(rs.getString(6));
//    			   stmt.setString(1, gModel.getMovtitle());
//    			   list.add(gModel);
//    			   int value=stmt.executeUpdate();
//    			   
//    			   
//    		   }
//    		   return list.size() > 0 ? list1 : null; 
//    	   }
//    	   catch(Exception ex)
//    	   {
//    		   System.out.println("Erroer is"+ex);
//    	   }
//    	   return genres;
//       }
//       
       
	public GenresModel getConcatGenres(String movtit) {
		 GenresModel gModel=new GenresModel();
		 try
  	   {	
  		   stmt=conn.prepareStatement("select m.movtitle,m.movyear,m.movtime,m.movlang,m.movdtrel,m.movrelcountry,group_concat(g.gentitle) from movie m inner join moviegenres mg on mg.movid=m.movid inner join genres g on g.genid=mg.genid where m.movtitle=? group by m.movtitle,m.movyear,m.movtime,m.movlang,m.movdtrel,m.movrelcountry");
  		   stmt.setString(1, movtit);
  		   rs=stmt.executeQuery();
  		   if(rs.next())
  		   {
  			  
  			   gModel.setMovtitle(rs.getString(1));
  			   gModel.setMovyear(rs.getInt(2));
  			   gModel.setMovtime(rs.getInt(3));
  			   gModel.setMovlang(rs.getString(4));
  			   gModel.setMovdtrel(rs.getString(5));
  			   gModel.setMovrelcountry(rs.getString(6));
  			  gModel.setGentitle(rs.getString(7));
  			   list.add(gModel);
  			  
  			   
  			   
  		   }
  		  return gModel;
  	   }
  	   catch(Exception ex)
  	   {
//  		   System.out.println("Erroer is"+ex);
  		   return gModel;
  	   }
	}
    public GenresModel SearchByGenres(String gentitle)
    {
    	GenresModel gModel=new GenresModel();
    	try
    	{
    		stmt=conn.prepareStatement("select m.movtitle,m.movyear,m.movtime,m.movlang,m.movdtrel,m.movrelcountry,g.gentitle from movie m inner join moviegenres mg on mg.movid=m.movid inner join genres g on g.genid=mg.genid where gentitle=?");
    		stmt.setString(1, gentitle);
    		rs=stmt.executeQuery();
    		if(rs.next())
    		{
    			gModel.setMovtitle(rs.getString(1));
    			gModel.setMovyear(rs.getInt(2));
    			gModel.setMovtime(rs.getInt(3));
    			gModel.setMovlang(rs.getString(4));
    			gModel.setMovdtrel(rs.getString(5));
    			gModel.setMovrelcountry(rs.getString(6));
    			gModel.setGentitle(rs.getString(7));
    			list.add(gModel);
    		}
    		return gModel;
    	}
    	catch(Exception ex)
    	{
    		System.out.println("Exception ex"+ex);
    		return gModel;
    	}
    }
       
}
