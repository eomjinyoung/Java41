/* 테이블 생성 */
/* 
- 기본키를 정의
- 기본키(PRIMARY KEY)
  . 후보키들 중에서 DB 관리자가 사용하기로 선택한 키 
  . 이메일
- 후보키(Alternate key)
  . 키들을 최소로 만든 키
  . 예)
    이름, 전화번호
    블로그
    이메일
- 키(key)
  . 데이터를 구분하기 위한 컬럼들의 집합
  . 예) 
    이름, 전화번호
	전화번호, 블로그
	이름, 블로그
	이름, 전화번호, 블로그
	이름, 이메일, 전화번호
	이메일
	이름, 나이, 이메일
	전화번호, 이메일
	블로그

*/
/* drop table 테이블명
 - 테이블 삭제(테이블의 모든 데이터도 함께 삭제된다)
*/
drop table MEMBERS;

/* create table 테이블명
 - 테이블 생성
*/
create table MEMBERS
(
	MNAME	varchar(50) not null,
	PHONE	varchar(15) not null,
	EMAIL	varchar(50) not null /*primary key*/,
	BLOG	varchar(100),
	AGE		int,
	REG_DATE	DATETIME
);

alter table MEMBERS 
	add primary key(EMAIL);

/* insert
- 테이블에 데이터 입력
- insert into 테이블명(컬럼명, 컬럼명, ...) 
  values(값, 값, ...) 
*/
insert into MEMBERS(MNAME,PHONE,EMAIL,BLOG,AGE,REG_DATE)
values ('홍길동','111-1111','hong@test.com',
		'hong.blog.com',20,now());

insert into MEMBERS(MNAME,PHONE,EMAIL,BLOG,AGE,REG_DATE)
values ('임꺽정','111-1112','leem@test.com',
		'leem.blog.com',30,now());

insert into MEMBERS(MNAME,PHONE,EMAIL,BLOG,AGE,REG_DATE)
values ('일지매','111-1113','ill@test.com',
		'ill.blog.com',40,now());

/* 컬럼명 생략
 - 테이블 생성 시 선언된 순서대로 값을 입력한다. 
*/
insert into MEMBERS
values ('장보고','111-1113','jang@test.com',
		'jang.blog.com',40,now());

/* 필수 컬럼의 값만 입력 */
insert into MEMBERS (EMAIL,PHONE,MNAME)
values ('kang2@test.com','111-1115','강감찬2');

/* PROJECTS 테이블 생성 */
create table PROJECTS (
	PNO int not null auto_increment primary key,
	MGR varchar(50),
	TITLE varchar(200) not null,
	CONTENT text,
	START_DAT datetime not null,
	END_DAT datetime not null,
	CREATED_DAT datetime
);

insert into PROJECTS(TITLE,CONTENT,START_DAT,END_DAT,CREATED_DAT)
values('aaa','aaaaaa','2013-08-20','2013-09-20',now());

insert into PROJECTS(TITLE,CONTENT,START_DAT,END_DAT,CREATED_DAT)
values('bbbb','bbbbbb','2013-08-20','2013-09-20',now());

insert into PROJECTS(TITLE,CONTENT,START_DAT,END_DAT,CREATED_DAT)
values('ccc','ccccccc','2013-08-20','2013-09-20',now());

