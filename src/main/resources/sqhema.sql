CREATE TABLE IF NOT EXISTS `autoschoolgroups` (
                                                  `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                                  `name` VARCHAR(255) NOT NULL,
                                                  `start_date` DATE,
                                                  `end_date` DATE
);

CREATE TABLE IF NOT EXISTS `students` (
                                          `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                          `first_name` VARCHAR(255),
                                          `last_name` VARCHAR(255),
                                          `birth_date` DATE,
                                          `contact_info` VARCHAR(255),
                                          `start_date` DATE,
                                          `end_date` DATE,
                                          `group_id` BIGINT,
                                          FOREIGN KEY (group_id) REFERENCES `autoschoolgroups` (`id`)
);

CREATE TABLE IF NOT EXISTS `instructors` (
                                             `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                             `first_name` VARCHAR(255) NOT NULL,
                                             `last_name` VARCHAR(255),
                                             `specialization` VARCHAR(255),
                                             `contact_info` VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS `lessons` (
                                         `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         `type` VARCHAR(255),
                                         `date_time` DATETIME,
                                         `location` VARCHAR(255),
                                         `instructor_id` BIGINT,
                                         `group_id` BIGINT,
                                         FOREIGN KEY (instructor_id) REFERENCES `instructors` (`id`),
                                         FOREIGN KEY (group_id) REFERENCES `autoschoolgroups` (`id`)
);

CREATE TABLE IF NOT EXISTS `results` (
                                         `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         `type` VARCHAR(255),
                                         `date` DATE,
                                         `grade` VARCHAR(255),
                                         `student_id` BIGINT,
                                         FOREIGN KEY (student_id) REFERENCES `students` (`id`)
);

CREATE TABLE IF NOT EXISTS `applications` (
                                              `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                              `student_name` VARCHAR(255) NOT NULL,
                                              `contact_info` VARCHAR(255),
                                              `application_date` DATE
);

CREATE TABLE IF NOT EXISTS `roles` (
                                       `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       `name` VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS `users` (
                                       `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       `username` VARCHAR(255) NOT NULL UNIQUE,
                                       `password` VARCHAR(255) NOT NULL,
                                       `enabled` BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS `users_roles` (
                                             `user_id` BIGINT NOT NULL,
                                             `role_id` BIGINT NOT NULL,
                                             FOREIGN KEY (user_id) REFERENCES `users` (`id`),
                                             FOREIGN KEY (role_id) REFERENCES `roles` (`id`),
                                             PRIMARY KEY (user_id, role_id)
);
