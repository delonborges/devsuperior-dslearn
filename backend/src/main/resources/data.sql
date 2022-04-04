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

INSERT INTO tb_enrollment (user_id, offer_id, enroll_moment, refund_moment, available, only_update)
VALUES (1, 1, TIMESTAMP WITH TIME ZONE '2022-01-01T08:00:00Z', null, true, false);
INSERT INTO tb_enrollment (user_id, offer_id, enroll_moment, refund_moment, available, only_update)
VALUES (2, 1, TIMESTAMP WITH TIME ZONE '2022-01-01T08:00:00Z', null, true, false);

INSERT INTO tb_lesson (title, position, section_id)
VALUES ('Aula 01', 1, 1);
INSERT INTO tb_content (id, text_content, video_uri)
VALUES (1, 'Material de apoio', 'https://youtube.com');

INSERT INTO tb_lesson (title, position, section_id)
VALUES ('Aula 02', 2, 1);
INSERT INTO tb_content (id, text_content, video_uri)
VALUES (2, 'Material de apoio', 'https://youtube.com');

INSERT INTO tb_lesson (title, position, section_id)
VALUES ('Aula 03', 3, 1);
INSERT INTO tb_content (id, text_content, video_uri)
VALUES (3, 'Material de apoio', 'https://youtube.com');

INSERT INTO tb_lesson (title, position, section_id)
VALUES ('Tarefa do capítulo 01', 4, 1);
INSERT INTO tb_task (id, description, question_count, approval_count, weight, due_date)
VALUES (4, 'Desafio do capítulo 01', 5, 4, 1.0, TIMESTAMP WITH TIME ZONE '2022-12-31T23:59:59Z');

INSERT INTO tb_lessons_done (lesson_id, user_id, offer_id)
VALUES (1, 1, 1);
INSERT INTO tb_lessons_done (lesson_id, user_id, offer_id)
VALUES (2, 1, 1);

INSERT INTO tb_notification (text, moment, read, route, user_id)
VALUES ('Primeiro feedback de tarefa: favor revisar', TIMESTAMP WITH TIME ZONE '2020-12-10T13:00:00Z', true,
        '/offers/1/resource/1/sections/1', 1);
INSERT INTO tb_notification (text, moment, read, route, user_id)
VALUES ('Segundo feedback: favor revisar', TIMESTAMP WITH TIME ZONE '2020-12-12T13:00:00Z', true,
        '/offers/1/resource/1/sections/1', 1);
INSERT INTO tb_notification (text, moment, read, route, user_id)
VALUES ('Terceiro feedback: favor revisar', TIMESTAMP WITH TIME ZONE '2020-12-14T13:00:00Z', false,
        '/offers/1/resource/1/sections/1', 1);

INSERT INTO tb_deliver (uri, moment, status, feedback, correct_count, lesson_id, user_id, offer_id)
VALUES ('https://github.com/devsuperior/bds-dslearn', TIMESTAMP WITH TIME ZONE '2020-12-10T10:00:00Z', 0, null, null, 4,
        1, 1);

INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id)
VALUES ('Título do tópico 1', 'Corpo do tópico 1', TIMESTAMP WITH TIME ZONE '2020-12-12T13:00:00Z', 1, 1, 1);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id)
VALUES ('Título do tópico 2', 'Corpo do tópico 2', TIMESTAMP WITH TIME ZONE '2020-12-13T13:00:00Z', 2, 1, 1);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id)
VALUES ('Título do tópico 3', 'Corpo do tópico 3', TIMESTAMP WITH TIME ZONE '2020-12-14T13:00:00Z', 2, 1, 1);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id)
VALUES ('Título do tópico 4', 'Corpo do tópico 4', TIMESTAMP WITH TIME ZONE '2020-12-15T13:00:00Z', 1, 1, 2);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id)
VALUES ('Título do tópico 5', 'Corpo do tópico 5', TIMESTAMP WITH TIME ZONE '2020-12-16T13:00:00Z', 1, 1, 2);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id)
VALUES ('Título do tópico 6', 'Corpo do tópico 6', TIMESTAMP WITH TIME ZONE '2020-12-17T13:00:00Z', 2, 1, 3);

INSERT INTO tb_topic_likes (topic_id, user_id)
VALUES (1, 2);
INSERT INTO tb_topic_likes (topic_id, user_id)
VALUES (2, 1);

INSERT INTO tb_reply (body, moment, topic_id, author_id)
VALUES ('Tente reiniciar o computador', TIMESTAMP WITH TIME ZONE '2020-12-15T13:00:00Z', 1, 2);
INSERT INTO tb_reply (body, moment, topic_id, author_id)
VALUES ('Deu certo, valeu!', TIMESTAMP WITH TIME ZONE '2020-12-20T13:00:00Z', 1, 1);

INSERT INTO tb_reply_likes (reply_id, user_id)
VALUES (1, 1);