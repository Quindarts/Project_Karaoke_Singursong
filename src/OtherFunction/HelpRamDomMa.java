package OtherFunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import ConnectDB.ConnectDB;

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

		String fd_day = String.valueOf(day);
		String fd_month = String.valueOf(month);
		if (day >= 0 && day <= 9) {
			fd_day = "0" + fd_day;
		}
		if (month >= 0 && month <= 9) {
			fd_month = "0" + fd_month;
		}

		ArrayList<String> column = maToDaTaBase(tenBang, maTao);

		if (!column.isEmpty()) {
			maFromData = column.get(column.size() - 1);
		} else {
			maFromData = "";
		}

		if (hour >= 7 && hour <= 11) {
			result = result + fd_day + "" + fd_month + "" + year + "" + "A";
		} else if (hour >= 12 && hour <= 16) {

			result = result + fd_day + "" + fd_month + "" + year + "" + "B";

		} else if (hour >= 17 && hour <= 22) {

			result = result + fd_day + "" + fd_month + "" + year + "" + "C";

		} else {

			result = result + fd_day + "" + fd_month + "" + year + "" + "D";

		}
		if (maFromData.trim() != "" && !maFromData.trim().substring(maFromData.trim().length() - 3).equals("999")) {

			if (maFromData.trim().length() >= 11 && result.length() >= 11
					&& maFromData.trim().substring(0, 11).equals(result.substring(0, 11).trim())) {

				String str_base = maFromData.substring(11);

				String str_result = "";
				for (int i = 0; i < str_base.length(); i++) {
					char c = str_base.charAt(i);

					if (c != '0' || str_result.length() > 0 && str_result.charAt(str_result.length() - 1) != '0') {

						str_result = str_result + c;

					}

				}
				int count = Integer.parseInt(cutString(str_base)) + 1;

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
			sql = "SELECT * " + " FROM  " + "  " + tenBang + "  " + tenCot + "  "
					+ "WHERE  ngayLap = (SELECT MAX(ngayLap) FROM HoaDon)";
		}
		if (tenBang.trim().equals("PhieuDatPhong")) {
			sql = "SELECT TOP 1 * " + " FROM  " + "  " + tenBang + "  " + tenCot + "  "
					+ " ORDER BY thoiGianDatPhong DESC";
		}
		ArrayList<String> maCot = new ArrayList<>();
		System.out.println(sql);
		try (Connection con = DriverManager.getConnection(jdbcUrl, user, password)) {

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				maHoaDon = rs.getString(tenCot);
				maCot.add(maHoaDon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (tenBang.trim().equals("HoaDon")) {
			
			String ma = maCot.get(0);
			for (int i = 0; i < maCot.size() - 1; i++) {
				for (int j = i + 1; j < maCot.size(); j++) {
					ma = soSanhMa(maCot.get(i), maCot.get(j));

				}

			}
			ArrayList<String> maCot2 = new ArrayList<>();
			System.out.println(maCot2);
			maCot2.add(ma);

			return maCot2;
		}
		return maCot;
	}

	public static String cutString(String x) {
		String laySoCuoiX = x.trim().substring(x.length() - 4);
		String formatX = "";
		int flag = 0;
		for (int i = 0; i < laySoCuoiX.length(); i++) {
			char c = laySoCuoiX.charAt(i);
			if (c != '0') {
				formatX = formatX + c;
				flag = i + 1;
				break;
			}
		}
		for (int i = flag; i < laySoCuoiX.length(); i++) {
			char c = laySoCuoiX.charAt(i);
			formatX = formatX + c;
		}
		return formatX;
	}

	public static String soSanhMa(String a, String b) {

		int valueA = Integer.parseInt(cutString(a));
		int valueB = Integer.parseInt(cutString(b));

		char charA = a.charAt(10);
		char charB = b.charAt(10);
		if (charA == charB) {
			if (valueA > valueB)
				return a;
			else
				return b;
		}
		if (charA < charB)
			return b;
		else {
			return a;
		}

	}

	public static void main(String[] args) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String maHD = taoMa("HoaDon", "maHoaDon", "HD");
		String maPhieuDat2 = taoMa("PhieuDatPhong", "maPhieuDat", "PD");
		System.out.println(maHD);

	}

}