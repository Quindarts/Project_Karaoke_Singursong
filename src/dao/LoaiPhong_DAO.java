package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiPhong;

public class LoaiPhong_DAO {

	public LoaiPhong_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<LoaiPhong> layTatCaLoaiPhong() {
		ArrayList<LoaiPhong> danhSachLoaiPhong = new ArrayList<LoaiPhong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM LoaiPhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maLoaiPhong = rs.getString("maLoaiPhong");
				String tenLoaiPhong = rs.getString("tenLoaiPhong");
				int soLuongKhachToiDa = rs.getInt("soLuongKhachToiDa");
				Double giaTien = rs.getDouble("giaTien");
				String hinhAnh = rs.getString("hinhAnh");
				String moTa = rs.getString("moTa");
				LoaiPhong loaiPhong = new LoaiPhong(maLoaiPhong, tenLoaiPhong, soLuongKhachToiDa, giaTien, hinhAnh, moTa);
				danhSachLoaiPhong.add(loaiPhong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachLoaiPhong;
	}

	public LoaiPhong layLoaiPhong_TheoMaLoaiPhong(String maLoaiP) {
		LoaiPhong loaiPhong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM LoaiPhong WHERE maLoaiPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maLoaiP);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maLoaiPhong = rs.getString("maLoaiPhong");
				String tenLoaiPhong = rs.getString("tenLoaiPhong");
				int soLuongKhachToiDa = rs.getInt("soLuongKhachToiDa");
				Double giaTien = rs.getDouble("giaTien");
				String hinhAnh = rs.getString("hinhAnh");
				String moTa = rs.getString("moTa");
				loaiPhong = new LoaiPhong(maLoaiPhong, tenLoaiPhong, soLuongKhachToiDa, giaTien, hinhAnh, moTa);
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
		return loaiPhong;
	}
	
	public LoaiPhong layLoaiPhong_TheoTenLoaiPhong(String xtenLoaiPhong) {
		LoaiPhong loaiPhong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM LoaiPhong WHERE tenLoaiPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, xtenLoaiPhong);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maLoaiPhong = rs.getString("maLoaiPhong");
				String tenLoaiPhong = rs.getString("tenLoaiPhong");
				int soLuongKhachToiDa = rs.getInt("soLuongKhachToiDa");
				Double giaTien = rs.getDouble("giaTien");
				String hinhAnh = rs.getString("hinhAnh");
				String moTa = rs.getString("moTa");
				loaiPhong = new LoaiPhong(maLoaiPhong, tenLoaiPhong, soLuongKhachToiDa, giaTien, hinhAnh, moTa);
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
		return loaiPhong;
	}

	public boolean taoLoaiPhong(LoaiPhong loaiPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("INSERT INTO LoaiPhong values(?,?,?,?,?,?)");
			statement.setString(1, loaiPhong.getMaLoaiPhong());
			statement.setString(2, loaiPhong.getTenLoaiPhong());
			statement.setInt(3, loaiPhong.getSoLuongToiDa());
			statement.setDouble(4, loaiPhong.getGiaTien());
			statement.setString(5, loaiPhong.getHinhAnh());
			statement.setString(6, loaiPhong.getMoTa());
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

	public boolean capNhatLoaiPhong(LoaiPhong loaiPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"UPDATE LoaiPhong SET tenLoaiPhong = ?, soLuongKhachToiDa = ?, giaTien = ?, hinhAnh = ?, moTa = ?"
							+ " WHERE maLoaiPhong = ?");		
			statement.setString(1, loaiPhong.getTenLoaiPhong());
			statement.setInt(2, loaiPhong.getSoLuongToiDa());
			statement.setDouble(3, loaiPhong.getGiaTien());
			statement.setString(4, loaiPhong.getHinhAnh());
			statement.setString(5, loaiPhong.getMoTa());
			statement.setString(6, loaiPhong.getMaLoaiPhong());
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
	
	public boolean xoaLoaiPhong(LoaiPhong loaiPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"DELETE FROM LoaiPhong"
							+ " WHERE maLoaiPhong = ?");
			statement.setString(1, loaiPhong.getMaLoaiPhong());
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
	public ArrayList<LoaiPhong> timDStheoSoLuongVaGiaTien(String soLuong, String price) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		ArrayList<LoaiPhong> danhSachLoaiPhong = new ArrayList<LoaiPhong>();
		String sql = "SELECT * FROM LoaiPhong WHERE 1 = 1 ";
		if(!soLuong.equals("Tất cả")) {
			sql += "AND soLuongKhachToiDa = ? ";
		}
		if(!price.equals("Tất cả")) {
			sql += "AND giaTien <= ?"; 
		}
		
		
		try {
			statement = con.prepareStatement(sql);
			int parameterIndex = 1;
			if(!soLuong.equals("Tất cả")) {
				statement.setString(parameterIndex++, soLuong);
			}
			if(!price.equals("Tất cả")) {
				statement.setString(parameterIndex++, price);
			}
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maLoaiPhong = rs.getString("maLoaiPhong");
				String tenLoaiPhong = rs.getString("tenLoaiPhong");
				int soLuongKhachToiDa = rs.getInt("soLuongKhachToiDa");
				Double giaTien = rs.getDouble("giaTien");
				String hinhAnh = rs.getString("hinhAnh");
				String moTa = rs.getString("moTa");
				LoaiPhong loaiPhong = new LoaiPhong(maLoaiPhong, tenLoaiPhong, soLuongKhachToiDa, giaTien, hinhAnh, moTa);
				danhSachLoaiPhong.add(loaiPhong);
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
		return danhSachLoaiPhong;
	}
	public ArrayList<LoaiPhong> timDSPhongTheoMaLPhong(String maLP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;

		ArrayList<LoaiPhong> danhSachLoaiPhong = new ArrayList<LoaiPhong>();
		try {
			String sql = "SELECT * FROM LoaiPhong WHERE maLoaiPhong LIKE ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, "%" + maLP + "%");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maLoaiPhong = rs.getString("maLoaiPhong");
				String tenLoaiPhong = rs.getString("tenLoaiPhong");
				int soLuongKhachToiDa = rs.getInt("soLuongKhachToiDa");
				Double giaTien = rs.getDouble("giaTien");
				String hinhAnh = rs.getString("hinhAnh");
				String moTa = rs.getString("moTa");
				LoaiPhong loaiPhong = new LoaiPhong(maLoaiPhong, tenLoaiPhong, soLuongKhachToiDa, giaTien, hinhAnh, moTa);
				danhSachLoaiPhong.add(loaiPhong);
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
		return danhSachLoaiPhong;
	}
}
