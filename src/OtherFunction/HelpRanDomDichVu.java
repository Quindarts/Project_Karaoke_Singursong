package OtherFunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import DAO.DichVu_DAO;
import DAO.ThongTinDichVu_DAO;
import Entity.DichVu;
import Entity.ThongTinDichVu;

public class HelpRanDomDichVu {
	public static String taoMaDV() {
		long ma = 10000000;
		DichVu_DAO DV_DAO = new DichVu_DAO();
		ThongTinDichVu_DAO TTDV_DAO = new ThongTinDichVu_DAO();
		List<DichVu> list = DV_DAO.layTatCaDichVu();

		for (int i = 0; i < list.size(); i++) {
			if (i == (list.size() - 1)) {
				String chuoi[] = list.get(i).getMaDichVu().trim().split("V");
				System.out.println(chuoi[1]);
				ma = Long.parseLong(chuoi[1]) + 1;
			}
		}
		return "DV" + ma;
	}

	public static String taoMaTTDV() {
		long ma = 10000000;
		DichVu_DAO DV_DAO = new DichVu_DAO();
		ThongTinDichVu_DAO TTDV_DAO = new ThongTinDichVu_DAO();
		List<ThongTinDichVu> list = TTDV_DAO.layTatCaThongTinDichVu();

		for (int i = 0; i < list.size(); i++) {
			if (i == (list.size() - 1)) {
				String chuoi[] = list.get(i).getMaThongTinDichVu().trim().split("V");
				System.out.println(chuoi[1]);
				ma = Long.parseLong(chuoi[1]) + 1;
			}
		}
		return "TTDV" + ma;
	}

	public static void main(String[] args) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String maDV = taoMaDV();
		String maTTDV = taoMaTTDV();
		System.out.println(maTTDV);
	}
}
