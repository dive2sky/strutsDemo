# DROP TABLE USERINFO;

CREATE TABLE USERINFO (
	userId          varchar(12)		NOT NULL,
	password		varchar(12)		NOT NULL,
	name			varchar(20)		NOT NULL,
	email			varchar(50),

	PRIMARY KEY               (userId),
	INDEX USERINFO_userId_idx  (userId)
);

INSERT INTO struts.USERINFO VALUES('admin', 'admin', 'kunsu', 'dive2sky@neowiz.com');