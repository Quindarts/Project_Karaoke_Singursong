package Entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument;

/**
 * HoaDon trangThai:
 * 
 * 
 */
public class HoaDon {
	// Danh sách "ChiTietDichVu" và "ChiTietHoaDon"

	private String maHoaDon;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private PhieuDatPhong phieuDatPhong;
	private KhuyenMai khuyenMai;
	private Timestamp ngayLap;
	private String trangThai;
	private Timestamp thoiGianKetThuc;

	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDon(String maHoaDon, KhachHang khachHang, NhanVien nhanVien, PhieuDatPhong phieuDatPhong,
			KhuyenMai khuyenMai, Timestamp ngayLap, String trangThai, Timestamp thoiGianKetThuc) {
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

	public float tinhGioHat() {
		// Lấy Timestamp kết thúc từ đối tượng HoaDon
		long gioHat = 0;
		float result ;
		if (getThoiGianKetThuc() != null) {
			Timestamp thoiGianKetThuc = getThoiGianKetThuc();
			// Lấy Timestamp đặt phòng từ đối tượng PhieuDatPhong
			Timestamp thoiGianNhanPhong = getNgayLap();

			// Chuyển Timestamp thành LocalDateTime

			LocalDateTime ketThuc = thoiGianKetThuc.toLocalDateTime();
			LocalDateTime batDau = thoiGianNhanPhong.toLocalDateTime();

			// Tính khoảng thời gian (duration) giữa hai thời điểm
			Duration duration = Duration.between(batDau, ketThuc);

			// Chuyển khoảng thời gian thành số giờ
			gioHat = duration.toMinutes() ;
			result =(float) gioHat / 60;
		} else {
			// Lấy thời gian hiện tại
			long currentTimeMillis = System.currentTimeMillis();

			// Tạo đối tượng Timestamp từ thời gian hiện tại
			Timestamp currentTimestamp = new Timestamp(currentTimeMillis);
			Timestamp thoiGianNhanPhong = getNgayLap();

			Duration duration = Duration.between(thoiGianNhanPhong.toLocalDateTime(),
					currentTimestamp.toLocalDateTime());
			gioHat = duration.toMinutes();

			// In ra timestamp
			
			result =(float) gioHat / 60;
		}
		return   result;// Trả về giờ hát dưới dạng số nguyên
		
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

	public Timestamp getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Timestamp ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public Timestamp getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Timestamp thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public long tinhTienPhong(ArrayList<ChiTietHoaDon> dsCTHD) {
		long sum = 0;
		for (ChiTietHoaDon chiTietHoaDon : dsCTHD) {
			sum += chiTietHoaDon.thanhTien(tinhGioHat());
		}
		return sum;
	}

	public double tinhTienDichVu(ArrayList<ChiTietDichVu> dsCTDV) {
		double sum = 0;
		if (dsCTDV == null)
			return 0;
		for (ChiTietDichVu chiTietDichVu : dsCTDV) {
			sum += chiTietDichVu.thanhTien();
		}
		return sum;
	}

	public double tinhTongTien(ArrayList<ChiTietHoaDon> dsCTHD, ArrayList<ChiTietDichVu> dsCTDV) {
		if (dsCTDV == null)
			return 0;
		int thoiGian = 0;
		double sum = tinhTienDichVu(dsCTDV) + tinhTienPhong(dsCTHD);
		double chietKhau = ((this.khuyenMai.getChietKhau()) / 100) * sum;
		return sum + chietKhau;
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien
				+ ", phieuDatPhong=" + phieuDatPhong + ", khuyenMai=" + khuyenMai + ", ngayLap=" + ngayLap
				+ ", trangThai=" + trangThai + ", thoiGianKetThuc=" + thoiGianKetThuc + "]";
	}

}