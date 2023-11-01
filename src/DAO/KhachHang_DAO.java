package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.KhachHang;

public class KhachHang_DAO {

	public KhachHang_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<KhachHang> layTatCaKhachHang() {
		ArrayList<KhachHang> danhSachKhachHang = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				
				String maKhachHang = rs.getString("maKhachHang");
				String hoTen = rs.getString("hoTen");
				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				java.sql.Date ngaySinh = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");
				String soDienThoai = rs.getString("soDienThoai");
				int diemThuong = rs.getInt("diemThuong");
				String ghiChu = rs.getString("ghiChu");
				KhachHang khachHang = new KhachHang(maKhachHang, hoTen, gioiTinh, ngaySinh, diaChi, soDienThoai,
						diemThuong, ghiChu);
				danhSachKhachHang.add(khachHang);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachKhachHang;
	}

	public KhachHang layKhachHang_TheoMaKhachHang(String maKH) {
		
		KhachHang khachHang = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "SELECT * FROM KhachHang WHERE maKhachHang = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maKH);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				
				String maKhachHang = rs.getString("maKhachHang");
				String hoTen = rs.getString("hoTen");
				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				java.sql.Date ngaySinh = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");
				String soDienThoai = rs.getString("soDienThoai");
				int diemThuong = rs.getInt("diemThuong");
				String ghiChu = rs.getString("ghiChu");
				khachHang = new KhachHang(maKhachHang, hoTen, gioiTinh, ngaySinh, diaChi, soDienThoai, diemThuong,
						ghiChu);
				
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
		return khachHang;
	}
	
	public KhachHang layKhachHang_TheoSoDienThoai(String soDT) {
		
		KhachHang khachHang = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "SELECT * FROM KhachHang WHERE soDienThoai = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, soDT);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				
				String maKhachHang = rs.getString("maKhachHang");
				String hoTen = rs.getString("hoTen");
				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				java.sql.Date ngaySinh = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");
				String soDienThoai = rs.getString("soDienThoai");
				int diemThuong = rs.getInt("diemThuong");
				String ghiChu = rs.getString("ghiChu");
				khachHang = new KhachHang(maKhachHang, hoTen, gioiTinh, ngaySinh, diaChi, soDienThoai, diemThuong,
						ghiChu);
				
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
		return khachHang;
	}

	public boolean taoKhachHang(KhachHang khachHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("INSERT INTO KhachHang values(?,?,?,?,?,?,?,?)");
			statement.setString(1, khachHang.getMaKhachHang());
			statement.setString(2, khachHang.getHoTen());
			statement.setBoolean(3, khachHang.isGioiTinh());
			statement.setDate(4, khachHang.getNgaySinh());
			statement.setString(5, khachHang.getDiaChi());
			statement.setString(6, khachHang.getSoDienThoai());
			statement.setInt(7, khachHang.getDiemThuong());
			statement.setString(8, khachHang.getGhiChu());
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

	public boolean capNhatKhachHang(KhachHang khachHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"UPDATE KhachHang SET hoTen = ?, gioiTinh = ?, ngaySinh = ?, diaChi = ?, soDienThoai = ?, diemThuong = ?, ghiChu = ?"
							+ " WHERE maKhachHang = ?");
			statement.setString(1, khachHang.getHoTen());
			statement.setBoolean(2, khachHang.isGioiTinh());
			statement.setDate(3, khachHang.getNgaySinh());
			statement.setString(4, khachHang.getDiaChi());
			statement.setString(5, khachHang.getSoDienThoai());
			statement.setInt(6, khachHang.getDiemThuong());
			statement.setString(7, khachHang.getGhiChu());
			statement.setString(8, khachHang.getMaKhachHang());
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

	public boolean xoaKhachHang(KhachHang khachHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("DELETE FROM KhachHang" + " WHERE maKhachHang = ?");
			statement.setString(1, khachHang.getMaKhachHang());
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
