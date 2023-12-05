package delete;
import java.sql.*;
import java.util.Scanner;

public class OrderList_Delete {
	public void orderlistdeleteMethod() {

		Scanner sc = new Scanner(System.in);
		String tableselectQuery;
		String deleteQuery;
		String ConQuery;
		String Columnname;
		String Columnname2;
		int id;
		int id2;
		
		try{ 
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 연결
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://192.168.56.101:4567/laundry",
					"kminnyes","rudals135!!"); //DB 연결
			
			
			Statement stmt=con.createStatement();
			
			
			tableselectQuery = "SELECT * FROM OrderList";
			
			ResultSet rs=stmt.executeQuery(tableselectQuery);
			
			ResultSetMetaData rsmd = rs.getMetaData(); //rs에 조회한 데이터 저장
			
			
			Columnname = rsmd.getColumnName(1);
			Columnname2 = rsmd.getColumnName(2);// 열 값을 기준으로 삭제하기
			
			ConQuery="SET FOREIGN_KEY_CHECKS=0;";
			con.setAutoCommit(false);
			stmt.addBatch(ConQuery);
			stmt.executeBatch();
			con.commit();//외래키 check 해제
			
			deleteQuery = "DELETE FROM `OrderList` WHERE "+ Columnname + "=?" + " AND "+ Columnname2 + "=?;";
			PreparedStatement pstmt = null;
			pstmt=con.prepareStatement(deleteQuery);
			
			System.out.println();
			System.out.println("삭제할 행의 세탁물 번호(washing_no)를 입력하여 주세요.");
			
			id = sc.nextInt();
			pstmt.setInt(1, id);
			sc.nextLine();
			System.out.println("삭제할 행의 주문 번호(orders_no)를 입력하여 주세요.");
			id2 = sc.nextInt();
			pstmt.setInt(2, id2);
			
			int cnt = pstmt.executeUpdate();
			
			System.out.println();
			System.out.println(cnt+"개의 행이 삭제되었습니다."); // 삭제완료
			
			System.out.println();
			
		
			con.close();
			sc.close();
		}catch(Exception e){ System.out.println(e);}
	}

}
