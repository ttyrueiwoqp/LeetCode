# Select all employee's name and bonus whose bonus is < 1000.
#
# Table:Employee
#
# +-------+--------+-----------+--------+
# | empId |  name  | supervisor| salary |
# +-------+--------+-----------+--------+
# |   1   | John   |  3        | 1000   |
# |   2   | Dan    |  3        | 2000   |
# |   3   | Brad   |  null     | 4000   |
# |   4   | Thomas |  3        | 4000   |
# +-------+--------+-----------+--------+
# empId is the primary key column for this table.
# Table: Bonus
#
# +-------+-------+
# | empId | bonus |
# +-------+-------+
# | 2     | 500   |
# | 4     | 2000  |
# +-------+-------+
# empId is the primary key column for this table.
# Example ouput:
#
# +-------+-------+
# | name  | bonus |
# +-------+-------+
# | John  | null  |
# | Dan   | 500   |
# | Brad  | null  |
# +-------+-------+


SELECT *
FROM
  (SELECT
     e.name,
     b.bonus
   FROM employee e LEFT JOIN bonus b
       ON e.empId = b.empId
  ) eb
WHERE eb.bonus IS NULL
      OR eb.bonus < 1000;