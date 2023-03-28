CREATE TABLE th_member(
	idx number(10) PRIMARY KEY,	--회원 idx
	email varchar2(20) NOT NULL,	--회원 email
	password varchar2(20) NOT NULL,	--회원 password
	name varchar2(20) NOT NULL,		--회원 name
	nickname varchar2(20) NOT NULL,	--회원 nickname
	phone varchar2(20) NOT NULL,	--회원 phone
	birth varchar2(20) NOT NULL,	--회원 birth
	grade number(1) DEFAULT '1' 	--회원 grade
		--0 관리자
		--1 신규회원 /요린이
		--2 일반회원 /요리사
		--3 고급회원 /셰프
		--4 마스터회원 /고든램지
);
SELECT * FROM TH_MEMBER tm ;