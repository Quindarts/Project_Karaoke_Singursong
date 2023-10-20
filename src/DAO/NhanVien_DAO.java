package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.NhanVien;
import Entity.TaiKhoan;
import Entity.LoaiNhanVien;

/**
 * NhanVien_DAO
 * 
 * @author THANH CUONG
 *
 */
public class NhanVien_DAO {

	public NhanVien_DAO() {
	}

	/**
	 * LayTatCaNhanVien
	 * 
	 * @return true/false
	 */
	public ArrayList<NhanVien> layTatCaNhanVien() {
		ArrayList<NhanVien> danhSachNhanVien = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNhanVien = rs.getString("maNhanVien");
				LoaiNhanVien loaiNhanVien = new LoaiNhanVien(rs.getString("maLoaiNhanVien"));
				java.sql.Date ngaySinh = rs.getDate("ngaySinh");
				String hoTen = rs.getString("hoTen");
				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				String SoDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("diaChi");
				String trangThai = rs.getString("trangThai");
				String anhThe = rs.getString("anhThe");
				TaiKhoan taiKhoan = new TaiKhoan(rs.getString("maNhanVien"));
				NhanVien nv = new NhanVien(maNhanVien, loaiNhanVien, hoTen, gioiTinh, ngaySinh, SoDienThoai,
						SoDienThoai, diaChi, trangThai, anhThe);
				danhSachNhanVien.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachNhanVien;
	}

	/**
	 * TimNhanVienTheoMa
	 * 
	 * @param maNV
	 * @return true / false
	 */
	public NhanVien timNhanVienTheoMa(String maNV) {
		NhanVien nv = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM NhanVien where maNhanVien = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maNV);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maNhanVien = rs.getString("maNhanVien");
				LoaiNhanVien loaiNhanVien = new LoaiNhanVien(rs.getString("maLoaiNhanVien"));
				java.sql.Date ngaySinh = rs.getDate("ngaySinh");
				String hoTen = rs.getString("hoTen");
				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				String SoDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("diaChi");
				String trangThai = rs.getString("trangThai");
				String anhThe = rs.getString("anhThe");
				 nv = new NhanVien(maNhanVien, loaiNhanVien, hoTen, gioiTinh, ngaySinh, SoDienThoai,
						SoDienThoai, diaChi, trangThai, anhThe);
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
		return nv;
	}

	/**
	 * TaoNhanVien
	 * 
	 * @param nv
	 * @return true / false
	 */
	public boolean taoNhanVien(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?,?,?,?)");
			statement.setString(1, nv.getMaNhanVien());
			statement.setString(2, nv.getloaiNhanVien().getMaLoaiNhanVien());
			statement.setString(3, nv.getHoTen());
			statement.setBoolean(4, nv.isGioiTinh());
			statement.setDate(5, (java.sql.Date) nv.getNgaySinh());
			statement.setString(6, nv.getSoDienThoai());
			statement.setString(7, nv.getCCCD());
			statement.setString(8, nv.getDiaChi());
			statement.setString(9, nv.getTrangThai());
			statement.setString(10, nv.getAnhThe());
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

	/**
	 * CapNhatNhanVien
	 * 
	 * @param nv
	 * @return true / false
	 */
	public boolean capNhatNhanVien(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"update NhanVien set hoTen =?, gioiTinh=?, ngaySinh=?, soDienThoai=?, CCCD=?, diaChi=?, trangThai=?, anhThe=?"
							+ "where maNhanVien=?");
			statement.setString(1, nv.getMaNhanVien());
			statement.setString(2, nv.getloaiNhanVien().getMaLoaiNhanVien());
			statement.setString(3, nv.getHoTen());
			statement.setBoolean(4, nv.isGioiTinh());
			statement.setDate(5, (java.sql.Date) nv.getNgaySinh());
			statement.setString(6, nv.getSoDienThoai());
			statement.setString(7, nv.getCCCD());
			statement.setString(8, nv.getDiaChi());
			statement.setString(9, nv.getTrangThai());
			statement.setString(10, nv.getAnhThe());
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

	/**
	 * XoaNhanVien
	 * 
	 * @param nv
	 * @return true / false
	 */
	public boolean xoaNhanVien(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("delete from NhanVien where maNhanVien=?");
			statement.setString(1, nv.getMaNhanVien());
			n = statement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
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
