# Code blocks for Docker
``` bash
   docker run --name my-postgres-container -e POSTGRES_PASSWORD=root -p 5432:5432 postgres
   
   docker run --name pgsql-dev -e POSTGRES_PASSWORD=test1234 -v ${PWD}/postgres-docker:/var/lib/postgresql/data -p 5432:5432 postgres
```
## Code blocks for PostgreSQL
```PostgreSQL

create table my_table (user_id BIGSERIAL primary KEY, user_name varchar(255) not NULL );

insert into my_table (user_name) values ('Daniil');

delete from my_table where user_id = 1;

select * from my_table;


------------------------------------------------------------------------------------------------
create table user_info(user_id bigserial, user_name varchar(255));

select * from user_info;



create table vacation (vac_id bigserial, user_id bigint, vac_start date, vac_close date);

insert into user_info(user_name) values ('Danil');

insert into vacation(user_id, vac_start,vac_close) values (1, '2024-01-14', '2024-02-01');

select * from vacation;

select * from user_info left join vacation on user_info.user_id=vacation.user_id;

insert into vacation(user_id, vac_start,vac_close) values (2, '2024-01-14', '2024-02-01');

select * from vacation;


ALTER TABLE user_info 
ADD PRIMARY KEY (user_id);


ALTER TABLE vacation
    ADD CONSTRAINT fk_vacation_user_info FOREIGN KEY (user_id) REFERENCES user_info (user_id);
   
insert into vacation(user_id, vac_start,vac_close) values (1, '2024-01-30', '2024-02-15');q


```
