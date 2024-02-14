# Term_Project
+ 세탁소 관리 Database
+ 2023.11.25 ~ 2023.12.05

## 사용 기술 및 환경
+ JAVA
+ JDBC
+ MySQL
+ Window
+ Eclipse

## 구현 기능
+ 데이터 CRUD 기능 구현

## 주요 코드
+ Select
```
query = "SELECT * FROM Customer";//쿼리문
			
			Statement stmt=con.createStatement();

			ResultSet rs=stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData(); //rs에 조회한 데이터 저장
			
			System.out.println("------------------------------------------------------------");
			for(int i =1; i<= rsmd.getColumnCount(); i++) {
				System.out.printf("%s ", rsmd.getColumnName(i));
			}
			System.out.println();
			System.out.println("-------------------------------------------------------------"); // 상위 칼럼목록 표기
			
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
```

+ Insert
```
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
		
					}
				System.out.println();
				}
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println(cnt+"개의 행이 삽입되었습니다.");
			}else{
				System.out.println("문제가 발생하였습니다.");
			}; //삽입완료
			
			System.out.println();
			
						
			con.close();
			sc.close();
```

+ Delete
```
Statement stmt=con.createStatement();
			
			
			tableselectQuery = "SELECT * FROM Customer";
			
			ResultSet rs=stmt.executeQuery(tableselectQuery);
			
			ResultSetMetaData rsmd = rs.getMetaData(); //rs에 조회한 데이터 저장
			
			
			Columnname = rsmd.getColumnName(1); // 1열 값을 기준으로 삭제하기
			
			deleteQuery = "DELETE FROM `Customer` WHERE "+ Columnname +" =?;";
			PreparedStatement pstmt = null;
			pstmt=con.prepareStatement(deleteQuery);
			
			System.out.println();
			System.out.println("삭제할 행의 고객 ID를 입력하여 주세요.");
			
			id = sc.nextInt();
			pstmt.setInt(1, id);
			int cnt = pstmt.executeUpdate();
			
			System.out.println();
			if(cnt>0) {
				System.out.println(cnt+"개의 행이 삭제되었습니다.");
			}else{
				System.out.println("문제가 발생하였습니다.");
			}; //삭제완료
			
			System.out.println();
			
		
			con.close();
			sc.close();
```

+ Update
```
System.out.print("고객 ID: ");
			id = sc.nextInt();
			sc.nextLine();
			System.out.println("이름: ");
			name = sc.nextLine();
			System.out.println("전화번호: ");
			num = sc.nextLine();
			System.out.println("지역구 명: ");
			localaddr = sc.nextLine();
			System.out.println("상세주소: ");
			detailaddr = sc.nextLine();
			
			
			updateQuery = "UPDATE Customer SET " +"customer_name ='" +name+ "', customer_num ='" +num+
					"', customer_localaddr ='" +localaddr+ "', customer_detailaddr ='" +detailaddr+ 
					"' WHERE customer_id =" +id;
			
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
```
