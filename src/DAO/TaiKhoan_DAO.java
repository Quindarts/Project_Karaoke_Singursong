package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnectDB.ConnectDB;
import Entity.TaiKhoan;
import Entity.NhanVien;

/**
 * TaiKhoanDAO Le Minh Quang 20/10/2023
 */
public class TaiKhoan_DAO {

	/**
	 * @param maNhanVien
	 * @param tenDangNhap
	 * @param matKhau
	 * @return boolean
	 */
	public TaiKhoan_DAO() {
	}

	public boolean taoMoiTaiKhoan(String maNhanVien, String tenDangNhap, String matKhau) {
		System.out.println("Bat Dau");
		Connection con = ConnectDB.getInstance().getConnection();
		try {
			PreparedStatement statement = con.prepareStatement("insert into TaiKhoan values(?,?,?,?)");
			statement.setString(1, maNhanVien);
			statement.setString(2, tenDangNhap);
			statement.setString(3, matKhau);
			statement.setBoolean(3, true);
			statement.executeUpdate();
			con.close();
			statement.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	/**
	 * @param tenDangNhap
	 * @param matKhau
	 * @return TaiKhoan
	 */
	public TaiKhoan timKiemTaiKhoan(String tenDangNhap) {
		Connection con = ConnectDB.getInstance().getConnection();
		TaiKhoan taiKhoan = null;
		try {
			PreparedStatement statement = con
					.prepareStatement("SELECT * FROM TaiKhoan WHERE tenDangNhap = ?");
			statement.setString(1, tenDangNhap);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				Boolean trangThai = rs.getBoolean("trangThai");
				taiKhoan = new TaiKhoan(nhanVien, tenDangNhap, matKhau, trangThai);
			}

		} catch (SQLException e) {
			return null;
		}
		return taiKhoan;
	}
	

	public TaiKhoan timTaiKhoan_TheoMaNhanVien(String maNV) {
		TaiKhoan taiKhoan = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM TaiKhoan where maNhanVien = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maNV);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				String tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				Boolean trangThai = rs.getBoolean("trangThai");
				taiKhoan = new TaiKhoan(nhanVien, tenDangNhap, matKhau, trangThai);
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
		return taiKhoan;
	}

	public boolean capNhatTaiKhoan_TheoTenDangNhap(String tenDangNhap, String matKhau) {
		Connection con = ConnectDB.getInstance().getConnection();
		int n = 0;
		TaiKhoan taiKhoan = null;
		try {
			PreparedStatement statement = con.prepareStatement("UPDATE TaiKhoan SET  matKhau = ? WHERE tenDangNhap = ?");
			statement.setString(1, matKhau);
			statement.setString(2, tenDangNhap);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				tenDangNhap = rs.getString("tenDangNhap");
				matKhau = rs.getString("matKhau");
				Boolean trangThai = rs.getBoolean("trangThai");
				taiKhoan = new TaiKhoan(nhanVien, tenDangNhap, matKhau, trangThai);
				n++;
				System.out.println("đã thực hiện đổi mật khẩu");
			}
		} catch (SQLException e) {
			return n > 0;
		}
		return n > 0;
	}

	public TaiKhoan capNhatTaiKhoan_TheoMaNhanVien(String tenDangNhap, String maNhanVien, String matKhau) {
		Connection con = ConnectDB.getInstance().getConnection();
		TaiKhoan taiKhoan = null;
		try {
			PreparedStatement statement = con.prepareStatement("UPDATE TaiKhoan SET  maKhau = ? WHERE maNhanVien = ?");
			statement.setString(1, matKhau);
			statement.setString(2, maNhanVien);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				tenDangNhap = rs.getString("tenDangNhap");
				matKhau = rs.getString("matKhau");
				Boolean trangThai = rs.getBoolean("trangThai");
				taiKhoan = new TaiKhoan(nhanVien, tenDangNhap, matKhau, trangThai);
			}
		} catch (SQLException e) {
			return null;
		}
		return taiKhoan;
	}
	
	public TaiKhoan timTaiKhoan_TheoTenDangNhap(String tenDangNhap) {
		Connection con = ConnectDB.getInstance().getConnection();
		TaiKhoan taiKhoan = null;
		try {
			PreparedStatement statement = con
					.prepareStatement("SELECT * FROM TaiKhoan WHERE tenDangNhap = ?");
			statement.setString(1, tenDangNhap);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
				tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				Boolean trangThai = rs.getBoolean("trangThai");
				taiKhoan = new TaiKhoan(nhanVien, tenDangNhap, matKhau, trangThai);
			}

		} catch (SQLException e) {
			return null;
		}
		return taiKhoan;
		
	}
}