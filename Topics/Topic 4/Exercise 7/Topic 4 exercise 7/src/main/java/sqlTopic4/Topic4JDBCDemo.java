package sqlTopic4;

public class Topic4JDBCDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String URL ="jdbc:mysql://localhost:3306/topic4pn1-test01";
		String User="root";
		String Pass="root1234";
		
		Topic4JDBCImpProxy dbproxy =new Topic4JDBCImpProxy();
		
		dbproxy.logIn(URL, User, Pass);
		
		String queryTest ="select concat_ws(',',t.lastName,t.firstName) AS 'Teacher: <last-name>, <first-name>',concat_ws(' : ',concat_ws(' ',cw.dayName,concat_ws(' - ',cw.startTime,cw.endTime)),c.nameCourse) AS 'Schedule:' from teacher AS t inner join course AS c ON t.idTeacher=c.idTeacher_fk inner join course_classweek AS ccw ON c.idCourse=ccw.idCourse_fk inner join class_week AS cw on ccw.idDay_fk=cw.idDay where t.idTeacher='2' order by cw.dayName DESC";
		dbproxy.read(queryTest);
		dbproxy.showQuery();
	}

}
