create table products (
  id integer identity,
  description varchar(255),
  price decimal(15,2)
);
create index products_description on products(description);

create table events (
  id integer identity,
  name varchar(255),
  eventDate date
);
create index events_description on products(description);
