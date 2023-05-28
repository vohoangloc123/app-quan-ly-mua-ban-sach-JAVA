package gui;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.KhachHang_DAO;
import dao.LoaiKhachHang_DAO;
import entity.*;
import regex.MauRegex;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;

public class GD_ThemKhachHang extends JFrame implements ActionListener, MouseListener {
	private JTable table_dsKH;
	private JTextField txt_maKH;
	private JTextField txt_tenKH;
	private JTextField txt_SDT;
	private JTextField txt_diaChi;
	private JTextField txt_email;
	private KhachHang_DAO khachhang_dao;
	private DefaultTableModel modelSach;
	private JButton btnThem;
	private JComboBox cbo_loai;
	private LoaiKhachHang_DAO loaikhachhang_dao;
	private JCheckBox chk_nam;
	private JTextField txtTimKiem;
	private JButton btnTimKiem;
	private JButton btnLamMoi;
	private JTable tableDSKH;
	private DefaultTableModel modelKhachHang;
	private String maLoaiKhachHang;
	private JButton btnSua;
	private JPanel jpnThemKH;
	private JButton btnXoa;
	public String tamMa;
	public String tamTen;
	private JComboBox cboTimKiem;
	private JButton btnHienTatCa;
	private static GD_ThemKhachHang window;
	public static void ThemKHScreen() {
		EventQueue.invokeLater(new Runnable() {
			

			public void run() {
				try {
					window = new GD_ThemKhachHang();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
		public GD_ThemKhachHang() {
			setIconImage(Toolkit.getDefaultToolkit().getImage("image\\customer.png"));
			setResizable(false);
			khachhang_dao=new KhachHang_DAO();
			loaikhachhang_dao=new LoaiKhachHang_DAO();
			setBackground(new Color(240, 240, 240));
			getContentPane().setLayout(null);
			setBounds(100, 100, 850, 811);
			setLocationRelativeTo(null);
			
			
			String[] colHeader = { "Mã khách hàng", "Tên khách hàng", "SĐT", "Email", "Loại khách hàng", "Giới tính", "Địa chỉ" };
			modelKhachHang = new DefaultTableModel(colHeader, 0);
		
			
			JTabbedPane tbnKH = new JTabbedPane(JTabbedPane.TOP);
			tbnKH.setBounds(0, 10, 846, 773);
			getContentPane().add(tbnKH);
			
			JPanel panel_1 = new JPanel();
			tbnKH.addTab("Danh mục KH", null, panel_1, null);
			panel_1.setLayout(null);
			
			txtTimKiem = new JTextField();
			txtTimKiem.setBounds(26, 34, 573, 31);
			panel_1.add(txtTimKiem);
			txtTimKiem.setColumns(10);
			
			btnTimKiem = new JButton("");
			btnTimKiem.setBounds(760, 34, 54, 31);
			panel_1.add(btnTimKiem);
			btnTimKiem.setIcon(new ImageIcon("image\\search.png"));
			btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			
			JPanel panel_8 = new JPanel();
			panel_8.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 192)));
			panel_8.setBounds(26, 75, 788, 610);
			panel_1.add(panel_8);
			panel_8.setBackground(Color.WHITE);
			panel_8.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 10, 768, 590);
			panel_8.add(scrollPane);
			tableDSKH = new JTable(modelKhachHang);
			scrollPane.setViewportView(tableDSKH);
			
			JLabel lblNewLabel = new JLabel("Danh Sách Khách Hàng");
			lblNewLabel.setBounds(0, 0, 841, 36);
			panel_1.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setForeground(SystemColor.textHighlight);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			
			btnXoa = new JButton("");
			btnXoa.setIcon(new ImageIcon("image\\delete.png"));
			btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnXoa.setBounds(26, 691, 82, 31);
			panel_1.add(btnXoa);
			
			cboTimKiem = new JComboBox();
			cboTimKiem.setModel(new DefaultComboBoxModel(new String[] {"Tìm theo mã", "Tìm theo tên"}));
			cboTimKiem.setBounds(609, 34, 141, 31);
			panel_1.add(cboTimKiem);
			
			btnHienTatCa = new JButton("Hiện tất cả");
			btnHienTatCa.setBounds(729, 695, 85, 27);
			panel_1.add(btnHienTatCa);
			
			 jpnThemKH = new JPanel();
			 tbnKH.addTab("Quản lý KH", null, jpnThemKH, null);
			 jpnThemKH.setLayout(null);
			 
			 JPanel panel_9 = new JPanel();
			 panel_9.setBackground(new Color(255, 255, 255));
			 panel_9.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 192)));
			 panel_9.setBounds(131, 77, 609, 645);
			 jpnThemKH.add(panel_9);
			 panel_9.setLayout(null);
			 
			 txt_maKH = new JTextField();
			 txt_maKH.setBounds(340, 77, 194, 31);
			 panel_9.add(txt_maKH);
			 txt_maKH.setBackground(SystemColor.inactiveCaption);
			 txt_maKH.setText("");
			 txt_maKH.setHorizontalAlignment(SwingConstants.CENTER);
			 txt_maKH.setFont(new Font("Tahoma", Font.BOLD, 13));
			 txt_maKH.setColumns(10);
			 
			 txt_tenKH = new JTextField();
			 txt_tenKH.setBounds(340, 140, 194, 31);
			 panel_9.add(txt_tenKH);
			 txt_tenKH.setBackground(SystemColor.inactiveCaption);
			 txt_tenKH.setHorizontalAlignment(SwingConstants.CENTER);
			 txt_tenKH.setFont(new Font("Tahoma", Font.BOLD, 13));
			 txt_tenKH.setColumns(10);
			 
			 txt_SDT = new JTextField();
			 txt_SDT.setBounds(340, 203, 194, 31);
			 panel_9.add(txt_SDT);
			 txt_SDT.setBackground(SystemColor.inactiveCaption);
			 txt_SDT.setHorizontalAlignment(SwingConstants.CENTER);
			 txt_SDT.setFont(new Font("Tahoma", Font.BOLD, 13));
			 txt_SDT.setColumns(10);
			 
			 JPanel panel_6 = new JPanel();
			 panel_6.setBounds(82, 406, 194, 31);
			 panel_9.add(panel_6);
			 panel_6.setLayout(null);
			 panel_6.setBackground(new Color(128, 255, 128));
			 JLabel lblN_gioiTinh = new JLabel("Giới tính:");
			 lblN_gioiTinh.setBounds(10, 0, 139, 31);
			 panel_6.add(lblN_gioiTinh);
			 lblN_gioiTinh.setFont(new Font("Tahoma", Font.BOLD, 18));
			 
			 JPanel panel_7 = new JPanel();
			 panel_7.setBounds(82, 471, 194, 31);
			 panel_9.add(panel_7);
			 panel_7.setLayout(null);
			 panel_7.setBackground(new Color(128, 255, 128));
			 
			 JLabel lbl_diaChi = new JLabel("Địa chỉ:");
			 lbl_diaChi.setBounds(10, 0, 139, 28);
			 panel_7.add(lbl_diaChi);
			 lbl_diaChi.setFont(new Font("Tahoma", Font.BOLD, 18));
			 
			 JPanel panel_5 = new JPanel();
			 panel_5.setBounds(82, 339, 194, 31);
			 panel_9.add(panel_5);
			 panel_5.setLayout(null);
			 panel_5.setBackground(new Color(128, 255, 128));
			 
			 JLabel lbl_loai = new JLabel("Loại:");
			 lbl_loai.setBounds(10, 0, 139, 28);
			 panel_5.add(lbl_loai);
			 lbl_loai.setFont(new Font("Tahoma", Font.BOLD, 18));
			 
			 JPanel panel_4 = new JPanel();
			 panel_4.setBounds(82, 271, 194, 31);
			 panel_9.add(panel_4);
			 panel_4.setLayout(null);
			 panel_4.setBackground(new Color(128, 255, 128));
			 
			 JLabel lbl_email = new JLabel("Email:");
			 lbl_email.setBounds(10, 0, 139, 31);
			 panel_4.add(lbl_email);
			 lbl_email.setFont(new Font("Tahoma", Font.BOLD, 18));
			 
			 JPanel panel_3 = new JPanel();
			 panel_3.setBounds(82, 203, 194, 31);
			 panel_9.add(panel_3);
			 panel_3.setLayout(null);
			 panel_3.setBackground(new Color(128, 255, 128));
			 
			 JLabel lbl_sdt = new JLabel("SDT:");
			 lbl_sdt.setBounds(10, 0, 139, 28);
			 panel_3.add(lbl_sdt);
			 lbl_sdt.setFont(new Font("Tahoma", Font.BOLD, 18));
			 
			 JPanel panel_2 = new JPanel();
			 panel_2.setBounds(82, 140, 194, 31);
			 panel_9.add(panel_2);
			 panel_2.setLayout(null);
			 panel_2.setBackground(new Color(128, 255, 128));
			 
			 JLabel lbl_tenKH = new JLabel("Tên khách hàng:");
			 lbl_tenKH.setBounds(10, 0, 174, 28);
			 panel_2.add(lbl_tenKH);
			 lbl_tenKH.setFont(new Font("Tahoma", Font.BOLD, 18));
			 
			 JPanel panel = new JPanel();
			 panel.setBounds(82, 77, 194, 31);
			 panel_9.add(panel);
			 panel.setBackground(new Color(128, 255, 128));
			 panel.setLayout(null);
			 
			 JLabel lbl_maKH = new JLabel("Mã khách hàng:");
			 lbl_maKH.setBounds(10, 0, 157, 31);
			 panel.add(lbl_maKH);
			 lbl_maKH.setFont(new Font("Tahoma", Font.BOLD, 18));
			 
			 txt_diaChi = new JTextField();
			 txt_diaChi.setBounds(340, 471, 194, 31);
			 panel_9.add(txt_diaChi);
			 txt_diaChi.setBackground(SystemColor.inactiveCaption);
			 txt_diaChi.setHorizontalAlignment(SwingConstants.CENTER);
			 txt_diaChi.setFont(new Font("Tahoma", Font.BOLD, 13));
			 txt_diaChi.setColumns(10);
			 
			 chk_nam = new JCheckBox("Nam");
			 chk_nam.setBounds(340, 406, 81, 34);
			 panel_9.add(chk_nam);
			 chk_nam.setFont(new Font("Tahoma", Font.BOLD, 16));
			 
			 cbo_loai = new JComboBox();
			 cbo_loai.setBounds(340, 339, 194, 33);
			 panel_9.add(cbo_loai);
			 cbo_loai.setFont(new Font("Tahoma", Font.BOLD, 15));
			 txt_email = new JTextField();
			 txt_email.setBounds(340, 271, 194, 31);
			 panel_9.add(txt_email);
			 txt_email.setBackground(SystemColor.inactiveCaption);
			 txt_email.setHorizontalAlignment(SwingConstants.CENTER);
			 txt_email.setFont(new Font("Tahoma", Font.BOLD, 13));
			 txt_email.setColumns(10);
				ArrayList<LoaiKhachHang> listKH=loaikhachhang_dao.getallLoaiKhachHang();
				for(LoaiKhachHang loaiKH: listKH)
				{
					cbo_loai.addItem(loaiKH.getTenLoaiKH());
				}
			 btnSua = new JButton("Cập nhật");
			 btnSua.setBounds(237, 574, 150, 47);
			 panel_9.add(btnSua);
			 btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
			 btnSua.setIcon(new ImageIcon("image\\edit.png"));
			 
			 btnLamMoi = new JButton("Làm mới");
			 btnLamMoi.setBounds(397, 574, 150, 47);
			 panel_9.add(btnLamMoi);
			 btnLamMoi.setIcon(new ImageIcon("image\\refesh.png"));
			 btnLamMoi.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 	}
			 });
			 btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
			 
			 btnThem = new JButton("Thêm");
			 btnThem.setBounds(77, 574, 150, 47);
			 panel_9.add(btnThem);
			 btnThem.setIcon(new ImageIcon("image\\add.png"));
			 btnThem.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		setVisible(true);
			 		
			 	}
			 });
			 btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
			 btnThem.addActionListener(this);
			 btnLamMoi.addActionListener(this);
			 btnSua.addActionListener(this);
			 
			 JLabel lblNewLabel_1 = new JLabel("Thông Tin Khách Hàng");
			 lblNewLabel_1.setBounds(0, 0, 841, 67);
			 jpnThemKH.add(lblNewLabel_1);
			 lblNewLabel_1.setForeground(new Color(0, 128, 192));
			 lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			 lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			tableDSKH.addMouseListener(this);
			btnTimKiem.addActionListener(this);
			btnHienTatCa.addActionListener(this);
			btnXoa.addActionListener(this);
			DocDuLieuKhachHangVaoTable();
		
}
		public void resetKhachHang()
		{
			int rowCount = modelKhachHang.getRowCount();
			for (int i = 0; i < rowCount; i++) {
				modelKhachHang.removeRow(0);
			}
		}
		public void DocDuLieuKhachHangVaoTable() {
			resetKhachHang();
			List<KhachHang> list=khachhang_dao.getallKhachHang();
			for(KhachHang kh:list)
			{
				modelKhachHang.addRow(new Object[] {
						kh.getMaKH(), kh.getTenKH(), kh.getSDT(), kh.getEmail(), kh.getLoaiKhachHang().getMaLoaiKH(),kh.isGioiTinh() ? "Nam":"Nữ" , kh.getDiaChi()
						});
			}
		}
		private void themKH()
		{
			String maKH=txt_maKH.getText();
			String hoTenKH=txt_tenKH.getText();
			String SDT=txt_SDT.getText();
			String email=txt_email.getText();
			String tenLoaiKH=cbo_loai.getSelectedItem().toString();
			maLoaiKhachHang="";
			LoaiKhachHang_DAO dsKH = new LoaiKhachHang_DAO();
			List<LoaiKhachHang> listLoaiKH= dsKH.getallLoaiKhachHang();
			for (LoaiKhachHang loaiKH : listLoaiKH) {
				if (loaiKH.getTenLoaiKH().equals(tenLoaiKH)) {
					this.maLoaiKhachHang = loaiKH.getMaLoaiKH();
				}
			}
			Boolean gioiTinh=chk_nam.isSelected();
			String diaChi=txt_diaChi.getText();
			KhachHang kh=new KhachHang(maKH, hoTenKH, SDT, email, new LoaiKhachHang(maLoaiKhachHang), gioiTinh, diaChi);
			try {
				
				if(khachhang_dao.createKH(kh))
				{
				modelKhachHang.addRow(new Object[] {
						kh.getMaKH(), kh.getTenKH(), kh.getSDT(), kh.getEmail(), kh.getLoaiKhachHang().getMaLoaiKH(), kh.isGioiTinh() ? "Nam": "Nữ", kh.getDiaChi()
				});
				DocDuLieuKhachHangVaoTable();
				JOptionPane.showMessageDialog(this, "Thêm thành công");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Trung mã khách hàng mời bạn nhập lại!");
				}
			}catch (Exception e1) {
				System.out.println(e1.toString());
			}	
		}
		private void xoaKH() {
			int row =tableDSKH.getSelectedRow();
			if(row >=0) {
				
				String maKH =(String) tableDSKH.getValueAt(row, 0);
				if(khachhang_dao.deleteKH(maKH)) {
					modelKhachHang.removeRow(row);
				}
			}
			JOptionPane.showMessageDialog(this, "Xóa thành công !");
		}
		private void lamMoi()
		{
			txt_maKH.setText("");
			txt_tenKH.setText("");
			cbo_loai.setSelectedItem(null);
			txt_SDT.setText("");
			txt_email.setText("");
			txt_diaChi.setText("");
		}
		private void suaKH()
		{
			String maKH=txt_maKH.getText();
			String hoTenKH=txt_tenKH.getText();
			String SDT=txt_SDT.getText();
			String email=txt_email.getText();
			String tenLoaiKH=cbo_loai.getSelectedItem().toString();
			maLoaiKhachHang="";
			LoaiKhachHang_DAO dsKH = new LoaiKhachHang_DAO();
			List<LoaiKhachHang> listLoaiKH= dsKH.getallLoaiKhachHang();
			for (LoaiKhachHang loaiKH : listLoaiKH) {
				if (loaiKH.getTenLoaiKH().equals(tenLoaiKH)) {
					this.maLoaiKhachHang = loaiKH.getMaLoaiKH();
				}
			}
			Boolean gioiTinh=chk_nam.isSelected();
			String diaChi=txt_diaChi.getText();
			
			KhachHang kh=new KhachHang(maKH, hoTenKH, SDT, email, new LoaiKhachHang(maLoaiKhachHang), gioiTinh, diaChi);
			try
			{
				khachhang_dao.updateKH(kh);
				modelKhachHang.setRowCount(0);
				DocDuLieuKhachHangVaoTable();
				JOptionPane.showMessageDialog(this, "Sửa thành công");
				//xoaTrang();
			}catch(Exception e1)
			{
				JOptionPane.showMessageDialog(this, "Trùng mã");
			}
		}
		private void timKhachHangTheoMa() {
			KhachHang_DAO khachhang_dao=new KhachHang_DAO();
			List<KhachHang> list = khachhang_dao.getKhachHangTheoMa(txtTimKiem.getText());
			if (txtTimKiem.getText().equals("")) 
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khách hàng cần tìm!");
			else if(list.size()==0) 
				   JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			else {
				for(KhachHang kh: list){
					resetKhachHang();
					modelKhachHang.addRow(new Object[] { kh.getMaKH(), kh.getTenKH(), kh.getSDT(), kh.getEmail(), kh.getLoaiKhachHang().getMaLoaiKH(),kh.isGioiTinh() ? "Nam":"Nữ" , kh.getDiaChi()
							});
					tableDSKH.setModel(modelKhachHang);
					}
					
			}
		}
		private void timKhachHangTheoTen() {
			KhachHang_DAO khachhang_dao=new KhachHang_DAO();
			List<KhachHang> list = khachhang_dao.getKhachHangTheoTen(txtTimKiem.getText());
			if (txtTimKiem.getText().equals("")) 
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tên khách hàng cần tìm!");
			else if(list.size()==0) 
				   JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			else {
				for(KhachHang kh: list){
					resetKhachHang();
					modelKhachHang.addRow(new Object[] { kh.getMaKH(), kh.getTenKH(), kh.getSDT(), kh.getEmail(), kh.getLoaiKhachHang().getMaLoaiKH(),kh.isGioiTinh() ? "Nam":"Nữ" , kh.getDiaChi()
							});
					tableDSKH.setModel(modelKhachHang);
					}
					
			}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object o=e.getSource();
			if(o.equals(btnThem))
			{
				if(validatekhachHang())
				{
					
					themKH();
					lamMoi();
				}
			}
			if(o.equals(btnXoa))
			{
					xoaKH();
					lamMoi();
			}
			if(o.equals(btnSua))
			{
				if(validatekhachHang())
				{
					suaKH();
					lamMoi();
				}
			}
			if(o.equals(btnTimKiem)&& cboTimKiem.getSelectedItem().equals("Tìm theo mã"))
			{
				timKhachHangTheoMa();
			}
			else if(o.equals(btnTimKiem)&& cboTimKiem.getSelectedItem().equals("Tìm theo tên"))
			{
				timKhachHangTheoTen();
			}
			if(o.equals(btnLamMoi))
			{
				lamMoi();
			}
			if(o.equals(btnHienTatCa))
			{
				DocDuLieuKhachHangVaoTable();
			}
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row = tableDSKH.getSelectedRow();
			txt_maKH.setText(modelKhachHang.getValueAt(row, 0).toString());
			txt_tenKH.setText(modelKhachHang.getValueAt(row, 1).toString());
			txt_SDT.setText(modelKhachHang.getValueAt(row, 2).toString());
			txt_email.setText(modelKhachHang.getValueAt(row, 3).toString());
			cbo_loai.setSelectedItem(modelKhachHang.getValueAt(row, 4).toString());
			chk_nam.setSelected(modelKhachHang.getValueAt(row, 5).toString() == "Nam" ? true : false);
			txt_diaChi.setText(modelKhachHang.getValueAt(row, 6).toString());
		}
		private boolean validatekhachHang() {
			String maKH=txt_maKH.getText();
			String hoTenKH=txt_tenKH.getText();
			String SDT=txt_SDT.getText();
			String email=txt_email.getText();
			String diaChi=txt_diaChi.getText();
			if(maKH.length() == 0) {
				JOptionPane.showMessageDialog(null, "Mã KH không được để trống");
				txt_maKH.requestFocus();
				txt_maKH.selectAll();
				return false;
			}else {
				if(!maKH.matches(MauRegex.REGEX_SODIENTHOAI)) {
					JOptionPane.showMessageDialog(null, "Mã KH là số và bắt đầu bằng 0 và theo sau là 9 chữ số");
					txt_maKH.requestFocus();
					txt_maKH.selectAll();
					return false;
				}
			}
			if(hoTenKH.length() == 0) {
				JOptionPane.showMessageDialog(null, "Tên khách hàng không được để trống");
				txt_tenKH.requestFocus();
				txt_tenKH.selectAll();
				return false;
			}else {
				if(!hoTenKH.matches(MauRegex.REGEX_TEN)) {
					JOptionPane.showMessageDialog(null, "Tên khách hàng không chứa số và các kí tự đặt biệt");
					txt_tenKH.requestFocus();
					txt_tenKH.selectAll();
					return false;
				}
			}
			if(diaChi.length() == 0) {
				JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống");
				txt_diaChi.requestFocus();
				txt_diaChi.selectAll();
				return false;
			}else {
				if(!diaChi.matches(MauRegex.REGEX_DIACHI)) {
					JOptionPane.showMessageDialog(null, "Địa chỉ không chứa các kí tự đặt biệt ngoại trừ , .");
					txt_diaChi.requestFocus();
					txt_diaChi.selectAll();
					return false;
				}
			}
			if(SDT.length() == 0) {
				JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống");
				txt_SDT.requestFocus();
				txt_SDT.selectAll();
				return false;
			}else {
				if(!SDT.matches(MauRegex.REGEX_SODIENTHOAI)) {
					JOptionPane.showMessageDialog(null, "Số điện thoại bắt đầu bằng 0 và theo sau là 9 chữ số");
					txt_SDT.requestFocus();
					txt_SDT.selectAll();
					return false;
				}
			}
			if(email.length() == 0) {
				JOptionPane.showMessageDialog(null, "Email không được để trống");
				txt_email.requestFocus();
				txt_email.selectAll();
				return false;
			}else {
				if(!email.matches(MauRegex.REGEX_EMAIL)) {
					JOptionPane.showMessageDialog(null, "Email sai định dạng");
					txt_email.requestFocus();
					txt_email.selectAll();
					return false;
				}
			}
			return true;
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
