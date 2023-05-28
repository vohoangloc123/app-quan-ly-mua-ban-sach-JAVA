package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.LoaiNhanVien;
import entity.NhanVien;
import entity.QuanLy;

public class NhanVien_DAO {
	public ArrayList<NhanVien> getallNhanVien(){
		ArrayList<NhanVien> dsNV=new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			String sql="select maNV, tenNV, LoaiNhanVien.chucVu, CCCD, SDT, ngaySinh, ngayVaoLam, diaChi, email, gioiTinh, matKhau, trangThai, urlAnhNV from NhanVien join LoaiNhanVien on NhanVien.maLoaiNV=LoaiNhanVien.maLoaiNV ";

			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maNV=rs.getString(1);
				String tenNV=rs.getString(2);
				LoaiNhanVien loaiNV=new LoaiNhanVien(rs.getString(3));
				String CCCD=rs.getString(4);
				String SDT=rs.getString(5);
				Date ngaySinh=rs.getDate(6);
				Date ngayVaoLam=rs.getDate(7);
				String diaChi=rs.getString(8);
				String email=rs.getString(9);
				boolean gioitinh=rs.getBoolean(10);
				String matKhau=rs.getString(11);
				boolean trangThai=rs.getBoolean(12);
				String urlAnhNV=rs.getString(13);
				NhanVien nv=new NhanVien(maNV, tenNV, loaiNV, CCCD, SDT, ngaySinh, ngayVaoLam, diaChi, email, gioitinh, matKhau, trangThai, urlAnhNV);
				dsNV.add(nv);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsNV;
	}
	public ArrayList<NhanVien> getallNhanVienTangDanTheoTen(){
		ArrayList<NhanVien> dsNV=new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			String sql="select maNV, tenNV, LoaiNhanVien.chucVu, CCCD, SDT, ngaySinh, ngayVaoLam, diaChi, email, gioiTinh, matKhau, trangThai, urlAnhNV from NhanVien join LoaiNhanVien on NhanVien.maLoaiNV=LoaiNhanVien.maLoaiNV ORDER BY NhanVien.tenNV asc";

			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maNV=rs.getString(1);
				String tenNV=rs.getString(2);
				LoaiNhanVien loaiNV=new LoaiNhanVien(rs.getString(3));
				String CCCD=rs.getString(4);
				String SDT=rs.getString(5);
				Date ngaySinh=rs.getDate(6);
				Date ngayVaoLam=rs.getDate(7);
				String diaChi=rs.getString(8);
				String email=rs.getString(9);
				boolean gioitinh=rs.getBoolean(10);
				String matKhau=rs.getString(11);
				boolean trangThai=rs.getBoolean(12);
				String urlAnhNV=rs.getString(13);
				NhanVien nv=new NhanVien(maNV, tenNV, loaiNV, CCCD, SDT, ngaySinh, ngayVaoLam, diaChi, email, gioitinh, matKhau, trangThai, urlAnhNV);
				dsNV.add(nv);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsNV;
	}
	public ArrayList<NhanVien> getallNhanVienGiamDanTheoTen(){
		ArrayList<NhanVien> dsNV=new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			
			String sql="select maNV, tenNV, LoaiNhanVien.chucVu, CCCD, SDT, ngaySinh, ngayVaoLam, diaChi, email, gioiTinh, matKhau, trangThai, urlAnhNV from NhanVien join LoaiNhanVien on NhanVien.maLoaiNV=LoaiNhanVien.maLoaiNV ORDER BY NhanVien.tenNV desc";

			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String maNV=rs.getString(1);
				String tenNV=rs.getString(2);
				LoaiNhanVien loaiNV=new LoaiNhanVien(rs.getString(3));
				String CCCD=rs.getString(4);
				String SDT=rs.getString(5);
				Date ngaySinh=rs.getDate(6);
				Date ngayVaoLam=rs.getDate(7);
				String diaChi=rs.getString(8);
				String email=rs.getString(9);
				boolean gioitinh=rs.getBoolean(10);
				String matKhau=rs.getString(11);
				boolean trangThai=rs.getBoolean(12);
				String urlAnhNV=rs.getString(13);
				NhanVien nv=new NhanVien(maNV, tenNV, loaiNV, CCCD, SDT, ngaySinh, ngayVaoLam, diaChi, email, gioitinh, matKhau, trangThai, urlAnhNV);
				dsNV.add(nv);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dsNV;
	}
	public boolean createNV(NhanVien nv)
	{
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try
		{
			stmt=con.prepareStatement("insert into NhanVien values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, nv.getMaNV());
			stmt.setString(2, nv.getTenNV());
			stmt.setString(3, nv.getLoaiNV().getMaLoaiNV());
			stmt.setString(4, nv.getCCCD());
			stmt.setString(5,  nv.getSDT());
			stmt.setDate(6, nv.getNgaySinh());
			stmt.setDate(7, nv.getNgayVaoLam());
			stmt.setString(8, nv.getDiaChi());
			stmt.setString(9, nv.getEmail());
			stmt.setBoolean(10, nv.isGioiTinh());
			stmt.setString(11, nv.getMatKhau());
			stmt.setBoolean(12, nv.isTrangThai());
			stmt.setString(13, nv.getUrlAnhNV());
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
	public boolean updateNV(NhanVien nv)
	{
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try
		{
			stmt=con.prepareStatement("update NhanVien set tenNV=?, maLoaiNV=?, CCCD=?, SDT=?, ngaySinh=?, ngayVaoLam=?, diaChi=?, email=?, gioiTinh=?, matKhau=?, trangThai=?, urlAnhNV=?"+ " where maNV=?");
			stmt.setString(1, nv.getTenNV());
			stmt.setString(2, nv.getLoaiNV().getMaLoaiNV());
			stmt.setString(3, nv.getCCCD());
			stmt.setString(4, nv.getSDT());
			stmt.setDate(5, nv.getNgaySinh());
			stmt.setDate(6, nv.getNgayVaoLam());
			stmt.setString(7, nv.getDiaChi());
			stmt.setString(8, nv.getEmail());
			stmt.setBoolean(9, nv.isGioiTinh());
			stmt.setString(10, nv.getMatKhau());
			stmt.setBoolean(11, nv.isTrangThai());
			stmt.setString(12, nv.getUrlAnhNV());
			stmt.setString(13, nv.getMaNV());
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
	public ArrayList<NhanVien> getNhanVienTheoMa(String id)
	{
		ArrayList<NhanVien> dsNV=new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="select maNV, tenNV, LoaiNhanVien.chucVu, CCCD, SDT, ngaySinh, ngayVaoLam, diaChi, email, gioiTinh, matKhau, trangThai, urlAnhNV from NhanVien join LoaiNhanVien on NhanVien.maLoaiNV=LoaiNhanVien.maLoaiNV  where maNV=?";
			statement=con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				String maNV=rs.getString(1);
				String tenNV=rs.getString(2);
				LoaiNhanVien loaiNV=new LoaiNhanVien(rs.getString(3));
				String CCCD=rs.getString(4);
				String SDT=rs.getString(5);
				Date ngaySinh=rs.getDate(6);
				Date ngayVaoLam=rs.getDate(7);
				String diaChi=rs.getString(8);
				String email=rs.getString(9);
				boolean gioitinh=rs.getBoolean(10);
				String matKhau=rs.getString(11);
				boolean trangThai=rs.getBoolean(12);
				String urlAnhNV=rs.getString(13);
				NhanVien nv=new NhanVien(maNV, tenNV, loaiNV, CCCD, SDT, ngaySinh, ngayVaoLam, diaChi, email, gioitinh, matKhau, trangThai, urlAnhNV);
				dsNV.add(nv);
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
		return dsNV;
	}
	public ArrayList<NhanVien> getNhanVienTheoTen(String id)
	{
		ArrayList<NhanVien> dsNV=new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="select maNV, tenNV, LoaiNhanVien.chucVu, CCCD, SDT, ngaySinh, ngayVaoLam, diaChi, email, gioiTinh, matKhau, trangThai, urlAnhNV from NhanVien join LoaiNhanVien on NhanVien.maLoaiNV=LoaiNhanVien.maLoaiNV  where tenNV=?";
			statement=con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				String maNV=rs.getString(1);
				String tenNV=rs.getString(2);
				LoaiNhanVien loaiNV=new LoaiNhanVien(rs.getString(3));
				String CCCD=rs.getString(4);
				String SDT=rs.getString(5);
				Date ngaySinh=rs.getDate(6);
				Date ngayVaoLam=rs.getDate(7);
				String diaChi=rs.getString(8);
				String email=rs.getString(9);
				boolean gioitinh=rs.getBoolean(10);
				String matKhau=rs.getString(11);
				boolean trangThai=rs.getBoolean(12);
				String urlAnhNV=rs.getString(13);
				NhanVien nv=new NhanVien(maNV, tenNV, loaiNV, CCCD, SDT, ngaySinh, ngayVaoLam, diaChi, email, gioitinh, matKhau, trangThai, urlAnhNV);
				dsNV.add(nv);
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
		return dsNV;
	}
	public boolean updateTrangThaiNV(NhanVien nv)
	{
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try
		{
			stmt=con.prepareStatement("update NhanVien set trangThai=0"+ " where maNV=?");
			stmt.setString(1, nv.getMaNV());
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
	public boolean updateMatKhau(NhanVien nv)
	{
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try
		{
			stmt=con.prepareStatement("UPDATE NhanVien SET matKhau = ? WHERE NhanVien.maNV = ?");
			stmt.setString(1, nv.getMatKhau());
			stmt.setString(2, nv.getMaNV());
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
