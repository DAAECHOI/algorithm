-- 1
select ename, e.deptno, dname
from emp e join dept d
on e.deptno = d.deptno
where d.deptno = 30;

-- 2
select distinct job, loc
from emp e join dept d
on e.deptno = d.deptno
where d.deptno = 30;

-- 3
select ename, dname, loc
from emp e join dept d
on e.deptno = d.deptno
where d.deptno = 30
and comm is not null;

-- 4
select ename, dname
from emp e join dept d
on e.deptno = d.deptno
where ename like '%A%';

-- 5
select ename, job, d.deptno, dname
from emp e join dept d
on e.deptno = d.deptno
where loc = 'Dallas';

-- 6
select e.ename employee, e.empno 'emp#', m.ename manager, m.empno 'mgr#'
from emp e join emp m
where e.mgr = m.empno;

-- 7
select ename, job, dname, sal, grade
from emp e join dept d
on e.deptno = d.deptno
join salgrade s
on sal between losal and hisal;

-- 8
select ename, hiredate
from emp
where hiredate > (
				select hiredate
				from emp
				where ename = 'Smith'
				);

-- 9
select e.ename 'Employee', e.hiredate 'EmpHiredate', m.ename 'Manager', m.hiredate 'MgrHiredate'
from emp e join emp m
on e.mgr = m.empno
where e.hiredate < m.hiredate;

-- 10
select ename, hiredate
from emp
where deptno = (
				select deptno
                from emp
                where ename = 'Smith'
                )
and not ename = 'Smith';

-- 11
select empno, ename, sal
from emp
where sal > (
			select avg(sal)
            from emp
            )
order by sal desc;

-- 12
select empno, ename
from emp
where deptno in (
				select distinct d.deptno
                from dept d join emp e
                on d.deptno = e.deptno
                where e.ename like '%T%'
                );

-- 13
select empno, ename, sal
from emp
where sal > (
			select avg(sal)
            from emp
            )
and  deptno in (
				select distinct d.deptno
                from dept d join emp e
                on d.deptno = e.deptno
                where e.ename like '%T%'
                );

-- 14
select empno, ename, sal
from emp
where sal > all (
			select sal
            from emp
            where job = 'Clerk'
            )
order by sal desc;

-- 15
select e.ename, d.dname
from emp e join dept d
on e.deptno = d.deptno
where sal in (
			select sal
            from emp e join dept d
            on e.deptno = d.deptno
            where loc = 'New York'
            )
and comm in (
			select comm
            from emp e join dept d
            on e.deptno = d.deptno
            where loc = 'New York'
            );

select e.ename, d.dname, d.loc, sal, comm
from emp e join dept d
on e.deptno = d.deptno
where loc = 'New York';

select ename, sal, comm, deptno
from emp;