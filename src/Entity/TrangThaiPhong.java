package Entity;

import java.util.Objects;

/**
 * Trạng thái phòng
 * @author THANH CUONG
 *
 */
public class TrangThaiPhong {
	private String maTrangThai;
	private String tenTrangThai;
	public TrangThaiPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param maTrangThai
	 * @param tenTrangThai
	 */
	public TrangThaiPhong(String maTrangThai, String tenTrangThai) {
		super();
		this.maTrangThai = maTrangThai;
		this.tenTrangThai = tenTrangThai;
	}
	public TrangThaiPhong(String maTrangThai) {
		super();
		this.maTrangThai = maTrangThai;
	}
	public String getMaTrangThai() {
		return maTrangThai;
	}
	public void setMaTrangThai(String maTrangThai) {
		this.maTrangThai = maTrangThai;
	}
	public String getTenTrangThai() {
		return tenTrangThai;
	}
	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maTrangThai);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrangThaiPhong other = (TrangThaiPhong) obj;
		return Objects.equals(maTrangThai, other.maTrangThai);
	}
	@Override
	public String toString() {
		return "TrangThaiPhong [maTrangThai=" + maTrangThai + ", tenTrangThai=" + tenTrangThai + "]";
	}
	
	
}
