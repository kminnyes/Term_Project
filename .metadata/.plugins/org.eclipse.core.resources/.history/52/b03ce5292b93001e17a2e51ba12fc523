package Insert;
import java.sql.*;
import java.util.Scanner;

public class Customer_Insert {
	public void customerinsertMethod() {
		Scanner sc = new Scanner(System.in);
		String tableselectQuery;
		String insertQuery;
		
		try{ 
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 연결
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://192.168.56.101:4567/laundry",
					"kminnyes","rudals135!!"); //DB 연결
			
			
			Statement stmt=con.createStatement();
			
			tableselectQuery = "SELECT * FROM Customer";
			ResultSet rs=stmt.executeQuery(tableselectQuery);
			
			ResultSetMetaData rsmd = rs.getMetaData(); //rs에 조회한 데이터 저장
			
			
			System.out.println("삽입할 값을 입력해주세요.");
			System.out.println();
			
			insertQuery = "INSERT INTO `Customer` VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement pstmt = null;
			pstmt=con.prepareStatement(insertQuery);
			
			for(int i =1; i<= rsmd.getColumnCount(); i++) {// column타입에 맞는 자료형으로 삽입하기
				System.out.printf("%s ", rsmd.getColumnName(i)+":");
					int columnType =rsmd.getColumnType(i);
					if(columnType == Types.INTEGER) {
						int temp = sc.nextInt();
						pstmt.setInt(i, temp);
						sc.nextLine();
					}else if(columnType == Types.VARCHAR) {
						String temp1 =sc.nextLine();
						pstmt.setString(i, temp1);
					}else if(columnType == Types.DATE) {
						int temp2 = sc.nextInt();
						pstmt.setInt(i, temp2);
						sc.nextLine();
					}
				System.out.println();
				}
			
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt+"개의 행이 삽입되었습니다."); //삽입완료
			
			System.out.println();
			
						
			con.close();
			sc.close();
		}catch(Exception e){ System.out.println(e);}
		
	}

}
