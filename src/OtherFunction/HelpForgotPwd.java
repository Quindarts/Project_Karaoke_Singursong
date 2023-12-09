package OtherFunction;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class HelpForgotPwd {

	private static final String CHARACTERS = "0123456789";
	private static SecureRandom secureRandom = new SecureRandom();

	public static String generateRandomString() {
		StringBuilder randomString = new StringBuilder(6);
		for (int i = 0; i < 6; i++) {
			int randomIndex = secureRandom.nextInt(CHARACTERS.length());
			randomString.append(CHARACTERS.charAt(randomIndex));
		}
		return randomString.toString();
	}

	public static void updatePwd(String tenDangNhap, String email) {
		String jdbcUrl = "jdbc:sqlserver://localhost:1433;databasename=SingUrSong_vnew";
		String user = "sa";
		String password = "230903";
		String newPwd = generateRandomString();
		int n = 0;

		try {
			Connection con = DriverManager.getConnection(jdbcUrl, user, password);
			String sql = "UPDATE TaiKhoan SET matKhau= ? WHERE tenDangNhap = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, newPwd);
			preparedStatement.setString(2, tenDangNhap);

			n = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		if (n > 0) {
			HelpEmail.sendMail(email, "Gửi từ SingUrSong karaoke", "Mã xác nhận của bạn là: " + newPwd);
		}

	}

	public static void main(String[] args) {
		updatePwd("NV42560001", "nguyenthientu413@gmail.com");
	}
}