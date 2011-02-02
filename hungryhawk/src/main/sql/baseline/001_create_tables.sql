create table events (
  id integer identity,
  name varchar(255),
  eventDate date
);

create table reservations (
  id integer identity,
  name varchar(255),
  guests integer,
  eventId integer
);
