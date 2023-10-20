package Entity;

public class ChiTietHoaDon {
	private HoaDon hoaDon;
	private Phong phong;
	private double soGioHat;
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDon(HoaDon hoaDon, Phong phong) {
		super();
		this.hoaDon = hoaDon;
		this.phong = phong;
	}
	public ChiTietHoaDon(HoaDon hoaDon, Phong phong, double soGioHat) {
		super();
		this.hoaDon = hoaDon;
		this.phong = phong;
		this.soGioHat = soGioHat;
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
	public double getSoGioHat() {
		return soGioHat;
	}
	public void setSoGioHat(double soGioHat) {
		this.soGioHat = soGioHat;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + hoaDon + ", phong=" + phong + ", soGioHat=" + soGioHat + "]";
	}
	
}