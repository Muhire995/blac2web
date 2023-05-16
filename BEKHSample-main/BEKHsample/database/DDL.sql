create table staff(
	id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	firstname char(25),
	lastname char(25),
	email varchar(25) unique,
	phone varchar(10),
	password varchar(10)
);

create table business(
	id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	business_name varchar(25),
	owner_name char(30),
	email varchar(25),
	phone varchar(10),
	address varchar(30),
	ownership char(20),
	website varchar(30),
	description varchar(100)
);

create table event(
	id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	title varchar(25),
	host varchar(25),
	address varchar(25),
	event_date varchar(25),
	event_time varchar(25),
	description varchar(100),
	visible bool default FALSE
);