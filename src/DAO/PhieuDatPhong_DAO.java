package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;

import ConnectDB.ConnectDB;
import Entity.PhieuDatPhong;

import Entity.Phong;
import Entity.NhanVien;
import Entity.KhachHang;

public class PhieuDatPhong_DAO {

//	private PhieuDatPhong phieuDatPhong;

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
				java.sql.Timestamp thoiGianDatPhong = rs.getTimestamp("thoiGianDatPhong");
				java.sql.Timestamp thoiGianNhanPhong = rs.getTimestamp("thoiGianNhanPhong");
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
				java.sql.Timestamp thoiGianDatPhong = rs.getTimestamp("thoiGianDatPhong");
				java.sql.Timestamp thoiGianNhanPhong = rs.getTimestamp("thoiGianNhanPhong");
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
				java.sql.Timestamp thoiGianDatPhong = rs.getTimestamp("thoiGianDatPhong");
				java.sql.Timestamp thoiGianNhanPhong = rs.getTimestamp("thoiGianNhanPhong");
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
				java.sql.Timestamp thoiGianDatPhong = rs.getTimestamp("thoiGianDatPhong");
				java.sql.Timestamp thoiGianNhanPhong = rs.getTimestamp("thoiGianNhanPhong");
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
				java.sql.Timestamp thoiGianDatPhong = rs.getTimestamp("thoiGianDatPhong");
				java.sql.Timestamp thoiGianNhanPhong = rs.getTimestamp("thoiGianNhanPhong");
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

	public ArrayList<PhieuDatPhong> layPhieuDatPhong_TheoTrangThaiPhieu(String ttp) {
		ArrayList<PhieuDatPhong> danhSachPhieuDatPhong = new ArrayList<PhieuDatPhong>();
		PhieuDatPhong phieuDatPhong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM PhieuDatPhong WHERE trangThai = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, ttp);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maPhieuDat = rs.getString("maPhieuDat");
				Phong phong = new Phong(rs.getString("maPhong"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				java.sql.Timestamp thoiGianDatPhong = rs.getTimestamp("thoiGianDatPhong");
				java.sql.Timestamp thoiGianNhanPhong = rs.getTimestamp("thoiGianNhanPhong");
				Double tienCoc = rs.getDouble("tienCoc");
				String trangThai = rs.getString("trangThai");
				String moTa = rs.getString("moTa");
				phieuDatPhong = new PhieuDatPhong(maPhieuDat, phong, nhanVien, khachHang, thoiGianDatPhong,
						thoiGianNhanPhong, tienCoc, trangThai, moTa);
				danhSachPhieuDatPhong.add(phieuDatPhong);
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
		return danhSachPhieuDatPhong;
	}

	public ArrayList<PhieuDatPhong> layPhieuDatPhong_TheoTenKhachHangvsSDT(String tenKH) {
		ArrayList<PhieuDatPhong> danhSachPhieuDatPhong = new ArrayList<PhieuDatPhong>();
		PhieuDatPhong phieuDatPhong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT PhieuDatPhong.* FROM PhieuDatPhong "
					+ "JOIN KhachHang ON PhieuDatPhong.maKhachHang = KhachHang.maKhachHang "
					+ "WHERE KhachHang.hoTen LIKE ? OR KhachHang.soDienThoai LIKE ?";
			;
			statement = con.prepareStatement(sql);
			statement.setString(1, "%" + tenKH + "%");
			statement.setString(2, "%" + tenKH + "%");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maPhieuDat = rs.getString("maPhieuDat");
				Phong phong = new Phong(rs.getString("maPhong"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				java.sql.Timestamp thoiGianDatPhong = rs.getTimestamp("thoiGianDatPhong");
				java.sql.Timestamp thoiGianNhanPhong = rs.getTimestamp("thoiGianNhanPhong");
				Double tienCoc = rs.getDouble("tienCoc");
				String trangThai = rs.getString("trangThai");
				String moTa = rs.getString("moTa");
				phieuDatPhong = new PhieuDatPhong(maPhieuDat, phong, nhanVien, khachHang, thoiGianDatPhong,
						thoiGianNhanPhong, tienCoc, trangThai, moTa);
				danhSachPhieuDatPhong.add(phieuDatPhong);
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
		return danhSachPhieuDatPhong;
	}

	public ArrayList<PhieuDatPhong> layPhieuDatPhong_TheoTenPhong(String tenP) {
		ArrayList<PhieuDatPhong> danhSachPhieuDatPhong = new ArrayList<PhieuDatPhong>();
		PhieuDatPhong phieuDatPhong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT PhieuDatPhong.* FROM PhieuDatPhong "
					+ "JOIN Phong ON PhieuDatPhong.maPhong = Phong.maPhong " + "WHERE Phong.tenPhong LIKE ?";
			;
			statement = con.prepareStatement(sql);
			statement.setString(1, "%" + tenP + "%");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maPhieuDat = rs.getString("maPhieuDat");
				Phong phong = new Phong(rs.getString("maPhong"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				java.sql.Timestamp thoiGianDatPhong = rs.getTimestamp("thoiGianDatPhong");
				java.sql.Timestamp thoiGianNhanPhong = rs.getTimestamp("thoiGianNhanPhong");
				Double tienCoc = rs.getDouble("tienCoc");
				String trangThai = rs.getString("trangThai");
				String moTa = rs.getString("moTa");
				phieuDatPhong = new PhieuDatPhong(maPhieuDat, phong, nhanVien, khachHang, thoiGianDatPhong,
						thoiGianNhanPhong, tienCoc, trangThai, moTa);
				danhSachPhieuDatPhong.add(phieuDatPhong);
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
		return danhSachPhieuDatPhong;
	}
	
	public ArrayList<PhieuDatPhong> layPhieuDatPhong_TheoNgayNhan(String NgayNhan) {
		ArrayList<PhieuDatPhong> danhSachPhieuDatPhong = new ArrayList<PhieuDatPhong>();
		PhieuDatPhong phieuDatPhong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT PhieuDatPhong.* FROM PhieuDatPhong WHERE thoiGianNhanPhong LIKE ?";
			;
			statement = con.prepareStatement(sql);
			statement.setString(1, "%" + NgayNhan + "%");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maPhieuDat = rs.getString("maPhieuDat");
				Phong phong = new Phong(rs.getString("maPhong"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				java.sql.Timestamp thoiGianDatPhong = rs.getTimestamp("thoiGianDatPhong");
				java.sql.Timestamp thoiGianNhanPhong = rs.getTimestamp("thoiGianNhanPhong");
				Double tienCoc = rs.getDouble("tienCoc");
				String trangThai = rs.getString("trangThai");
				String moTa = rs.getString("moTa");
				phieuDatPhong = new PhieuDatPhong(maPhieuDat, phong, nhanVien, khachHang, thoiGianDatPhong,
						thoiGianNhanPhong, tienCoc, trangThai, moTa);
				danhSachPhieuDatPhong.add(phieuDatPhong);
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
		return danhSachPhieuDatPhong;
	}

	public ArrayList<PhieuDatPhong> layPhieuDatPhongTuongDoi_TheoMaPhieuDatPhong(String ma) {
		ArrayList<PhieuDatPhong> danhSachPhieuDatPhong = new ArrayList<PhieuDatPhong>();
		PhieuDatPhong phieuDatPhong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT PhieuDatPhong.* FROM PhieuDatPhong WHERE maPhieuDat LIKE ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, "%" + ma + "%");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maPhieuDat = rs.getString("maPhieuDat");
				Phong phong = new Phong(rs.getString("maPhong"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				java.sql.Timestamp thoiGianDatPhong = rs.getTimestamp("thoiGianDatPhong");
				java.sql.Timestamp thoiGianNhanPhong = rs.getTimestamp("thoiGianNhanPhong");
				Double tienCoc = rs.getDouble("tienCoc");
				String trangThai = rs.getString("trangThai");
				String moTa = rs.getString("moTa");
				phieuDatPhong = new PhieuDatPhong(maPhieuDat, phong, nhanVien, khachHang, thoiGianDatPhong,
						thoiGianNhanPhong, tienCoc, trangThai, moTa);
				danhSachPhieuDatPhong.add(phieuDatPhong);
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
		return danhSachPhieuDatPhong;
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
			statement.setTimestamp(5, phieuDatPhong.getThoiGianDatPhong());
			statement.setTimestamp(6, phieuDatPhong.getThoiGianNhanPhong());
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
			statement.setTimestamp(4, phieuDatPhong.getThoiGianDatPhong());
			statement.setTimestamp(5, phieuDatPhong.getThoiGianNhanPhong());
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
	
	

	public boolean HuyPhieuDatPhong(String maPDP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("UPDATE PhieuDatPhong SET TrangThai = N'Đã hủy' WHERE maPhieuDat = ?");
			statement.setString(1, maPDP);
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
