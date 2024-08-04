package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.itextpdf.text.List;

import connectDB.ConnectDB;
import entity.ChiTietDichVu;
import entity.DichVu;
import entity.HoaDon;
import entity.Phong;

public class ChiTietDichVu_DAO {

	public ChiTietDichVu_DAO() {
	}

	public ArrayList<ChiTietDichVu> layTatCaCTDichVu() {
		ArrayList<ChiTietDichVu> danhSachCTDichVu = new ArrayList<ChiTietDichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM ChiTietDichVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				HoaDon hoaDon = new HoaDon(rs.getString("maHoaDon"));
				DichVu dichVu = new DichVu(rs.getString("maDichVu"));
				int soLuong = rs.getInt("soLuong");
				ChiTietDichVu ctDichVu = new ChiTietDichVu(hoaDon, dichVu, soLuong);
				danhSachCTDichVu.add(ctDichVu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachCTDichVu;
	}

	public ChiTietDichVu timCTDichVu_TheoMaDichVu(String maDV) {
		ChiTietDichVu ctDichVu = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM ChiTietDichVu where maDichVu = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maDV);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				HoaDon hoaDon = new HoaDon(rs.getString("maHoaDon"));
				DichVu dichVu = new DichVu(rs.getString("maDichVu"));
				int soLuong = rs.getInt("soLuong");
				ctDichVu = new ChiTietDichVu(hoaDon, dichVu, soLuong);
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
		return ctDichVu;
	}

	public ArrayList<ChiTietDichVu> layDanhSachChiTietDichVu_TheoMaPhong_TheoMaHD(String maP, String maHD) {
		ArrayList<ChiTietDichVu> danhSachCTDichVu = new ArrayList<ChiTietDichVu>();
		DichVu_DAO DAO_DV = new DichVu_DAO();
		Phong_DAO DAO_P = new Phong_DAO();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM ChiTietDichVu where maPhong = '" + maP + "' and maHoaDon = '" + maHD + "';";
			statement = con.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				HoaDon hoaDon = new HoaDon(rs.getString("maHoaDon"));
				DichVu dv = DAO_DV.layDichVu_TheoMaDichVu(rs.getString("maDichVu"));
				Phong ph = DAO_P.timPhong_TheoMaPhong(rs.getString("maPhong"));
				int soLuong = rs.getInt("soLuong");
				ChiTietDichVu ctDichVu = new ChiTietDichVu(hoaDon, dv, soLuong, ph);

				danhSachCTDichVu.add(ctDichVu);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachCTDichVu;
	}

	public ArrayList<ChiTietDichVu> layDanhSachChiTietDichVu_TheoMaHoaDon_MaPhong(String maHD, String maPhong) {
		ArrayList<ChiTietDichVu> danhSachCTDichVu = new ArrayList<ChiTietDichVu>();
		DichVu_DAO DAO_DV = new DichVu_DAO();
		Phong_DAO DAO_P = new Phong_DAO();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM ChiTietDichVu where maHoaDon = ? and maPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maHD);
			statement.setString(2, maPhong);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				HoaDon hoaDon = new HoaDon(rs.getString("maHoaDon"));
				DichVu dv = DAO_DV.layDichVu_TheoMaDichVu(rs.getString("maDichVu"));
				int soLuong = rs.getInt("soLuong");
				Phong ph = DAO_P.timPhong_TheoMaPhong(rs.getString("maPhong"));
				ChiTietDichVu ctDichVu = new ChiTietDichVu(hoaDon, dv, soLuong, ph);
				danhSachCTDichVu.add(ctDichVu);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachCTDichVu;
	}

	public ArrayList<ChiTietDichVu> layDanhSachChiTietDichVu_TheoMaHoaDon(String maHD) {
		ArrayList<ChiTietDichVu> danhSachCTDichVu = new ArrayList<ChiTietDichVu>();
		DichVu_DAO DAO_DV = new DichVu_DAO();
		Phong_DAO DAO_P = new Phong_DAO();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM ChiTietDichVu where maHoaDon = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maHD);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				HoaDon hoaDon = new HoaDon(rs.getString("maHoaDon"));
				DichVu dv = DAO_DV.layDichVu_TheoMaDichVu(rs.getString("maDichVu"));
				int soLuong = rs.getInt("soLuong");
				Phong ph = DAO_P.timPhong_TheoMaPhong(rs.getString("maPhong"));
				ChiTietDichVu ctDichVu = new ChiTietDichVu(hoaDon, dv, soLuong, ph);
				danhSachCTDichVu.add(ctDichVu);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachCTDichVu;
	}

	public ChiTietDichVu timCTDichVu_TheoMaHoaDon(String maHD) {
		ChiTietDichVu ctDichVu = null;
		DichVu_DAO DAO_DV = new DichVu_DAO();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM ChiTietDichVu where maHoaDon = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maHD);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				HoaDon hoaDon = new HoaDon(rs.getString("maHoaDon"));

				DichVu dv = DAO_DV.layDichVu_TheoMaDichVu(rs.getString("maDichVu"));
				int soLuong = rs.getInt("soLuong");
				ctDichVu = new ChiTietDichVu(hoaDon, dv, soLuong);
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
		return ctDichVu;
	}

	public ChiTietDichVu timCTDichVu_TheoMaHoaDon_MaDichVu(String maHD, String maDV) {
		ChiTietDichVu ctDichVu = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM ChiTietDichVu" + " WHERE maHoaDon = ? AND maDichVu = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maHD);
			statement.setString(2, maDV);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				HoaDon hoaDon = new HoaDon(rs.getString("maHoaDon"));
				DichVu dichVu = new DichVu(rs.getString("maDichVu"));
				int soLuong = rs.getInt("soLuong");
				ctDichVu = new ChiTietDichVu(hoaDon, dichVu, soLuong);
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
		return ctDichVu;
	}

	public boolean taoCTDichVu(ChiTietDichVu ctDichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("INSERT INTO ChiTietDichVu values(?,?,?,?)");
			statement.setString(1, ctDichVu.getHoaDon().getMaHoaDon());
			statement.setString(2, ctDichVu.getDichVu().getMaDichVu());
			statement.setInt(3, ctDichVu.getSoLuong());
			statement.setString(4, ctDichVu.getPhong().getMaPhong());
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

	public boolean capNhatCTDichVu_TheoMaHoaDon(ChiTietDichVu ctDichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con
					.prepareStatement("UPDATE ChiTietDichVu SET soLuong = ?" + " WHERE maHoaDon = ? and maDichVu = ?");
			statement.setString(3, ctDichVu.getDichVu().getMaDichVu());
			statement.setInt(1, ctDichVu.getSoLuong());
			statement.setString(2, ctDichVu.getHoaDon().getMaHoaDon());
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

	public boolean capNhatCTDichVu_TheoMaDichVu(ChiTietDichVu ctDichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"UPDATE ChiTietDichVu SET maHoaDon = ?, soLuong = ?, maPhong = ?" + " WHERE maDichVu = ?");
			statement.setString(1, ctDichVu.getHoaDon().getMaHoaDon());
			statement.setInt(2, ctDichVu.getSoLuong());
			statement.setString(3, ctDichVu.getPhong().getMaPhong());
			statement.setString(4, ctDichVu.getDichVu().getMaDichVu());
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

	public boolean capNhatCTDichVu_Theo_MaHoaDon_MaDichVu_MaPhong(ChiTietDichVu ctDichVu) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"UPDATE ChiTietDichVu SET  soLuong = ?" + " WHERE maHoaDon = ? and maDichVu = ? and maPhong  = ?");
			statement.setInt(1, ctDichVu.getSoLuong());
			statement.setString(4, ctDichVu.getPhong().getMaPhong());
			statement.setString(2, ctDichVu.getHoaDon().getMaHoaDon());
			statement.setString(3, ctDichVu.getDichVu().getMaDichVu());
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

	public boolean capNhatCTDichVu_Theo_MaHoaDon_MaDichVu(ChiTietDichVu ctDichVu, String maPhongMoi) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"UPDATE ChiTietDichVu SET  soLuong = ?, maPhong  = ?" + " WHERE maHoaDon = ? and maDichVu = ?");
			statement.setInt(1, ctDichVu.getSoLuong());
			statement.setString(2, maPhongMoi);
			statement.setString(3, ctDichVu.getHoaDon().getMaHoaDon());
			statement.setString(4, ctDichVu.getDichVu().getMaDichVu());
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

	public boolean xoaCTDichVu_TheoMaHoaDon_TheoMaPhong(String hd, String maP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("DELETE ChiTietDichVu" + " WHERE maHoaDon = ? AND maPhong = ?");
			statement.setString(1, hd);
			statement.setString(2, maP);
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

	public boolean xoaCTDichVu_TheoMaHoaDon(String hd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("DELETE ChiTietDichVu" + " WHERE maHoaDon = ?");
			statement.setString(1, hd);
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

	public boolean xoaCTDichVu_TheoMaHD_MaP(ChiTietDichVu ctDichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"DELETE FROM ChiTietDichVu" + " WHERE maHoaDon = ? and maPhong = ? and maDichVu = ?");
			statement.setString(1, ctDichVu.getHoaDon().getMaHoaDon());
			statement.setString(3, ctDichVu.getDichVu().getMaDichVu());
			statement.setString(2, ctDichVu.getPhong().getMaPhong());
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

	public boolean xoaCTDichVu_TheoMaDichVu(ChiTietDichVu ctDichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("DELETE FROM ChiTietDichVu" + " FROM maDichVu = ?");
			statement.setString(1, ctDichVu.getDichVu().getMaDichVu());
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

	public boolean xoaCTDichVu_TheoMaHoaDon_MaDichVu(ChiTietDichVu ctDichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("DELETE FROM ChiTietDichVu" + " FROM maHoaDon = ? AND maDichVu = ?");
			statement.setString(1, ctDichVu.getHoaDon().getMaHoaDon());
			statement.setString(2, ctDichVu.getDichVu().getMaDichVu());
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
