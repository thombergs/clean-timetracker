create table project
(
    id     int,
    name   varchar,
    status varchar
);
create table task
(
    id          int,
    name        varchar,
    invoiceable BOOLEAN,
    project_id  int,
    status      varchar
);
insert into project (id, name, status)
values (1000001, 'Clean Timetracker', 'ACTIVE');
insert into task (id, name, invoiceable, project_id, status)
values (1000001, 'Requirements Engineering', true, 1000001, 'ACTIVE');
insert into task (id, name, invoiceable, project_id, status)
values (1000002, 'Project Setup', true, 1000001, 'ACTIVE');
insert into task (id, name, invoiceable, project_id, status)
values (1000003, 'Coding', true, 1000001, 'ACTIVE');
insert into task (id, name, invoiceable, project_id, status)
values (1000004, 'Meetings', true, 1000001, 'ACTIVE');

