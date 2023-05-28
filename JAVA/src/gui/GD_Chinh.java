package gui;

import java.awt.Color;


import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.NextScreen;
import contructer.DanhMuc;
import dao.QuanLy_DAO;
import entity.QuanLy;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;




import connect.ConnectDB;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.SystemColor;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Window.Type;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;

public class GD_Chinh extends JFrame {
	


	protected static final Component Main = null;
	private JPanel contentPane;
	private JButton btnDoiMatKhau;
	public JLabel lblTenAD;
	public JLabel lblTenTk;
	private JTextField txtMatKhau;
	private JTextField txtNhapLaiMatKhau;
	private JButton btnHuy;
	private JButton btnXacNhan;
	

	
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
					java.util.logging.Logger.getLogger(GD_Chinh.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (InstantiationException ex) {
					java.util.logging.Logger.getLogger(GD_Chinh.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (IllegalAccessException ex) {
					java.util.logging.Logger.getLogger(GD_Chinh.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (javax.swing.UnsupportedLookAndFeelException ex) {
					java.util.logging.Logger.getLogger(GD_Chinh.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				}
				try {
					GD_Chinh frame = new GD_Chinh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GD_Chinh() {
		setTitle("QUẢN LÝ BÁN SÁCH");
		setIconImage(Toolkit.getDefaultToolkit().getImage("image\\login_book.png"));
		setAutoRequestFocus(false);
		setExtendedState(Frame.MAXIMIZED_BOTH);
	    
	
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getContentPane().setBackground(new Color(0, 128, 192));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel jpnView = new JPanel();
		jpnView.setBackground(new Color(255, 255, 255));
		jpnView.setBounds(183, 10, 1347, 781);
		getContentPane().add(jpnView);

		
		NextScreen controller = new NextScreen(jpnView);
		jpnView.setLayout(null);
		
		JLabel title = new JLabel("NH\u00C0 S\u00C1CH THE BOYS");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.RED);
		title.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 77));
		title.setBounds(0, 81, 1337, 123);
		jpnView.add(title);
		
		JPanel jpnMain = new JPanel();
		jpnMain.setBorder(new MatteBorder(6, 6, 6, 6, (Color) new Color(0, 0, 0)));
		jpnMain.setBackground(new Color(240, 240, 240));
		jpnMain.setBounds(202, 245, 940, 415);
		jpnView.add(jpnMain);
		jpnMain.setLayout(null);
		
		JLabel lblHD = new JLabel("LỊCH SỬ HÓA ĐƠN");
		lblHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblHD.setBounds(33, 124, 131, 55);
		jpnMain.add(lblHD);
		
		JLabel lblHoaDon = new JLabel("");
		lblHoaDon.setIcon(new ImageIcon("image\\invoice.png"));
		lblHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoaDon.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblHoaDon.setBounds(23, 33, 150, 129);
		jpnMain.add(lblHoaDon);
		
		JButton btnHoaDon = new JButton("");
		btnHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				GD_HoaDon lshd = new GD_HoaDon();
			    lshd.LSHD();
		
			}
		});
		btnHoaDon.setBounds(23, 24, 150, 171);
		jpnMain.add(btnHoaDon);
		
		
		
		
		
		JLabel lblNhanVien = new JLabel("");
		lblNhanVien.setIcon(new ImageIcon("image\\imploy.png"));
		lblNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNhanVien.setBounds(209, 33, 150, 129);
		jpnMain.add(lblNhanVien);
		
		JLabel lblNV = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNV.setBounds(219, 124, 131, 55);
		jpnMain.add(lblNV);
		
		JButton btnNhanVien = new JButton("");
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				GD_NhanVien NV = new GD_NhanVien();
				NV.NhanVienScreen();
			}
		});
		btnNhanVien.setBounds(209, 24, 150, 171);
		jpnMain.add(btnNhanVien);
		
		JLabel lblSach = new JLabel("");
		lblSach.setIcon(new ImageIcon("image\\book.png"));
		lblSach.setHorizontalAlignment(SwingConstants.CENTER);
		lblSach.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSach.setBounds(23, 223, 150, 129);
		jpnMain.add(lblSach);
		
		JLabel lblQunLSch = new JLabel("QUẢN LÝ SÁCH");
		lblQunLSch.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLSch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQunLSch.setBounds(33, 318, 131, 55);
		jpnMain.add(lblQunLSch);
		
		JButton btnSach = new JButton("");
		btnSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(true);
				GD_Sach GDS = new GD_Sach();
				GD_Sach.SachScreen();
				
			}
		});
		btnSach.setBounds(23, 223, 150, 171);
		jpnMain.add(btnSach);
		
		JLabel lblKhachHang = new JLabel("");
		lblKhachHang.setIcon(new ImageIcon("image\\customer.png"));
		lblKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblKhachHang.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblKhachHang.setBounds(209, 223, 150, 129);
		jpnMain.add(lblKhachHang);
		JLabel lblKhchHng = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lblKhchHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblKhchHng.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblKhchHng.setBounds(209, 318, 150, 55);
		jpnMain.add(lblKhchHng);
		
		JButton btnKhachHang = new JButton("");
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				GD_KhachHang KH = new GD_KhachHang();
				KH.KhachHangScreen();
				
			}
		});
		btnKhachHang.setBounds(209, 223, 150, 171);
		jpnMain.add(btnKhachHang);
		
		JLabel lblThongKE = new JLabel("");
		lblThongKE.setIcon(new ImageIcon("image\\chart.png"));
		lblThongKE.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongKE.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblThongKE.setBounds(387, 33, 150, 129);
		jpnMain.add(lblThongKE);
		
		JLabel lblThngK = new JLabel("THỐNG KÊ");
		lblThngK.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngK.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThngK.setBounds(397, 124, 131, 55);
		jpnMain.add(lblThngK);
		
		JButton btnThongKe = new JButton("");
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				GD_ThongKe TK = new GD_ThongKe();
				TK.ThongKeScreen();
				
				
				
			}
		});
		btnThongKe.setBounds(387, 24, 150, 171);
		jpnMain.add(btnThongKe);
		
		JLabel lblTroGiup = new JLabel("");
		lblTroGiup.setIcon(new ImageIcon("image\\help.png"));
		lblTroGiup.setHorizontalAlignment(SwingConstants.CENTER);
		lblTroGiup.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTroGiup.setBounds(387, 223, 150, 129);
		jpnMain.add(lblTroGiup);
		
		JLabel lblT = new JLabel("Trợ giúp");
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblT.setBounds(397, 318, 131, 55);
		jpnMain.add(lblT);
		
		JButton btnTroGiup = new JButton("");
		btnTroGiup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
					browser.browse(new URI("https://bookhelp7.wordpress.com/"));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnTroGiup.setBounds(387, 223, 150, 171);
		jpnMain.add(btnTroGiup);
		
		JLabel lblPhanHoi = new JLabel("");
		lblPhanHoi.setIcon(new ImageIcon("image\\feedback.png"));
		lblPhanHoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhanHoi.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPhanHoi.setBounds(571, 33, 150, 129);
		jpnMain.add(lblPhanHoi);
		
		JLabel lblPH = new JLabel("PHẢN HỒI");
		lblPH.setHorizontalAlignment(SwingConstants.CENTER);
		lblPH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPH.setBounds(581, 124, 131, 55);
		jpnMain.add(lblPH);
		
		JButton btnPhanHoi = new JButton("");
		btnPhanHoi.setBounds(571, 24, 150, 171);
		jpnMain.add(btnPhanHoi);
		
		JLabel lbVCT = new JLabel("");
		lbVCT.setIcon(new ImageIcon("image\\info.png"));
		lbVCT.setHorizontalAlignment(SwingConstants.CENTER);
		lbVCT.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbVCT.setBounds(762, 223, 150, 129);
		jpnMain.add(lbVCT);
		
		JLabel lblVeChungToi = new JLabel("THÔNG TIN");
		lblVeChungToi.setHorizontalAlignment(SwingConstants.CENTER);
		lblVeChungToi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVeChungToi.setBounds(772, 318, 131, 55);
		jpnMain.add(lblVeChungToi);
		
		JButton btnVeChungToi = new JButton("");
		btnVeChungToi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				GD_ThongTin TT = new GD_ThongTin();
				TT.ThongTinScreen();
			}
		});
		btnVeChungToi.setBounds(762, 223, 150, 171);
		jpnMain.add(btnVeChungToi);
		
		JLabel lblPhanHoi_1 = new JLabel("");
		lblPhanHoi_1.setIcon(new ImageIcon("image\\setting.png"));
		lblPhanHoi_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhanHoi_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPhanHoi_1.setBounds(571, 223, 150, 129);
		jpnMain.add(lblPhanHoi_1);
		
		JLabel lblCaiDat = new JLabel("");
		lblCaiDat.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaiDat.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCaiDat.setBounds(571, 223, 150, 129);
		jpnMain.add(lblCaiDat);
		
		JLabel lblCD = new JLabel("CÀI ĐẶT");
		lblCD.setHorizontalAlignment(SwingConstants.CENTER);
		lblCD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCD.setBounds(581, 318, 131, 55);
		jpnMain.add(lblCD);
		
		JButton btnCaiDat = new JButton("");
		btnCaiDat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				GD_CaiDat CD = new GD_CaiDat();
				CD.CDScreen();
				
			}
		});
		btnCaiDat.setBounds(571, 223, 150, 171);
		jpnMain.add(btnCaiDat);
		
		JLabel icontime = new JLabel("");
		icontime.setIcon(new ImageIcon("image\\time.png"));
		icontime.setBounds(1133, 0, 38, 36);
		
		jpnView.add(icontime);
		
		Date dd = new Date();
		SimpleDateFormat datef = new SimpleDateFormat("dd/MM/yyy");
		SimpleDateFormat timef = new SimpleDateFormat("hh:mm:ss a ");
		String date = datef.format(dd);
		String time = timef.format(dd);
		
		
		JLabel lblNgay = new JLabel("");
		lblNgay.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgay.setBounds(1011, 8, 95, 28);
		jpnView.add(lblNgay);
		lblNgay.setText(date);
		
		JLabel icondate = new JLabel("");
		icondate.setIcon(new ImageIcon("image\\calendar.png"));
		icondate.setBounds(963, 0, 38, 36);
		jpnView.add(icondate);
		
		JLabel lblgio = new JLabel("");
		lblgio.setText(time);
		lblgio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblgio.setBounds(1181, 8, 120, 28);
		jpnView.add(lblgio);
		
		
		
		List<DanhMuc> listItem= new ArrayList<>();
				
				
				JButton btnExit = new JButton("Đăng xuất");
				btnExit.setFont(new Font("Tahoma", Font.BOLD, 10));
				btnExit.setBounds(10, 298, 163, 39);
				getContentPane().add(btnExit);
				btnExit.setBackground(new Color(255, 0, 0));
				btnExit.setForeground(new Color(255, 255, 255));
				
				JLabel lblAnh = new JLabel("");
				lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
				lblAnh.setIcon(new ImageIcon("image\\admin.png"));
				lblAnh.setBounds(11, 49, 162, 169);
				getContentPane().add(lblAnh);
				
				lblTenAD = new JLabel("");
				lblTenAD.setHorizontalAlignment(SwingConstants.CENTER);
				lblTenAD.setForeground(Color.WHITE);
				lblTenAD.setFont(new Font("Leelawadee", Font.PLAIN, 19));
				lblTenAD.setBounds(0, 204, 184, 39);
				getContentPane().add(lblTenAD);
				
				JLabel lblNewLabel_2 = new JLabel("CỬA HÀNG SÁCH");
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_2.setForeground(new Color(255, 255, 255));
				lblNewLabel_2.setBounds(0, 457, 184, 39);
				getContentPane().add(lblNewLabel_2);
				
				JLabel lblNewLabel_2_1 = new JLabel("THE BOYS");
				lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2_1.setForeground(Color.WHITE);
				lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_2_1.setBounds(0, 491, 184, 39);
				getContentPane().add(lblNewLabel_2_1);
				
				JLabel lblNewLabel_2_1_1 = new JLabel("12 Nguyễn Văn Bảo");
				lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2_1_1.setForeground(Color.WHITE);
				lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_2_1_1.setBounds(0, 524, 184, 39);
				getContentPane().add(lblNewLabel_2_1_1);
				
				JLabel lblNewLabel_2_1_1_1 = new JLabel("Gò Vấp");
				lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
				lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_2_1_1_1.setBounds(0, 554, 184, 39);
				getContentPane().add(lblNewLabel_2_1_1_1);
				
				JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Version 1.0");
				lblNewLabel_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2_1_1_1_1.setForeground(new Color(255, 128, 128));
				lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_2_1_1_1_1.setBounds(0, 719, 184, 39);
				getContentPane().add(lblNewLabel_2_1_1_1_1);
				
				JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Design by Nhom 10");
				lblNewLabel_2_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2_1_1_1_1_1.setForeground(new Color(255, 128, 128));
				lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_2_1_1_1_1_1.setBounds(0, 752, 184, 39);
				getContentPane().add(lblNewLabel_2_1_1_1_1_1);
				
				btnDoiMatKhau = new JButton("Đổi mật khẩu");
				btnDoiMatKhau.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnExit.setVisible(false);
						txtMatKhau.setVisible(true);
						txtNhapLaiMatKhau.setVisible(true);
						btnXacNhan.setVisible(true);
						btnHuy.setVisible(true);
					}
				});
				btnDoiMatKhau.setForeground(Color.WHITE);
				btnDoiMatKhau.setFont(new Font("Tahoma", Font.BOLD, 10));
				btnDoiMatKhau.setBackground(Color.GREEN);
				btnDoiMatKhau.setBounds(10, 249, 163, 39);
				getContentPane().add(btnDoiMatKhau);
				
				lblTenTk = new JLabel("New label");
				lblTenTk.setBounds(69, 166, 45, 13);
				getContentPane().add(lblTenTk);
				
				txtMatKhau = new JTextField();
				txtMatKhau.setBounds(10, 298, 163, 39);
				txtMatKhau.setVisible(false);
				getContentPane().add(txtMatKhau);
				txtMatKhau.setColumns(10);
				
				txtNhapLaiMatKhau = new JTextField();
				txtNhapLaiMatKhau.setColumns(10);
				txtNhapLaiMatKhau.setBounds(10, 347, 163, 39);
				txtNhapLaiMatKhau.setVisible(false);
				getContentPane().add(txtNhapLaiMatKhau);
				
				btnXacNhan = new JButton("Xác nhận");
				btnXacNhan.setBackground(new Color(0, 255, 0));
				btnXacNhan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						QuanLy_DAO quanly_dao=new QuanLy_DAO();
						String passcheck = txtMatKhau.getText();
				        String newpassword = txtNhapLaiMatKhau.getText();
				        String tenTK=lblTenTk.getText();
				        
				        QuanLy ql=new QuanLy(tenTK, newpassword);
				        if(!passcheck.equals(newpassword))
				        {
				        	JOptionPane.showMessageDialog(null, "Mật khẩu không khớp");
				        	txtMatKhau.setText("");
							txtNhapLaiMatKhau.setText("");
				        }
				        else if(passcheck.equals(newpassword) && !passcheck.equals("") && !newpassword.equals("")) {
				        	int n=0;	
							try
							{
								quanly_dao.updateMatKhau(ql);
								JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
							}catch(Exception e1)
							{
								e1.printStackTrace();
							}
							txtMatKhau.setText("");
							txtNhapLaiMatKhau.setText("");
							txtMatKhau.setVisible(false);
							txtNhapLaiMatKhau.setVisible(false);
							btnHuy.setVisible(false);
							btnXacNhan.setVisible(false);
							btnExit.setVisible(true);
				        }
				        else if(passcheck.equals("") && newpassword.equals(""))
				        {
				        	JOptionPane.showMessageDialog(null, "Bạn chưa nhập mật khẩu");
				        }
					}
				});
				btnXacNhan.setForeground(new Color(255, 255, 255));
				btnXacNhan.setBounds(88, 397, 85, 21);
				btnXacNhan.setVisible(false);
				getContentPane().add(btnXacNhan);
				
				btnHuy = new JButton("Hủy");
				btnHuy.setBackground(new Color(255, 0, 0));
				btnHuy.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtMatKhau.setVisible(false);
						txtNhapLaiMatKhau.setVisible(false);
						btnHuy.setVisible(false);
						btnXacNhan.setVisible(false);
						btnExit.setVisible(true);
						txtMatKhau.setText("");
						txtNhapLaiMatKhau.setText("");
					}
				});
				btnHuy.setForeground(new Color(255, 255, 255));
				btnHuy.setBounds(10, 397, 68, 21);
				btnHuy.setVisible(false);
				getContentPane().add(btnHuy);
				btnExit.addActionListener(new ActionListener() {
				
					
					
					public void actionPerformed(ActionEvent e) {
						
					int Result = 	JOptionPane.showConfirmDialog(Main, "Bạn muốn đăng xuất ?", getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
					if (Result == JOptionPane.YES_OPTION) {
						setVisible(false);
						GD_DangNhap LG = new GD_DangNhap();
						LG.LoginScreen();
						
					}else if (Result ==JOptionPane.NO_OPTION) {
						
						
					}
					
					}
				});
		controller.setEvent(listItem);
	}
}

