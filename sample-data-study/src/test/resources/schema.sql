create table team
(
    team_id bigint not null,
    name    varchar(255),
    primary key (team_id)
);

create table member
(
    member_id bigint not null,
    age       integer,
    username  varchar(255),
    team_id   bigint,
    primary key (member_id)
);

alter table member
    add constraint FKcjte2jn9pvo9ud2hyfgwcja0k
        foreign key (team_id)
            references team;
