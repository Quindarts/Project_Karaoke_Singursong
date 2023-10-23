package Entity;

import java.sql.Date;
import java.util.Objects;

/**
 * Khách hàng
 * @author THANH CUONG
 *
 */
public class KhachHang {
	private String maKhachHang;
	private String hoTen;
	private boolean gioiTinh;
	private Date ngaySinh;
	private String diaChi;
	private String soDienThoai;
	private int diemThuong;
	private String ghiChu;

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maKhachHang
	 * @param hoTen
	 * @param gioiTinh
	 * @param ngaySinh
	 * @param diaChi
	 * @param soDienThoai
	 * @param diemThuong
	 * @param ghiChu
	 */
	public KhachHang(String maKhachHang, String hoTen, boolean gioiTinh, Date ngaySinh, String diaChi,
			String soDienThoai, int diemThuong, String ghiChu) {
		super();
		this.maKhachHang = maKhachHang;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.diemThuong = diemThuong;
		this.ghiChu = ghiChu;
	}

	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public int getDiemThuong() {
		return diemThuong;
	}

	public void setDiemThuong(int diemThuong) {
		this.diemThuong = diemThuong;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maKhachHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKhachHang, other.maKhachHang);
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", ngaySinh="
				+ ngaySinh + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + ", diemThuong=" + diemThuong
				+ ", ghiChu=" + ghiChu + "]";
	}

}