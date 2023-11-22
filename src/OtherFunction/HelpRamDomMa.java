package OtherFunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class HelpRamDomMa {

	public static String taoMa(String tenBang, String maTao, String type) {
		String result = type;
		String maFromData;

		LocalDate currentDate = LocalDate.now();
		int day = currentDate.getDayOfMonth();
		int month = currentDate.getMonthValue();
		int year = currentDate.getYear();

		LocalTime currentTime = LocalTime.now();
		int hour = currentTime.getHour();

		ArrayList<String> column = maToDaTaBase(tenBang, maTao);

		if (!column.isEmpty()) {
			maFromData = column.get(column.size() - 1);
		} else {
			maFromData = "";
		}

		if (hour >= 7 && hour <= 11) {
			result = result + day + "" + month + "" + year + "" + "A";
		} else if (hour >= 12 && hour <= 16) {
			result = result + day + "" + month + "" + year + "" + "B";
		} else if (hour >= 17 && hour <= 22) {
			result = result + day + "" + month + "" + year + "" + "C";
		} else {
			result = result + day + "" + month + "" + year + "" + "D";
		}
		if (maFromData.trim() != "" && !maFromData.trim().substring(maFromData.trim().length() - 3).equals("999")) {

			if (maFromData.trim().substring(0, 11).equals(result.substring(0, 11).trim())) {

				String str_base = maFromData.substring(11);

				String str_result = "";
				for (int i = 0; i < str_base.length(); i++) {
					char c = str_base.charAt(i);
					if (c != '0' || str_result.length() > 0 && str_result.charAt(str_result.length() - 1) != '0') {

						str_result = str_result + c;

					}

				}
				int count = Integer.parseInt(str_result.trim()) + 1;

				result = result + String.format("%03d", count);

			} else {
				result = result.concat("001");
			}
		} else {
			result = result.concat("001");
		}

		return result;
	}

	public static ArrayList<String> maToDaTaBase(String tenBang, String tenCot) {
		String jdbcUrl = "jdbc:sqlserver://localhost:1433;databasename=SingUrSong_vnew";
		String user = "sa";
		String password = "230903";
		String maHoaDon = "";
		String sql = "";
		if (tenBang.trim().equals("HoaDon")) {
			sql = "SELECT TOP 1 * " + " FROM  " + "  " + tenBang + "  " + tenCot + "  " + " ORDER BY ngayLap DESC";
		}
		if (tenBang.trim().equals("PhieuDatPhong")) {
			sql = "SELECT TOP 1 * " + " FROM  " + "  " + tenBang + "  " + tenCot + "  "
					+ " ORDER BY thoiGianDatPhong DESC";
		}
		ArrayList<String> maCot = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(jdbcUrl, user, password)) {

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				maHoaDon = rs.getString(tenCot);
				maCot.add(maHoaDon);
			}
			System.out.println(maCot);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(maCot);
		return maCot;
	}

	public static void main(String[] args) {

//		String maHoaDon = taoMa("HoaDon", "maHoaDon", "HD");
		String maPhieuDat = taoMa("HoaDon", "maHoaDon", "HD");
		String maPhieuDat2 = taoMa("PhieuDatPhong", "maPhieuDat", "PD");
		System.out.println(maPhieuDat);
		System.out.println(maPhieuDat2);
	}

}