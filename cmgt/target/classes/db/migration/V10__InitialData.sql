INSERT INTO `instructor` (`id`, `name`, `password`, `surname`)
VALUES
(1, 'john', '{bcrypt}$2a$10$Q0jUGTx6m1EaZZdgs.h8TuDJ5PRm46CEiWS7tyk3gGgeLGuiAxkPG', 'doe'),
(2, 'max', '{bcrypt}$2a$10$ZEAhjl.GToZ9ciJSDEQN2.CkLAZuEP5lGu24HV.V5dqZ1GYpkd4Au', 'dax'),
(3, 'admin', '{bcrypt}$2a$10$pUZlsxs9hcWI9RDnl4k5TeRo7eDctXq3vxH9wSKisWxnxd.eJKswG', 'admin')
;

INSERT INTO `student` (`id`, `name`, `semester`, `surname`, `year_of_enrollment`)
VALUES
(NULL, 'sName1', '1', 'sSurName1', '2014-05-01 00:00:00'),
(NULL, 'sName2', '2', 'sSurName2', '2015-05-01 00:00:00')
;

INSERT INTO `course` (`id`, `description`, `ects`, `name`, `semester`, `year`)
VALUES
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '431', 'Course1', '1', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '321', 'Course2', '2', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '431', 'Course3', '1', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '321', 'Course4', '2', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '431', 'Course5', '1', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '321', 'Course6', '2', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '431', 'Course7', '1', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '321', 'Course8', '2', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '431', 'Course9', '1', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '321', 'Course10', '2', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '431', 'Course11', '1', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '321', 'Course12', '2', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '431', 'Course13', '1', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '321', 'Course14', '2', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '431', 'Course15', '1', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '321', 'Course16', '2', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '431', 'Course17', '1', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '321', 'Course19', '2', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '431', 'Course20', '1', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '321', 'Course21', '2', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '431', 'Course22', '1', '2014-05-01 00:00:00'),
(NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '321', 'Course23', '2', '2014-05-01 00:00:00')
;