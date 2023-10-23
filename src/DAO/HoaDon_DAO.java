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
				java.sql.Date ngayLap = rs.getDate("ngayLap");
				java.sql.Date thoiGianKetThuc = rs.getDate("thoiGianKetThuc");
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
				java.sql.Date ngayLap = rs.getDate("ngayLap");
				java.sql.Date thoiGianKetThuc = rs.getDate("thoiGianKetThuc");
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
				java.sql.Date ngayLap = rs.getDate("ngayLap");
				java.sql.Date thoiGianKetThuc = rs.getDate("thoiGianKetThuc");
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
				java.sql.Date ngayLap = rs.getDate("ngayLap");
				java.sql.Date thoiGianKetThuc = rs.getDate("thoiGianKetThuc");
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
				java.sql.Date ngayLap = rs.getDate("ngayLap");
				java.sql.Date thoiGianKetThuc = rs.getDate("thoiGianKetThuc");
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
				java.sql.Date ngayLap = rs.getDate("ngayLap");
				java.sql.Date thoiGianKetThuc = rs.getDate("thoiGianKetThuc");
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
			statement = con.prepareStatement("INSERT INTO HoaDon values(?,?,?,?,?,?,?,?)");
			statement.setString(1, hoaDon.getMaHoaDon());
			statement.setString(2, hoaDon.getKhachHang().getMaKhachHang());
			statement.setString(3, hoaDon.getNhanVien().getMaNhanVien());
			statement.setString(4, hoaDon.getPhieuDatPhong().getMaPhieuDat());
			statement.setString(5, hoaDon.getKhuyenMai().getMaKhuyenMai());
			statement.setDate(6, hoaDon.getNgayLap());
			statement.setString(7, hoaDon.getTrangThai());
			statement.setDate(8, hoaDon.getThoiGianKetThuc());
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
			statement = con.prepareStatement(
					"UPDATE HoaDon SET maKhachHang = ?, maNhanVien = ?, maPhieuDat = ?, maKhuyenMai = ?, ngayLap = ?, trangThai = ?, thoiGianKetThuc = ?"
							+ " WHERE maHoaDon = ? ");		
			statement.setString(1, hoaDon.getKhachHang().getMaKhachHang());
			statement.setString(2, hoaDon.getNhanVien().getMaNhanVien());
			statement.setString(3, hoaDon.getPhieuDatPhong().getMaPhieuDat());
			statement.setString(4, hoaDon.getKhuyenMai().getMaKhuyenMai());
			statement.setDate(5, hoaDon.getNgayLap());
			statement.setString(6, hoaDon.getTrangThai());
			statement.setDate(7, hoaDon.getThoiGianKetThuc());
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
			statement = con.prepareStatement(
					"DELETE FROM HoaDon" + "WHERE maHoaDon = ?");
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
