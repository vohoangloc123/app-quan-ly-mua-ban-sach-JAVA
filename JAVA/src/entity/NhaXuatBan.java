package entity;

public class NhaXuatBan {
	private String maNXB;
	private String tenNXB;
		public NhaXuatBan(String maNXB, String tenNXB) {
			super();
			this.maNXB = maNXB;
			this.tenNXB = tenNXB;
		}
		public NhaXuatBan() {
			super();
		}
		public NhaXuatBan(String maNXB) {
			this(maNXB,"");
		}
		public String getMaNXB() {
			return maNXB;
		}
		public void setMaNXB(String maNXB) {
			this.maNXB = maNXB;
		}
		public String getTenNXB() {
			return tenNXB;
		}
		public void setTenNXB(String tenNXB) {
			this.tenNXB = tenNXB;
		}
		
}
