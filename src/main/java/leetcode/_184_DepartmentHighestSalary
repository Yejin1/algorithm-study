
// Leetcode
// 184. Department Highest Salary
// https://leetcode.com/problems/department-highest-salary/description/
// 유형 : SQL


select
    d.name as Department,
    e.name as Employee,
    e.salary as Salary
from
    Department d,
    Employee e
where 1=1
    and d.id = e.departmentId
    and (e.salary, e.departmentId) in (select Max(salary) as salary, departmentId from employee group by departmentId)