INSERT INTO tb_user (name, email, password)
VALUES ('Student User', 'student@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password)
VALUES ('Instructor User', 'instructor@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password)
VALUES ('Admin User', 'admin@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority)
VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority)
VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority)
VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id)
VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id)
VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id)
VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id)
VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id)
VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id)
VALUES (3, 3);

INSERT INTO tb_course (name, img_uri, img_gray_uri)
VALUES ('Bootcamp Spring Boot', 'https://imgur.com/bdqES46', 'https://imgur.com/rDH6HWv');
INSERT INTO tb_course (name, img_uri, img_gray_uri)
VALUES ('Bootcamp React', 'https://imgur.com/Oc2Qbik', 'https://imgur.com/1qdor18');

INSERT INTO tb_offer (edition, start_moment, end_moment, course_id)
VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2022-01-01T00:00:00Z', TIMESTAMP WITH TIME ZONE '2022-12-31T23:59:59Z', 1);
INSERT INTO tb_offer (edition, start_moment, end_moment, course_id)
VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2022-01-01T00:00:00Z', TIMESTAMP WITH TIME ZONE '2022-12-31T23:59:59Z', 2);

INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id)
VALUES ('Trilha Spring Boot', 'Trilha principal', 1, 'https://imgur.com/bdqES46', 1, 1);
INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id)
VALUES ('Fórum', 'Tire suas dúvidas', 2, 'https://imgur.com/bdqES46', 2, 1);
INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id)
VALUES ('Lives', 'Aulas ao vivo', 3, 'https://imgur.com/bdqES46', 0, 1);

INSERT INTO tb_section (title, description, position, img_uri, resource_id, prerequisite_id)
VALUES ('Capítulo 01', 'Introdução ao Spring Boot', 1, 'https://imgur.com/bdqES46', 1, null);
INSERT INTO tb_section (title, description, position, img_uri, resource_id, prerequisite_id)
VALUES ('Capítulo 02', 'CRUD', 2, 'https://imgur.com/bdqES46', 1, 1);
INSERT INTO tb_section (title, description, position, img_uri, resource_id, prerequisite_id)
VALUES ('Capítulo 03', 'Testes automatizados', 3, 'https://imgur.com/bdqES46', 1, 2);