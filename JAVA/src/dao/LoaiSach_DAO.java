package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.LoaiSach;
public class LoaiSach_DAO {
	public ArrayList<LoaiSach> getallLoaiSach(){
		ArrayList<LoaiSach> dsLoaiSach=new ArrayList<LoaiSach>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql="Select * from LoaiSach";
			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maLoaiSach=rs.getString(1);
				String tenLoaiSach=rs.getString(2);
				LoaiSach loaisach=new LoaiSach(maLoaiSach, tenLoaiSach);
				dsLoaiSach.add(loaisach);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsLoaiSach;
	}
}
