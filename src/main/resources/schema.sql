DROP TABLE IF EXISTS groceries;
DROP TABLE IF EXISTS purchase_cart;
DROP TABLE IF EXISTS exercises_table;

/*CREATE TBL*/
CREATE TABLE groceries (
	id serial NOT NULL,
    product_name varchar(64),
	price numeric,
    discount bigint,
	primary key(id)
);

CREATE TABLE purchase_cart (
	id serial NOT NULL,
    product_name varchar(64),
	price numeric,
    discount bigint,
    quantity bigint,
    amount numeric,
	primary key(id)
);

CREATE TABLE exercises_table (
	id serial NOT NULL,
    code varchar(64),
	order_date date,
    region varchar(64),
    rep varchar(64),
    item varchar(64),
    units bigint,
    unit_cost numeric,
    total numeric,
	primary key(id),
	UNIQUE(code)
);

INSERT INTO public.groceries(product_name, price, discount)
	VALUES ('Apple', 20, 2),
		   ('Grapes', 30, 3),
		   ('Sardines', 20, 6),
		   ('Eggs', 10, 3),
		   ('Chicken', 250, 4),
		   ('Beef', 350, 15),
		   ('Vinegar', 15, 5),
		   ('Bread', 5, 0),
		   ('Coffee', 10, 4),
		   ('Milk', 25, 7);
		   
INSERT INTO public.exercises_table(code, order_date, region, rep, item, units, unit_cost, total)
	 VALUES ('ABC1', '1/6/21', 'East', 'Jones', 'Pencil', 95, 1.99, 189.05),
			('ABC2', '1/23/21', 'Central', 'Kivell', 'Binder', 50, 19.99, 999.50),
			('ABC3', '2/9/21', 'Central', 'Jardine', 'Pencil', 36, 4.99, 179.64),
			('ABC4', '2/26/21', 'Central', 'Gill', 'Pen', 27, 19.99, 539.73),
			('ABC5', '3/15/21', 'West', 'Sorvino', 'Pencil', 56, 2.99, 167.44),
			('ABC6', '4/1/21', 'East', 'Jones', 'Binder', 60, 4.99, 299.40),
			('ABC7', '4/18/21', 'Central', 'Andrews', 'Pencil', 75, 1.99, 149.25),
			('ABC8', '5/5/21', 'Central', 'Jardine', 'Pencil', 90, 4.99, 449.10),
			('ABC9', '5/22/21', 'West', 'Thompson', 'Pencil', 32, 1.99, 63.68),
			('ABC10', '6/8/21', 'East', 'Jones', 'Binder', 60, 8.99, 539.40),
			('ABC11', '6/25/21', 'Central', 'Morgan', 'Pencil', 90, 4.99, 449.10),
			('ABC12', '7/12/21', 'East', 'Howard', 'Binder', 29, 1.99, 57.71),
			('ABC13', '7/29/21', 'East', 'Parent', 'Binder', 81, 19.99, 1619.19),
			('ABC14', '8/15/21', 'East', 'Jones', 'Pencil', 35, 4.99, 174.65),
			('ABC15', '9/1/21', 'Central', 'Smith', 'Desk', 2, 125.00, 250.00),
			('ABC16', '9/18/21', 'East', 'Jones', 'Pen Set', 16, 15.99, 255.84),
			('ABC17', '10/5/21', 'Central', 'Morgan', 'Binder', 28, 8.99, 251.72),
			('ABC18', '10/22/21', 'East', 'Jones', 'Pen', 64, 8.99, 575.36),
			('ABC19', '11/8/21', 'East', 'Parent', 'Pen', 15, 19.99, 299.85),
			('ABC20', '11/25/21', 'Central', 'Kivell', 'Pen Set', 96, 4.99, 479.04),
			('ABC21', '12/12/21', 'Central', 'Smith', 'Pencil', 67, 1.29, 86.43),
			('ABC22', '12/29/21', 'East', 'Parent', 'Pen Set', 74, 15.99, 1183.26),
			('ABC23', '1/15/22', 'Central', 'Gill', 'Binder', 46, 8.99, 413.54),
			('ABC24', '2/1/22', 'Central', 'Smith', 'Binder', 87, 15.00, 1305.00),
			('ABC25', '2/18/22', 'East', 'Jones', 'Binder', 4, 4.99, 19.96),
			('ABC26', '3/7/22', 'West', 'Sorvino', 'Binder', 7, 19.99, 139.93),
			('ABC27', '3/24/22', 'Central', 'Jardine', 'Pen Set', 50, 4.99, 249.50),
			('ABC28', '4/10/22', 'Central', 'Andrews', 'Pencil', 66, 1.99, 131.34),
			('ABC29', '4/27/22', 'East', 'Howard', 'Pen', 96, 4.99, 479.04),
			('ABC30', '5/14/22', 'Central', 'Gill', 'Pencil', 53, 1.29, 68.37),
			('ABC31', '5/31/22', 'Central', 'Gill', 'Binder', 80, 8.99, 719.20),
			('ABC32', '6/17/22', 'Central', 'Kivell', 'Desk', 5, 125.00, 625.00),
			('ABC33', '7/4/22', 'East', 'Jones', 'Pen Set', 62, 4.99, 309.38),
			('ABC34', '7/21/22', 'Central', 'Morgan', 'Pen Set', 55, 12.49, 686.95),
			('ABC35', '8/7/22', 'Central', 'Kivell', 'Pen Set', 42, 23.95, 1005.90),
			('ABC36', '8/24/22', 'West', 'Sorvino', 'Desk', 3, 275.00, 825.00),
			('ABC37', '9/10/22', 'Central', 'Gill', 'Pencil', 7, 1.29, 9.03),
			('ABC38', '9/27/22', 'West', 'Sorvino', 'Pen', 76, 1.99, 151.24),
			('ABC39', '10/14/22', 'West', 'Thompson', 'Binder', 57, 19.99, 1139.43),
			('ABC40', '10/31/22', 'Central', 'Andrews', 'Pencil', 14, 1.29, 18.06),
			('ABC41', '11/17/22', 'Central', 'Jardine', 'Binder', 11, 4.99, 54.89),
			('ABC42', '12/4/22', 'Central', 'Jardine', 'Binder', 94, 19.99, 1879.06),
			('ABC43', '12/21/22', 'Central', 'Andrews', 'Binder', 28, 4.99, 139.72);
			
			