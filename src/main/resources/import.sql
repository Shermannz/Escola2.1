DROP SEQUENCE IF EXISTS user_sequence;
CREATE SEQUENCE user_sequence START WITH 1 INCREMENT BY 1;

INSERT INTO tb_classe (number) VALUES ('111');
INSERT INTO tb_classe (number) VALUES ('122');
INSERT INTO tb_classe (number) VALUES ('133');

INSERT INTO tb_professor (id, name, email, password, subject) VALUES (NEXTVAL('user_sequence'), 'Alex', 'alex@gmail.com', '$2a$04$6X1yNwhnglLknaTYdJxnwOVmQRPt/b5CkOPhoLfQANXixMFhHVn5e', 0);
INSERT INTO tb_employee (id, name, email, password) VALUES (NEXTVAL('user_sequence'), 'Fulano', 'fulano@gmail.com', '$2a$04$6X1yNwhnglLknaTYdJxnwOVmQRPt/b5CkOPhoLfQANXixMFhHVn5e');
INSERT INTO tb_aluno (name,age,moment,classe_id) VALUES ('Patricia',16,TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z',1);
INSERT INTO tb_aluno (name,age,moment,classe_id) VALUES ('Julio',16,TIMESTAMP WITH TIME ZONE '1969-08-29T15:30:07.12345Z',1);


INSERT INTO tb_aula (day, num, professor_id, classe_id, turn) VALUES ('segunda', 2, 1, 1, 0);

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);