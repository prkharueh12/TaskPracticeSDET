SELECT JOBS.job_title, min_salary
FROM JOBS
WHERE min_salary > 1000;
----------------------------------------
SELECT first_name, hire_date
FROM EMPLOYEES
where hire_date BETWEEN '31-DEC-01' AND '01-JAN-06';
--------------------------------------------
SELECT emp.first_name, emp.hire_date, emp.JOB_ID 
FROM EMPLOYEES  emp
WHERE JOB_ID = 'IT_PROG' OR JOB_ID = 'SA_MAN' ;
------------------------------------------------
SELECT emp.first_name, emp.last_name, emp.hire_date
FROM employees emp
WHERE emp.hire_date > '1-JAN-08';
----------------------------------------------
SELECT * 
FROM employees
WHERE employee_ID = 150 OR employee_ID = 160;
-------------------------------------------------
SELECT emp.first_name, emp.salary, emp.commission_pct, emp.hire_date
FROM employees emp
WHERE salary < 10000 ;
------------------------------------------------
SELECT Job_title, max_salary,min_salary
FROM JOBS
WHERE max_salary BETWEEN 10000 AND 20000;
------------------------------------------------
SELECT first_name, ROUND(salary, -3) RoundedSalary
FROM employees;
-------------------------------
SELECT job_title
FROM JOBS
ORDER BY job_title desc;
---------------------------------
SELECT emp.first_name, emp.last_name
FROM EMPLOYEES emp
WHERE emp.first_name LIKE 'S%' OR emp.last_name LIKE 'S%';
---------------------------------
SELECT first_name, hire_date
FROM employees
WHERE hire_date LIKE '%MAY%';
---------------------------------------
SELECT *
FROM employees 
WHERE commission_pct IS NULL 
AND salary BETWEEN 5000 AND 10000 
AND department_ID = 30;
--------------------------------------
SELECT first_name, hire_date, salary
FROM EMPLOYEES
WHERE  rownum = 1;
 ---------------------------------------
 ----NOT SURE 
SELECT DISTINCT ROUND((jh.end_date - jh.Start_date)/365, 0)  EXPERIENCES, emp.first_name
FROM employees emp
RIGHT JOIN job_history jh
ON emp.employee_id = jh.employee_id;
-----------------------------------------
SELECT first_name, hire_date
FROM employees
WHERE hire_date LIKE  '%01';
-------------------------------------------
SELECT INITCAP (first_name),(last_name)
FROM employees;
-------------------------------------------
SELECT INITCAP (first_name),(last_name), hire_date
FROM employees
WHERE hire_date LIKE '%21';
----------------------------------------------
SELECT  job_ID, salary
FROM employees 
WHERE salary >10000 ;
----------------------------------------
SELECT emp.employee_ID, dp.department_ID, emp.hire_date
FROM departments dp
INNER JOIN employees emp
ON dp.manager_id = emp.manager_id;
--GROUP by dp.department_ID, emp.hire_date;
---------------------------------------
SELECT dp.department_name, emp.manager_ID, emp.first_name
FROM departments dp
INNER JOIN employees emp
ON dp.manager_id = emp.manager_id;
