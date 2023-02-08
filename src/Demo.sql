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
    constraint primary key(oid),
    constraint foreign key (cus_id) references customer(cid)
);

insert into orders('o001','2023-02-08','C02');