package entity;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ChiTietHoaDon {
	private HoaDon hoaDon;
	private Phong phong;

	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDon(HoaDon hoaDon, Phong phong) {
		super();
		this.hoaDon = hoaDon;
		this.phong = phong;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public double thanhTien(float soGioHat) {

		return (double) getPhong().getLoaiPhong().getGiaTien() * soGioHat;

	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + hoaDon + ", phong=" + phong + "]";
	}

}