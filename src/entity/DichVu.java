package entity;

import java.util.Objects;

/**
 * DichVu trangThai: conHang, hetHang
 * 
 */
public class DichVu {

	private String maDichVu;
	private String tenDichVu;
	private String donViTinh;
	private double donGia;
	private boolean trangThai;
	private ThongTinDichVu thongTinDichVu;

	public DichVu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DichVu(String maDichVu, String tenDichVu, double donGia) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;

		this.donGia = donGia;
	}

	public DichVu(String maDichVu, String tenDichVu, String donViTinh, double donGia, boolean trangThai,
			ThongTinDichVu thongTinDichVu) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.donViTinh = donViTinh;
		this.donGia = donGia;
		this.trangThai = trangThai;
		this.thongTinDichVu = thongTinDichVu;
	}

	public ThongTinDichVu getThongTinDichVu() {
		return thongTinDichVu;
	}

	public void setThongTinDichVu(ThongTinDichVu thongTinDichVu) {
		this.thongTinDichVu = thongTinDichVu;
	}

	public DichVu(String maDichVu) {
		super();
		this.maDichVu = maDichVu;
	}

	public String getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}

	public String getTenDichVu() {
		return tenDichVu;
	}

	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDichVu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DichVu other = (DichVu) obj;
		return Objects.equals(maDichVu, other.maDichVu);
	}

	@Override
	public String toString() {
		return "DichVu [maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + "donViTinh=" + donViTinh + ", donGia="
				+ donGia + ", trangThai=" + trangThai + "]";
	}

	

}