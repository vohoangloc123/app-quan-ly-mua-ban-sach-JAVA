package entity;

public class LoaiNhanVien {
	private String maLoaiNV;
	private String chucVu;
	
	public LoaiNhanVien(String maLoaiNV, String chucVu) {
		super();
		this.maLoaiNV = maLoaiNV;
		this.chucVu = chucVu;
	}
	
	public LoaiNhanVien() {
		super();
	}
	public LoaiNhanVien(String maLoaiNV) {
		this(maLoaiNV,"");
	}
	public String getMaLoaiNV() {
		return maLoaiNV;
	}
	public void setMaLoaiNV(String maLoaiNV) {
		this.maLoaiNV = maLoaiNV;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	
}
