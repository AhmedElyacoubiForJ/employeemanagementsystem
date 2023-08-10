-- select AVG(salary)
-- from employee

-- 1. average salary per department
select AVG(salary) salary_average, department
from employee
group by department;

-- 1.1 test 1
select AVG(salary) salary_average_account_and_finance
from employee
where department = 'Account And Finance';

-- 1.2 test 1
select AVG(salary) salary_average_hr
from employee
where department = 'HR';

-- 1.3 test 1
select AVG(salary) salary_average_infrastructure
from employee
where department = 'Infrastructure';

-- 2. average salary per department ordered
select AVG(salary) salary_average, department
from employee
group by department
order by salary_average desc;

select AVG(salary) salary_average, department
from employee
group by department
order by salary_average desc limit 1;

-- 2. average salary per department, gender
select AVG(salary) salary_average, department, gender
from employee
group by department, gender;

-- 2.1 test 2
select AVG(salary) salary_average_male, department
from employee
where gender = 'Male'
group by department;

-- 2.2 test 2
select AVG(salary) salary_average_female, department
from employee
where gender = 'Female'
group by department;

-- 3. number of male per department
select count(*) count_male, department
from employee
where gender = 'Male'
group by department;

-- 3.1 group filter
select count(*) count_gender_male, department
from employee
where gender = 'Male'
group by department
having count_gender_male > 2;

-- number of female per department
select count(*) count_female, department
from employee
where gender = 'Female'
group by department;

-- only for department having more than one female
select count(*) count_gender_female, department
from employee
where gender = 'Female'
group by department
having count_gender_female > 1;

-- age duplicate per department
select count(age) age_count, department
from employee
group by department, age
having age_count > 1

