insert into teacher values 
(default, 'pedro', 'alfo','1977-02-01'),
(default, 'alicia', 'torres','1980-09-03'),
(default,'patrica','aragon','1987-08-04');


insert into course values
(default,'EE101',4,1),
(default,'Biology',3,2),
(default,'Physics',3,3);


insert into class_week values
(default,'Monday','09:00','10:00'),
(default,'Monday','14:00','15:00'),
(default,'Tuesday','07:00','08:00'),
(default,'Tuesday','15:00','16:00'),
(default,'Wednesday','14:00','15:00'),
(default,'Thursday','07:00','09:00'),
(default,'Friday','10:00','11:00');


insert into course_classWeek values
(1,1),
(2,1),
(3,2),
(7,2),
(4,3),
(5,3),
(6,3);


insert into Student values
(201,'Est First Name 1','Est Last Name 1','1987-01-25'),
(202,'Est First Name 2','Est Last Name 2','198-01-26'),
(203,'Est First Name 3','Est Last Name 3','1986-01-06'),
(204,'Est First Name 4','Est Last Name 4','1988-03-13'),
(205,'Est First Name 5','Est Last Name 5','1989-01-29'),
(206,'Est First Name 6','Est Last Name 6','1985-02-06'),
(207,'Est First Name 7','Est Last Name 7','1984-01-31'),
(208,'Est First Name 8','Est Last Name 8','1986-08-02'),
(209,'Est First Name 9','Est Last Name 9','1989-04-25'),
(210,'Est First Name 10','Est Last Name 10','1987-02-03');


insert into student_curse values
(201,1,5,2,5,4.0),
(202,1,2,1,1,1.3),
(203,1,3,2,3,2.7),
(204,1,2,2,3,2.3),
(205,1,5,2,1,2.7),
(206,1,3,1,5,3.0),
(207,1,2,4,1,2.3),
(208,1,4,2,1,2.3),
(209,1,3,2,1,2.0),
(210,1,5,4,3,4.0),
(201,2,2,3,5,3.3),
(202,2,4,4,1,3.0),
(203,2,2,3,5,3.3),
(204,2,5,2,1,2.7),
(205,2,4,4,5,4.3),
(206,2,3,5,1,3.0),
(207,2,3,2,4,3.0),
(208,2,4,3,4,3.7),
(209,2,5,2,1,2.7),
(210,2,4,1,4,3.0),
(201,3,2,1,4,2.3),
(202,3,2,5,4,3.7),
(203,3,2,1,1,1.3),
(204,3,5,1,1,2.3),
(205,3,5,3,5,4.3),
(206,3,4,5,1,3.3),
(207,3,2,1,2,1.7),
(208,3,5,5,4,4.7),
(209,3,3,2,5,3.3),
(210,3,3,2,3,2.7)


