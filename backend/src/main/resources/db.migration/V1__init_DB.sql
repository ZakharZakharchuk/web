 create table departments (department_id int8 generated by default as identity, name varchar(255), short_name varchar(255), facility_id int8, primary key (department_id));
 create table disciplines (discipline_id int8 generated by default as identity, name varchar(255), primary key (discipline_id));
 create table facilities (facility_id int8 generated by default as identity, name varchar(255), short_name varchar(255), primary key (facility_id));
 create table groups (group_id int8 generated by default as identity, course int4, name varchar(255), department_id int8, primary key (group_id))
 create table schedules (schedule_id int8 generated by default as identity, classroom varchar(255), time timestamp, discipline_id int8, group_id int8, teacher_id int8, primary key (schedule_id));
 create table students (student_id int8 generated by default as identity, email varchar(255), name varchar(255), phone varchar(255), teacher_id int8, primary key (student_id));
 create table students_schedules (schedule_id int8 not null, student_id int8 not null);
 create table teachers (teacher_id int8 generated by default as identity, email varchar(255), name varchar(255), phone varchar(255), surname varchar(255), primary key (teacher_id));
 alter table if exists departments add constraint FK9kfar9gh4fg1k94s1wg2ijpbx foreign key (facility_id) references facilities;
 alter table if exists groups add constraint FKqh3pnyt97wuwjuqmu010d96ma foreign key (department_id) references departments;
 alter table if exists schedules add constraint FK5j5jf4mqkkr1qqgfblwhpypoa foreign key (discipline_id) references disciplines;
 alter table if exists schedules add constraint FKi8nxapnjxk1chfkho5f4h33aa foreign key (group_id) references groups;
 alter table if exists schedules add constraint FK66835t8mhqb22dmdyx8p6etjf foreign key (teacher_id) references teachers;
 alter table if exists students add constraint FKougrw6pw4r9ntbj3p8mnn39nh foreign key (teacher_id) references groups;
 alter table if exists students_schedules add constraint FKqblfwo40eeih1kcr6de200yya foreign key (student_id) references students;
 alter table if exists students_schedules add constraint FKtbal4tptykx4iycws8sdbajto foreign key (schedule_id) references schedules;