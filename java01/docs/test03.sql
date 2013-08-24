/* 데이터 변경 
update 테이블명 set 컬럼명=값, 컬럼명=값, ...
where 조건
*/
update MEMBERS set REG_DATE='2013-08-10'
where EMAIL='leem@test.com';

update MEMBERS set REG_DATE='2013-08-11'
where EMAIL='hong@test.com';

update MEMBERS set REG_DATE='2013-08-12'
where EMAIL='ill@test.com';

update MEMBERS set REG_DATE='2013-08-13'
where EMAIL='kang@test.com';

update MEMBERS set
	MNAME='홍길동2',
	PHONE='112-1111',
	BLOG='hong.blog.com',
	AGE=20,
	REG_DATE=now()
where 
	EMAIL='hong@test.com';











