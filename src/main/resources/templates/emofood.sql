DROP DATABASE EMOFOOD;
CREATE DATABASE EMOFOOD;

DROP USER 'food_user'@'localhost';
CREATE USER 'food_user'@'localhost' IDENTIFIED WITH mysql_native_password BY '1234';

GRANT SELECT, INSERT, UPDATE, DELETE on EMOFOOD.* to 'food_user'@'localhost';

USE EMOFOOD;

CREATE TABLE KAKAO_INFO(
    kid INT,
    krate FLOAT,
    kcount_rate INT,
    kcount_blog INT,
    kkeyword VARCHAR(50),
	CONSTRAINT PRIMARY KEY(kid)
);

CREATE TABLE RESTAURANT(
    rid INT AUTO_INCREMENT,
    rname VARCHAR(255) NOT NULL,
    rcate VARCHAR(50) NOT NULL,
    raddr VARCHAR(255) NOT NULL,
    raddr_gu VARCHAR(12) NOT NULL,
    rphone VARCHAR(14) NOT NULL,
    rlocate_x FLOAT,
    rlocate_y FLOAT,
    kid INT,
	CONSTRAINT PRIMARY KEY(rid),
	FOREIGN KEY(kid) REFERENCES KAKAO_INFO(kid)
	ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE FOOD_MENU(
    fid INT AUTO_INCREMENT,
    fname VARCHAR(50) NOT NULL,
    fprice VARCHAR(20),
    fimg VARCHAR(255),
    rid INT,
	CONSTRAINT PRIMARY KEY(fid),
	FOREIGN KEY(rid) REFERENCES RESTAURANT(rid)
	ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE USER(
    uemail VARCHAR(255) NOT NULL,
    uname VARCHAR(30) NOT NULL,
    upw VARCHAR(52) NOT NULL,
    ugend TINYINT NOT NULL,
    uage INT NOT NULL,
    ujoindate DATETIME DEFAULT CURRENT_TIMESTAMP(),
	CONSTRAINT PRIMARY KEY(uemail)
);

CREATE TABLE EMOT_LOG(
    eid INT AUTO_INCREMENT,
	etime DATETIME DEFAULT CURRENT_TIMESTAMP(),
    eemote VARCHAR(255),
    elocate_x FLOAT,
    elocate_y FLOAT,
    uemail VARCHAR(255) NOT NULL,
	CONSTRAINT PRIMARY KEY(eid),
	FOREIGN KEY(uemail) REFERENCES USER(uemail)
	ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO RESTAURANT (rname,rcate,raddr,raddr_gu,rphone,rlocate_y,rlocate_x) VALUES
    ('메가커피', '카페', '서울시 마포구 양화로', '마포구', '02-123-4567', 39.12314412, 122.1231242112);

INSERT INTO USER (uemail, uname, upw, ugend, uage) VALUES
    ('admin', '관리자', '1234', 0, 9);

INSERT INTO EMOT_LOG(uemail, eemote, elocate_y, elocate_x) VALUES
    ('example@mail.com', '기쁨', 39.12314412, 122.1231242112);


    

LOAD DATA INFILE '/csvroot/file.csv'
INTO TABLE RESTAURANT
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(@rname, @rcate, @raddr, @raddr_gu, @rphone, @rlocate_x, @rlocate_y)
set 사업장명 = @rname,
    업태구분명 = @rcate,
    도로명주소 = @raddr,
    구 = @raddr_gu
    연락처 = @rphone,
    경도 = @rlocate_x,
    위도 = @rlocate_y;



LOAD DATA INFILE '/csvroot/file.csv'
INTO TABLE KAKAO_INFO
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(@kid, @krate, @kcount_rate, @kcount_blog, @kkeyword)
set 카카오맵번호 = @kid,
    카카오평점 = @krate,
    카카오후기개수 = @kcount_rate,
    카카오블로그리뷰개수 = @kcount_blog
    사업장명 = @kkeyword;

    
LOAD DATA INFILE '/csvroot/food.csv'
INTO TABLE FOOD_MENU
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(@rid, @fname, @fprice, @fimg)
set restaurant_id = @rid,
    food_name = @fname,
    food_price = @fprice,
    food_img = @fimg;