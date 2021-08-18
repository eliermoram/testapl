DROP TABLE IF EXISTS credit;

create table credit(
	credit_id INT AUTO_INCREMENT  PRIMARY KEY,
	amount double,
	terms int,
	rate double
);

DROP TABLE IF EXISTS payment;

create table payment(
	payment_id INT AUTO_INCREMENT  PRIMARY KEY,
	payment_number int,
	amount double,
	payment_date date,
	credit_id bigint
);
