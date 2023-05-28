package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.LoaiKhachHang;

public class LoaiKhachHang_DAO {
	public ArrayList<LoaiKhachHang> getallLoaiKhachHang(){
		ArrayList<LoaiKhachHang> dsLoaiKH=new ArrayList<LoaiKhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql="Select * from LoaiKhachHang";
			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maLoaiKhachHang=rs.getString(1);
				String tenLoaiKhachHang=rs.getString(2);
				LoaiKhachHang loaiKH=new LoaiKhachHang(maLoaiKhachHang, tenLoaiKhachHang);
				dsLoaiKH.add(loaiKH);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsLoaiKH;
	}
}
