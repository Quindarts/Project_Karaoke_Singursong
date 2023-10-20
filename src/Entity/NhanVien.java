package Entity;

import java.sql.Date;
import java.util.Objects;

/**
 * NhanVien
 * @author THANH CUONG
 *
 */
public class NhanVien {
	private String maNhanVien;
	private LoaiNhanVien loaiNhanVien;
	private String hoTen;
	private boolean gioiTinh;
	private Date ngaySinh;
	private String soDienThoai;
	private String CCCD;
	private String diaChi;
	private String trangThai;
	private String anhThe;
	
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	/**
	 * @param maNhanVien
	 * @param loaiNhanVien
	 * @param hoTen
	 * @param gioiTinh
	 * @param ngaySinh
	 * @param soDienThoai
	 * @param cCCD
	 * @param diaChi
	 * @param trangThai
	 * @param anhThe
	 * @param tenDangNhap
	 */
	public NhanVien(String maNhanVien, LoaiNhanVien loaiNhanVien, String hoTen, boolean gioiTinh, Date ngaySinh,
			String soDienThoai, String cCCD, String diaChi, String trangThai, String anhThe) {
		super();
		this.maNhanVien = maNhanVien;
		this.loaiNhanVien = loaiNhanVien;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.CCCD = cCCD;
		this.diaChi = diaChi;
		this.trangThai = trangThai;
		this.anhThe = anhThe;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public LoaiNhanVien getloaiNhanVien() {
		return loaiNhanVien;
	}

	public void setloaiNhanVien(LoaiNhanVien loaiNhanVien) {
		this.loaiNhanVien = loaiNhanVien;
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

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getCCCD() {
		return CCCD;
	}

	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getAnhThe() {
		return anhThe;
	}

	public void setAnhThe(String anhThe) {
		this.anhThe = anhThe;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNhanVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNhanVien, other.maNhanVien);
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", loaiNhanVien=" + loaiNhanVien + ", hoTen=" + hoTen
				+ ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", soDienThoai=" + soDienThoai + ", CCCD="
				+ CCCD + ", diaChi=" + diaChi + ", trangThai=" + trangThai + ", anhThe=" + anhThe +  "]";
	}


}
