/*Request Questions*/
use game;
select *
from questions
order by RANDOM()
limit 10;

/*Get Client Data*/
use game;
select *
from users 
where user_id = 'test_user';/*replace test_user with string variable from servlet*/

/*Create Test User ID: 123456789*/
insert into users(id, user_id)
values(123456789, 'test_user');/*Replace 123456789 with auto generated id, and 'test_user' with hashed id?*/


/*Update Score*/
use game;
set @x := (select id from users where user_id = 'test_user');/*replace test_user with id variable*/
update users
set score = 1 /*replace 1 with score variable*/
where id = @x;







