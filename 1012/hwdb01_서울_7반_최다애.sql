select *
from emp
where hiredate between '2014-01-01' and '2014-12-31';

select *
from emp
where ename like '%S%';

select *
from emp
where comm is null;

select ename, deptno, sal, (sal * 12) + (sal * 1.5) "Monthly Salary"
from emp
where deptno = 30;

select ename, sal, sal * 0.15 "expenses"
from emp
where sal >= 2000;
