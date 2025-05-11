package serveice;

import java.sql.Connection;

import Login.ketnoi;

public class Main {
	public static void main(String[] args) {
		Connection con = ketnoi.getConnection();
		
		if(con != null) {
			System.out.println("Kết nối thành công!");
		} else {
			System.out.println("Kết nối thất bại!");
		}
	}

}
