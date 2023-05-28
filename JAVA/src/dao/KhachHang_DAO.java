package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiKhachHang;
import entity.LoaiSach;
import entity.NhaXuatBan;
import entity.NhanVien;
import entity.Sach;

public class KhachHang_DAO {
	public ArrayList<KhachHang> getallKhachHang(){
		ArrayList<KhachHang> dsKhachHang=new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			String sql="select maKH, tenKH, SDT, email, LoaiKhachHang.tenLoaiKH, gioiTinh, diaChi from KhachHang join LoaiKhachHang on KhachHang.maLoaiKH=LoaiKhachHang.maLoaiKH";

			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maKH=rs.getString(1);
				String tenKH=rs.getString(2);
				String SDT=rs.getString(3);
				String email=rs.getString(4);
				LoaiKhachHang loaiKH=new LoaiKhachHang(rs.getString(5));
				boolean gioiTinh=rs.getBoolean(6);
				String diaChi=rs.getString(7);
				KhachHang kh=new KhachHang(maKH, tenKH, SDT, email, loaiKH, gioiTinh, diaChi);
				dsKhachHang.add(kh);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsKhachHang;
	}
	public ArrayList<KhachHang> getallKhachHangTangDanTheoTen(){
		ArrayList<KhachHang> dsKhachHang=new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			String sql="select maKH, tenKH, SDT, email, LoaiKhachHang.tenLoaiKH, gioiTinh, diaChi from KhachHang join LoaiKhachHang on KhachHang.maLoaiKH=LoaiKhachHang.maLoaiKH order by KhachHang.tenKH asc";

			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maKH=rs.getString(1);
				String tenKH=rs.getString(2);
				String SDT=rs.getString(3);
				String email=rs.getString(4);
				LoaiKhachHang loaiKH=new LoaiKhachHang(rs.getString(5));
				boolean gioiTinh=rs.getBoolean(6);
				String diaChi=rs.getString(7);
				KhachHang kh=new KhachHang(maKH, tenKH, SDT, email, loaiKH, gioiTinh, diaChi);
				dsKhachHang.add(kh);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsKhachHang;
	}
	public ArrayList<KhachHang> getallKhachHangGiamDanTheoTen(){
		ArrayList<KhachHang> dsKhachHang=new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			String sql="select maKH, tenKH, SDT, email, LoaiKhachHang.tenLoaiKH, gioiTinh, diaChi from KhachHang join LoaiKhachHang on KhachHang.maLoaiKH=LoaiKhachHang.maLoaiKH order by KhachHang.tenKH desc";

			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maKH=rs.getString(1);
				String tenKH=rs.getString(2);
				String SDT=rs.getString(3);
				String email=rs.getString(4);
				LoaiKhachHang loaiKH=new LoaiKhachHang(rs.getString(5));
				boolean gioiTinh=rs.getBoolean(6);
				String diaChi=rs.getString(7);
				KhachHang kh=new KhachHang(maKH, tenKH, SDT, email, loaiKH, gioiTinh, diaChi);
				dsKhachHang.add(kh);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsKhachHang;
	}
	public ArrayList<KhachHang> getKhachHangTheoMa(String id)
	{
		ArrayList<KhachHang> dsKhachHang=new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="select maKH, tenKH, SDT, email, LoaiKhachHang.tenLoaiKH, gioiTinh, diaChi from KhachHang join LoaiKhachHang on KhachHang.maLoaiKH=LoaiKhachHang.maLoaiKH where maKH=?";
			statement=con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				String maKH=rs.getString(1);
				String tenKH=rs.getString(2);
				String SDT=rs.getString(3);
				String email=rs.getString(4);
				LoaiKhachHang loaiKH=new LoaiKhachHang(rs.getString(5));
				boolean gioiTinh=rs.getBoolean(6);
				String diaChi=rs.getString(7);
				KhachHang kh=new KhachHang(maKH, tenKH, SDT, email, loaiKH, gioiTinh, diaChi);
				dsKhachHang.add(kh);
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
		return dsKhachHang;
	}
	public ArrayList<KhachHang> getKhachHangTheoTen(String id)
	{
		ArrayList<KhachHang> dsKhachHang=new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="select maKH, tenKH, SDT, email, LoaiKhachHang.tenLoaiKH, gioiTinh, diaChi from KhachHang join LoaiKhachHang on KhachHang.maLoaiKH=LoaiKhachHang.maLoaiKH where tenKH=?";
			statement=con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				String maKH=rs.getString(1);
				String tenKH=rs.getString(2);
				String SDT=rs.getString(3);
				String email=rs.getString(4);
				LoaiKhachHang loaiKH=new LoaiKhachHang(rs.getString(5));
				boolean gioiTinh=rs.getBoolean(6);
				String diaChi=rs.getString(7);
				KhachHang kh=new KhachHang(maKH, tenKH, SDT, email, loaiKH, gioiTinh, diaChi);
				dsKhachHang.add(kh);
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
		return dsKhachHang;
	}
	public boolean createKH(KhachHang kh)
	{
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try
		{
			stmt=con.prepareStatement("insert into KhachHang values(?,?,?,?,?,?,?)");
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getTenKH());
			stmt.setString(3, kh.getSDT());
			stmt.setString(4, kh.getEmail());
			stmt.setString(5,  kh.getLoaiKhachHang().getMaLoaiKH());
			stmt.setBoolean(6, kh.isGioiTinh());
			stmt.setString(7, kh.getDiaChi());
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
	public boolean deleteKH(String maKH) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt =null;
		int n=0;
		try {
			stmt =con.prepareStatement("delete from KhachHang where maKH=?");
			stmt.setString(1, maKH);
			n=stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
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
			stmt.setString(2, kh.getSDT());
			stmt.setString(3, kh.getEmail());
			stmt.setString(4, kh.getLoaiKhachHang().getMaLoaiKH());
			stmt.setBoolean(5, kh.isGioiTinh());
			stmt.setString(6, kh.getDiaChi());
			stmt.setString(7, kh.getMaKH());
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