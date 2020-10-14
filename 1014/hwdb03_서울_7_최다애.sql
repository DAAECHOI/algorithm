-- 1
select employee_id, first_name, job_id, department_id, department_name
from employees
join departments
using(department_id)
where department_id = (
					select department_id
                    from employees
                    where first_name= 'Diana'
                    );

-- 2
select e.employee_id, e.first_name, job_title, department_name
from employees e
join employees m
on e.manager_id = m.employee_id
join jobs j
on e.job_id = j.job_id
join departments d
on e.department_id = d.department_id
where e.manager_id = (
					select manager_id
					from employees
					where first_name = 'Bruce'
					);

select employee_id, first_name, job_title, department_name
from (
	select employee_id, first_name, job_id, department_id
    from employees e
	where manager_id = (
						select m.manager_id
						from employees m
						where first_name = 'Bruce'
						)
	) es
join jobs j
on es.job_id = j.job_id
join departments d
on es.department_id = d.department_id;

-- 3
select employee_id, first_name, hire_date
from employees
order by hire_date limit 5, 5;