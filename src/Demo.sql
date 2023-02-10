create table customer (
    cid varchar(10),
    name varchar(20),
    town varchar(20),
    salary decimal(10,2),
    constraint primary key(cid)
);

insert into customer values("c01","yasindu","panadura",25000.00);
insert into customer values("c02","pasindu","galle",35000.00);
insert into customer values("c03","kavindu","colombo",15000.00);

create table item (
    iid varchar(10),
    name varchar(20),
    qty int,
    constraint primary key(iid)
);

insert into item values("i001","Parippu",5);
insert into item values("i002","Saban",6);
insert into item values("i003","cream Soda",3);

create table orders(
    oid varchar(10),
    order_date date,
    cus_id varchar(10),
    item_id varchar(10),
    constraint primary key(oid),
    constraint foreign key (cus_id) references customer(cid),
    constraint foreign key (item_id) references item(iid)
);

insert into orders('o001','2023-02-08','C02');