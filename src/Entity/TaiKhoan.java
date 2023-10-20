package Entity;

import java.util.Objects;

public class TaiKhoan {
	private String maNhanVien;
	private String tenDangNhap;
	private String matKhau;
	private boolean trangThai;
	public TaiKhoan(String maNhanVien, String tenDangNhap, String matKhau, boolean trangThai) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.trangThai = trangThai;
	}
	public TaiKhoan(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
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
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(maNhanVien, other.maNhanVien);
	}
	@Override
	public String toString() {
		return "tenDangNhap [maNhanVien=" + maNhanVien + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", trangThai="
				+ trangThai + "]";
	}
		
	
	

}
