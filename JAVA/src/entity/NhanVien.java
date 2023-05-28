package entity;

import java.sql.Date;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private LoaiNhanVien loaiNV;
	private String CCCD;
	private String SDT;
	private Date ngaySinh;
	private Date ngayVaoLam;
	private String diaChi;
	private String email;
	private boolean gioiTinh;
	private String matKhau;
	private boolean trangThai;
	private String urlAnhNV;
	
	public NhanVien(String maNV, String tenNV, LoaiNhanVien loaiNV, String cCCD, String sDT, Date ngaySinh,
			Date ngayVaoLam, String diaChi, String email, boolean gioiTinh, String matKhau, boolean trangThai, String urlAnhNV) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.loaiNV = loaiNV;
		CCCD = cCCD;
		SDT = sDT;
		this.ngaySinh = ngaySinh;
		this.ngayVaoLam = ngayVaoLam;
		this.diaChi = diaChi;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.matKhau = matKhau;
		this.trangThai=trangThai;
		this.urlAnhNV=urlAnhNV;
	}

	public NhanVien(String maNV, String tenNV, String urlAnhNV) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.urlAnhNV=urlAnhNV;
	}
	public NhanVien(String maNV, boolean trangThai) {
		super();
		this.maNV = maNV;
		this.trangThai=trangThai;
	}
	public NhanVien(String matKhau, String maNV) {
		super();
		this.matKhau=matKhau;
		this.maNV = maNV;
	}
	
	
	public NhanVien() {
		super();
	}
	public NhanVien(String maNV) {
		this(maNV, "", "");
	}
	

	
	public String getUrlAnhNV() {
		return urlAnhNV;
	}

	public void setUrlAnhNV(String urlAnhNV) {
		this.urlAnhNV = urlAnhNV;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public LoaiNhanVien getLoaiNV() {
		return loaiNV;
	}

	public void setLoaiNV(LoaiNhanVien loaiNV) {
		this.loaiNV = loaiNV;
	}

	public String getCCCD() {
		return CCCD;
	}

	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	
		
		
}
