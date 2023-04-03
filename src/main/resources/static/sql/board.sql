CREATE TABLE board(
	idx number(10) NOT NULL, -- SEQ
	category varchar2(300) NOT NULL, --카테고리
	subCate varchar2(300),	-- 대분류
	nickname varchar2(30) NOT NULL, -- 작성자
	title varchar2(400) NOT NULL, -- 글 제목
	filename varchar2(200),	-- 파일명
	content clob NOT NULL, --글 내용, 제한 없이 쓸 수 있는 것
	regdate timestamp DEFAULT sysdate, -- 작성일자
	viewcnt NUMBER DEFAULT 0, --조회수
	numcomments NUMBER DEFAULT 0 --댓글 수 
);

select * from board
  	where idx = 136;
SELECT *FROM BOARD b ;
CREATE SEQUENCE board_idx_seq;
DROP TABLE board;
INSERT INTO HR.BOARD
(IDX, CATEGORY, subCate, NICKNAME, TITLE, FILENAME, CONTENT, REGDATE)
VALUES(board_idx_seq.nextval, '레시피','전통음식','집가자', '맛조아', '맛조아', '맛조아', sysdate); 
INSERT INTO HR.BOARD
(IDX, CATEGORY, subCate, NICKNAME, TITLE, FILENAME, CONTENT, REGDATE)
VALUES(board_idx_seq.nextval, '레시피','전통음식','집가자', '맛조아', '맛조아', '맛조아', sysdate); 
INSERT INTO HR.BOARD
(IDX, CATEGORY, subCate, NICKNAME, TITLE, FILENAME, CONTENT, REGDATE)
VALUES(board_idx_seq.nextval, '레시피','전통음식','집가자', '맛조아', '맛조아', '맛조아', sysdate); 
INSERT INTO HR.BOARD
(IDX, CATEGORY, subCate, NICKNAME, TITLE, FILENAME, CONTENT, REGDATE)
VALUES(board_idx_seq.nextval, '레시피','전통음식','집가자', '맛조아', '맛조아', '맛조아', sysdate); 
INSERT INTO HR.BOARD
(IDX, CATEGORY, subCate, NICKNAME, TITLE, FILENAME, CONTENT, REGDATE)
VALUES(board_idx_seq.nextval, '레시피','주식','집가자', '맛조아', '맛조아', '맛조아', sysdate); 
INSERT INTO HR.BOARD
(IDX, CATEGORY, subCate, NICKNAME, TITLE, FILENAME, CONTENT, REGDATE)
VALUES(board_idx_seq.nextval, '레시피','주식','집가자', '맛조아', '맛조아', '맛조아', sysdate); 
INSERT INTO HR.BOARD
(IDX, CATEGORY, subCate, NICKNAME, TITLE, FILENAME, CONTENT, REGDATE)
VALUES(board_idx_seq.nextval, '레시피','주식','집가자', '맛조아', '맛조아', '맛조아', sysdate); 
INSERT INTO HR.BOARD
(IDX, CATEGORY, subCate, NICKNAME, TITLE, FILENAME, CONTENT, REGDATE)
VALUES(board_idx_seq.nextval, '레시피','주식','집가자', '맛조아', '맛조아', '맛조아', sysdate); 
INSERT INTO HR.BOARD
(IDX, CATEGORY, subCate, NICKNAME, TITLE, FILENAME, CONTENT, REGDATE)
VALUES(board_idx_seq.nextval, '레시피','건강식','집가자', '맛조아', '맛조아', '맛조아', sysdate); 
INSERT INTO HR.BOARD
(IDX, CATEGORY, subCate, NICKNAME, TITLE, FILENAME, CONTENT, REGDATE)
VALUES(board_idx_seq.nextval, '레시피','건강식','집가자', '맛조아', '맛조아', '맛조아', sysdate); 
INSERT INTO HR.BOARD
(IDX, CATEGORY, subCate, NICKNAME, TITLE, FILENAME, CONTENT, REGDATE)
VALUES(board_idx_seq.nextval, '레시피','건강식','집가자', '맛조아', '맛조아', '맛조아', sysdate); 
INSERT INTO HR.BOARD
(IDX, CATEGORY, subCate, NICKNAME, TITLE, FILENAME, CONTENT, REGDATE)
VALUES(board_idx_seq.nextval, '레시피','건강식','집가자', '맛조아', '맛조아', '맛조아', sysdate); 
INSERT INTO HR.BOARD
(IDX, CATEGORY, subCate, NICKNAME, TITLE, FILENAME, CONTENT, REGDATE)
VALUES(board_idx_seq.nextval, '레시피','건강식','집가자', '맛조아', '맛조아', '맛조아', sysdate); 

INSERT INTO HR.BOARD
(IDX, CATEGORY, NICKNAME, TITLE, FILENAME, CONTENT, REGDATE)
VALUES(board_idx_seq.nextval, '자유','집가자', '맛조아', '맛조아', '맛조아', sysdate); 

INSERT INTO HR.BOARD
(IDX, CATEGORY, NICKNAME, TITLE, FILENAME, CONTENT, REGDATE)
VALUES(board_idx_seq.nextval, '질문','집가자', '맛조아', '맛조아', '맛조아', sysdate); 






SELECT IDX, CATEGORY, MAINCAG, NICKNAME, TITLE, FILENAME, CONTENT, REGDATE, VIEWCNT, NUMCOMMENTS
FROM HR.BOARD;
SELECT *FROM BOARD WHERE idx =2;

UPDATE board SET viewcnt = viewcnt + 1
WHERE idx = 2;
update board set numcomments = numcomments + 1
  where idx = 2;
update board set 
  mainCag = '지역별',
  title = '개맛있어',
  filename = '개맛있어',
  content = '존맛탱'
  where idx = 2;
  
 SELECT COUNT(*) FROM BOARD b ; 
SELECT FROM board WHERE del='n'
ORDER BY idx DESC;
--SELECT * FROM 
--			(SELECT rownum r ,f.* FROM
--								(SELECT * FROM community  ORDER BY idx DESC) f)
--		WHERE r BETWEEN #{start} AND #{end}
SELECT*FROM 
(SELECT ROWNUM r, f.*FROM
(SELECT*FROM BOARD b WHERE category = '레시피' ORDER BY idx DESC)f
)
WHERE r BETWEEN 1 AND 4;


SELECT*FROM
(SELECT ROWNUM r,f.*FROM
(SELECT * FROM BOARD b 
WHERE category = "자유,질문"
ORDER BY idx DESC)f)
WHERE r BETWEEN 1 AND 2;

SELECT*FROM
(SELECT ROWNUM r,f.*FROM
(SELECT * FROM BOARD b 
WHERE subCate='건강식'
ORDER BY idx DESC)f)
WHERE r BETWEEN 1 AND 2;


SELECT COUNT(*) FROM BOARD where MAINCAG ;


ALTER TABLE BOARD RENAME COLUMN MainCag TO "SUBCATE";

CREATE TABLE COMMENTS (
	idx number(10) NOT NULL,
	merf number(10) NOT NULL,
	Nickname varchar2(50) NOT NULL, -- 작성자
	contents clob NOT NULL, --댓글 내용
	createdate timestamp DEFAULT sysdate, -- 작성 날짜
	ip varchar2(15) DEFAULT '127.0.0.1', -- 작성자 ip
	PRIMARY key(idx)
);
DROP TABLE COMMENTS ;
SELECT *FROM COMMENTS c ;
CREATE SEQUENCE COMMENTS_idx_seq;
INSERT INTO HR.COMMENTS
(IDX, merf,NICKNAME, CONTENTS, CREATEDATE, IP)
VALUES(COMMENTS_idx_seq.nextval, 4,'wdwd', '집 가고 싶어', sysdate, '127.0.0.1');
SELECT *FROM BOARD b ;

INSERT INTO HR.COMMENTS
(IDX, merf,NICKNAME, CONTENTS, CREATEDATE, IP)
VALUES(COMMENTS_idx_seq.nextval, 123,'wdwd', '집 가고 싶어', sysdate, '127.0.0.1');


UPDATE board SET numcomments=(SELECT count(*) 
FROM COMMENTS c WHERE merf=123)
WHERE idx=123;

UPDATE board b SET numcomments=(SELECT count(*) 
FROM COMMENTS c WHERE c.merf=b.idx)
WHERE b.idx=c.MERF ;


/*CREATE OR REPLACE TRIGGER update_numcomments
AFTER INSERT OR DELETE ON COMMENTS
FOR EACH ROW
BEGIN
  UPDATE board SET numcomments = (SELECT COUNT(*) FROM COMMENTS WHERE idx = :NEW.merf)
  WHERE idx = :NEW.merf;
END;*/


SELECT *FROM BOARD b WHERE idx=123;
SELECT *FROM COMMENTS c ;





