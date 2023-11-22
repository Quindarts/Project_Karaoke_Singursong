package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import Entity.DichVu;
import Entity.ThongTinDichVu;

public class DichVu_DAO {

	public DichVu_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int soLuongDichVu() {
		Connection con = new ConnectDB().getConnection();
		int dem = 0;
		try {
			PreparedStatement statement = con.prepareStatement("select count(maDichVu) as Dem from DichVu");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				dem = rs.getInt("Dem");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dem;
	}

	public ArrayList<DichVu> phanTrangDichVu(int fn, int ln) {
		Connection con = new ConnectDB().getConnection();
		ArrayList<DichVu> list = new ArrayList<DichVu>();
		PreparedStatement statement = null;

		String sql = "select *from(select ROW_NUMBER() over (order by maDichVu)as STT,maDichVu,tenDichVu,donViTinh,donGia,trangThai,maThongTinDichVu from DichVu) as PhanTrang where PhanTrang.STT Between ? and ?";

		try {
			statement = con.prepareStatement(sql);
			statement.setInt(1, fn);
			statement.setInt(2, ln);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				String maDichVu = rs.getString("maDichVu");
				String tenDichVu = rs.getString("tenDichVu");
				String donViTinh = rs.getString("donViTinh");
				Double donGia = rs.getDouble("donGia");
				boolean trangThai = rs.getBoolean("trangThai");
				String maTTDV = rs.getString("maThongTinDichVu");

				ThongTinDichVu_DAO DAO_TTDV = new ThongTinDichVu_DAO();
				ThongTinDichVu ttdv = new ThongTinDichVu();
				ttdv = DAO_TTDV.timThongTinDichVu_TheoMaThongTinDichVu(rs.getString("maThongTinDichVu"));

				DichVu dichVu = new DichVu(maDichVu, tenDichVu, donViTinh, donGia, trangThai, ttdv);
				list.add(dichVu);
			}
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return list;

	}

	public ArrayList<DichVu> layTatCaDichVu() {
		ArrayList<DichVu> danhSachDichVu = new ArrayList<DichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM DichVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDichVu = rs.getString("maDichVu");
				String tenDichVu = rs.getString("tenDichVu");
				String donViTinh = rs.getString("donViTinh");
				Double donGia = rs.getDouble("donGia");
				boolean trangThai = rs.getBoolean("trangThai");
				String maTTDV = rs.getString("maThongTinDichVu");
				ThongTinDichVu_DAO DAO_TTDV = new ThongTinDichVu_DAO();
				ThongTinDichVu ttdv = DAO_TTDV.timThongTinDichVu_TheoMaThongTinDichVu(maTTDV);

				DichVu dichVu = new DichVu(maDichVu, tenDichVu, donViTinh, donGia, trangThai, ttdv);
				danhSachDichVu.add(dichVu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachDichVu;
	}

	public DichVu layDichVu_TheoMaDichVu(String maDV) {
		DichVu dichVu = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM DichVu WHERE maDichVu = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maDV);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maDichVu = rs.getString("maDichVu");
				String tenDichVu = rs.getString("tenDichVu");
				String donViTinh = rs.getString("donViTinh");
				Double donGia = rs.getDouble("donGia");
				boolean trangThai = rs.getBoolean("trangThai");
				String maTTDV = rs.getString("maThongTinDichVu");
				ThongTinDichVu_DAO DAO_TTDV = new ThongTinDichVu_DAO();
				ThongTinDichVu ttdv = DAO_TTDV.timThongTinDichVu_TheoMaThongTinDichVu(maTTDV);

				dichVu = new DichVu(maDichVu, tenDichVu, donViTinh, donGia, trangThai, ttdv);
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
		return dichVu;
	}

	public boolean taoDichVu(DichVu dichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("INSERT INTO DichVu values(?,?,?,?,?,?)");
			statement.setString(1, dichVu.getMaDichVu());
			statement.setString(2, dichVu.getTenDichVu());
			statement.setString(3, dichVu.getDonViTinh());
			statement.setDouble(4, dichVu.getDonGia());
			statement.setBoolean(5, dichVu.getTrangThai());
			statement.setString(6, dichVu.getThongTinDichVu().getMaThongTinDichVu());
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

	public int capNhatDichVu(DichVu dichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"UPDATE DichVu SET tenDichVu = ?, soLuong = ?, donViTinh = ?, donGia = ?, trangThai = ?, maThongTinDichVu = ?"
							+ " WHERE maDichVu = ?");
			statement.setString(1, dichVu.getTenDichVu());
			statement.setString(2, dichVu.getDonViTinh());
			statement.setDouble(3, dichVu.getDonGia());
			statement.setBoolean(4, dichVu.getTrangThai());
			statement.setString(5, dichVu.getMaDichVu());
			statement.setString(6, dichVu.getThongTinDichVu().getMaThongTinDichVu());

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

		return n;
	}

	public boolean xoaDichVu(DichVu dichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("DELETE FROM DichVu" + " WHERE maDichVu = ?");
			statement.setString(1, dichVu.getMaDichVu());
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
