package entity;

public class QuanLy {
	private String tenTK;
	private String matKhau;
	private String tenQuanLy;
	public QuanLy(String tenTK, String matKhau, String tenQuanLy) {
		super();
		this.tenTK = tenTK;
		this.matKhau = matKhau;
		this.tenQuanLy = tenQuanLy;
	}
	public QuanLy(String tenTK, String matKhau) {
		super();
		this.tenTK = tenTK;
		this.matKhau = matKhau;
	}
	public QuanLy(String tenTK)
	{
		this(tenTK,"");
	}
	public String getTenTK() {
		return tenTK;
	}
	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getTenQuanLy() {
		return tenQuanLy;
	}
	public void setTenQuanLy(String tenQuanLy) {
		this.tenQuanLy = tenQuanLy;
	}
	
}
