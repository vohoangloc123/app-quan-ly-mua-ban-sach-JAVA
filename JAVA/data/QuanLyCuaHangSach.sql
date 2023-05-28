create database QuanLyCuaHangSach
go
use QuanLyCuaHangSach
go
CREATE TABLE NhaXuatBan (
	maNXB NVARCHAR(8) NOT NULL  PRIMARY KEY,
	tenNXB NVARCHAR(50),
);
CREATE TABLE LoaiSach (
	maLoaiSach NVARCHAR(8)  NOT NULL  PRIMARY KEY,
	tenLoaiSach NVARCHAR(50)
);
CREATE TABLE Sach (
    maSach NVARCHAR(8) NOT NULL PRIMARY KEY,
	tenSach NVARCHAR(50),
	namXuatBan Date,
	donGia float,
	ngonNgu NVARCHAR(50),
	tacGia NVARCHAR(50),
	maNXB NVARCHAR(8),
	maLoaiSach NVARCHAR(8),
	trangThai bit,
	urlAnh NVARCHAR(200),
	FOREIGN KEY (maNXB) REFERENCES NhaXuatBan(maNXB),
	FOREIGN KEY (maLoaiSach) REFERENCES LoaiSach(maLoaiSach)
);
CREATE TABLE LoaiNhanVien(
	maLoaiNV NVARCHAR(4) NOT NULL PRIMARY KEY,
	chucVu NVARCHAR(50)
)
CREATE TABLE NhanVien(
	maNV NVARCHAR(4) NOT NULL  PRIMARY KEY,
	tenNV NVARCHAR(50),
	maLoaiNV NVARCHAR(4),
	CCCD NVARCHAR(12),
	SDT NVARCHAR(10),
	ngaySinh date,
	ngayVaoLam date,
	diaChi NVARCHAR(100),
	email NVARCHAR(50),
	gioiTinh bit,
	matKhau NVARCHAR(8),
	trangThai bit,
	urlAnhNV NVARCHAR(200),
	FOREIGN KEY (maLoaiNV) REFERENCES LoaiNhanVien(maLoaiNV),
);
CREATE TABLE LoaiKhachHang(
	maLoaiKH NVARCHAR(4) NOT NULL PRIMARY KEY,
	tenLoaiKH NVARCHAR(50)
)
CREATE TABLE KhachHang(
	maKH NVARCHAR(10) NOT NULL  PRIMARY KEY,
	tenKH NVARCHAR(50),
	SDT NVARCHAR(10),
	email NVARCHAR(50),
	maLoaiKH NVARCHAR(4),
	gioiTinh bit,
	diaChi NVARCHAR(100),
	FOREIGN KEY (maLoaiKH) REFERENCES LoaiKhachHang(maLoaiKH)
);
CREATE TABLE HoaDon (
	maHoaDon NVARCHAR(8) NOT NULL  PRIMARY KEY,
	maNV NVARCHAR(4),
	ngayLapHoaDon date,
	uuDai bit,
	maSach NVARCHAR(8),
	maKH NVARCHAR(10),
	tongTien float,
	trangThai bit null,
	FOREIGN KEY (maSach) REFERENCES Sach(maSach),
	FOREIGN KEY (maNV) REFERENCES NhanVien(maNV),
	FOREIGN KEY (maKH) REFERENCES KhachHang(maKH)
	ON DELETE CASCADE ON UPDATE CASCADE 
);
CREATE TABLE maHD(

id int NOT NULL PRIMARY KEY,

name VARCHAR(255) NOT NULL,

price int ,



);
CREATE TABLE QuanLy(
	tenTK NVARCHAR(10),
	matKhau NVARCHAR(10),
	tenQuanLy NVARCHAR(50)
)
insert into QuanLy(tenTK, matKhau, tenQuanLy)
values('QL01', '123',N'Võ Hoàng Lộc')
insert into LoaiKhachHang(maLoaiKH, tenLoaiKH)
values('LKH1', N'Thường');
insert into LoaiKhachHang(maLoaiKH, tenLoaiKH)
values('LKH2', N'Thành viên');
----------------------------------------------------------------------------------------------------------------------------

insert into KhachHang(maKH, tenKH, SDT, email, maLoaiKH, gioiTinh, diaChi)
values ('0942410127', N'Phùng Khánh Linh', '0942410127', 'phungkhanhlinh@gmail.com', 'LKH1', 0, N'Bến Tre');
insert into KhachHang(maKH, tenKH, SDT, email, maLoaiKH, gioiTinh, diaChi)
values ('0842220128', N'Bùi Xuân Dũng', '0842220128', 'buixuandung@gmail.com', 'LKH1', 1, N'TP Hồ Chí Minh');
insert into KhachHang(maKH, tenKH, SDT, email, maLoaiKH, gioiTinh, diaChi)
values ('0942414125', N'Nguyễn Thanh Trúc', '0942414125', 'nguyenthanhtruc@gmail.com', 'LKH1', 0, N'Đồng Nai');
insert into KhachHang(maKH, tenKH, SDT, email, maLoaiKH, gioiTinh, diaChi)
values ('0932310124', N'Phạm Phi Hùng', '0932310124', 'phamphihung@gmail.com', 'LKH2', 1, N'Hà Nội');
insert into KhachHang(maKH, tenKH, SDT, email, maLoaiKH, gioiTinh, diaChi)
values ('0948412122', N'Phan Minh Khoa', '0948412122', 'phanminhkhoa@gmail.com', 'LKH2', 1, N'Vũng Tàu');
insert into KhachHang(maKH, tenKH, SDT, email, maLoaiKH, gioiTinh, diaChi)
values ('0948434212', N'Trần Thanh Hoa', '0948434212', 'tranthanhhoa@gmail.com', 'LKH2', 1, N'Đồng Tháp');
insert into KhachHang(maKH, tenKH, SDT, email, maLoaiKH, gioiTinh, diaChi)
values ('0925234212', N'Nguyễn Thị Bích', '0925234212', 'nguyenthibich@gmail.com', 'LKH1', 0, N'Kiên Giang');
insert into KhachHang(maKH, tenKH, SDT, email, maLoaiKH, gioiTinh, diaChi)
values ('0923521212', N'Võ Minh Sang', '0923521212', 'vominhsang@gmail.com', 'LKH1', 0, N'Bình Dương');
insert into KhachHang(maKH, tenKH, SDT, email, maLoaiKH, gioiTinh, diaChi)
values ('0925731612', N'Trương Thảo Nhi', '0925731612', 'truongthaonhi@gmail.com', 'LKH2', 0, N'Cần Thơ');
insert into KhachHang(maKH, tenKH, SDT, email, maLoaiKH, gioiTinh, diaChi)
values ('0925541612', N'Nguyễn Quốc Việt', '0925541612', 'nguyenquocviet@gmail.com', 'LKH2', 1, N'TP Hồ Chí Minh');
insert into KhachHang(maKH, tenKH, SDT, email, maLoaiKH, gioiTinh, diaChi)
values ('0952511612', N'Trần Linh Chi', '0952511612', 'tranlinhchi@gmail.com', 'LKH2', 0, N'TP Hồ Chí Minh');
insert into KhachHang(maKH, tenKH, SDT, email, maLoaiKH, gioiTinh, diaChi)
values ('0956251612', N'Võ Thanh Thúy', '0956251612', 'vothanhthuy@gmail.com', 'LKH1', 0, N'TP Hồ Chí Minh');
insert into KhachHang(maKH, tenKH, SDT, email, maLoaiKH, gioiTinh, diaChi)
values ('0956235215', N'Lê Khánh Châu', '0956235215', 'lekhanhchau@gmail.com', 'LKH1', 0, N'TP Hồ Chí Minh');
insert into KhachHang(maKH, tenKH, SDT, email, maLoaiKH, gioiTinh, diaChi)
values ('0952612515', N'Võ Thục Trinh', '0952612515', 'vothuctrinh@gmail.com', 'LKH2', 0, N'TP Hồ Chí Minh');
insert into KhachHang(maKH, tenKH, SDT, email, maLoaiKH, gioiTinh, diaChi)
values ('0952652515', N'Cao Anh Minh', '0952652515', 'caoanhminh@gmail.com', 'LKH2', 1, N'Hà Nội');
----------------------------------------------------------------------------------------------------------------------------
insert into LoaiNhanVien(maLoaiNV,  chucVu)
values ('LNV1', N'Nhân viên bán hàng');

insert into LoaiNhanVien(maLoaiNV,  chucVu)
values ('LNV2', N'Nhân viên kiểm sách');

insert into LoaiNhanVien(maLoaiNV,  chucVu)
values ('LNV3', N'Nhân viên an ninh');
----------------------------------------------------------------------------------------------------------------------------
insert into NhanVien(maNV, tenNV, maLoaiNV, CCCD, SDT, ngaySinh, ngayVaoLam, diaChi, email, gioiTinh, matKhau, trangThai, urlAnhNV)
values ('NV01', N'Võ Hoàng Lộc', 'LNV1', '083202010261', '0362711649', '2002-01-21', '2022-02-01', 'TP HCM', 'vohoangloc@gmail.com', 1, '123',1, null);

insert into NhanVien(maNV, tenNV, maLoaiNV, CCCD, SDT, ngaySinh, ngayVaoLam, diaChi, email, gioiTinh, matKhau, trangThai, urlAnhNV)
values ('NV02', N'Đỗ Hoàng Nhật Nguyên', 'LNV1', '083202525255', '0962711649', '2002-02-28', '2022-02-01', 'TP HCM', 'dohoangnhatnguyen@gmail.com', 1, '124',1, null);

insert into NhanVien(maNV, tenNV, maLoaiNV, CCCD, SDT, ngaySinh, ngayVaoLam, diaChi, email, gioiTinh, matKhau, trangThai, urlAnhNV)
values ('NV03', N'Lê Bảo Phúc', 'LNV1', '083202010261', '0722711649', '2002-03-18', '2022-02-01', 'TP HCM', 'lebaophuc@gmail.com', 1, '125',1, null);

insert into NhanVien(maNV, tenNV, maLoaiNV, CCCD, SDT, ngaySinh, ngayVaoLam, diaChi, email, gioiTinh, matKhau, trangThai, urlAnhNV)
values ('NV04', N'Lê Sơn Hải', 'LNV1', '083202010261', '0962711649', '2002-04-18', '2022-02-01', 'TP HCM', 'lesohai@gmail.com', 1, '126',1, null);


----------------------------------------------------------------------------------------------------------------------------
insert into NhaXuatBan(maNXB, tenNXB)
values ('NXB00001', N'Kim Đồng');

insert into NhaXuatBan(maNXB, tenNXB)
values ('NXB00002', N'Chính trị quốc gia');

insert into NhaXuatBan(maNXB, tenNXB)
values ('NXB00003', N'Báo thành niên');

insert into NhaXuatBan(maNXB, tenNXB)
values ('NXB00004', N'Lao động');

insert into NhaXuatBan(maNXB, tenNXB)
values ('NXB00005', N'Phụ nữ');

insert into NhaXuatBan(maNXB, tenNXB)
values ('NXB00006', N'Thế giới');

insert into NhaXuatBan(maNXB, tenNXB)
values ('NXB00007', N'Bách Khoa Hà Nội');

insert into NhaXuatBan(maNXB, tenNXB)
values ('NXB00008', N'Giáo dục Việt Nam');

insert into NhaXuatBan(maNXB, tenNXB)
values ('NXB00009', N'Hội nhà văn');
----------------------------------------------------------------------------------------------------------------------------
insert into LoaiSach(maLoaiSach, tenLoaiSach)
values ('LS000001', N'Giáo khoa');
insert into LoaiSach(maLoaiSach, tenLoaiSach)
values ('LS000002', N'Truyện tranh');
insert into LoaiSach(maLoaiSach, tenLoaiSach)
values ('LS000003', N'Khoa học');
insert into LoaiSach(maLoaiSach, tenLoaiSach)
values ('LS000004', N'Self care');
insert into LoaiSach(maLoaiSach, tenLoaiSach)
values ('LS000005', N'Tâm lý học');
insert into LoaiSach(maLoaiSach, tenLoaiSach)
values ('LS000006', N'Công nghệ');
insert into LoaiSach(maLoaiSach, tenLoaiSach)
values ('LS000007', N'Tạp chí');
insert into LoaiSach(maLoaiSach, tenLoaiSach)
values ('LS000008', N'Thiếu nhi');
----------------------------------------------------------------------------------------------------------------------------
insert into Sach(maSach, tenSach, namXuatBan,  donGia, ngonNgu, tacGia, maNXB,  maLoaiSach, trangThai, urlAnh)
values ('MS000001', N'Một cuốn sách về chủ nghĩa tối giản', '2008-12-02', 12000, N'Việt Nam',N'Chi Nguyen', 'NXB00001', 'LS000004',1, null);

insert into Sach(maSach, tenSach, namXuatBan,  donGia, ngonNgu, tacGia, maNXB,  maLoaiSach, trangThai, urlAnh)
values ('MS000002', N'Đắc nhân tâm', '2019-12-02', 65000, N'Việt Nam', N'Dale Carnegie', 'NXB00006', 'LS000004',1, null);

insert into Sach(maSach, tenSach, namXuatBan,  donGia, ngonNgu, tacGia, maNXB,  maLoaiSach,trangThai, urlAnh)
values ('MS000003', N'Doraemon', '2019-12-02', 30000, N'Việt Nam', N'Fujiko Fujio', 'NXB00001', 'LS000002',1, null);

insert into Sach(maSach, tenSach, namXuatBan,  donGia, ngonNgu, tacGia, maNXB,  maLoaiSach,trangThai, urlAnh)
values ('MS000004', N'Conan', '2019-12-02', 20000, N'Việt Nam', N'Gosho Aoyama', 'NXB00001', 'LS000002',1, null);

insert into Sach(maSach, tenSach, namXuatBan,  donGia, ngonNgu, tacGia, maNXB,  maLoaiSach,trangThai, urlAnh)
values ('MS000005', N'EST toeic', '2022-01-01', 19000, N'Việt Nam', N'Eiichiro Oda', 'NXB00001', 'LS000001',0, null);

insert into Sach(maSach, tenSach, namXuatBan,  donGia, ngonNgu, tacGia, maNXB,  maLoaiSach,trangThai, urlAnh)
values ('MS000006', N'Lịch sử đảng', '2022-01-01', 100000, N'Việt Nam', N'Bộ giáo dục và đào tạo', 'NXB00002', 'LS000001',0, null);

insert into Sach(maSach, tenSach, namXuatBan,  donGia, ngonNgu, tacGia, maNXB,  maLoaiSach,trangThai, urlAnh)
values ('MS000007', N'Kinh tế chính trị', '2022-01-01', 100000, N'Việt Nam', N'Bộ giáo dục và đào tạo', 'NXB00002', 'LS000001',0, null);

insert into Sach(maSach, tenSach, namXuatBan,  donGia, ngonNgu, tacGia, maNXB,  maLoaiSach,trangThai, urlAnh)
values ('MS000008', N'Triết học Mác-Lênin', '2022-01-01', 100000, N'Việt Nam', N'Bộ giáo dục và đào tạo', 'NXB00002', 'LS000001',1, null);

insert into Sach(maSach, tenSach, namXuatBan,  donGia, ngonNgu, tacGia, maNXB,  maLoaiSach,trangThai, urlAnh)
values ('MS000009', N'Cấu trúc dữ và giải thuật', '2022-01-01', 90000, N'Việt Nam', N'Nguyễn Đức Nghĩa', 'NXB00007', 'LS000006',1, null);

insert into Sach(maSach, tenSach, namXuatBan,  donGia, ngonNgu, tacGia, maNXB,  maLoaiSach,trangThai, urlAnh)
values ('MS000010', N'Ngữ văn 12', '2022-01-01', 13000, N'Việt Nam', N'Bộ giáo dục và đào tạo', 'NXB00008', 'LS000001',1, null);

insert into Sach(maSach, tenSach, namXuatBan,  donGia, ngonNgu, tacGia, maNXB,  maLoaiSach,trangThai, urlAnh)
values ('MS000011', N'Sự im lặng của bày cừu', '2022-01-01', 105000, N'Việt Nam', N'Thomas Harris', 'NXB00009', 'LS000002',1, null);
----------------------------------------------------------------------------------------------------------------------------
insert into HoaDon(maHoaDon, ngayLapHoaDon, maNV, uuDai, maSach, tongTien)
values ('77', '2022-11-01',  'NV01', '0', 'MS000001', '100000');

insert into HoaDon(maHoaDon, ngayLapHoaDon, maNV, uuDai, maSach, tongTien)
values ('88', '2022-11-02',  'NV01', '0', 'MS000001', '100000');

insert into HoaDon(maHoaDon, ngayLapHoaDon, maNV, uuDai, maSach, tongTien)
values ('67', '2022-11-04',  'NV02', '0', 'MS000001', '400000');

insert into HoaDon(maHoaDon, ngayLapHoaDon, maNV, uuDai, maSach, tongTien)
values ('65', '2022-11-05',  'NV01', '0', 'MS000003', '500000');

insert into HoaDon(maHoaDon, ngayLapHoaDon, maNV, uuDai, maSach, tongTien)
values ('55', '2022-11-06',  'NV01', '0', 'MS000002', '100000');

insert into HoaDon(maHoaDon, ngayLapHoaDon, maNV, uuDai, maSach, tongTien)
values ('22', '2022-11-07',  'NV03', '0', 'MS000005', '300000');

insert into HoaDon(maHoaDon, ngayLapHoaDon, maNV, uuDai, maSach, tongTien)
values ('33', '2022-11-08',  'NV02','0', 'MS000006', '800000');

insert into HoaDon(maHoaDon, ngayLapHoaDon, maNV, uuDai, maSach, tongTien)
values ('43', '2022-10-08',  'NV02', '0', 'MS000006', '800000');

insert into HoaDon(maHoaDon, ngayLapHoaDon, maNV, uuDai, maSach, tongTien)
values ('44', '2022-11-29',  'NV02', '0', 'MS000006', '800000');

insert into HoaDon(maHoaDon, ngayLapHoaDon, maNV, uuDai, maSach, tongTien)
values ('111', '2022-11-29',  'NV02', '0', 'MS000006', '800000');
---------------------------------------------------------------------------------------------------------------------------
select* from KhachHang