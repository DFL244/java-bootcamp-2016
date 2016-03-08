CREATE TABLE IF NOT EXISTS Teacher (
    idTeacher INT(11) NOT NULL AUTO_INCREMENT,
    firstName CHAR(20) NOT NULL,
    lastName char(20) NOT NULL,
    birth_day DATE NOT NULL,
    PRIMARY KEY (idTeacher)
);




CREATE TABLE IF NOT EXISTS Student (
    regNum INT(10) NOT NULL,
    firstName CHAR(20) NOT NULL,
    LastName CHAR(20) NOT NULL,
    birth_day DATE NOT NULL,
    PRIMARY KEY (regNum)
    );
    
    
CREATE TABLE IF NOT EXISTS course (
    idCourse INT(10) NOT NULL AUTO_INCREMENT,
    nameCourse CHAR(10) NOT NULL,
    hours_by_weeK INT(10) NOT NULL,
    idTeacher_fk INT(10) NOT NULL,
    PRIMARY KEY (idCourse),
    FOREIGN KEY (idTeacher_fk)
        REFERENCES teacher (idTeacher)
);
 
 
 create table if not  exists student_curse(
 regNum_fk int(10)	not null,
 idCourse_fk int(10) not null,
 pNote1 int(10) null,
 pNote2 int(10) null,
 pNote3 int(10) null,
 fNote int(10) null,
 foreign key (regNum_fk) REFERENCES student(regNum),
 foreign key (idCourse_fk) references course(idCourse),
 primary key (regNum_fk,idCourse_fk) 
);

Alter Table student_curse change fNote fNote float(20);

create table if not exists class_weeK(
idDay int(10) not null AUTO_INCREMENT,
dayName char(10)	not null,
startTime time,
endTime	time,
primary key (idDay,dayName)
);

create table if not exists course_classWeek(
idDay_fk int(10) not null,
idCourse_fk int(10) not null,
foreign key (idDay_fk) references class_week(idDay),
foreign key(idCourse_fk) references course(idCourse),
primary key(idDay_fk,idCourse_fk)
)




