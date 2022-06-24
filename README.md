# Myy803 Project 

## Prerequisites

- [git](https://git-scm.com)
- [docker](https://www.docker.com/)
- [eclipse](https://www.eclipse.org/)
- [java >=8](https://www.oracle.com/java/technologies/downloads/#jdk17-windows)
- [Maven](https://maven.apache.org/download.cgi)

## Initial Setup

Before all, we need to start a local instance of the MariaDB database with the help of `docker-compose`.

In the root of the project's folder run:

```bash
docker-compose up -d
```

Then, we need to create/migrate the database of the project.

We do so with the maven [Flyway](https://flywaydb.org/documentation/database/mysql) plugin command:

```bash
mvnw flyway:migrate
```

## Useful Info

* Database: `tcp:localhost:3306`
* Database Credentials = user: `root`, password: `password`
* phpMyAdmin: [http://localhost:8081](http://localhost:8081)
  - Connect on `db` database instance
* Application: [http://localhost:8080](http://localhost:8080)
* Instructor Credentials = user: `admin`, password: `admin`

## Sprints allocation

Sprints are comprised by 8 working days. Meaning 1 and a half week.

- US1-US5 are course related and can be done by 1 dev in 1 sprint
- US6-US9 are student related tasks and can be done  by 1 dev in 1 sprint (in parallel to courses)
- US10-US11 is an added feature on top of previous use cases and has to be started after these use cases on the second sprint
- US12 Statistics are a metrics feature for traceability and can be done once all previous use cases are complete.
