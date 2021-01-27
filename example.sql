create database shirotest;
use shirotest;

INSERT INTO permission (`id`, `name`, `description`)
VALUES ('1', 'user:*', 'manage user');
INSERT INTO permission (`id`, `name`, `description`)
VALUES ('2', 'user:query', 'query user');
INSERT INTO permission (`id`, `name`, `description`)
VALUES ('3', 'user:insert', 'add user');
INSERT INTO permission (`id`, `name`, `description`)
VALUES ('4', 'user:update', 'update user');
INSERT INTO permission (`id`, `name`, `description`)
VALUES ('5', 'user:delete', 'delete user');

INSERT INTO role (`id`, `name`, `description`) VALUES ('1', 'admin', 'admin');
INSERT INTO role (`id`, `name`, `description`) VALUES ('2', 'users', 'user');


INSERT INTO role_permission (`id`, `role_id`, `permission_id`) VALUES ('1', '1', '1');
INSERT INTO role_permission (`id`, `role_id`, `permission_id`) VALUES ('2', '2', '2');

INSERT INTO user (`id`, `username`, `password`, `role_id`) VALUES ('1', 'admin', 'admin', '1');
INSERT INTO user (`id`, `username`, `password`, `role_id`) VALUES ('2', 'user1', '123456', '2');