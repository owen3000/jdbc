-- getList
  select emp_no, birth_date, first_name, last_name, gender, hire_date 
    from employees
order by hire_date
   limit 0, 100;
   
-- update
update employees
   set birth_date = '1971-12-18',
       first_name = '안',
       last_name = '대혁',
       gender = 'M',
       hire_date = '2018-03-08'
 where emp_no = 10001;

select * from employees;

desc employees;  