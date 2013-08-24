/* desc 테이블명
 - 테이블에 대한 정보를 출력
*/
desc MEMBERS;

/* 데이터 조회 
- select 컬럼명, 컬럼명, ...
  from 테이블명
- select *
  from 테이블명
*/
select *
from MEMBERS;

/* 조건 조회
select *
from 테이블명
where
	컬럼명 연산자 값 and/or 컬럼명 연산자 값 ....
*/
select *
from MEMBERS
where
	MNAME='임꺽정' and PHONE='111-1113';

select PHONE
from MEMBERS
where
	MNAME='임꺽정' and PHONE='111-1112';

select *
from MEMBERS
where AGE > 30;

select *
from MEMBERS
where
	AGE > 30 or MNAME='임꺽정';

/* 연산자: <, >, <=, >=, =, <> */
select *
from MEMBERS
where AGE <> 40 or AGE is null;

select *
from MEMBERS
where AGE <= 30;

select *
from MEMBERS
where MNAME > '일지마';

select *
from MEMBERS
where REG_DATE > '2013-08-11';

select *
from MEMBERS
where REG_DATE >= '2013-08-12' and
	REG_DATE < '2013-08-15';

/* like */
select *
from MEMBERS
where MNAME like '임%';

select *
from MEMBERS
where MNAME like '%꺽정';

select *
from MEMBERS
where MNAME like '%정%';

select *
from MEMBERS
where MNAME like '임_정';

/* between a and b : x >= a and x <= b */
select *
from MEMBERS
where AGE >= 20 and AGE <= 30; 

select *
from MEMBERS
where AGE between 20 and 30;

/* in (값, 값, 값) */
select *
from MEMBERS
where AGE in (20, 35, 40);

select *
from MEMBERS
where AGE not in (20, 35, 40);

/* not */
select *
from MEMBERS
where not MNAME='임꺽정';

select *
from MEMBERS
where MNAME<>'임꺽정';

select *
from MEMBERS
where EMAIL='leem@test.com';

select MNAME,PHONE,EMAIL
from MEMBERS;





