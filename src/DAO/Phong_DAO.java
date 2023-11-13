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

	public Phong timPhong_TheoMaPhong(String maPh) {
		Phong phong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM Phong WHERE maPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPh);
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
	public ArrayList<Phong> timDSPhongTheoMaLoaiPhong(String maLP) {
		Phong phong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;

		ArrayList<Phong> dsPhong = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Phong WHERE maLoaiPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maLP);
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
