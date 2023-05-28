package entity;

public class LoaiSach {
		private String maLoaiSach;
		private String tenLoaiSach;
		public LoaiSach(String maLoaiSach, String tenLoaiSach) {
			super();
			this.maLoaiSach = maLoaiSach;
			this.tenLoaiSach = tenLoaiSach;
		}
		public LoaiSach() {
			super();
		}
		public LoaiSach(String maLoaiSach) {
			this(maLoaiSach, "");
		}
		public String getMaLoaiSach() {
			return maLoaiSach;
		}
		public void setMaLoaiSach(String maLoaiSach) {
			this.maLoaiSach = maLoaiSach;
		}
		public String getTenLoaiSach() {
			return tenLoaiSach;
		}
		public void setTenLoaiSach(String tenLoaiSach) {
			this.tenLoaiSach = tenLoaiSach;
		}
		
}
