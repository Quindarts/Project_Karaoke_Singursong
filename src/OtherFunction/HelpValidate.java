package OtherFunction;

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
	
	private String regexTien = "^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+ [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(?: [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*";
	
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
}
