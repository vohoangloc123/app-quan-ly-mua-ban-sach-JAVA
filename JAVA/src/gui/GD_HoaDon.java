package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import connect.ConnectDB;
import dao.HoaDon_DAO;
import dao.LoaiNhanVien_DAO;
import dao.NhanVien_DAO;
import entity.HoaDon;
import entity.LoaiNhanVien;
import entity.NhanVien;
import entity.Sach;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JEditorPane;
import javax.swing.JSeparator;

public class GD_HoaDon extends JFrame implements ActionListener, MouseListener {
	private JTable table_dsHD;
	private JTextField txtTimKiem;
	private DefaultTableModel modelHoaDon;
	private HoaDon_DAO hoadon;
	private HoaDon_DAO hoadon_dao;
	private JTable table;
	private JButton btnTimKiem;
	private JTable table_ChiTietHoaDon;
	private TableModel modelChiTietHoaDon;
	private JTextField textField;
	private JTable tableChiTietHoaDon;
	private JTextField txtTimKiemHDDaHuy;
	private JTable tableHoaDon;
	private JTable tableHDDaHuy;
	private DefaultTableModel modelHoaDonDaHuy;
	private JButton btnHuyHoaDon;
	private JTextField txtMaHD;

	public static void LSHD() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_HoaDon lshd = new GD_HoaDon();
					lshd.setVisible(true);
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
					java.util.logging.Logger.getLogger(GD_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (InstantiationException ex) {
					java.util.logging.Logger.getLogger(GD_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (IllegalAccessException ex) {
					java.util.logging.Logger.getLogger(GD_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (javax.swing.UnsupportedLookAndFeelException ex) {
					java.util.logging.Logger.getLogger(GD_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				}
				try {
					GD_HoaDon frame = new GD_HoaDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GD_HoaDon() {
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nhatn\\Downloads\\checklist (1).png"));
		getContentPane().setBackground(new Color(0, 128, 192));
		try {
			ConnectDB.getInstance().connect();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		hoadon_dao = new HoaDon_DAO();
		setBackground(Color.GRAY);
		getContentPane().setLayout(null);
		setAutoRequestFocus(false);
		setExtendedState(Frame.MAXIMIZED_BOTH);

		String[] colHeader = { "Mã Hóa Đơn", "Tên Nhân Viên", "Ngày Lập", "Ưu Đãi", "Tên Sách", "Tên khách hàng",
				"Tổng Tiền" };
		modelHoaDon = new DefaultTableModel(colHeader, 0);

		tableChiTietHoaDon = new JTable();
		String[] colHeader1 = { "STT", "Tên Sách", "Đơn Giá", "", "Số Lượng", "Tồng Tiền" };
		modelChiTietHoaDon = new DefaultTableModel(colHeader1, 0);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1540, 789);
		getContentPane().add(tabbedPane);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 10));

		JPanel jpnHoaDon = new JPanel();
		tabbedPane.addTab("Lịch sử hóa đơn", null, jpnHoaDon, null);
		jpnHoaDon.setBackground(new Color(255, 255, 255));
		jpnHoaDon.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 192)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 1515, 742);
		jpnHoaDon.add(panel);
		panel.setLayout(null);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(33, 10, 508, 35);
		panel.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		btnTimKiem = new JButton("");
		btnTimKiem.setBounds(551, 10, 54, 37);
		panel.add(btnTimKiem);
		btnTimKiem.setIcon(new ImageIcon("image\\search.png"));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));

		btnHuyHoaDon = new JButton("Hủy");
		btnHuyHoaDon.setBackground(new Color(255, 0, 0));
		btnHuyHoaDon.setForeground(new Color(255, 255, 255));
		btnHuyHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHuyHoaDon.setBounds(1275, 696, 80, 36);
		panel.add(btnHuyHoaDon);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 55, 1475, 617);
		panel.add(scrollPane);

		tableHoaDon = new JTable(modelHoaDon);
		scrollPane.setViewportView(tableHoaDon);

		JComboBox cboChonNgay = new JComboBox();
		cboChonNgay.setModel(new DefaultComboBoxModel(new String[] { "1 ngày", "1 tuần", "Tất cả" }));
		cboChonNgay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cboChonNgay.getSelectedItem().equals("1 tuần")) {
					resetHoaDon();
					DocDuLieuHoaDonTuanGanNhatVaoTable();
				} else if (cboChonNgay.getSelectedItem().equals("Tất cả")) {
					resetHoaDon();
					DocDuLieuHoaDonVaoTable();
				} else {
					resetHoaDon();
					DocDuLieuHoaDonNgayHomNayVaoTable();
				}

			}
		});
		cboChonNgay.setBounds(1402, 13, 103, 35);
		panel.add(cboChonNgay);

		JLabel lblLoc = new JLabel("Lọc:");
		lblLoc.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLoc.setBounds(1362, 13, 63, 33);
		panel.add(lblLoc);

		txtMaHD = new JTextField();
		txtMaHD.setBounds(20, 42, 80, 19);
		panel.add(txtMaHD);
		txtMaHD.setColumns(10);

		JButton btnHienTatCa = new JButton("Hiện tất cả");
		btnHienTatCa.setBackground(new Color(0, 128, 192));
		btnHienTatCa.setForeground(new Color(255, 255, 255));
		btnHienTatCa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHienTatCa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetHoaDon();
				DocDuLieuHoaDonVaoTable();
			}
		});
		btnHienTatCa.setBounds(1375, 696, 130, 36);
		panel.add(btnHienTatCa);
		txtMaHD.setVisible(false);

		JInternalFrame internalFrame = new JInternalFrame("Thông Tin Khách Hàng");

		JPanel jpnHoaDonHuy = new JPanel();
		tabbedPane.addTab("Hóa đơn hủy", null, jpnHoaDonHuy, null);
		jpnHoaDonHuy.setLayout(null);

		JPanel jpnHoaDon_1 = new JPanel();
		jpnHoaDon_1.setLayout(null);
		jpnHoaDon_1.setBackground(Color.WHITE);
		jpnHoaDon_1.setBounds(0, 0, 1535, 762);
		jpnHoaDonHuy.add(jpnHoaDon_1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 192)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 10, 1515, 742);
		jpnHoaDon_1.add(panel_1);

		txtTimKiemHDDaHuy = new JTextField();
		txtTimKiemHDDaHuy.setColumns(10);
		txtTimKiemHDDaHuy.setBounds(33, 10, 508, 35);
		panel_1.add(txtTimKiemHDDaHuy);

		JButton btnTimKiemHDDaHuy = new JButton("");
		btnTimKiemHDDaHuy.setIcon(new ImageIcon("image\\search.png"));
		btnTimKiemHDDaHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o.equals(btnTimKiemHDDaHuy)) {
					timHDDaHuy();
				}
			}
		});
		btnTimKiemHDDaHuy.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTimKiemHDDaHuy.setBounds(551, 10, 54, 37);
		panel_1.add(btnTimKiemHDDaHuy);

		String[] colHeader2 = { "Mã Hóa Đơn", "Tên Nhân Viên", "Ngày Lập", "Ưu Đãi", "Tên Sách", "Tên khách hàng",
				"Tổng Tiền" };
		modelHoaDonDaHuy = new DefaultTableModel(colHeader2, 0);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(33, 55, 1472, 625);
		panel_1.add(scrollPane_2);
		tableHDDaHuy = new JTable(modelHoaDonDaHuy);
		scrollPane_2.setViewportView(tableHDDaHuy);

		JButton btnHienTatCaHDDaHuy = new JButton("Hiện tất cả");
		btnHienTatCaHDDaHuy.setBackground(new Color(0, 128, 192));
		btnHienTatCaHDDaHuy.setForeground(new Color(255, 255, 255));
		btnHienTatCaHDDaHuy.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHienTatCaHDDaHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetHoaDonDaHuy();
				DocDuLieuHoaDonDaHuyVaoTable();
			}
		});
		btnHienTatCaHDDaHuy.setBounds(1344, 690, 161, 37);
		panel_1.add(btnHienTatCaHDDaHuy);
		txtMaHD.setVisible(false);

		JButton home = new JButton("Trang chủ");
		home.setBorder(null);
		home.setFocusPainted(false);
		home.setContentAreaFilled(false);
		home.setPreferredSize(new Dimension(100, 30));
		home.setIcon(new ImageIcon("image\\home-button.png"));
		home.setBackground(Color.BLUE);
		home.setFont(new Font("Tahoma", Font.BOLD, 10));
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				

			}
		});

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		tabbedPane.setTabComponentAt(2, home);
		btnTimKiem.addActionListener(this);
		btnHuyHoaDon.addActionListener(this);
		tableHoaDon.addMouseListener(this);
		DocDuLieuHoaDonVaoTable();
		DocDuLieuHoaDonDaHuyVaoTable();
	}


	
	public void resetHoaDon() {
		int rowCount = modelHoaDon.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			modelHoaDon.removeRow(0);
		}
	}

	public void resetHoaDonDaHuy() {
		int rowCount = modelHoaDonDaHuy.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			modelHoaDonDaHuy.removeRow(0);
		}
	}

	public void DocDuLieuHoaDonVaoTable() {
		List<HoaDon> list = hoadon_dao.getallHoaDon();
		for (HoaDon hd : list) {
			modelHoaDon.addRow(new Object[] { hd.getMaHD(), hd.getNguoiLapHD().getMaNV(), hd.getNgayLapHD(),
					hd.isUuDai() ? "Có " : "Không", hd.getTenSach().getMaSach(), hd.getKhachHang().getMaKH(),
					hd.getTongTien() });
		}
	}

	private void DocDuLieuHoaDonTuanGanNhatVaoTable() {
		// TODO Auto-generated method stub
		List<HoaDon> list = hoadon_dao.getallHoaDonTrongTuanGanNhat();
		for (HoaDon hd : list) {
			modelHoaDon.addRow(new Object[] { hd.getMaHD(), hd.getNguoiLapHD().getMaNV(), hd.getNgayLapHD(),
					hd.isUuDai() ? "Có " : "Không", hd.getTenSach().getMaSach(), hd.getKhachHang().getMaKH(),
					hd.getTongTien() });
		}
	}

	private void DocDuLieuHoaDonNgayHomNayVaoTable() {
		// TODO Auto-generated method stub
		List<HoaDon> list = hoadon_dao.getallHoaDonNgayHomNay();
		for (HoaDon hd : list) {
			modelHoaDon.addRow(new Object[] { hd.getMaHD(), hd.getNguoiLapHD().getMaNV(), hd.getNgayLapHD(),
					hd.isUuDai() ? "Có " : "Không", hd.getTenSach().getMaSach(), hd.getKhachHang().getMaKH(),
					hd.getTongTien() });
		}
	}

	public void DocDuLieuHoaDonDaHuyVaoTable() {
		List<HoaDon> list = hoadon_dao.getallHoaDonDaHuy();
		for (HoaDon hd : list) {
			modelHoaDonDaHuy.addRow(new Object[] { hd.getMaHD(), hd.getNguoiLapHD().getMaNV(), hd.getNgayLapHD(),
					hd.isUuDai() ? "Có " : "Không", hd.getTenSach().getMaSach(), hd.getKhachHang().getMaKH(),
					hd.getTongTien() });
		}
	}

	private void tim() {
		HoaDon_DAO hoaDon = new HoaDon_DAO();
		List<HoaDon> list = hoaDon.getHoaDonTheoMa(txtTimKiem.getText());
		if (txtTimKiem.getText().equals(""))
			JOptionPane.showMessageDialog(this, "VUI LÒNG NHẬP MÃ HÓA ĐƠN CẦN TÌM!");
		else if (list.size() == 0)
			JOptionPane.showMessageDialog(this, "KHÔNG TÌM THẤY!!!");
		else {
			modelHoaDon.getDataVector().removeAllElements();
			;
			for (HoaDon hd : list) {
				String[] rowData = { hd.getMaHD(), hd.getNguoiLapHD().getMaNV(), hd.getNgayLapHD() + "",
						hd.isUuDai() ? "Có ưu đãi" : "Không có ưu đãi", hd.getTenSach().getMaSach(),
						hd.getKhachHang().getMaKH(), hd.getTongTien() + "" };
				modelHoaDon.addRow(rowData);
			}
			tableHoaDon.setModel(modelHoaDon);
		}

	}

	private void timHDDaHuy() {
		HoaDon_DAO hoaDon = new HoaDon_DAO();
		List<HoaDon> list = hoaDon.getHoaDonDaHuyTheoMa(txtTimKiemHDDaHuy.getText());
		if (txtTimKiemHDDaHuy.getText().equals(""))
			JOptionPane.showMessageDialog(this, "VUI LÒNG NHẬP MÃ HÓA ĐƠN CẦN TÌM!");
		else if (list.size() == 0)
			JOptionPane.showMessageDialog(this, "KHÔNG TÌM THẤY!!!");
		else {
			modelHoaDonDaHuy.getDataVector().removeAllElements();
			;
			for (HoaDon hd : list) {
				String[] rowData = { hd.getMaHD(), hd.getNguoiLapHD().getMaNV(), hd.getNgayLapHD() + "",
						hd.isUuDai() ? "Có ưu đãi" : "Không có ưu đãi", hd.getTenSach().getMaSach(),
						hd.getKhachHang().getMaKH(), hd.getTongTien() + "" };
				modelHoaDonDaHuy.addRow(rowData);
			}
			tableHDDaHuy.setModel(modelHoaDonDaHuy);
		}

	}

	private void xoaHD() {
		String maHD = txtMaHD.getText();
		HoaDon hd = new HoaDon(maHD);
		try {
			hoadon_dao.xoaHD(hd);
			modelHoaDonDaHuy.setRowCount(0);
			resetHoaDon();
			DocDuLieuHoaDonVaoTable();
			DocDuLieuHoaDonDaHuyVaoTable();
			JOptionPane.showMessageDialog(this, "Hủy hóa đơn thành công!");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Hóa đơn không tồn tại!");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnTimKiem)) {
			tim();
		}
		if (o.equals(btnHuyHoaDon)) {
			xoaHD();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableHoaDon.getSelectedRow();
		txtMaHD.setText(modelHoaDon.getValueAt(row, 0).toString());
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
