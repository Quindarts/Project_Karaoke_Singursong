package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.KhuyenMai;

public class KhuyenMai_DAO {

	public KhuyenMai_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<KhuyenMai> layTatCaKhuyenMai() {
		ArrayList<KhuyenMai> danhSachKhuyenMai = new ArrayList<KhuyenMai>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM KhuyenMai";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKhuyenMai = rs.getString("maKhuyenMai");
				String tenKhuyenMai = rs.getString("tenKhuyenMai");
				String maGiamGia = rs.getString("maGiamGia");
				java.sql.Date ngayBatDau = rs.getDate("ngayBatDau");
				java.sql.Date ngayKetThuc = rs.getDate("ngayKetThuc");
				int tongSoLuong = rs.getInt("tongSoLuong");
				Double chietKhau = rs.getDouble("chieuKhau");
				String moTa = rs.getString("moTa");
				KhuyenMai khuyenMai = new KhuyenMai(maKhuyenMai, tenKhuyenMai, maGiamGia, ngayBatDau, ngayKetThuc,
						tongSoLuong, chietKhau, moTa);
				danhSachKhuyenMai.add(khuyenMai);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachKhuyenMai;
	}

	public KhuyenMai layKhuyenMai_TheoMaKhuyenMai(String maKM) {
		KhuyenMai khuyenMai = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM KhuyenMai WHERE maKhuyenMai = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maKM);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maKhuyenMai = rs.getString("maKhuyenMai");
				String tenKhuyenMai = rs.getString("tenKhuyenMai");
				String maGiamGia = rs.getString("maGiamGia");
				java.sql.Date ngayBatDau = rs.getDate("ngayBatDau");
				java.sql.Date ngayKetThuc = rs.getDate("ngayKetThuc");
				int tongSoLuong = rs.getInt("tongSoLuong");
				Double chietKhau = rs.getDouble("chieuKhau");
				String moTa = rs.getString("moTa");
				khuyenMai = new KhuyenMai(maKhuyenMai, tenKhuyenMai, maGiamGia, ngayBatDau, ngayKetThuc, tongSoLuong,
						chietKhau, moTa);
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
		return khuyenMai;
	}

	public KhuyenMai layKhuyenMai_TheoMaGiamGia(String maGG) {
		KhuyenMai khuyenMai = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM KhuyenMai WHERE maGiamGia = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maGG);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maKhuyenMai = rs.getString("maKhuyenMai");
				String tenKhuyenMai = rs.getString("tenKhuyenMai");
				String maGiamGia = rs.getString("maGiamGia");
				java.sql.Date ngayBatDau = rs.getDate("ngayBatDau");
				java.sql.Date ngayKetThuc = rs.getDate("ngayKetThuc");
				int tongSoLuong = rs.getInt("tongSoLuong");
				Double chietKhau = rs.getDouble("chietKhau");
				String moTa = rs.getString("moTa");
				khuyenMai = new KhuyenMai(maKhuyenMai, tenKhuyenMai, maGiamGia, ngayBatDau, ngayKetThuc, tongSoLuong,
						chietKhau, moTa);
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
		return khuyenMai;
	}

	public boolean taoKhuyenMai(KhuyenMai khuyenMai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("INSERT INTO KhuyenMai values(?,?,?,?,?,?,?,?)");
			statement.setString(1, khuyenMai.getMaKhuyenMai());
			statement.setString(2, khuyenMai.getTenKhuyenMai());
			statement.setString(3, khuyenMai.getMaGiamGia());
			statement.setDate(4, khuyenMai.getNgayBatDau());
			statement.setDate(5, khuyenMai.getNgayKetThuc());
			statement.setInt(6, khuyenMai.getTongSoLuong());
			statement.setDouble(7, khuyenMai.getChietKhau());
			statement.setString(8, khuyenMai.getMoTa());
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

	public boolean capNhatKhuyenMai(KhuyenMai khuyenMai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"UPDATE KhuyenMai SET tenKhuyenMai = ?, maGiamGia = ?, ngayBatDau = ?, ngayKetThuc = ?, tongSoLuong = ?, chietKhau = ?, moTa = ?"
							+ " WHER maKhuyenMai = ?");		
			statement.setString(1, khuyenMai.getTenKhuyenMai());
			statement.setString(2, khuyenMai.getMaGiamGia());
			statement.setDate(3, khuyenMai.getNgayBatDau());
			statement.setDate(4, khuyenMai.getNgayKetThuc());
			statement.setInt(5, khuyenMai.getTongSoLuong());
			statement.setDouble(6, khuyenMai.getChietKhau());
			statement.setString(7, khuyenMai.getMoTa());
			statement.setString(8, khuyenMai.getMaKhuyenMai());
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
	
	public boolean xoaKhuyenMai(KhuyenMai khuyenMai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"DELTETE FROM KhuyenMai"
							+ " WHER maKhuyenMai = ?");
			statement.setString(1, khuyenMai.getMaKhuyenMai());
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
