package entity;

import java.sql.Date;

public class HoaDon {

	private String maHD;
	private NhanVien nguoiLapHD;
	private Date ngayLapHD;
	private boolean uuDai;
	private Sach tenSach;
	private KhachHang khachHang;
	private Double tongTien;
	private double sum;
	private int soHoaDon;
	private boolean trangThai;
	public HoaDon(String maHD, NhanVien nguoiLapHD, Date ngayLapHD, boolean uuDai, Sach tenSach, KhachHang khachHang, Double tongTien) {
		super();
		this.maHD = maHD;
		this.nguoiLapHD = nguoiLapHD;
		this.ngayLapHD = ngayLapHD;
		this.uuDai = uuDai;
		this.tenSach = tenSach;
		this.khachHang=khachHang;
		this.tongTien = tongTien;
	}
	
	public HoaDon(String maHD, boolean uuDai) {
		super();
		this.maHD = maHD;
		this.uuDai = uuDai;
	}
	
	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public HoaDon(Double sum)
	{
		super();
		this.sum=sum;
	}
	public HoaDon(String maHD) {
		this(maHD, true);
	}
	
	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public HoaDon(int soHoaDon)
	{
		super();
		this.soHoaDon=soHoaDon;
	}
	public int getSoHoaDon() {
		return soHoaDon;
	}

	public void setSoHoaDon(int soHoaDon) {
		this.soHoaDon = soHoaDon;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public NhanVien getNguoiLapHD() {
		return nguoiLapHD;
	}
	public void setNguoiLapHD(NhanVien nguoiLapHD) {
		this.nguoiLapHD = nguoiLapHD;
	}
	
	public Date getNgayLapHD() {
		return ngayLapHD;
	}

	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}

	public boolean isUuDai() {
		return uuDai;
	}
	public void setUuDai(boolean uuDai) {
		this.uuDai = uuDai;
	}
	public Sach getTenSach() {
		return tenSach;
	}
	public void setTenSach(Sach tenSach) {
		this.tenSach = tenSach;
	}

	public Double getTongTien() {
		return tongTien;
	}

	public void setTongTien(Double tongTien) {
		this.tongTien = tongTien;
	}
	
	
	
	

	
	
}
