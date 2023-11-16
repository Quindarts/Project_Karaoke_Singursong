package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.itextpdf.text.List;

import ConnectDB.ConnectDB;
import Entity.ChiTietDichVu;
import Entity.HoaDon;
import Entity.DichVu;

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

	public ArrayList<ChiTietDichVu> layDanhSachChiTietDichVu_TheoMaHoaDon(String maHD) {
		ArrayList<ChiTietDichVu> danhSachCTDichVu = new ArrayList<ChiTietDichVu>();
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
				ChiTietDichVu ctDichVu = new ChiTietDichVu(hoaDon, dv, soLuong);
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
			statement = con.prepareStatement("INSERT INTO ChiTietDichVu values(?,?,?)");
			statement.setString(1, ctDichVu.getHoaDon().getMaHoaDon());
			statement.setString(2, ctDichVu.getDichVu().getMaDichVu());
			statement.setInt(3, ctDichVu.getSoLuong());
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
			statement = con
					.prepareStatement("UPDATE ChiTietDichVu SET maHoaDon = ?, soLuong = ?" + " WHERE maDichVu = ?");
			statement.setString(1, ctDichVu.getHoaDon().getMaHoaDon());
			statement.setInt(2, ctDichVu.getSoLuong());
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

	public boolean capNhatCTDichVu_TheoMaHoaDon_MaDichVu(ChiTietDichVu ctDichVu) {
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con
					.prepareStatement("UPDATE ChiTietDichVu SET  soLuong = ?" + " WHERE maHoaDon = ? and maDichVu = ?");
			statement.setInt(1, ctDichVu.getSoLuong());
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
