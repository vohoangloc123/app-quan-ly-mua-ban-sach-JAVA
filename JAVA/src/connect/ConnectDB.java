package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectDB {

	public static Connection con=null;
	private static ConnectDB instance=new ConnectDB();
	public static ConnectDB getInstance()
	{
		return instance;
	}
	public void connect() throws SQLException
	{
		String url="jdbc:sqlserver://localhost:1433;databasename=QuanLyCuaHangSach";
		String user="sa";
		String passwords="sapassword";
		con=DriverManager.getConnection(url,user,passwords);
		System.out.println("Thành công");
		
		
	}
	public void disconnect()
	{
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			
			}
	}
	public static Connection getConnection()
	{
		return con;
	}
	
}