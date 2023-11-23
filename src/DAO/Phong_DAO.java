package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import Entity.Phong;
import Entity.DichVu;
import Entity.LoaiPhong;
import Entity.TrangThaiPhong;

public class Phong_DAO {

	public Phong_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Phong> layTatCaPhong() {
		ArrayList<Phong> danhSachPhong = new ArrayList<Phong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM Phong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {

				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong"));

				TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThai"));
				java.sql.Date ngayTaoPhong = rs.getDate("ngayTaoPhong");
				String viTriPhong = rs.getString("viTriPhong");
				String ghiChu = rs.getString("ghiChu");
				String tinhTrangPhong = rs.getString("tinhTrangPhong");
				Phong phong = new Phong(maPhong, tenPhong, loaiPhong, trangThaiPhong, ngayTaoPhong, viTriPhong, ghiChu,
						tinhTrangPhong);

				danhSachPhong.add(phong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachPhong;
	}

	public boolean capNhatTatCaPhong_TrangThaiPhongMoiNhat() {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		String sql = "--- B1: cập nhật PDP hết hạn\r\n" + "UPDATE PhieuDatPhong\r\n" + "SET trangThai = N'Hết hạn'\r\n"
				+ "WHERE \r\n" + "thoiGianNhanPhong < GETDATE()\r\n" + "AND trangThai =  N'Chờ nhận phòng'\r\n"
				+ "--- B2: cập nhật  trạng thái Hóa đơn = đã hủy\r\n" + "\r\n" + "UPDATE HoaDon \r\n"
				+ "SET trangThai = N'Đã hủy'\r\n" + "FROM HoaDon\r\n" + "WHERE \r\n"
				+ "CONVERT(date, HoaDon.ngayLap) < CONVERT(date, GETDATE())\r\n" + "AND\r\n"
				+ "trangThai = N'Đang chờ thanh toán';\r\n"
				+ "--- B2.2: cập nhật trạng thái phòng trống cho phiếu đặt = hết hạn, hóa đơn = đã thanh toán\r\n"
				+ "UPDATE Phong\r\n" + "SET maTrangThai = 'VC'\r\n" + "FROM Phong\r\n"
				+ "INNER JOIN ChiTietHoaDon ON Phong.maPhong = ChiTietHoaDon.maPhong\r\n"
				+ "INNER JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon\r\n"
				+ "INNER JOIN PhieuDatPhong ON Phong.maPhong = PhieuDatPhong.maPhong\r\n" + "WHERE \r\n"
				+ "HoaDon.trangThai = N'Đã thanh toán'\r\n" + "OR\r\n" + "HoaDon.trangThai = N'Đã hủy'\r\n" + "OR\r\n"
				+ "PhieuDatPhong.trangThai = N'Hết hạn'\r\n" + "select * from Phong\r\n" + ";\r\n"
				+ "--- B3: cập nhật trạng thái phòng đã đặt\r\n" + "UPDATE Phong\r\n" + "SET maTrangThai = 'OCP'\r\n"
				+ "FROM Phong\r\n" + "INNER JOIN PhieuDatPhong ON Phong.maPhong = PhieuDatPhong.maPhong\r\n"
				+ "WHERE\r\n"
				+ " ABS( DATEDIFF(SECOND, PhieuDatPhong.thoiGianNhanPhong, cast(GETDATE() as dateTime))) <= 3600\r\n"
				+ "AND PhieuDatPhong.trangThai = N'Chờ nhận phòng'\r\n"
				+ "AND CONVERT(date, PhieuDatPhong.thoiGianNhanPhong) = CONVERT(date, GETDATE());\r\n" + "\r\n"
				+ "--- B4: cập nhật trạng thái phòng đang sử dụng\r\n" + "UPDATE Phong\r\n"
				+ "SET maTrangThai = 'OC'\r\n" + "FROM Phong\r\n"
				+ "INNER JOIN ChiTietHoaDon ON Phong.maPhong = ChiTietHoaDon.maPhong\r\n"
				+ "INNER JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon\r\n"
				+ "WHERE CONVERT(date, HoaDon.ngayLap) = CONVERT(date, GETDATE())\r\n"
				+ "AND HoaDon.trangThai = N'Đang chờ thanh toán';\r\n" + "\r\n"
				+ "--- B5: cập nhật trạng thái phòng đang trống\r\n" + "UPDATE Phong\r\n" + "SET maTrangThai = 'VC'\r\n"
				+ "FROM Phong\r\n" + "INNER JOIN ChiTietHoaDon ON Phong.maPhong = ChiTietHoaDon.maPhong\r\n"
				+ "INNER JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon\r\n"
				+ "INNER JOIN PhieuDatPhong ON Phong.maPhong = PhieuDatPhong.maPhong\r\n" + "WHERE \r\n"
				+ "maTrangThai <> 'OOO'\r\n" + "AND\r\n" + "maTrangThai <> 'OCP'\r\n" + "AND\r\n"
				+ "maTrangThai <> 'OC'\r\n" + ";";

		try {
			statement = con.prepareStatement(sql);
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

	public ArrayList<Phong> timPhong_TheoTongHop(String tenLoaiPhong, String tenKhachHang, String soDienThoai,
			String tenTrangThai, String maPhongTK) {

		ArrayList<Phong> dsPhong = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sqlTenLoaiPhong = "";
		
		if (tenLoaiPhong.trim().equals("Tất cả"))
			sqlTenLoaiPhong = "LoaiPhong.tenLoaiPhong Like N'%%'";
		else {
			sqlTenLoaiPhong = "LoaiPhong.tenLoaiPhong = N'" + tenLoaiPhong + "' \r\n";
		}
		String sqlTenKhachHang = "KhachHang.hoTen Like N'%" + tenKhachHang + "%'\r\n";
		String sqlSoDienThoai = "KhachHang.soDienThoai LIKE '%" + soDienThoai + "%'";
		String sqlTenTrangThai = "TrangThaiPhong.tenTrangThai =N'" + tenTrangThai + "'\r\n";
		String sqlMaPhong = "Phong.maPhong LIKE '%" + maPhongTK + "%'";

		String sqlAND = "AND\r\n";
		String sqlTop1 = "TOP 1";
		String sqlWhere = "\n where \n";
		String sqlJoinLoaiP = "INNER JOIN LoaiPhong ON LoaiPhong.maLoaiPhong = Phong.maLoaiPhong\r\n";
		String sqlJoinTrangThaiP = "INNER JOIN TrangThaiPhong ON TrangThaiPhong.maTrangThai = Phong.maTrangThai\r\n";

		String sqlJoinPhieuDat = "INNER JOIN PhieuDatPhong ON Phong.maPhong = PhieuDatPhong.maPhong\r\n";

		String sqlJoinKhachHangPDP = "INNER JOIN KhachHang ON KhachHang.maKhachHang = PhieuDatPhong.maKhachHang\r\n";
		String sqlJoinKhachHangHD = "INNER JOIN KhachHang ON KhachHang.maKhachHang = HoaDon.maKhachHang\r\n";

		String sqlJoinCTHoaDon = "INNER JOIN ChiTietHoaDon ON Phong.maPhong = ChiTietHoaDon.maPhong\r\n";
		String sqlJoinHoaDon = "INNER JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon\r\n";

		//////////////////////////////////////////////////////////////////////////////////////////////////////
		String sqlTongHop = "select * from Phong\r\n";
		String sqlPhongTrong = "select * from Phong\r\n"
				+ "INNER JOIN LoaiPhong ON LoaiPhong.maLoaiPhong = Phong.maLoaiPhong\r\n"
				+ "INNER JOIN TrangThaiPhong ON TrangThaiPhong.maTrangThai = Phong.maTrangThai\r\n" + "where\r\n"
				+ sqlTenLoaiPhong + sqlAND + "TrangThaiPhong.tenTrangThai =N'Trống'\r\n" + sqlAND
				+ "Phong.maPhong LIKE '%P%'";

		if (tenTrangThai.trim().equals("Trống")) {

			sqlTongHop = sqlTongHop + sqlJoinLoaiP + sqlJoinTrangThaiP + sqlWhere + sqlTenLoaiPhong + sqlAND
					+ sqlTenTrangThai + sqlAND + sqlMaPhong;
		}
		if (tenTrangThai.trim().equals("Đã đặt")) {
			sqlTongHop = sqlTongHop + sqlJoinLoaiP + sqlJoinTrangThaiP + sqlJoinPhieuDat + sqlJoinKhachHangPDP
					+ sqlWhere + sqlTenLoaiPhong + sqlAND + sqlTenTrangThai + sqlAND + sqlMaPhong + sqlAND
					+ sqlTenKhachHang + sqlAND + sqlSoDienThoai + sqlAND
					+ "ABS( DATEDIFF(SECOND, PhieuDatPhong.thoiGianNhanPhong, cast(GETDATE() as dateTime))) <= 3600";
		}
		if (tenTrangThai.trim().equals("Đang sử dụng")) {

			sqlTongHop = "";
			sqlTongHop = "select * from Phong \n" + sqlJoinLoaiP + sqlJoinTrangThaiP + sqlJoinCTHoaDon
					+ sqlJoinHoaDon + sqlJoinKhachHangHD + sqlWhere + sqlTenLoaiPhong + sqlAND + sqlTenTrangThai
					+ sqlAND + sqlMaPhong + sqlAND + sqlTenKhachHang + sqlAND + sqlSoDienThoai + sqlAND
					+ "(HoaDon.trangThai = N'Đang chờ thanh toán' AND HoaDon.maKhachHang = KhachHang.maKhachHang) \n"
					+ sqlAND
					+ "CONVERT(date, HoaDon.ngayLap) = CONVERT(date, GETDATE())";
		}

		try {
			System.out.println(sqlTongHop);
			PreparedStatement statement = con.prepareStatement(sqlTongHop);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong1 = rs.getString("tenPhong");
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong"));
				TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThai"));
				java.sql.Date ngayTaoPhong = rs.getDate("ngayTaoPhong");
				String viTriPhong = rs.getString("viTriPhong");
				String ghiChu = rs.getString("ghiChu");
				String tinhTrangPhong = rs.getString("tinhTrangPhong");

				Phong phong = new Phong(maPhong, tenPhong1, loaiPhong, trangThaiPhong, ngayTaoPhong, viTriPhong, ghiChu,
						tinhTrangPhong);

				dsPhong.add(phong);
			}
		} catch (SQLException e) {

		}
		return dsPhong;
	}

	public Phong timPhong_TheoMaPhong(String maPh) {
		Phong phong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		LoaiPhong_DAO DAO_LP = new LoaiPhong_DAO();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM Phong WHERE maPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPh);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				LoaiPhong loaiPhong = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(rs.getString("maLoaiPhong"));
				TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThai"));
				java.sql.Date ngayTaoPhong = rs.getDate("ngayTaoPhong");
				String viTriPhong = rs.getString("viTriPhong");
				String ghiChu = rs.getString("ghiChu");
				String tinhTrangPhong = rs.getString("tinhTrangPhong");
				phong = new Phong(maPhong, tenPhong, loaiPhong, trangThaiPhong, ngayTaoPhong, viTriPhong, ghiChu,
						tinhTrangPhong);

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
		return phong;
	}

	public ArrayList<Phong> timDSPhongTheoMaLoaiPhong(String maLP) {
		Phong phong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;

		ArrayList<Phong> dsPhong = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Phong WHERE maLoaiPhong LIKE '%"+maLP+"%'";
			statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong"));
				TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThai"));
				java.sql.Date ngayTaoPhong = rs.getDate("ngayTaoPhong");
				String viTriPhong = rs.getString("viTriPhong");
				String ghiChu = rs.getString("ghiChu");
				String tinhTrangPhong = rs.getString("tinhTrangPhong");
				phong = new Phong(maPhong, tenPhong, loaiPhong, trangThaiPhong, ngayTaoPhong, viTriPhong, ghiChu,
						tinhTrangPhong);
				dsPhong.add(phong);
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
		return dsPhong;
	}

	public Phong timPhong_TheoMaLoaiPhong(String maLoaiPh) {
		Phong phong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM Phong WHERE maLoaiPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maLoaiPh);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong"));
				TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThai"));
				java.sql.Date ngayTaoPhong = rs.getDate("ngayTaoPhong");
				String viTriPhong = rs.getString("viTriPhong");
				String ghiChu = rs.getString("ghiChu");
				String tinhTrangPhong = rs.getString("tinhTrangPhong");
				phong = new Phong(maPhong, tenPhong, loaiPhong, trangThaiPhong, ngayTaoPhong, viTriPhong, ghiChu,
						tinhTrangPhong);
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
		return phong;
	}

	public ArrayList<Phong> timPhong_TheoMaTrangThai(String maTrThai) {
		ArrayList<Phong> listP = new ArrayList<Phong>();
		Phong phong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM Phong WHERE maTrangThai = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maTrThai);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong"));
				TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThai"));
				java.sql.Date ngayTaoPhong = rs.getDate("ngayTaoPhong");
				String viTriPhong = rs.getString("viTriPhong");
				String ghiChu = rs.getString("ghiChu");
				String tinhTrangPhong = rs.getString("tinhTrangPhong");
				phong = new Phong(maPhong, tenPhong, loaiPhong, trangThaiPhong, ngayTaoPhong, viTriPhong, ghiChu,
						tinhTrangPhong);
				listP.add(phong);
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
		return listP;
	}

	public boolean taoPhong(Phong phong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("INSERT INTO Phong values(?,?,?,?,?,?,?,?)");
			statement.setString(1, phong.getMaPhong());
			statement.setString(2, phong.getTenPhong());
			statement.setString(3, phong.getLoaiPhong().getMaLoaiPhong());
			statement.setString(4, phong.getTrangThaiPhong().getMaTrangThai());
			statement.setDate(5, phong.getNgayTaoPhong());
			statement.setString(6, phong.getViTriPhong());
			statement.setString(7, phong.getGhiChu());
			statement.setString(8, phong.getTinhTrangPhong());
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

	public boolean capNhatPhong(Phong phong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"UPDATE Phong SET tenPhong=?, maLoaiPhong=?, maTrangThai=?, ngayTaoPhong = ? , viTriPhong=?, ghiChu=?, tinhTrangPhong=?"
							+ " WHERE maPhong=?");
			statement.setString(1, phong.getTenPhong());
			statement.setString(2, phong.getLoaiPhong().getMaLoaiPhong());
			statement.setString(3, phong.getTrangThaiPhong().getMaTrangThai());
			statement.setDate(4, phong.getNgayTaoPhong());
			statement.setString(5, phong.getViTriPhong());
			statement.setString(6, phong.getGhiChu());
			statement.setString(7, phong.getTinhTrangPhong());
			statement.setString(8, phong.getMaPhong());
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

	public boolean capNhat_TranThaiPhong(String maPh, String trThPh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("UPDATE Phong SET maTrangThai=? " + " WHERE maPhong=?");
			statement.setString(2, maPh);
			statement.setString(1, trThPh);

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

	public boolean xoaPhong(Phong phong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("DELETE FROM Phong" + " WHERE maPhong=?");
			statement.setString(1, phong.getMaPhong());
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

	public List<Phong> layDanhSachPhongTrongTheoNgayVaLoaiPhong(Timestamp startTime, Timestamp endTime, String lp) {
		List<Phong> danhSachPhong = new ArrayList<Phong>();
		PreparedStatement statement = null;
		System.out.println(startTime);
		System.out.println(endTime);
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM Phong WHERE maLoaiPhong = ? AND maPhong NOT IN "
					+ "(SELECT maPhong FROM PhieuDatPhong " + "WHERE thoiGianNhanPhong BETWEEN ? AND ?)";

			statement = con.prepareStatement(sql);
			statement.setString(1, lp);
			statement.setTimestamp(2, startTime);
			statement.setTimestamp(3, endTime);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong"));

				TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThai"));
				java.sql.Date ngayTaoPhong = rs.getDate("ngayTaoPhong");
				String viTriPhong = rs.getString("viTriPhong");
				String ghiChu = rs.getString("ghiChu");
				String tinhTrangPhong = rs.getString("tinhTrangPhong");
				Phong phong = new Phong(maPhong, tenPhong, loaiPhong, trangThaiPhong, ngayTaoPhong, viTriPhong, ghiChu,
						tinhTrangPhong);

				danhSachPhong.add(phong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return danhSachPhong;

	}

	public List<Phong> layDanhSachPhongTheoTrangThai(TrangThaiPhong trangThai) {
		List<Phong> danhSachPhong = new ArrayList<Phong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Phong where trangThai = '" + trangThai;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {

				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong"));

				TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThai"));
				java.sql.Date ngayTaoPhong = rs.getDate("ngayTaoPhong");
				String viTriPhong = rs.getString("viTriPhong");
				String ghiChu = rs.getString("ghiChu");
				String tinhTrangPhong = rs.getString("tinhTrangPhong");
				Phong phong = new Phong(maPhong, tenPhong, loaiPhong, trangThaiPhong, ngayTaoPhong, viTriPhong, ghiChu,
						tinhTrangPhong);

				danhSachPhong.add(phong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachPhong;
	}

	public int soLuongPhongtheoTrangThaiPhong(TrangThaiPhong trangThai) {
		Connection con = new ConnectDB().getConnection();
		int dem = 0;
		String sql = "select count(*) from Phong where trangThai = '" + trangThai + "'";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				dem = rs.getInt("Dem");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dem;
	}

	public int soLuongPhong() {
		Connection con = new ConnectDB().getConnection();
		int dem = 0;
		try {
			PreparedStatement statement = con.prepareStatement("select count(maPhong) as Dem from Phong");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				dem = rs.getInt("Dem");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dem;
	}

	public ArrayList<Phong> phanTrangPhong(int fn, int ln) {
		Connection con = new ConnectDB().getConnection();
		ArrayList<Phong> danhSachPhong = new ArrayList<Phong>();
		PreparedStatement statement = null;

		String sql = "select *from(select ROW_NUMBER() over (order by maPhong)as STT,maPhong,tenPhong,maLoaiPhong,maTrangThai,ngayTaoPhong,viTriPhong,ghiChu,tinhTrangPhong from Phong) as PhanTrang where PhanTrang.STT Between ? and ?";

		try {
			statement = con.prepareStatement(sql);
			statement.setInt(1, fn);
			statement.setInt(2, ln);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong"));

				TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThai"));
				java.sql.Date ngayTaoPhong = rs.getDate("ngayTaoPhong");
				String viTriPhong = rs.getString("viTriPhong");
				String ghiChu = rs.getString("ghiChu");
				String tinhTrangPhong = rs.getString("tinhTrangPhong");
				Phong phong = new Phong(maPhong, tenPhong, loaiPhong, trangThaiPhong, ngayTaoPhong, viTriPhong, ghiChu,
						tinhTrangPhong);

				danhSachPhong.add(phong);
			}
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return danhSachPhong;

	}

	public ArrayList<Phong> timPhongTheoLau(String floor) {
		Phong phong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;

		ArrayList<Phong> dsPhong = new ArrayList<>();

		try {
			String sql = "SELECT * FROM phong WHERE viTriPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, floor);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong"));
				TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThai"));
				java.sql.Date ngayTaoPhong = rs.getDate("ngayTaoPhong");
				String viTriPhong = rs.getString("viTriPhong");
				String ghiChu = rs.getString("ghiChu");
				String tinhTrangPhong = rs.getString("tinhTrangPhong");
				phong = new Phong(maPhong, tenPhong, loaiPhong, trangThaiPhong, ngayTaoPhong, viTriPhong, ghiChu,
						tinhTrangPhong);
				dsPhong.add(phong);
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
		return dsPhong;
	}

}
