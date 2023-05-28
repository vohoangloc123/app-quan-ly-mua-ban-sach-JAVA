package gui;

import javax.swing.JPanel;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import controller.NextScreen;
import contructer.DanhMuc;
import dao.LoaiSach_DAO;
import dao.NhaXuatBan_DAO;
import dao.NhanVien_DAO;
import dao.Sach_DAO;
import entity.LoaiSach;
import entity.NhaXuatBan;
import entity.NhanVien;
import entity.Sach;
import regex.MauRegex;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.JInternalFrame;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.RowFilter;

import java.awt.Scrollbar;
import java.awt.Panel;

import javax.print.Doc;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.AncestorEvent;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;

public class GD_Sach extends JFrame implements ActionListener, MouseListener{
	private JTable table_Sach;
	private JTextField txtMaSach;
	private JTextField txtTenSach;
	private JTextField txtGia;
	private JDateChooser txtNamXB;
	private JTextField txtTacGia;
	private Sach_DAO sach_dao;
	private NhaXuatBan_DAO NXB_dao;
	private JComboBox<String> cboNXB;
	private JComboBox<String> cboLoai;
	private DefaultTableModel modelSach;
	private JScrollPane scroll;
	private LoaiSach_DAO loaisach_dao;
	private JButton btnThem;
	private JTextField txtNgonNgu;
	private JButton btnSua;
private JButton btnLamMoi;
	private String maNhaXuatBan;
	private String maLoaiSach;
	private String ma;
	private String ten;
	private JRadioButton chkTrangThai;
	private JButton btnThemAnh;
	private JLabel lbl_HinhAnh;
	private JFileChooser fileChooser;
	private String urlAnh;
	private JButton btnHienTatCa;
	private JTextField txtAn;
	private JTextField txtTimSach;
	private JButton btnTimSach;
	private JComboBox cboSapXep;
	private JButton btnXoa;
	private JComboBox cboTimO;
	private JComboBox cboTimKiem;
	private JLabel lblSapXep;
	private JLabel lblNewLabel_1;
	
	
	public static void SachScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 GD_Sach  Sach = new GD_Sach();
					Sach.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
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
					java.util.logging.Logger.getLogger(GD_Sach.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (InstantiationException ex) {
					java.util.logging.Logger.getLogger(GD_Sach.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (IllegalAccessException ex) {
					java.util.logging.Logger.getLogger(GD_Sach.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (javax.swing.UnsupportedLookAndFeelException ex) {
					java.util.logging.Logger.getLogger(GD_Sach.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				}
				try {
					GD_Sach frame = new GD_Sach();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GD_Sach(){
		try {
			ConnectDB.getInstance().connect();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sach_dao=new Sach_DAO();
		NXB_dao=new NhaXuatBan_DAO();
		loaisach_dao=new LoaiSach_DAO();
		setBackground(Color.GRAY);
		getContentPane().setLayout(null);
		setAutoRequestFocus(false);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		String [] ngonNgu= {" Tiếng Việt", "Tiếng Anh", "Tiếng Nhật"};
		
		
		
		
		

		String[] colHeader = { "Mã sách", "Tên sách", "Năm xuất bản",  "Đơn giá", "Ngôn ngữ", "Tên tác giả", "Tên nhà xuất bản",  "Loại sách", "Trạng thái"};
		modelSach = new DefaultTableModel(colHeader, 0);
		DocDuLieuSachConHangVaoTable();
		
		JTabbedPane tbnSach = new JTabbedPane(JTabbedPane.TOP);
		tbnSach.setBounds(10, 10, 1507, 764);
		getContentPane().add(tbnSach);
		tbnSach.setFont(new Font("Tahoma", Font.BOLD, 10));
		JPanel jpnDanhMucSach = new JPanel();
		tbnSach.addTab("Danh mục", null, jpnDanhMucSach, null);
		jpnDanhMucSach.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 192)));
		jpnDanhMucSach.setBackground(new Color(255, 255, 255));
        jpnDanhMucSach.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
			scrollPane.setBounds(10, 118, 1482, 538);
			jpnDanhMucSach.add(scrollPane);
			table_Sach = new JTable(modelSach);
			scrollPane.setViewportView(table_Sach);
			
			btnHienTatCa = new JButton("Hiện tất cả");
			btnHienTatCa.setForeground(new Color(255, 255, 255));
			btnHienTatCa.setBackground(new Color(0, 128, 255));
			btnHienTatCa.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnHienTatCa.setBounds(1235, 666, 138, 41);
			jpnDanhMucSach.add(btnHienTatCa);
			
			txtTimSach = new JTextField();
			txtTimSach.setHorizontalAlignment(SwingConstants.CENTER);
			txtTimSach.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtTimSach.setColumns(10);
			txtTimSach.setBounds(153, 71, 818, 28);
			jpnDanhMucSach.add(txtTimSach);
			
			 btnTimSach = new JButton("");
			 btnTimSach.setIcon(new ImageIcon("image\\search.png"));
			btnTimSach.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnTimSach.setBounds(986, 71, 60, 31);
			jpnDanhMucSach.add(btnTimSach);
			
			JLabel lblNewLabel = new JLabel("Danh Mục Sách");
			lblNewLabel.setForeground(new Color(0, 128, 192));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblNewLabel.setBounds(-253, 410, 1492, 69);
			jpnDanhMucSach.add(lblNewLabel);
			
			cboSapXep = new JComboBox();
			cboSapXep.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cboSapXep.getSelectedItem().equals("Tăng dần theo tên"))
					{
						DocDuLieuSachTangDanTheoTenVaoTable();
					}
					else if(cboSapXep.getSelectedItem().equals("Giảm dần theo tên"))
					{
						DocDuLieuSachGiamDanTheoTenVaoTable();
					}
				}
			});
			cboSapXep.setModel(new DefaultComboBoxModel(new String[] {"Tăng dần theo tên", "Giảm dần theo tên"}));
			cboSapXep.setBounds(1317, 72, 175, 28);
			jpnDanhMucSach.add(cboSapXep);
			
		    btnXoa = new JButton("Xóa");
			btnXoa.setBackground(new Color(255, 0, 0));
			btnXoa.setForeground(new Color(255, 255, 255));
			btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnXoa.setBounds(1383, 666, 109, 41);
			jpnDanhMucSach.add(btnXoa);
			
			JComboBox cboHienThiSach = new JComboBox();
			cboHienThiSach.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cboHienThiSach.getSelectedItem().equals("Hiển thị sách còn hàng"))
					{
						DocDuLieuSachConHangVaoTable();
					}
					else if(cboHienThiSach.getSelectedItem().equals("Hiển thị sách hết hàng"))
					{
						DocDuLieuSachHetHangVaoTable();
					}
					else if(cboHienThiSach.getSelectedItem().equals("Hiển thị tất cả sách"))
					{
						DocDuLieuSachVaoTable();
					}
				}
			});
			cboHienThiSach.setModel(new DefaultComboBoxModel(new String[] {"Hiển thị sách còn hàng", "Hiển thị sách hết hàng", "Hiển thị tất cả sách"}));
			cboHienThiSach.setBounds(1067, 71, 157, 28);
			jpnDanhMucSach.add(cboHienThiSach);
			
			
			cboTimKiem = new JComboBox();
			cboTimKiem.setModel(new DefaultComboBoxModel(new String[] {"Tìm theo mã", "Tìm theo tên"}));
			cboTimKiem.setBounds(10, 72, 119, 28);
			jpnDanhMucSach.add(cboTimKiem);
			
			lblSapXep = new JLabel("Sắp xếp:");
			lblSapXep.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSapXep.setBounds(1252, 71, 89, 28);
			jpnDanhMucSach.add(lblSapXep);
			
			lblNewLabel_1 = new JLabel("Danh Mục Sách");
			lblNewLabel_1.setForeground(new Color(0, 128, 192));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblNewLabel_1.setBounds(0, 10, 1502, 51);
			jpnDanhMucSach.add(lblNewLabel_1);
			
			JPanel jpnThemSach = new JPanel();
			jpnThemSach.setBackground(new Color(0, 128, 192));
			tbnSach.addTab("Quản lý sách", null, jpnThemSach, null);
			jpnThemSach.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
			jpnThemSach.setLayout(null);
			
			
			
			txtAn=new JTextField();
			
			btnThem = new JButton("Thêm");
			btnThem.setBounds(168, 496, 260, 41);
			jpnThemSach.add(btnThem);
			btnThem.setIcon(new ImageIcon("image\\add.png"));
			
			btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			btnSua = new JButton("Sửa");
			btnSua.setBounds(449, 496, 260, 41);
			jpnThemSach.add(btnSua);
			btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnSua.setIcon(new ImageIcon("image\\edit.png"));
			
			btnLamMoi = new JButton("Làm mới");
			btnLamMoi.setBounds(731, 496, 260, 41);
			jpnThemSach.add(btnLamMoi);
			btnLamMoi.setIcon(new ImageIcon("image\\refesh.png"));
			btnLamMoi.addActionListener(this);
			btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			JPanel jpn_HinhSach = new JPanel();
			jpn_HinhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			jpn_HinhSach.setBounds(1016, 95, 390, 360);
			jpnThemSach.add(jpn_HinhSach);
			jpn_HinhSach.setLayout(null);
			
			lbl_HinhAnh = new JLabel("");
			lbl_HinhAnh.setBounds(0, 0, 390, 360);
			jpn_HinhSach.add(lbl_HinhAnh);
			
			btnThemAnh = new JButton("Chọn ảnh");
			btnThemAnh.setBounds(1162, 467, 146, 41);
			jpnThemSach.add(btnThemAnh);
			btnThemAnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JPanel panel = new JPanel();
			panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(171, 95, 822, 356);
			jpnThemSach.add(panel);
			panel.setLayout(null);
			
			JLabel lblGia = new JLabel("Giá");
			lblGia.setBounds(39, 153, 139, 28);
			panel.add(lblGia);
			lblGia.setFont(new Font("Tahoma", Font.BOLD, 20));
			
			JLabel lblTenSach = new JLabel("Tên sách");
			lblTenSach.setBounds(39, 98, 139, 28);
			panel.add(lblTenSach);
			lblTenSach.setFont(new Font("Tahoma", Font.BOLD, 20));
			
			JLabel lblMaSach = new JLabel("Mã sách");
			lblMaSach.setBounds(39, 30, 139, 31);
			panel.add(lblMaSach);
			lblMaSach.setFont(new Font("Tahoma", Font.BOLD, 20));
			
			txtMaSach = new JTextField();
			txtMaSach.setBackground(SystemColor.inactiveCaption);
			txtMaSach.setBounds(166, 33, 194, 31);
			panel.add(txtMaSach);
			txtMaSach.setText("MS");
			txtMaSach.setHorizontalAlignment(SwingConstants.LEFT);
			txtMaSach.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtMaSach.setColumns(10);
			
			txtTenSach = new JTextField();
			txtTenSach.setBackground(SystemColor.inactiveCaption);
			txtTenSach.setBounds(166, 95, 194, 31);
			panel.add(txtTenSach);
			txtTenSach.setHorizontalAlignment(SwingConstants.LEFT);
			txtTenSach.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtTenSach.setColumns(10);
			
			txtGia = new JTextField();
			txtGia.setBackground(SystemColor.inactiveCaption);
			txtGia.setBounds(166, 155, 194, 31);
			panel.add(txtGia);
			
			
			
			txtGia.setHorizontalAlignment(SwingConstants.LEFT);
			txtGia.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtGia.setColumns(10);
			
			txtNgonNgu = new JTextField();
			txtNgonNgu.setBackground(SystemColor.inactiveCaption);
			txtNgonNgu.setBounds(579, 33, 194, 31);
			panel.add(txtNgonNgu);
			txtNgonNgu.setHorizontalAlignment(SwingConstants.CENTER);
			txtNgonNgu.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtNgonNgu.setColumns(10);
			
			txtTacGia = new JTextField();
			txtTacGia.setBounds(579, 95, 194, 31);
			panel.add(txtTacGia);
txtTacGia.setHorizontalAlignment(SwingConstants.CENTER);
			txtTacGia.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtTacGia.setColumns(10);
			
			cboLoai = new JComboBox<String>();
			cboLoai.setBounds(579, 151, 194, 37);
			panel.add(cboLoai);
			cboLoai.setModel(new DefaultComboBoxModel());
			cboLoai.setFont(new Font("Tahoma", Font.BOLD, 15));
			ArrayList<LoaiSach> listLoaiSach=loaisach_dao.getallLoaiSach();
			for(LoaiSach loaiSach: listLoaiSach)
			{
				cboLoai.addItem(loaiSach.getTenLoaiSach());
			}
			JLabel lblLoai = new JLabel("Loại");
			lblLoai.setBounds(442, 152, 77, 31);
			panel.add(lblLoai);
			lblLoai.setFont(new Font("Tahoma", Font.BOLD, 20));
			
			JLabel lblTacGia = new JLabel("Tác giả");
			lblTacGia.setBounds(442, 98, 139, 28);
			panel.add(lblTacGia);
			lblTacGia.setFont(new Font("Tahoma", Font.BOLD, 20));
			
			JLabel lblNgonNgu = new JLabel("Ngôn ngữ");
			lblNgonNgu.setBounds(442, 31, 139, 28);
			panel.add(lblNgonNgu);
			lblNgonNgu.setFont(new Font("Tahoma", Font.BOLD, 20));
			
			txtNamXB = new JDateChooser();
			txtNamXB.setBounds(579, 225, 194, 31);
			panel.add(txtNamXB);
			
			txtNamXB.setFont(new Font("Tahoma", Font.BOLD, 13));
			
			JLabel lblNamXB = new JLabel("Năm XB");
			lblNamXB.setBounds(442, 228, 139, 28);
			panel.add(lblNamXB);
			lblNamXB.setFont(new Font("Tahoma", Font.BOLD, 20));
			
			JLabel lblNXB = new JLabel("NXB");
			lblNXB.setBounds(39, 227, 139, 31);
			panel.add(lblNXB);
			lblNXB.setFont(new Font("Tahoma", Font.BOLD, 20));
			
			cboNXB = new JComboBox<String>();
			cboNXB.setBounds(166, 229, 194, 31);
			panel.add(cboNXB);
			cboNXB.setModel(new DefaultComboBoxModel());
			cboNXB.setFont(new Font("Tahoma", Font.BOLD, 15));
			ArrayList<NhaXuatBan> list=NXB_dao.getalltNhaXuatBan();
			for(NhaXuatBan nxb: list)
			{
				cboNXB.addItem(nxb.getTenNXB());	
			}
		
			JLabel lblTrangThai = new JLabel("Trạng thái");
			lblTrangThai.setBounds(39, 287, 103, 28);
			panel.add(lblTrangThai);
			lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 20));
			
			chkTrangThai = new JRadioButton("Còn sách");
			chkTrangThai.setBackground(new Color(255, 255, 255));
			chkTrangThai.setBounds(166, 293, 194, 31);
			panel.add(chkTrangThai);
			chkTrangThai.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			
			
			
			
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
			
			
			
			
			JPanel panel_1 = new JPanel();
			tbnSach.addTab("New tab", null, panel_1, null);
			tbnSach.setTabComponentAt(2, home);
			btnThemAnh.addActionListener(this);
			btnThem.addActionListener(this);
			btnSua.addActionListener(this);
			btnLamMoi.addActionListener(this);
			table_Sach.addMouseListener(this);
			btnHienTatCa.addActionListener(this);
			btnTimSach.addActionListener(this);
			btnXoa.addActionListener(this);
	
	}

	public void reset()
	{
		int rowCount = modelSach.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			modelSach.removeRow(0);
		}
	}
	public void DocDuLieuSachConHangVaoTable() {
		reset();
		List<Sach> list=sach_dao.getallSachConHang();
		for(Sach sach:list)
		{
			modelSach.addRow(new Object[] {sach.getMaSach(), sach.getTenSach(),sach.getNamXB(), sach.getDonGia(), sach.getNgonNgu(), sach.getTacgia(),sach.getNhaxuatban().getMaNXB(), sach.getLoaisach().getMaLoaiSach(), sach.isTrangThai()?"Còn hàng":"Hết hàng", sach.getUrlAnh()
					});
		}
	}
	public void DocDuLieuSachHetHangVaoTable() {
		reset();
		List<Sach> list=sach_dao.getallSachHetHang();
		for(Sach sach:list)
		{
			modelSach.addRow(new Object[] {sach.getMaSach(), sach.getTenSach(),sach.getNamXB(), sach.getDonGia(), sach.getNgonNgu(), sach.getTacgia(),sach.getNhaxuatban().getMaNXB(), sach.getLoaisach().getMaLoaiSach(), sach.isTrangThai()?"Còn hàng":"Hết hàng", sach.getUrlAnh()
					});
		}
	}
	public void DocDuLieuSachVaoTable() {
		reset();
		List<Sach> list=sach_dao.getallSach();
		for(Sach sach:list)
		{
			modelSach.addRow(new Object[] {sach.getMaSach(), sach.getTenSach(),sach.getNamXB(), sach.getDonGia(), sach.getNgonNgu(), sach.getTacgia(),sach.getNhaxuatban().getMaNXB(), sach.getLoaisach().getMaLoaiSach(), sach.isTrangThai()?"Còn hàng":"Hết hàng", sach.getUrlAnh()
					});
		}
	}
	public void DocDuLieuSachTangDanTheoTenVaoTable() {
		reset();
		List<Sach> list=sach_dao.getallSachTangDanTheoTen();
		for(Sach sach:list)
		{
			modelSach.addRow(new Object[] {sach.getMaSach(), sach.getTenSach(),sach.getNamXB(), sach.getDonGia(), sach.getNgonNgu(), sach.getTacgia(),sach.getNhaxuatban().getMaNXB(), sach.getLoaisach().getMaLoaiSach(), sach.isTrangThai()?"Còn hàng":"Hết hàng", sach.getUrlAnh()
					});
		}
	}
	public void DocDuLieuSachGiamDanTheoTenVaoTable() {
		reset();
		List<Sach> list=sach_dao.getallSachGiamDanTheoTen();
		for(Sach sach:list)
		{
			modelSach.addRow(new Object[] {sach.getMaSach(), sach.getTenSach(),sach.getNamXB(), sach.getDonGia(), sach.getNgonNgu(), sach.getTacgia(),sach.getNhaxuatban().getMaNXB(), sach.getLoaisach().getMaLoaiSach(), sach.isTrangThai()?"Còn hàng":"Hết hàng", sach.getUrlAnh()
					});
		}
	}
	
	private void them()
	{
		String ma=txtMaSach.getText();
		String hoten=txtTenSach.getText();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		Date namXB = Date.valueOf(sd.format(txtNamXB.getDate()));
		double donGia=Double.parseDouble(txtGia.getText());
		String ngonNgu=txtNgonNgu.getText();
		String tenTacGia=txtTacGia.getText();
		String tenNXB=cboNXB.getSelectedItem().toString();
		maNhaXuatBan="";
		NhaXuatBan_DAO dsNXB = new NhaXuatBan_DAO();
		List<NhaXuatBan> listNXB = dsNXB.getalltNhaXuatBan();
		for (NhaXuatBan nxb : listNXB) {
			if (nxb.getTenNXB().equals(tenNXB)) {
				this.maNhaXuatBan = nxb.getMaNXB();
			}
		}
		String loai=cboLoai.getSelectedItem().toString();
		maLoaiSach="";
		LoaiSach_DAO dsLoaiSach = new LoaiSach_DAO();
		List<LoaiSach> listLoaiSach = dsLoaiSach.getallLoaiSach();
		for (LoaiSach loaiSach : listLoaiSach) {
			if (loaiSach.getTenLoaiSach().equals(loai)) {
				this.maLoaiSach = loaiSach.getMaLoaiSach();
				
			}
		}
		boolean trangThai=chkTrangThai.isSelected();
		Sach sach= new Sach(ma, hoten, namXB, donGia, ngonNgu, tenTacGia ,new NhaXuatBan(maNhaXuatBan), new LoaiSach(maLoaiSach), trangThai, urlAnh);
		try {
			
			if(sach_dao.create(sach))
			{
			modelSach.addRow(new Object[] {
					sach.getMaSach(), sach.getTenSach(),sach.getNamXB(), sach.getDonGia(), sach.getNgonNgu(), sach.getTacgia(),sach.getNhaxuatban().getMaNXB(), sach.getLoaisach().getMaLoaiSach()
			});
			DocDuLieuSachConHangVaoTable();
			XoaRong();
			JOptionPane.showMessageDialog(this, "Thêm thành công");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Trùng mã sách mời bạn nhập lại!");
			}
		}catch (Exception e1) {
			System.out.println(e1.toString());
		}	
	}
	private void sua()
	{
		String ma=txtMaSach.getText();
String hoten=txtTenSach.getText();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		Date namXB = Date.valueOf(sd.format(txtNamXB.getDate()));
		double donGia=Double.parseDouble(txtGia.getText());
		String ngonNgu=txtNgonNgu.getText();
		String tenTacGia=txtTacGia.getText();
		String tenNXB=cboNXB.getSelectedItem().toString();
		maNhaXuatBan="";
		NhaXuatBan_DAO dsNXB = new NhaXuatBan_DAO();
		List<NhaXuatBan> listNXB = dsNXB.getalltNhaXuatBan();
		for (NhaXuatBan nxb : listNXB) {
			if (nxb.getTenNXB().equals(tenNXB)) {
				this.maNhaXuatBan = nxb.getMaNXB();
			}
		}
		String loai=cboLoai.getSelectedItem().toString();
		maLoaiSach="";
		LoaiSach_DAO dsLoaiSach = new LoaiSach_DAO();
		List<LoaiSach> listLoaiSach = dsLoaiSach.getallLoaiSach();
		for (LoaiSach loaiSach : listLoaiSach) {
			if (loaiSach.getTenLoaiSach().equals(loai)) {
				this.maLoaiSach = loaiSach.getMaLoaiSach();
				
			}
		}
		boolean trangThai=chkTrangThai.isSelected();
		Sach sach= new Sach(ma, hoten, namXB, donGia, ngonNgu, tenTacGia ,new NhaXuatBan(maNhaXuatBan), new LoaiSach(maLoaiSach), trangThai, urlAnh);
		try
		{
			sach_dao.update(sach);
			modelSach.setRowCount(0);
			DocDuLieuSachConHangVaoTable();
			XoaRong();
			JOptionPane.showMessageDialog(this, "Sửa thành công");
		}catch(Exception e1)
		{
			JOptionPane.showMessageDialog(this, "Trùng mã");
		}
	}
	
	private void XoaRong()
	{
			txtMaSach.setText("MS");
			txtTenSach.setText("");
			txtGia.setText("");
			cboNXB.setSelectedIndex(0);
			txtTacGia.setText("");
			txtNamXB.setDate(null);
			txtNgonNgu.setText("");
			cboLoai.setSelectedIndex(0);
			lbl_HinhAnh.setIcon(null);
			
	}
	private void timSachTheoMa() {
		Sach_DAO sach_dao=new Sach_DAO();
		List<Sach> list = sach_dao.getSachTheoMa(txtTimSach.getText());
		if (txtTimSach.getText().equals("")) 
			JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sách cần tìm!");
		else if(list.size()==0) 
			   JOptionPane.showMessageDialog(this, "Không tìm thấy!");
		else {
			for(Sach sach: list){
				reset();
				modelSach.addRow(new Object[] { sach.getMaSach(), sach.getTenSach(), sach.getNamXB(), sach.getDonGia(),
						sach.getNgonNgu(), sach.getTacgia(), sach.getNhaxuatban().getMaNXB(),
						sach.getLoaisach().getMaLoaiSach(), sach.isTrangThai() ? "Còn hàng"   : sach.getUrlAnh() });
						
				}
				table_Sach.setModel(modelSach);
		}
		
	}
	private void timSachTheoTen() {
		Sach_DAO sach_dao=new Sach_DAO();
		List<Sach> list = sach_dao.getSachTheoTen(txtTimSach.getText());
		if (txtTimSach.getText().equals("")) 
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sách cần tìm!");
		else if(list.size()==0) 
			   JOptionPane.showMessageDialog(this, "Không tìm thấy!");
		else {
			for(Sach sach: list){
				reset();
				modelSach.addRow(new Object[] { sach.getMaSach(), sach.getTenSach(), sach.getNamXB(), sach.getDonGia(),
						sach.getNgonNgu(), sach.getTacgia(), sach.getNhaxuatban().getMaNXB(),
						sach.getLoaisach().getMaLoaiSach(), sach.isTrangThai() ? "Còn hàng"   : sach.getUrlAnh() });
						
				}
				table_Sach.setModel(modelSach);
		}
		
	}
	private void suaTrangThaiSach() {
		String maSach=txtMaSach.getText();
		Sach sach=new Sach(maSach);
		try
		{
			sach_dao.updateTrangThaiSach(sach);
			modelSach.setRowCount(0);
			DocDuLieuSachConHangVaoTable();
			JOptionPane.showMessageDialog(this, "Xóa thành công");
		}catch(Exception e1)
		{
			JOptionPane.showMessageDialog(this, "Trùng mã");
		}
		
	}
	private void chonHinhAnh() {
		try {
			// chọn ảnh D:\\anh
			fileChooser= new JFileChooser("imgbook");
			fileChooser.setBounds(1, 111, 281, 34);
FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("*.png, *.jpg", "png", "jpg");
			fileChooser.setFileFilter(imgFilter);
			fileChooser.setMultiSelectionEnabled(false);
			fileChooser.showOpenDialog(null);
			File tenAnh = fileChooser.getSelectedFile();
			urlAnh = tenAnh.getAbsolutePath();
			lbl_HinhAnh.setIcon(ResizeImage(String.valueOf(urlAnh)));
		} catch (Exception loi) {
			JOptionPane.showMessageDialog(null, "Bạn đã thoát chọn ảnh");
		}
	}

	// hàm resize hình ảnh cho khớp kích thước
	private ImageIcon ResizeImage(String img_path) {
		ImageIcon myIMG = new ImageIcon(img_path);
		Image img = myIMG.getImage();
		Image newIMG = img.getScaledInstance(lbl_HinhAnh.getWidth(), lbl_HinhAnh.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newIMG);
		return image;
	}
	public boolean validateSach()
	{
		String ma=txtMaSach.getText();
		String tenSach=txtTenSach.getText();
		String donGia=txtGia.getText();
		String ngonNgu=txtNgonNgu.getText();
		String tenTacGia=txtTacGia.getText();
		java.util.Date namXB=txtNamXB.getDate();
		java.util.Date date = new java.util.Date();  
		if(ma.length() == 0) {
			JOptionPane.showMessageDialog(null, "Mã sách không được để trống");
			txtMaSach.requestFocus();
			txtMaSach.selectAll();
			return false;
		}else {
			if(!ma.matches("^MS\\d{6}")) {
				JOptionPane.showMessageDialog(null, "Mã sách theo mẫu MSXXXXXX");
				txtMaSach.requestFocus();
				txtMaSach.selectAll();
				return false;
			}
		}
		if(tenSach.length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên sách không được để trống");
			txtTenSach.requestFocus();
			txtTenSach.selectAll();
			return false;
		}else {
			if(!tenSach.matches(MauRegex.REGEX_TENSACH)) {
				JOptionPane.showMessageDialog(null, "Tên sách không chứa số và các kí tự đặt biệt");
				txtTenSach.requestFocus();
				txtTenSach.selectAll();
				return false;
			}
		}
		if(donGia.length()==0) {
			JOptionPane.showMessageDialog(this, "Chưa nhập đơn giá");
			txtGia.requestFocus();
			return false;
			
		}else {
			try {
				double x =Double.parseDouble(donGia);
				if(x<=0) {
					txtGia.requestFocus();
					JOptionPane.showMessageDialog(this, "Đơn giá phải lớn hơn 0!");
					return false;
				}
			} catch (NumberFormatException  ex) {
				txtGia.requestFocus();
				JOptionPane.showMessageDialog(this, "Phải nhập số nguyên dương");
				return false;
			}
		}
		if(ngonNgu.length() == 0) {
			JOptionPane.showMessageDialog(null, "Ngôn ngữ không được để trống");
			txtNgonNgu.requestFocus();
			txtNgonNgu.selectAll();
			return false;
		}else {
			if(!ngonNgu.matches(MauRegex.REGEX_TEN)) {
				JOptionPane.showMessageDialog(null, "Ngôn ngữ không chứa số và các kí tự đặt biệt");
				txtNgonNgu.requestFocus();
				txtNgonNgu.selectAll();
				return false;
			}
		}
		if(tenTacGia.length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên tác giả không được để trống");
			txtTacGia.requestFocus();
			txtTacGia.selectAll();
			return false;
		}else {
			if(!tenTacGia.matches(MauRegex.REGEX_TEN)) {
				JOptionPane.showMessageDialog(null, "Tên tác giả không chứa số và các kí tự đặt biệt");
				txtTacGia.requestFocus();
				txtTacGia.selectAll();
				return false;
			}
		}
		if(namXB==null) {
			JOptionPane.showMessageDialog(null, "Ngày xuất bản không được để trống");
			txtNamXB.requestFocus();
			return false;
		}
		else if(namXB.after(date))
		{
			JOptionPane.showMessageDialog(null, "Ngày xuất bản phải trước ngày hiện tại");
			txtNamXB.requestFocus();
			return false;
		}
		return true;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if(validateSach())
			{
				them();	
			}
		}
		if (o.equals(btnXoa)) {
			suaTrangThaiSach();
			XoaRong();
		}
		if (o.equals(btnSua)) {
			if(validateSach())
			{
				sua();
			}
		}
		if (cboTimKiem.getSelectedItem().equals("Tìm theo mã")&&o.equals(btnTimSach)) {
			timSachTheoMa();
		}
		else if (cboTimKiem.getSelectedItem().equals("Tìm theo tên")&&o.equals(btnTimSach)) {
			timSachTheoTen();
		}
		if(o.equals(btnLamMoi))
		{
			XoaRong();
		}
		if(o.equals(btnThemAnh))
		{
			chonHinhAnh();
		}
		if(o.equals(btnHienTatCa))
		{
			reset();
			DocDuLieuSachConHangVaoTable();
		}
		}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table_Sach.getSelectedRow();
		txtMaSach.setText(modelSach.getValueAt(row, 0).toString());
		txtTenSach.setText(modelSach.getValueAt(row, 1).toString());
		java.util.Date dateNamXB = null;
		try {
			dateNamXB = new SimpleDateFormat("yyyy-MM-dd").parse(modelSach.getValueAt(row, 2).toString());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtNamXB.setDate(dateNamXB);
		txtGia.setText(modelSach.getValueAt(row, 3).toString());
		txtNgonNgu.setText(modelSach.getValueAt(row, 4).toString());
		txtTacGia.setText(modelSach.getValueAt(row, 5).toString());
		cboNXB.setSelectedItem(modelSach.getValueAt(row, 6).toString());
		cboLoai.setSelectedItem(modelSach.getValueAt(row, 7).toString());
		sach_dao = new Sach_DAO();
		List<Sach> listSach = sach_dao.getallSach();
		for (Sach sach : listSach) {
			if (sach.getMaSach().equals(modelSach.getValueAt(row, 0).toString())) {
				this.urlAnh = sach.getUrlAnh();
				lbl_HinhAnh.setIcon(ResizeImage(String.valueOf(this.urlAnh)));
			}
		}
		chkTrangThai.setSelected(modelSach.getValueAt(row, 8).toString() == "Còn hàng" ? true : false);
	}
	@Override
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
