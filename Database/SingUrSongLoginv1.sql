CREATE DATABASE SingUrSong_Test

GO
use SingUrSong_Test
GO


CREATE TABLE LoaiPhong(
	maLoaiPhong			nchar(16) primary key,
	tenLoaiPhong		nvarchar(40),
	soLuongKhachToiDa	int,
	giaTien				money,
	hinhAnh				image null,
	moTa				nvarchar(40) null,
);

CREATE TABLE TrangThaiPhong(
	maTrangThai		nchar(16) primary key,
	tenTrangThai	nvarchar(40)  NULL,
);

CREATE TABLE Phong(
	maPhong				nchar(16) primary key,
	tenPhong			nvarchar(40),
	maLoaiPhong			nchar(16),
	maTrangThai			nchar(16),
	ngayTaoPhong		date,
	viTriPhong			nchar(8),
	ghiChu				nvarchar(40) null,
	tinhTrangPhong		nvarchar(40)
);

CREATE TABLE LoaiNhanVien(
	maLoaiNhanVien	nchar(16) primary key,
	tenLoaiNhanVien nvarchar(40),
);

CREATE TABLE NhanVien(
	maNhanVien		nchar(16) primary key,
	maLoaiNhanVien	nchar(16),
	hoTen			nvarchar(40),
	gioiTinh		bit,
	ngaySinh		date,
	soDienThoai		nvarchar(10),
	CCCD			nvarchar(12),
	diaChi			nvarchar(40),
	trangThai		nvarchar(40),
	anhThe			image null,
);

CREATE TABLE TaiKhoan(
	maNhanVien  nchar(16) primary key,
	tenDangNhap nchar(10),
	matKhau		nvarchar(40) not null,
	trangThai	bit not null
);

CREATE TABLE KhachHang(
	maKhachHang	nchar(16) primary key,
	hoTen		nvarchar(40),
	gioiTinh	bit,
	ngaySinh	date,
	diaChi		nvarchar(40),
	soDienThoai	nvarchar(10),
	diemThuong	int,
	ghiChu		nvarchar(40) null,
);

CREATE TABLE PhieuDatPhong(
	maPhieuDat			nchar(16) primary key,
	maPhong				nchar(16),
	maNhanVien			nchar(16),
	maKhachHang			nchar(16),
	thoiGianDatPhong	datetime,
	thoiGianNhanPhong	datetime,
	tienCoc				money,
	trangThai			nvarchar(40) null,
	moTa				nvarchar(40) null,
);

CREATE TABLE KhuyenMai(
	maKhuyenMai		nchar(16) primary key,
	tenKhuyenMai	nvarchar(40),
	maGiamGia 		nvarchar(16),
	ngayBatDau		datetime,
	ngayKetThuc		datetime,
	tongSoLuong		int,
	chieuKhau		float,
	moTa			nvarchar(40) null
);

CREATE TABLE DichVu(
	maDichVu	nchar(16) primary key,
	tenDichVu	nvarchar(40),
	soLuong		int,
	donViTinh	nvarchar(12),
	donGia		money,
	trangThai	nvarchar(40),
);

CREATE TABLE HoaDon(
	maHoaDon		nchar(16) primary key,
	maKhachHang		nchar(16),
	maNhanVien		nchar(16),
	maPhieuDat		nchar(16),
	maKhuyenMai		nchar(16),
	ngayLap			datetime,
	trangThai		nvarchar(40),
	thoiGianKetThuc	datetime
);

CREATE TABLE ThongTinDichVu(
	maThongTinDichVu	nchar(16) primary key,
	maDichVu			nchar(16),
	soLuong				int,
	soLuongDaSuDung		int,
	ngayNhap			datetime,
	ngayHetHan			datetime,
	moTa				nvarchar(40),
	hinhAnh				image null
);

CREATE TABLE ChiTietDichVu(
	maHoaDon		nchar(16),
	maDichVu		nchar(16),
	soLuong			int,
	primary key (maHoaDon, maDichVu)
);

CREATE TABLE ChiTietHoaDon(
	maHoaDon		nchar(16),
	maPhong			nchar(16),
	soGioHat		float,
	primary key (maHoaDon, maPhong)
);

ALTER Table TaiKhoan
ADD Constraint F_TaiKhoan_NhanVien Foreign key(maNhanVien) references NhanVien(maNhanVien)

ALTER Table Phong 
ADD Constraint F_Phong_LoaiPhong Foreign key(maLoaiPhong) references LoaiPhong(maLoaiPhong),
	Constraint F_Phong_TrangThaiPhong Foreign key(maTrangThai) references TrangThaiPhong(maTrangThai)

ALTER Table NhanVien
ADD Constraint F_NhanVien_LoaiNhanVien Foreign key(maLoaiNhanVien) references LoaiNhanVien(maLoaiNhanVien)

ALTER Table PhieuDatPhong
ADD Constraint F_PhieuDatPhong_Phong Foreign key(maPhong) references Phong(maPhong),
	Constraint F_PhieuDatPhong_NhanVien Foreign key(maNhanVien) references NhanVien(maNhanVien),
	Constraint F_PhieuDatPhong_KhachHang Foreign key(maKhachHang) references KhachHang(maKhachHang)

ALTER Table  HoaDon
ADD Constraint F_HoaDon_KhachHang Foreign key(maKhachHang) references KhachHang(maKhachHang),
	Constraint F_HoaDon_NhanVien Foreign key(maNhanVien) references NhanVien(maNhanVien),
	Constraint F_HoaDon_PhieuDat Foreign key(maPhieuDat) references PhieuDatPhong(maPhieuDat),
	Constraint F_HoaDon_KhuyenMai Foreign key(maKhuyenMai) references KhuyenMai(maKhuyenMai)

ALTER Table ThongTinDichVu
ADD Constraint F_ThongTinDichVu_KhachHang Foreign key(maDichVu) references DichVu(maDichVu)

ALTER Table ChiTietDichVu
ADD Constraint F_ChiTietDichVu_HoaDon Foreign key(maHoaDon) references HoaDon(maHoaDon),
	Constraint F_ChiTietDichVu_DichVu Foreign key(maDichVu) references DichVu(maDichVu)

ALTER Table ChiTietHoaDon
ADD Constraint F_ChiTietHoaDon_HoaDon Foreign key(maHoaDon) references HoaDon(maHoaDon),
	Constraint F_ChiTietHoaDon_Phong Foreign key(maPhong) references Phong(maPhong)

--use master
--drop database SingUrSong

INSERT INTO LoaiNhanVien
VALUES	('LNV000', 'QuanLy'),
		('LNV001', 'ThuNgan')

INSERT INTO LoaiPhong
VALUES ('ORD1', 'Phòng thường 5 người', 6, 20000, 'Nothing', 'Nothing'),
		('ORD2', 'Phòng thường 12 người', 12, 40000, 'Nothing', 'Nothing')

INSERT INTO TrangThaiPhong
VALUES ('VC', 'Trống'),
		('OCP', 'Đã đặt')

INSERT INTO NhanVien
VALUES	('78203123843', 'LNV000', 'Cao Trương Thanh', 1, '2003-01-01', '0340424651', '214568669', 'Thủ Đức, Hồ Chí Minh', 'Đang làm', 'Nothing'),
		('78203123844', 'LNV001', 'Trương Trung Trực', 1, '2004-01-01', '0346444436', '214568669', 'Gò Vấp, Hồ Chí Minh', 'Nghỉ Làm', 'Nothing')

INSERT INTO TaiKhoan
VALUES ('78203123843', '21115231', '123456', 1),
		('78203123844', '21155233', '123456', 0)

INSERT INTO Phong
VALUES ('P101', 'Phòng Thường Lầu 1', 'ORD1', 'VC', '2023-01-01', 'Lầu 1', 'Nothing', 'Sạch sẽ'),
		('P201', 'Phòng Thường Lầu 2', 'ORD1', 'OCP', '2023-02-01', 'Lầu 2', 'Nothing', 'Đang dọn')

INSERT INTO KhachHang
VALUES ('7820312319843', 'Phan Thanh Lưu', 1, '2003-01-03', 'Thủ Đức, Hồ Chí Minh', '0346444436', 1000, 'Nothing'),
		('7820312319844', 'Do Tuan Tai', 0, '2004-02-03', 'Gò Vấp, Hồ Chí Minh', '0346444436', 1000, 'Nothing')

INSERT INTO KhuyenMai
VALUES ('10122023001', 'Giảm giá 20/10', 'GIAMGIA2010', '2023-10-22', '2023-11-22', 100, 10, 'Nothing'),
		('10122023002', 'Giảm giá 21/11', 'GIAMGIA2111', '2023-11-20', '2023-11-22', 50, 10, 'Nothing')

INSERT INTO PhieuDatPhong
VALUES ('PD12102023A001', 'P101', '78203123843', '7820312319843', '2023-10-22', '2023-11-20', 1000, 'Đã đặt', 'Nothing'),
		('PD12102023A002', 'P201', '78203123844', '7820312319844', '2023-10-22', '2023-11-20', 1000, 'Đã thanh toán', 'Nothing')

INSERT INTO DichVu
VALUES ('121020230001' , 'Pepsi', 10, 'Lon', 20000, 'Còn hàng'),
		('121020230002' , 'Trà Chanh', 10, 'Lon', 20000, 'Hết hàng')

INSERT INTO ThongTinDichVu
VALUES ('121020230001', '121020230001', 10, 9, '2023-10-22', '2023-10-23', 'Nothing', 'Nothing'),
		('121020230002', '121020230002', 10, 9, '2023-10-22', '2023-10-23', 'Nothing', 'Nothing')


INSERT INTO HoaDon
VALUES ('HD12102023A001', '7820312319843', '78203123843', 'PD12102023A001', '10122023001', '2023-10-23', 'Đang đợi thanh toán', '2023-10-23'),
		('HD12102023A002', '7820312319844', '78203123844', 'PD12102023A002', '10122023002', '2023-10-23', 'Đã thanh toán', '2023-10-23')

INSERT INTO ChiTietDichVu
VALUES ('HD12102023A001', '121020230001', 10)

INSERT INTO ChiTietHoaDon
Values ('HD12102023A001', 'P101', 4)

select * from ChiTietDichVu 
select * from ChiTietHoaDon 
select * from KhachHang
select * from HoaDon 
select * from DichVu 
select * from KhuyenMai 
select * from LoaiNhanVien 
select * from LoaiPhong 
select * from NhanVien 
select * from PhieuDatPhong 
select * from Phong 
select * from TaiKhoan
select * from ThongTinDichVu
select * from TrangThaiPhong 