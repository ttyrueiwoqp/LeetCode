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