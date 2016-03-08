
select (count(*)*100)/(select count(*) from student_curse AS sc
				where sc.idCourse_fk='2') as 'course number Passed%'
                
                from student_curse AS sc
					 where sc.idCourse_fk='2' and sc.fNote >=3.0;
                     
                     
               
                    
                