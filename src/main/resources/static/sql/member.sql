CREATE TABLE th_member
(
	idx number(10) PRIMARY KEY,		--회원 idx
	email varchar2(20) NOT NULL,	--회원 email
	password varchar2(20) NOT NULL,	--회원 password
	name varchar2(20) NOT NULL,	--회원 name
	nickname varchar2(20) NOT NULL,	--회원 nickname
	phone varchar2(20) NOT NULL,	--회원 phone
	birth varchar2(20) NOT NULL,		--회원 birth
	createAt timestamp DEFAULT sysdate,	--회원 createAt
	grade number(1) DEFAULT '1' 	--회원 grade
		--0 관리자
		--1 신규회원 /요린이
		--2 일반회원 /짜파게티 요리사
		--3 고급회원 /셰프
		--4 마스터회원 /고든램지
);

CREATE SEQUENCE thmemidx_seq;

INSERT INTO th_member (idx,email,password,name,nickname,phone,birth,grade)
VALUES (thmemidx_seq.nextval,'admin@admin.net','1111','admin','admin','010-0000-0000','2000-01-01',0);
INSERT INTO th_member (idx,email,password,name,nickname,phone,birth,grade)
VALUES (thmemidx_seq.nextval,'nyr@naver.com','1111','남유리','NYR','010-1111-1111','2000-01-01',1);
INSERT INTO th_member (idx,email,password,name,nickname,phone,birth,grade)
VALUES (thmemidx_seq.nextval,'cgh@daum.net','1111','조건희','CGH','010-2222-2222','2000-01-01',2);
INSERT INTO th_member (idx,email,password,name,nickname,phone,birth,grade)
VALUES (thmemidx_seq.nextval,'cjw@google.com','1111','최재우','CJW','010-3333-3333','2000-01-01',3);
INSERT INTO th_member (idx,email,password,name,nickname,phone,birth,grade)
VALUES (thmemidx_seq.nextval,'hyc@yahoo.co.kr','1111','홍용치','HYC','010-4444-4444','2000-01-01',4);