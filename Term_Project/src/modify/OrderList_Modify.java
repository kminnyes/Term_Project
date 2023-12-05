package modify;
import java.sql.*;
import java.util.Scanner;

public class OrderList_Modify {
	public void orderlistmodifyMethod() {
		Scanner sc = new Scanner(System.in);
		String updateQuery;
		int washing_no;
		int orders_id;
		int washing_quantity;
		String washing_startdate;
		String washing_enddate;
		
		try{ 
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 연결
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://192.168.56.101:4567/laundry",
					"kminnyes","rudals135!!"); //DB 연결
		
			
			
			System.out.print("세탁물 번호: ");
			washing_no = sc.nextInt();
			sc.nextLine();
			System.out.println("주문 번호: ");
			orders_id = sc.nextInt();
			sc.nextLine();
			System.out.println("수량: ");
			washing_quantity = sc.nextInt();
			sc.nextLine();
			System.out.println("세탁일: ");
			washing_startdate = sc.nextLine();
			System.out.println("완료일: ");
			washing_enddate = sc.nextLine();
			
			
			
			updateQuery = "UPDATE OrderList SET" +" washing_quantity ='" +washing_quantity+
					"', washing_startdate ='" +washing_startdate+ "', washing_enddate ='" +washing_enddate+
					"' WHERE washing_no =" +washing_no+ " AND " +"orders_id =" +orders_id;
			
			PreparedStatement pstmt = null;
			pstmt=con.prepareStatement(updateQuery);// 쿼리 준비
			
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println(cnt+"개의 행이 수정되었습니다.");
			}else{
				System.out.println("문제가 발생하였습니다.");
			}; //수정완료 //수정완료
			
			System.out.println();
			
						
			con.close();
			sc.close();
		}catch(Exception e){ System.out.println(e);}
		
	}

}
