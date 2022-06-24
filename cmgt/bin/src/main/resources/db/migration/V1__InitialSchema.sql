create table course (id integer not null auto_increment, description varchar(255), ects integer not null, name varchar(255), semester integer not null, year datetime, primary key (id))  ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
create table instructor (id integer not null auto_increment, name varchar(255), password varchar(255), surname varchar(255), primary key (id))  ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
create table instructor_courses (instructor_id integer not null, course_id integer not null, primary key (instructor_id, course_id))  ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
create table student (id integer not null auto_increment, name varchar(255), semester integer not null, surname varchar(255), year_of_enrollment datetime, primary key (id))  ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
create table student_courses (course_id integer not null, student_id integer not null, enrolled_time datetime, grade double precision not null, primary key (course_id, student_id))  ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
alter table instructor_courses add constraint FKh7ljffrnu8s7ubigl83r2qrf5 foreign key (course_id) references course (id);
alter table instructor_courses add constraint FK9bta2cjr5t7pgwp9h2ecb0x3q foreign key (instructor_id) references instructor (id);
alter table student_courses add constraint FKc614in0kdhj9sih7vw304qxgj foreign key (course_id) references course (id);
alter table student_courses add constraint FKiqufqwgb6im4n8xslhjvxmt0n foreign key (student_id) references student (id);