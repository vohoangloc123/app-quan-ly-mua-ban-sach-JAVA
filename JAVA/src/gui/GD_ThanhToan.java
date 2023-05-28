package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.PreferenceChangeEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import controller.NextContainer;
import contructer.DanhMuc;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.LoaiSach_DAO;
import dao.NhaXuatBan_DAO;
import dao.NhanVien_DAO;
import dao.QuanLy_DAO;
import dao.Sach_DAO;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhaXuatBan;
import entity.NhanVien;
import entity.QuanLy;
import entity.Sach;
/////import sun.awt.geom.AreaOp.AddOp;
import java.awt.*;
import java.sql.Date;
import java.awt.event.KeyEvent;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;
import javax.swing.DropMode;
public class GD_ThanhToan extends JFrame implements ActionListener, MouseListener {

	protected static final Component ThanhToan = null;
	
	protected static final String lblmaNV = null;

	private static final JFrame GD_LichSuHoaDon = null;
	private javax.swing.JTextField txtTienThu;
	private javax.swing.JTextArea bill;
	private javax.swing.JButton btnThanhToan;
	private javax.swing.JLabel lblTamTinh;
	private javax.swing.JLabel lblTienTra;
	private javax.swing.JLabel lblTienThu;
	private javax.swing.JPanel jpnChinh;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable jTable1;
	private Component NhanVienNguyen;

	private JButton btnThem;
	private JButton btnXoa;

	DefaultTableModel tbModel;

	private JLabel lblDiscout;
	private JLabel lblTong;

	private JTable table_Sach;

	private Sach_DAO sach_dao;
	private NhaXuatBan_DAO NXB_dao;
	private DefaultTableModel modelSach;
	private JScrollPane scroll;
	private LoaiSach_DAO loaisach_dao;

	private String maNhaXuatBan;
	private String maLoaiSach;
	private String ma;
	private String ten;
	private JTextField txtmaSach;
	private Double gia;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblTnSch;
	private JTextField txtTimSach;
	private JButton btnTimSach;
	private JButton btnThemSoLuongSach;
	private HoaDon_DAO hoadon_dao;
	public NhanVien_DAO nhanvien_dao;
	private String maNhanVien;

	private DefaultTableModel modelHoaDon;
	private JTable table;
	private JComboBox cbUuDai;
	private JCheckBox chkKHTV;
	private DefaultTableModel tableHoaDon_1;
	public JLabel lblTenNV;
	public JTextField txtTenNV;
	Connection con;
	PreparedStatement pst;
	Statement st;

	ResultSet rs;
	int num;
	private JButton jbn1;
	private JLabel lblAnhSach;
	private JFileChooser fileChooser;
	private String urlAnh;
	private JLabel txtTime;
	private JLabel txtMaHD;
	private JLabel lblNgay;
	private String s;
	private DefaultTableModel tbModel1;
	private JTextField txtprice;
	private JTextField txtname;
	private JLabel q1;
	private JLabel q2;
	private JComboBox cboTimKiem;
	private JTextField txtTonHang;
	private JTextField lbl_TamTinh;
	private JTextField lblTongTien;
	private JTextField lbl_TienTra;
	private JPanel jpnDangXuat;
	private JPanel jpnChange;
	private JDateChooser lblNgayAn;
	private JTextField txtMatKhauMoi;
	private JTextField txtKiemTraMatKhau;
	private JButton btnHuy;
	private JButton btnXacNhan;
	private JButton btnDoiMatKhau;
	private JButton btnCong;
	private JSpinner spSoLuong;
	private JTextField textField;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblDonGia;
	private JLabel lblTenSach;
	private JLabel lblMaSach;
	private JLabel lblGiHng;
	private String maKhachHang;
	public JLabel lblMaKH;
	public JLabel lblTenKh;
	private JPanel panel_3;
	private JTable tableDSKH;
	private DefaultTableModel modelKhachHang;
	private JScrollPane scrollPane_2;
	private JPanel panel_4;
	private JButton btnChonKH;
	private JButton btnHuyKH;
	private JTextField txtTimKH;
	private JButton btnTimKH;
	public JLabel lblAnhNV;
	private JButton btnHienTatCa;
	private JLabel jlbKH;
	private JPanel jpnKhachHang;

	public static void NNSCreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ThanhToan window = new GD_ThanhToan();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GD_ThanhToan() {
		setAutoRequestFocus(false);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		try {
			ConnectDB.getInstance().connect();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		hoadon_dao = new HoaDon_DAO();
		nhanvien_dao = new NhanVien_DAO();

		setType(Type.POPUP);
		setTitle("LẬP HÓA ĐƠN");
		setIconImage(Toolkit.getDefaultToolkit().getImage("image\\sales_menu.png"));
		initComponents();
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		getContentPane().add(jpnChinh);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel pnlLog = new JPanel();
		pnlLog.setBorder(UIManager.getBorder("ScrollPane.border"));
		pnlLog.setBackground(new Color(0, 128, 192));
		pnlLog.setBounds(0, 0, 189, 802);
		jpnChinh.add(pnlLog);
		pnlLog.setLayout(null);

		java.util.Date dd = new java.util.Date();
		SimpleDateFormat datef = new SimpleDateFormat("dd/MM/yyy");
		SimpleDateFormat timef = new SimpleDateFormat("hh:mm aa");
		String date = datef.format(dd);
		String time = timef.format(dd);

		lblTenNV = new JLabel();
		lblTenNV.setIcon(new ImageIcon("image\\emp.png"));
		lblTenNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenNV.setBounds(0, 0, 184, 52);
		pnlLog.add(lblTenNV);

		lblTenNV.setForeground(new Color(255, 255, 255));
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 15));

		jpnDangXuat = new JPanel();
		jpnDangXuat.setBounds(0, 733, 200, 59);
		jpnDangXuat.setBackground(new Color(0, 128, 192));
		pnlLog.add(jpnDangXuat);
		jpnDangXuat.setLayout(null);

		JLabel jlbDangXuat = new JLabel("ĐĂNG XUÁT");
		jlbDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Result = 	JOptionPane.showConfirmDialog(ThanhToan, "Bạn muốn đăng xuất ?", getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if (Result == JOptionPane.YES_OPTION) {
					setVisible(false);
					GD_DangNhap LG = new GD_DangNhap();
					LG.LoginScreen();
					
				}else if (Result ==JOptionPane.NO_OPTION) {
					
					
				}
			}
		});
		jlbDangXuat.setIcon(new ImageIcon("image\\logout.png"));
		jlbDangXuat.setFont(new Font("Tahoma", Font.BOLD, 15));
		jlbDangXuat.setHorizontalAlignment(SwingConstants.CENTER);
		jlbDangXuat.setForeground(new Color(255, 255, 255));
		jlbDangXuat.setBackground(new Color(255, 255, 255));
		jlbDangXuat.setBounds(0, 0, 190, 59);
		jpnDangXuat.add(jlbDangXuat);

		JPanel jpnHoaDon = new JPanel();
		jpnHoaDon.setLayout(null);
		jpnHoaDon.setBackground(new Color(0, 128, 192));
		jpnHoaDon.setBounds(0, 543, 200, 59);
		pnlLog.add(jpnHoaDon);

		JLabel jlbHoaDon = new JLabel("HOÁ ĐƠN");
		jlbHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(true);
				GD_LichSuHoaDon lshd = new 	GD_LichSuHoaDon();
				lshd.LSScreen();
			      
				
			}
		});
		jlbHoaDon.setIcon(new ImageIcon("image\\invo.png"));
		jlbHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		jlbHoaDon.setForeground(Color.WHITE);
		jlbHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		jlbHoaDon.setBackground(Color.WHITE);
		jlbHoaDon.setBounds(0, 0, 189, 59);
		jpnHoaDon.add(jlbHoaDon);

		ArrayList<NhanVien> listNV = nhanvien_dao.getallNhanVien();
		for (NhanVien tenNV : listNV) {
			lblTenNV.setText(tenNV.getTenNV());
		}

		sach_dao = new Sach_DAO();
		NXB_dao = new NhaXuatBan_DAO();
		loaisach_dao = new LoaiSach_DAO();
		setBackground(new Color(192, 192, 192));

		String[] ngonNgu = { " Tiếng Việt", "Tiếng Anh", "Tiếng Nhật" };
		ArrayList<NhaXuatBan> list = NXB_dao.getalltNhaXuatBan();

		String[] colHeader = { "Mã sách", "Tên sách", "Năm XB", "Đơn giá", "Ngôn ngữ", "Tên tác giả", "Tên NXB",
				"Loại sách", "Trạng thái"};
		modelSach = new DefaultTableModel(colHeader, 0);

		
		 jpnKhachHang = new JPanel();
			jpnKhachHang.setBackground(new Color(0, 128, 192));
			jpnKhachHang.setBounds(0, 619, 200, 52);
			pnlLog.add(jpnKhachHang);
			jpnKhachHang.setLayout(null);
			
			jlbKH = new JLabel("KHÁCH HÀNG");
			jlbKH.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(true);
					GD_ThemKhachHang tkh = new 	GD_ThemKhachHang();
					tkh.ThemKHScreen();
				}
			});
			jlbKH.setIcon(new ImageIcon("image\\customerSmall.png"));
			jlbKH.setForeground(new Color(255, 255, 255));
			jlbKH.setHorizontalAlignment(SwingConstants.CENTER);
			jlbKH.setFont(new Font("Tahoma", Font.BOLD, 15));
			jlbKH.setBounds(0, 0, 190, 52);
			jpnKhachHang.add(jlbKH);
		
		
		NextContainer controller = new NextContainer(GD_LichSuHoaDon);
		List<DanhMuc> listItem = new ArrayList<>();
		listItem.add(new DanhMuc ("Hoa Don", jpnHoaDon, jlbHoaDon));
		listItem.add(new DanhMuc ("Khach Hang", jpnKhachHang, jlbKH));
		listItem.add(new DanhMuc ("Dang Xuat", jpnDangXuat, jlbDangXuat));
	
		
		JPanel jpnAnhNV = new JPanel();
		jpnAnhNV.setBounds(0, 52, 184, 239);
		pnlLog.add(jpnAnhNV);
		jpnAnhNV.setLayout(null);
		
		lblAnhNV = new JLabel("");
		lblAnhNV.setBounds(0, 0, 184, 239);
		jpnAnhNV.add(lblAnhNV);
		
				q1 = new JLabel("0");
				q1.setForeground(new Color(0, 128, 192));
				q1.setBackground(new Color(0, 128, 192));
				q1.setBounds(46, 598, 14, 18);
				pnlLog.add(q1);
				
						q2 = new JLabel("0");
						q2.setForeground(new Color(0, 128, 192));
						q2.setBounds(99, 598, 14, 18);
						pnlLog.add(q2);
						
						txtMatKhauMoi = new JTextField();
						txtMatKhauMoi.setBounds(10, 318, 174, 33);
						pnlLog.add(txtMatKhauMoi);
						txtMatKhauMoi.setColumns(10);
						txtMatKhauMoi.setVisible(false);
						
						txtKiemTraMatKhau = new JTextField();
						txtKiemTraMatKhau.setBounds(10, 361, 174, 33);
						pnlLog.add(txtKiemTraMatKhau);
						txtKiemTraMatKhau.setColumns(10);
						txtKiemTraMatKhau.setVisible(false);
						
						
						btnHuy = new JButton("Hủy");
						btnHuy.setForeground(new Color(255, 255, 255));
						btnHuy.setFont(new Font("Tahoma", Font.BOLD, 10));
						btnHuy.setBackground(new Color(255, 0, 0));
						btnHuy.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								btnDoiMatKhau.setVisible(true);
								txtMatKhauMoi.setVisible(false);
								txtKiemTraMatKhau.setVisible(false);
								btnHuy.setVisible(false);
								btnXacNhan.setVisible(false);
							}
						});
						btnHuy.setBounds(10, 412, 85, 21);
						pnlLog.add(btnHuy);
						btnHuy.setVisible(false);
						
						btnXacNhan = new JButton("Xác nhận");
						btnXacNhan.setForeground(new Color(255, 255, 255));
						btnXacNhan.setFont(new Font("Tahoma", Font.BOLD, 10));
						btnXacNhan.setBackground(new Color(0, 255, 0));
						btnXacNhan.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String passcheck = txtMatKhauMoi.getText();
						        String newpassword = txtKiemTraMatKhau.getText();
						       
					        
						        NhanVien nv=new NhanVien(newpassword);
						        if(!passcheck.equals(newpassword))
						        {
						        	JOptionPane.showMessageDialog(null, "Mật khẩu không khớp");
						        	txtMatKhauMoi.setText("");
									txtKiemTraMatKhau.setText("");
									
						        }
						        else if(passcheck.equals(newpassword) && !passcheck.equals("") && !newpassword.equals("")) {
						        	int n=0;	
									try
									{
										nhanvien_dao.updateMatKhau(nv);
										JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
									}catch(Exception e1)
									{
										e1.printStackTrace();
									}
									btnDoiMatKhau.setVisible(true);
									txtMatKhauMoi.setVisible(false);
									txtKiemTraMatKhau.setVisible(false);
									btnHuy.setVisible(false);
									btnXacNhan.setVisible(false);
						        }
						        else if(passcheck.equals("") && newpassword.equals(""))
						        {
						        	JOptionPane.showMessageDialog(null, "Bạn chưa nhập mật khẩu");
						        }
						        
				
							}
								
							
						});
						btnXacNhan.setBounds(99, 412, 85, 21);
						pnlLog.add(btnXacNhan);
						btnXacNhan.setVisible(false);
						
						btnDoiMatKhau = new JButton("Đổi mật khẩu");
						btnDoiMatKhau.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								btnDoiMatKhau.setVisible(false);
								txtMatKhauMoi.setVisible(true);
								txtKiemTraMatKhau.setVisible(true);
								btnHuy.setVisible(true);
								btnXacNhan.setVisible(true);
								txtMatKhauMoi.setText("");
								txtKiemTraMatKhau.setText("");
							}
						});
						btnDoiMatKhau.setBounds(10, 322, 174, 33);
						pnlLog.add(btnDoiMatKhau);
						
					
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(225, 688, -3, 13);
		jpnChinh.add(txtname);
		s = lblTenNV.getText();

		txtprice = new JTextField();
		txtprice.setBounds(225, 739, -3, 4);
		jpnChinh.add(txtprice);
		txtprice.setColumns(10);

		jpnChange = new JPanel();
		jpnChange.setBackground(new Color(240, 240, 240));
		jpnChange.setBounds(171, 0, 1424, 802);
		jpnChinh.add(jpnChange);
		jpnChange.setLayout(null);

		JPanel jpnThongTinSach = new JPanel();
		jpnThongTinSach.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 192)));
		jpnThongTinSach.setBounds(28, 272, 653, 266);
		jpnChange.add(jpnThongTinSach);
		jpnThongTinSach.setBackground(new Color(240, 240, 240));
		jpnThongTinSach.setLayout(null);

		JPanel panel_anh = new JPanel();
		panel_anh.setBackground(new Color(255, 255, 255));
		panel_anh.setBounds(10, 10, 208, 246);
		jpnThongTinSach.add(panel_anh);
		panel_anh.setLayout(null);

		lblAnhSach = new JLabel("");
		lblAnhSach.setBounds(0, 0, 208, 246);
		panel_anh.add(lblAnhSach);

		txtTonHang = new JTextField();
		txtTonHang.setBounds(249, 323, -59, -7);
		jpnThongTinSach.add(txtTonHang);
		txtTonHang.setColumns(10);
								 lblDonGia = new JLabel("");
								 lblDonGia.setHorizontalAlignment(SwingConstants.LEFT);
								 lblDonGia.setForeground(new Color(0, 0, 0));
								 lblDonGia.setFont(new Font("Tahoma", Font.PLAIN, 20));
								lblDonGia.setBounds(344, 163, 228, 41);
								jpnThongTinSach.add(lblDonGia);
								lblMaSach = new JLabel("");
								lblMaSach.setForeground(new Color(0, 0, 0));
								lblMaSach.setHorizontalAlignment(SwingConstants.LEFT);
								lblMaSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
								lblMaSach.setBounds(344, 59, 283, 41);
								jpnThongTinSach.add(lblMaSach);
								
								JLabel lblThngTinSch = new JLabel("Thông Tin Sách");
								lblThngTinSch.setHorizontalAlignment(SwingConstants.CENTER);
								lblThngTinSch.setForeground(SystemColor.desktop);
								lblThngTinSch.setFont(new Font("Tahoma", Font.BOLD, 20));
								lblThngTinSch.setBounds(217, 8, 426, 41);
								jpnThongTinSach.add(lblThngTinSch);
								
								btnCong = new JButton("+");
								btnCong.setBounds(459, 226, 49, 23);
								jpnThongTinSach.add(btnCong);
								btnCong.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										
										try {
											  spSoLuong.setValue(spSoLuong.getNextValue());
											 }
											 catch (IllegalArgumentException ex) {
											  // Ignore it, as in the UI
											 }
											
	
										
										
									}
								});
								btnCong.setFont(new Font("Tahoma", Font.PLAIN, 15));
								
								spSoLuong = new JSpinner();
								spSoLuong.setBounds(410, 229, 39, 21);
								jpnThongTinSach.add(spSoLuong);
								
								JButton btnTru = new JButton("-");
								btnTru.setBounds(351, 226, 49, 23);
								jpnThongTinSach.add(btnTru);
								btnTru.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										try {
											  spSoLuong.setValue(spSoLuong.getPreviousValue());
											 }
											 catch (IllegalArgumentException ex1) {
											  // Ignore it, as in the UI
											 }
											
	
										
										
									}
									
								});
								btnTru.setFont(new Font("Tahoma", Font.PLAIN, 15));
								
								JLabel lblSLng = new JLabel("Số lượng:");
								lblSLng.setForeground(new Color(0, 0, 0));
								lblSLng.setFont(new Font("Tahoma", Font.BOLD, 20));
								lblSLng.setBounds(228, 215, 128, 41);
								jpnThongTinSach.add(lblSLng);
								
								JLabel lblnGi = new JLabel("Đơn giá:");
								lblnGi.setForeground(new Color(0, 0, 0));
								lblnGi.setFont(new Font("Tahoma", Font.BOLD, 20));
								lblnGi.setBounds(228, 163, 94, 41);
								jpnThongTinSach.add(lblnGi);
								
								JLabel lblMSch = new JLabel("Mã sách:");
								lblMSch.setForeground(new Color(0, 0, 0));
								lblMSch.setFont(new Font("Tahoma", Font.BOLD, 20));
								lblMSch.setBounds(228, 59, 94, 41);
								jpnThongTinSach.add(lblMSch);
								
								JLabel lblTnSch_1 = new JLabel("Tên sách:");
								lblTnSch_1.setForeground(new Color(0, 0, 0));
								lblTnSch_1.setFont(new Font("Tahoma", Font.BOLD, 20));
								lblTnSch_1.setBounds(228, 110, 128, 41);
								jpnThongTinSach.add(lblTnSch_1);
								
								lblTenSach = new JLabel("");
								lblTenSach.setBounds(344, 110, 299, 41);
								jpnThongTinSach.add(lblTenSach);
								lblTenSach.setForeground(new Color(0, 0, 0));
								lblTenSach.setHorizontalAlignment(SwingConstants.LEFT);
								lblTenSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
								
								JPanel panel_2 = new JPanel();
								panel_2.setBounds(288, 47, 302, 2);
								jpnThongTinSach.add(panel_2);
								

		txtTimSach = new JTextField();
		txtTimSach.setBounds(145, 10, 663, 29);
		jpnChange.add(txtTimSach);
		txtTimSach.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimSach.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTimSach.setColumns(10);


		btnTimSach = new JButton("");
		btnTimSach.setBounds(818, 10, 56, 31);
		jpnChange.add(btnTimSach);
		btnTimSach.setIcon(new ImageIcon("image\\search.png"));
		btnTimSach.setFont(new Font("Tahoma", Font.BOLD, 15));

		
		btnThemSoLuongSach = new JButton("Thêm vào ");
		btnThemSoLuongSach.setBounds(560, 548, 121, 28);
		jpnChange.add(btnThemSoLuongSach);
		btnThemSoLuongSach.setIcon(new ImageIcon("image\\add-chart.png"));
		btnThemSoLuongSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int add = table_Sach.getSelectedRow();
				if (add >= 0) {
					int sl = Integer.valueOf(spSoLuong.getValue().toString());
					if (sl == 0) {
						JOptionPane.showMessageDialog(ThanhToan, "Bạn chưa nhập số lượng!!!");
					
					} else {
						int i = Integer.valueOf(q1.getText());
						++i;
						int stt = Integer.valueOf(q2.getText());
						++stt;

						q1.setText(String.valueOf(i));
						q2.setText(String.valueOf(stt));
						String tenSac = lblTenSach.getText();
						Double dongia1 = Double.valueOf(lblDonGia.getText());

						ThemVaoGioHang(i, tenSac, sl, dongia1);
					}

				} else{
					JOptionPane.showMessageDialog(ThanhToan, "Bạn chưa chọn sản phẩm!");
				}

				
				TinhToan();
			}

		});
		btnThemSoLuongSach.setFont(new Font("Tahoma", Font.BOLD, 10));
		jScrollPane2 = new javax.swing.JScrollPane();
		jScrollPane2.setBounds(691, 272, 293, 512);
		jpnChange.add(jScrollPane2);
		jScrollPane2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bill = new javax.swing.JTextArea();
		jScrollPane2.setViewportView(bill);
		bill.setEditable(false);
		bill.setRows(5);
		

		bill.setColumns(20);
				
				lblNgayAn = new JDateChooser();
				lblNgayAn.setBackground(new Color(240, 240, 240));
				lblNgayAn.setBounds(884, 396, -11, 2);
				jpnChange.add(lblNgayAn);
				java.util.Date date1 = new java.util.Date();
				lblNgayAn.setDate(date1);
				
				JTabbedPane tbnHoaDon = new JTabbedPane(JTabbedPane.TOP);
				tbnHoaDon.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 192)));
				tbnHoaDon.setBounds(994, 0, 355, 784);
				jpnChange.add(tbnHoaDon);
				
				JPanel jpnTaoHoaDon = new JPanel();
				jpnTaoHoaDon.setBackground(new Color(255, 255, 255));
				tbnHoaDon.addTab("Thêm hóa đơn", null, jpnTaoHoaDon, null);
				jpnTaoHoaDon.setLayout(null);
																												btnThanhToan = new javax.swing.JButton();
																												btnThanhToan.setBounds(10, 639, 320, 88);
																												jpnTaoHoaDon.add(btnThanhToan);
																												btnThanhToan.setIcon(new ImageIcon("image\\pay.png"));
																												
																														btnThanhToan.setBackground(SystemColor.scrollbar);
																														
																																btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 15)); // 
																																btnThanhToan.setText("THANH TOÁN");
																																
																																JLabel lblNote = new JLabel();
																																lblNote.setText("Note:");
																																lblNote.setFont(new Font("Tahoma", Font.PLAIN, 15));
																																lblNote.setBounds(10, 452, 51, 40);
																																jpnTaoHoaDon.add(lblNote);
																																
																																textField = new JTextField();
																																textField.setHorizontalAlignment(SwingConstants.LEFT);
																																textField.setBounds(10, 488, 320, 106);
																																jpnTaoHoaDon.add(textField);
																																textField.setColumns(10);
																																		
																																		panel_1 = new JPanel();
																																		panel_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
																																		panel_1.setBackground(SystemColor.inactiveCaption);
																																		panel_1.setBounds(10, 10, 320, 88);
																																		jpnTaoHoaDon.add(panel_1);
																																		panel_1.setLayout(null);
																																		
																																		lblNewLabel_2 = new JLabel("Mã khách hàng :");
																																		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
																																		lblNewLabel_2.setBounds(10, 10, 106, 28);
																																		panel_1.add(lblNewLabel_2);
																																		
																																		lblNewLabel_1 = new JLabel("Tên khách hàng:");
																																		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
																																		lblNewLabel_1.setBounds(10, 48, 119, 28);
																																		panel_1.add(lblNewLabel_1);
																																		
																																		JButton btnChon = new JButton("Chọn");
																																		btnChon.addActionListener(new ActionListener() {
																																			public void actionPerformed(ActionEvent e) {
																																				panel_4.setVisible(false);
																																				panel_3.setVisible(true);
																																				
																																			}
																																		});
																																		btnChon.setBounds(225, 15, 85, 26);
																																		panel_1.add(btnChon);
																																		
																																		lblTenKh = new JLabel("");
																																		lblTenKh.setFont(new Font("Tahoma", Font.PLAIN, 13));
																																		lblTenKh.setBounds(121, 48, 189, 28);
																																		panel_1.add(lblTenKh);
																																		
																																		lblMaKH =  new JLabel("");
																																		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
																																		lblMaKH.setHorizontalAlignment(SwingConstants.LEFT);
																																		lblMaKH.setBounds(121, 13, 98, 29);
																																		panel_1.add(lblMaKH);
																																		
																																		JButton btnreset = new JButton("Hủy");
																																		btnreset.addActionListener(new ActionListener() {
																																			public void actionPerformed(ActionEvent e) {
																																				lblMaKH.setText("");
																																				lblTenKh.setText("");
																																				chkKHTV.setSelected(false);
																																				
																																				
																																			}
																																		});
																																		btnreset.setBounds(225, 53, 85, 25);
																																		panel_1.add(btnreset);
																																		
																																				btnThem = new JButton("Làm mới");
																																				btnThem.setBounds(230, 604, 100, 28);
																																				jpnTaoHoaDon.add(btnThem);
																																				btnThem.setFont(new Font("Tahoma", Font.BOLD, 10));
																																				btnThem.setIcon(new ImageIcon("image\\refesh.png"));
																																												
																																												JButton btnHuyHoaDon = new JButton("Hủy hóa đơn");
																																												btnHuyHoaDon.setFont(new Font("Tahoma", Font.BOLD, 10));
																																												btnHuyHoaDon.addActionListener(new ActionListener() {
																																													public void actionPerformed(ActionEvent e) {
																																														int Result = 	JOptionPane.showConfirmDialog(ThanhToan, "Bạn muốn hủy thao tác ?", getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
																																														
																																														if (Result == JOptionPane.YES_OPTION) {
																																															

																																															lbl_TamTinh.setText("0");
																																															txtTienThu.setText("0");
																																															lbl_TienTra.setText("0");
																																															lblTongTien.setText("0");
																																															cbUuDai.setSelectedIndex(0);
																																															
																																															addHD();
																																															
																																															JOptionPane.showMessageDialog(null, "Hủy thành công");
																																														}else if (Result ==JOptionPane.NO_OPTION) {
																																															
																																															
																																														}
																																													
																																													}
																																												});
																																												btnHuyHoaDon.setForeground(new Color(255, 255, 255));
																																												btnHuyHoaDon.setBackground(new Color(255, 0, 0));
																																												btnHuyHoaDon.setBounds(10, 604, 117, 28);
																																												jpnTaoHoaDon.add(btnHuyHoaDon);
																																												
																																														JButton btnIn = new JButton("IN ");
																																														btnIn.setBounds(137, 604, 88, 28);
																																														jpnTaoHoaDon.add(btnIn);
																																														btnIn.setIcon(new ImageIcon("image\\print.png"));
																																														btnIn.addActionListener(new ActionListener() {
																																															public void actionPerformed(ActionEvent e) {

																																																if (jTable1.getRowCount() == 0) {
																																																	JOptionPane.showMessageDialog(NhanVienNguyen, "Chưa có hóa đơn!!");

																																																} else {

																																																	try {
																																																		bill.print();
																																																	} catch (PrinterException e1) {
																																																		// TODO Auto-generated catch block
																																																		e1.printStackTrace();
																																																	}
																																																}
																																															}
																																														});
																																														btnIn.setFont(new Font("Tahoma", Font.BOLD, 10));
																																																						String[] colKhachHang = { "Mã khách hàng", "Tên khách hàng" };
																																																						modelKhachHang = new DefaultTableModel(colKhachHang, 0);
																																																						
																																																						panel_4 = new JPanel();
																																																						panel_4.setBackground(new Color(255, 255, 255));
																																																						panel_4.setBounds(10, 99, 320, 362);
																																																						jpnTaoHoaDon.add(panel_4);
																																																								panel_4.setLayout(null);
																																																						
																																																								JLabel lblNewLabel_2_1 = new JLabel("Mã HD:");
																																																								lblNewLabel_2_1.setBounds(2, 62, 47, 16);
																																																								panel_4.add(lblNewLabel_2_1);
																																																								lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
																																																								lblTamTinh = new javax.swing.JLabel();
																																																								lblTamTinh.setBounds(2, 90, 66, 47);
																																																								panel_4.add(lblTamTinh);
																																																								
																																																										lblTamTinh.setFont(new Font("Tahoma", Font.BOLD, 13)); 
																																																										lblTamTinh.setText("Tạm tính:");
																																																										
																																																												lbl_TamTinh = new JTextField();
																																																												lbl_TamTinh.setBounds(167, 94, 143, 28);
																																																												panel_4.add(lbl_TamTinh);
																																																												lbl_TamTinh.setEditable(false);
																																																												lbl_TamTinh.setColumns(10);
																																																												
																																																														lblDiscout = new JLabel();
																																																														lblDiscout.setBounds(2, 137, 63, 41);
																																																														panel_4.add(lblDiscout);
																																																														lblDiscout.setText("Giảm giá:");
																																																														lblDiscout.setFont(new Font("Tahoma", Font.ITALIC, 13));
																																																														
																																																																lblTong = new JLabel();
																																																																lblTong.setBounds(2, 191, 107, 37);
																																																																panel_4.add(lblTong);
																																																																lblTong.setText("Tổng tiền:");
																																																																lblTong.setFont(new Font("Tahoma", Font.BOLD, 13));
																																																																
																																																																		lblTongTien = new JTextField();
																																																																		lblTongTien.setBounds(167, 195, 143, 28);
																																																																		panel_4.add(lblTongTien);
																																																																		lblTongTien.setEditable(false);
																																																																		lblTongTien.setColumns(10);
																																																																		
																																																																				chkKHTV = new JCheckBox("");
																																																																				chkKHTV.setBackground(new Color(255, 255, 255));
																																																																				chkKHTV.setBounds(167, 144, 40, 39);
																																																																				panel_4.add(chkKHTV);
																																																																				lblTienThu = new javax.swing.JLabel();
																																																																				lblTienThu.setBounds(2, 247, 120, 39);
																																																																				panel_4.add(lblTienThu);
																																																																				
																																																																						lblTienThu.setFont(new Font("Tahoma", Font.BOLD, 13));
																																																																						lblTienThu.setText("Tiền khách đưa:");
																																																																						lblTienTra = new javax.swing.JLabel();
																																																																						lblTienTra.setBounds(2, 296, 147, 40);
																																																																						panel_4.add(lblTienTra);
																																																																						
																																																																								lblTienTra.setFont(new Font("Tahoma", Font.BOLD, 13));
																																																																								lblTienTra.setText("Tiền thừa trả khách:");
																																																																								txtTienThu = new javax.swing.JTextField();
																																																																								txtTienThu.setBounds(167, 252, 143, 28);
																																																																								panel_4.add(txtTienThu);
																																																																								txtTienThu.addKeyListener(new KeyAdapter() {
																																																																									@Override
																																																																									public void keyPressed(java.awt.event.KeyEvent evt) {
																																																																										char c = evt.getKeyChar();

																																																																										// kiểm tra kí tự nếu là chữ thì kh cho nhập số///
																																																																										if (Character.isLetter(c)) {

																																																																											txtTienThu.setEditable(false);
																																																																											JOptionPane.showMessageDialog(NhanVienNguyen, "Chỉ nhập số");
																																																																										} else {
																																																																											txtTienThu.setEditable(true);
																																																																										}

																																																																									}
																																																																								});
																																																																								
																																																																										txtTienThu.setForeground(new Color(255, 255, 255));
																																																																										txtTienThu.setBackground(new Color(64, 0, 64));
																																																																										
																																																																												txtTienThu.setFont(new Font("Tahoma", Font.PLAIN, 15)); // 
																																																																												txtTienThu.setText("0");
																																																																												
																																																																														lbl_TienTra = new JTextField();
																																																																														lbl_TienTra.setBounds(167, 304, 143, 28);
																																																																														panel_4.add(lbl_TienTra);
																																																																														lbl_TienTra.setEditable(false);
																																																																														lbl_TienTra.setColumns(10);
																																																																														
																																																																																lblNgay = new JLabel("");
																																																																																lblNgay.setBounds(2, 24, 95, 28);
																																																																																panel_4.add(lblNgay);
																																																																																lblNgay.setFont(new Font("Tahoma", Font.BOLD, 14));
																																																																																
																																																																																		lblNgay.setText(date);
																																																																																		
																																																																																				txtMaHD = new JLabel("");
																																																																																				txtMaHD.setBounds(167, 52, 62, 28);
																																																																																				panel_4.add(txtMaHD);
																																																																																				txtMaHD.setFont(new Font("Tahoma", Font.BOLD, 13));
																																																																																				
																																																																																						txtTime = new JLabel("");
																																																																																						txtTime.setBounds(167, 24, 100, 28);
																																																																																						panel_4.add(txtTime);
																																																																																						txtTime.setFont(new Font("Tahoma", Font.BOLD, 15));
																																																																																						
																																																																																								txtTime.setText(time);
																																																																																								
																																																																																								panel_3 = new JPanel();
																																																																																								panel_3.setBounds(10, 98, 320, 363);
																																																																																								jpnTaoHoaDon.add(panel_3);
																																																																																								panel_3.setLayout(null);
																																																																																								
																																																																																								scrollPane_2 = new JScrollPane();
																																																																																								scrollPane_2.setBounds(10, 10, 300, 251);
																																																																																								panel_3.add(scrollPane_2);
																																																																																								tableDSKH = new JTable(modelKhachHang);
																																																																																								tableDSKH.addMouseListener(new MouseAdapter() {
																																																																																									@Override
																																																																																									public void mouseClicked(MouseEvent e) {
																																																																																										int row1=tableDSKH.getSelectedRow();
																																																																																										lblMaKH.setText(modelKhachHang.getValueAt(row1, 0).toString());
																																																																																										lblTenKh.setText(modelKhachHang.getValueAt(row1, 1).toString());
																																																																																									}
																																																																																								});
																																																																																								scrollPane_2.setViewportView(tableDSKH);
																																																																																								
																																																																																								btnChonKH = new JButton("Chọn");
																																																																																								btnChonKH.setFont(new Font("Tahoma", Font.BOLD, 13));
																																																																																								btnChonKH.setForeground(new Color(255, 255, 255));
																																																																																								btnChonKH.setBackground(new Color(0, 255, 0));
																																																																																								btnChonKH.setBounds(10, 325, 72, 21);
																																																																																								panel_3.add(btnChonKH);
																																																																																								
																																																																																								btnHuyKH = new JButton("Hủy ");
																																																																																								btnHuyKH.setBackground(new Color(255, 0, 0));
																																																																																								btnHuyKH.setFont(new Font("Tahoma", Font.BOLD, 13));
																																																																																								btnHuyKH.setForeground(new Color(255, 255, 255));
																																																																																								btnHuyKH.addActionListener(new ActionListener() {
																																																																																									public void actionPerformed(ActionEvent e) {
																																																																																										panel_3.setVisible(false);
																																																																																										panel_4.setVisible(true);
																																																																																										lblMaKH.setText("");
																																																																																										lblTenKh.setText("");
																																																																																										txtTimKH.setText("");
																																																																																										resetKH();
																																																																																										DocDuLieuKhachHangVaoTable();
																																																																																									}
																																																																																								});
																																																																																								btnHuyKH.setBounds(92, 325, 88, 21);
																																																																																								panel_3.add(btnHuyKH);
																																																																																								
																																																																																								txtTimKH = new JTextField();
																																																																																								txtTimKH.setBounds(10, 270, 258, 26);
																																																																																								panel_3.add(txtTimKH);
																																																																																								txtTimKH.setColumns(10);
																																																																																								
																																																																																								btnTimKH = new JButton("");
																																																																																								btnTimKH.setIcon(new ImageIcon("image\\search.png"));
														
																																																																																								btnTimKH.setBounds(276, 270, 32, 28);
																																																																																								panel_3.add(btnTimKH);
																																																																																								
																																																																																								JButton btnHienTatCaKH = new JButton("Hiện tất cả");
																																																																																								btnHienTatCaKH.addActionListener(new ActionListener() {
																																																																																									public void actionPerformed(ActionEvent e) {
																																																																																										resetKH();
																																																																																										DocDuLieuKhachHangVaoTable();
																																																																																									}
																																																																																								});
																																																																																								btnHienTatCaKH.setForeground(Color.WHITE);
																																																																																								btnHienTatCaKH.setFont(new Font("Tahoma", Font.BOLD, 13));
																																																																																								btnHienTatCaKH.setBackground(Color.BLUE);
																																																																																								btnHienTatCaKH.setBounds(190, 325, 120, 21);
																																																																																								panel_3.add(btnHienTatCaKH);
																																																																																								btnChonKH.addActionListener(new ActionListener() {
																																																																																									public void actionPerformed(ActionEvent e) {
																																																																																										panel_4.setVisible(true);
																																																																																										panel_3.setVisible(false);
																																																																																										chkKHTV.setSelected(true);
																																																																																										txtTimKH.setText("");
																																																																																										resetKH();
																																																																																										DocDuLieuKhachHangVaoTable();
																																																																																									}
																																																																																								});
																																																																																								panel_3.setVisible(false);
																																																																				chkKHTV.addActionListener(new ActionListener() {
																																																																					public void actionPerformed(ActionEvent e) {
																																																																						if (chkKHTV.isSelected() == false) {
																																																																							Double sum = Double.valueOf(lbl_TamTinh.getText());
																																																																							DecimalFormat df = new DecimalFormat(".0");

																																																																							lblTongTien.setText(String.valueOf(df.format(sum)));
																																																																						} else if (chkKHTV.isSelected() == true) {
																																																																							Double tamtinh = Double.valueOf(lbl_TamTinh.getText());
																																																																							double b = 0.1;
																																																																							Double sumdiscout = tamtinh - (tamtinh * b);
																																																																							DecimalFormat df = new DecimalFormat(".0");
																																																																							lblTongTien.setText(String.valueOf(df.format(sumdiscout)));
																																																																						}
																																																																					}
																																																																				});
																																				
																																				JPanel jpnGioHang = new JPanel();
																																				jpnGioHang.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 192)));
																																				jpnGioHang.setBackground(SystemColor.text);
																																				jpnGioHang.setBounds(28, 586, 653, 206);
																																				jpnChange.add(jpnGioHang);
																																				jpnGioHang.setLayout(null);
																																				jScrollPane1 = new javax.swing.JScrollPane();
																																				jScrollPane1.setBounds(10, 10, 633, 186);
																																				jpnGioHang.add(jScrollPane1);
																																				jScrollPane1.setFont(new Font("Tahoma", Font.BOLD, 15));
																																				jScrollPane1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
																																				jTable1 = new javax.swing.JTable();
																																				jTable1.setBackground(new Color(255, 255, 255));
																																				
																																						jTable1.setFont(new Font("Dialog", Font.PLAIN, 19)); // NOI18N
																																						jTable1.setModel(new DefaultTableModel(new Object[][] {},
																																								new String[] { "STT", "S\u00E1ch", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1" }));
																																						jTable1.getColumnModel().getColumn(0).setPreferredWidth(115);
																																						jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);
																																						jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
																																						jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
																																						
																																								jScrollPane1.setViewportView(jTable1);
																																								
																																										btnXoa = new JButton("Xóa ");
																																										btnXoa.setBounds(461, 548, 89, 28);
																																										jpnChange.add(btnXoa);
																																										btnXoa.setFont(new Font("Tahoma", Font.BOLD, 10));
																																										btnXoa.setIcon(new ImageIcon("image\\delete.png"));
																																												
																																												JPanel jpnDanhMucSach = new JPanel();
																																												jpnDanhMucSach.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 192)));
																																												jpnDanhMucSach.setBounds(28, 49, 956, 213);
																																												jpnChange.add(jpnDanhMucSach);
																																												jpnDanhMucSach.setLayout(null);
																																												
																																														JScrollPane scrollPane = new JScrollPane();
																																														scrollPane.setBounds(10, 10, 936, 199);
																																														jpnDanhMucSach.add(scrollPane);
																																														table_Sach = new JTable(modelSach);
																																														table_Sach.setFont(new Font("Tahoma", Font.BOLD, 10));
																																														scrollPane.setViewportView(table_Sach);
																																														
																																														lblGiHng = new JLabel("Giỏ hàng");
																																														lblGiHng.setForeground(Color.RED);
																																														lblGiHng.setFont(new Font("Tahoma", Font.BOLD, 20));
																																														lblGiHng.setBounds(38, 534, 102, 48);
																																														jpnChange.add(lblGiHng);
																																														
																																														btnHienTatCa = new JButton("Hiện tất cả");
																																														btnHienTatCa.setForeground(new Color(255, 255, 255));
																																														btnHienTatCa.setBackground(new Color(0, 128, 192));
																																														btnHienTatCa.setFont(new Font("Tahoma", Font.BOLD, 10));
																																														btnHienTatCa.setBounds(888, 10, 96, 29);
																																														jpnChange.add(btnHienTatCa);
																																														
																																																cboTimKiem = new JComboBox();
																																																cboTimKiem.setBounds(28, 11, 107, 28);
																																																jpnChange.add(cboTimKiem);
																																																cboTimKiem.setFont(new Font("Tahoma", Font.BOLD, 10));
																																																cboTimKiem.setModel(new DefaultComboBoxModel(new String[] {"Tìm theo mã", "Tìm theo tên"}));
																																												
																																												
																																												table_Sach.addMouseListener(this);
																																								btnXoa.addActionListener(new ActionListener() {
																																									public void actionPerformed(ActionEvent e) {
																																										Clear();
																																									}
																																								});
																																				btnThem.addActionListener(new ActionListener() {

																																					public void actionPerformed(ActionEvent e) {

																																						lbl_TamTinh.setText("0");
																																						txtTienThu.setText("0");
																																						lbl_TienTra.setText("0");
																																						lblTongTien.setText("0");
																																						q1.setText("0");
																																			            

																																						tbModel1 = (DefaultTableModel) jTable1.getModel();

																																						int rowRemove = tbModel1.getRowCount();

																																						for (int i = rowRemove - 1; i >= 0; i--) {
																																							tbModel1.removeRow(i);
																																						}

																																					}

																																				});
																																btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
																																	public void actionPerformed(java.awt.event.ActionEvent evt) {

																																		if (jTable1.getRowCount() == 0) {
																																			JOptionPane.showMessageDialog(NhanVienNguyen, "Chưa có sản phẩm để thanh toán");

																																			lbl_TamTinh.setText("0");
																																			txtTienThu.setText("0");
																																			lbl_TienTra.setText("0");
																																			lblTongTien.setText("0");
																																			cbUuDai.setSelectedIndex(0);
																																		} else {
																																			try {
																																				Double sum = Double.valueOf(lbl_TamTinh.getText());
																																				DecimalFormat df = new DecimalFormat(".0");
																																				sum = Double.valueOf(lbl_TamTinh.getText());
																																				Double chs = Double.valueOf(txtTienThu.getText());
																																				txtTienThu.setText(String.valueOf(df.format(chs)));

																																				if (chs < sum) {

																																					JOptionPane.showMessageDialog(NhanVienNguyen, "Số tiền thu không hợp lệ");
																																					txtTienThu.setText("0");
																																					lbl_TienTra.setText("0");
																																				} else {
																																					Double bal = chs - sum;
																																					lbl_TienTra.setText(String.valueOf(df.format(bal)));

																																				}

																																				if (chkKHTV.isSelected() == true) {
																																					DecimalFormat df1 = new DecimalFormat(".0");
																																					Double tamtinh = Double.valueOf(lbl_TamTinh.getText());
																																					double b = 0.1;
																																					Double sumdiscout = tamtinh - (tamtinh * b);

																																					txtTienThu.setText(String.valueOf(df1.format(chs)));
																																					if (chs < sumdiscout) {

																																						txtTienThu.setText("0");
																																						lbl_TienTra.setText("0");
																																					} else {
																																						Double bal = chs - sumdiscout;
																																						lbl_TienTra.setText(String.valueOf(df.format(bal)));
																																					}
																																				}

																																			} catch (Exception e) {

																																			}

																																		}
																																		if (lbl_TienTra.getText().equals("0")) {
																																			JOptionPane.showMessageDialog(NhanVienNguyen, "Nhập số tiền thanh toán!!");
																																		} else {

																																			try {
																																				taoHoaDon();
																																			} catch (ParseException e) {
																																				// TODO Auto-generated catch block
																																				e.printStackTrace();
																																			}
																																			InHoaDon();
																																			addHD();

																																			lbl_TamTinh.setText("0");
																																			txtTienThu.setText("0");
																																			lbl_TienTra.setText("0");
																																			lblTongTien.setText("0");
																																			q1.setText("0");
																																			q2.setText("0");
																																		}
																																	}

																																});
																																btnThanhToan.addActionListener(this);
		btnTimSach.addActionListener(this);
		btnTimKH.addActionListener(this);
		btnHienTatCa.addActionListener(this);
		DocDuLieuSachVaoTable();
		DocDuLieuKhachHangVaoTable();
		controller.setEvent(listItem);
		s = lblTenNV.getText();

		String[] colHeader1 = { "Mã hóa đơn", "Tên nhân viên", "Ngày lập hóa đơn", "Ưu đãi", "tên sách","tên khách hàng", "Tổng tiền" };
		modelHoaDon = new DefaultTableModel(colHeader1, 0);
		DocDuLieuHoaDonVaoTable();
		setBackground(new Color(255, 255, 255));
		Connec();

	}

	public void reset() {
		int rowCount = modelSach.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			modelSach.removeRow(0);
		}
	}
	public void resetKH() {
		int rowCount = modelKhachHang.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			modelKhachHang.removeRow(0);
		}
	}

	public void DocDuLieuSachVaoTable() {
		reset();
		List<Sach> list = sach_dao.getallSachConHang();
		for (Sach sach : list) {
			modelSach.addRow(new Object[] { sach.getMaSach(), sach.getTenSach(), sach.getNamXB(), sach.getDonGia(),
					sach.getNgonNgu(), sach.getTacgia(), sach.getNhaxuatban().getMaNXB(),
					sach.getLoaisach().getMaLoaiSach(), sach.isTrangThai() ? "Còn hàng"   : "Hết hàng", sach.getUrlAnh()});
		}
	}

	public void DocDuLieuHoaDonVaoTable() {
		List<HoaDon> list = hoadon_dao.getallHoaDon();
		for (HoaDon hd : list) {
			modelHoaDon.addRow(new Object[] { hd.getMaHD(), hd.getNguoiLapHD().getMaNV(), hd.getNgayLapHD(),
					hd.isUuDai() ? "Có ưu đãi" : "Không có ưu đãi", hd.getTenSach().getMaSach(), hd.getTongTien() });
		}
	}
	public void DocDuLieuKhachHangVaoTable() {
		KhachHang_DAO khachhang_dao=new KhachHang_DAO();
		List<KhachHang> list=khachhang_dao.getallKhachHang();
		for(KhachHang kh:list)
		{
			modelKhachHang.addRow(new Object[] {
					kh.getMaKH(), kh.getTenKH(), kh.getSDT(), kh.getEmail(), kh.getLoaiKhachHang().getMaLoaiKH(),kh.isGioiTinh() ? "Nam":"Nữ" , kh.getDiaChi()
					});
		}
	}
	private void timKhachHang() {
		KhachHang_DAO khachhang_dao=new KhachHang_DAO();
		List<KhachHang> list = khachhang_dao.getKhachHangTheoMa(txtTimKH.getText());
		if (txtTimKH.getText().equals("")) 
			JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khách hàng cần tìm!");
		else if(list.size()==0) 
			   JOptionPane.showMessageDialog(this, "Không tìm thấy");
		else {
			for(KhachHang kh: list){
				resetKH();
				modelKhachHang.addRow(new Object[] { kh.getMaKH(), kh.getTenKH()});
				tableDSKH.setModel(modelKhachHang);
				}
				
		}
		
	}
	private void timSach() {
		Sach_DAO sach_dao=new Sach_DAO();
		List<Sach> list = sach_dao.getSachTheoMa(txtTimSach.getText());
		if (txtTimSach.getText().equals("")) 
			JOptionPane.showMessageDialog(this, "Vui lòng  nhập mã sách cần tìm!!");
		else if(list.size()==0) 
			   JOptionPane.showMessageDialog(this, "Không tìm thấy!!!");
		else {
			reset();
			for(Sach sach: list){
				modelSach.addRow(new Object[] { sach.getMaSach(), sach.getTenSach(), sach.getNamXB(), sach.getDonGia(),
						sach.getNgonNgu(), sach.getTacgia(), sach.getNhaxuatban().getMaNXB(),
						sach.getLoaisach().getMaLoaiSach(), sach.isTrangThai() ? "Còn hàng"   : sach.getUrlAnh() });
						
				}
				table_Sach.setModel(modelSach);
		}
		
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
	private void chonHinhAnh() {
		try {
			// chọn ảnh D:\\anh
			fileChooser = new JFileChooser("imgbook");
			fileChooser.setBounds(1, 111, 281, 34);
			FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("*.png, *.jpg", "png", "jpg");
			fileChooser.setFileFilter(imgFilter);
			fileChooser.setMultiSelectionEnabled(false);
			fileChooser.showOpenDialog(null);
			File tenAnh = fileChooser.getSelectedFile();
			urlAnh = tenAnh.getAbsolutePath();
			lblAnhSach.setIcon(ResizeImage(String.valueOf(urlAnh)));
		} catch (Exception loi) {
			loi.printStackTrace();
		}
	}

	private ImageIcon ResizeImage(String img_path) {
		ImageIcon myIMG = new ImageIcon(img_path);
		Image img = myIMG.getImage();
		Image newIMG = img.getScaledInstance(lblAnhSach.getWidth(), lblAnhSach.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newIMG);
		return image;
	}
	private void filterKH(String query)
	{
		TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(modelKhachHang);
		tableDSKH.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(query));			
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnTimSach)&& cboTimKiem.getSelectedItem().equals("Tìm theo mã")) {
			timSachTheoMa();
		}
		else if(o.equals(btnTimSach)&& cboTimKiem.getSelectedItem().equals("Tìm theo tên"))
		{
			timSachTheoTen();
		}
		if(o.equals(btnTimKH))
		{
			timKhachHang();
		}
		if(o.equals(btnHienTatCa))
		{
			reset();
			DocDuLieuSachVaoTable();
		}

		
	}

	private void Clear() {
		DefaultTableModel tbModel = (DefaultTableModel) jTable1.getModel();
		int RemoveItem = jTable1.getSelectedRow();
		if (RemoveItem >= 0) {
			tbModel.removeRow(RemoveItem);

			try {
				Double sum = Double.valueOf(lbl_TamTinh.getText());
				DecimalFormat df = new DecimalFormat(".0");

				lblTongTien.setText(String.valueOf(df.format(sum)));

			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			if (jTable1.getRowCount() == 0) {
				JOptionPane.showMessageDialog(NhanVienNguyen, "Bảng trống");
			} else {
				JOptionPane.showMessageDialog(NhanVienNguyen, "Chọn dòng sản phẩm để xóa");
			}
		}

		TinhToan();
		lbl_TienTra.setText("0 ");
		txtTienThu.setText("0");
		DecimalFormat df = new DecimalFormat(".0");
		Double sum = Double.valueOf(lbl_TamTinh.getText());
		lblTongTien.setText(String.valueOf(df.format(sum)));

	}

	// tạo hàm thêm vào giỏ hàng///
	public void ThemVaoGioHang(int id, String Name, int Qty, Double Price) {

		DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
		DecimalFormat df = new DecimalFormat(".0");
		double totPrice = Price * Double.valueOf(Qty);
		String TotalPrice = df.format(totPrice);

		Vector v = new Vector();

		v.add(id);
		v.add(Name);
		v.add(Qty);
		v.add(TotalPrice);
		dt.addRow(v);

	}
	// tạo hàm tính giỏ hàng///
	public void TinhToan() {

		int numofrow = jTable1.getRowCount();
		double total = 0;
		for (int i = 0; i < numofrow; i++) {
			double value = Double.valueOf(jTable1.getValueAt(i, 3).toString());
			total += value;
		}

		DecimalFormat df = new DecimalFormat(".0");
		String d1 = df.format(total);
		lbl_TamTinh.setText(d1);
		Double sum = Double.valueOf(lbl_TamTinh.getText());
		lblTongTien.setText(String.valueOf(df.format(sum)));

	}
	// tạo hàm in hóa đơn từ giỏ hàng///
	public void InHoaDon() {

		try {

			java.util.Date dd = new java.util.Date();
			SimpleDateFormat datef = new SimpleDateFormat("dd/MM/yyy");
			
			SimpleDateFormat timef = new SimpleDateFormat("hh:mm ");
			String date = datef.format(dd);
			
			String time = timef.format(dd);
			
			bill.setFont(new Font("Arial", Font.BOLD, 12));
			bill.setText(bill.getText() +"               CỬA HÀNG SÁCH THE BOYS \n");
			bill.setText(bill.getText() +"                 12 Nguyễn Văn Bảo P.4 \n"
					+ "                 Q.Gò Vấp, TP.Hồ Chí Minh \n");
			bill.setText(bill.getText() + "                                    \n");
		
		
			bill.setText(bill.getText() + "Thu ngân:  "  +   lblTenNV.getText() + "\n");
			bill.setText(bill.getText() + "Thời gian:  " +   date + "   "+ time + "\n");
			bill.setText(bill.getText() + "Số HĐ: HD000"+   txtMaHD.getText()+"\n");
			
			if(lblTenKh.getText()== null) {
		    String thanhvien = "Không";
			bill.setText(bill.getText() + "#KH:"+ thanhvien + "\n");
			}else {
			bill.setText(bill.getText() + "#KH: "+ lblTenKh.getText()+   "\n");
			}
			bill.setText(bill.getText() + "...................................................................................\n");
			bill.setText(bill.getText() + "Sách\t\tSL         Đơn Giá \n");
			bill.setText(bill.getText() + "                                    \n");

			DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
			for (int i = 0; i < jTable1.getRowCount(); i++) {
				String stt = df.getValueAt(i, 0).toString();
				String name = df.getValueAt(i, 1).toString();
				String qt = df.getValueAt(i, 2).toString();
				String prc = df.getValueAt(i, 3).toString();

		    bill.setText(bill.getText()+name.trim()+"\t "+qt+"           "+ prc+ "     " + "\n");
				
			}

			bill.setText(bill.getText()+ "...................................................................................\n");
			bill.setText(bill.getText() + "TẠM TÍNH\t\t              " + lbl_TamTinh.getText() + "     " + "\n");
			bill.setText(bill.getText() + "                                    \n");

			if (chkKHTV.isSelected() == false) {
				String uuDai = "Không";
				bill.setText(bill.getText() + "GIẢM GIÁ\t\t               " + uuDai + "\n");
				bill.setText(bill.getText() + "                                    \n");
			} else if (chkKHTV.isSelected() == true) {
				String uuDai = "Có";
				bill.setText(bill.getText() + "                                    \n");
				bill.setText(bill.getText() + "GIẢM GIÁ\t\t               " + uuDai + "\n");
			}
			
			bill.setText(bill.getText() + "THÀNH TIỀN\t\t              "+ lblTongTien.getText() + "    " + "\n");
			bill.setText(bill.getText() + "                                    \n");
			bill.setText(bill.getText() + "Tiền mặt\t\t              " + txtTienThu.getText() + "     " + "\n");
			bill.setText(bill.getText() + "                                    \n");
			bill.setText(bill.getText() + "TIỀN TRẢ LẠI\t\t              " + lbl_TienTra.getText() + "    " + "\n");

	

			bill.setText(bill.getText() + "...................................................................................\n");
			bill.setText(bill.getText() + "              Quý khách cần hóa đơn tài chính\n"
					+ "vui lòng cung cấp thông tin hóa đơn trong ngày\n");
			bill.setText(bill.getText() + "...................................................................................\n");
			bill.setText(bill.getText() + "                                    \n");
			bill.setText(bill.getText() + "                                    \n");              
			bill.setText(bill.getText() + "                                    \n");
			bill.setText(bill.getText() + "                                    \n");
			bill.setText(bill.getText() + "       CÁM ƠN QUÝ KHÁCH VÀ HẸN GẶP LẠI\n");
			bill.setText(bill.getText() + "                          Hotline: 098 8977761\n");

		} catch (Exception ex) {

			Logger.getLogger(GD_ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jpnChinh = new javax.swing.JPanel();
		jpnChinh.setBounds(0, 0, 1540, 812);

		cbUuDai = new JComboBox();
		ArrayList<HoaDon> listUuDai = hoadon_dao.getGiamGia();
		jpnChinh.setLayout(null);

		setLocationRelativeTo(null);
	}
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "");
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GD_ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GD_ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GD_ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		try {
			GD_ThanhToan nn = new GD_ThanhToan();
			nn.setVisible(true);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void taoHoaDon() throws ParseException {
		String maHD = txtMaHD.getText();
		String tenNV = lblTenNV.getText();
		maNhanVien = "";
		NhanVien_DAO nv = new NhanVien_DAO();
		List<NhanVien> listNV = nv.getallNhanVien();
		for (NhanVien NV : listNV) {
			if (NV.getTenNV().equals(tenNV)) {
				this.maNhanVien = NV.getMaNV();
			}
		}
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayLapHD = Date.valueOf(sd.format(lblNgayAn.getDate()));
	    //-------------------------------------
		boolean uuDai = chkKHTV.isSelected();
		String maSach = lblMaSach.getText();
		String maKH=lblMaKH.getText();
		double tongTien = Double.parseDouble(lblTongTien.getText());
		if(lblMaKH.getText().equals("")) {
			HoaDon hd=new HoaDon(maHD, new NhanVien(maNhanVien), ngayLapHD, uuDai, new Sach(maSach), null, tongTien);
			try {

				if (hoadon_dao.createHoaDonKhongCoKH(hd)) {
					modelHoaDon.addRow(new Object[] { hd.getMaHD(), hd.getNguoiLapHD().getMaNV(), hd.getNgayLapHD(),
							hd.isUuDai() ? "Có ưu đãi" : "Không có ưu đãi", hd.getTenSach().getMaSach(), null,
							hd.getTongTien() });
					// xoaTrang();
					System.out.println(lblMaKH.getText());
					System.out.println(maKH);
					JOptionPane.showMessageDialog(this, "Thanh toán thành công!");
				} else {
					JOptionPane.showMessageDialog(this, "Hóa đơn đã tồn!");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else
		{
			KhachHang kh=new KhachHang(maKH);
			System.out.println(kh.getMaKH());
			HoaDon hd=new HoaDon(maHD, new NhanVien(maNhanVien), ngayLapHD, uuDai, new Sach(maSach), kh, tongTien);
		
		try {

			if (hoadon_dao.createHoaDonCoKH(hd)) {
				modelHoaDon.addRow(new Object[] { hd.getMaHD(), hd.getNguoiLapHD().getMaNV(), hd.getNgayLapHD(),
						hd.isUuDai() ? "Có ưu đãi" : "Không có ưu đãi", hd.getTenSach().getMaSach(), hd.getKhachHang().getMaKH(),
						hd.getTongTien() });
				System.out.println(lblMaKH.getText());
				System.out.println(maKH);
				JOptionPane.showMessageDialog(this, "Thanh toán thành công!");
			} else {
				JOptionPane.showMessageDialog(this, "Hóa đơn đã tồn!");
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		}
	}

	public void Connec() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databasename=QuanLyCuaHangSach;user=sa;password=sapassword");

			String sql = "select max(id) from maHD";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				num = rs.getInt(1);
				num++;
				txtMaHD.setText(Integer.toString(num));

			}

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void addHD() {
		String id = txtMaHD.getText();
		String fname = txtname.getText();
		String price = txtprice.getText();

		try {
			pst = con.prepareStatement("insert into maHD(id,name,price)values(?,?,?)");
			pst.setString(1, id);
			pst.setString(2, fname);
			pst.setString(3, price);

			pst.executeUpdate();

			Connec();
			txtname.setText("");
			txtprice.setText("");
			txtname.requestFocus();

		} catch (SQLException ex) {

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int row = table_Sach.getSelectedRow();
		lblMaSach.setText(modelSach.getValueAt(row, 0).toString());
		lblTenSach.setText(modelSach.getValueAt(row, 1).toString());
	
		lblDonGia.setText(modelSach.getValueAt(row, 3).toString());

		txtTonHang.setText(modelSach.getValueAt(row, 8).toString());
		
		if (txtTonHang.getText().equals("Hết hàng")) {
			JOptionPane.showMessageDialog(ThanhToan, "Sách hết hàng!!!");
		}
		Double sum = Double.valueOf(lblDonGia.getText());
		DecimalFormat df = new DecimalFormat(".0 ");

		lblDonGia.setText(String.valueOf(df.format(sum)));
		sach_dao = new Sach_DAO();
		List<Sach> listSach = sach_dao.getallSach();
		for (Sach sach : listSach) {
			if (sach.getMaSach().equals(modelSach.getValueAt(row, 0).toString())) {
				this.urlAnh = sach.getUrlAnh();
				lblAnhSach.setIcon(ResizeImage(String.valueOf(this.urlAnh)));
			}
		}
		
		
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
