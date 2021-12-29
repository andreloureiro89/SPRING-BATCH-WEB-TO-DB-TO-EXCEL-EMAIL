DROP TABLE IF EXISTS TBL_USERS;

CREATE TABLE TBL_USERS (
  	id INT PRIMARY KEY,
    name VARCHAR2(750),
    username VARCHAR2(750),
    email VARCHAR2(750),
    street VARCHAR2(750),
    suite VARCHAR2(750),
    city VARCHAR2(750),
    zipcode VARCHAR2(750),
    lat VARCHAR2(750),
    lng VARCHAR2(750),
    phone VARCHAR2(750),
    website VARCHAR2(750),
    companyName VARCHAR2(750), 
    catchPhrase VARCHAR2(750),
    bs VARCHAR2(750)
);