package other;

import javax.swing.JOptionPane;

public class HelpValidate {

	private String regexTenDangNhap = "/^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/";

	/**
	 * @regexTenDangNhap 
	 * Số điện thoại Là dãy 10 chữ số.
	 * Chữ số đầu tiên là số 0.
	 * 
	 **/
	private String regexMatKhau = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}";

	/**
	 * @regexMatKhau 
	 * (?=.*[0-9]):	một chữ số phải xuất hiện ít nhất một lần
	 * (?=.*[a-z]):	một chữ cái viết thường phải xuất hiện ít nhất một lần
	 * (?=.*[A-Z]): một chữ cái viết hoa phải xuất hiện ít nhất một lần 
	 * (?=.*[@#$%^&+=]): một ký tự đặc biệt phải xuất hiện ít nhất một lần 
	 * (?=\\S+$):	không cho phép khoảng trắng trong toàn bộ chuỗi .{8,}ít nhất 8 ký tự
	 ***/

	private String regexNgayTaoPhong;
	
	private String regexTien;
	
	private String regexEmail = "[A-Za-z0-9.]+@[A-Za-z]+.[A-Za-z]+";
	
	private String regexNgayNhapDichVu;
	
	private String regexSoDienThoai = "/^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/";
	private String regexCCCD;
	
	private String regexHoTen = "[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\\r\\n\"\r\n"
			+ "					+ \"fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\\r\\n\"\r\n"
			+ "					+ \"UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ]+";
	
	private String regexNgayLapHoaDon;
	
	private String regexNgayXuatHoaDon;
	
	private int regexTuoi = 18;

	public String getRegexTenDangNhap() {
		return regexTenDangNhap;
	}

	public void setRegexTenDangNhap(String regexTenDangNhap) {
		this.regexTenDangNhap = regexTenDangNhap;
	}

	public String getRegexMatKhau() {
		return regexMatKhau;
	}

	public void setRegexMatKhau(String regexMatKhau) {
		this.regexMatKhau = regexMatKhau;
	}

	public String getRegexNgayTaoPhong() {
		return regexNgayTaoPhong;
	}

	public void setRegexNgayTaoPhong(String regexNgayTaoPhong) {
		this.regexNgayTaoPhong = regexNgayTaoPhong;
	}

	public String getRegexTien() {
		return regexTien;
	}

	public void setRegexTien(String regexTien) {
		this.regexTien = regexTien;
	}

	public String getRegexEmail() {
		return regexEmail;
	}

	public void setRegexEmail(String regexEmail) {
		this.regexEmail = regexEmail;
	}

	public String getRegexNgayNhapDichVu() {
		return regexNgayNhapDichVu;
	}

	public void setRegexNgayNhapDichVu(String regexNgayNhapDichVu) {
		this.regexNgayNhapDichVu = regexNgayNhapDichVu;
	}

	public String getRegexSoDienThoai() {
		return regexSoDienThoai;
	}

	public void setRegexSoDienThoai(String regexSoDienThoai) {
		this.regexSoDienThoai = regexSoDienThoai;
	}

	public String getRegexCCCD() {
		return regexCCCD;
	}

	public void setRegexCCCD(String regexCCCD) {
		this.regexCCCD = regexCCCD;
	}

	public String getRegexHoTen() {
		return regexHoTen;
	}

	public void setRegexHoTen(String regexHoTen) {
		this.regexHoTen = regexHoTen;
	}

	public String getRegexNgayLapHoaDon() {
		return regexNgayLapHoaDon;
	}

	public void setRegexNgayLapHoaDon(String regexNgayLapHoaDon) {
		this.regexNgayLapHoaDon = regexNgayLapHoaDon;
	}

	public String getRegexNgayXuatHoaDon() {
		return regexNgayXuatHoaDon;
	}

	public void setRegexNgayXuatHoaDon(String regexNgayXuatHoaDon) {
		this.regexNgayXuatHoaDon = regexNgayXuatHoaDon;
	}

	public int getRegexTuoi() {
		return regexTuoi;
	}

	public void setRegexTuoi(int regexTuoi) {
		this.regexTuoi = regexTuoi;
	}
}
