package com.topic6ex3;
import java.sql.*;


public class Topic6SimpleJDBC {
	
	
	

	public static void main(String[] args) {
		
		try{			
			
			String URL ="jdbc:mysql://localhost:3306/regusers";
			String User="root";
			String Pass="root1234";
			
			// 1) Get a connection to the Database;
			Connection newConn =DriverManager.getConnection(URL,User,Pass);
			
			
			//2) Create an Statement object
			
			Statement newStmt = newConn.createStatement();
			
			
			//3)Execute SQL query
			
			/*String queryTest ="select concat_ws(',',t.lastName,t.firstName) AS 'Teacher: <last-name>, <first-name>',concat_ws(' : ',concat_ws(' ',cw.dayName,concat_ws(' - ',cw.startTime,cw.endTime)),c.nameCourse) AS 'Schedule:' from teacher AS t inner join course AS c ON t.idTeacher=c.idTeacher_fk inner join course_classweek AS ccw ON c.idCourse=ccw.idCourse_fk inner join class_week AS cw on ccw.idDay_fk=cw.idDay where t.idTeacher='2' order by cw.dayName DESC";
			ResultSet newResSet= newStmt.executeQuery(queryTest);
			*/
			
			
			//4  Process the resultset
			
			
			/*while(newResSet.next()){
				System.out.println(newResSet.getString("Teacher: <last-name>, <first-name>")+"    "+newResSet.getString("Schedule:"));			
				
			}
			*/
			String query2="UPDATE registeruser SET nickname = 'nickname5' WHERE id = 5";
			int up1=newStmt.executeUpdate(query2);		
			System.out.println(""+up1);
					
				
			
			
			
		}catch(Exception exc){
			exc.printStackTrace();			
		}

	}

}
