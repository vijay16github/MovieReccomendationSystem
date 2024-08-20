package org.movie.recommend.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.movie.recommend.config.DBHelper;
import org.movie.recommend.config.PathHelper;
import org.movie.recommend.model.GenresModel;
import org.movie.recommend.model.MovieMasterModel;

public class GenresRepository extends DBHelper {
	private List<GenresModel> list = new ArrayList<GenresModel>();
	private List<MovieMasterModel> list1 = new ArrayList<MovieMasterModel>();
	private int movid=0;

	public boolean isBulkAddGenres() {
		try {
			FileReader fr = new FileReader(PathHelper.path + "genres.csv");
			BufferedReader br = new BufferedReader(fr);
			int value = 0;

			String line = null;
			while ((line = br.readLine()) != null) {
				String data[] = line.split(",");
				stmt = conn.prepareStatement("insert into genres values('0',?)");
				stmt.setString(1, data[1]);
				value = stmt.executeUpdate();

			}
			return value > 0 ? true : false;

		} catch (Exception ex) {
			System.out.println("Error is" + ex);
		}
		return false;
	}

	public List<GenresModel> getAllGenres() {
		try {
			stmt = conn.prepareStatement("select *from genres");
			rs = stmt.executeQuery();
			while (rs.next()) {
				GenresModel gmodel = new GenresModel();
				gmodel.setGenid(rs.getInt(1));
				gmodel.setGentitle(rs.getString(2));
				list.add(gmodel);
			}
			return list.size() > 0 ? list : null;

		} catch (Exception ex) {
			System.out.println("Exception is" + ex);
			return null;
		}
	}

	public boolean isAddGenres(GenresModel gModel) {
		try {
			stmt = conn.prepareStatement("insert into genres values('0',?)");
			stmt.setString(1, gModel.getGentitle());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;

		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return false;
		}
	}

	public List<GenresModel> getAllMovieGenres() {
		List<GenresModel> movies=new ArrayList<>();
		try {
			stmt = conn.prepareStatement(
					"select m.movid,m.movtitle,m.movyear,m.movtime,m.movlang,m.movdtrel,"
					+ "m.movrelcountry,g.gentitle from movie m inner join moviegenres mg "
					+ "on m.movid=mg.movid inner join genres g on g.genid=mg.genid ");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				GenresModel gmodel=new GenresModel();
				gmodel.setMovid(rs.getInt(1));
				gmodel.setMovtitle(rs.getString(2));
				gmodel.setMovyear(rs.getInt(3));
				gmodel.setMovtime(rs.getInt(4));
				gmodel.setMovlang(rs.getString(5));
				gmodel.setMovdtrel(rs.getString(6));
				gmodel.setMovrelcountry(rs.getString(7));
				gmodel.setGentitle(rs.getString(8));
				list.add(gmodel);
				
			}
			return list.size() > 0 ? list : null;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
		}
		return movies;
	  
	}
	public int getgenreid(String name)
	{
		try
		{
			stmt=conn.prepareStatement("select genid from genres where gentitle=?");
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

    public int getMovieIdAutomatic()
    {
 	   try
 	   {
 		   stmt=conn.prepareStatement("select max(movid) from movie");
 		   rs=stmt.executeQuery();
 		   if(rs.next())
 		   {
 			   this.movid=rs.getInt(1);
 		   }
 		   ++movid;
 		   return movid;
 		   
 	   }
 	   catch(Exception ex)
 	   {
 		   System.out.println("Exception is"+ex);
 		   return 0;
 	   }
    }
    
    public boolean isAddMovGen(GenresModel gModel)
    {
    	try
    	{
    		clst=conn.prepareCall("{call savemovgen(?,?,?,?,?,?,?,?)}");
    		clst.setInt(1, gModel.getMovid());
    		clst.setString(2, gModel.getMovtitle());
    		clst.setInt(3, gModel.getMovyear());
    		clst.setInt(4, gModel.getMovtime());
    		clst.setString(5, gModel.getMovlang());
    		clst.setString(6,gModel.getMovdtrel());
    		clst.setString(7, gModel.getMovrelcountry());
    		clst.setInt(8, gModel.getGenid());
    		boolean b=clst.execute();
    		return !b;
    		
    		
    	}
    	catch(Exception ex)
    	{
    		System.out.println("exception is"+ex);
    		return false;
    		
    	}
    }
    
    public boolean isJoinMovGen(GenresModel gModel)
    {
    	try
    	{
    		stmt=conn.prepareStatement("insert into moviegenres values(?,?)");
    		stmt.setInt(1, gModel.getMovid());
    		stmt.setInt(2, gModel.getGenid());
    		int value=stmt.executeUpdate();
    		return value > 0 ? true : false;
    		
    	}
    	catch(Exception ex)
    	{
    	      System.out.println("Exception is"+ex);
    	      return false;
    	}
    }
//    public boolean isConcatGenres()
//    {
//    	try
//    	{
//    		
//    	}
//    	catch(Exception ex)
//    	{
//    		
//    	}
//    }

//	public Map<Integer, Float> getCummPer(int gid) {
//		try
//    	{	Map<Integer, Float> tmap = new LinkedHashMap<Integer, Float>();
//    		stmt=conn.prepareStatement(" select (select movtitle from movie where movid=mg.movid) from moviegenres mg where mg.genid IN (select genid from genres where genid=?);");
//    		stmt.setInt(1, gid);
//    		while(rs.next()) {
//    			tmap.put(rs.getInt(1), null);
//    		}
//    		return tmap;
//    	}
//    	catch(Exception ex)
//    	{return null;
//    	}
//	}

}
