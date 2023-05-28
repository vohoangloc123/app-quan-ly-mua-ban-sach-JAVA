package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.NhanVien;
import entity.QuanLy;
import entity.Sach;

public class QuanLy_DAO {
	public ArrayList<QuanLy> getQuanLyTheoMa(String id)
	{
		ArrayList<QuanLy> dsQL=new ArrayList<QuanLy>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try
		{
			String sql="select tenTK, matKhau, tenQuanLy from QuanLy where tenTK=?";
			statement=con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				String tenTK=rs.getString(1);
				String matKhau=rs.getString(2);
				String tenQL=rs.getString(3);
				QuanLy QL=new QuanLy(tenTK, matKhau, tenQL);
				dsQL.add(QL);
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
		return dsQL;
	}
	public boolean updateMatKhau(QuanLy quanLy)
	{
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try
		{
			stmt=con.prepareStatement("UPDATE QuanLy SET matKhau = ? WHERE QuanLy.tenTK = ?");
			stmt.setString(1, quanLy.getMatKhau());
			stmt.setString(2, quanLy.getTenTK());
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
