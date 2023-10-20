package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnectDB.ConnectDB;
import Entity.TaiKhoan;

/**
 * TaiKhoanDAO
 * Le Minh Quang
 * 20/10/2023
 */
public class TaiKhoan_DAO {
	
	/**
	 * @param maNhanVien
	 * @param tenDangNhap
	 * @param matKhau
	 * @return	boolean
	 */
	public TaiKhoan_DAO() {
	}
	
	public boolean taoMoiTaiKhoan(String maNhanVien, String tenDangNhap, String matKhau) {
		System.out.println("Bat Dau");
		Connection con =  ConnectDB.getInstance().getConnection();
		try {
			PreparedStatement statement = con.prepareStatement("insert into TaiKhoan values(?,?,?,?)");
			statement.setString(1, maNhanVien);
			statement.setString(2,tenDangNhap);
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
	public TaiKhoan timKiemTaiKhoan( String tenDangNhap, String matKhau) {
		Connection con =  ConnectDB.getInstance().getConnection();
		TaiKhoan tk = null;
		try {
			PreparedStatement statement = con.prepareStatement("select * from TaiKhoan where tenDangNhap = ? and matKhau = ? ");
			statement.setString(1, tenDangNhap);
			statement.setString(2,matKhau);
			
			ResultSet rs = statement.executeQuery();
			rs.next();
			tk = new TaiKhoan(rs.getString("maNhanVien"),rs.getString("tenDangNhap"),rs.getString("matKhau"),rs.getBoolean("trangThai"));
		} catch (SQLException e) {
			return null;
		}
		return tk;
		
	}
}
