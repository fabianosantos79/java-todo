create table todo(
    id bigint not null auto_increment,
    title varchar(100) not null,
    message varchar(255) not null,
    priority varchar(100) not null,

    primary key(id)
);