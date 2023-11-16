

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.KhachHang;
import Entity.HoaDon;
import Entity.NhanVien;
import Entity.PhieuDatPhong;
import Entity.KhuyenMai;

public class HoaDon_DAO {

	public HoaDon_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<HoaDon> layTatCaHoaDon() {
		ArrayList<HoaDon> danhSachHoaDon = new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {

				String maHoaDon = rs.getString("maHoaDon");
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				PhieuDatPhong phieuDatPhong = new PhieuDatPhong(rs.getString("maPhieuDat"));
				KhuyenMai khuyenMai = new KhuyenMai(rs.getString("maKhuyenMai"));
				java.sql.Timestamp ngayLap = rs.getTimestamp("ngayLap");
				java.sql.Timestamp thoiGianKetThuc = rs.getTimestamp("thoiGianKetThuc");
				String trangThai = rs.getString("trangThai");
				HoaDon hoaDon = new HoaDon(maHoaDon, khachHang, nhanVien, phieuDatPhong, khuyenMai, ngayLap, trangThai,
						thoiGianKetThuc);
				danhSachHoaDon.add(hoaDon);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachHoaDon;
	}

	public HoaDon layHoaDon_TheoMaHoaDon(String maHD) {
		HoaDon hoaDon = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM HoaDon WHERE maHoaDon = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maHD);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString("maHoaDon");
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				PhieuDatPhong phieuDatPhong = new PhieuDatPhong(rs.getString("maPhieuDat"));
				KhuyenMai khuyenMai = new KhuyenMai(rs.getString("maKhuyenMai"));
				java.sql.Timestamp ngayLap = rs.getTimestamp("ngayLap");
				java.sql.Timestamp thoiGianKetThuc = rs.getTimestamp("thoiGianKetThuc");
				String trangThai = rs.getString("trangThai");
				hoaDon = new HoaDon(maHoaDon, khachHang, nhanVien, phieuDatPhong, khuyenMai, ngayLap, trangThai,
						thoiGianKetThuc);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return hoaDon;
	}

	public HoaDon layHoaDon_TheoMaKhachHang(String maKH) {
		HoaDon hoaDon = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM HoaDon WHERE maKhachHang = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maKH);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString("maHoaDon");
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				PhieuDatPhong phieuDatPhong = new PhieuDatPhong(rs.getString("maPhieuDat"));
				KhuyenMai khuyenMai = new KhuyenMai(rs.getString("maKhuyenMai"));
				java.sql.Timestamp ngayLap = rs.getTimestamp("ngayLap");
				java.sql.Timestamp thoiGianKetThuc = rs.getTimestamp("thoiGianKetThuc");
				String trangThai = rs.getString("trangThai");
				hoaDon = new HoaDon(maHoaDon, khachHang, nhanVien, phieuDatPhong, khuyenMai, ngayLap, trangThai,
						thoiGianKetThuc);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return hoaDon;
	}

	public ArrayList<HoaDon> layHoaDon_TheoNhanVien(String nv) {
		ArrayList<HoaDon> listHD = new ArrayList<HoaDon>();
		HoaDon hoaDon = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT HoaDon.* FROM HoaDon " + "JOIN NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien "
					+ "WHERE NhanVien.hoTen LIKE ? OR NhanVien.soDienThoai LIKE ? OR NhanVien.maNhanVien LIKE ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, "%" + nv + "%");
			statement.setString(2, "%" + nv + "%");
			statement.setString(3, "%" + nv + "%");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString("maHoaDon");
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				PhieuDatPhong phieuDatPhong = new PhieuDatPhong(rs.getString("maPhieuDat"));
				KhuyenMai khuyenMai = new KhuyenMai(rs.getString("maKhuyenMai"));
				java.sql.Timestamp ngayLap = rs.getTimestamp("ngayLap");
				java.sql.Timestamp thoiGianKetThuc = rs.getTimestamp("thoiGianKetThuc");
				String trangThai = rs.getString("trangThai");
				hoaDon = new HoaDon(maHoaDon, khachHang, nhanVien, phieuDatPhong, khuyenMai, ngayLap, trangThai,
						thoiGianKetThuc);
				listHD.add(hoaDon);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return listHD;
	}

	public ArrayList<HoaDon> layHoaDon_TheoKhachHang(String kh) {
		ArrayList<HoaDon> listHD = new ArrayList<HoaDon>();
		HoaDon hoaDon = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT HoaDon.* FROM HoaDon "
					+ "JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang "
					+ "WHERE KhachHang.hoTen LIKE ? OR KhachHang.soDienThoai LIKE ? OR KhachHang.maKhachHang LIKE ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, "%" + kh + "%");
			statement.setString(2, "%" + kh + "%");
			statement.setString(3, "%" + kh + "%");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString("maHoaDon");
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				PhieuDatPhong phieuDatPhong = new PhieuDatPhong(rs.getString("maPhieuDat"));
				KhuyenMai khuyenMai = new KhuyenMai(rs.getString("maKhuyenMai"));
				java.sql.Timestamp ngayLap = rs.getTimestamp("ngayLap");
				java.sql.Timestamp thoiGianKetThuc = rs.getTimestamp("thoiGianKetThuc");
				String trangThai = rs.getString("trangThai");
				hoaDon = new HoaDon(maHoaDon, khachHang, nhanVien, phieuDatPhong, khuyenMai, ngayLap, trangThai,
						thoiGianKetThuc);
				listHD.add(hoaDon);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return listHD;
	}

	public HoaDon layHoaDon_TheoMaNhanVien(String maNV) {
		HoaDon hoaDon = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM HoaDon WHERE maNhanVien = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maNV);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString("maHoaDon");
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				PhieuDatPhong phieuDatPhong = new PhieuDatPhong(rs.getString("maPhieuDat"));
				KhuyenMai khuyenMai = new KhuyenMai(rs.getString("maKhuyenMai"));
				java.sql.Timestamp ngayLap = rs.getTimestamp("ngayLap");
				java.sql.Timestamp thoiGianKetThuc = rs.getTimestamp("thoiGianKetThuc");
				String trangThai = rs.getString("trangThai");
				hoaDon = new HoaDon(maHoaDon, khachHang, nhanVien, phieuDatPhong, khuyenMai, ngayLap, trangThai,
						thoiGianKetThuc);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return hoaDon;
	}

	public HoaDon layHoaDon_DangChoThanhToan(String maPhong) {
		HoaDon hoaDon = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		KhachHang_DAO DAO_KH = new KhachHang_DAO();
		NhanVien_DAO DAO_NV = new NhanVien_DAO();
		
		PreparedStatement statement = null;
		try {
			String sql = " select * from HoaDon \r\n"
					+ "WHERE\r\n"
					+ " trangThai = N'Đang chờ thanh toán'\r\n"
					+ "AND CAST(ngayLap AS DATE) = CAST(GETDATE() AS DATE)\r\n"
					+ "AND ngayLap <= CONVERT(datetime, DATEADD(HOUR, 0, GETDATE()), 100)";
			statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString("maHoaDon");
				KhachHang khachHang =DAO_KH.layKhachHang_TheoMaKhachHang(rs.getString("maKhachHang"));
				NhanVien nhanVien = DAO_NV.timNhanVien_TheoMaNhanVien(rs.getString("maNhanVien"));
				PhieuDatPhong	phieuDatPhong = new PhieuDatPhong(rs.getString("maPhieuDat"));
				KhuyenMai khuyenMai = new KhuyenMai(rs.getString("maKhuyenMai"));
				java.sql.Timestamp ngayLap = rs.getTimestamp("ngayLap");
				java.sql.Timestamp thoiGianKetThuc = rs.getTimestamp("thoiGianKetThuc");
				String trangThai = rs.getString("trangThai");
				hoaDon = new HoaDon(maHoaDon, khachHang, nhanVien, phieuDatPhong, khuyenMai, ngayLap, trangThai,
						thoiGianKetThuc);
				System.out.println(hoaDon);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return hoaDon;
	}

	public HoaDon layHoaDon_TheoMaPhieuDat(String maPhD) {
		HoaDon hoaDon = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM HoaDon WHERE maPhieuDat = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPhD);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString("maHoaDon");
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				PhieuDatPhong phieuDatPhong = new PhieuDatPhong(rs.getString("maPhieuDat"));
				KhuyenMai khuyenMai = new KhuyenMai(rs.getString("maKhuyenMai"));
				java.sql.Timestamp ngayLap = rs.getTimestamp("ngayLap");
				java.sql.Timestamp thoiGianKetThuc = rs.getTimestamp("thoiGianKetThuc");
				String trangThai = rs.getString("trangThai");
				hoaDon = new HoaDon(maHoaDon, khachHang, nhanVien, phieuDatPhong, khuyenMai, ngayLap, trangThai,
						thoiGianKetThuc);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return hoaDon;
	}

	public HoaDon layHoaDon_TheoMaKhuyenMai(String maKhM) {
		HoaDon hoaDon = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM HoaDon WHERE maKhuyenMai = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maKhM);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString("maHoaDon");
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				PhieuDatPhong phieuDatPhong = new PhieuDatPhong(rs.getString("maPhieuDat"));
				KhuyenMai khuyenMai = new KhuyenMai(rs.getString("maKhuyenMai"));
				java.sql.Timestamp ngayLap = rs.getTimestamp("ngayLap");
				java.sql.Timestamp thoiGianKetThuc = rs.getTimestamp("thoiGianKetThuc");
				String trangThai = rs.getString("trangThai");
				hoaDon = new HoaDon(maHoaDon, khachHang, nhanVien, phieuDatPhong, khuyenMai, ngayLap, trangThai,
						thoiGianKetThuc);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return hoaDon;
	}

	public boolean taoHoaDon(HoaDon hoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;

		int n = 0;
		try {
			String maPhieuDat = hoaDon.getPhieuDatPhong() != null ? hoaDon.getPhieuDatPhong().getMaPhieuDat() : null;
			statement = con.prepareStatement("INSERT INTO HoaDon values(?,?,?,?,?,?,?,?)");
			statement.setString(1, hoaDon.getMaHoaDon());
			statement.setString(2, hoaDon.getKhachHang().getMaKhachHang());
			statement.setString(3, hoaDon.getNhanVien().getMaNhanVien());
			statement.setString(4, maPhieuDat);
			statement.setString(5, hoaDon.getKhuyenMai().getMaKhuyenMai());
			statement.setTimestamp(6, hoaDon.getNgayLap());
			statement.setString(7, hoaDon.getTrangThai());
			statement.setTimestamp(8, hoaDon.getThoiGianKetThuc());
			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean capNhatHoaDon(HoaDon hoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String maPhieuDat = hoaDon.getPhieuDatPhong() != null ? hoaDon.getPhieuDatPhong().getMaPhieuDat() : null;
			statement = con.prepareStatement(
					"UPDATE HoaDon SET maKhachHang = ?, maNhanVien = ?, maPhieuDat = ?, maKhuyenMai = ?, ngayLap = ?, trangThai = ?, thoiGianKetThuc = ?"
							+ " WHERE maHoaDon = ? ");
			statement.setString(1, hoaDon.getKhachHang().getMaKhachHang());
			statement.setString(2, hoaDon.getNhanVien().getMaNhanVien());
			statement.setString(3, maPhieuDat);
			statement.setString(4, hoaDon.getKhuyenMai().getMaKhuyenMai());
			statement.setTimestamp(5, hoaDon.getNgayLap());
			statement.setString(6, hoaDon.getTrangThai());
			statement.setTimestamp(7, hoaDon.getThoiGianKetThuc());
			statement.setString(8, hoaDon.getMaHoaDon());
			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean xoaHoaDon(HoaDon hoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("DELETE FROM HoaDon" + "WHERE maHoaDon = ?");
			statement.setString(1, hoaDon.getMaHoaDon());
			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
}
