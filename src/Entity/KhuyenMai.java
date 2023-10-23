package Entity;

import java.sql.Date;
import java.util.Objects;

public class KhuyenMai {
	private String maKhuyenMai;
	private String tenKhuyenMai;
	private String maGiamGia;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private int tongSoLuong;
	private double chietKhau;
	private String moTa;
	public KhuyenMai() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, String maGiamGia, Date ngayBatDau, Date ngayKetThuc,
			int tongSoLuong, double chietKhau, String moTa) {
		super();
		this.maKhuyenMai = maKhuyenMai;
		this.tenKhuyenMai = tenKhuyenMai;
		this.maGiamGia = maGiamGia;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.tongSoLuong = tongSoLuong;
		this.chietKhau = chietKhau;
		this.moTa = moTa;
	}
	public KhuyenMai(String maKhuyenMai) {
		super();
		this.maKhuyenMai = maKhuyenMai;
	}
	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}
	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}
	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}
	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}
	public String getMaGiamGia() {
		return maGiamGia;
	}
	public void setMaGiamGia(String maGiamGia) {
		this.maGiamGia = maGiamGia;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public int getTongSoLuong() {
		return tongSoLuong;
	}
	public void setTongSoLuong(int tongSoLuong) {
		this.tongSoLuong = tongSoLuong;
	}
	public double getChietKhau() {
		return chietKhau;
	}
	public void setChietKhau(double chietKhau) {
		this.chietKhau = chietKhau;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKhuyenMai);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhuyenMai other = (KhuyenMai) obj;
		return Objects.equals(maKhuyenMai, other.maKhuyenMai);
	}
	@Override
	public String toString() {
		return "KhuyenMai [maKhuyenMai=" + maKhuyenMai + ", tenKhuyenMai=" + tenKhuyenMai + ", maGiamGia=" + maGiamGia
				+ ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", tongSoLuong=" + tongSoLuong
				+ ", chietKhau=" + chietKhau + ", moTa=" + moTa + "]";
	}
	
	
}