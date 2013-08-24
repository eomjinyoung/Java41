/* 데이터 삭제 
delete from 테이블명
where 조건
*/
SET SQL_SAFE_UPDATES=0;

delete from MEMBERS 
where MNAME='일지매';

select *
from MEMBERS;

delete from MEMBERS
where PHONE like '%1111' or PHONE like '%1112';

delete from MEMBERS
where EMAIL='hong@test.com';



