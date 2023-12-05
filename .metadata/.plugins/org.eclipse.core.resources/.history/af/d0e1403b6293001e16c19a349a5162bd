package delete;
import java.sql.*;
import java.util.Scanner;

public class Orders_Delete {
	public void ordersdeleteMethod() {

		Scanner sc = new Scanner(System.in);
		String tableselectQuery;
		String deleteQuery;
		String Columnname;
		int id;
		
		try{ 
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 연결
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://192.168.56.101:4567/laundry",
					"kminnyes","rudals135!!"); //DB 연결
			
			
			Statement stmt=con.createStatement();
			
			
			tableselectQuery = "SELECT * FROM Orders";
			
			ResultSet rs=stmt.executeQuery(tableselectQuery);
			
			ResultSetMetaData rsmd = rs.getMetaData(); //rs에 조회한 데이터 저장
			
			
			Columnname = rsmd.getColumnName(1); // 1열 값을 기준으로 삭제하기
			
			deleteQuery = "DELETE FROM `Orders` WHERE "+ Columnname +" =?;";
			PreparedStatement pstmt = null;
			pstmt=con.prepareStatement(deleteQuery);
			
			System.out.println();
			System.out.println("삭제할 행의 주문번호를 입력하여 주세요.");
			
			id = sc.nextInt();
			pstmt.setInt(1, id);
			int cnt = pstmt.executeUpdate();
			
			System.out.println();
			System.out.println(cnt+"개의 행이 삭제되었습니다."); // 삭제완료
			
			System.out.println();
			
		
			con.close();
			sc.close();
		}catch(Exception e){ System.out.println(e);}
	}

}
