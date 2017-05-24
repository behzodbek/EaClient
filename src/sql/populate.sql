 
INSERT INTO Authentication(user,password,enabled) VALUES ('guest','guest', TRUE);
INSERT INTO Authentication(user,password,enabled) VALUES ('admin','admin', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');

INSERT INTO  `USERS` (firstname, lastname,email,is_admin, userid) VALUES ('Curious','George','george@test.com', 0,'admin');
INSERT INTO `USERS` (firstname, lastname,email, is_admin, userid) VALUES ('Allen','Rench','allen@test.com', 0,'guest');
INSERT INTO `USERS` (firstname, lastname,email, is_admin, userid) VALUES ('Jane','Doe','jane@test.com', 0,'guest');
INSERT INTO `USERS` (firstname, lastname,email, is_admin, userid) VALUES ('Jake','Smith','jake@test.com', 0,'guest');

					