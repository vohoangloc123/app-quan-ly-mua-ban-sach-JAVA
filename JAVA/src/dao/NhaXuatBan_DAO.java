package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.NhaXuatBan;

public class NhaXuatBan_DAO {
	public ArrayList<NhaXuatBan> getalltNhaXuatBan(){
		ArrayList<NhaXuatBan> dsNhaXuatBan=new ArrayList<NhaXuatBan>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql="Select * from NhaXuatBan";
			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maNXB=rs.getString(1);
				String tenNXB=rs.getString(2);
				NhaXuatBan nhaxuatban=new NhaXuatBan(maNXB, tenNXB);
				dsNhaXuatBan.add(nhaxuatban);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsNhaXuatBan;
	}
}
