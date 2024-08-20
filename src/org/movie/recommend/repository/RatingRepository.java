package org.movie.recommend.repository;

import java.sql.PreparedStatement;
import java.util.LinkedHashMap;
import java.util.Map;

import org.movie.recommend.config.DBHelper;
import org.movie.recommend.model.RatingModel;
import java.sql.*;
public class RatingRepository extends DBHelper {
	
	public boolean isGiveRating(RatingModel Rmodel)
	{
		try
		{
			stmt=conn.prepareStatement("insert into ratings values(?,'0',?,?)");
			stmt.setInt(1, Rmodel.getUsermovid());
			stmt.setString(2, Rmodel.getRevstars());
			stmt.setString(3, Rmodel.getFeedback());
			int value=stmt.executeUpdate();
			return value > 0 ? true :false;
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception is"+ex);
			return false;
		}
	}

	public int getTotal() {
		try
		{
			stmt=conn.prepareStatement("select count(usermovid) from ratings");
			rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}else {
				return 0;
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception is"+ex);
			return 0;
		}
	}

	public Map<String, Float> getCummPer(int gid) {
		try
    	{	Map<String, Float> tmap = new LinkedHashMap<String, Float>();
    		stmt=conn.prepareStatement(" select (select movtitle from movie where movid=mg.movid) from moviegenres mg where mg.genid IN (select genid from genres where genid=?);");
    		stmt.setInt(1, gid);
    		rs=stmt.executeQuery();
    		while(rs.next()) {
//    			tmap.put(rs.getString(1), null);
//    			System.out.println(rs.getString(1));
    			PreparedStatement pst=conn.prepareStatement("select avg(revstars) from ratings where usermovid IN (select usermovid from userwatchhistory where movid =(select movid from movie where movtitle=?))");
    					
    			pst.setString(1,rs.getString(1));
    			ResultSet rs1=pst.executeQuery();
    			if(rs1.next()){
//    				System.out.println(rs1.getFloat(1)*10);
    				tmap.put(rs.getString(1),rs1.getFloat(1)*10);
    			}
    		}
    		return tmap;
    	}
    	catch(Exception ex)
    	{
    		System.out.println("Exception is "+ex);
    		return null;
    	}
	}


	
   
}
