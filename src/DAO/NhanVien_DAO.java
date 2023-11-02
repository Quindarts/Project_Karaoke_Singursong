package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.NhanVien;
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
				String CCCD = rs.getString("CCCD");
				String diaChi = rs.getString("diaChi");
				String trangThai = rs.getString("trangThai");
				String anhThe = rs.getString("anhThe");
				NhanVien nhanVien = new NhanVien(maNhanVien, loaiNhanVien, hoTen, gioiTinh, ngaySinh, SoDienThoai, CCCD,
						diaChi, trangThai, anhThe);
				danhSachNhanVien.add(nhanVien);
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
	public NhanVien timNhanVien_TheoMaNhanVien(String maNV) {
		NhanVien nhanVien = null;
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
				String CCCD = rs.getString("CCCD");
				String diaChi = rs.getString("diaChi");
				String trangThai = rs.getString("trangThai");
				String anhThe = rs.getString("anhThe");

				nhanVien = new NhanVien(maNhanVien, loaiNhanVien, hoTen, gioiTinh, ngaySinh, SoDienThoai, CCCD, diaChi,
						trangThai, anhThe);

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
		return nhanVien;
	}

	public NhanVien timNhanVien_TheoMaLoaiNhanVien(String maLoaiNV) {
		NhanVien nhanVien = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM NhanVien WHERE maLoaiNhanVien = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maLoaiNV);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maNhanVien = rs.getString("maNhanVien");
				LoaiNhanVien loaiNhanVien = new LoaiNhanVien(rs.getString("maLoaiNhanVien"));
				java.sql.Date ngaySinh = rs.getDate("ngaySinh");
				String hoTen = rs.getString("hoTen");
				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				String SoDienThoai = rs.getString("SoDienThoai");
				String CCCD = rs.getString("CCCD");
				String diaChi = rs.getString("diaChi");
				String trangThai = rs.getString("trangThai");
				String anhThe = rs.getString("anhThe");
				nhanVien = new NhanVien(maNhanVien, loaiNhanVien, hoTen, gioiTinh, ngaySinh, SoDienThoai, CCCD, diaChi,
						trangThai, anhThe);
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
		return nhanVien;
	}
	
	public NhanVien timNhanVien_TheoSoDienThoai(String soDT) {
		NhanVien nhanVien = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM NhanVien WHERE soDienThoai = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, soDT);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maNhanVien = rs.getString("maNhanVien");
				LoaiNhanVien loaiNhanVien = new LoaiNhanVien(rs.getString("maLoaiNhanVien"));
				java.sql.Date ngaySinh = rs.getDate("ngaySinh");
				String hoTen = rs.getString("hoTen");
				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				String soDienThoai = rs.getString("SoDienThoai");
				String CCCD = rs.getString("CCCD");
				String diaChi = rs.getString("diaChi");
				String trangThai = rs.getString("trangThai");
				String anhThe = rs.getString("anhThe");
				nhanVien = new NhanVien(maNhanVien, loaiNhanVien, hoTen, gioiTinh, ngaySinh, soDienThoai, CCCD, diaChi,
						trangThai, anhThe);
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
		return nhanVien;
	}

	/**
	 * TaoNhanVien
	 * 
	 * @param nv
	 * @return true / false
	 */
	public boolean taoNhanVien(NhanVien nhanVien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("INSERT INTO NhanVien values(?,?,?,?,?,?,?,?,?,?)");
			statement.setString(1, nhanVien.getMaNhanVien());
			statement.setString(2, nhanVien.getloaiNhanVien().getMaLoaiNhanVien());
			statement.setString(3, nhanVien.getHoTen());
			statement.setBoolean(4, nhanVien.isGioiTinh());
			statement.setDate(5, (java.sql.Date) nhanVien.getNgaySinh());
			statement.setString(6, nhanVien.getSoDienThoai());
			statement.setString(7, nhanVien.getCCCD());
			statement.setString(8, nhanVien.getDiaChi());
			statement.setString(9, nhanVien.getTrangThai());
			statement.setString(10, nhanVien.getAnhThe());
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
	public boolean capNhatNhanVien(NhanVien nhanVien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"UPDATE NhanVien SET maLoaiNhanVien = ?, hoTen =?, gioiTinh=?, ngaySinh=?, soDienThoai=?, CCCD=?, diaChi=?, trangThai=?, anhThe=?"
							+ " WHERE maNhanVien=?");
			statement.setString(1, nhanVien.getloaiNhanVien().getMaLoaiNhanVien());
			statement.setString(2, nhanVien.getHoTen());
			statement.setBoolean(3, nhanVien.isGioiTinh());
			statement.setDate(4, (java.sql.Date) nhanVien.getNgaySinh());
			statement.setString(5, nhanVien.getSoDienThoai());
			statement.setString(6, nhanVien.getCCCD());
			statement.setString(7, nhanVien.getDiaChi());
			statement.setString(8, nhanVien.getTrangThai());
			statement.setString(9, nhanVien.getAnhThe());
			statement.setString(10, nhanVien.getMaNhanVien());
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
	public boolean xoaNhanVien(NhanVien nhanVien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("DELETE FROM NhanVien WHERE maNhanVien=?");
			statement.setString(1, nhanVien.getMaNhanVien());
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
