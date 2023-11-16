package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
			String sql = "SELECT * FROM PhieuDatPhong ORDER BY thoiGianNhanPhong";
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

	/**
	 * Tìm những phiếu đặt phòng thỏa thông tin truyền vào dưới đây
	 *
	 * @param tenPhong:     tên phòng
	 * @param tenKhachHang: tên khách hàng
	 * @param trangThai:    trạng thái
	 * @param ngayDat:      ngày đặt
	 * @return danh sách phiếu đặt phòng
	 */
	public ArrayList<PhieuDatPhong> timDSPhieuDatPhongByAllProperty(String maPhong, String maKhachHang,
			String trangThai, String ngayDat) {
		ArrayList<PhieuDatPhong> danhSachPhieuDatPhong = new ArrayList<PhieuDatPhong>();
		PhieuDatPhong phieuDatPhong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		String sql;
		if (ngayDat == null) {
			sql = "SELECT PhieuDatPhong.* FROM KhachHang JOIN PhieuDatPhong ON KhachHang.maKhachHang = PhieuDatPhong.maKhachHang JOIN Phong ON PhieuDatPhong.maPhong = Phong.maPhong \n"
					+ "where Phong.maPhong like '%" + maPhong + "%' and KhachHang.maKhachHang like N'%" + maKhachHang
					+ "%' and PhieuDatPhong.trangThai like '%" + trangThai + "%'" + "order by PhieuDatPhong.maPhieuDat";
		} else {
			sql = "SELECT PhieuDatPhong.* FROM KhachHang JOIN PhieuDatPhong ON KhachHang.maKhachHang = PhieuDatPhong.maKhachHang JOIN Phong ON PhieuDatPhong.maPhong = Phong.maPhong \n"
					+ "where Phong.maPhong like '%" + maPhong + "%' and KhachHang.maKhachHang like N'%" + maKhachHang
					+ "%' and PhieuDatPhong.trangThai like '%" + trangThai
					+ "%' and CONVERT(dateTime, thoiGianDatPhong) = CONVERT(dateTime, '" + ngayDat + "') "
					+ "order by PhieuDatPhong.maPhieuDat";
		}
		try {
			statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				String maPhieuDat = rs.getString("maPhieuDat");
				Phong phong = new Phong(rs.getString("maPhong"));
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
				java.sql.Timestamp thoiGianDatPhong = rs.getTimestamp("thoiGianDatPhong");
				java.sql.Timestamp thoiGianNhanPhong = rs.getTimestamp("thoiGianNhanPhong");
				Double tienCoc = rs.getDouble("tienCoc");
				String trangThai1 = rs.getString("trangThai");
				String moTa = rs.getString("moTa");
				phieuDatPhong = new PhieuDatPhong(maPhieuDat, phong, nhanVien, khachHang, thoiGianDatPhong,
						thoiGianNhanPhong, tienCoc, trangThai1, moTa);
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

	@SuppressWarnings("deprecation")
	public ArrayList<PhieuDatPhong> layPhieuDatPhong_TheoNgayNhan(java.util.Date ngayNhan) {
		ArrayList<PhieuDatPhong> danhSachPhieuDatPhong = new ArrayList<PhieuDatPhong>();
		PhieuDatPhong phieuDatPhong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT PhieuDatPhong.* FROM PhieuDatPhong WHERE CONVERT(date, thoiGianNhanPhong) = ?";

			statement = con.prepareStatement(sql);
			statement.setDate(1, (Date) ngayNhan);
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

	public ArrayList<PhieuDatPhong> layPhieuDatPhongNgayHienTai() {
		ArrayList<PhieuDatPhong> danhSachPhieuDatPhong = new ArrayList<PhieuDatPhong>();
		PhieuDatPhong phieuDatPhong = null;
		// Lấy ngày hiện tại
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String currentDateString = dateFormat.format(currentDate);

		System.out.println(currentDate);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT PhieuDatPhong.* FROM PhieuDatPhong WHERE CONVERT(DATE, thoiGianNhanPhong) = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, currentDateString);
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
	
	public PhieuDatPhong layThongTinPhieuDatTrangThai_DangCho_MaPhong(String maP) {
		PhieuDatPhong phieuDatPhong = null;
		
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "select * from PhieuDatPhong PD\r\n"
				+ "JOIN Phong P  ON P.maPhong = PD.maPhong\r\n"
				+ "WHERE \r\n"
				+ "	  P.maPhong = '"+maP+"'\r\n"
				+ "	  AND\r\n"
				+ "      CAST(PD.thoiGianNhanPhong AS DATE) = CAST(GETDATE() AS DATE)\r\n"
				+ "      AND PD.trangThai = N'Chờ nhận phòng'\r\n"
				+ "      AND PD.thoiGianNhanPhong >= CONVERT(datetime, DATEADD(HOUR, 0, GETDATE()), 100)\r\n"

				;

		try {
			System.out.println(sql);
			statement = con.prepareStatement(sql);
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
	
	public boolean capNhatPhieuDatTrangThai_DaNhanPhong_MaPhieuDat(String maPhieuDat) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		String sql = "UPDATE PhieuDatPhong\r\n" + "Set trangThai = N'Đã nhận phòng'\r\n" + "WHERE\r\n"
				+ "tienCoc > 0\r\n" + "AND\r\n" + "maPhieuDat = '" + maPhieuDat + " '\r\n" + "AND \r\n"
				+ "trangThai=N'Chờ nhận phòng'\r\n" + "AND\r\n"
				+ "CAST(thoiGianNhanPhong AS DATE) = CAST(GETDATE() AS DATE)\r\n" + "AND\r\n"
				+ "DATEADD(hour, 0, GETDATE()) <= thoiGianNhanPhong\r\n" + "AND\r\n"
				+ "DATEDIFF(hour, thoiGianNhanPhong, GETDATE()) <= 1";
		try {
			statement = con.prepareStatement(sql);
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

	public boolean capNhatTrangThaiPhieu(PhieuDatPhong phieuDatPhong) {
		Connection con = ConnectDB.getConnection();
		int n = 0;

		// Lấy thời gian hiện tại
		java.util.Date utilDate = new java.util.Date();

		// Chuyển đổi ngày từ java.util.Date thành java.sql.Date
		Date sqlDate = new Date(utilDate.getTime());

		// Tính toán thời gian trễ 1 giờ
		Calendar cal = Calendar.getInstance();
		cal.setTime(sqlDate);
		cal.add(Calendar.HOUR, -1);
		java.util.Date lateTime = (java.util.Date) cal.getTime();

		// Chuyển thời gian trễ thành Timestamp
		Timestamp lateTimestamp = new Timestamp(lateTime.getTime());
		System.out.println(lateTimestamp);

		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement("UPDATE PhieuDatPhong SET trangThai = ? WHERE thoiGianNhanPhong >= ?");
			statement.setString(1, "Hết hạn"); // Đặt trạng thái thành "Hết hạn"
			statement.setTimestamp(2, lateTimestamp);

			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
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
