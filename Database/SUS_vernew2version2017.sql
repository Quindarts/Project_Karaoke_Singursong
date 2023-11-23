USE [master]
GO
/****** Object:  Database [SingUrSong_vnew]    Script Date: 11/22/2023 11:41:36 PM ******/
CREATE DATABASE [SingUrSong_vnew]
GO
use SingUrSong_vnew
GO
CREATE TABLE [dbo].[ChiTietDichVu](
	[maHoaDon] [nchar](15) NOT NULL,
	[maDichVu] [nchar](15) NOT NULL,
	[soLuong] [int] NULL,
	[maPhong] [varchar](16) NULL,
PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC,
	[maDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 11/22/2023 11:41:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maHoaDon] [nchar](15) NOT NULL,
	[maPhong] [nchar](16) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC,
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhieuDatPhong]    Script Date: 11/22/2023 11:41:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuDatPhong](
	[maPhieuDat] [nchar](15) NOT NULL,
	[maPhong] [nchar](16) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhieuDat] ASC,
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 11/22/2023 11:41:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[maDichVu] [nchar](15) NOT NULL,
	[tenDichVu] [nvarchar](40) NULL,
	[donViTinh] [nvarchar](12) NULL,
	[donGia] [float] NULL,
	[trangThai] [bit] NULL,
	[maThongTinDichVu] [varchar](16) NULL,
PRIMARY KEY CLUSTERED 
(
	[maDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/22/2023 11:41:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [nchar](15) NOT NULL,
	[maKhachHang] [nchar](16) NULL,
	[maNhanVien] [nchar](16) NULL,
	[maPhieuDat] [nchar](15) NULL,
	[maKhuyenMai] [nchar](16) NULL,
	[ngayLap] [datetime] NULL,
	[trangThai] [nvarchar](40) NULL,
	[thoiGianKetThuc] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/22/2023 11:41:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [nchar](16) NOT NULL,
	[hoTen] [nvarchar](40) NULL,
	[gioiTinh] [bit] NULL,
	[ngaySinh] [date] NULL,
	[diaChi] [nvarchar](40) NULL,
	[soDienThoai] [nvarchar](10) NULL,
	[diemThuong] [int] NULL,
	[ghiChu] [nvarchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 11/22/2023 11:41:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[maKhuyenMai] [nchar](16) NOT NULL,
	[tenKhuyenMai] [nvarchar](40) NULL,
	[maGiamGia] [nvarchar](16) NULL,
	[ngayBatDau] [datetime] NULL,
	[ngayKetThuc] [datetime] NULL,
	[tongSoLuong] [int] NULL,
	[chieuKhau] [float] NULL,
	[moTa] [nvarchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[maKhuyenMai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiNhanVien]    Script Date: 11/22/2023 11:41:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiNhanVien](
	[maLoaiNhanVien] [nchar](16) NOT NULL,
	[tenLoaiNhanVien] [nvarchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[maLoaiNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 11/22/2023 11:41:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiPhong](
	[maLoaiPhong] [nchar](16) NOT NULL,
	[tenLoaiPhong] [nvarchar](40) NULL,
	[soLuongKhachToiDa] [int] NULL,
	[giaTien] [float] NULL,
	[hinhAnh] [nchar](255) NULL,
	[moTa] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[maLoaiPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/22/2023 11:41:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nchar](16) NOT NULL,
	[maLoaiNhanVien] [nchar](16) NULL,
	[hoTen] [nvarchar](40) NULL,
	[gioiTinh] [bit] NULL,
	[ngaySinh] [date] NULL,
	[soDienThoai] [nvarchar](10) NULL,
	[CCCD] [nvarchar](12) NULL,
	[diaChi] [nvarchar](40) NULL,
	[trangThai] [nvarchar](40) NULL,
	[anhThe] [nchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuDatPhong]    Script Date: 11/22/2023 11:41:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDatPhong](
	[maPhieuDat] [nchar](15) NOT NULL,
	[maPhong] [nchar](16) NULL,
	[maNhanVien] [nchar](16) NULL,
	[maKhachHang] [nchar](16) NULL,
	[thoiGianDatPhong] [datetime] NULL,
	[thoiGianNhanPhong] [datetime] NULL,
	[tienCoc] [float] NULL,
	[trangThai] [nvarchar](40) NULL,
	[moTa] [nvarchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhieuDat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 11/22/2023 11:41:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[maPhong] [nchar](16) NOT NULL,
	[tenPhong] [nvarchar](40) NULL,
	[maLoaiPhong] [nchar](16) NULL,
	[maTrangThai] [nchar](16) NULL,
	[ngayTaoPhong] [date] NULL,
	[viTriPhong] [nchar](8) NULL,
	[ghiChu] [nvarchar](100) NULL,
	[tinhTrangPhong] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 11/22/2023 11:41:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[maNhanVien] [nchar](16) NOT NULL,
	[tenDangNhap] [nchar](16) NULL,
	[matKhau] [nchar](40) NOT NULL,
	[trangThai] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThongTinDichVu]    Script Date: 11/22/2023 11:41:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThongTinDichVu](
	[maThongTinDichVu] [nchar](16) NOT NULL,
	[soLuong] [int] NULL,
	[soLuongDaSuDung] [int] NULL,
	[ngayNhap] [datetime] NULL,
	[ngayHetHan] [datetime] NULL,
	[moTa] [nvarchar](40) NULL,
	[hinhAnh] [nchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[maThongTinDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TrangThaiPhong]    Script Date: 11/22/2023 11:41:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TrangThaiPhong](
	[maTrangThai] [nchar](16) NOT NULL,
	[tenTrangThai] [nvarchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[maTrangThai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD11122023A001 ', N'DV261020230001 ', 5, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD11122023A001 ', N'DV261020230003 ', 2, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD11122023A001 ', N'DV261020230004 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD11122023A001 ', N'DV261020230006 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD11122023A001 ', N'DV271020230016 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD11122023A001 ', N'DV271020230017 ', 5, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD11122023A001 ', N'DV271020230018 ', 21, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD11122023A002 ', N'DV261020230002 ', 6, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD11122023A002 ', N'DV261020230008 ', 2, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD11122023A002 ', N'DV261020230009 ', 5, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD11122023A002 ', N'DV271020230019 ', 2, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD14112023D001 ', N'DV261020230002 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD14112023D002 ', N'DV261020230002 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD14112023D002 ', N'DV271020230011 ', 4, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD15112023C001 ', N'DV261020230001 ', 2, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD15112023C001 ', N'DV261020230002 ', 2, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD15112023C001 ', N'DV271020230012 ', 6, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A003 ', N'DV261020230004 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A003 ', N'DV271020230013 ', 6, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A003 ', N'DV271020230014 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A003 ', N'DV271020230017 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A003 ', N'DV271020230018 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A003 ', N'DV271020230019 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A004 ', N'DV261020230004 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A004 ', N'DV271020230016 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A004 ', N'DV271020230018 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A005 ', N'DV261020230004 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A005 ', N'DV271020230017 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A005 ', N'DV271020230018 ', 3, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A006 ', N'DV261020230006 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A006 ', N'DV261020230008 ', 4, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A006 ', N'DV271020230011 ', 5, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A006 ', N'DV271020230012 ', 5, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A006 ', N'DV271020230015 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A006 ', N'DV271020230018 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A008 ', N'DV261020230008 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A008 ', N'DV261020230009 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023A008 ', N'DV261020230010 ', 4, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023B002 ', N'DV261020230003 ', 10, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023B002 ', N'DV261020230008 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023B002 ', N'DV271020230011 ', 20, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023B003 ', N'DV261020230008 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023B003 ', N'DV271020230018 ', 12, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023D001 ', N'DV261020230001 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD16112023D001 ', N'DV261020230003 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD20112023D001 ', N'DV261020230004 ', 3, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD21112023B001 ', N'DV271020230014 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD21112023B001 ', N'DV271020230017 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD21112023B001 ', N'DV271020230018 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD22112023A014 ', N'DV261020230008 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD22112023A014 ', N'DV261020230009 ', 3, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD22112023A014 ', N'DV271020230015 ', 2, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD22112023B002 ', N'DV261020230001 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD22112023C001 ', N'DV261020230002 ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([maHoaDon], [maDichVu], [soLuong], [maPhong]) VALUES (N'HD22112023C001 ', N'DV261020230008 ', 5, NULL)
GO
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD11122023A001 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD11122023A002 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD15112023C001 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD15112023C001 ', N'P103            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD15112023C001 ', N'P104            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD15112023C002 ', N'P201            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD15112023C003 ', N'P304            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD15112023C003 ', N'P401            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A001 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A002 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A003 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A004 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A005 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A006 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A006 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A006 ', N'P103            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A007 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A007 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A007 ', N'P103            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A008 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A008 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A008 ', N'P103            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A009 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A009 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A009 ', N'P103            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A010 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A010 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A010 ', N'P103            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A012 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A015 ', N'P202            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A016 ', N'P202            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A016 ', N'P203            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A016 ', N'P204            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A017 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A018 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A018 ', N'P103            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A018 ', N'P104            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A018 ', N'P201            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A018 ', N'P202            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A018 ', N'P203            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A018 ', N'P204            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A018 ', N'P301            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023A018 ', N'P302            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023B001 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023B001 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023B001 ', N'P103            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023B002 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023B002 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023B002 ', N'P202            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023B002 ', N'P203            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023B002 ', N'P204            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023B003 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023C001 ', N'P203            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023C001 ', N'P204            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023C001 ', N'P301            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023C001 ', N'P304            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023C001 ', N'P401            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023C001 ', N'P402            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD16112023D001 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD20112023D001 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD20112023D002 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD21112023A001 ', N'P103            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD21112023A002 ', N'P202            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD21112023A003 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD21112023A003 ', N'P103            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD21112023A003 ', N'P201            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD21112023A004 ', N'P303            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD21112023B001 ', N'P301            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD21112023D001 ', N'P404            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD21112023D002 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD21112023D003 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A001 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A002 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A003 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A005 ', N'P103            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A006 ', N'P104            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A007 ', N'P201            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A008 ', N'P202            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A008 ', N'P203            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A008 ', N'P204            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A009 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A009 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A009 ', N'P103            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A009 ', N'P104            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A009 ', N'P202            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A009 ', N'P203            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A009 ', N'P204            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A009 ', N'P301            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A010 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A011 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A012 ', N'P104            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A013 ', N'P103            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023A014 ', N'P201            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023B001 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023B001 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023B001 ', N'P103            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023B002 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023C001 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023C001 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023C001 ', N'P103            ')
GO
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023C002 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023C002 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023C002 ', N'P103            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023C002 ', N'P104            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023C002 ', N'P201            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023C003 ', N'P304            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023C004 ', N'P101            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023C004 ', N'P102            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023C005 ', N'P202            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023C005 ', N'P203            ')
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maPhong]) VALUES (N'HD22112023C006 ', N'P204            ')
GO
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [donViTinh], [donGia], [trangThai], [maThongTinDichVu]) VALUES (N'DV261020230001 ', N'Bia', N'VND', 20000, 1, N'TTDV261020230001')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [donViTinh], [donGia], [trangThai], [maThongTinDichVu]) VALUES (N'DV261020230002 ', N'Đậu phộng rang', N'VND', 10000, 1, N'TTDV261020230002')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [donViTinh], [donGia], [trangThai], [maThongTinDichVu]) VALUES (N'DV261020230003 ', N'Bánh mì', N'VND', 15000, 1, N'TTDV261020230003')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [donViTinh], [donGia], [trangThai], [maThongTinDichVu]) VALUES (N'DV261020230004 ', N'Snack', N'VND', 5000, 1, N'TTDV261020230004')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [donViTinh], [donGia], [trangThai], [maThongTinDichVu]) VALUES (N'DV261020230006 ', N'Cơm rang', N'VND', 20000, 1, N'TTDV261020230006')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [donViTinh], [donGia], [trangThai], [maThongTinDichVu]) VALUES (N'DV261020230008 ', N'Trái cây', N'VND', 60000, 1, N'TTDV261020230008')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [donViTinh], [donGia], [trangThai], [maThongTinDichVu]) VALUES (N'DV261020230009 ', N'Khô mực', N'VND', 80000, 1, N'TTDV261020230009')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [donViTinh], [donGia], [trangThai], [maThongTinDichVu]) VALUES (N'DV261020230010 ', N'Thuốc lá', N'VND', 20000, 1, N'TTDV261020230010')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [donViTinh], [donGia], [trangThai], [maThongTinDichVu]) VALUES (N'DV271020230011 ', N'7 UP', N'VND', 12000, 1, N'TTDV261020230011')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [donViTinh], [donGia], [trangThai], [maThongTinDichVu]) VALUES (N'DV271020230012 ', N'Không độ', N'VND', 12000, 1, N'TTDV261020230012')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [donViTinh], [donGia], [trangThai], [maThongTinDichVu]) VALUES (N'DV271020230013 ', N'Mirinda', N'VND', 12000, 1, N'TTDV261020230013')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [donViTinh], [donGia], [trangThai], [maThongTinDichVu]) VALUES (N'DV271020230014 ', N'Nước C2 vị bạc hà', N'VND', 10000, 1, N'TTDV261020230014')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [donViTinh], [donGia], [trangThai], [maThongTinDichVu]) VALUES (N'DV271020230015 ', N'Nước C2 vị chanh', N'VND', 10000, 1, N'TTDV261020230015')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [donViTinh], [donGia], [trangThai], [maThongTinDichVu]) VALUES (N'DV271020230016 ', N'Nước suối', N'VND', 8000, 1, N'TTDV261020230016')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [donViTinh], [donGia], [trangThai], [maThongTinDichVu]) VALUES (N'DV271020230017 ', N'Red bull', N'Lon', 15000, 1, N'TTDV261020230017')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [donViTinh], [donGia], [trangThai], [maThongTinDichVu]) VALUES (N'DV271020230018 ', N'Sting', N'VND', 12000, 1, N'TTDV261020230018')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [donViTinh], [donGia], [trangThai], [maThongTinDichVu]) VALUES (N'DV271020230019 ', N'Twister', N'VND', 11000, 1, N'TTDV261020230019')
GO
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD11122023A001 ', N'KH56920001      ', N'NV61890001      ', N'PD11122023A001 ', NULL, CAST(N'2023-11-12T08:00:00.000' AS DateTime), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD11122023A002 ', N'KH42560001      ', N'NV61890001      ', N'PD11122023A002 ', NULL, CAST(N'2023-11-12T08:05:00.000' AS DateTime), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD14112023B003 ', N'KH56920001      ', N'NV56920001      ', N'PD14112023B003 ', NULL, CAST(N'2023-11-14T16:51:40.877' AS DateTime), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD14112023C001 ', N'KH56920001      ', N'NV56920001      ', N'PD14112023C001 ', NULL, CAST(N'2023-11-14T21:58:10.680' AS DateTime), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD14112023D001 ', N'KH56920001      ', N'NV56920001      ', N'PD14112023D001 ', NULL, CAST(N'2023-11-14T00:45:30.633' AS DateTime), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD14112023D002 ', N'KH56920001      ', N'NV56920001      ', N'PD14112023D002 ', NULL, CAST(N'2023-11-14T01:46:59.307' AS DateTime), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD15112023B001 ', N'KH56920001      ', N'NV56920001      ', N'PD15112023B001 ', NULL, CAST(N'2023-11-15T12:20:59.917' AS DateTime), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD15112023B002 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-15T15:58:27.840' AS DateTime), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD15112023C001 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-15T18:30:53.963' AS DateTime), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD15112023C002 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-15T18:32:26.850' AS DateTime), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD15112023C003 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-15T19:17:15.267' AS DateTime), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023A001 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-16T10:04:10.687' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T10:04:55.140' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023A002 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-16T10:06:50.087' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T10:07:05.780' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023A003 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-16T10:09:46.400' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T10:14:37.263' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023A004 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-16T10:17:12.713' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T10:17:42.483' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023A005 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-16T10:18:01.797' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T10:19:00.883' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023A006 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-16T10:21:39.287' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T10:46:48.040' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023A007 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-16T10:22:19.497' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T10:22:42.077' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023A008 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-16T10:23:08.957' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T10:23:54.197' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023A009 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-16T10:24:31.973' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T10:24:57.453' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023A010 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-16T10:28:35.577' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T10:28:49.277' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023A012 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-16T11:04:48.933' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T11:04:57.353' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023A013 ', N'KH56920001      ', N'NV56920001      ', N'PD16112023A003 ', NULL, CAST(N'2023-11-16T11:22:31.943' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T11:28:45.807' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023A014 ', N'KH56920001      ', N'NV56920001      ', N'PD16112023A004 ', NULL, CAST(N'2023-11-16T11:30:55.823' AS DateTime), N'Đã hủy', NULL)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023A015 ', N'KH56920001      ', N'NV56920001      ', N'PD16112023A005 ', NULL, CAST(N'2023-11-16T11:41:21.613' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T11:41:35.407' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023A016 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-16T11:41:51.677' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T11:42:01.100' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023A017 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-16T11:43:44.580' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T11:43:51.267' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023A018 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-16T11:46:14.590' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T11:46:26.493' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023B001 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-16T12:52:24.567' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T12:52:45.400' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023B002 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-16T12:53:08.653' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T12:54:14.940' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023B003 ', N'KH56920001      ', N'NV56920001      ', N'PD16112023B001 ', NULL, CAST(N'2023-11-16T12:55:30.713' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T12:56:10.580' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023C001 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-16T22:00:30.040' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T23:05:03.167' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD16112023D001 ', N'KH56920001      ', N'NV56920001      ', NULL, NULL, CAST(N'2023-11-16T01:28:34.280' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-16T10:03:30.640' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD20112023D001 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-20T23:21:26.353' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-20T23:24:16.940' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD20112023D002 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-20T23:24:46.637' AS DateTime), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD21112023A001 ', N'KH56920001      ', N'NV56920002      ', N'PD21112023A001 ', NULL, CAST(N'2023-11-21T10:33:53.357' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-21T10:34:15.327' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD21112023A002 ', N'KH56920001      ', N'NV56920002      ', N'PD21112023A005 ', NULL, CAST(N'2023-11-21T10:37:21.217' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-21T10:37:39.577' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD21112023A003 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-21T10:38:37.943' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-21T10:38:48.330' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD21112023A004 ', N'KH56920001      ', N'NV56920002      ', N'PD21112023A006 ', NULL, CAST(N'2023-11-21T10:52:47.493' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-21T10:53:00.087' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD21112023B001 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-21T16:52:50.533' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-21T16:53:35.977' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD21112023D001 ', N'KH56920001      ', N'NV56920002      ', N'PD21112023D002 ', NULL, CAST(N'2023-11-21T00:25:34.597' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-21T00:25:48.290' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD21112023D002 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-21T00:37:27.930' AS DateTime), N'Đã hủy', NULL)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD21112023D003 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-21T00:40:36.610' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-21T00:40:56.093' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023A001 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T08:05:17.833' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T08:09:46.770' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023A002 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T08:32:19.120' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T09:39:22.133' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023A003 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T09:18:17.930' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T09:39:11.300' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023A004 ', N'KH61890001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T09:19:15.330' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T09:39:00.457' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023A005 ', N'KH61890001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T09:19:31.057' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T09:38:52.390' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023A006 ', N'KH61890001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T09:19:38.320' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T09:38:45.943' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023A007 ', N'KH61890001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T09:19:46.820' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T09:38:38.003' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023A008 ', N'KH98430001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T09:20:06.877' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T09:38:27.860' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023A009 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T09:39:36.180' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T09:40:27.137' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023A010 ', N'KH56920001      ', N'NV56920002      ', N'PD22112023A002 ', NULL, CAST(N'2023-11-22T09:41:51.300' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T09:44:53.490' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023A011 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T10:07:09.630' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T14:11:40.320' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023A012 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T10:28:03.973' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T14:11:28.710' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023A013 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T10:29:39.977' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T14:11:09.647' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023A014 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T10:29:55.590' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T14:10:36.173' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023B001 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T14:12:11.393' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T14:12:22.317' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023B002 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T14:12:48.703' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T14:19:02.900' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023C001 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T22:36:22.390' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T22:37:39.063' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023C002 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T22:41:48.443' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T22:53:12.723' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023C003 ', N'KH56920001      ', N'NV56920002      ', N'PD22112023C004 ', NULL, CAST(N'2023-11-22T22:46:23.037' AS DateTime), N'Đã thanh toán', CAST(N'2023-11-22T22:53:01.203' AS DateTime))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023C004 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T22:53:35.533' AS DateTime), N'Đang chờ thanh toán', NULL)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023C005 ', N'KH56920001      ', N'NV56920002      ', NULL, NULL, CAST(N'2023-11-22T22:57:20.957' AS DateTime), N'Đang chờ thanh toán', NULL)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [maNhanVien], [maPhieuDat], [maKhuyenMai], [ngayLap], [trangThai], [thoiGianKetThuc]) VALUES (N'HD22112023C006 ', N'KH56920001      ', N'NV56920002      ', N'PD22112023C009 ', NULL, CAST(N'2023-11-22T22:58:32.913' AS DateTime), N'Đang chờ thanh toán', NULL)
GO
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [diaChi], [soDienThoai], [diemThuong], [ghiChu]) VALUES (N'KH42560001      ', N'Nguyễn Thiên Tứ', 1, CAST(N'2003-01-02' AS Date), N'Gò Vấp, TP.HCM', N'0935014256', 300, N'Không có ghi chú nào')
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [diaChi], [soDienThoai], [diemThuong], [ghiChu]) VALUES (N'KH56920001      ', N'Lê Minh Quang', 1, CAST(N'2003-02-19' AS Date), N'Gò Vấp, TP.HCM', N'0364835692', 500, N'Không có ghi chú nào')
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [diaChi], [soDienThoai], [diemThuong], [ghiChu]) VALUES (N'KH61890001      ', N'Nguyễn Thị Nga', 0, CAST(N'2003-09-23' AS Date), N'Gò Vấp, TP.HCM', N'0776466189', 200, N'Không có ghi chú nào')
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [diaChi], [soDienThoai], [diemThuong], [ghiChu]) VALUES (N'KH98430001      ', N'Nguyễn Thành Cương', 1, CAST(N'2003-07-31' AS Date), N'Thủ Đức, TP.HCM', N'0935019843', 100, N'Không có ghi chú nào')
GO
INSERT [dbo].[KhuyenMai] ([maKhuyenMai], [tenKhuyenMai], [maGiamGia], [ngayBatDau], [ngayKetThuc], [tongSoLuong], [chieuKhau], [moTa]) VALUES (N'10122023001     ', N'Giảm giá 20/10', N'GIAMGIA2010', CAST(N'2023-10-22T00:00:00.000' AS DateTime), CAST(N'2023-11-22T00:00:00.000' AS DateTime), 100, 10, N'Nothing')
INSERT [dbo].[KhuyenMai] ([maKhuyenMai], [tenKhuyenMai], [maGiamGia], [ngayBatDau], [ngayKetThuc], [tongSoLuong], [chieuKhau], [moTa]) VALUES (N'10122023002     ', N'Giảm giá 21/11', N'GIAMGIA2111', CAST(N'2023-11-20T00:00:00.000' AS DateTime), CAST(N'2023-11-22T00:00:00.000' AS DateTime), 50, 10, N'Nothing')
GO
INSERT [dbo].[LoaiNhanVien] ([maLoaiNhanVien], [tenLoaiNhanVien]) VALUES (N'LNV000          ', N'Quản lý')
INSERT [dbo].[LoaiNhanVien] ([maLoaiNhanVien], [tenLoaiNhanVien]) VALUES (N'LNV001          ', N'Nhân viên thu ngân')
INSERT [dbo].[LoaiNhanVien] ([maLoaiNhanVien], [tenLoaiNhanVien]) VALUES (N'LNV002          ', N'Nhân viên tiếp tân')
GO
INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [tenLoaiPhong], [soLuongKhachToiDa], [giaTien], [hinhAnh], [moTa]) VALUES (N'ORD1            ', N'Loại phòng thường 5 người', 5, 20000, N'                                                                                                                                                                                                                                                               ', N'')
INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [tenLoaiPhong], [soLuongKhachToiDa], [giaTien], [hinhAnh], [moTa]) VALUES (N'ORD2            ', N'Loại phòng thường 12 người', 12, 40000, N'img\phong_thuong_2                                                                                                                                                                                                                                             ', N'Phòng cho 12 người sử dụng')
INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [tenLoaiPhong], [soLuongKhachToiDa], [giaTien], [hinhAnh], [moTa]) VALUES (N'VIP1            ', N'Loại phòng vip 5 người', 5, 40000, N'img\phong_vip_1                                                                                                                                                                                                                                                ', N'Phòng cho 5 người sử dụng')
INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [tenLoaiPhong], [soLuongKhachToiDa], [giaTien], [hinhAnh], [moTa]) VALUES (N'VIP2            ', N'Loại phòng vip 12 người', 12, 40000, N'img\phong_vip_2                                                                                                                                                                                                                                                ', N'Phòng cho 12 người sử dụng')
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [maLoaiNhanVien], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [CCCD], [diaChi], [trangThai], [anhThe]) VALUES (N'NV42560001      ', N'LNV001          ', N'Nguyễn Thiên Tứ', 1, CAST(N'2003-01-01' AS Date), N'0935014256', N'054203126452', N'Thủ Đức, Hồ Chí Minh', N'Đang làm', N'/img/noImage.jpg                                                                                    ')
INSERT [dbo].[NhanVien] ([maNhanVien], [maLoaiNhanVien], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [CCCD], [diaChi], [trangThai], [anhThe]) VALUES (N'NV56920001      ', N'LNV001          ', N'Lê Minh Quang', 1, CAST(N'2003-01-01' AS Date), N'0364835692', N'054203030983', N'Gò Vấp, Hồ Chí Minh', N'Đang Làm', N'/img/noImage.jpg                                                                                    ')
INSERT [dbo].[NhanVien] ([maNhanVien], [maLoaiNhanVien], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [CCCD], [diaChi], [trangThai], [anhThe]) VALUES (N'NV56920002      ', N'LNV000          ', N'Lê Nguyễn Thành Tứ', 1, CAST(N'2003-01-01' AS Date), N'0364835692', N'054203330983', N'Gò Vấp, Hồ Chí Minh', N'Đang Làm', N'/img/noImage.jpg                                                                                    ')
INSERT [dbo].[NhanVien] ([maNhanVien], [maLoaiNhanVien], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [CCCD], [diaChi], [trangThai], [anhThe]) VALUES (N'NV61890001      ', N'LNV001          ', N'Nguyễn Nga', 0, CAST(N'2003-01-01' AS Date), N'0776466189', N'012943666212', N'Gò Vấp, Hồ Chí Minh', N'Đang Làm', N'/img/noImage.jpg                                                                                    ')
INSERT [dbo].[NhanVien] ([maNhanVien], [maLoaiNhanVien], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [CCCD], [diaChi], [trangThai], [anhThe]) VALUES (N'NV98430001      ', N'LNV001          ', N'Nguyễn Thành Cương', 1, CAST(N'2003-01-01' AS Date), N'0935019843', N'054203000983', N'Gò Vấp, Hồ Chí Minh', N'Đang Làm', N'/img/noImage.jpg                                                                                    ')
GO
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD10122023A003 ', N'P103            ', N'NV61890001      ', N'KH56920001      ', CAST(N'2023-10-12T08:00:00.000' AS DateTime), CAST(N'2023-12-13T09:00:00.000' AS DateTime), 50000, N'Hết hạn', N'Nothing')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD10122023A004 ', N'P104            ', N'NV61890001      ', N'KH42560001      ', CAST(N'2023-10-12T08:00:00.000' AS DateTime), CAST(N'2023-12-13T09:13:00.000' AS DateTime), 100000, N'Hết hạn', N'Nothing')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD11122023A001 ', N'P101            ', N'NV61890001      ', N'KH56920001      ', CAST(N'2023-11-12T08:00:00.000' AS DateTime), CAST(N'2023-11-12T08:00:00.000' AS DateTime), 50000, N'Hết hạn', N'Nothing')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD11122023A002 ', N'P102            ', N'NV61890001      ', N'KH42560001      ', CAST(N'2023-11-12T08:00:00.000' AS DateTime), CAST(N'2023-11-12T08:00:00.000' AS DateTime), 100000, N'Hết hạn', N'Nothing')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD13112023B001 ', N'P203            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-13T16:55:00.000' AS DateTime), CAST(N'2023-11-13T17:55:00.000' AS DateTime), 20000, N'Hết hạn', N'Quang đặt phòng nè !!!')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD13112023C002 ', N'P403            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-13T17:21:00.000' AS DateTime), CAST(N'2023-11-14T17:21:00.000' AS DateTime), 20000, N'Hết hạn', N'Demo 01')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD13112023C003 ', N'P404            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-13T20:23:00.000' AS DateTime), CAST(N'2023-11-13T21:50:00.000' AS DateTime), 40000, N'Hết hạn', N'hi')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD14112023B003 ', N'P103            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-14T16:51:40.877' AS DateTime), CAST(N'2023-11-14T16:51:40.877' AS DateTime), 0, N'Hết hạn', N'NV56920001      ')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD14112023C001 ', N'P104            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-14T21:58:10.680' AS DateTime), CAST(N'2023-11-14T21:58:10.680' AS DateTime), 0, N'Hết hạn', N'NV56920001      ')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD14112023D001 ', N'P202            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-14T00:45:30.633' AS DateTime), CAST(N'2023-11-14T00:45:30.633' AS DateTime), 0, N'Hết hạn', N'NV56920001      ')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD14112023D002 ', N'P204            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-14T01:46:59.307' AS DateTime), CAST(N'2023-11-14T01:46:59.307' AS DateTime), 0, N'Hết hạn', N'NV56920001      ')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD15112023B001 ', N'P101            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-15T12:20:59.917' AS DateTime), CAST(N'2023-11-15T12:20:59.917' AS DateTime), 0, N'Hết hạn', N'NV56920001      ')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD15112023B003 ', N'P203            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-15T14:03:00.000' AS DateTime), CAST(N'2023-11-15T15:20:00.000' AS DateTime), 20000, N'Hết hạn', N'Test phieu')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD15112023B004 ', N'P203            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-15T15:20:00.000' AS DateTime), CAST(N'2023-11-15T16:20:00.000' AS DateTime), 20000, N'Hết hạn', N'quanggggggggggggggggggg')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD15112023B005 ', N'P303            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-15T15:46:00.000' AS DateTime), CAST(N'2023-11-15T16:46:00.000' AS DateTime), 20000, N'Hết hạn', N'p303 tst nhan Phong')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD15112023B006 ', N'P403            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-15T15:57:00.000' AS DateTime), CAST(N'2023-11-15T16:57:00.000' AS DateTime), 20000, N'Hết hạn', N'Demo lan cuoi')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD15112023C001 ', N'P501            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-15T22:14:00.000' AS DateTime), CAST(N'2023-11-15T23:14:00.000' AS DateTime), 20000, N'Hết hạn', N'quang tesst')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD15112023D001 ', N'P203            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-15T00:09:00.000' AS DateTime), CAST(N'2023-11-15T00:15:00.000' AS DateTime), 20000, N'Hết hạn', N'Demo p203 dang dat luc 0h dem')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD15112023D002 ', N'P203            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-15T00:14:00.000' AS DateTime), CAST(N'2023-11-15T01:14:00.000' AS DateTime), 20000, N'Hết hạn', N'qqqq')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD15112023D003 ', N'P203            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-15T00:21:00.000' AS DateTime), CAST(N'2023-11-14T00:21:00.000' AS DateTime), 20000, N'Hết hạn', N'test cap nhat het han')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD15112023D004 ', N'P203            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-15T00:21:00.000' AS DateTime), CAST(N'2023-11-15T00:22:00.000' AS DateTime), 20000, N'Hết hạn', N'test cap nhat het han')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD15112023D005 ', N'P203            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-15T00:21:00.000' AS DateTime), CAST(N'2023-11-15T23:22:00.000' AS DateTime), 20000, N'Hết hạn', N'test cap nhat het han')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD15112023D006 ', N'P203            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-15T00:21:00.000' AS DateTime), CAST(N'2023-11-15T22:22:00.000' AS DateTime), 20000, N'Hết hạn', N'test cap nhat het han')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD15112023D007 ', N'P203            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-15T00:21:00.000' AS DateTime), CAST(N'2023-11-15T01:10:00.000' AS DateTime), 20000, N'Hết hạn', N'test cap nhat het han')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD16112023A002 ', N'P504            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-16T10:46:00.000' AS DateTime), CAST(N'2023-11-16T11:46:00.000' AS DateTime), 20000, N'Hết hạn', N'Quang đặt phòng nèeeeeee')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD16112023A003 ', N'P203            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-16T11:18:00.000' AS DateTime), CAST(N'2023-11-16T12:18:00.000' AS DateTime), 20000, N'Hết hạn', N'test nhan phong')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD16112023A004 ', N'P103            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-16T11:28:00.000' AS DateTime), CAST(N'2023-11-16T12:28:00.000' AS DateTime), 20000, N'Hết hạn', N'ádasdsadsadas')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD16112023A005 ', N'P202            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-16T11:39:00.000' AS DateTime), CAST(N'2023-11-16T12:39:00.000' AS DateTime), 40000, N'Hết hạn', N'qqqwessaa')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD16112023B001 ', N'P101            ', N'NV56920001      ', N'KH56920001      ', CAST(N'2023-11-16T12:52:00.000' AS DateTime), CAST(N'2023-11-16T13:52:00.000' AS DateTime), 40000, N'Hết hạn', N'TEST')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD20112023B001 ', N'P101            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-20T13:38:00.000' AS DateTime), CAST(N'2023-11-20T14:38:00.000' AS DateTime), 40000, N'Hết hạn', N'Tét nhận phòng 1 tiếng')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD20112023B002 ', N'P101            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-20T13:57:00.000' AS DateTime), CAST(N'2023-11-13T13:57:00.000' AS DateTime), 40000, N'Hết hạn', N'Téttttttttttttttttttttttt')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD20112023B003 ', N'P103            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-20T14:04:00.000' AS DateTime), CAST(N'2023-11-20T15:04:00.000' AS DateTime), 20000, N'Hết hạn', N'eeee')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD20112023B004 ', N'P103            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-20T14:14:00.000' AS DateTime), CAST(N'2023-11-20T14:14:00.000' AS DateTime), 20000, N'Hết hạn', N'11111111111')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD20112023B005 ', N'P101            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-20T14:18:00.000' AS DateTime), CAST(N'2023-11-20T15:18:00.000' AS DateTime), 40000, N'Hết hạn', N'2222')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD20112023B006 ', N'P101            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-20T14:18:00.000' AS DateTime), CAST(N'2023-11-20T15:18:00.000' AS DateTime), 40000, N'Hết hạn', N'2222333')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD20112023C001 ', N'P102            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-20T21:43:48.343' AS DateTime), CAST(N'2023-11-20T22:43:00.000' AS DateTime), 40000, N'Hết hạn', N'qqqq')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD20112023C002 ', N'P102            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-20T21:44:11.443' AS DateTime), CAST(N'2023-11-20T22:43:00.000' AS DateTime), 40000, N'Hết hạn', N'qqqq')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD20112023C003 ', N'P102            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-20T21:44:14.250' AS DateTime), CAST(N'2023-11-20T22:43:00.000' AS DateTime), 40000, N'Hết hạn', N'qqqq')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD20112023C004 ', N'P102            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-20T21:44:16.380' AS DateTime), CAST(N'2023-11-20T22:43:00.000' AS DateTime), 40000, N'Hết hạn', N'qqqq')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD20112023C005 ', N'P102            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-20T21:44:18.497' AS DateTime), CAST(N'2023-11-20T22:43:00.000' AS DateTime), 40000, N'Hết hạn', N'qqqq')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD20112023C006 ', N'P102            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-20T21:44:21.250' AS DateTime), CAST(N'2023-11-20T22:43:00.000' AS DateTime), 40000, N'Hết hạn', N'qqqq')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD20112023C007 ', N'P104            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-20T22:38:36.857' AS DateTime), CAST(N'2023-11-21T22:00:00.000' AS DateTime), 40000, N'Hết hạn', N'tét ngày mai')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD20112023D001 ', N'P304            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-20T23:34:33.687' AS DateTime), CAST(N'2023-11-21T23:00:00.000' AS DateTime), 40000, N'Hết hạn', N'tét ngày mai')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD20112023D002 ', N'P304            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-20T23:34:39.963' AS DateTime), CAST(N'2023-11-21T23:00:00.000' AS DateTime), 40000, N'Hết hạn', N'tét ngày mai')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD20112023D003 ', N'P304            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-20T23:35:19.717' AS DateTime), CAST(N'2023-11-20T00:00:00.000' AS DateTime), 40000, N'Hết hạn', N'tét ngày mai')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD20112023D004 ', N'P404            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-20T23:35:24.317' AS DateTime), CAST(N'2023-11-20T00:00:00.000' AS DateTime), 40000, N'Hết hạn', N'tét ngày mai')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD20112023D005 ', N'P104            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-20T23:47:56.130' AS DateTime), CAST(N'2023-11-20T02:00:00.000' AS DateTime), 40000, N'Hết hạn', N'tét ngày mai')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD21112023A001 ', N'P103            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-21T10:12:01.813' AS DateTime), CAST(N'2023-11-21T11:11:00.000' AS DateTime), 20000, N'Đã nhận phòng', N'12333333')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD21112023A002 ', N'P104            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-21T10:12:56.493' AS DateTime), CAST(N'2023-11-21T13:11:00.000' AS DateTime), 40000, N'Hết hạn', N'12333333')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD21112023A003 ', N'P104            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-21T10:13:24.103' AS DateTime), CAST(N'2023-11-21T11:11:00.000' AS DateTime), 40000, N'Hết hạn', N'12333333')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD21112023A004 ', N'P102            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-21T10:13:47.473' AS DateTime), CAST(N'2023-11-21T11:11:00.000' AS DateTime), 40000, N'Hết hạn', N'12333333')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD21112023A005 ', N'P202            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-21T10:37:12.623' AS DateTime), CAST(N'2023-11-21T10:42:00.000' AS DateTime), 40000, N'Đã nhận phòng', N'111223')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD21112023A006 ', N'P303            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-21T10:40:16.673' AS DateTime), CAST(N'2023-11-21T11:42:00.000' AS DateTime), 20000, N'Đã nhận phòng', N'111223')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD21112023A008 ', N'P302            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-21T10:43:50.390' AS DateTime), CAST(N'2023-11-21T10:45:00.000' AS DateTime), 40000, N'Hết hạn', N'111223')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD21112023A009 ', N'P103            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-21T10:54:20.743' AS DateTime), CAST(N'2023-11-21T10:56:00.000' AS DateTime), 20000, N'Hết hạn', N'122333')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD21112023D001 ', N'P404            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-21T00:03:34.510' AS DateTime), CAST(N'2023-11-21T02:00:00.000' AS DateTime), 40000, N'Hết hạn', N'tét ngày mai')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD21112023D002 ', N'P404            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-21T00:15:43.500' AS DateTime), CAST(N'2023-11-21T01:00:00.000' AS DateTime), 40000, N'Đã nhận phòng', N'trueee')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD21112023D003 ', N'P103            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-21T00:42:20.830' AS DateTime), CAST(N'2023-11-21T01:39:00.000' AS DateTime), 20000, N'Hết hạn', N'hihi')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD21112023D004 ', N'P203            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-21T00:42:50.970' AS DateTime), CAST(N'2023-11-21T01:22:00.000' AS DateTime), 20000, N'Hết hạn', N'hihi2222222')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD22112023A001 ', N'P101            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-22T08:27:03.433' AS DateTime), CAST(N'2023-11-22T09:14:00.000' AS DateTime), 40000, N'Hết hạn', N'qqqqqq')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD22112023A002 ', N'P505            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-22T09:41:07.727' AS DateTime), CAST(N'2023-11-22T10:36:00.000' AS DateTime), 20000, N'Đã nhận phòng', N'test')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD22112023C001 ', N'P103            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-22T20:35:00.843' AS DateTime), CAST(N'2023-11-23T21:30:00.000' AS DateTime), 20000, N'Chờ nhận phòng', N'test ngay mai 23 - 11')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD22112023C003 ', N'P203            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-22T21:04:18.793' AS DateTime), CAST(N'2023-11-23T21:30:00.000' AS DateTime), 20000, N'Chờ nhận phòng', N'test ngay mai 23 - 11')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD22112023C004 ', N'P303            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-22T22:38:18.863' AS DateTime), CAST(N'2023-11-22T23:36:00.000' AS DateTime), 20000, N'Đã nhận phòng', N'sss')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD22112023C005 ', N'P303            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-22T22:38:38.407' AS DateTime), CAST(N'2023-11-23T23:36:00.000' AS DateTime), 20000, N'Chờ nhận phòng', N'sss')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD22112023C006 ', N'P403            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-22T22:39:03.423' AS DateTime), CAST(N'2023-11-23T23:36:00.000' AS DateTime), 20000, N'Chờ nhận phòng', N'sss')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD22112023C007 ', N'P501            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-22T22:44:53.660' AS DateTime), CAST(N'2023-11-22T22:46:00.000' AS DateTime), 20000, N'Hết hạn', N'aaaa')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD22112023C008 ', N'P204            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-22T22:47:43.547' AS DateTime), CAST(N'2023-11-22T22:49:00.000' AS DateTime), 40000, N'Hết hạn', N'qqqq')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDat], [maPhong], [maNhanVien], [maKhachHang], [thoiGianDatPhong], [thoiGianNhanPhong], [tienCoc], [trangThai], [moTa]) VALUES (N'PD22112023C009 ', N'P304            ', N'NV56920002      ', N'KH56920001      ', CAST(N'2023-11-22T22:58:23.580' AS DateTime), CAST(N'2023-11-22T23:57:00.000' AS DateTime), 40000, N'Đã nhận phòng', N'ss')
GO
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P101            ', N'P101', N'VIP1            ', N'OC              ', CAST(N'2023-10-30' AS Date), N'Lầu 1   ', N'Không có ghi chú', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P102            ', N'P102', N'VIP2            ', N'OC              ', CAST(N'2023-10-30' AS Date), N'Lầu 1   ', N'Không có ghi chú', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P103            ', N'P103', N'ORD1            ', N'VC              ', CAST(N'2023-10-30' AS Date), N'Lầu 1   ', N'Không có ghi chú', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P104            ', N'P104', N'ORD2            ', N'VC              ', CAST(N'2023-10-30' AS Date), N'Lầu 1   ', N'Không có ghi chú', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P201            ', N'P201', N'VIP1            ', N'VC              ', CAST(N'2023-10-30' AS Date), N'Lầu 1   ', N'Không có ghi chú', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P202            ', N'P202', N'VIP2            ', N'OC              ', CAST(N'2023-10-30' AS Date), N'Lầu 1   ', N'Không có ghi chú', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P203            ', N'P203', N'ORD1            ', N'OC              ', CAST(N'2023-10-30' AS Date), N'Lầu 1   ', N'Không có ghi chú', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P204            ', N'P204', N'ORD2            ', N'OC              ', CAST(N'2023-10-30' AS Date), N'Lầu 2   ', N'Không có ghi chú', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P301            ', N'P301', N'VIP1            ', N'VC              ', CAST(N'2023-10-30' AS Date), N'Lầu 3   ', N'Không có ghi chú', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P302            ', N'P302', N'VIP2            ', N'VC              ', CAST(N'2023-10-30' AS Date), N'Lầu 3   ', N'Không có ghi chú', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P303            ', N'P303', N'ORD1            ', N'VC              ', CAST(N'2023-10-30' AS Date), N'Lầu 3   ', N'Không có ghi chú', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P304            ', N'P304', N'ORD2            ', N'VC              ', CAST(N'2023-10-30' AS Date), N'Lầu 3   ', N'Không có ghi chú', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P401            ', N'P401', N'VIP1            ', N'VC              ', CAST(N'2023-10-30' AS Date), N'Lầu 4   ', N'Không có ghi chú', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P402            ', N'P402', N'VIP2            ', N'VC              ', CAST(N'2023-10-30' AS Date), N'Lầu 4   ', N'Không có ghi chú', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P403            ', N'P403', N'ORD1            ', N'VC              ', CAST(N'2023-10-30' AS Date), N'Lầu 4   ', N'Không có ghi chú', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P404            ', N'P404', N'ORD2            ', N'VC              ', CAST(N'2023-10-30' AS Date), N'Lầu 4   ', N'Không có ghi chú', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P501            ', N'P501', N'ORD1            ', N'VC              ', CAST(N'2023-11-14' AS Date), N'Lầu 1   ', N'', N'Sửa chữa')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P502            ', N'P406', N'ORD1            ', N'VC              ', CAST(N'2023-11-14' AS Date), N'Lầu 5   ', N'', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P503            ', N'P503', N'ORD1            ', N'VC              ', CAST(N'2023-11-14' AS Date), N'Lầu 1   ', N'', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P504            ', N'P504', N'ORD1            ', N'VC              ', CAST(N'2023-11-14' AS Date), N'Lầu 1   ', N'', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P505            ', N'P409', N'ORD1            ', N'VC              ', CAST(N'2023-11-14' AS Date), N'Lầu 5   ', N'', N'Sử dụng được')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [maTrangThai], [ngayTaoPhong], [viTriPhong], [ghiChu], [tinhTrangPhong]) VALUES (N'P506            ', N'P410', N'ORD1            ', N'VC              ', CAST(N'2023-11-13' AS Date), N'Lầu 5   ', N'', N'Sử dụng được')
GO
INSERT [dbo].[TaiKhoan] ([maNhanVien], [tenDangNhap], [matKhau], [trangThai]) VALUES (N'NV42560001      ', N'NV42560001      ', N'123456                                  ', 1)
INSERT [dbo].[TaiKhoan] ([maNhanVien], [tenDangNhap], [matKhau], [trangThai]) VALUES (N'NV56920001      ', N'NV56920001      ', N'123456                                  ', 1)
INSERT [dbo].[TaiKhoan] ([maNhanVien], [tenDangNhap], [matKhau], [trangThai]) VALUES (N'NV56920002      ', N'NV56920002      ', N'123456                                  ', 1)
INSERT [dbo].[TaiKhoan] ([maNhanVien], [tenDangNhap], [matKhau], [trangThai]) VALUES (N'NV61890001      ', N'NV61890001      ', N'123456                                  ', 1)
INSERT [dbo].[TaiKhoan] ([maNhanVien], [tenDangNhap], [matKhau], [trangThai]) VALUES (N'NV98430001      ', N'NV98430001      ', N'123456                                  ', 1)
GO
INSERT [dbo].[ThongTinDichVu] ([maThongTinDichVu], [soLuong], [soLuongDaSuDung], [ngayNhap], [ngayHetHan], [moTa], [hinhAnh]) VALUES (N'TTDV22112023B001', 22, 1, CAST(N'2023-11-22T00:00:00.000' AS DateTime), CAST(N'2024-11-14T00:00:00.000' AS DateTime), N'', N'/img/                                                                                                                                                                                                                                                          ')
INSERT [dbo].[ThongTinDichVu] ([maThongTinDichVu], [soLuong], [soLuongDaSuDung], [ngayNhap], [ngayHetHan], [moTa], [hinhAnh]) VALUES (N'TTDV261020230001', 100, 1, CAST(N'2023-10-26T00:00:00.000' AS DateTime), CAST(N'2024-11-26T00:00:00.000' AS DateTime), N'Bia ngon lắm nha', N'/img/                                                                                                                                                                                                                                                          ')
INSERT [dbo].[ThongTinDichVu] ([maThongTinDichVu], [soLuong], [soLuongDaSuDung], [ngayNhap], [ngayHetHan], [moTa], [hinhAnh]) VALUES (N'TTDV261020230002', 100, 1, CAST(N'2023-10-26T00:00:00.000' AS DateTime), CAST(N'2024-11-26T00:00:00.000' AS DateTime), N'Không có mô tả', N'/img/                                                                                                                                                                                                                                                          ')
INSERT [dbo].[ThongTinDichVu] ([maThongTinDichVu], [soLuong], [soLuongDaSuDung], [ngayNhap], [ngayHetHan], [moTa], [hinhAnh]) VALUES (N'TTDV261020230003', 500, 0, CAST(N'2023-10-26T00:00:00.000' AS DateTime), CAST(N'2024-11-26T00:00:00.000' AS DateTime), N'Không có mô tả', N'/img/                                                                                                                                                                                                                                                          ')
INSERT [dbo].[ThongTinDichVu] ([maThongTinDichVu], [soLuong], [soLuongDaSuDung], [ngayNhap], [ngayHetHan], [moTa], [hinhAnh]) VALUES (N'TTDV261020230004', 100, 0, CAST(N'2023-10-26T00:00:00.000' AS DateTime), CAST(N'2024-11-26T00:00:00.000' AS DateTime), N'Không có mô tả', N'/img/                                                                                                                                                                                                                                                          ')
INSERT [dbo].[ThongTinDichVu] ([maThongTinDichVu], [soLuong], [soLuongDaSuDung], [ngayNhap], [ngayHetHan], [moTa], [hinhAnh]) VALUES (N'TTDV261020230006', 100, 0, CAST(N'2023-10-26T00:00:00.000' AS DateTime), CAST(N'2024-10-26T00:00:00.000' AS DateTime), N'Không có mô tả', N'/img/                                                                                                                                                                                                                                                          ')
INSERT [dbo].[ThongTinDichVu] ([maThongTinDichVu], [soLuong], [soLuongDaSuDung], [ngayNhap], [ngayHetHan], [moTa], [hinhAnh]) VALUES (N'TTDV261020230008', 200, 5, CAST(N'2023-10-26T00:00:00.000' AS DateTime), CAST(N'2024-10-27T00:00:00.000' AS DateTime), N'Không có mô tả', N'/img/                                                                                                                                                                                                                                                          ')
INSERT [dbo].[ThongTinDichVu] ([maThongTinDichVu], [soLuong], [soLuongDaSuDung], [ngayNhap], [ngayHetHan], [moTa], [hinhAnh]) VALUES (N'TTDV261020230009', 400, 202, CAST(N'2023-10-26T00:00:00.000' AS DateTime), CAST(N'2024-11-26T00:00:00.000' AS DateTime), N'Không có mô tả', N'/img/                                                                                                                                                                                                                                                          ')
INSERT [dbo].[ThongTinDichVu] ([maThongTinDichVu], [soLuong], [soLuongDaSuDung], [ngayNhap], [ngayHetHan], [moTa], [hinhAnh]) VALUES (N'TTDV261020230010', 400, 0, CAST(N'2023-10-26T00:00:00.000' AS DateTime), CAST(N'2024-10-26T00:00:00.000' AS DateTime), N'Không có mô tả', N'/img/                                                                                                                                                                                                                                                          ')
INSERT [dbo].[ThongTinDichVu] ([maThongTinDichVu], [soLuong], [soLuongDaSuDung], [ngayNhap], [ngayHetHan], [moTa], [hinhAnh]) VALUES (N'TTDV261020230011', 100, 0, CAST(N'2023-10-26T00:00:00.000' AS DateTime), CAST(N'2024-11-26T00:00:00.000' AS DateTime), N'Không có mô tả', N'/img/                                                                                                                                                                                                                                                          ')
INSERT [dbo].[ThongTinDichVu] ([maThongTinDichVu], [soLuong], [soLuongDaSuDung], [ngayNhap], [ngayHetHan], [moTa], [hinhAnh]) VALUES (N'TTDV261020230012', 100, 0, CAST(N'2023-10-26T00:00:00.000' AS DateTime), CAST(N'2024-11-26T00:00:00.000' AS DateTime), N'Không có mô tả', N'/img/                                                                                                                                                                                                                                                          ')
INSERT [dbo].[ThongTinDichVu] ([maThongTinDichVu], [soLuong], [soLuongDaSuDung], [ngayNhap], [ngayHetHan], [moTa], [hinhAnh]) VALUES (N'TTDV261020230013', 500, 0, CAST(N'2023-10-26T00:00:00.000' AS DateTime), CAST(N'2024-11-26T00:00:00.000' AS DateTime), N'Không có mô tả', N'/img/                                                                                                                                                                                                                                                          ')
INSERT [dbo].[ThongTinDichVu] ([maThongTinDichVu], [soLuong], [soLuongDaSuDung], [ngayNhap], [ngayHetHan], [moTa], [hinhAnh]) VALUES (N'TTDV261020230014', 100, 0, CAST(N'2023-10-26T00:00:00.000' AS DateTime), CAST(N'2024-11-26T00:00:00.000' AS DateTime), N'Không có mô tả', N'/img/                                                                                                                                                                                                                                                          ')
INSERT [dbo].[ThongTinDichVu] ([maThongTinDichVu], [soLuong], [soLuongDaSuDung], [ngayNhap], [ngayHetHan], [moTa], [hinhAnh]) VALUES (N'TTDV261020230015', 500, 0, CAST(N'2023-10-26T00:00:00.000' AS DateTime), CAST(N'2024-11-26T00:00:00.000' AS DateTime), N'Không có mô tả', N'/img/                                                                                                                                                                                                                                                          ')
INSERT [dbo].[ThongTinDichVu] ([maThongTinDichVu], [soLuong], [soLuongDaSuDung], [ngayNhap], [ngayHetHan], [moTa], [hinhAnh]) VALUES (N'TTDV261020230016', 100, 0, CAST(N'2023-10-26T00:00:00.000' AS DateTime), CAST(N'2024-10-26T00:00:00.000' AS DateTime), N'Không có mô tả', N'/img/                                                                                                                                                                                                                                                          ')
INSERT [dbo].[ThongTinDichVu] ([maThongTinDichVu], [soLuong], [soLuongDaSuDung], [ngayNhap], [ngayHetHan], [moTa], [hinhAnh]) VALUES (N'TTDV261020230017', 100, 0, CAST(N'2023-10-26T00:00:00.000' AS DateTime), CAST(N'2024-10-27T00:00:00.000' AS DateTime), N'Không có mô tả', N'/img/                                                                                                                                                                                                                                                          ')
INSERT [dbo].[ThongTinDichVu] ([maThongTinDichVu], [soLuong], [soLuongDaSuDung], [ngayNhap], [ngayHetHan], [moTa], [hinhAnh]) VALUES (N'TTDV261020230018', 150, 0, CAST(N'2023-10-26T00:00:00.000' AS DateTime), CAST(N'2024-10-27T00:00:00.000' AS DateTime), N'Không có mô t?', N'/img/22.jpg                                                                                                                                                                                                                                                    ')
INSERT [dbo].[ThongTinDichVu] ([maThongTinDichVu], [soLuong], [soLuongDaSuDung], [ngayNhap], [ngayHetHan], [moTa], [hinhAnh]) VALUES (N'TTDV261020230019', 150, 10, CAST(N'2023-10-26T00:00:00.000' AS DateTime), CAST(N'2024-10-27T00:00:00.000' AS DateTime), N'Không có mô t?', N'/img/22.jpg                                                                                                                                                                                                                                                    ')
GO
INSERT [dbo].[TrangThaiPhong] ([maTrangThai], [tenTrangThai]) VALUES (N'OC              ', N'Đang sử dụng')
INSERT [dbo].[TrangThaiPhong] ([maTrangThai], [tenTrangThai]) VALUES (N'OCP             ', N'Đã đặt')
INSERT [dbo].[TrangThaiPhong] ([maTrangThai], [tenTrangThai]) VALUES (N'OOO             ', N'Không phục vụ')
INSERT [dbo].[TrangThaiPhong] ([maTrangThai], [tenTrangThai]) VALUES (N'VC              ', N'Trống')
GO
ALTER TABLE [dbo].[ChiTietDichVu]  WITH CHECK ADD  CONSTRAINT [F_ChiTietDichVu_DichVu] FOREIGN KEY([maDichVu])
REFERENCES [dbo].[DichVu] ([maDichVu])
GO
ALTER TABLE [dbo].[ChiTietDichVu] CHECK CONSTRAINT [F_ChiTietDichVu_DichVu]
GO
ALTER TABLE [dbo].[ChiTietDichVu]  WITH CHECK ADD  CONSTRAINT [F_ChiTietDichVu_HoaDon] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
GO
ALTER TABLE [dbo].[ChiTietDichVu] CHECK CONSTRAINT [F_ChiTietDichVu_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [F_ChiTietHoaDon_HoaDon] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [F_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [fk_CTHD_P] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [fk_CTHD_P]
GO
ALTER TABLE [dbo].[ChiTietPhieuDatPhong]  WITH CHECK ADD  CONSTRAINT [F_ChiTietPDP_PDP] FOREIGN KEY([maPhieuDat])
REFERENCES [dbo].[PhieuDatPhong] ([maPhieuDat])
GO
ALTER TABLE [dbo].[ChiTietPhieuDatPhong] CHECK CONSTRAINT [F_ChiTietPDP_PDP]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [F_HoaDon_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [F_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [F_HoaDon_KhuyenMai] FOREIGN KEY([maKhuyenMai])
REFERENCES [dbo].[KhuyenMai] ([maKhuyenMai])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [F_HoaDon_KhuyenMai]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [F_HoaDon_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [F_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [F_HoaDon_PhieuDat] FOREIGN KEY([maPhieuDat])
REFERENCES [dbo].[PhieuDatPhong] ([maPhieuDat])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [F_HoaDon_PhieuDat]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [F_NhanVien_LoaiNhanVien] FOREIGN KEY([maLoaiNhanVien])
REFERENCES [dbo].[LoaiNhanVien] ([maLoaiNhanVien])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [F_NhanVien_LoaiNhanVien]
GO
ALTER TABLE [dbo].[PhieuDatPhong]  WITH CHECK ADD  CONSTRAINT [F_PhieuDatPhong_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[PhieuDatPhong] CHECK CONSTRAINT [F_PhieuDatPhong_KhachHang]
GO
ALTER TABLE [dbo].[PhieuDatPhong]  WITH CHECK ADD  CONSTRAINT [F_PhieuDatPhong_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[PhieuDatPhong] CHECK CONSTRAINT [F_PhieuDatPhong_NhanVien]
GO
ALTER TABLE [dbo].[PhieuDatPhong]  WITH CHECK ADD  CONSTRAINT [F_PhieuDatPhong_Phong] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[PhieuDatPhong] CHECK CONSTRAINT [F_PhieuDatPhong_Phong]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [F_Phong_LoaiPhong] FOREIGN KEY([maLoaiPhong])
REFERENCES [dbo].[LoaiPhong] ([maLoaiPhong])
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [F_Phong_LoaiPhong]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [F_Phong_TrangThaiPhong] FOREIGN KEY([maTrangThai])
REFERENCES [dbo].[TrangThaiPhong] ([maTrangThai])
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [F_Phong_TrangThaiPhong]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [F_TaiKhoan_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [F_TaiKhoan_NhanVien]
GO
/****** Object:  StoredProcedure [dbo].[XoaHetDuLieu]    Script Date: 11/22/2023 11:41:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[XoaHetDuLieu]
AS
BEGIN
    -- Xóa dữ liệu từ bảng ThongTinDichVu
    DELETE FROM ThongTinDichVu;

    -- Xóa dữ liệu từ bảng DichVu
    DELETE FROM DichVu;
END;
GO
USE [master]
GO
ALTER DATABASE [SingUrSong_vnew] SET  READ_WRITE 
GO
