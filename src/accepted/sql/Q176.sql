select max(a.Salary) from Employee a
where a.Salary < (
select max(b.Salary)
from Employee b)