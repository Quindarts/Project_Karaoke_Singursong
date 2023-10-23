package Entity;

<<<<<<< HEAD

import java.sql.Date;
import java.util.Objects;

=======
import java.util.Objects;

>>>>>>> 9ac1a29a9c58755f34f7f7c2a2297bbbb3854160
/**
 * Phòng
 * @author THANH CUONG
 *
 */
public class Phong {
	private String maPhong;
	private String tenPhong;
<<<<<<< HEAD
	private LoaiPhong loaiPhong;
	private TrangThaiPhong trangThaiPhong;
	private Date ngayTaoPhong;
=======
	private TrangThaiPhong trangThaiPhong;
>>>>>>> 9ac1a29a9c58755f34f7f7c2a2297bbbb3854160
	private String viTriPhong;
	private String ghiChu;
	private String tinhTrangPhong;
	public Phong() {
		super();
		// TODO Auto-generated constructor stub
	}
<<<<<<< HEAD
	/**
	 * @param maPhong
	 * @param tenPhong
	 * @param loaiNhanVien
=======

	
	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}
	/**
	 * @param maPhong
	 * @param tenPhong
>>>>>>> 9ac1a29a9c58755f34f7f7c2a2297bbbb3854160
	 * @param trangThaiPhong
	 * @param viTriPhong
	 * @param ghiChu
	 * @param tinhTrangPhong
	 */
<<<<<<< HEAD
	public Phong(String maPhong, String tenPhong, LoaiPhong loaiPhong, TrangThaiPhong trangThaiPhong, Date ngayTaoPhong,
			String viTriPhong, String ghiChu, String tinhTrangPhong) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.loaiPhong = loaiPhong;
		this.trangThaiPhong = trangThaiPhong;
		this.ngayTaoPhong = ngayTaoPhong;
=======
	public Phong(String maPhong, String tenPhong, TrangThaiPhong trangThaiPhong, String viTriPhong, String ghiChu,
			String tinhTrangPhong) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.trangThaiPhong = trangThaiPhong;
>>>>>>> 9ac1a29a9c58755f34f7f7c2a2297bbbb3854160
		this.viTriPhong = viTriPhong;
		this.ghiChu = ghiChu;
		this.tinhTrangPhong = tinhTrangPhong;
	}
<<<<<<< HEAD
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
	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public TrangThaiPhong getTrangThaiPhong() {
		return trangThaiPhong;
	}
	public void setTrangThaiPhong(TrangThaiPhong trangThaiPhong) {
		this.trangThaiPhong = trangThaiPhong;
	}
	public Date getNgayTaoPhong() {
		return ngayTaoPhong;
	}
	public void setNgayTaoPhong(Date ngayTaoPhong) {
		this.ngayTaoPhong = ngayTaoPhong;
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
=======

	
>>>>>>> 9ac1a29a9c58755f34f7f7c2a2297bbbb3854160
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
<<<<<<< HEAD
	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", loaiPhong=" + loaiPhong + ", trangThaiPhong="
				+ trangThaiPhong + ", ngayTaoPhong=" + ngayTaoPhong + ", viTriPhong=" + viTriPhong + ", ghiChu="
				+ ghiChu + ", tinhTrangPhong=" + tinhTrangPhong + "]";
	}
	
	
	
}
=======


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
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", trangThaiPhong=" + trangThaiPhong
				+ ", viTriPhong=" + viTriPhong + ", ghiChu=" + ghiChu + ", tinhTrangPhong=" + tinhTrangPhong + "]";
	}
	
	
}
>>>>>>> 9ac1a29a9c58755f34f7f7c2a2297bbbb3854160
