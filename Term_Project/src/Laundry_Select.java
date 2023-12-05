import java.sql.*;
import java.util.Scanner;

public class Laundry_Select {
	

	public void laundryselectMethod() {
		Scanner sc = new Scanner(System.in);
		
		String query;
		
		try{ 
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 연결
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://192.168.56.101:4567/laundry",
					"kminnyes","rudals135!!"); //DB 연결
			
			query = "SELECT * FROM Laundry";//쿼리문
			
			Statement stmt=con.createStatement();

			ResultSet rs=stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData(); //rs에 조회한 데이터 저장
			
			System.out.println("-------------------------------------------------------------------------------");
			for(int i =1; i<= rsmd.getColumnCount(); i++) {
				System.out.printf("%s ", rsmd.getColumnName(i));
			}
			System.out.println();
			System.out.println("-------------------------------------------------------------------------------"); // 상위 칼럼목록 표기
			
			while(rs.next()) {
				for(int i =1; i<=rsmd.getColumnCount(); i++)
				{
					int columnType = rsmd.getColumnType(i);
					
					if(columnType == Types.INTEGER) {
						System.out.printf("%d ", rs.getInt(i));
					}else if(columnType == Types.VARCHAR) {
						System.out.printf("%s ", rs.getString(i));
					}
					
				}
				System.out.println(); //자료형에 맞게 출력하기
			}
				con.close();
				sc.close();
		}catch(Exception e){ System.out.println(e);
		

			
			
			
		}
		
	}

}
