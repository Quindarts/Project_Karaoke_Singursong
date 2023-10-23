package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.PhieuDatPhong;
import Entity.Phong;
import Entity.NhanVien;
import Entity.KhachHang;

public class PhieuDatPhong_DAO {

	public PhieuDatPhong_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<PhieuDatPhong> layTatCaPhieuDatPhong() {
		ArrayList<PhieuDatPhong> danhSachPhieuDatPhong = new ArrayList<PhieuDatPhong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM PhieuDatPhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhieuDat = rs.getString("maPhieuDat");
				Phong phong = new Phong(rs.getString("maPhong"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				java.sql.Date thoiGianDatPhong = rs.getDate("thoiGianDatPhong");
				java.sql.Date thoiGianNhanPhong = rs.getDate("thoiGianNhanPhong");
				Double tienCoc = rs.getDouble("tienCoc");
				String trangThai = rs.getString("trangThai");
				String moTa = rs.getString("moTa");
				PhieuDatPhong phieuDatPhong = new PhieuDatPhong(maPhieuDat, phong, nhanVien, khachHang,
						thoiGianDatPhong, thoiGianNhanPhong, tienCoc, trangThai, moTa);
				danhSachPhieuDatPhong.add(phieuDatPhong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachPhieuDatPhong;
	}

	public PhieuDatPhong layPhieuDatPhong_TheoMaPhieuDat(String maPD) {
		PhieuDatPhong phieuDatPhong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM PhieuDatPhong WHERE maPhieuDat = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPD);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maPhieuDat = rs.getString("maPhieuDat");
				Phong phong = new Phong(rs.getString("maPhong"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				java.sql.Date thoiGianDatPhong = rs.getDate("thoiGianDatPhong");
				java.sql.Date thoiGianNhanPhong = rs.getDate("thoiGianNhanPhong");
				Double tienCoc = rs.getDouble("tienCoc");
				String trangThai = rs.getString("trangThai");
				String moTa = rs.getString("moTa");
				phieuDatPhong = new PhieuDatPhong(maPhieuDat, phong, nhanVien, khachHang, thoiGianDatPhong,
						thoiGianNhanPhong, tienCoc, trangThai, moTa);
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
		return phieuDatPhong;
	}

	public PhieuDatPhong layPhieuDatPhong_TheoMaPhong(String maPh) {
		PhieuDatPhong phieuDatPhong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM PhieuDatPhong WHERE maPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPh);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maPhieuDat = rs.getString("maPhieuDat");
				Phong phong = new Phong(rs.getString("maPhong"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				java.sql.Date thoiGianDatPhong = rs.getDate("thoiGianDatPhong");
				java.sql.Date thoiGianNhanPhong = rs.getDate("thoiGianNhanPhong");
				Double tienCoc = rs.getDouble("tienCoc");
				String trangThai = rs.getString("trangThai");
				String moTa = rs.getString("moTa");
				phieuDatPhong = new PhieuDatPhong(maPhieuDat, phong, nhanVien, khachHang, thoiGianDatPhong,
						thoiGianNhanPhong, tienCoc, trangThai, moTa);
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
		return phieuDatPhong;
	}

	public PhieuDatPhong layPhieuDatPhong_TheoMaNhanVien(String maNV) {
		PhieuDatPhong phieuDatPhong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM PhieuDatPhong WHERE maNhanVien = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maNV);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maPhieuDat = rs.getString("maPhieuDat");
				Phong phong = new Phong(rs.getString("maPhong"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				java.sql.Date thoiGianDatPhong = rs.getDate("thoiGianDatPhong");
				java.sql.Date thoiGianNhanPhong = rs.getDate("thoiGianNhanPhong");
				Double tienCoc = rs.getDouble("tienCoc");
				String trangThai = rs.getString("trangThai");
				String moTa = rs.getString("moTa");
				phieuDatPhong = new PhieuDatPhong(maPhieuDat, phong, nhanVien, khachHang, thoiGianDatPhong,
						thoiGianNhanPhong, tienCoc, trangThai, moTa);
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
		return phieuDatPhong;
	}

	public PhieuDatPhong layPhieuDatPhong_TheoMaKhachHang(String maKH) {
		PhieuDatPhong phieuDatPhong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM PhieuDatPhong WHERE maKhachHang = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maKH);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maPhieuDat = rs.getString("maPhieuDat");
				Phong phong = new Phong(rs.getString("maPhong"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				java.sql.Date thoiGianDatPhong = rs.getDate("thoiGianDatPhong");
				java.sql.Date thoiGianNhanPhong = rs.getDate("thoiGianNhanPhong");
				Double tienCoc = rs.getDouble("tienCoc");
				String trangThai = rs.getString("trangThai");
				String moTa = rs.getString("moTa");
				phieuDatPhong = new PhieuDatPhong(maPhieuDat, phong, nhanVien, khachHang, thoiGianDatPhong,
						thoiGianNhanPhong, tienCoc, trangThai, moTa);
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
		return phieuDatPhong;
	}

	public boolean taoPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("INSERT INTO PhieuDatPhong values(?,?,?,?,?,?,?,?,?)");
			statement.setString(1, phieuDatPhong.getMaPhieuDat());
			statement.setString(2, phieuDatPhong.getPhong().getMaPhong());
			statement.setString(3, phieuDatPhong.getNhanVien().getMaNhanVien());
			statement.setString(4, phieuDatPhong.getKhachHang().getMaKhachHang());
			statement.setDate(5, phieuDatPhong.getThoiGianDatPhong());
			statement.setDate(6, phieuDatPhong.getThoiGianNhanPhong());
			statement.setDouble(7, phieuDatPhong.getTienCoc());
			statement.setString(8, phieuDatPhong.getTrangThai());
			statement.setString(9, phieuDatPhong.getMoTa());
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

	public boolean capNhatPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"UPDATE PhieuDatPhong SET  maPhong = ?, maNhanVien = ?, maKhachHang = ?, thoiGianDatPhong = ?, thoiGianNhanPhong = ?, tienCoc = ?, trangThai = ?, moTa = ?"
							+ " WHERE maPhieuDat = ?");
			statement.setString(1, phieuDatPhong.getPhong().getMaPhong());
			statement.setString(2, phieuDatPhong.getNhanVien().getMaNhanVien());
			statement.setString(3, phieuDatPhong.getKhachHang().getMaKhachHang());
			statement.setDate(4, phieuDatPhong.getThoiGianDatPhong());
			statement.setDate(5, phieuDatPhong.getThoiGianNhanPhong());
			statement.setDouble(6, phieuDatPhong.getTienCoc());
			statement.setString(7, phieuDatPhong.getTrangThai());
			statement.setString(8, phieuDatPhong.getMoTa());
			statement.setString(9, phieuDatPhong.getMaPhieuDat());
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

	public boolean xoaPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("DELETE FROM PhieuDatPhong" + " WHERE maPhieuDat = ?");
			statement.setString(1, phieuDatPhong.getMaPhieuDat());
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
