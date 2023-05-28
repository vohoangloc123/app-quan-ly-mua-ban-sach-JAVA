package entity;

public class KhachHang {
		private String maKH;
		private String tenKH;
		private String SDT;
		private String email;
		private LoaiKhachHang loaiKH;
		private boolean gioiTinh;
		private String diaChi;
		
		public KhachHang(String maKH, String tenKH, String sDT, String email, LoaiKhachHang khachHang, boolean gioiTinh,
				String diaChi) {
			super();
			this.maKH = maKH;
			this.tenKH = tenKH;
			SDT = sDT;
			this.email = email;
			this.loaiKH = khachHang;
			this.gioiTinh = gioiTinh;
			this.diaChi = diaChi;
		}
		
		public KhachHang() {
			super();
		}
		public KhachHang(String maKH, String tenKH)
		{
			super();
		}
		public KhachHang(String maKH)
		{
			this.maKH=maKH;
		}
		public String getMaKH() {
			return maKH;
		}
		public void setMaKH(String maKH) {
			this.maKH = maKH;
		}
		public String getTenKH() {
			return tenKH;
		}
		public void setTenKH(String tenKH) {
			this.tenKH = tenKH;
		}
		public String getSDT() {
			return SDT;
		}
		public void setSDT(String sDT) {
			SDT = sDT;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public LoaiKhachHang getLoaiKhachHang() {
			return loaiKH;
		}
		public void setLoaiKhachHang(LoaiKhachHang khachHang) {
			this.loaiKH = khachHang;
		}
		public boolean isGioiTinh() {
			return gioiTinh;
		}
		public void setGioiTinh(boolean gioiTinh) {
			this.gioiTinh = gioiTinh;
		}
		public String getDiaChi() {
			return diaChi;
		}
		public void setDiaChi(String diaChi) {
			this.diaChi = diaChi;
		}
		
}
