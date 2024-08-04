package entity;

import java.sql.Date;
import java.util.Objects;

public class ThongTinDichVu {
	private String maThongTinDichVu;
	private int soLuong;
	private int soLuongDaSuDung;
	private Date ngayNhap;
	private Date ngayHetHan;
	private String moTa;
	private String hinhAnh;
	public ThongTinDichVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThongTinDichVu(String maThongTinDichVu) {
		super();
		this.maThongTinDichVu = maThongTinDichVu;
	}
	public ThongTinDichVu(String maThongTinDichVu,int soLuong, int soLuongDaSuDung, Date ngayNhap,
			Date ngayHetHan, String moTa, String hinhAnh) {
		super();
		this.maThongTinDichVu = maThongTinDichVu;
		this.soLuong = soLuong;
		this.soLuongDaSuDung = soLuongDaSuDung;
		this.ngayNhap = ngayNhap;
		this.ngayHetHan = ngayHetHan;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
	}
	public String getMaThongTinDichVu() {
		return maThongTinDichVu;
	}
	public void setMaThongTinDichVu(String maThongTinDichVu) {
		this.maThongTinDichVu = maThongTinDichVu;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getSoLuongDaSuDung() {
		return soLuongDaSuDung;
	}
	public void setSoLuongDaSuDung(int soLuongDaSuDung) {
		this.soLuongDaSuDung = soLuongDaSuDung;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public Date getNgayHetHan() {
		return ngayHetHan;
	}
	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maThongTinDichVu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThongTinDichVu other = (ThongTinDichVu) obj;
		return Objects.equals(maThongTinDichVu, other.maThongTinDichVu);
	}
	public int tinhSoLuongConLai() {
		if (getSoLuong() - getSoLuongDaSuDung() > 0)
			return getSoLuong() - getSoLuongDaSuDung();
		else {
			return 0;
		}
	}
	@Override
	public String toString() {
		return "ThongTinDichVu [maThongTinDichVu=" + maThongTinDichVu + "," + "soLuong=" + soLuong
				+ ", soLuongDaSuDung=" + soLuongDaSuDung + ", ngayNhap=" + ngayNhap + ", ngayHetHan=" + ngayHetHan
				+ ", moTa=" + moTa + ", hinhAnh=" + hinhAnh + "]";
	}
	
	
}