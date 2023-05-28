package gui;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import dao.HoaDon_DAO;
import entity.HoaDon;
import gui.GD_HoaDon;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.MouseAdapter;
import javax.swing.ListSelectionModel;
public class GD_LichSuHoaDon extends JFrame implements ActionListener {

	private JPanel jpnGD_LichSuHoaDon;
	private JTable table_dsHD;
	private JTextField txtTimKiem;
	private DefaultTableModel modelHoaDon;
	private JTable tableHoaDon;
	private JTable tableHoaDon_1;
	private HoaDon_DAO hoadon;
	private HoaDon_DAO hoadon_dao;
	private JTable table;
	private JButton btnTimKim;

	

	public static void LSScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 GD_LichSuHoaDon window = new GD_LichSuHoaDon();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public GD_LichSuHoaDon() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAutoRequestFocus(false);
		try {
			ConnectDB.getInstance().connect();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		hoadon_dao=new HoaDon_DAO();
	
		setBounds(100, 100, 1076, 622);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
	
		getContentPane().add(panel);
		panel.setLayout(null);
		JLabel lbl_danhMucThongTinKH = new JLabel("LỊCH SỬ HÓA ĐƠN");
		lbl_danhMucThongTinKH.setForeground(new Color(220, 20, 60));
		lbl_danhMucThongTinKH.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_danhMucThongTinKH.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl_danhMucThongTinKH.setBounds(0, 0, 1503, 65);
		panel.add(lbl_danhMucThongTinKH);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 0, 1075, 575);
		getContentPane().add(panel_8);
		panel_8.setBackground(new Color(240, 240, 240));
		panel_8.setLayout(null);
		
		JButton btnHuy = new JButton("Thoát");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnHuy.setBackground(Color.RED);
		btnHuy.setForeground(Color.WHITE);
		
		btnHuy.setBounds(819, 519, 179, 41);
		panel_8.add(btnHuy);
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblHoaDon = new JLabel("Mã hóa đơn:");
		lblHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHoaDon.setBounds(186, 28, 100, 33);
		panel_8.add(lblHoaDon);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(296, 30, 483, 33);
		panel_8.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		btnTimKim = new JButton("Tìm kiếm");
		btnTimKim.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTimKim.setBounds(789, 28, 120, 33);
		panel_8.add(btnTimKim);
		
		tableHoaDon = new JTable();
		String[] colHeader = { "MÃ HÓA ĐƠN",  "TÊN NHÂN VIÊN", "NGÀY LẬP HÓA ĐƠN","ƯU ĐÃI","TÊN KHÁCH HÀNG",  "TỔNG TIỀN"};
		modelHoaDon = new DefaultTableModel(colHeader, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 92, 928, 417);
		panel_8.add(scrollPane);
		tableHoaDon_1 = new JTable(modelHoaDon);
		tableHoaDon_1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableHoaDon_1.setShowGrid(false);
		tableHoaDon_1.setShowHorizontalLines(false);
		tableHoaDon_1.setShowVerticalLines(false);
		tableHoaDon_1.setSurrendersFocusOnKeystroke(true);
		tableHoaDon_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		scrollPane.setViewportView(tableHoaDon_1);
		DocDuLieuHoaDonVaoTable();
		btnTimKim.addActionListener(this);

	}
	public void DocDuLieuHoaDonVaoTable() {
		List<HoaDon> list=hoadon_dao.getallHoaDon();
		for(HoaDon hd:list)
		{
			modelHoaDon.addRow(new Object[] {hd.getMaHD(),  hd.getNguoiLapHD().getMaNV(), hd.getNgayLapHD(),hd.isUuDai() ? "Có ": "Không",hd.getKhachHang().getMaKH(),  hd.getTongTien()
					});
		}
	}
	private void tim() {
		HoaDon_DAO hoaDon = new HoaDon_DAO();
		List<HoaDon> list = hoaDon.getHoaDonTheoMa(txtTimKiem.getText());
		if (txtTimKiem.getText().equals("")) 
			JOptionPane.showMessageDialog(this, "VUI LÒNG NHẬP MÃ HÓA ĐƠN CẦN TÌM!");
		else if(list.size()==0) 
			   JOptionPane.showMessageDialog(this, "KHÔNG TÌM THẤY!!!");
		else
		 {	
			modelHoaDon.getDataVector().removeAllElements();;
			for(HoaDon hd : list){
			  String [] rowData = {hd.getMaHD(), hd.getNguoiLapHD().getMaNV(), hd.getNgayLapHD()+"", hd.isUuDai() ? "Có ưu đãi": "Không có ưu đãi", hd.getTongTien()+""};
			  modelHoaDon.addRow(rowData);			
			}
			tableHoaDon.setModel(modelHoaDon);
		 }
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnTimKim))
		{
			tim();
		}
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row =modelHoaDon.getRowCount();
		
		
	}

}
