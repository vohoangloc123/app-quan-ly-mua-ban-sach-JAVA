package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import connect.ConnectDB;
import entity.KhachHang;
import entity.LoaiSach;
import entity.NhaXuatBan;
import entity.Sach;

public class Sach_DAO {
	public ArrayList<Sach> getallSachConHang(){
		ArrayList<Sach> dsSach=new ArrayList<Sach>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			String sql="select maSach, tenSach, namXuatBan, donGia, ngonNgu, tacGia, NhaXuatBan.tenNXB, LoaiSach.tenLoaiSach, trangThai, urlAnh from Sach join NhaXuatBan on Sach.maNXB=NhaXuatBan.maNXB join LoaiSach on Sach.maLoaiSach=LoaiSach.maLoaiSach where TrangThai = 1";

			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maSach=rs.getString(1);
				String tenSach=rs.getString(2);
				Date namXB=rs.getDate(3);
				double donGia=rs.getDouble(4);
				String ngonNgu=rs.getString(5);
				String tenTacGia=rs.getString(6);
				NhaXuatBan nhaxuatban=new NhaXuatBan(rs.getString(7));
				LoaiSach loaisach=new LoaiSach(rs.getString(8));
				boolean trangThai=rs.getBoolean(9);
				String url=rs.getString(10);
				Sach sach=new Sach(maSach, tenSach, namXB, donGia, ngonNgu, tenTacGia, nhaxuatban, loaisach, trangThai, url );
				dsSach.add(sach);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsSach;
	}
	public ArrayList<Sach> getallSachHetHang(){
		ArrayList<Sach> dsSach=new ArrayList<Sach>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			String sql="select maSach, tenSach, namXuatBan, donGia, ngonNgu, tacGia, NhaXuatBan.tenNXB, LoaiSach.tenLoaiSach, trangThai, urlAnh from Sach join NhaXuatBan on Sach.maNXB=NhaXuatBan.maNXB join LoaiSach on Sach.maLoaiSach=LoaiSach.maLoaiSach where TrangThai = 0";

			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maSach=rs.getString(1);
				String tenSach=rs.getString(2);
				Date namXB=rs.getDate(3);
				double donGia=rs.getDouble(4);
				String ngonNgu=rs.getString(5);
				String tenTacGia=rs.getString(6);
				NhaXuatBan nhaxuatban=new NhaXuatBan(rs.getString(7));
				LoaiSach loaisach=new LoaiSach(rs.getString(8));
				boolean trangThai=rs.getBoolean(9);
				String url=rs.getString(10);
				Sach sach=new Sach(maSach, tenSach, namXB, donGia, ngonNgu, tenTacGia, nhaxuatban, loaisach, trangThai, url );
				dsSach.add(sach);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsSach;
	}
	public ArrayList<Sach> getallSach(){
		ArrayList<Sach> dsSach=new ArrayList<Sach>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			String sql="select maSach, tenSach, namXuatBan, donGia, ngonNgu, tacGia, NhaXuatBan.tenNXB, LoaiSach.tenLoaiSach, trangThai, urlAnh from Sach join NhaXuatBan on Sach.maNXB=NhaXuatBan.maNXB join LoaiSach on Sach.maLoaiSach=LoaiSach.maLoaiSach";

			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maSach=rs.getString(1);
				String tenSach=rs.getString(2);
				Date namXB=rs.getDate(3);
				double donGia=rs.getDouble(4);
				String ngonNgu=rs.getString(5);
				String tenTacGia=rs.getString(6);
				NhaXuatBan nhaxuatban=new NhaXuatBan(rs.getString(7));
				LoaiSach loaisach=new LoaiSach(rs.getString(8));
				boolean trangThai=rs.getBoolean(9);
				String url=rs.getString(10);
				Sach sach=new Sach(maSach, tenSach, namXB, donGia, ngonNgu, tenTacGia, nhaxuatban, loaisach, trangThai, url );
				dsSach.add(sach);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsSach;
	}
	public ArrayList<Sach> getallSachTangDanTheoTen(){
		ArrayList<Sach> dsSach=new ArrayList<Sach>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			String sql="select maSach, tenSach, namXuatBan, donGia, ngonNgu, tacGia, NhaXuatBan.tenNXB, LoaiSach.tenLoaiSach, trangThai, urlAnh from Sach join NhaXuatBan on Sach.maNXB=NhaXuatBan.maNXB join LoaiSach on Sach.maLoaiSach=LoaiSach.maLoaiSach where TrangThai = 1 order by Sach.tenSach asc";

			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maSach=rs.getString(1);
				String tenSach=rs.getString(2);
				Date namXB=rs.getDate(3);
				double donGia=rs.getDouble(4);
				String ngonNgu=rs.getString(5);
				String tenTacGia=rs.getString(6);
				NhaXuatBan nhaxuatban=new NhaXuatBan(rs.getString(7));
				LoaiSach loaisach=new LoaiSach(rs.getString(8));
				boolean trangThai=rs.getBoolean(9);
				String url=rs.getString(10);
				Sach sach=new Sach(maSach, tenSach, namXB, donGia, ngonNgu, tenTacGia, nhaxuatban, loaisach, trangThai, url );
				dsSach.add(sach);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsSach;
	}
	public ArrayList<Sach> getallSachGiamDanTheoTen(){
		ArrayList<Sach> dsSach=new ArrayList<Sach>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			String sql="select maSach, tenSach, namXuatBan, donGia, ngonNgu, tacGia, NhaXuatBan.tenNXB, LoaiSach.tenLoaiSach, trangThai, urlAnh from Sach join NhaXuatBan on Sach.maNXB=NhaXuatBan.maNXB join LoaiSach on Sach.maLoaiSach=LoaiSach.maLoaiSach where TrangThai = 1 order by Sach.tenSach desc";

			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maSach=rs.getString(1);
				String tenSach=rs.getString(2);
				Date namXB=rs.getDate(3);
				double donGia=rs.getDouble(4);
				String ngonNgu=rs.getString(5);
				String tenTacGia=rs.getString(6);
				NhaXuatBan nhaxuatban=new NhaXuatBan(rs.getString(7));
				LoaiSach loaisach=new LoaiSach(rs.getString(8));
				boolean trangThai=rs.getBoolean(9);
				String url=rs.getString(10);
				Sach sach=new Sach(maSach, tenSach, namXB, donGia, ngonNgu, tenTacGia, nhaxuatban, loaisach, trangThai, url );
				dsSach.add(sach);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsSach;
	}
	public ArrayList<Sach> getSachTheoMa(String id)
	{
		ArrayList<Sach> dsSach=new ArrayList<Sach>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="select maSach, tenSach, namXuatBan, donGia, ngonNgu, tacGia, NhaXuatBan.tenNXB, LoaiSach.tenLoaiSach, trangThai, urlAnh from Sach join NhaXuatBan on Sach.maNXB=NhaXuatBan.maNXB join LoaiSach on Sach.maLoaiSach=LoaiSach.maLoaiSach where maSach=?";
			statement=con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				String maSach=rs.getString(1);
				String tenSach=rs.getString(2);
				Date namXB=rs.getDate(3);
				double donGia=rs.getDouble(4);
				String ngonNgu=rs.getString(5);
				String tenTacGia=rs.getString(6);
				NhaXuatBan nhaxuatban=new NhaXuatBan(rs.getString(7));
				LoaiSach loaisach=new LoaiSach(rs.getString(8));
				boolean trangThai=rs.getBoolean(9);
				String url=rs.getString(10);
				Sach sach=new Sach(maSach, tenSach, namXB, donGia, ngonNgu, tenTacGia, nhaxuatban, loaisach, trangThai, url );
				dsSach.add(sach);
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally 
		{
			try
			{
				statement.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return dsSach;
	}
	public ArrayList<Sach> getSachTheoTen(String id)
	{
		ArrayList<Sach> dsSach=new ArrayList<Sach>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="select maSach, tenSach, namXuatBan, donGia, ngonNgu, tacGia, NhaXuatBan.tenNXB, LoaiSach.tenLoaiSach, trangThai, urlAnh from Sach join NhaXuatBan on Sach.maNXB=NhaXuatBan.maNXB join LoaiSach on Sach.maLoaiSach=LoaiSach.maLoaiSach where tenSach=?";
			statement=con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				String maSach=rs.getString(1);
				String tenSach=rs.getString(2);
				Date namXB=rs.getDate(3);
				double donGia=rs.getDouble(4);
				String ngonNgu=rs.getString(5);
				String tenTacGia=rs.getString(6);
				NhaXuatBan nhaxuatban=new NhaXuatBan(rs.getString(7));
				LoaiSach loaisach=new LoaiSach(rs.getString(8));
				boolean trangThai=rs.getBoolean(9);
				String url=rs.getString(10);
				Sach sach=new Sach(maSach, tenSach, namXB, donGia, ngonNgu, tenTacGia, nhaxuatban, loaisach, trangThai, url );
				dsSach.add(sach);
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally 
		{
			try
			{
				statement.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return dsSach;
	}
	public boolean create(Sach s)
	{
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try
		{
			stmt=con.prepareStatement("insert into Sach values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, s.getMaSach());
			stmt.setString(2, s.getTenSach());
			stmt.setDate(3, s.getNamXB());
			stmt.setDouble(4,  s.getDonGia());
			stmt.setString(5, s.getNgonNgu());
			stmt.setString(6, s.getTacgia());
			stmt.setString(7, s.getNhaxuatban().getMaNXB());
			stmt.setString(8, s.getLoaisach().getMaLoaiSach());
			stmt.setBoolean(9, s.isTrangThai());
			stmt.setString(10, s.getUrlAnh());
			n=stmt.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				stmt.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return n>0;
	}
	/*public boolean delete(String maSach) {
		Connection con = ConnectDB.getInstance().getConnection();
		
		PreparedStatement stmt =null;
		
		int n=0;
		
		try {
			stmt =con.prepareStatement("delete from Sach where maSach=?");
			stmt.setString(1, maSach);
			n=stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return n>0;
	}*/
	public boolean update(Sach sach)
	{
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try
		{
			stmt=con.prepareStatement("update Sach set tenSach=?, namXuatBan=?, donGia=?, ngonNgu=?, tacGia=?, maNXB=?, maLoaiSach=?, trangThai=?, urlAnh=?"+ " where maSach=?");
			stmt.setString(1, sach.getTenSach());
			stmt.setDate(2, sach.getNamXB());
			stmt.setDouble(3, sach.getDonGia());
			stmt.setString(4, sach.getNgonNgu());
			stmt.setString(5, sach.getTacgia());
			stmt.setString(6, sach.getNhaxuatban().getMaNXB());
			stmt.setString(7, sach.getLoaisach().getMaLoaiSach());
			stmt.setBoolean(8, sach.isTrangThai());
			stmt.setString(9, sach.getUrlAnh());
			stmt.setString(10, sach.getMaSach());
			n=stmt.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				stmt.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public boolean updateTrangThaiSach(Sach maSach)
	{
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try
		{
			stmt=con.prepareStatement("update Sach set trangThai=0"+ " where maSach=?");
			stmt.setString(1, maSach.getMaSach());
			n=stmt.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				stmt.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public boolean updateKH(KhachHang kh)
	{
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try
		{
			stmt=con.prepareStatement("update KhachHang set tenKH=?, SDT=?, email=?, maLoaiKH=?, gioiTinh=?, diaChi=?"+ " where maKH=?");
			stmt.setString(1, kh.getTenKH());
			
			n=stmt.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				stmt.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return n>0;
	}
	
}
