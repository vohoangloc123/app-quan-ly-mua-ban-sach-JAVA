package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.LoaiNhanVien;

public class LoaiNhanVien_DAO {
	public ArrayList<LoaiNhanVien> getallLoaiNhanVien(){
		ArrayList<LoaiNhanVien> dsLoaiSach=new ArrayList<LoaiNhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql="Select * from LoaiNhanVien";
			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maLoaiNV=rs.getString(1);
				String chucVu=rs.getString(2);
				LoaiNhanVien loaiNV=new LoaiNhanVien(maLoaiNV, chucVu);
				dsLoaiSach.add(loaiNV);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsLoaiSach;
	}
}
