package OtherFunction;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HelpDate {

	public static String chuyenDateThanhString(Date date) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String ngayThang;

		if (date != null) {
			ngayThang = simpleDateFormat.format(date);
		} else {
			ngayThang = "";
		}
		return ngayThang;

	}

	public static Date chuyenStringThanhDate(String ngayThang) {

		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

			java.util.Date date = null;
			date = simpleDateFormat.parse(ngayThang);
			@SuppressWarnings("deprecation")
			Date source = new Date(date.getYear(), date.getMonth(), date.getDate());

			return source;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}