package Entity;

import java.util.Objects;

/**
 * LoaiNhanVien
 * @author THANH CUONG
 *
 */
public class LoaiNhanVien {
	private String maLoaiNhanVien;
	private String tenLoaiNhanVien;
	
	public LoaiNhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiNhanVien(String maLoaiNhanVien) {
		super();
		this.maLoaiNhanVien = maLoaiNhanVien;
	}

	/**
	 * @param maLoaiNhanVien
	 * @param tenLoaiNhanVien
	 */
	public LoaiNhanVien(String maLoaiNhanVien, String tenLoaiNhanVien) {
		super();
		this.maLoaiNhanVien = maLoaiNhanVien;
		this.tenLoaiNhanVien = tenLoaiNhanVien;
	}

	public String getMaLoaiNhanVien() {
		return maLoaiNhanVien;
	}

	public void setMaLoaiNhanVien(String maLoaiNhanVien) {
		this.maLoaiNhanVien = maLoaiNhanVien;
	}

	public String getTenLoaiNhanVien() {
		return tenLoaiNhanVien;
	}

	public void setTenLoaiNhanVien(String tenLoaiNhanVien) {
		this.tenLoaiNhanVien = tenLoaiNhanVien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLoaiNhanVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiNhanVien other = (LoaiNhanVien) obj;
		return Objects.equals(maLoaiNhanVien, other.maLoaiNhanVien);
	}

	@Override
	public String toString() {
		return "LoaiNhanVien [maLoaiNhanVien=" + maLoaiNhanVien + ", tenLoaiNhanVien=" + tenLoaiNhanVien + "]";
	}
	
}
