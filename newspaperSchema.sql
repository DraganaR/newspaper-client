DROP DATABASE IF EXISTS newspaper;
CREATE DATABASE IF NOT EXISTS newspaper;
USE newspaper;

DROP TABLE IF EXISTS customer;

CREATE TABLE customer (																				
	cus_id INTEGER AUTO_INCREMENT,																				
	first_name VARCHAR(15) NOT NULL,																				
	sur_name VARCHAR(20) NOT NULL,																				
	title VARCHAR(4) NOT NULL,																				
	address1 VARCHAR(20) NOT NULL,																		
	address2 VARCHAR(20),																				
	town VARCHAR(20),																				
	county VARCHAR(20) NOT NULL,																				
	eircode VARCHAR(7) NOT NULL,																				
	balance decimal(4,2) NOT NULL,		
	PRIMARY KEY(cus_id)																																					
);			

DROP TABLE IF EXISTS staff;
 
CREATE TABLE staff (																				
staff_id INTEGER AUTO_INCREMENT NOT NULL,																				
first_name VARCHAR(15) NOT NULL,																				
sur_name VARCHAR(20) NOT NULL,
PRIMARY KEY(staff_id)																			
);	

DROP TABLE IF EXISTS publication;

CREATE TABLE publication(																				
pub_id INTEGER AUTO_INCREMENT NOT NULL,																				
title VARCHAR(25) NOT NULL,																				
price VARCHAR(20) NOT NULL,		
PRIMARY KEY(pub_id)													
);	

DROP TABLE IF EXISTS delivery;

CREATE TABLE delivery (																				
delivery_id INTEGER AUTO_INCREMENT NOT NULL,																				
date VARCHAR(7),	
cus_id INTEGER NOT NULL,
pub_id INTEGER NOT NULL,
PRIMARY KEY(delivery_id),	
FOREIGN KEY(cus_id) REFERENCES customer (cus_id),
FOREIGN KEY(pub_id) REFERENCES publication (pub_id)															
);	

DROP TABLE IF EXISTS invoice;

CREATE TABLE invoice (																				
invoice_id INTEGER AUTO_INCREMENT NOT NULL,																				
amount INTEGER NOT NULL,																				
date datetime NOT NULL,
cus_id INTEGER NOT NULL,
delivery_id INTEGER NOT NULL,
PRIMARY KEY(invoice_id),
FOREIGN KEY(cus_id) REFERENCES customer (cus_id),
FOREIGN KEY(delivery_id) REFERENCES delivery (delivery_id)													
);	

DROP TABLE IF EXISTS orders;

CREATE TABLE orders(			
order_id INTEGER AUTO_INCREMENT NOT NULL,			
days VARCHAR(7),
cus_id INTEGER NOT NULL,
pub_id INTEGER NOT NULL,
PRIMARY KEY(order_id),	
FOREIGN KEY(pub_id) REFERENCES publication (pub_id),
FOREIGN KEY(cus_id) REFERENCES customer (cus_id)
);

select "All tables created successfully" as "info";

INSERT INTO customer (cus_id, first_name, sur_name, title, address1, 
address2, town, county, eircode, balance)
VALUES (0001, 'John', 'Doe', 'Mr', '7 Monksfield Park', 'Monksland', 'Athlone', 'Co.Roscommon', 'N37Y0X3', 0.00)
INSERT INTO customer VALUES(0002, 'Jane', 'Doe', 'Miss', '1 Sli An Choiste', 'Monksland', 'Athlone', 'Co.Roscommon', 'N37N5K3', 0.00);
INSERT INTO customer VALUES(0003, 'Tom', 'Smith', 'Mr', '18 St Andrews Park', 'Outlands', 'Swords', 'Dublin', 'K67TX32', 0.00);
INSERT INTO customer VALUES(0004, 'Jack', 'Jones', 'Mr', '34 Sail Ardan', 'Ardshanavooly', 'Killarney', 'Kerry', 'V93V5Y3', 0.00);
INSERT INTO customer VALUES(0005, 'Ann', 'Williams', 'Mrs', '22 River Ville', 'Oakview Village', 'Tralee', 'Kerry', 'V92P624', 0.00);


INSERT INTO staff (staff_id, first_name, sur_name)
VALUES (0001, 'Joe', 'Smith');
INSERT INTO staff VALUES (0002, 'Dragana', 'Ruzic');
INSERT INTO staff VALUES (0003, 'Gary', 'Daly');
INSERT INTO staff VALUES (0004, 'Mark', 'Farrell');
INSERT INTO staff VALUES (0005, 'Tom', 'Devlin');
);

INSERT INTO publication (pub_id, title, price)
VALUES (1, 'Westmeath Independent', 2.40);
INSERT INTO publication VALUES (2, 'The Sun', 3.00);
INSERT INTO publication VALUES (3, 'Irish Times', 2.00);
INSERT INTO publication VALUES (4, 'Irish Independent', 1.50);
INSERT INTO publication VALUES (5, 'Irish Examiner', 1.00);
);


