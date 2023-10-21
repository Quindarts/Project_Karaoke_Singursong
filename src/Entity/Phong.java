package Entity;

import java.util.Objects;

/**
 * Phòng
 * @author THANH CUONG
 *
 */
public class Phong {
	private String maPhong;
	private String tenPhong;
	private LoaiNhanVien loaiNhanVien;
	private TrangThaiPhong trangThaiPhong;
	private String viTriPhong;
	private String ghiChu;
	private String tinhTrangPhong;
	public Phong() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param maPhong
	 * @param tenPhong
	 * @param loaiNhanVien
	 * @param trangThaiPhong
	 * @param viTriPhong
	 * @param ghiChu
	 * @param tinhTrangPhong
	 */
	public Phong(String maPhong, String tenPhong, LoaiNhanVien loaiNhanVien, TrangThaiPhong trangThaiPhong,
			String viTriPhong, String ghiChu, String tinhTrangPhong) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.loaiNhanVien = loaiNhanVien;
		this.trangThaiPhong = trangThaiPhong;
		this.viTriPhong = viTriPhong;
		this.ghiChu = ghiChu;
		this.tinhTrangPhong = tinhTrangPhong;
	}
	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public LoaiNhanVien getLoaiNhanVien() {
		return loaiNhanVien;
	}
	public void setLoaiNhanVien(LoaiNhanVien loaiNhanVien) {
		this.loaiNhanVien = loaiNhanVien;
	}
	public TrangThaiPhong getTrangThaiPhong() {
		return trangThaiPhong;
	}
	public void setTrangThaiPhong(TrangThaiPhong trangThaiPhong) {
		this.trangThaiPhong = trangThaiPhong;
	}
	public String getViTriPhong() {
		return viTriPhong;
	}
	public void setViTriPhong(String viTriPhong) {
		this.viTriPhong = viTriPhong;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getTinhTrangPhong() {
		return tinhTrangPhong;
	}
	public void setTinhTrangPhong(String tinhTrangPhong) {
		this.tinhTrangPhong = tinhTrangPhong;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phong other = (Phong) obj;
		return Objects.equals(maPhong, other.maPhong);
	}
	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", loaiNhanVien=" + loaiNhanVien
				+ ", trangThaiPhong=" + trangThaiPhong + ", viTriPhong=" + viTriPhong + ", ghiChu=" + ghiChu
				+ ", tinhTrangPhong=" + tinhTrangPhong + "]";
	}
	
	
}