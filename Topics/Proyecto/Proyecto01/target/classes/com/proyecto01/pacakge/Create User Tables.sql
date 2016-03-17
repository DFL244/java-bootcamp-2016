CREATE TABLE IF NOT EXISTS userTable (    
    username CHAR(20) NOT NULL,
    pass CHAR(20) NOT NULL,
    name CHAR(20) NOT NULL,    
    namelist CHAR(20),
    listsize int(10),
    PRIMARY KEY (username)
);