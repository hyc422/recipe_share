-- 채팅 방
CREATE TABLE chatroom
(
	roomId varchar2(200) PRIMARY KEY,
	roomName varchar2(200) NOT NULL,
	userCount number(30) DEFAULT 0
);

-- 채팅방 유저목록
CREATE TABLE userlist
(
	userId varchar2(200) PRIMARY KEY,
	roomId varchar2(200) NOT NULL,
	nickName varchar2(20) NOT NULL
);