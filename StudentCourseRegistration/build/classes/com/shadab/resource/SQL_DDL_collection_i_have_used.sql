CREATE TABLE student_info (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    email VARCHAR2(100),
    course VARCHAR2(100)
);

CREATE TABLE course (
  cid NUMBER PRIMARY KEY,
  title VARCHAR2(100),
  instructor VARCHAR2(100),
  duration VARCHAR2(20)
);

CREATE TABLE enrollment (
  eid NUMBER PRIMARY KEY,
  sid NUMBER REFERENCES student(sid),
  cid NUMBER REFERENCES course(cid),
  enroll_date DATE DEFAULT SYSDATE
);

CREATE SEQUENCE student_seq START WITH 1 INCREMENT BY 1;
