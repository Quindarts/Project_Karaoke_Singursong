package entity;

import java.util.ArrayList;

/**
 * ChiTietDichVu
 */
public class ChiTietDichVu {



	private HoaDon hoaDon;
	private DichVu dichVu;
	private int soLuong;
	private Phong phong;

	public ChiTietDichVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public ChiTietDichVu(HoaDon hoaDon, DichVu dichVu, int soLuong) {
		super();
		this.hoaDon = hoaDon;
		this.dichVu = dichVu;
		this.soLuong = soLuong;
	}

	public ChiTietDichVu(HoaDon hoaDon, DichVu dichVu, int soLuong, Phong phong) {
		super();
		this.hoaDon = hoaDon;
		this.dichVu = dichVu;
		this.soLuong = soLuong;
		this.phong = phong;
	}

	public ChiTietDichVu(HoaDon hoaDon, DichVu dichVu) {
		super();
		this.hoaDon = hoaDon;
		this.dichVu = dichVu;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double thanhTien() {
		return (double) getSoLuong() * getDichVu().getDonGia();

	}

	@Override
	public String toString() {
		return "ChiTietDichVu [hoaDon=" + hoaDon + ", dichVu=" + dichVu + ", soLuong=" + soLuong + "]";
	}

}