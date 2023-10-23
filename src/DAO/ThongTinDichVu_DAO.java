package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.DichVu;
import Entity.ThongTinDichVu;

public class ThongTinDichVu_DAO {

	public ThongTinDichVu_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<ThongTinDichVu> layTatCaThongTinDichVu() {
		ArrayList<ThongTinDichVu> danhSachThongTinDichVu = new ArrayList<ThongTinDichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM ThongTinDichVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maThongTinDichVu = rs.getString("maThongTinDichVu");
				DichVu dichVu = new DichVu(rs.getString("maDichVu"));
				int soLuong = rs.getInt("soLuong");
				int soLuongDaSuDung = rs.getInt("soLuongDaSuDung");
				java.sql.Date ngayNhap = rs.getDate("ngayNhap");
				java.sql.Date ngayHetHan = rs.getDate("ngayHetHan");
				String moTa = rs.getString("moTa");
				String hinhAnh = rs.getString("hinhAnh");
				ThongTinDichVu thongTinDichVu = new ThongTinDichVu(maThongTinDichVu, dichVu, soLuong, soLuongDaSuDung,
						ngayNhap, ngayHetHan, moTa, hinhAnh);
				danhSachThongTinDichVu.add(thongTinDichVu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachThongTinDichVu;
	}

	public ThongTinDichVu timThongTinDichVu_TheoMaThongTinDichVu(String maTTDichVu) {
		ThongTinDichVu thongTinDichVu = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM ThongTinDichVu WHERE maThongTinDichVu = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maTTDichVu);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maThongTinDichVu = rs.getString("maThongTinDichVu");
				DichVu dichVu = new DichVu(rs.getString("maDichVu"));
				int soLuong = rs.getInt("soLuong");
				int soLuongDaSuDung = rs.getInt("soLuongDaSuDung");
				java.sql.Date ngayNhap = rs.getDate("ngayNhap");
				java.sql.Date ngayHetHan = rs.getDate("ngayHetHan");
				String moTa = rs.getString("moTa");
				String hinhAnh = rs.getString("hinhAnh");
				thongTinDichVu = new ThongTinDichVu(maThongTinDichVu, dichVu, soLuong, soLuongDaSuDung, ngayNhap,
						ngayHetHan, moTa, hinhAnh);
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
		return thongTinDichVu;
	}
	
	public ThongTinDichVu timThongTinDichVu_TheoMaDichVu(String maDv) {
		ThongTinDichVu thongTinDichVu = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM ThongTinDichVu WHERE maDichVu = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maDv);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maThongTinDichVu = rs.getString("maThongTinDichVu");
				DichVu dichVu = new DichVu(rs.getString("maDichVu"));
				int soLuong = rs.getInt("soLuong");
				int soLuongDaSuDung = rs.getInt("soLuongDaSuDung");
				java.sql.Date ngayNhap = rs.getDate("ngayNhap");
				java.sql.Date ngayHetHan = rs.getDate("ngayHetHan");
				String moTa = rs.getString("moTa");
				String hinhAnh = rs.getString("hinhAnh");
				thongTinDichVu = new ThongTinDichVu(maThongTinDichVu, dichVu, soLuong, soLuongDaSuDung, ngayNhap,
						ngayHetHan, moTa, hinhAnh);
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
		return thongTinDichVu;
	}

	public boolean taoThongTinDichVu(ThongTinDichVu thongTinDichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("INSERT INTO ThongTinDichVu values(?,?,?,?,?,?,?,?)");
			statement.setString(1, thongTinDichVu.getMaThongTinDichVu());
			statement.setString(2, thongTinDichVu.getDichVu().getMaDichVu());
			statement.setInt(3, thongTinDichVu.getSoLuong());
			statement.setInt(4, thongTinDichVu.getSoLuongDaSuDung());
			statement.setDate(5, thongTinDichVu.getNgayNhap());
			statement.setDate(6, thongTinDichVu.getNgayHetHan());
			statement.setString(7, thongTinDichVu.getMoTa());
			statement.setString(8, thongTinDichVu.getHinhAnh());
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

	public boolean capNhatThongTinDichVu(ThongTinDichVu thongTinDichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"UPDATE ThongTinDichVu SET maDichVu = ?, soLuong = ?, soLuongDaSuDung = ?, ngayNhap = ?, ngayHetHan = ?, moTa = ?, hinhAnh = ?"
							+ " WHERE maThongTinDichVu = ?");
			statement.setString(1, thongTinDichVu.getDichVu().getMaDichVu());
			statement.setInt(2, thongTinDichVu.getSoLuong());
			statement.setInt(3, thongTinDichVu.getSoLuongDaSuDung());
			statement.setDate(4, thongTinDichVu.getNgayNhap());
			statement.setDate(5, thongTinDichVu.getNgayHetHan());
			statement.setString(6, thongTinDichVu.getMoTa());
			statement.setString(7, thongTinDichVu.getHinhAnh());
			statement.setString(8, thongTinDichVu.getMaThongTinDichVu());
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
	
	public boolean xoaThongTinDichVu(ThongTinDichVu thongTinDichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"DELETE FROM ThongTinDichVu"
							+ " WHERE maThongTinDichVu = ?");
			statement.setString(1, thongTinDichVu.getMaThongTinDichVu());
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
