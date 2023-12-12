package entity;

import java.util.Objects;

/**
 * TaiKhoan Le Minh Quang 20/10/2023
 */

public class TaiKhoan {
	private NhanVien nhanVien;
	private String tenDangNhap;
	private String matKhau;
	private boolean trangThai;
	private String email;

	/**
	 * @param maNhanVien
	 * @param tenDangNhap
	 * @param matKhau
	 * @param trangThai
	 */
	public TaiKhoan(NhanVien nhanVien, String tenDangNhap, String matKhau, boolean trangThai, String email) {
		super();
		this.nhanVien = nhanVien;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.trangThai = trangThai;
		this.email = email;
	}

	/**
	 * @param maNhanVien
	 */
	public TaiKhoan(NhanVien nhanVien) {
		super();
		this.nhanVien = nhanVien;
	}

	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "TaiKhoan [nhanVien=" + nhanVien + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
				+ ", trangThai=" + trangThai + ", email=" + email + "]";
	}

}