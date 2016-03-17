create table if not exists catalog (
	id int(10) not null auto_increment,
    pname char(20) not null,
    category char(20) not null,
    uprice int(20) not null,
    primary key (id)

)