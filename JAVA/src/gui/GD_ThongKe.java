package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import dao.HoaDon_DAO;
import entity.HoaDon;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
public class GD_ThongKe extends JFrame  implements ActionListener{
	private JTable table;
	private DefaultTableModel modelThongKe;
	private JButton btnThongKe;
	private JLabel lblTongTien1;
	private JComboBox txtNam;
	private JComboBox txtThang;
	private JComponent panelBieuDo;
	private JLabel lblSHDHomQua;
	private JLabel lblSHDThangNay;
	private JLabel lblSHDTuanNay;
	private JLabel lblSHDHomNay;
	private JLabel lblDTHomQua;
	private JLabel lblDTHomNay;
	private JLabel lblDTTuanNay;
	private JLabel lblDTThangNay;
	private DecimalFormat de;
	public static void ThongKeScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 GD_ThongKe  TK = new GD_ThongKe();
					TK.setVisible(true);
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
					java.util.logging.Logger.getLogger(GD_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (InstantiationException ex) {
					java.util.logging.Logger.getLogger(GD_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (IllegalAccessException ex) {
					java.util.logging.Logger.getLogger(GD_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (javax.swing.UnsupportedLookAndFeelException ex) {
					java.util.logging.Logger.getLogger(GD_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				}
				try {
					GD_ThongKe frame = new GD_ThongKe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	public GD_ThongKe() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("image\\chart.png"));
		getContentPane().setBackground(new Color(0, 128, 192));
		setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		setAutoRequestFocus(false);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		String[] colHeader = { "MÃ HÓA ĐƠN",  "TÊN NHÂN VIÊN", "NGÀY LẬP HÓA ĐƠN","ƯU ĐÃI", "TÊN SÁCH", "TỔNG TIỀN"};
		modelThongKe = new DefaultTableModel(colHeader, 0);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1530, 788);
		getContentPane().add(tabbedPane);
		
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Bảng Thống Kê", null, panel, null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 192)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 20, 432, 361);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblT = new JLabel("Tháng");
		lblT.setBounds(39, 27, 106, 34);
		panel_1.add(lblT);
		lblT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtThang = new JComboBox();
		txtThang.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtThang.setBounds(39, 60, 349, 34);
		panel_1.add(txtThang);
		txtThang.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		
		JLabel lbln = new JLabel("Năm");
		lbln.setBounds(39, 104, 143, 34);
		panel_1.add(lbln);
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtNam = new JComboBox();
		txtNam.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNam.setBounds(39, 137, 349, 34);
		panel_1.add(txtNam);
		txtNam.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		
		JLabel lblTongTien = new JLabel("TỔNG:");
		lblTongTien.setBounds(39, 292, 76, 34);
		panel_1.add(lblTongTien);
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		lblTongTien1 = new JLabel("");
		lblTongTien1.setForeground(new Color(255, 0, 0));
		lblTongTien1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTongTien1.setBounds(110, 292, 289, 34);
		panel_1.add(lblTongTien1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(39, 258, 349, 1);
		panel_1.add(panel_2);
		
		btnThongKe = new JButton("Thống kê");
		btnThongKe.setForeground(new Color(255, 255, 255));
		btnThongKe.setBackground(new Color(255, 0, 0));
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThongKe.setBounds(39, 200, 115, 34);
		panel_1.add(btnThongKe);
		
		panelBieuDo = new JPanel();
		panelBieuDo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panelBieuDo.setBackground(new Color(255, 255, 255));
		panelBieuDo.setBounds(466, 20, 994, 447);
		panel.add(panelBieuDo);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 0, 0));
		panel_5.setBounds(10, 412, 432, 314);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Số Hóa Đơn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(135, 23, 96, 40);
		panel_5.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Doanh Thu");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(293, 23, 96, 40);
		panel_5.add(lblNewLabel_1_1);
		
		JLabel txtHomQua = new JLabel("Hôm qua");
		txtHomQua.setForeground(Color.WHITE);
		txtHomQua.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtHomQua.setBounds(10, 52, 96, 40);
		panel_5.add(txtHomQua);
		
		JLabel lblNewLabel_1_2 = new JLabel("Hôm nay");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(10, 102, 96, 40);
		panel_5.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tuần này");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1.setBounds(10, 152, 96, 40);
		panel_5.add(lblNewLabel_1_2_1);
		
		JLabel lblThangNay = new JLabel("Tháng này");
		lblThangNay.setForeground(Color.WHITE);
		lblThangNay.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThangNay.setBounds(10, 202, 96, 40);
		panel_5.add(lblThangNay);
		
		JPanel line1 = new JPanel();
		line1.setBounds(10, 91, 70, 1);
		panel_5.add(line1);
		
		JPanel line2 = new JPanel();
		line2.setBounds(10, 142, 70, 1);
		panel_5.add(line2);
		
		JPanel line3 = new JPanel();
		line3.setBounds(10, 193, 70, 1);
		panel_5.add(line3);
		
		JPanel line4 = new JPanel();
		line4.setBounds(10, 237, 70, 1);
		panel_5.add(line4);
		
		JPanel line5 = new JPanel();
		line5.setBounds(130, 91, 96, 1);
		panel_5.add(line5);
		
		JPanel line6 = new JPanel();
		line6.setBounds(130, 142, 96, 1);
		panel_5.add(line6);
		
		JPanel line7 = new JPanel();
		line7.setBounds(130, 193, 96, 1);
		panel_5.add(line7);
		
		JPanel line8 = new JPanel();
		line8.setBounds(130, 237, 96, 1);
		panel_5.add(line8);
		
		JPanel line9 = new JPanel();
		line9.setBounds(290, 91, 96, 1);
		panel_5.add(line9);
		
		JPanel line10 = new JPanel();
		line10.setBounds(290, 142, 96, 1);
		panel_5.add(line10);
		
		JPanel line11 = new JPanel();
		line11.setBounds(290, 191, 96, 1);
		panel_5.add(line11);
		
		JPanel line12 = new JPanel();
		line12.setBounds(290, 237, 96, 1);
		panel_5.add(line12);
		
		lblSHDHomQua = new JLabel("");
		lblSHDHomQua.setHorizontalAlignment(SwingConstants.CENTER);
		lblSHDHomQua.setForeground(new Color(255, 0, 0));
		lblSHDHomQua.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSHDHomQua.setBounds(135, 52, 96, 40);
		panel_5.add(lblSHDHomQua);
		
		lblSHDTuanNay = new JLabel("");
		lblSHDTuanNay.setHorizontalAlignment(SwingConstants.CENTER);
		lblSHDTuanNay.setForeground(Color.RED);
		lblSHDTuanNay.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSHDTuanNay.setBounds(135, 152, 96, 40);
		panel_5.add(lblSHDTuanNay);
		
		lblSHDThangNay = new JLabel("");
		lblSHDThangNay.setHorizontalAlignment(SwingConstants.CENTER);
		lblSHDThangNay.setForeground(Color.RED);
		lblSHDThangNay.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSHDThangNay.setBounds(135, 198, 96, 40);
		panel_5.add(lblSHDThangNay);
		
		lblSHDHomNay = new JLabel("");
		lblSHDHomNay.setHorizontalAlignment(SwingConstants.CENTER);
		lblSHDHomNay.setForeground(Color.RED);
		lblSHDHomNay.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSHDHomNay.setBounds(135, 102, 96, 40);
		panel_5.add(lblSHDHomNay);
		
		lblDTHomQua = new JLabel("");
		lblDTHomQua.setHorizontalAlignment(SwingConstants.LEFT);
		lblDTHomQua.setForeground(Color.RED);
		lblDTHomQua.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDTHomQua.setBounds(290, 52, 142, 40);
		panel_5.add(lblDTHomQua);
		
		lblDTHomNay = new JLabel("");
		lblDTHomNay.setHorizontalAlignment(SwingConstants.LEFT);
		lblDTHomNay.setForeground(Color.RED);
		lblDTHomNay.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDTHomNay.setBounds(293, 102, 129, 40);
		panel_5.add(lblDTHomNay);
		
		lblDTTuanNay = new JLabel("");
		lblDTTuanNay.setHorizontalAlignment(SwingConstants.LEFT);
		lblDTTuanNay.setForeground(Color.RED);
		lblDTTuanNay.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDTTuanNay.setBounds(290, 152, 132, 40);
		panel_5.add(lblDTTuanNay);
		
		lblDTThangNay = new JLabel("");
		lblDTThangNay.setHorizontalAlignment(SwingConstants.LEFT);
		lblDTThangNay.setForeground(Color.RED);
		lblDTThangNay.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDTThangNay.setBounds(290, 202, 142, 40);
		panel_5.add(lblDTThangNay);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(466, 477, 994, 249);
		panel.add(scrollPane);
		
		table = new JTable(modelThongKe);
		scrollPane.setViewportView(table);
		
	
	
		
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
	

		try {
			String query="select ngayLapHoaDon,tongTien  from HoaDon join NhanVien on NhanVien.maNV=HoaDon.maNV join Sach on HoaDon.maSach=Sach.maSach WHERE MONTH(ngayLapHoaDon) = MONTH(GETDATE()) and HoaDon.trangThai is null ORDER BY ngayLapHoaDon asc ";
			JDBCCategoryDataset dateset=new JDBCCategoryDataset(ConnectDB.getConnection(), query);
			JFreeChart chart=ChartFactory.createBarChart("Biểu đồ doanh thu", "Tháng", "Tổng tiền", dateset, PlotOrientation.VERTICAL, false, true, true);
			BarRenderer renderer=null;
			CategoryPlot plot=null;
			renderer=new BarRenderer();
			panelBieuDo.setLayout(new BorderLayout(0, 0));
			ChartPanel FrameBieuDo=new ChartPanel(chart);
			FrameBieuDo.setRefreshBuffer(true);
			FrameBieuDo.setMouseWheelEnabled(true);
			FrameBieuDo.setDomainZoomable(true);
			panelBieuDo.add(FrameBieuDo);
			panelBieuDo.validate();
			FrameBieuDo.setVisible(true);
			
		}catch(Exception eee)
		{
			eee.printStackTrace();
		}
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_6, null);
		btnThongKe.addActionListener(this);
		tabbedPane.setTabComponentAt(1, home);
		thongKeThangNay();
		tongHoaDonNgayHomQua();
		tongHoaDonNgayHomNay();
		tongHoaDonNgayTuanNay();
		tongHoaDonNgayThangNay();
		tongDoanhThuCuaHomNay();
		tongDoanhThuCuaHomQua();
		tongDoanhThuCuaTuanNay();
		tongDoanhThuCuaThangNay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnThongKe))
		{
			thongKe();
			tongTienCuaThang();
			hienThiBieuDo();
		}
	}
	private void hienThiBieuDo()
	{
		if (txtThang.getSelectedItem().equals("")) 
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tháng");
		else {
		
		try {
			String query="select ngayLapHoaDon, tongTien from HoaDon WHERE MONTH(ngayLapHoaDon) = '"+ txtThang.getSelectedItem().toString()+"' and YEAR(ngayLapHoaDon) = '"+ txtNam.getSelectedItem().toString()+"' and HoaDon.trangThai is NULL order by ngayLapHoaDon asc";
			JDBCCategoryDataset dateset=new JDBCCategoryDataset(ConnectDB.getConnection(), query);
			JFreeChart chart=ChartFactory.createBarChart("Biểu đồ doanh thu", "Tháng", "Tổng tiền", dateset, PlotOrientation.VERTICAL, false, true, true);
			BarRenderer renderer=null;
			CategoryPlot plot=null;
			renderer=new BarRenderer();
			ChartPanel frame=new ChartPanel(chart);
			panelBieuDo.add(frame, BorderLayout.CENTER);
			panelBieuDo.validate();
			frame.setVisible(true);
			
		}catch(Exception eee)
		{
			eee.printStackTrace();
		}
	}
	}
	private void tongTienCuaThang() {
		// TODO Auto-generated method stub
		HoaDon_DAO hoadon_dao=new HoaDon_DAO();
		String month=txtThang.getSelectedItem().toString();
		String year=txtNam.getSelectedItem().toString();
		ArrayList<HoaDon> listHD=hoadon_dao.getTongTienCacHoaDon(month, year);
		for(HoaDon HD: listHD)
		{
			 de = new DecimalFormat("###,###VNĐ");
			Double stringdouble= Double.valueOf(HD.getSum());	
			lblTongTien1.setText(String.valueOf(de.format(stringdouble)));
		}
	}
	private void tongHoaDonNgayHomQua() {
		// TODO Auto-generated method stub
		HoaDon_DAO hoadon_dao=new HoaDon_DAO();
		ArrayList<HoaDon> listHD=hoadon_dao.getTongSoHoaDonNgayHomQua();
		for(HoaDon HD: listHD)
		{
			String stringInt= Integer.toString(HD.getSoHoaDon());	
			lblSHDHomQua.setText(stringInt);
		}
	}
	private void tongHoaDonNgayHomNay() {
		// TODO Auto-generated method stub
		HoaDon_DAO hoadon_dao=new HoaDon_DAO();
		ArrayList<HoaDon> listHD=hoadon_dao.getTongSoHoaDonNgayHomNay();
		for(HoaDon HD: listHD)
		{
			String stringInt= Integer.toString(HD.getSoHoaDon());	
			lblSHDHomNay.setText(stringInt);
		}
	}
	private void tongHoaDonNgayTuanNay() {
		// TODO Auto-generated method stub
		HoaDon_DAO hoadon_dao=new HoaDon_DAO();
		ArrayList<HoaDon> listHD=hoadon_dao.getTongSoHoaDonTuanNay();
		for(HoaDon HD: listHD)
		{
			String stringInt= Integer.toString(HD.getSoHoaDon());	
			lblSHDTuanNay.setText(stringInt);
		}
	}
	private void tongHoaDonNgayThangNay() {
		// TODO Auto-generated method stub
		HoaDon_DAO hoadon_dao=new HoaDon_DAO();
		ArrayList<HoaDon> listHD=hoadon_dao.getTongSoHoaDonThangNay();
		for(HoaDon HD: listHD)
		{
			String stringInt= Integer.toString(HD.getSoHoaDon());	
			lblSHDThangNay.setText(stringInt);
		}
	}
	private void tongDoanhThuCuaHomNay() {
		// TODO Auto-generated method stub
		HoaDon_DAO hoadon_dao=new HoaDon_DAO();
		ArrayList<HoaDon> listHD=hoadon_dao.getTongDoanhThuHomNay();
		for(HoaDon HD: listHD)
		{
			 de = new DecimalFormat("###,###VNĐ");
			Double stringdouble= Double.valueOf(HD.getSum());	
			lblDTHomNay.setText(String.valueOf(de.format(stringdouble)));
		}
	}
	private void tongDoanhThuCuaHomQua() {
		// TODO Auto-generated method stub
		HoaDon_DAO hoadon_dao=new HoaDon_DAO();
		ArrayList<HoaDon> listHD=hoadon_dao.getTongDoanhThuHomQua();
		for(HoaDon HD: listHD)
		{
			 de = new DecimalFormat("###,###VNĐ");
			 Double stringdouble= Double.valueOf(HD.getSum());	
			lblDTHomQua.setText(String.valueOf(de.format(stringdouble)));
		}
	}
	private void tongDoanhThuCuaTuanNay() {
		// TODO Auto-generated method stub
		HoaDon_DAO hoadon_dao=new HoaDon_DAO();
		ArrayList<HoaDon> listHD=hoadon_dao.getTongDoanhThuTuanNay();
		for(HoaDon HD: listHD)
		{
			 de = new DecimalFormat("###,###VNĐ");
			 Double stringdouble= Double.valueOf(HD.getSum());	
			lblDTTuanNay.setText(String.valueOf(de.format(stringdouble)));
		}
	}
	private void tongDoanhThuCuaThangNay() {
		// TODO Auto-generated method stub
		HoaDon_DAO hoadon_dao=new HoaDon_DAO();
		ArrayList<HoaDon> listHD=hoadon_dao.getTongDoanhThuThangNay();
		for(HoaDon HD: listHD)
		{
			 de = new DecimalFormat("###,###VNĐ");
			 Double stringdouble= Double.valueOf(HD.getSum());	
			lblDTThangNay.setText(String.valueOf(de.format(stringdouble)));
		}
	}
	private void thongKe() {
		HoaDon_DAO hoadon_dao=new HoaDon_DAO();
		String month=txtThang.getSelectedItem().toString();
		String year=txtNam.getSelectedItem().toString();
		List<HoaDon> list = hoadon_dao.getHoaDonTheoThangVaNam(month, year);
		if (txtThang.getSelectedItem().equals("")) 
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tháng");
		else if(list.size()==0) 
			   JOptionPane.showMessageDialog(this, "Không có dữ liệu");
		else
		 {	
			modelThongKe.getDataVector().removeAllElements();;
			for(HoaDon hd : list){
			  String [] rowData = {hd.getMaHD(), hd.getNguoiLapHD().getMaNV(), hd.getNgayLapHD()+"", hd.isUuDai() ? "Có ưu đãi": "Không có ưu đãi", hd.getTenSach().getMaSach(), hd.getTongTien()+""};
			  modelThongKe.addRow(rowData);			
			}
			table.setModel(modelThongKe);
		 }
		
	}
	private void thongKeThangNay() {
		HoaDon_DAO hoadon_dao=new HoaDon_DAO();
		
		List<HoaDon> list = hoadon_dao.getallHoaDonThangNay();
			for(HoaDon hd : list){
			  String [] rowData = {hd.getMaHD(), hd.getNguoiLapHD().getMaNV(), hd.getNgayLapHD()+"", hd.isUuDai() ? "Có ưu đãi": "Không có ưu đãi", hd.getTenSach().getMaSach(), hd.getTongTien()+""};
			  modelThongKe.addRow(rowData);			
			}
			table.setModel(modelThongKe);
	}
}
