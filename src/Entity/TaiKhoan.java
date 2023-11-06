package Entity;

import java.util.Objects;

/**
 * TaiKhoan Le Minh Quang 20/10/2023
 */

public class TaiKhoan {
	private NhanVien nhanVien;
	private String tenDangNhap;
	private String matKhau;
	private String gmail;
	private boolean trangThai;

	/**
	 * @param maNhanVien
	 */
	public TaiKhoan(NhanVien nhanVien) {
		super();
		this.nhanVien = nhanVien;
	}

	/**
	 * @param nhanVien
	 * @param tenDangNhap
	 * @param matKhau
	 * @param gmail
	 * @param trangThai
	 */
	public TaiKhoan(NhanVien nhanVien, String tenDangNhap, String matKhau, String gmail, boolean trangThai) {
		super();
		this.nhanVien = nhanVien;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.gmail = gmail;
		this.trangThai = trangThai;
	}

	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}	

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}


	public String gettenDangNhap() {
		return tenDangNhap;
	}

	public void settenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nhanVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(nhanVien, other.nhanVien);
	}

	@Override
	public String toString() {
		return "TaiKhoan [nhanVien=" + nhanVien + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", gmail="
				+ gmail + ", trangThai=" + trangThai + "]";
	}



}