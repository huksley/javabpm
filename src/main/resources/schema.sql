
drop table if exists requests;
create table requests
(
   id bigint not null,
   name varchar(255) not null,
   start_date date not null,
   end_date date not null,
   status integer not null,
   primary key(id)
);