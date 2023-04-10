CREATE TABLE uploadfile(
upidx NUMBER(10), --고유번호
boardNum number(10),--보드테이블 번호
fileName clob, -- 원본 파일명
filePath clob,
savefilename clob	--저장될 파일명
);
DROP TABLE UPLOADFILE ;

CREATE SEQUENCE file_idx_seq;

INSERT INTO UPLOADFILE
(IDX, BOARDNUM, FILENAME, FILEPATH ,SAVEFILENAME)
VALUES(file_idx_seq.nextval, #{boardNum}, #{fileName}, #{filePath},#{saveFileName})

SELECT IDX, BOARDNUM, FILENAME, SAVEFILENAME
FROM UPLOADFILE WHERE IDX =#{idx}

SELECT * FROM board;
SELECT * FROM UPLOADFILE;
SELECT MAX(idx) FROM uploadfile;
SELECT *FROM GALLERY g ;		
UPDATE UPLOADFILE
SET BOARDNUM=49 WHERE idx=27;

SELECT *FROM BOARD b
JOIN UPLOADFILE u 
ON b.IDX =u.BOARDNUM WHERE b.VIEWCNT =35;

UPDATE BOARD SET  VIEWCNT =1125 WHERE idx =60;

SELECT * FROM UPLOADFILE WHERE BOARDNUM=50 ORDER BY idx ASC;
select * from UploadFile    where boardNum = 50 ORDER BY idx ASC

DELETE FROM BOARD
WHERE SUBCATE ='선택 해주세요'; 

DELETE FROM UPLOADFILE u 
WHERE idx =42; 

 UPDATE BOARD SET  VIEWCNT =1000 WHERE idx =64;
 
SELECT * FROM BOARD b
JOIN UPLOADFILE u 
ON b.IDX =u.BOARDNUM
ORDER by b.VIEWCNT DESC ;
SELECT *FROM BOARD b ORDER by b.VIEWCNT DESC ;
SELECT *FROM UPLOADFILE u ;
 UPDATE BOARD SET  SUBCATE ='국/찌개/전곡' WHERE idx =68;
 UPDATE BOARD SET  SUBCATE ='반찬' WHERE idx =67;
 UPDATE BOARD SET  VIEWCNT = 2215 WHERE idx =68;
INSERT INTO UPLOADFILE
(UPIDX, BOARDNUM, FILENAME, FILEPATH, SAVEFILENAME)
VALUES(file_idx_seq.nextval, 68, '', '', '');

DELETE FROM UPLOADFILE
WHERE UPIDX=45 ;
DELETE FROM BOARD
WHERE IDX=66;

