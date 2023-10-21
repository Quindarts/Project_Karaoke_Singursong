package Entity;

import java.util.Objects;

/**
 * Loại phòng
 * @author THANH CUONG
 *
 */
public class LoaiPhong {
	private String maLoaiPhong;
	private String tenLoaiPhong;
	private int soLuongToiDa;
	private double giaTien;
	private String hinhAnh;
	private String moTa;
	
	/**
	 * @param maLoaiPhong
	 * @param tenLoaiPhong
	 * @param soLuongToiDa
	 * @param giaTien
	 * @param hinhAnh
	 * @param moTa
	 */
	public LoaiPhong(String maLoaiPhong, String tenLoaiPhong, int soLuongToiDa, double giaTien, String hinhAnh,
			String moTa) {
		super();
		this.maLoaiPhong = maLoaiPhong;
		this.tenLoaiPhong = tenLoaiPhong;
		this.soLuongToiDa = soLuongToiDa;
		this.giaTien = giaTien;
		this.hinhAnh = hinhAnh;
		this.moTa = moTa;
	}
	public LoaiPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoaiPhong(String maLoaiPhong) {
		super();
		this.maLoaiPhong = maLoaiPhong;
	}
	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}
	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}
	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}
	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}
	public int getSoLuongToiDa() {
		return soLuongToiDa;
	}
	public void setSoLuongToiDa(int soLuongToiDa) {
		this.soLuongToiDa = soLuongToiDa;
	}
	public double getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maLoaiPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiPhong other = (LoaiPhong) obj;
		return Objects.equals(maLoaiPhong, other.maLoaiPhong);
	}
	@Override
	public String toString() {
		return "LoaiPhong [maLoaiPhong=" + maLoaiPhong + ", tenLoaiPhong=" + tenLoaiPhong + ", soLuongToiDa="
				+ soLuongToiDa + ", giaTien=" + giaTien + ", hinhAnh=" + hinhAnh + ", moTa=" + moTa + "]";
	}
	
	
}
