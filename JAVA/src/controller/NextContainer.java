package controller;

import java.awt.BorderLayout;





import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import contructer.DanhMuc;
import gui.GD_KhachHang;
import gui.GD_Sach;
import gui.GD_ThanhToan;
import gui.GD_HoaDon;


import gui.GD_ThemKhachHang;


public class NextContainer {
	private JFrame root;
	private String kinSelceted = "";
	private List<DanhMuc> lisItem = null;

	public NextContainer(JFrame jpnRoot) {
		this.root = jpnRoot;

	}

	public void setView(JPanel jpnItem, JLabel jlbItem) {
		kinSelceted = "";
		jpnItem.setBackground(new Color(0, 128, 192));
		jlbItem.setBackground(new Color(0, 128, 192));
		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(new GD_ThanhToan());
		root.validate();
		root.repaint();

	}

	public void setEvent(List<DanhMuc> listItem) {
		this.lisItem = listItem;
		for (DanhMuc item : lisItem) {
			item.getJlb().addMouseListener(new LabelEnent(item.getKind(), item.getJpn(), item.getJlb()));

		}
	}

	class LabelEnent implements MouseListener {
		private JPanel node;
		private String kind;

		private JPanel jpnItem;
		private JLabel jlbItem;

		public LabelEnent(String kind, JPanel jpnItem, JLabel jlbItem) {
			super();
			this.kind = kind;
			this.jpnItem = jpnItem;
			this.jlbItem = jlbItem;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			switch (kind) {
			case "Hoa Don":

			case "Khach Hang":
				
			case "Dang Xuat":

			
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			kinSelceted = kind;
			jpnItem.setBackground(new Color(0, 128, 192));
			jlbItem.setBackground(new Color(0, 128, 192));

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jpnItem.setBackground(Color.red);
			jlbItem.setBackground(Color.red);

		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (!kinSelceted.equalsIgnoreCase(kind)) {
				jpnItem.setBackground(new Color(0, 128, 192));
				jlbItem.setBackground(new Color(0, 128, 192));
			}

		}

		private void setChangeBackGr(String kind) {
			for (DanhMuc item : lisItem) {
				if (item.getKind().equalsIgnoreCase(kind)) {
					jpnItem.setBackground(new Color(0, 128, 192));
					jlbItem.setBackground(new Color(0, 128, 192));
				} else {

				}
			}
		}

	}
}
