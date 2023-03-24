CREATE TABLE th_member(
	idx number(10) PRIMARY KEY,		--회원 idx
	id varchar2(20) NOT NULL,		--회원 id
	password varchar2(20) NOT NULL,	--회원 password
	name varchar2(20) NOT NULL,	--회원 name
	nickname varchar2(20) NOT NULL,	--회원 nickname
	phone varchar2(20) NOT NULL,	--회원 phone
	email varchar2(20) NOT NULL,	--회원 email
	birth varchar2(20) NOT NULL,		--회원 birth
	createAt timestamp DEFAULT sysdate,	--회원 createAt
	grade number(1) DEFAULT '1' 	--회원 grade
		--0 관리자
		--1 신규회원 /요린이
		--2 일반회원 /요리사
		--3 고급회원 /셰프
		--4 마스터회원 /고든램지
);