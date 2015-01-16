select a.FirstName, a.LastName, b.City, b.State 
from Person a left outer join Address b
on a.PersonId = b.PersonId