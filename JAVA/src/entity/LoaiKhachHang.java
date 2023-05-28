package entity;

public class LoaiKhachHang {
	private String maLoaiKH;
	private String tenLoaiKH;
	
	public LoaiKhachHang(String maLoaiKH, String tenLoaiKH) {
		super();
		this.maLoaiKH = maLoaiKH;
		this.tenLoaiKH = tenLoaiKH;
	}

	public LoaiKhachHang() {
		super();
	}
	public LoaiKhachHang(String maLoaiKH) {
		this(maLoaiKH,"");
	}

	public String getMaLoaiKH() {
		return maLoaiKH;
	}

	public void setMaLoaiKH(String maLoaiKH) {
		this.maLoaiKH = maLoaiKH;
	}

	public String getTenLoaiKH() {
		return tenLoaiKH;
	}

	public void setTenLoaiKH(String tenLoaiKH) {
		this.tenLoaiKH = tenLoaiKH;
	}
	
}
