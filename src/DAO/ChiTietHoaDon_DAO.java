package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.ChiTietHoaDon;
import Entity.HoaDon;
import Entity.LoaiNhanVien;
import Entity.NhanVien;
import Entity.Phong;

public class ChiTietHoaDon_DAO {

	public ChiTietHoaDon_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<ChiTietHoaDon> layTatCaChiTietHoaDon() {
		ArrayList<ChiTietHoaDon> danhSachHoaDon = new ArrayList<ChiTietHoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM ChiTietHoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				HoaDon hoaDon = new HoaDon(rs.getString("maHoaDon"));
				Phong phong = new Phong(rs.getString("maPhong"));
				int soGioHat = rs.getInt("soGioHat");
				ChiTietHoaDon ctHoaDon = new ChiTietHoaDon(hoaDon, phong, soGioHat);
				danhSachHoaDon.add(ctHoaDon);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachHoaDon;
	}

	public ChiTietHoaDon timCTHoaDon_TheoMaHoaDon_MaPhong(String maHD, String maPh) {
		ChiTietHoaDon ctHoaDon = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM ChiTietHoaDon WHERE maHoaDon = ? AND maPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maHD);
			statement.setString(2, maPh);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				HoaDon hoaDon = new HoaDon(rs.getString("maHoaDon"));
				Phong phong = new Phong(rs.getString("maPhong"));
				int soGioHat = rs.getInt("soGioHat");
				ctHoaDon = new ChiTietHoaDon(hoaDon, phong, soGioHat);
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
		return ctHoaDon;
	}

	public boolean taoCTHoaDon(ChiTietHoaDon ctHoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("INSERT INTO ChiTietHoaDon values(?,?,?)");
			statement.setString(1, ctHoaDon.getHoaDon().getMaHoaDon());
			statement.setString(2, ctHoaDon.getPhong().getMaPhong());
			statement.setDouble(3, ctHoaDon.getSoGioHat());
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

	public boolean capNhatCTHoaDon(ChiTietHoaDon ctHoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("UPDATE ChiTietHoaDon SET maHoaDon = ?, maPhong = ?, soGioHat = ?"
					+ " WHERE maHoaDon = ? AND maPhong = ?");
			statement.setString(1, ctHoaDon.getHoaDon().getMaHoaDon());
			statement.setString(2, ctHoaDon.getPhong().getMaPhong());
			statement.setDouble(3, ctHoaDon.getSoGioHat());
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

	public boolean xoaCTHoaDon(ChiTietHoaDon ctHoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("DELETE FROM ChiTietHoaDon" + " WHERE maHoaDon = ? AND maPhong = ?");
			statement.setString(1, ctHoaDon.getHoaDon().getMaHoaDon());
			statement.setString(2, ctHoaDon.getPhong().getMaPhong());
			statement.setDouble(3, ctHoaDon.getSoGioHat());
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
