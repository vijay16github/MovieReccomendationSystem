package org.movie.recommend.repository;

import java.sql.ResultSet;

import org.movie.recommend.config.DBHelper;

public class AdminRepository extends DBHelper{
	public boolean idAdminValid(String id,String pass)
	{
		try
		{
			stmt=conn.prepareStatement("select *from admin where adminid=? and adminpass=?");
			stmt.setString(1, id);
			stmt.setString(2, pass);
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
			System.out.println("Error is"+ex);
		}
		return false;
	}
	public boolean changepass(String id,String pass)
	{
		try
		{
			stmt=conn.prepareStatement("update admin set adminpass=? where adminid=?");
			stmt.setString(1, pass);
			stmt.setString(2, id);
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
			System.out.println("Error is"+ex);
		}
		return false;
	}

}
