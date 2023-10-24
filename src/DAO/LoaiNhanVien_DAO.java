package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.LoaiNhanVien;

/**LoaiNhanVien_DAO
 * @author THANH CUONG
 *
 */
public class LoaiNhanVien_DAO {

	public LoaiNhanVien_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<LoaiNhanVien> layTatCaLoaiNhanVien() {
		ArrayList<LoaiNhanVien> danhSachLoaiNhanVien = new ArrayList<LoaiNhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM LoaiNhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				
				String maLoaiNhanVien = rs.getString("maLoaiNhanVien");
				String tenLoaiNhanVien = rs.getString("tenLoaiNhanVien");
				LoaiNhanVien loaiNhanVien = new LoaiNhanVien(maLoaiNhanVien, tenLoaiNhanVien);
				danhSachLoaiNhanVien.add(loaiNhanVien);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachLoaiNhanVien;
	}
	
	public LoaiNhanVien layLoaiNhanVien_TheoMaLoaiNhanVien(String maLoaiNV) {
		LoaiNhanVien loaiNhanVien = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM LoaiNhanVien WHERE maLoaiNhanVien = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maLoaiNV);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maLoaiNhanVien = rs.getString("maLoaiNhanVien");
				String tenLoaiNhanVien = rs.getString("tenLoaiNhanVien");
				loaiNhanVien = new LoaiNhanVien(maLoaiNhanVien, tenLoaiNhanVien);
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
		return loaiNhanVien;
	}
	
	public boolean taoLoaiNhanVien(LoaiNhanVien loaiNhanVien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("INSERT INTO LoaiNhanVien values(?,?)");
			statement.setString(1, loaiNhanVien.getMaLoaiNhanVien());
			statement.setString(2, loaiNhanVien.getTenLoaiNhanVien());
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
	
	public boolean capNhatLoaiNhanVien(LoaiNhanVien loaiNhanVien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"UPDATE LoaiNhanVien SET tenLoaiNhanVien = ?"
							+ " WHERE maLoaiNhanVien = ?");		
			statement.setString(1, loaiNhanVien.getTenLoaiNhanVien());
			statement.setString(2, loaiNhanVien.getMaLoaiNhanVien());
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
	
	public boolean xoaLoaiNhanVien(LoaiNhanVien loaiNhanVien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"DELETE FROM LoaiNhanVien"
							+ " WHERE maLoaiNhanVien = ?");
			statement.setString(1, loaiNhanVien.getMaLoaiNhanVien());
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
