package modify;
import java.sql.*;
import java.util.Scanner;

public class Laundry_Modify {
	public void laundrymodifyMethod() {
		Scanner sc = new Scanner(System.in);
		String updateQuery;
		int id;
		String name;
		String num;
		String localaddr;
		String detailaddr;
		
		try{ 
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 연결
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://192.168.56.101:4567/laundry",
					"kminnyes","rudals135!!"); //DB 연결
			
			

			System.out.print("세탁소 ID: ");
			id = sc.nextInt();
			sc.nextLine();
			System.out.println("세탁소 이름: ");
			name = sc.nextLine();
			System.out.println("전화번호: ");
			num = sc.nextLine();
			System.out.println("지역구 명: ");
			localaddr = sc.nextLine();
			System.out.println("상세주소: ");
			detailaddr = sc.nextLine();
			
			
			updateQuery = "UPDATE Laundry SET " +"laundry_name ='" +name+ "', laundry_num ='" +num+
					"', laundry_localaddr ='" +localaddr+ "', laundry_detailaddr ='" +detailaddr+ 
					"' WHERE laundry_id =" +id;
			
			PreparedStatement pstmt = null;
			pstmt=con.prepareStatement(updateQuery);// 쿼리 준비
			
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println(cnt+"개의 행이 수정되었습니다.");
			}else{
				System.out.println("문제가 발생하였습니다.");
			}; //수정완료 
			
			System.out.println();
			
						
			con.close();
			sc.close();
		}catch(Exception e){ System.out.println(e);}
		
	}


}
