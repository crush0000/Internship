-- Создание ролей в Keycloak
-- Роли: ROLE_ADMIN, ROLE_TEACHER, ROLE_USER

-- Добавление роли ROLE_ADMIN
INSERT INTO keycloak_role (name, realm_id)
VALUES ('ROLE_ADMIN', (SELECT id FROM keycloak_realm WHERE realm = 'master'));

-- Добавление роли ROLE_TEACHER
INSERT INTO keycloak_role (name, realm_id)
VALUES ('ROLE_TEACHER', (SELECT id FROM keycloak_realm WHERE realm = 'master'));

-- Добавление роли ROLE_USER
INSERT INTO keycloak_role (name, realm_id)
VALUES ('ROLE_USER', (SELECT id FROM keycloak_realm WHERE realm = 'master'));

-- Обновление, если нужно, индексы и связи
-- Создание пользователей и назначение ролей

-- Добавление пользователя admin_user
INSERT INTO keycloak_user (username, email, enabled, realm_id)
VALUES ('admin_user', 'admin_user@domain.com', TRUE, (SELECT id FROM keycloak_realm WHERE realm = 'master'));

-- Добавление пароля для admin_user
INSERT INTO keycloak_credential (user_id, type, value, temporary)
VALUES ((SELECT id FROM keycloak_user WHERE username = 'admin_user'), 'password', 'admin123', FALSE);

-- Назначение роли ROLE_ADMIN пользователю admin_user
INSERT INTO keycloak_user_role_mapping (user_id, role_id)
VALUES ((SELECT id FROM keycloak_user WHERE username = 'admin_user'),
        (SELECT id FROM keycloak_role WHERE name = 'ROLE_ADMIN' AND realm_id = (SELECT id FROM keycloak_realm WHERE realm = 'master')));

-- Добавление пользователя teacher_user
INSERT INTO keycloak_user (username, email, enabled, realm_id)
VALUES ('teacher_user', 'teacher_user@domain.com', TRUE, (SELECT id FROM keycloak_realm WHERE realm = 'master'));

-- Добавление пароля для teacher_user
INSERT INTO keycloak_credential (user_id, type, value, temporary)
VALUES ((SELECT id FROM keycloak_user WHERE username = 'teacher_user'), 'password', 'teacher123', FALSE);

-- Назначение роли ROLE_TEACHER пользователю teacher_user
INSERT INTO keycloak_user_role_mapping (user_id, role_id)
VALUES ((SELECT id FROM keycloak_user WHERE username = 'teacher_user'),
        (SELECT id FROM keycloak_role WHERE name = 'ROLE_TEACHER' AND realm_id = (SELECT id FROM keycloak_realm WHERE realm = 'master')));

-- Добавление пользователя basic_user
INSERT INTO keycloak_user (username, email, enabled, realm_id)
VALUES ('basic_user', 'basic_user@domain.com', TRUE, (SELECT id FROM keycloak_realm WHERE realm = 'master'));

-- Добавление пароля для basic_user
INSERT INTO keycloak_credential (user_id, type, value, temporary)
VALUES ((SELECT id FROM keycloak_user WHERE username = 'basic_user'), 'password', 'user123', FALSE);

-- Назначение роли ROLE_USER пользователю basic_user
INSERT INTO keycloak_user_role_mapping (user_id, role_id)
VALUES ((SELECT id FROM keycloak_user WHERE username = 'basic_user'),
        (SELECT id FROM keycloak_role WHERE name = 'ROLE_USER' AND realm_id = (SELECT id FROM keycloak_realm WHERE realm = 'master')));
