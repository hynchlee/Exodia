--드롭 구문--
DROP TABLE MEMBER CASCADE CONSTRAINTS;
DROP TABLE ADMIN CASCADE CONSTRAINTS;
DROP TABLE LECTURE CASCADE CONSTRAINTS;
DROP TABLE BOARD CASCADE CONSTRAINTS;
DROP TABLE REPLY CASCADE CONSTRAINTS;
DROP TABLE LETTER CASCADE CONSTRAINTS;
DROP TABLE QNA CASCADE CONSTRAINTS;
DROP TABLE VACATION_REQUEST_LIST CASCADE CONSTRAINTS;
DROP TABLE REVIEW CASCADE CONSTRAINTS;
DROP TABLE LECTURE_CATEGORY CASCADE CONSTRAINTS;
DROP TABLE BOARD_CATEGORY CASCADE CONSTRAINTS;
DROP TABLE NOTICE CASCADE CONSTRAINTS;
DROP TABLE TEAM_CALENDER CASCADE CONSTRAINTS;
DROP TABLE PROBLEM_BANK CASCADE CONSTRAINTS;
DROP TABLE BOARD_PHOTO CASCADE CONSTRAINTS;
DROP TABLE EXAM_LIST CASCADE CONSTRAINTS;
DROP TABLE ATTENDANCE_LIST CASCADE CONSTRAINTS;
DROP TABLE STUDENT CASCADE CONSTRAINTS;
DROP TABLE TEAM CASCADE CONSTRAINTS;
DROP TABLE EXAM_CATEGORY CASCADE CONSTRAINTS;
DROP TABLE TEAM_ROLE CASCADE CONSTRAINTS;
DROP TABLE SUBMIT_ANSWER CASCADE CONSTRAINTS;
DROP TABLE NOTICE_PHOTO CASCADE CONSTRAINTS;
DROP TABLE ANSWER CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_ADMIN_NO;
DROP SEQUENCE SEQ_ANSWER_NO;
DROP SEQUENCE SEQ_BOARD_NO;
DROP SEQUENCE SEQ_BOARD_CATEGORY_NO;
DROP SEQUENCE SEQ_BOARD_PHOTO_NO;
DROP SEQUENCE SEQ_EXAM_CATEGORY_NO;
DROP SEQUENCE SEQ_EXAM_LIST_NO;
DROP SEQUENCE SEQ_LECTURE_NO;
DROP SEQUENCE SEQ_LECTURE_CATEGORY_NO;
DROP SEQUENCE SEQ_LETTER_NO;
DROP SEQUENCE SEQ_MEMBER_NO;
DROP SEQUENCE SEQ_NOTICE_NO;
DROP SEQUENCE SEQ_NOTICE_PHOTO_NO;
DROP SEQUENCE SEQ_PROBLEM_BANK_NO;
DROP SEQUENCE SEQ_QNA_NO;
DROP SEQUENCE SEQ_REPLY_NO;
DROP SEQUENCE SEQ_REVIEW_NO;
DROP SEQUENCE SEQ_STUDENT_NO;
DROP SEQUENCE SEQ_SUBMIT_ANSWER_NO;
DROP SEQUENCE SEQ_TEAM_NO;
DROP SEQUENCE SEQ_TEAM_CALENDER_NO;
DROP SEQUENCE SEQ_TEAM_ROLE_NO;
DROP SEQUENCE SEQ_VACATION_REQUEST_LIST_NO;


--시퀀스 생성--
CREATE SEQUENCE SEQ_ADMIN_NO NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_ANSWER_NO NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_BOARD_CATEGORY_NO NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_BOARD_PHOTO_NO NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_EXAM_CATEGORY_NO;
CREATE SEQUENCE SEQ_EXAM_LIST_NO;
CREATE SEQUENCE SEQ_LECTURE_NO;
CREATE SEQUENCE SEQ_LECTURE_CATEGORY_NO;
CREATE SEQUENCE SEQ_LETTER_NO;
CREATE SEQUENCE SEQ_MEMBER_NO;
CREATE SEQUENCE SEQ_NOTICE_NO;
CREATE SEQUENCE SEQ_NOTICE_PHOTO_NO;
CREATE SEQUENCE SEQ_PROBLEM_BANK_NO;
CREATE SEQUENCE SEQ_QNA_NO;
CREATE SEQUENCE SEQ_REPLY_NO;
CREATE SEQUENCE SEQ_REVIEW_NO;
CREATE SEQUENCE SEQ_STUDENT_NO;
CREATE SEQUENCE SEQ_SUBMIT_ANSWER_NO;
CREATE SEQUENCE SEQ_TEAM_NO;
CREATE SEQUENCE SEQ_TEAM_CALENDER_NO;
CREATE SEQUENCE SEQ_TEAM_ROLE_NO;
CREATE SEQUENCE SEQ_VACATION_REQUEST_LIST_NO;


--테이블 생성--
CREATE TABLE MEMBER (
	MEMBER_NO	NUMBER		NOT NULL,
	MEMBER_ID	VARCHAR2(200)		NOT NULL,
	MEMBER_PWD	VARCHAR2(200)		NOT NULL,
	MEMBER_NICK	VARCHAR2(200)		NOT NULL,
	BIRTH_NUM	CHAR(13)		NULL,
	STATUS	CHAR(1)	DEFAULT 'O'	NULL,
	PHONE_NO	CHAR(11)		NULL,
	SIGN_DATE	TIMESTAMP	DEFAULT SYSDATE	NULL,
	PROFILE	VARCHAR2(1000)		NULL,
	IDENTITY	CHAR(1)	DEFAULT 'S'	NULL,
	LEFT_VACATION	NUMBER	DEFAULT 0	NULL
);

CREATE TABLE ADMIN (
	ADMIN_NO	NUMBER		NOT NULL,
	ADMIN_ID	VARCHAR2(200)		NOT NULL,
	ADMIN_PWD	VARCHAR2(200)		NOT NULL,
	ADMIN_NICK	VARCHAR2(200)		NOT NULL,
	STATUS	CHAR(1)	DEFAULT 'O'	NOT NULL,
	QUALIFICATION	NUMBER	DEFAULT 1	NOT NULL
);

CREATE TABLE LECTURE (
	LECTURE_NO	NUMBER		NOT NULL,
	TEACHER_MEMBER_NO	NUMBER		NOT NULL,
	LECTURE_CATEGORY_NO	NUMBER		NOT NULL,
	LECTURE_START_TIME	CHAR(4)		NOT NULL,
	LECTURE_FINISH_TIME	CHAR(4)		NOT NULL,
	LECTURE_OPEN_DATE	CHAR(8)		NOT NULL,
	LECTURE_CLOSE_DATE	CHAR(8)		NOT NULL,
	STATUS	CHAR(1)	DEFAULT 'X'	NOT NULL
);

CREATE TABLE BOARD (
	BOARD_NO	NUMBER		NOT NULL,
	BOARD_CATEGORY_NO	NUMBER		NOT NULL,
	MEMBER_NO	NUMBER		NOT NULL,
	BOARD_TITLE	VARCHAR2(500)		NOT NULL,
	BOARD_CONTENT	VARCHAR2(2000)		NOT NULL,
	ENROLL_DATE	TIMESTAMP	DEFAULT SYSDATE	NOT NULL,
	MODIFY_DATE	TIMESTAMP	DEFAULT SYSDATE	NOT NULL,
	STATUS	CHAR(1)	DEFAULT 'O'	NOT NULL,
	HIT	NUMBER	DEFAULT 0	NOT NULL
);

CREATE TABLE REPLY (
	REPLY_NO	NUMBER		NOT NULL,
	WRITER_NO	NUMBER		NOT NULL,
	BOARD_NO	NUMBER		NOT NULL,
	REPLY_CONTENT	VARCHAR(1000)		NOT NULL,
	ENROLL_DATE	TIMESTAMP	DEFAULT SYSDATE	NOT NULL,
	MODIFY_DATE	TIMESTAMP	DEFAULT SYSDATE	NOT NULL,
	STATUS	CHAR(1)	DEFAULT 'O'	NOT NULL
);

CREATE TABLE LETTER (
	LETTER_NO	NUMBER		NOT NULL,
	SEND_MEMBER_NO	NUMBER		NOT NULL,
	RECEIVE_MEMBER_NO	NUMBER		NOT NULL,
	LETTER_TITLE	VARCHAR2(200)		NOT NULL,
	LETTER_CONTENT	VARCHAR2(2500)		NOT NULL,
	ENROLL_DATE	TIMESTAMP	DEFAULT SYSDATE	NOT NULL,
	STATUS	CHAR(1)	DEFAULT 'O'	NOT NULL
);

CREATE TABLE QNA (
	QNA_NO	NUMBER		NOT NULL,
	ADMIN_NO	NUMBER		NOT NULL,
	STUDENT_MEMBER_NO	NUMBER		NOT NULL,
	QNA_TITLE	VARCHAR2(250)		NULL,
	QNA_CONTENT	VARCHAR2(2500)		NULL,
	QNA_ANSWER	VARCHAR2(2500)		NULL,
	ENROLL_DATE	TIMESTAMP	DEFAULT SYSDATE	NULL,
	MODIFY_DATE	TIMESTAMP	DEFAULT SYSDATE	NULL,
	PHOTO	VARCHAR2(1000)		NULL,
	STATUS	CHAR(1)	DEFAULT 'O'	NULL
);

CREATE TABLE VACATION_REQUEST_LIST (
	VACATION_REQUEST_LIST_NO	NUMBER		NOT NULL,
	MEMBER_NO	NUMBER		NOT NULL,
	VACATION_START	CHAR(8)		NOT NULL,
	VACATION_END	CHAR(8)		NOT NULL,
    STATUS          CHAR(1)     NULL
);

CREATE TABLE REVIEW (
	REVIEW_NO	NUMBER		NOT NULL,
	MEMBER_NO	NUMBER		NOT NULL,
	REVIEW_TITLE	VARCHAR2(250)		NULL,
	REVIEW_CONTENT	VARCHAR2(2500)		NULL,
	ENROLL_DATE	TIMESTAMP	DEFAULT SYSDATE	NULL,
	MODIFY_DATE	TIMESTAMP	DEFAULT SYSDATE	NULL,
	PHOTO	VARCHAR2(1000)		NULL,
	STATUS	CHAR(1)	DEFAULT 'O'	NULL
);

CREATE TABLE LECTURE_CATEGORY (
	LECTURE_CATEGORY_NO	NUMBER		NOT NULL,
	LECTURE_NAME	VARCHAR2(200)		NOT NULL
);

CREATE TABLE BOARD_CATEGORY (
	BOARD_CATEGORY_NO	NUMBER		NOT NULL,
	BOARD_CATEGORY_TYPE	VARCHAR2(100)		NOT NULL
);

CREATE TABLE NOTICE (
	NOTICE_NO	NUMBER		NOT NULL,
	ADMIN_NO	NUMBER		NOT NULL,
	NOTICE_TITLE	VARCHAR2(500)		NOT NULL,
	NOTICE_CONTENT	VARCHAR2(2000)		NOT NULL,
	ENROLL_DATE	TIMESTAMP	DEFAULT SYSDATE	NULL,
	MODIFY_DATE	TIMESTAMP	DEFAULT SYSDATE	NULL,
	HIT	NUMBER	DEFAULT 0	NULL,
	STATUS	CHAR(1)	DEFAULT 'O'	NULL
);

CREATE TABLE TEAM_CALENDER (
	TEAM_CALENDER_NO	NUMBER		NOT NULL,
	TEAM_NO	NUMBER		NOT NULL,
	MEETING_DATE	VARCHAR2(100)	DEFAULT SYSDATE	NOT NULL,
	MEETING_CONTENT	VARCHAR2(500)		NULL
);

CREATE TABLE PROBLEM_BANK (
	EXAM_PROBLEM_NO	NUMBER		NOT NULL,
	EXAM_CATEGORY_NO	NUMBER		NOT NULL,
	PROBLEM	VARCHAR2(500)		NOT NULL,
	ANSWER	VARCHAR2(2500)		NULL,
	PROBLEM_POINT	NUMBER		NOT NULL
);

CREATE TABLE BOARD_PHOTO (
	BOARD_PHOTO_NO	NUMBER		NOT NULL,
	BOARD_NO	NUMBER		NOT NULL,
	PHOTO	VARCHAR2(1000)		NULL
);

CREATE TABLE EXAM_LIST (
	EXAM_SCORE_NO	NUMBER		NOT NULL,
	EXAM_CATEGORY_NO	NUMBER		NOT NULL,
	MEMBER_NO	NUMBER		NOT NULL,
	SCORE	NUMBER		NULL,
	ENROLL_DATE	TIMESTAMP	DEFAULT SYSDATE	NULL
);

CREATE TABLE ATTENDANCE_LIST (
	ATTENDANCE_DATE	VARCHAR2(100)		NULL,
	STUDENT_MEMBER_NO	NUMBER		NOT NULL,
	CHECK_IN_TIME	TIMESTAMP	DEFAULT SYSDATE	NULL,
	CHECK_OUT_TIME	TIMESTAMP		NULL,
	STATUS	CHAR(1)	DEFAULT 'X'	NULL
);

CREATE TABLE STUDENT (
	STUDENT_MEMBER_NO	NUMBER		NOT NULL,
	LECTURE_NO	NUMBER		NOT NULL,
	TEAM_NO	NUMBER		NOT NULL,
	MILEAGE	NUMBER	DEFAULT 0	NOT NULL
);

CREATE TABLE TEAM (
	TEAM_NO	NUMBER		NOT NULL,
	TEAM_NAME	VARCHAR2(200)		NULL
);

CREATE TABLE EXAM_CATEGORY (
	EXAM_CATEGORY_NO	NUMBER		NOT NULL,
	LECTURE_CATEGORY_NO	NUMBER		NOT NULL,
	EXAM_SUBJECT	VARCHAR2(500)		NOT NULL
);

CREATE TABLE TEAM_ROLE (
	TEAM_ROLE_NO	NUMBER		NOT NULL,
	TEAM_NO	NUMBER		NOT NULL,
	STUDENT_MEMBER_NO	NUMBER		NOT NULL,
	ROLE	VARCHAR2(100)	DEFAULT '조원'	NOT NULL,
	PROJECT_DIVISION	VARCHAR2(100)		NOT NULL
);

CREATE TABLE SUBMIT_ANSWER (
	SUBMIT_ANSWER_NO	NUMBER		NOT NULL,
	EXAM_SCORE_NO	NUMBER		NOT NULL,
	EXAM_PROBLEM_NO	NUMBER		NOT NULL,
	SUBMIT_ANSWER	VARCHAR2(2500)		NULL
);

CREATE TABLE NOTICE_PHOTO (
	NOTICE_PHOTO_NO	NUMBER		NOT NULL,
	NOTICE_NO	NUMBER		NOT NULL,
	PHOTO	VARCHAR2(1000)		NULL
);

CREATE TABLE ANSWER (
	ANSWER_NO	NUMBER		NOT NULL,
	REPLY_NO2	NUMBER		NOT NULL,
	ANSWER_CONTENT	VARCHAR(1000)		NOT NULL,
	ENROLL_DATE	TIMESTAMP	DEFAULT SYSDATE	NOT NULL,
	MODIFY_DATE	TIMESTAMP	DEFAULT SYSDATE	NOT NULL,
	STATUS	CHAR(1)	DEFAULT 'O'	NOT NULL
);

ALTER TABLE MEMBER ADD CONSTRAINT PK_MEMBER PRIMARY KEY (
	MEMBER_NO
);

ALTER TABLE ADMIN ADD CONSTRAINT PK_ADMIN PRIMARY KEY (
	ADMIN_NO
);

ALTER TABLE LECTURE ADD CONSTRAINT PK_LECTURE PRIMARY KEY (
	LECTURE_NO
);

ALTER TABLE BOARD ADD CONSTRAINT PK_BOARD PRIMARY KEY (
	BOARD_NO
);

ALTER TABLE REPLY ADD CONSTRAINT PK_REPLY PRIMARY KEY (
	REPLY_NO
);

ALTER TABLE LETTER ADD CONSTRAINT PK_LETTER PRIMARY KEY (
	LETTER_NO
);

ALTER TABLE QNA ADD CONSTRAINT PK_QNA PRIMARY KEY (
	QNA_NO
);

ALTER TABLE VACATION_REQUEST_LIST ADD CONSTRAINT PK_VACATION_REQUEST_LIST PRIMARY KEY (
	VACATION_REQUEST_LIST_NO
);

ALTER TABLE REVIEW ADD CONSTRAINT PK_REVIEW PRIMARY KEY (
	REVIEW_NO
);

ALTER TABLE LECTURE_CATEGORY ADD CONSTRAINT PK_LECTURE_CATEGORY PRIMARY KEY (
	LECTURE_CATEGORY_NO
);

ALTER TABLE BOARD_CATEGORY ADD CONSTRAINT PK_BOARD_CATEGORY PRIMARY KEY (
	BOARD_CATEGORY_NO
);

ALTER TABLE NOTICE ADD CONSTRAINT PK_NOTICE PRIMARY KEY (
	NOTICE_NO
);

ALTER TABLE TEAM_CALENDER ADD CONSTRAINT PK_TEAM_CALENDER PRIMARY KEY (
	TEAM_CALENDER_NO
);

ALTER TABLE PROBLEM_BANK ADD CONSTRAINT PK_PROBLEM_BANK PRIMARY KEY (
	EXAM_PROBLEM_NO
);

ALTER TABLE BOARD_PHOTO ADD CONSTRAINT PK_BOARD_PHOTO PRIMARY KEY (
	BOARD_PHOTO_NO
);

ALTER TABLE EXAM_LIST ADD CONSTRAINT PK_EXAM_LIST PRIMARY KEY (
	EXAM_SCORE_NO
);

ALTER TABLE ATTENDANCE_LIST ADD CONSTRAINT PK_ATTENDANCE_LIST PRIMARY KEY (
	ATTENDANCE_DATE,
	STUDENT_MEMBER_NO
);

ALTER TABLE STUDENT ADD CONSTRAINT PK_STUDENT PRIMARY KEY (
	STUDENT_MEMBER_NO
);

ALTER TABLE TEAM ADD CONSTRAINT PK_TEAM PRIMARY KEY (
	TEAM_NO
);

ALTER TABLE EXAM_CATEGORY ADD CONSTRAINT PK_EXAM_CATEGORY PRIMARY KEY (
	EXAM_CATEGORY_NO
);

ALTER TABLE TEAM_ROLE ADD CONSTRAINT PK_TEAM_ROLE PRIMARY KEY (
	TEAM_ROLE_NO
);

ALTER TABLE SUBMIT_ANSWER ADD CONSTRAINT PK_SUBMIT_ANSWER PRIMARY KEY (
	SUBMIT_ANSWER_NO
);

ALTER TABLE NOTICE_PHOTO ADD CONSTRAINT PK_NOTICE_PHOTO PRIMARY KEY (
	NOTICE_PHOTO_NO
);

ALTER TABLE ANSWER ADD CONSTRAINT PK_ANSWER PRIMARY KEY (
	ANSWER_NO
);

ALTER TABLE LECTURE ADD CONSTRAINT FK_MEMBER_TO_LECTURE_1 FOREIGN KEY (
	TEACHER_MEMBER_NO
)
REFERENCES MEMBER (
	MEMBER_NO
);

ALTER TABLE LECTURE ADD CONSTRAINT FK_LECTURE_CATEGORY_TO_LECTURE_1 FOREIGN KEY (
	LECTURE_CATEGORY_NO
)
REFERENCES LECTURE_CATEGORY (
	LECTURE_CATEGORY_NO
);

ALTER TABLE BOARD ADD CONSTRAINT FK_BOARD_CATEGORY_TO_BOARD_1 FOREIGN KEY (
	BOARD_CATEGORY_NO
)
REFERENCES BOARD_CATEGORY (
	BOARD_CATEGORY_NO
);

ALTER TABLE BOARD ADD CONSTRAINT FK_MEMBER_TO_BOARD_1 FOREIGN KEY (
	MEMBER_NO
)
REFERENCES MEMBER (
	MEMBER_NO
);

ALTER TABLE REPLY ADD CONSTRAINT FK_MEMBER_TO_REPLY_1 FOREIGN KEY (
	WRITER_NO
)
REFERENCES MEMBER (
	MEMBER_NO
);

ALTER TABLE REPLY ADD CONSTRAINT FK_BOARD_TO_REPLY_1 FOREIGN KEY (
	BOARD_NO
)
REFERENCES BOARD (
	BOARD_NO
);

ALTER TABLE LETTER ADD CONSTRAINT FK_MEMBER_TO_LETTER_1 FOREIGN KEY (
	SEND_MEMBER_NO
)
REFERENCES MEMBER (
	MEMBER_NO
);

ALTER TABLE LETTER ADD CONSTRAINT FK_MEMBER_TO_LETTER_2 FOREIGN KEY (
	RECEIVE_MEMBER_NO
)
REFERENCES MEMBER (
	MEMBER_NO
);

ALTER TABLE QNA ADD CONSTRAINT FK_ADMIN_TO_QNA_1 FOREIGN KEY (
	ADMIN_NO
)
REFERENCES ADMIN (
	ADMIN_NO
);

ALTER TABLE QNA ADD CONSTRAINT FK_STUDENT_TO_QNA_1 FOREIGN KEY (
	STUDENT_MEMBER_NO
)
REFERENCES STUDENT (
	STUDENT_MEMBER_NO
);

ALTER TABLE VACATION_REQUEST_LIST ADD CONSTRAINT FK_MEMBER_TO_VACATION_REQUEST_LIST_1 FOREIGN KEY (
	MEMBER_NO
)
REFERENCES MEMBER (
	MEMBER_NO
);

ALTER TABLE REVIEW ADD CONSTRAINT FK_MEMBER_TO_REVIEW_1 FOREIGN KEY (
	MEMBER_NO
)
REFERENCES MEMBER (
	MEMBER_NO
);

ALTER TABLE NOTICE ADD CONSTRAINT FK_ADMIN_TO_NOTICE_1 FOREIGN KEY (
	ADMIN_NO
)
REFERENCES ADMIN (
	ADMIN_NO
);

ALTER TABLE TEAM_CALENDER ADD CONSTRAINT FK_TEAM_TO_TEAM_CALENDER_1 FOREIGN KEY (
	TEAM_NO
)
REFERENCES TEAM (
	TEAM_NO
);

ALTER TABLE PROBLEM_BANK ADD CONSTRAINT FK_EXAM_CATEGORY_TO_PROBLEM_BANK_1 FOREIGN KEY (
	EXAM_CATEGORY_NO
)
REFERENCES EXAM_CATEGORY (
	EXAM_CATEGORY_NO
);

ALTER TABLE BOARD_PHOTO ADD CONSTRAINT FK_BOARD_TO_BOARD_PHOTO_1 FOREIGN KEY (
	BOARD_NO
)
REFERENCES BOARD (
	BOARD_NO
);

ALTER TABLE EXAM_LIST ADD CONSTRAINT FK_EXAM_CATEGORY_TO_EXAM_LIST_1 FOREIGN KEY (
	EXAM_CATEGORY_NO
)
REFERENCES EXAM_CATEGORY (
	EXAM_CATEGORY_NO
);

ALTER TABLE EXAM_LIST ADD CONSTRAINT FK_STUDENT_TO_EXAM_LIST_1 FOREIGN KEY (
	MEMBER_NO
)
REFERENCES STUDENT (
	STUDENT_MEMBER_NO
);

ALTER TABLE ATTENDANCE_LIST ADD CONSTRAINT FK_STUDENT_TO_ATTENDANCE_LIST_1 FOREIGN KEY (
	STUDENT_MEMBER_NO
)
REFERENCES STUDENT (
	STUDENT_MEMBER_NO
);

ALTER TABLE STUDENT ADD CONSTRAINT FK_MEMBER_TO_STUDENT_1 FOREIGN KEY (
	STUDENT_MEMBER_NO
)
REFERENCES MEMBER (
	MEMBER_NO
);

ALTER TABLE STUDENT ADD CONSTRAINT FK_LECTURE_TO_STUDENT_1 FOREIGN KEY (
	LECTURE_NO
)
REFERENCES LECTURE (
	LECTURE_NO
);

ALTER TABLE STUDENT ADD CONSTRAINT FK_TEAM_TO_STUDENT_1 FOREIGN KEY (
	TEAM_NO
)
REFERENCES TEAM (
	TEAM_NO
);

ALTER TABLE EXAM_CATEGORY ADD CONSTRAINT FK_LECTURE_CATEGORY_TO_EXAM_CATEGORY_1 FOREIGN KEY (
	LECTURE_CATEGORY_NO
)
REFERENCES LECTURE_CATEGORY (
	LECTURE_CATEGORY_NO
);

ALTER TABLE TEAM_ROLE ADD CONSTRAINT FK_TEAM_TO_TEAM_ROLE_1 FOREIGN KEY (
	TEAM_NO
)
REFERENCES TEAM (
	TEAM_NO
);

ALTER TABLE TEAM_ROLE ADD CONSTRAINT FK_STUDENT_TO_TEAM_ROLE_1 FOREIGN KEY (
	STUDENT_MEMBER_NO
)
REFERENCES STUDENT (
	STUDENT_MEMBER_NO
);

ALTER TABLE SUBMIT_ANSWER ADD CONSTRAINT FK_EXAM_LIST_TO_SUBMIT_ANSWER_1 FOREIGN KEY (
	EXAM_SCORE_NO
)
REFERENCES EXAM_LIST (
	EXAM_SCORE_NO
);

ALTER TABLE SUBMIT_ANSWER ADD CONSTRAINT FK_PROBLEM_BANK_TO_SUBMIT_ANSWER_1 FOREIGN KEY (
	EXAM_PROBLEM_NO
)
REFERENCES PROBLEM_BANK (
	EXAM_PROBLEM_NO
);

ALTER TABLE NOTICE_PHOTO ADD CONSTRAINT FK_NOTICE_TO_NOTICE_PHOTO_1 FOREIGN KEY (
	NOTICE_NO
)
REFERENCES NOTICE (
	NOTICE_NO
);

ALTER TABLE ANSWER ADD CONSTRAINT FK_REPLY_TO_ANSWER_1 FOREIGN KEY (
	REPLY_NO2
)
REFERENCES REPLY (
	REPLY_NO
);

