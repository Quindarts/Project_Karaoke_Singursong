package entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Phiếu Đặt Phòng
 * @author THANH CUONG
 *
 */

public class PhieuDatPhong {
	private String maPhieuDat;
	private Phong phong;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private Timestamp thoiGianDatPhong;
	private Timestamp thoiGianNhanPhong;
	private double tienCoc;
	
	private String trangThai;
	private String moTa;
	public PhieuDatPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param maPhieuDat
	 * @param phong
	 * @param nhanVien
	 * @param khachHang
	 * @param tgDatPhong
	 * @param tgNhanPhong
	 * @param tienCoc
	 * @param trangThai
	 * @param moTa
	 */
	public PhieuDatPhong(String maPhieuDat, Phong phong, NhanVien nhanVien, KhachHang khachHang, java.util.Date tgDatPhong,
			java.sql.Timestamp tgNhanPhong, double tienCoc, String trangThai, String moTa) {
		super();
		this.maPhieuDat = maPhieuDat;
		this.phong = phong;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.thoiGianDatPhong =  (java.sql.Timestamp) tgDatPhong;
		this.thoiGianNhanPhong =  (java.sql.Timestamp) tgNhanPhong;
		this.tienCoc = tienCoc;
		this.trangThai = trangThai;
		this.moTa = moTa;
	}
	public PhieuDatPhong(String maPhieuDat) {
		super();
		this.maPhieuDat = maPhieuDat;
	}
	public String getMaPhieuDat() {
		return maPhieuDat;
	}
	public void setMaPhieuDat(String maPhieuDat) {
		this.maPhieuDat = maPhieuDat;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public Timestamp getThoiGianDatPhong() {
		return thoiGianDatPhong;
	}
	public void setThoiGianDatPhong(Timestamp thoiGianDatPhong) {
		this.thoiGianDatPhong = thoiGianDatPhong;
	}
	public Timestamp getThoiGianNhanPhong() {
		return thoiGianNhanPhong;
	}
	public void setThoiGianNhanPhong(Timestamp thoiGianNhanPhong) {
		this.thoiGianNhanPhong = thoiGianNhanPhong;
	}
	public double getTienCoc() {
		return tienCoc;
	}
	public void setTienCoc(double tienCoc) {
		this.tienCoc = tienCoc;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhieuDat);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuDatPhong other = (PhieuDatPhong) obj;
		return Objects.equals(maPhieuDat, other.maPhieuDat);
	}
	@Override
	public String toString() {
		return "PhieuDatPhong [maPhieuDat=" + maPhieuDat + ", phong=" + phong + ", nhanVien=" + nhanVien
				+ ", khachHang=" + khachHang + ", thoiGianDatPhong=" + thoiGianDatPhong + ", thoiGianNhanPhong="
				+ thoiGianNhanPhong + ", tienCoc=" + tienCoc + ", trangThai=" + trangThai + ", moTa=" + moTa + "]";
	}
	
	
	
}