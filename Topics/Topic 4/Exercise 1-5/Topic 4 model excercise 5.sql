select concat_ws(',',t.lastName,t.firstName) AS 'Teacher: <last-name>, <first-name>',
concat_ws(' : ',concat_ws(' ',cw.dayName,concat_ws(' - ',cw.startTime,cw.endTime)),c.nameCourse) AS 'Schedule:'
from teacher AS t inner join course AS c ON t.idTeacher=c.idTeacher_fk
				  inner join course_classweek AS ccw ON c.idCourse=ccw.idCourse_fk
                  inner join class_week AS cw on ccw.idDay_fk=cw.idDay
                  where t.idTeacher='2'
                  order by cw.dayName DESC;
				