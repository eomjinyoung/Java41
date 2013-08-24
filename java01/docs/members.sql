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
drop table MEMBERS;

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
- insert into 테이블명(컬럼명, 컬럼명, ...) values(값, 값, ...) 
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
