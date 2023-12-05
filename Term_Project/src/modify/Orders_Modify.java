package modify;
import java.sql.*;
import java.util.Scanner;

public class Orders_Modify {
	public void ordersmodifyMethod() {
		Scanner sc = new Scanner(System.in);
		String updateQuery;
		int order_id;
		int laundry_id;
		String order_name;
		String orderdate;
		String sumquantity;
		String price;
		
		try{ 
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 연결
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://192.168.56.101:4567/laundry",
					"kminnyes","rudals135!!"); //DB 연결
		
			
			
			System.out.print("주문 번호: ");
			order_id = sc.nextInt();
			sc.nextLine();
			System.out.println("세탁소 ID: ");
			laundry_id = sc.nextInt();
			sc.nextLine();
			System.out.println("주문자: ");
			order_name = sc.nextLine();
			System.out.println("주문일: ");
			orderdate = sc.nextLine();
			System.out.println("합계 수량: ");
			sumquantity = sc.nextLine();
			System.out.println("가격: ");
			price = sc.nextLine();
			
			
			updateQuery = "UPDATE Orders SET " +"laundry_id ='" +laundry_id+ "', orders_name ='" +order_name+
					"', orders_date ='" +orderdate+ "', orders_sumquantity ='" +sumquantity+ "', orders_price ='"
					+price+ "' WHERE orders_id =" +order_id;
			
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
