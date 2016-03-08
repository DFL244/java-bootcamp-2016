select c.nameCourse AS 'Course: <course-name>', CONCAT_WS(',',t.lastName,t.firstName) AS 'Teacher: <last-name>, <first-name>',
CONCAT_WS(',',s.LastName,s.firstName) AS 'Students: <last-name>, <first-name>' 
from student AS s inner join student_curse AS sc on s.regNum=sc.regNum_fk 
				  inner join course AS c on sc.idCourse_fk=c.idCourse
                  inner join teacher AS t on c.idCourse= t.idTeacher
                  where c.nameCourse='Physics'
                  order by s.LastName;
                  	