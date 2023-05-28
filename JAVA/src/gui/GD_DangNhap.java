package gui;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;

import connect.ConnectDB;
import dao.NhanVien_DAO;
import dao.QuanLy_DAO;
import entity.NhanVien;
import entity.QuanLy;

import javax.swing.event.ChangeEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;


import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GD_DangNhap extends JFrame {
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private NhanVien_DAO nhanvien_dao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
							.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
				} catch (ClassNotFoundException ex) {
					java.util.logging.Logger.getLogger(GD_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (InstantiationException ex) {
					java.util.logging.Logger.getLogger(GD_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (IllegalAccessException ex) {
					java.util.logging.Logger.getLogger(GD_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (javax.swing.UnsupportedLookAndFeelException ex) {
					java.util.logging.Logger.getLogger(GD_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				}
				try {
					GD_DangNhap frame = new GD_DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void LoginScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_DangNhap  window = new GD_DangNhap();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GD_DangNhap() {
		nhanvien_dao=new NhanVien_DAO();
		setIconImage(Toolkit.getDefaultToolkit().getImage("image\\login.png"));
		setTitle("ĐĂNG NHẬP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 307);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 607, 279);
		panel.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên tài khoản:");
		lblNewLabel.setBounds(220, 71, 156, 25);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 128, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("M\u1EADt kh\u1EA9u:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(222, 128, 109, 25);
		panel.add(lblNewLabel_1);
		JLabel lblUsername = new JLabel("");
		lblUsername.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblUsername.setForeground(new Color(255, 0, 0));
		lblUsername.setBounds(386, 102, 156, 19);
		panel.add(lblUsername);
		username = new JTextField();
		username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				
				if(evt.getKeyCode()== KeyEvent.VK_ENTER) {
					
					if(username.getText().trim().isEmpty()&& password.getText().trim().isEmpty())  {
						
					
						lblUsername.setText("Tài khoản không được trống!");
						
					
				}
			}
			}
		});
		username.setBounds(386, 75, 156, 31);
		panel.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("");
		
		
		lblPassword.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblPassword.setForeground(new Color(255, 0, 0));
		lblPassword.setBounds(386, 138, 167, 39);
		panel.add(lblPassword);
		contentPane = new JPanel();
		
		
		JComboBox QuyenTruyCap = new JComboBox();
		
		QuyenTruyCap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		QuyenTruyCap.setModel(new DefaultComboBoxModel(new String[] {"Quản lí","Nhân viên"}));
		QuyenTruyCap.setBounds(386, 28, 109, 25);
		panel.add(QuyenTruyCap);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(QuyenTruyCap.getSelectedIndex()== 0) {
					QuanLy_DAO quanly_dao=new QuanLy_DAO();
					String sql  ="Select * from QuanLy where tenTK ='"+ username.getText()+"' and matKhau = '"+password.getText()+"'";
					try {
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyCuaHangSach;user=sa;password=sapassword";
						Connection con = DriverManager.getConnection(url);
						PreparedStatement pst = con.prepareStatement(sql);
						ResultSet rs = pst.executeQuery();
						if(rs.next())
						{
						GD_Chinh M = new GD_Chinh();
						String store=username.getText();
						ArrayList<QuanLy> listQL=quanly_dao.getQuanLyTheoMa(store);
						for(QuanLy tenQL: listQL)
						{
										
							M.lblTenAD.setText(tenQL.getTenQuanLy());
							M.lblTenTk.setText(tenQL.getTenTK());
							
						}
						setVisible(false);
						M.setVisible(true);
						}else
						{
							JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu sai!");
							username.setText("");
							password.setText("");
							lblPassword.setText("");
							lblUsername.setText("");
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				else if(QuyenTruyCap.getSelectedIndex()==1)
				{
					String sql  ="Select * from NhanVien where maNV ='"+ username.getText()+"' and matKhau = '"+password.getText()+"'";
					try {
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyCuaHangSach;user=sa;password=sapassword";
						Connection con = DriverManager.getConnection(url);
						PreparedStatement pst = con.prepareStatement(sql);
						ResultSet rs = pst.executeQuery();
						
					 if(rs.next())
					 {
						 GD_ThanhToan tt =new GD_ThanhToan();
						 String store=username.getText();
						 ArrayList<NhanVien> listNV=nhanvien_dao.getNhanVienTheoMa(store);
							for(NhanVien tenNV: listNV)
							{										
								tt.lblTenNV.setText(tenNV.getTenNV());
								tt.lblAnhNV.setIcon(ResizeImage(String.valueOf(tenNV.getUrlAnhNV())));
							}
						 setVisible(false);
						 tt.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu sai!");
							username.setText("");
							password.setText("");
							lblPassword.setText("");
							lblUsername.setText("");
						}
						con.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
	
		});
		
		
		
		
		
	
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDangNhap.setBounds(318, 206, 133, 25);
		panel.add(btnDangNhap);
		
		password = new JPasswordField();
		password.addKeyListener(new KeyAdapter() {
			@Override
               public void keyPressed(java.awt.event.KeyEvent evt) {
				
				if(evt.getKeyCode()== KeyEvent.VK_ENTER) {
					
					if(username.getText().trim().isEmpty()&& password.getText().trim().isEmpty())  {
						
					
						lblPassword.setText("Mật khẩu không được trống!");
						
					
				}
			}
			}
		});
	
		
		
		
		password.setBounds(386, 122, 156, 31);
		panel.add(password);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(0, 0, 214, 282);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 34, 215, 48);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("image\\book_open_book_read_icon_186989.png"));
		
		JLabel lblNewLabel_5_1 = new JLabel("THE BOYS");
		lblNewLabel_5_1.setBounds(27, 139, 177, 37);
		panel_1.add(lblNewLabel_5_1);
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setForeground(SystemColor.info);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblNewLabel_5 = new JLabel("NHÀ SÁCH");
		lblNewLabel_5.setBounds(0, 92, 214, 37);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_5.setForeground(SystemColor.info);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBackground(SystemColor.activeCaption);
		lblNewLabel_4.setIcon(new ImageIcon("image\\backgroud.png"));
		lblNewLabel_4.setBounds(-14, 0, 228, 282);
		panel_1.add(lblNewLabel_4);
		
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		
	
	}
	private ImageIcon ResizeImage(String img_path) {
		GD_ThanhToan tt=new GD_ThanhToan();
		ImageIcon myIMG = new ImageIcon(img_path);
		Image img = myIMG.getImage();
		Image newIMG = img.getScaledInstance(tt.lblAnhNV.getWidth(), tt.lblAnhNV.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newIMG);
		return image;
	}
}
