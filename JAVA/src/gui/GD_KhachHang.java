package gui;

import javax.swing.JPanel;


import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import dao.KhachHang_DAO;
import dao.LoaiKhachHang_DAO;
import dao.LoaiSach_DAO;
import dao.NhaXuatBan_DAO;
import entity.KhachHang;
import entity.LoaiKhachHang;
import entity.LoaiSach;
import entity.NhaXuatBan;
import entity.Sach;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JPanel;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;

import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.LoaiKhachHang_DAO;
import dao.LoaiSach_DAO;
import dao.NhaXuatBan_DAO;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiKhachHang;
import entity.LoaiSach;
import entity.NhaXuatBan;
import entity.Sach;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;
public class GD_KhachHang extends JFrame implements ActionListener, MouseListener{
	private JTable table_dsKH;
	private KhachHang_DAO khachhang_dao;
	private DefaultTableModel modelSach;
	private LoaiKhachHang_DAO loaikhachhang_dao;
	private JTextField txtTimKiem;
	private JTable tableDSKH;
	private DefaultTableModel modelKhachHang;
	private String maLoaiKhachHang;
	private JButton btnHienTatCa;
	private JComboBox cboSort;
	private JComboBox cboTimKiem;
	private JButton btnTimKiem;
	
	public static void KhachHangScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 GD_KhachHang  KH = new GD_KhachHang();
					KH.setVisible(true);
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
					java.util.logging.Logger.getLogger(GD_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (InstantiationException ex) {
					java.util.logging.Logger.getLogger(GD_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (IllegalAccessException ex) {
					java.util.logging.Logger.getLogger(GD_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (javax.swing.UnsupportedLookAndFeelException ex) {
					java.util.logging.Logger.getLogger(GD_Chinh.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				}
				try {
					GD_KhachHang frame = new GD_KhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	
	
	
	
	
	
	
	
		public GD_KhachHang() {
			getContentPane().setBackground(new Color(0, 128, 192));
			khachhang_dao=new KhachHang_DAO();
			loaikhachhang_dao=new LoaiKhachHang_DAO();
			setBackground(Color.GRAY);
			getContentPane().setLayout(null);
			
			setAutoRequestFocus(false);
			setExtendedState(Frame.MAXIMIZED_BOTH);
			
			
			String[] colHeader = { "Mã khách hàng", "Tên khách hàng", "SĐT", "Email", "Loại khách hàng", "Giới tính", "Địa chỉ" };
			modelKhachHang = new DefaultTableModel(colHeader, 0);
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBackground(new Color(192, 192, 192));
			tabbedPane.setBounds(0, 0, 1536, 790);
			getContentPane().add(tabbedPane);
			
			tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 10));


			JPanel panel_8 = new JPanel();
			tabbedPane.addTab("Danh Sách Khách Hàng", null, panel_8, null);
			panel_8.setBackground(new Color(240, 240, 240));
			panel_8.setLayout(null);
			
			txtTimKiem = new JTextField();
			txtTimKiem.setBounds(144, 15, 536, 30);
			panel_8.add(txtTimKiem);
			txtTimKiem.setColumns(10);
			
			JPanel panel = new JPanel();
			panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 192)));
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(22, 55, 1488, 686);
			panel_8.add(panel);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 59, 1468, 578);
			panel.add(scrollPane);
			tableDSKH = new JTable(modelKhachHang);
			tableDSKH.setEnabled(false);
			tableDSKH.setRowSelectionAllowed(false);
			scrollPane.setViewportView(tableDSKH);
			
			btnHienTatCa = new JButton("Hiện tất cả");
			btnHienTatCa.setBounds(1352, 647, 126, 30);
			panel.add(btnHienTatCa);
			btnHienTatCa.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnHienTatCa.setForeground(new Color(255, 255, 255));
			btnHienTatCa.setBackground(new Color(0, 128, 192));
			btnHienTatCa.addActionListener(this);
			
			JComboBox cboSapXep = new JComboBox();
			cboSapXep.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cboSapXep.getSelectedItem().equals("Tăng dần theo tên"))
					{
						DocDuLieuKhachHangTangDanTheoTenVaoTable();
					}
					else if(cboSapXep.getSelectedItem().equals("Giảm dần theo tên"))
					{
						DocDuLieuKhachHangGiamDanTheoTenVaoTable();
					}
				}
			});
			cboSapXep.setModel(new DefaultComboBoxModel(new String[] {"Tăng dần theo tên", "Giảm dần theo tên"}));
			cboSapXep.setBounds(1392, 23, 118, 26);
			panel_8.add(cboSapXep);
			
			cboTimKiem = new JComboBox();
			cboTimKiem.setModel(new DefaultComboBoxModel(new String[] {"Tìm theo mã", "Tìm theo tên"}));
			cboTimKiem.setBounds(22, 16, 112, 26);
			panel_8.add(cboTimKiem);
			
			btnTimKiem = new JButton("");
			btnTimKiem.setIcon(new ImageIcon("image\\search.png"));
			btnTimKiem.setBounds(690, 15, 47, 30);
			panel_8.add(btnTimKiem);
			
			JLabel lblSapXep = new JLabel("Sắp xếp:");
			lblSapXep.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSapXep.setBounds(1320, 23, 79, 22);
			panel_8.add(lblSapXep);
			DocDuLieuKhachHangVaoTable();
		
			
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
			tabbedPane.addTab("New tab", null, panel_1, null);
			tabbedPane.setTabComponentAt(1, home);
			tableDSKH.addMouseListener(this);
			btnTimKiem.addActionListener(this);
			
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
		public void DocDuLieuKhachHangTangDanTheoTenVaoTable() {
			resetKhachHang();
			List<KhachHang> list=khachhang_dao.getallKhachHangTangDanTheoTen();
			for(KhachHang kh:list)
			{
				modelKhachHang.addRow(new Object[] {
						kh.getMaKH(), kh.getTenKH(), kh.getSDT(), kh.getEmail(), kh.getLoaiKhachHang().getMaLoaiKH(),kh.isGioiTinh() ? "Nam":"Nữ" , kh.getDiaChi()
						});
			}
		}
		public void DocDuLieuKhachHangGiamDanTheoTenVaoTable() {
			resetKhachHang();
			List<KhachHang> list=khachhang_dao.getallKhachHangGiamDanTheoTen();
			for(KhachHang kh:list)
			{
				modelKhachHang.addRow(new Object[] {
						kh.getMaKH(), kh.getTenKH(), kh.getSDT(), kh.getEmail(), kh.getLoaiKhachHang().getMaLoaiKH(),kh.isGioiTinh() ? "Nam":"Nữ" , kh.getDiaChi()
						});
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
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object o=e.getSource();
			if(o.equals(btnHienTatCa))
			{
				resetKhachHang();
				DocDuLieuKhachHangVaoTable();
			}
			if(o.equals(btnTimKiem)&&cboTimKiem.getSelectedItem().equals("Tìm theo mã"))
			{
				timKhachHangTheoMa();
			}else if(o.equals(btnTimKiem)&&cboTimKiem.getSelectedItem().equals("Tìm theo tên"))
			{
				timKhachHangTheoTen();
			}
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row = tableDSKH.getSelectedRow();
			
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

