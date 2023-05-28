package gui;

import javax.swing.JPanel;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;

import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import dao.LoaiKhachHang_DAO;
import dao.LoaiNhanVien_DAO;
import dao.LoaiSach_DAO;
import dao.NhaXuatBan_DAO;
import dao.NhanVien_DAO;
import dao.Sach_DAO;
import entity.KhachHang;
import entity.LoaiKhachHang;
import entity.LoaiNhanVien;
import entity.LoaiSach;
import entity.NhaXuatBan;
import entity.NhanVien;
import entity.Sach;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import java.awt.event.*;
import regex.MauRegex;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;
import javax.swing.JInternalFrame;
import java.awt.Canvas;

public class GD_NhanVien extends JFrame implements ActionListener, MouseListener{
	private JTable tableNhanVien;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JDateChooser txtNgaySinh;
	private JTextField txtSDT;
	private JTextField txtCCCD;
	private JDateChooser txtNgayVaoLam;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private LoaiNhanVien_DAO loaiNV_dao;
	private NhanVien_DAO nhanvien_dao;
	private JRadioButton chkNam;
	private JButton btnThem;
	private JButton btnLamMoi;
	private JButton btnSua;
	private DefaultTableModel modelNhanVien;
	private JComboBox<String> cboChucVu;
	private String maLoaiNhanVien;
	private JTextField txtMatKhau;
	private AbstractButton chkTrangThai;
	private JLabel lblAnhNV;
	private String urlAnh;
	private JButton btnChonAnh;
	private JFileChooser fileChooser;
	private JTextField txtAn;
	
	private JTabbedPane tabbedPane;
	private JTextField txtTimKiem;
	private Object btnTimKiem;
	private JTextField txtTaiKhoan;
	private JPanel jpnNhanVien;
	private JPanel jpnThemNhanVien;
	private JLabel lblcccd;
	private JLabel lblngaySinh;
	private JLabel lblmatKhau;
	private JLabel lblmaNV;
	private JLabel lblgioiTinh;
	private JLabel lbltrangThai;
	private JLabel lbltenNV;
	private JLabel lblsdt;
	private JLabel lbldiaChi;
	private JLabel lblemail;
	private JLabel lblAnhNV2;
	private JLabel lblngayVaoLam;
	private JLabel lblchucVu;
	private JButton btnTimKiemNV;
	private JButton btnXoa;
	private JButton btnHienTatCa;
	private JComboBox cboSapXep;
	private JComboBox cboTimKiem;

	
	
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
					java.util.logging.Logger.getLogger(GD_NhanVien.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (InstantiationException ex) {
					java.util.logging.Logger.getLogger(GD_NhanVien.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (IllegalAccessException ex) {
					java.util.logging.Logger.getLogger(GD_NhanVien.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (javax.swing.UnsupportedLookAndFeelException ex) {
					java.util.logging.Logger.getLogger(GD_NhanVien.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				}
				try {
					GD_NhanVien frame = new GD_NhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	public static void NhanVienScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 GD_NhanVien  NV = new GD_NhanVien();
					 NV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public GD_NhanVien() {
		getContentPane().setBackground(new Color(0, 128, 192));
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		nhanvien_dao=new NhanVien_DAO();
		loaiNV_dao=new LoaiNhanVien_DAO();

		setBackground(Color.GRAY);
		getContentPane().setLayout(null);
		setAutoRequestFocus(false);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		
		String[] colHeader = { "Mã nhân viên", "Tên nhân viên", "Chức vụ", "CCCD", "SĐT", "Ngày sinh", "Ngày vào làm","Địa chỉ", "Email", "Giới tính", "Mật khẩu", "Trạng thái" };
		modelNhanVien = new DefaultTableModel(colHeader, 0);
		txtAn=new JTextField();
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1530, 796);
		getContentPane().add(tabbedPane);
		
		jpnNhanVien = new JPanel();
		tabbedPane.addTab("Danh Sách Nhân Viên", null, jpnNhanVien, null);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 10));
		jpnNhanVien.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, new Color(64, 0, 64)));
		jpnNhanVien.setBackground(new Color(255, 255, 255));
		jpnNhanVien.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 192)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 933, 749);
		jpnNhanVien.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 911, 675);
		panel.add(scrollPane);
		tableNhanVien = new JTable(modelNhanVien);
		scrollPane.setViewportView(tableNhanVien);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimKiem.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(117, 14, 323, 31);
		panel.add(txtTimKiem);
		
		btnTimKiemNV = new JButton("");
		btnTimKiemNV.setIcon(new ImageIcon("image\\search.png"));
		btnTimKiemNV.setBounds(450, 14, 49, 31);
		panel.add(btnTimKiemNV);
		
		btnXoa = new JButton("");
		btnXoa.setIcon(new ImageIcon("C:\\Users\\nhatn\\Downloads\\New folder\\JAVA\\image\\delete.png"));
		btnXoa.setBounds(509, 13, 65, 31);
		panel.add(btnXoa);
		
		cboSapXep = new JComboBox();
		cboSapXep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboSapXep.getSelectedItem().equals("Tăng dần theo tên"))
				{
					DocDuLieuNhanVienTangDanTheoTenVaoTable();
				}
				else if(cboSapXep.getSelectedItem().equals("Giảm dần theo tên"))
				{
					DocDuLieuNhanVienGiamDanTheoTenVaoTable();
				}
			}
		});
		cboSapXep.setModel(new DefaultComboBoxModel(new String[] {"Tăng dần theo tên", "Giảm dần theo tên"}));
		cboSapXep.setBounds(763, 14, 158, 31);
		panel.add(cboSapXep);
		
		btnHienTatCa = new JButton("Hiện tất cả");
		btnHienTatCa.setBackground(new Color(0, 128, 192));
		btnHienTatCa.setForeground(new Color(255, 255, 255));
		btnHienTatCa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHienTatCa.setBounds(584, 14, 102, 31);
		panel.add(btnHienTatCa);
		
		cboTimKiem = new JComboBox();
		cboTimKiem.setModel(new DefaultComboBoxModel(new String[] {"Tìm theo mã", "Tìm theo tên"}));
		cboTimKiem.setBounds(10, 14, 99, 31);
		panel.add(cboTimKiem);
		
		JLabel lblSapXep = new JLabel("Sắp xếp:");
		lblSapXep.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSapXep.setBounds(696, 13, 72, 29);
		panel.add(lblSapXep);
		
		JInternalFrame internalFrame = new JInternalFrame("Thông Tin Nhân Viên");
		internalFrame.getContentPane().setBackground(new Color(255, 255, 255));
		internalFrame.setBounds(959, 10, 556, 737);
		jpnNhanVien.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		JPanel jpnTTHinhNV = new JPanel();
		jpnTTHinhNV.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		jpnTTHinhNV.setBackground(new Color(255, 255, 255));
		jpnTTHinhNV.setBounds(151, 0, 270, 239);
		internalFrame.getContentPane().add(jpnTTHinhNV);
		jpnTTHinhNV.setLayout(null);
		
		lblAnhNV2 = new JLabel("");
		lblAnhNV2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnhNV2.setIcon(new ImageIcon("image\\imploy.png"));
		lblAnhNV2.setBounds(0, 0, 270, 239);
		jpnTTHinhNV.add(lblAnhNV2);
		
		JLabel lblNewLabel_1 = new JLabel("MSNV:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 340, 61, 40);
		internalFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ và Tên:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 389, 82, 40);
		internalFrame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Giới Tính:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 439, 82, 40);
		internalFrame.getContentPane().add(lblNewLabel_1_1_1);
		
		lblmaNV = new JLabel("");
		lblmaNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblmaNV.setBounds(64, 340, 216, 40);
		internalFrame.getContentPane().add(lblmaNV);
		
		lbltenNV = new JLabel("");
		lbltenNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbltenNV.setBounds(89, 389, 180, 40);
		internalFrame.getContentPane().add(lbltenNV);
		
		lblgioiTinh = new JLabel("");
		lblgioiTinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblgioiTinh.setBounds(78, 439, 180, 40);
		internalFrame.getContentPane().add(lblgioiTinh);
		
		JLabel lblNewLabel_1_1_1_2_1_1 = new JLabel("Thông Tin Cá Nhân");
		lblNewLabel_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_2_1_1.setBounds(10, 489, 524, 35);
		internalFrame.getContentPane().add(lblNewLabel_1_1_1_2_1_1);
		
		lbltrangThai = new JLabel("");
		lbltrangThai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltrangThai.setBounds(373, 340, 137, 40);
		internalFrame.getContentPane().add(lbltrangThai);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(10, 534, 514, 1);
		internalFrame.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_1_1_1_2_1_1_1 = new JLabel("Thông Tin Nhân Viên");
		lblNewLabel_1_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_2_1_1_1.setBounds(10, 266, 216, 35);
		internalFrame.getContentPane().add(lblNewLabel_1_1_1_2_1_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		panel_2_1.setBounds(10, 311, 503, 1);
		internalFrame.getContentPane().add(panel_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Trạng Thái:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(290, 340, 120, 40);
		internalFrame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Chức Vụ:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(290, 389, 82, 40);
		internalFrame.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Ngày Vào Làm:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(290, 439, 120, 40);
		internalFrame.getContentPane().add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("CCCD:");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1.setBounds(10, 537, 120, 40);
		internalFrame.getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Ngày Sinh:");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1_1.setBounds(10, 581, 120, 40);
		internalFrame.getContentPane().add(lblNewLabel_1_2_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1_1 = new JLabel("Mật khẩu");
		lblNewLabel_1_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1_1_1.setBounds(10, 631, 73, 40);
		internalFrame.getContentPane().add(lblNewLabel_1_2_1_1_1_1_1);
		
		lblcccd = new JLabel("");
		lblcccd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblcccd.setBounds(53, 537, 194, 40);
		internalFrame.getContentPane().add(lblcccd);
		
		lblngaySinh = new JLabel("");
		lblngaySinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblngaySinh.setBounds(89, 581, 137, 40);
		internalFrame.getContentPane().add(lblngaySinh);
		
		lblmatKhau = new JLabel("");
		lblmatKhau.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblmatKhau.setBounds(78, 631, 137, 40);
		internalFrame.getContentPane().add(lblmatKhau);
		
		JLabel lblNewLabel_1_3 = new JLabel("Địa Chỉ:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(290, 534, 61, 40);
		internalFrame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Email:");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_1.setBounds(290, 581, 42, 40);
		internalFrame.getContentPane().add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("SĐT:");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_1_1.setBounds(290, 631, 61, 40);
		internalFrame.getContentPane().add(lblNewLabel_1_3_1_1);
		
		JButton btnNewButton = new JButton("Cập nhật");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  tabbedPane.getTabComponentAt(1);
			
			  
			  
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setBounds(430, 676, 104, 22);
		internalFrame.getContentPane().add(btnNewButton);
		
		lbldiaChi = new JLabel("");
		lbldiaChi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbldiaChi.setBounds(347, 534, 163, 37);
		internalFrame.getContentPane().add(lbldiaChi);
		
		lblsdt = new JLabel("");
		lblsdt.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblsdt.setBounds(327, 631, 195, 40);
		internalFrame.getContentPane().add(lblsdt);
		
		lblemail = new JLabel("");
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblemail.setBounds(336, 581, 208, 40);
		internalFrame.getContentPane().add(lblemail);
		
		lblngayVaoLam = new JLabel("");
		lblngayVaoLam.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblngayVaoLam.setBounds(397, 439, 137, 40);
		internalFrame.getContentPane().add(lblngayVaoLam);
		
		lblchucVu = new JLabel("");
		lblchucVu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblchucVu.setBounds(354, 389, 137, 40);
		internalFrame.getContentPane().add(lblchucVu);
		internalFrame.setVisible(true);
		tableNhanVien.addMouseListener(this);
		
	 jpnThemNhanVien = new JPanel();
		tabbedPane.addTab("Quản lý NV", null, jpnThemNhanVien, null);
		jpnThemNhanVien.setBackground(new Color(255, 255, 255));
		jpnThemNhanVien.setLayout(null);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 192)));
		panel_1.setBounds(10, 10, 1505, 749);
		jpnThemNhanVien.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setBounds(31, 76, 139, 35);
		panel_1.add(lblMaNV);
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblTenNV = new JLabel("Họ và Tên:");
		lblTenNV.setBounds(31, 149, 155, 28);
		panel_1.add(lblTenNV);
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNgayVaoLam = new JLabel("Ngày vào làm");
		lblNgayVaoLam.setBounds(576, 214, 139, 28);
		panel_1.add(lblNgayVaoLam);
		lblNgayVaoLam.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtMaNV = new JTextField();
		txtMaNV.setBackground(SystemColor.inactiveCaption);
		txtMaNV.setText("NV");
		txtMaNV.setBounds(193, 80, 309, 31);
		panel_1.add(txtMaNV);
		txtMaNV.setHorizontalAlignment(SwingConstants.LEFT);
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaNV.setColumns(10);
		
		txtTenNV = new JTextField();
		txtTenNV.setBackground(SystemColor.inactiveCaption);
		txtTenNV.setHorizontalAlignment(SwingConstants.LEFT);
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(193, 149, 309, 30);
		panel_1.add(txtTenNV);
		
		JLabel lblCCCD = new JLabel("CCCD");
		lblCCCD.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCCCD.setBounds(31, 427, 74, 35);
		panel_1.add(lblCCCD);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNgaySinh.setBounds(31, 493, 99, 31);
		panel_1.add(lblNgaySinh);
		
		txtNgaySinh = new JDateChooser();
		txtNgaySinh.setBackground(SystemColor.inactiveCaption);
		txtNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNgaySinh.setBounds(193, 493, 309, 30);
		panel_1.add(txtNgaySinh);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDiaChi.setBounds(576, 434, 139, 28);
		panel_1.add(lblDiaChi);
		
		JPanel jpnAnhSach = new JPanel();
		jpnAnhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		jpnAnhSach.setBounds(1110, 26, 373, 379);
		panel_1.add(jpnAnhSach);
		jpnAnhSach.setLayout(null);
		
		lblAnhNV = new JLabel("");
		lblAnhNV.setBounds(0, 0, 363, 347);
		jpnAnhSach.add(lblAnhNV);
		
		txtCCCD = new JTextField();
		txtCCCD.setBackground(SystemColor.inactiveCaption);
		txtCCCD.setHorizontalAlignment(SwingConstants.LEFT);
		txtCCCD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(193, 432, 309, 30);
		panel_1.add(txtCCCD);
		
		JLabel lblChucVu = new JLabel("Chức vụ");
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblChucVu.setBounds(576, 148, 93, 31);
		panel_1.add(lblChucVu);
		
		cboChucVu = new JComboBox();
		cboChucVu.setBackground(new Color(255, 255, 255));
		cboChucVu.setModel(new DefaultComboBoxModel());
		cboChucVu.setFont(new Font("Tahoma", Font.BOLD, 15));
		cboChucVu.setBounds(726, 147, 309, 30);
		panel_1.add(cboChucVu);
		ArrayList<LoaiNhanVien> listloaiNV=loaiNV_dao.getallLoaiNhanVien();
		for(LoaiNhanVien loaiNV: listloaiNV)
		{
			cboChucVu.addItem(loaiNV.getChucVu());
		}
		txtNgayVaoLam = new JDateChooser();
		
		txtNgayVaoLam.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtNgayVaoLam.setBounds(731, 212, 303, 30);
		panel_1.add(txtNgayVaoLam);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBackground(SystemColor.inactiveCaption);
		txtDiaChi.setHorizontalAlignment(SwingConstants.LEFT);
		txtDiaChi.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(725, 432, 309, 30);
		panel_1.add(txtDiaChi);
		
		chkNam = new JRadioButton("Nam");
		chkNam.setBackground(new Color(255, 255, 255));
		chkNam.setFont(new Font("Tahoma", Font.BOLD, 15));
		chkNam.setSelected(true);
		chkNam.setBounds(193, 215, 60, 30);
		panel_1.add(chkNam);
		
		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGioiTinh.setBounds(31, 214, 93, 28);
		panel_1.add(lblGioiTinh);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMatKhau.setBounds(576, 286, 93, 28);
		panel_1.add(lblMatKhau);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setBackground(SystemColor.inactiveCaption);
		txtMatKhau.setHorizontalAlignment(SwingConstants.LEFT);
		txtMatKhau.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(726, 288, 309, 30);
		panel_1.add(txtMatKhau);
		
		chkTrangThai = new JRadioButton("Đang làm");
		chkTrangThai.setBackground(new Color(255, 255, 255));
		chkTrangThai.setSelected(true);
		chkTrangThai.setFont(new Font("Tahoma", Font.BOLD, 15));
		chkTrangThai.setBounds(726, 80, 303, 30);
		panel_1.add(chkTrangThai);
		
		JLabel lblTrangThai = new JLabel("Trạng thái");
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTrangThai.setBounds(576, 79, 117, 28);
		panel_1.add(lblTrangThai);
		
		btnChonAnh = new JButton("Chọn ảnh");
		btnChonAnh.setBackground(SystemColor.activeCaption);
		btnChonAnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChonAnh.setBounds(1196, 415, 202, 30);
		panel_1.add(btnChonAnh);
		
		JLabel lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(193, 114, 306, 35);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("*");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(728, 317, 306, 35);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("*");
		lblNewLabel_2_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(196, 174, 306, 35);
		panel_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("*");
		lblNewLabel_2_1_2.setForeground(Color.RED);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1_2.setBounds(196, 461, 306, 35);
		panel_1.add(lblNewLabel_2_1_2);
		
		JLabel lblTiKhon = new JLabel("Tài Khoản");
		lblTiKhon.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTiKhon.setBounds(31, 286, 117, 28);
		panel_1.add(lblTiKhon);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setHorizontalAlignment(SwingConstants.LEFT);
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setBackground(SystemColor.inactiveCaption);
		txtTaiKhoan.setBounds(193, 284, 309, 30);
		panel_1.add(txtTaiKhoan);
		
		JLabel lblNewLabel_3 = new JLabel("Thông Tin Nhân Viên");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(134, 10, 811, 35);
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.text);
		panel_4.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		panel_4.setBounds(10, 44, 1036, 308);
		panel_1.add(panel_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("Thông Tin Cá Nhân");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(134, 370, 811, 35);
		panel_1.add(lblNewLabel_3_1);
		
		
		
		
		JButton home = new JButton("Trang chủ");
		home.setBorder(null);
		home.setFocusPainted(false);
		home.setContentAreaFilled(false);
		home.setPreferredSize(new Dimension(100,30));
		home.setIcon(new ImageIcon("image\\home-button.png"));
		home.setBackground(Color.BLUE);
		home.setFont(new Font("Tahoma", Font.BOLD, 10));
		home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				
			}
		});
		
		
		
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		panel_4_1.setBackground(Color.WHITE);
		panel_4_1.setBounds(10, 410, 1036, 308);
		panel_1.add(panel_4_1);
		panel_4_1.setLayout(null);
		
		JLabel lblSDT = new JLabel("SDT");
		lblSDT.setBounds(570, 81, 63, 28);
		panel_4_1.add(lblSDT);
		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtSDT = new JTextField();
		txtSDT.setBounds(718, 83, 308, 30);
		panel_4_1.add(txtSDT);
		txtSDT.setBackground(SystemColor.inactiveCaption);
		txtSDT.setHorizontalAlignment(SwingConstants.LEFT);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSDT.setColumns(10);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("*");
		lblNewLabel_2_1_2_1.setBounds(718, 111, 306, 35);
		panel_4_1.add(lblNewLabel_2_1_2_1);
		lblNewLabel_2_1_2_1.setForeground(Color.RED);
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(570, 140, 139, 28);
		panel_4_1.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtEmail = new JTextField();
		txtEmail.setBounds(718, 142, 309, 30);
		panel_4_1.add(txtEmail);
		txtEmail.setBackground(SystemColor.inactiveCaption);
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("*");
		lblNewLabel_2_1_1_1.setBounds(718, 182, 306, 35);
		panel_4_1.add(lblNewLabel_2_1_1_1);
		lblNewLabel_2_1_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("(*) Thông tin bắt buộc nhập");
		lblNewLabel_2_1_1_2.setForeground(Color.RED);
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2_1_1_2.setBounds(327, 241, 306, 35);
		panel_4_1.add(lblNewLabel_2_1_1_2);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(1169, 557, 283, 47);
		panel_1.add(btnThem);
		btnThem.setIcon(new ImageIcon("image\\add.png"));
		
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnSua = new JButton("Cập nhật");
		btnSua.setBounds(1169, 614, 283, 47);
		panel_1.add(btnSua);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSua.setIcon(new ImageIcon("image\\edit.png"));
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBounds(1169, 675, 283, 47);
		panel_1.add(btnLamMoi);
		btnLamMoi.setIcon(new ImageIcon("image\\refesh.png"));
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLamMoi.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_5, null);
		tabbedPane.setTabComponentAt(2, home);
		btnChonAnh.addActionListener(this);
		DocDuLieuNhanVienVaoTable();
		btnTimKiemNV.addActionListener(this);
		btnXoa.addActionListener(this);
		btnHienTatCa.addActionListener(this);
	}
	public void resetNhanVien()
	{
		int rowCount = modelNhanVien.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			modelNhanVien.removeRow(0);
		}
	}
	public void DocDuLieuNhanVienVaoTable() {
		resetNhanVien();
		List<NhanVien> list=nhanvien_dao.getallNhanVien();
		for(NhanVien nv: list)
		
			modelNhanVien.addRow(new Object[] {
					nv.getMaNV(), nv.getTenNV(), nv.getLoaiNV().getMaLoaiNV(), nv.getCCCD(), nv.getSDT(), nv.getNgaySinh(), nv.getNgayVaoLam(), nv.getDiaChi(), nv.getEmail(), nv.isGioiTinh() ?"Nam": "Nữ", nv.getMatKhau(), nv.isTrangThai()? "Đang làm việc": "Đã nghỉ việc"
					});
		}
	public void DocDuLieuNhanVienTangDanTheoTenVaoTable() {
		resetNhanVien();
		List<NhanVien> list=nhanvien_dao.getallNhanVienTangDanTheoTen();
		for(NhanVien nv: list)
		
			modelNhanVien.addRow(new Object[] {
					nv.getMaNV(), nv.getTenNV(), nv.getLoaiNV().getMaLoaiNV(), nv.getCCCD(), nv.getSDT(), nv.getNgaySinh(), nv.getNgayVaoLam(), nv.getDiaChi(), nv.getEmail(), nv.isGioiTinh() ?"Nam": "Nữ", nv.getMatKhau(), nv.isTrangThai()? "Đang làm việc": "Đã nghỉ việc"
					});
		}
	public void DocDuLieuNhanVienGiamDanTheoTenVaoTable() {
		resetNhanVien();
		List<NhanVien> list=nhanvien_dao.getallNhanVienGiamDanTheoTen();
		for(NhanVien nv: list)
		
			modelNhanVien.addRow(new Object[] {
					nv.getMaNV(), nv.getTenNV(), nv.getLoaiNV().getMaLoaiNV(), nv.getCCCD(), nv.getSDT(), nv.getNgaySinh(), nv.getNgayVaoLam(), nv.getDiaChi(), nv.getEmail(), nv.isGioiTinh() ?"Nam": "Nữ", nv.getMatKhau(), nv.isTrangThai()? "Đang làm việc": "Đã nghỉ việc"
					});
		}
	private void themNV()
	{
		String maNV=txtMaNV.getText();
		String tenNV=txtTenNV.getText();
		String chucVu=cboChucVu.getSelectedItem().toString();
		maLoaiNhanVien="";
		LoaiNhanVien_DAO dsloaiNV = new LoaiNhanVien_DAO();
		List<LoaiNhanVien> listLoaiNV = dsloaiNV.getallLoaiNhanVien();
		for (LoaiNhanVien loaiNV : listLoaiNV) {
			if (loaiNV.getChucVu().equals(chucVu)) {
				this.maLoaiNhanVien = loaiNV.getMaLoaiNV();
			}
		}
		String CCCD=txtCCCD.getText();
		String SDT=txtSDT.getText();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		Date ngaySinh = Date.valueOf(sd.format(txtNgaySinh.getDate()));
		SimpleDateFormat sdd = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayVaoLam = Date.valueOf(sd.format(txtNgayVaoLam.getDate()));
		String diaChi=txtDiaChi.getText();
		String email=txtEmail.getText();
		boolean gioiTinh=chkNam.isSelected();
		String matKhau=txtMatKhau.getText();
		boolean trangThai=chkTrangThai.isSelected();
		NhanVien nv=new NhanVien(maNV, tenNV, new LoaiNhanVien(maLoaiNhanVien), CCCD, SDT, ngaySinh, ngayVaoLam, diaChi, email, gioiTinh, matKhau, trangThai, urlAnh);
		try {
			
			if(nhanvien_dao.createNV(nv))
			{
			modelNhanVien.addRow(new Object[] {
					nv.getMaNV(), nv.getTenNV(), nv.getLoaiNV().getMaLoaiNV(), nv.getCCCD(), nv.getSDT(), nv.getNgaySinh(), nv.getNgayVaoLam(), nv.getDiaChi(), nv.getEmail(), nv.isGioiTinh() ?"Nam": "Nữ", nv.isTrangThai()? "Đang làm": "Nghỉ việc"
			
			});
			DocDuLieuNhanVienVaoTable();
			lamRong();
			JOptionPane.showMessageDialog(this, "Thêm thành công");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Mã nhân viên đã tồn tại!");
			}
		}catch (Exception e1) {
			System.out.println(e1.toString());
		}	
	}
	private void suaNV()
	{
		String maNV=txtMaNV.getText();
		String tenNV=txtTenNV.getText();
		String chucVu=cboChucVu.getSelectedItem().toString();
		maLoaiNhanVien="";
		LoaiNhanVien_DAO dsloaiNV = new LoaiNhanVien_DAO();
		List<LoaiNhanVien> listLoaiNV = dsloaiNV.getallLoaiNhanVien();
		for (LoaiNhanVien loaiNV : listLoaiNV) {
			if (loaiNV.getChucVu().equals(chucVu)) {
				this.maLoaiNhanVien = loaiNV.getMaLoaiNV();
			}
		}
		String CCCD=txtCCCD.getText();
		String SDT=txtSDT.getText();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		Date ngaySinh = Date.valueOf(sd.format(txtNgaySinh.getDate()));
		SimpleDateFormat sdd = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayVaoLam = Date.valueOf(sd.format(txtNgayVaoLam.getDate()));
		String diaChi=txtDiaChi.getText();
		String email=txtEmail.getText();
		boolean gioiTinh=chkNam.isSelected();
		String matKhau=txtMatKhau.getText();
		boolean trangThai=chkTrangThai.isSelected();
		NhanVien nv=new NhanVien(maNV, tenNV, new LoaiNhanVien(maLoaiNhanVien), CCCD, SDT, ngaySinh, ngayVaoLam, diaChi, email, gioiTinh, matKhau, trangThai, urlAnh);
		try
		{
			nhanvien_dao.updateNV(nv);
			modelNhanVien.setRowCount(0);
			DocDuLieuNhanVienVaoTable();
			lamRong();
			JOptionPane.showMessageDialog(this, "Cập nhật thành công");
			DocDuLieuNhanVienVaoTable();
		}catch(Exception e1)
		{
			JOptionPane.showMessageDialog(this, "Trùng mã");
		}
	}
	private void suaTrangThaiNhanVien() {
		String maNV=txtMaNV.getText();
		NhanVien nv=new NhanVien(maNV);
		try
		{
			nhanvien_dao.updateTrangThaiNV(nv);
			modelNhanVien.setRowCount(0);
			DocDuLieuNhanVienVaoTable();
			JOptionPane.showMessageDialog(this, "Đổi trạng thái thành công!!!");
			//xoaTrang();
			DocDuLieuNhanVienVaoTable();
		}catch(Exception e1)
		{
			JOptionPane.showMessageDialog(this, "Nhân viên không tồn tại!!");
		}
		
	}
	private void lamRong()
	{
		txtMaNV.setText("");
		txtTenNV.setText("");
		cboChucVu.setSelectedItem(null);
		txtCCCD.setText("");
		txtSDT.setText("");
		txtNgaySinh.setDate(null);
		txtNgayVaoLam.setDate(null);
		txtDiaChi.setText("");
		txtEmail.setText("");
		txtMatKhau.setText("");
		txtTaiKhoan.setText("");
	}
	public void timNhanVienTheoMa()
	{
			NhanVien_DAO nhanvien_dao=new NhanVien_DAO();
			List<NhanVien> list = nhanvien_dao.getNhanVienTheoMa(txtTimKiem.getText());
			if (txtTimKiem.getText().equals("")) 
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên cần tìm!");
			else if(list.size()==0) 
				   JOptionPane.showMessageDialog(this, "Không tìm thấy");
			else {
				resetNhanVien();
				for(NhanVien nv:list){
					modelNhanVien.addRow(new Object[] {
							nv.getMaNV(), nv.getTenNV(), nv.getLoaiNV().getMaLoaiNV(), nv.getCCCD(), nv.getSDT(), nv.getNgaySinh(), nv.getNgayVaoLam(), nv.getDiaChi(), nv.getEmail(), nv.isGioiTinh() ?"Nam": "Nữ", nv.getMatKhau(), nv.isTrangThai()? "Đang làm việc": "Đã nghỉ việc"
							});
					tableNhanVien.setModel(modelNhanVien);
			}
			
	}
	}
	public void timNhanVienTheoTen()
	{
			NhanVien_DAO nhanvien_dao=new NhanVien_DAO();
			List<NhanVien> list = nhanvien_dao.getNhanVienTheoTen(txtTimKiem.getText());
			if (txtTimKiem.getText().equals("")) 
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhân viên cần tìm!");
			else if(list.size()==0) 
				   JOptionPane.showMessageDialog(this, "Không tìm thấy");
			else {
				resetNhanVien();
				for(NhanVien nv:list){
					modelNhanVien.addRow(new Object[] {
							nv.getMaNV(), nv.getTenNV(), nv.getLoaiNV().getMaLoaiNV(), nv.getCCCD(), nv.getSDT(), nv.getNgaySinh(), nv.getNgayVaoLam(), nv.getDiaChi(), nv.getEmail(), nv.isGioiTinh() ?"Nam": "Nữ", nv.getMatKhau(), nv.isTrangThai()? "Đang làm việc": "Đã nghỉ việc"
							});
					tableNhanVien.setModel(modelNhanVien);
			}
		}
	}
	private void chonHinhAnh() {
		try {
			// chọn ảnh D:\\anh
			fileChooser= new JFileChooser("imgemployee");
			fileChooser.setBounds(1, 111, 281, 34);
			FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("*.png, *.jpg", "png", "jpg");
			fileChooser.setFileFilter(imgFilter);
			fileChooser.setMultiSelectionEnabled(false);
			fileChooser.showOpenDialog(null);
			File tenAnh = fileChooser.getSelectedFile();
			urlAnh = tenAnh.getAbsolutePath();
			lblAnhNV.setIcon(ResizeImage(String.valueOf(urlAnh)));
		} catch (Exception loi) {
			JOptionPane.showMessageDialog(null, "Bạn đã thoát chọn ảnh");
		}
	}
	
	// hàm resize hình ảnh cho khớp kích thước
	private ImageIcon ResizeImage(String img_path) {
		ImageIcon myIMG = new ImageIcon(img_path);
		Image img = myIMG.getImage();
		Image newIMG = img.getScaledInstance(lblAnhNV.getWidth(), lblAnhNV.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newIMG);
		return image;
	}
	private boolean validateNhanVien() {
		String maNV=txtMaNV.getText().trim();
		String tenNhanVien = txtTenNV.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		String soDienThoai = txtSDT.getText().trim();
		String email = txtEmail.getText().trim();
		String cccd=txtCCCD.getText().trim();
		String matKhau = txtMatKhau.getText();
		java.util.Date ngaySinh=txtNgaySinh.getDate();
		java.util.Date ngayVaoLam=txtNgayVaoLam.getDate();
		java.util.Date date = new java.util.Date();  
		
		if(maNV.length() == 0) {
			JOptionPane.showMessageDialog(null, "Mã nhân viên không được để trống");
			txtMaNV.requestFocus();
			txtMaNV.selectAll();
			return false;
		}else {
			if(!maNV.matches("^NV\\d{2}")) {
				JOptionPane.showMessageDialog(null, "Mã nhân viên theo mẫu NVXX");
				txtMaNV.requestFocus();
				txtMaNV.selectAll();
				return false;
			}
		}
		if(tenNhanVien.length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên nhân viên không được để trống");
			txtTenNV.requestFocus();
			txtTenNV.selectAll();
			return false;
		}else {
			if(!tenNhanVien.matches(MauRegex.REGEX_TEN)) {
				JOptionPane.showMessageDialog(null, "Tên nhân viên không chứa số và các kí tự đặt biệt");
				txtTenNV.requestFocus();
				txtTenNV.selectAll();
				return false;
			}
		}
		if(diaChi.length() == 0) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống");
			txtDiaChi.requestFocus();
			txtDiaChi.selectAll();
			return false;
		}else {
			if(!diaChi.matches(MauRegex.REGEX_DIACHI)) {
				JOptionPane.showMessageDialog(null, "Địa chỉ không chứa các kí tự đặt biệt ngoại trừ , .");
				txtDiaChi.requestFocus();
				txtDiaChi.selectAll();
				return false;
			}
		}
		
		if(soDienThoai.length() == 0) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		}else {
			if(!soDienThoai.matches(MauRegex.REGEX_SODIENTHOAI)) {
				JOptionPane.showMessageDialog(null, "Số điện thoại bắt đầu bằng 0 và theo sau là 9 chữ số");
				txtSDT.requestFocus();
				txtSDT.selectAll();
				return false;
			}
		}
		
		if(email.length() == 0) {
			JOptionPane.showMessageDialog(null, "Email không được để trống");
			txtEmail.requestFocus();
			txtEmail.selectAll();
			return false;
		}else {
			if(!email.matches(MauRegex.REGEX_EMAIL)) {
				JOptionPane.showMessageDialog(null, "Email sai định dạng");
				txtEmail.requestFocus();
				txtEmail.selectAll();
				return false;
			}
		}
		
		if(matKhau.length() == 0) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống");
			txtMatKhau.requestFocus();
			txtMatKhau.selectAll();
			return false;
		}else {
			if(!matKhau.matches(MauRegex.REGEX_MATKHAU)) {
				JOptionPane.showMessageDialog(null, "Mật khẩu tối đa 8 kí tự và không chứa các kí tự đặt biệt");
				txtMatKhau.requestFocus();
				txtMatKhau.selectAll();
				return false;
			}
		}
		if(cccd.length() == 0) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống");
			txtCCCD.requestFocus();
			txtCCCD.selectAll();
			return false;
		}else {
			if(!cccd.matches(MauRegex.REGEX_CMT)) {
				JOptionPane.showMessageDialog(null, "CCCD phải có 12 chữ số và không chứa các kí tự đặt biệt");
				txtCCCD.requestFocus();
				txtCCCD.selectAll();
				return false;
			}
		}
		if(ngaySinh==null) {
			JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống");
			txtNgaySinh.requestFocus();
			return false;
		}
		else if(ngaySinh.after(date))
		{
			JOptionPane.showMessageDialog(null, "Ngày sinh phải trước ngày hiện tại!");
			txtNgaySinh.requestFocus();
			return false;
		}
		if(ngayVaoLam==null) {
			JOptionPane.showMessageDialog(null, "Ngày vào làm không được để trống");
			txtNgayVaoLam.requestFocus();
			return false;
		}
		/*else if(ngayVaoLam.before(date))
		{
			JOptionPane.showMessageDialog(this, "Ngày vào làm phải sau ngày hiện tại!");
			return false;
		}*/
		return true;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnThem))
			if(validateNhanVien())
		{
			themNV();
		}
		if(o.equals(btnSua))
		{
			if(validateNhanVien())
			{
				suaNV();
			}
		}
		if(cboTimKiem.getSelectedItem().equals("Tìm theo mã") &&o.equals(btnTimKiemNV))
		{
			timNhanVienTheoMa();
		}
		else if(cboTimKiem.getSelectedItem().equals("Tìm theo tên") &&o.equals(btnTimKiemNV))
		{
			timNhanVienTheoTen();
		}
		if(o.equals(btnXoa))
		{
			resetNhanVien();
			suaTrangThaiNhanVien();
			DocDuLieuNhanVienVaoTable();
			lamRong();
		}
		if(o.equals(btnLamMoi))
		{
			lamRong();
		}
		if(o.equals(btnChonAnh))
		{
			chonHinhAnh();
		}
		if(o.equals(btnHienTatCa))
		{
			resetNhanVien();
			DocDuLieuNhanVienVaoTable();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableNhanVien.getSelectedRow();
		txtMaNV.setText(modelNhanVien.getValueAt(row, 0).toString());
		txtTenNV.setText(modelNhanVien.getValueAt(row, 1).toString());
		cboChucVu.setSelectedItem(modelNhanVien.getValueAt(row, 2).toString());
		txtCCCD.setText(modelNhanVien.getValueAt(row, 3).toString());
		txtSDT.setText(modelNhanVien.getValueAt(row, 4).toString());
		java.util.Date dateNgaySinh = null;
		try {
			dateNgaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(modelNhanVien.getValueAt(row, 5).toString());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtNgaySinh.setDate(dateNgaySinh);
		java.util.Date dateNgayVaoLam = null;
		try {
			dateNgayVaoLam = new SimpleDateFormat("yyyy-MM-dd").parse(modelNhanVien.getValueAt(row, 6).toString());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtNgayVaoLam.setDate(dateNgayVaoLam);
		txtDiaChi.setText(modelNhanVien.getValueAt(row, 7).toString());
		txtEmail.setText(modelNhanVien.getValueAt(row, 8).toString());
		chkNam.setSelected(modelNhanVien.getValueAt(row, 9).toString() == "Nam" ? true : false);
		txtMatKhau.setText(modelNhanVien.getValueAt(row, 10).toString());
		List<NhanVien> listNV = nhanvien_dao.getallNhanVien();
		for (NhanVien nv : listNV) {
			if (nv.getMaNV().equals(modelNhanVien.getValueAt(row, 0).toString())) {
				this.urlAnh = nv.getUrlAnhNV();
				lblAnhNV.setIcon(ResizeImage(String.valueOf(this.urlAnh)));
			}
		}
		txtTaiKhoan.setText(modelNhanVien.getValueAt(row, 0).toString());
		//label
		lblmaNV.setText(modelNhanVien.getValueAt(row, 0).toString());
		lbltenNV.setText(modelNhanVien.getValueAt(row, 1).toString());
		String chucVu= new String(modelNhanVien.getValueAt(row, 2).toString());
		lblchucVu.setText(chucVu);
		lblcccd.setText(modelNhanVien.getValueAt(row, 3).toString());
		lblsdt.setText(modelNhanVien.getValueAt(row, 4).toString());
		

		lblngaySinh.setText(modelNhanVien.getValueAt(row, 5).toString());
	
		lblngayVaoLam.setText(modelNhanVien.getValueAt(row, 6).toString());
		lbldiaChi.setText(modelNhanVien.getValueAt(row, 7).toString());
		lblemail.setText(modelNhanVien.getValueAt(row, 8).toString());
		String gioiTinh=new String(modelNhanVien.getValueAt(row, 9).toString());
		lblgioiTinh.setText(gioiTinh);
		lblmatKhau.setText(modelNhanVien.getValueAt(row, 10).toString());;
		List<NhanVien> listNV1 = nhanvien_dao.getallNhanVien();
		for (NhanVien nv : listNV1) {
			if (nv.getMaNV().equals(modelNhanVien.getValueAt(row, 0).toString())) {
				this.urlAnh = nv.getUrlAnhNV();
				lblAnhNV2.setIcon(ResizeImage(String.valueOf(this.urlAnh)));
			}
		}	
		String trangThai=new String(modelNhanVien.getValueAt(row, 11).toString());
		lbltrangThai.setText(trangThai);
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
