CREATE sequence ACCOUNT_SEQ;
CREATE sequence EMPLOYEE_SEQ;
CREATE sequence PROJECT_SEQ;
CREATE sequence EMPL_PROJECT_MAP_SEQ;

--------------------------------------------------------
--  DDL for Table ACCOUNT
--------------------------------------------------------

  CREATE TABLE "ACCOUNT"
   (	"ID" NUMBER(10,0) PRIMARY KEY,
	"FIRST_NAME" VARCHAR2(45 CHAR) NOT NULL,
	"LAST_NAME" VARCHAR2(45 CHAR) NOT NULL,
	"E_MAIL" VARCHAR2(45 CHAR) NOT NULL
   );
--------------------------------------------------------
--  DDL for Table EMPLOYEE
--------------------------------------------------------

  CREATE TABLE "EMPLOYEE"
   (	"ID" NUMBER  PRIMARY KEY,
	"FIRSTNAME" VARCHAR2(45 CHAR) NOT NULL,
	"LASTNAME" VARCHAR2(45 CHAR) NOT NULL,
	"PROF_LEVEL" NUMBER(10,0) NOT NULL
   );
--------------------------------------------------------
--  DDL for Table EMPLOYEE_PROJECT_MAP
--------------------------------------------------------

  CREATE TABLE "PROJECT"
   (
	"ID" NUMBER(10,0)  PRIMARY KEY,
	"NAME" VARCHAR2(45 CHAR) NOT NULL,
	"DESCRIPTION" VARCHAR2(100 CHAR) NOT NULL
   );

  CREATE TABLE "EMPLOYEE_PROJECT_MAP"
   (	"ID" NUMBER(10,0)  PRIMARY KEY,
	"EMPLOYEE_ID" NUMBER(10,0)  NOT NULL,
	"PROJECT_ID" NUMBER(10,0)  NOT NULL,

	CONSTRAINT "EMPLOYEE_PROJECT_MAP_EMPL_FK1" FOREIGN KEY ("ID") REFERENCES "EMPLOYEE" ("ID"),
	CONSTRAINT "EMPLOYEE_PROJECT_MAP_PROJ_FK1" FOREIGN KEY ("ID") REFERENCES "PROJECT" ("ID")
   );

--------------------------------------------------------
--  Insert data
--------------------------------------------------------

Insert into ACCOUNT (ID, FIRST_NAME,LAST_NAME,E_MAIL) values (ACCOUNT_SEQ.NEXTVAL, 'JOHN','DOE','JOHN.DOE@FASTMAIL.COM');
Insert into ACCOUNT (ID, FIRST_NAME,LAST_NAME,E_MAIL) values (ACCOUNT_SEQ.NEXTVAL, 'JANE','DOE','JANE.DOE@FASTMAIL.COM');

Insert into EMPLOYEE (ID, FIRSTNAME,LASTNAME,PROF_LEVEL) values (EMPLOYEE_SEQ.NEXTVAL, 'John','Doe',1);
Insert into EMPLOYEE (ID, FIRSTNAME,LASTNAME,PROF_LEVEL) values (EMPLOYEE_SEQ.NEXTVAL, 'Jane','Doe',2);
Insert into EMPLOYEE (ID, FIRSTNAME,LASTNAME,PROF_LEVEL) values (EMPLOYEE_SEQ.NEXTVAL, 'Scott','Feist',1);
Insert into EMPLOYEE (ID, FIRSTNAME,LASTNAME,PROF_LEVEL) values (EMPLOYEE_SEQ.NEXTVAL, 'James','Donnell',3);
Insert into EMPLOYEE (ID, FIRSTNAME,LASTNAME,PROF_LEVEL) values (EMPLOYEE_SEQ.NEXTVAL, 'Michael','Dorn',5);

Insert into PROJECT (ID, NAME,DESCRIPTION) values (PROJECT_SEQ.NEXTVAL, 'Online Insurance System','A web application that automates insurance transactions.');
Insert into PROJECT (ID, NAME,DESCRIPTION) values (PROJECT_SEQ.NEXTVAL, 'Time Report System','A stand-alone application that records and generates time reports.');
Insert into PROJECT (ID, NAME,DESCRIPTION) values (PROJECT_SEQ.NEXTVAL, 'Real Estate Search System','An online search engine specifically for real estates.');
Insert into PROJECT (ID, NAME,DESCRIPTION) values (PROJECT_SEQ.NEXTVAL, 'Online Shopping System','A web application that handles shopping transactions online.');

Insert into EMPLOYEE_PROJECT_MAP (ID, EMPLOYEE_ID,PROJECT_ID) values (EMPL_PROJECT_MAP_SEQ.NEXTVAL, 2,3);
Insert into EMPLOYEE_PROJECT_MAP (ID, EMPLOYEE_ID,PROJECT_ID) values (EMPL_PROJECT_MAP_SEQ.NEXTVAL, 3,2);
Insert into EMPLOYEE_PROJECT_MAP (ID, EMPLOYEE_ID,PROJECT_ID) values (EMPL_PROJECT_MAP_SEQ.NEXTVAL, 1,1);
Insert into EMPLOYEE_PROJECT_MAP (ID, EMPLOYEE_ID,PROJECT_ID) values (EMPL_PROJECT_MAP_SEQ.NEXTVAL, 4,3);

COMMIT;