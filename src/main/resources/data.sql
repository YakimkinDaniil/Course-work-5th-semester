INSERT INTO `autoschoolgroups` (`name`, `start_date`, `end_date`) VALUES
                                                                      ('Группа 1', '2024-01-01', '2024-12-31'),
                                                                      ('Группа 2', '2024-02-01', '2024-11-30'),
                                                                      ('Группа 3', '2024-03-01', '2024-10-31');

INSERT INTO `students` (`first_name`, `last_name`, `birth_date`, `contact_info`, `start_date`, `end_date`, `group_id`) VALUES
                                                                                                                           ('Даниил', 'Якимкин', '2005-07-01', 'daniil@yandex.ru', '2024-01-01', '2024-12-31', 1),
                                                                                                                           ('Иван', 'Иванов', '2000-01-01', 'ivan@yandex.com', '2024-02-01', '2024-11-30', 2),
                                                                                                                           ('Петр', 'Петров', '1995-05-05', 'petr@yandex.com', '2024-03-01', '2024-10-31', 3);

INSERT INTO `instructors` (`first_name`, `last_name`, `specialization`, `contact_info`) VALUES
                                                                                            ('Семен', 'Семенов', 'Практика', 'semen@yandex.ru'),
                                                                                            ('Антон', 'Антонов', 'Теория', 'anton@yandex.ru'),
                                                                                            ('Алексей', 'Сидоров', 'Практика', 'alex@yandex.ru');

INSERT INTO `lessons` (`type`, `date_time`, `location`, `instructor_id`, `group_id`) VALUES
                                                                                         ('Теория', '2024-01-01 10:00:00', 'Кабинет 1', 1, 1),
                                                                                         ('Практика', '2024-01-02 10:00:00', 'Кабинет 2', 2, 2),
                                                                                         ('Теория', '2024-01-03 10:00:00', 'Кабинет 3', 3, 3);

INSERT INTO `results` (`type`, `date`, `grade`, `student_id`) VALUES
                                                                  ('Экзамен', '2024-01-01', '5', 1),
                                                                  ('Экзамен', '2024-01-02', '4', 2),
                                                                  ('Экзамен', '2024-01-03', '5', 3);

INSERT INTO `applications` (`student_name`, `contact_info`, `application_date`) VALUES
                                                                                    ('Даниил Якимкин', 'daniil@yandex.ru', '2024-01-01'),
                                                                                    ('Иван Иванов', 'ivan@yandex.com', '2024-02-01'),
                                                                                    ('Петр Петров', 'petr@yandex.com', '2024-03-01');

INSERT INTO `roles` (`name`) VALUES
                                 ('ROLE_USER'),
                                 ('ROLE_ADMIN'),
                                 ('ROLE_INSTRUCTOR'),
                                 ('ROLE_STUDENT');


