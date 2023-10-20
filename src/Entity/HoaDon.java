package Entity;

import java.sql.Date;

public class HoaDon {
	private String maHoaDon;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private PhieuDatPhong phieuDatPhong;
	private KhuyenMai khuyenMai;
	private Date ngayLap;
	private String trangThai;
	private Date thoiGianKetThuc;
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(String maHoaDon, KhachHang khachHang, NhanVien nhanVien, PhieuDatPhong phieuDatPhong,
			KhuyenMai khuyenMai, Date ngayLap, String trangThai, Date thoiGianKetThuc) {
		super();
		this.maHoaDon = maHoaDon;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.phieuDatPhong = phieuDatPhong;
		this.khuyenMai = khuyenMai;
		this.ngayLap = ngayLap;
		this.trangThai = trangThai;
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public PhieuDatPhong getPhieuDatPhong() {
		return phieuDatPhong;
	}
	public void setPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		this.phieuDatPhong = phieuDatPhong;
	}
	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}
	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public Date getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(Date thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien
				+ ", phieuDatPhong=" + phieuDatPhong + ", khuyenMai=" + khuyenMai + ", ngayLap=" + ngayLap
				+ ", trangThai=" + trangThai + ", thoiGianKetThuc=" + thoiGianKetThuc + "]";
	}
	
	
}