create table biz_member
(
    member_no   serial primary key,
    email       varchar(100) not null,
    password    varchar(150) not null,
    name        varchar(100) not null,
    tel         varchar(20)  not null,
    auth        varchar(20)  not null,
    email_yn    varchar(1)   not null,
    del_flag    varchar(1)   not null default 'N',
    reg_date    timestamp    not null,
    update_date timestamp    not null
)

create table company
(
    company_no   serial primary key,
    member_no   int not null,
    name       varchar(100) not null,
    address    varchar(2000) not null,
    address_detail    varchar(1000) not null,
    irs        varchar(12) not null,
    site         varchar(1000)  not null,
    descript        varchar(3000)  not null,
    -- logo       not null,
    del_flag    varchar(1)   not null default 'N',
    reg_date    timestamp    not null,
    update_date timestamp    not null,
    foreign key(member_no) REFERENCES biz_member(member_no)
)


create table mail_cf
(
    mail_no  serial primary key,
    email    varchar(100) not null,
    cf_no    int          not null,
    reg_date timestamp    not null
);