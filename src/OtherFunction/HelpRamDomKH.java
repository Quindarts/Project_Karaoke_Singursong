package OtherFunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HelpRamDomKH {
	
	private String soDT;
	
	public HelpRamDomKH(String data) {
		this.soDT = data;
	}
	


	public String taoMa(String tenBang, String maTao, String type) {
		String result = type;
		int count;
		int flag = 0;
		
		
		
		if(soDT.trim() != "" && soDT.trim().length() >= 10 && soDT.trim().matches("\\d+")) {
			result = result + soDT.substring(soDT.length() - 4);
			
			ArrayList<String> column = maToDaTaBase(tenBang, maTao);
			for(String value : column) {
				if(value.trim().substring(0, 6).equals(result.substring(0, 6))) {
					count = Integer.parseInt(value.trim().substring(value.trim().length() - 4)) + 1;
					result = result.substring(0, 6) + String.format("%04d", count);
					flag++;
				}
			} 

			if(flag == 0) {
				result = result.concat("0001");
			}
		} else {
			result = "chưa đúng";
		}
		
		
		
		return result;
	}
	
	
	public static ArrayList<String> maToDaTaBase(String tenBang, String tenCot) {
		String jdbcUrl = "jdbc:sqlserver://localhost:1433;databasename=SingUrSong_Test";
		String user = "sa";
		String password = "230903";
		String maHoaDon = "";
		
		 ArrayList<String> maCot = new ArrayList<>();
        
        try (Connection con = DriverManager.getConnection(jdbcUrl, user, password)) {
        	String sql = "SELECT " + tenCot + " FROM " + tenBang;
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	maHoaDon = rs.getString(tenCot);           	
            	maCot.add(maHoaDon);		
            }
               
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return maCot;
	}
	
//	public static void main(String[] args) {
//		String maKH = taoMa("PhieuDatPhong", "maPhieuDat", "PD");
//
//		System.out.println(maKH);
//	}
}
