package dao;
import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiSach;
import entity.NhaXuatBan;
import entity.NhanVien;
import entity.Sach;


public class HoaDon_DAO {
	public ArrayList<HoaDon> getallHoaDon(){
		ArrayList<HoaDon> dsHoaDon=new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			String sql="select maHoaDon, NhanVien.tenNV, ngayLapHoaDon, uuDai, Sach.tenSach,KhachHang.tenKH, tongTien  from HoaDon left join NhanVien on NhanVien.maNV=HoaDon.maNV left join Sach on HoaDon.maSach=Sach.maSach left join KhachHang on HoaDon.maKH=KhachHang.maKH WHERE HoaDon.trangThai IS NULL ORDER BY ngayLapHoaDon asc";

			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maHD=rs.getString(1);
				NhanVien nv=new NhanVien(rs.getString(2));
				Date ngayLapHD=rs.getDate(3);
				boolean uuDai = rs.getBoolean(4);
				Sach sach=new Sach(rs.getString(5));
				KhachHang khachHang=new KhachHang(rs.getString(6));
				Double tongTien=rs.getDouble(7);
				HoaDon hoaDon=new HoaDon(maHD, nv, ngayLapHD, uuDai, sach, khachHang, tongTien);
				dsHoaDon.add(hoaDon);
				
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsHoaDon;
	}
	public ArrayList<HoaDon> getallHoaDonDaHuy(){
		ArrayList<HoaDon> dsHoaDon=new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			String sql="select maHoaDon, NhanVien.tenNV, ngayLapHoaDon, uuDai, Sach.tenSach, KhachHang.tenKH, tongTien  from HoaDon left join NhanVien on NhanVien.maNV=HoaDon.maNV left join Sach on HoaDon.maSach=Sach.maSach left join KhachHang on HoaDon.maKH=KhachHang.maKH WHERE HoaDon.trangThai IS NOT NULL ORDER BY ngayLapHoaDon asc";

			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maHD=rs.getString(1);
				NhanVien nv=new NhanVien(rs.getString(2));
				Date ngayLapHD=rs.getDate(3);
				boolean uuDai = rs.getBoolean(4);
				Sach sach=new Sach(rs.getString(5));
				KhachHang kh=new KhachHang(rs.getString(6));
				Double tongTien=rs.getDouble(7);
				HoaDon hoaDon=new HoaDon(maHD, nv, ngayLapHD, uuDai, sach, kh, tongTien);
				dsHoaDon.add(hoaDon);
				
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsHoaDon;
	}
	public ArrayList<HoaDon> getallHoaDonTrongTuanGanNhat(){
		ArrayList<HoaDon> dsHoaDon=new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			String sql="select maHoaDon, NhanVien.tenNV, ngayLapHoaDon, uuDai, Sach.tenSach, KhachHang.tenKH, tongTien  from HoaDon left join NhanVien on NhanVien.maNV=HoaDon.maNV left join Sach on HoaDon.maSach=Sach.maSach left join KhachHang on HoaDon.maKH=KhachHang.maKH WHERE HoaDon.trangThai IS NULL and DATEDIFF(DAY, ngayLapHoaDon ,GETDATE())<=7 ORDER BY ngayLapHoaDon asc";

			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maHD=rs.getString(1);
				NhanVien nv=new NhanVien(rs.getString(2));
				Date ngayLapHD=rs.getDate(3);
				boolean uuDai = rs.getBoolean(4);
				Sach sach=new Sach(rs.getString(5));
				KhachHang kh=new KhachHang(rs.getString(6));
				Double tongTien=rs.getDouble(7);
				HoaDon hoaDon=new HoaDon(maHD, nv, ngayLapHD, uuDai, sach, kh, tongTien);
				dsHoaDon.add(hoaDon);
				
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsHoaDon;
	}
	public ArrayList<HoaDon> getallHoaDonThangNay(){
		ArrayList<HoaDon> dsHoaDon=new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			String sql="select maHoaDon, NhanVien.tenNV, ngayLapHoaDon, uuDai, Sach.tenSach,KhachHang.tenKH, tongTien  from HoaDon left join NhanVien on NhanVien.maNV=HoaDon.maNV left join Sach on HoaDon.maSach=Sach.maSach left join KhachHang on HoaDon.maKH=KhachHang.maKH WHERE HoaDon.trangThai IS NULL and MONTH(ngayLapHoaDon) = MONTH(GETDATE()) ORDER BY ngayLapHoaDon asc";

			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maHD=rs.getString(1);
				NhanVien nv=new NhanVien(rs.getString(2));
				Date ngayLapHD=rs.getDate(3);
				boolean uuDai = rs.getBoolean(4);
				Sach sach=new Sach(rs.getString(5));
				KhachHang kh=new KhachHang(rs.getString(6));
				Double tongTien=rs.getDouble(7);
				HoaDon hoaDon=new HoaDon(maHD, nv, ngayLapHD, uuDai, sach, kh, tongTien);
				dsHoaDon.add(hoaDon);
				
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsHoaDon;
	}
	public ArrayList<HoaDon> getallHoaDonNgayHomNay(){
		ArrayList<HoaDon> dsHoaDon=new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			String sql="select maHoaDon, NhanVien.tenNV, ngayLapHoaDon, uuDai, Sach.tenSach, KhachHang.tenKH, tongTien from HoaDon left join NhanVien on NhanVien.maNV=HoaDon.maNV left join Sach on HoaDon.maSach=Sach.maSach left join KhachHang on HoaDon.maKH=KhachHang.maKH WHERE HoaDon.trangThai IS NULL and ngayLapHoaDon >= cast(getdate() as date)\r\n"
					+ "and ngayLapHoaDon < cast(getdate()+1 as date) ORDER BY ngayLapHoaDon asc";

			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maHD=rs.getString(1);
				NhanVien nv=new NhanVien(rs.getString(2));
				Date ngayLapHD=rs.getDate(3);
				boolean uuDai = rs.getBoolean(4);
				Sach sach=new Sach(rs.getString(5));
				KhachHang kh=new KhachHang(rs.getString(6));
				Double tongTien=rs.getDouble(7);
				HoaDon hoaDon=new HoaDon(maHD, nv, ngayLapHD, uuDai, sach, kh, tongTien);
				dsHoaDon.add(hoaDon);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsHoaDon;
	}
	public ArrayList<HoaDon> getHoaDonTheoMa(String id)
	{
		ArrayList<HoaDon> dsHoaDon=new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="select maHoaDon, NhanVien.tenNV, ngayLapHoaDon, uuDai, Sach.tenSach,KhachHang.tenKH, tongTien  from HoaDon left join NhanVien on NhanVien.maNV=HoaDon.maNV left join Sach on HoaDon.maSach=Sach.maSach left join KhachHang on HoaDon.maKH=KhachHang.maKH where HoaDon.trangThai IS NULL and maHoaDon=?";
			statement=con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				String maHD=rs.getString(1);
				NhanVien nv=new NhanVien(rs.getString(2));
				Date ngayLapHD=rs.getDate(3);
				boolean uuDai = rs.getBoolean(4);
				Sach sach=new Sach(rs.getString(5));
				KhachHang kh=new KhachHang(rs.getString(6));
				Double tongTien=rs.getDouble(7);
				HoaDon hoaDon=new HoaDon(maHD, nv, ngayLapHD, uuDai, sach, kh, tongTien);
				dsHoaDon.add(hoaDon);
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
		return dsHoaDon;
	}
	public ArrayList<HoaDon> getHoaDonDaHuyTheoMa(String id)
	{
		ArrayList<HoaDon> dsHoaDon=new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="select maHoaDon, NhanVien.tenNV, ngayLapHoaDon, uuDai, Sach.tenSach,KhachHang.tenKH, tongTien  from HoaDon left join NhanVien on NhanVien.maNV=HoaDon.maNV left join Sach on HoaDon.maSach=Sach.maSach left join KhachHang on HoaDon.maKH=KhachHang.maKH where HoaDon.trangThai IS NOT NULL and maHoaDon=?";
			statement=con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				String maHD=rs.getString(1);
				NhanVien nv=new NhanVien(rs.getString(2));
				Date ngayLapHD=rs.getDate(3);
				boolean uuDai = rs.getBoolean(4);
				Sach sach=new Sach(rs.getString(5));
				KhachHang kh=new KhachHang(rs.getString(6));
				Double tongTien=rs.getDouble(7);
				HoaDon hoaDon=new HoaDon(maHD, nv, ngayLapHD, uuDai, sach, kh, tongTien);
				dsHoaDon.add(hoaDon);
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
		return dsHoaDon;
	}
	public ArrayList<HoaDon> getGiamGia(){
		ArrayList<HoaDon> dsHoaDon=new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql="Select * from HoaDon";
			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maLoaiNV=rs.getString(1);
				boolean uuDai=rs.getBoolean(2);
				HoaDon hd=new HoaDon(maLoaiNV, uuDai);
				dsHoaDon.add(hd);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsHoaDon;
}
	public boolean createHoaDonCoKH(HoaDon hd)
	{
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try
		{
			stmt=con.prepareStatement("insert into HoaDon values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, hd.getMaHD());
			stmt.setString(2, hd.getNguoiLapHD().getMaNV());
			stmt.setDate(3, hd.getNgayLapHD());
			stmt.setBoolean(4,  hd.isUuDai());
			stmt.setString(5,  hd.getTenSach().getMaSach());
			stmt.setString(6, hd.getKhachHang().getMaKH());
			stmt.setDouble(7, hd.getTongTien());
			stmt.setNull(8, Types.NULL);
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
	public boolean createHoaDonKhongCoKH(HoaDon hd)
	{
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try
		{
			stmt=con.prepareStatement("insert into HoaDon values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, hd.getMaHD());
			stmt.setString(2, hd.getNguoiLapHD().getMaNV());
			stmt.setDate(3, hd.getNgayLapHD());
			stmt.setBoolean(4,  hd.isUuDai());
			stmt.setString(5,  hd.getTenSach().getMaSach());
			stmt.setNull(6, Types.NULL);
			stmt.setDouble(7, hd.getTongTien());
			stmt.setNull(8, Types.NULL);
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
	public ArrayList<HoaDon> getHoaDonTheoThangVaNam(String month, String year) {
		ArrayList<HoaDon> dsHoaDon=new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="select maHoaDon, NhanVien.tenNV, ngayLapHoaDon, uuDai, Sach.tenSach,KhachHang.tenKH, tongTien  from HoaDon left join NhanVien on NhanVien.maNV=HoaDon.maNV left join Sach on HoaDon.maSach=Sach.maSach left join KhachHang on HoaDon.maKH=KhachHang.maKH WHERE HoaDon.trangThai is null and MONTH(ngayLapHoaDon) = ? and YEAR(ngayLapHoaDon) =? ORDER BY ngayLapHoaDon asc ";
			statement=con.prepareStatement(sql);
			statement.setString(1, month);
			statement.setString(2, year);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				String maHD=rs.getString(1);
				NhanVien nv=new NhanVien(rs.getString(2));
				Date ngayLapHD=rs.getDate(3);
				boolean uuDai = rs.getBoolean(4);
				Sach sach=new Sach(rs.getString(5));
				KhachHang kh=new KhachHang(rs.getString(6));
				Double tongTien=rs.getDouble(7);
				HoaDon hoaDon=new HoaDon(maHD, nv, ngayLapHD, uuDai, sach, kh, tongTien);
				dsHoaDon.add(hoaDon);
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
		return dsHoaDon;
	}
	public ArrayList<HoaDon> getTongTienCacHoaDon(String month, String year) {
		ArrayList<HoaDon> dsHoaDon=new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="SELECT SUM(tongTien)FROM HoaDon\r\n"
					+ "WHERE MONTH(ngayLapHoaDon) = ? and YEAR(ngayLapHoaDon) = ? and HoaDon.trangThai IS NULL";
			statement=con.prepareStatement(sql);
			statement.setString(1, month);
			statement.setString(2, year);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				Double tongTien=rs.getDouble(1);
				HoaDon hoaDon=new HoaDon(tongTien);
				dsHoaDon.add(hoaDon);
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
		return dsHoaDon;
	}
	public ArrayList<HoaDon> getTongSoHoaDonNgayHomQua() {
		ArrayList<HoaDon> dsHoaDon=new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="select  count(maHoaDon) as tongHoaDon\r\n"
					+ "from HoaDon\r\n"
					+ "where ngayLapHoaDon >= dateadd(day,datediff(day,1,GETDATE()),0)\r\n"
					+ "        AND ngayLapHoaDon < dateadd(day,datediff(day,0,GETDATE()),0) and HoaDon.trangThai IS NULL";
			statement=con.prepareStatement(sql);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				int soHoaDon=rs.getInt(1);
				HoaDon hoaDon=new HoaDon(soHoaDon);
				dsHoaDon.add(hoaDon);
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
		return dsHoaDon;
	}
	public ArrayList<HoaDon> getTongSoHoaDonNgayHomNay() {
		ArrayList<HoaDon> dsHoaDon=new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="select count(maHoaDon) from HoaDon\r\n"
					+ "where cast(ngayLapHoaDon as Date) = cast(getdate() as Date) and HoaDon.trangThai IS NULL";
			statement=con.prepareStatement(sql);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				int soHoaDon=rs.getInt(1);
				HoaDon hoaDon=new HoaDon(soHoaDon);
				dsHoaDon.add(hoaDon);
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
		return dsHoaDon;
	}
	public ArrayList<HoaDon> getTongSoHoaDonTuanNay() {
		ArrayList<HoaDon> dsHoaDon=new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="SELECT count(maHoaDon) as tongHoaDon\r\n"
					+ "					FROM HoaDon\r\n"
					+ "					WHERE  ngayLapHoaDon >= dateadd(day, 1-datepart(dw, getdate()), CONVERT(date,getdate())) \r\n"
					+ "					AND ngayLapHoaDon <  dateadd(day, 8-datepart(dw, getdate()), CONVERT(date,getdate())) and HoaDon.trangThai IS NULL";
			statement=con.prepareStatement(sql);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				int soHoaDon=rs.getInt(1);
				HoaDon hoaDon=new HoaDon(soHoaDon);
				dsHoaDon.add(hoaDon);
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
		return dsHoaDon;
	}
	public ArrayList<HoaDon> getTongSoHoaDonThangNay() {
		ArrayList<HoaDon> dsHoaDon=new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="select count(maHoaDon)\r\n"
					+ "from HoaDon\r\n"
					+ "where MONTH(ngayLapHoaDon) = MONTH(GETDATE()) and HoaDon.trangThai IS NULL";
			statement=con.prepareStatement(sql);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				int soHoaDon=rs.getInt(1);
				HoaDon hoaDon=new HoaDon(soHoaDon);
				dsHoaDon.add(hoaDon);
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
		return dsHoaDon;
	}
	public ArrayList<HoaDon> getTongDoanhThuHomNay() {
		ArrayList<HoaDon> dsHoaDon=new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="SELECT SUM(tongTien)FROM HoaDon\r\n"
					+ "where cast(ngayLapHoaDon as Date) = cast(getdate() as Date) and HoaDon.trangThai IS NULL";
			statement=con.prepareStatement(sql);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				Double tongTien=rs.getDouble(1);
				HoaDon hoaDon=new HoaDon(tongTien);
				dsHoaDon.add(hoaDon);
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
		return dsHoaDon;
	}
	public ArrayList<HoaDon> getTongDoanhThuHomQua() {
		ArrayList<HoaDon> dsHoaDon=new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="SELECT SUM(tongTien)FROM HoaDon\r\n"
					+ "where ngayLapHoaDon >= dateadd(day,datediff(day,1,GETDATE()),0) AND ngayLapHoaDon < dateadd(day,datediff(day,0,GETDATE()),0) and HoaDon.trangThai IS NULL";
			statement=con.prepareStatement(sql);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				Double tongTien=rs.getDouble(1);
				HoaDon hoaDon=new HoaDon(tongTien);
				dsHoaDon.add(hoaDon);
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
		return dsHoaDon;
	}
	public ArrayList<HoaDon> getTongDoanhThuTuanNay() {
		ArrayList<HoaDon> dsHoaDon=new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="SELECT SUM(tongTien)FROM HoaDon\r\n"
					+ "WHERE  ngayLapHoaDon >= dateadd(day, 1-datepart(dw, getdate()), CONVERT(date,getdate())) AND ngayLapHoaDon <  dateadd(day, 8-datepart(dw, getdate()), CONVERT(date,getdate())) and HoaDon.trangThai IS NULL";
			statement=con.prepareStatement(sql);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				Double tongTien=rs.getDouble(1);
				HoaDon hoaDon=new HoaDon(tongTien);
				dsHoaDon.add(hoaDon);
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
		return dsHoaDon;
	}
	public ArrayList<HoaDon> getTongDoanhThuThangNay() {
		ArrayList<HoaDon> dsHoaDon=new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="SELECT SUM(tongTien)FROM HoaDon\r\n"
					+ "WHERE MONTH(ngayLapHoaDon) = MONTH(GETDATE()) and HoaDon.trangThai IS NULL";
			statement=con.prepareStatement(sql);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				Double tongTien=rs.getDouble(1);
				HoaDon hoaDon=new HoaDon(tongTien);
				dsHoaDon.add(hoaDon);
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
		return dsHoaDon;
	}
	public boolean xoaHD(HoaDon hd)
	{
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try
		{
			stmt=con.prepareStatement("update HoaDon set trangThai=1 where maHoaDon=?");
			stmt.setString(1, hd.getMaHD());
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
