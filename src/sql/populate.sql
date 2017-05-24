INSERT INTO Usercredentials(usercred_id,user,password,enabled) VALUES (1,'guest','guest', 1);
INSERT INTO Usercredentials(usercred_id,user,password,enabled) VALUES (2,'admin','admin', 1);
INSERT INTO Usercredentials(usercred_id,user,password,enabled) VALUES (3,'jane','jane', 1);
INSERT INTO Usercredentials(usercred_id,user,password,enabled) VALUES (4,'jake','jake', 1);
 
INSERT INTO Authority (id, authority, usercred) VALUES (1, 'ROLE_ADMIN', 2);
INSERT INTO Authority (id, authority, usercred) VALUES (2,'ROLE_USER', 1);
INSERT INTO Authority (id, authority, usercred) VALUES (3, 'ROLE_READ', 3);
INSERT INTO Authority (id, authority, usercred) VALUES (4, 'ROLE_READ', 4);

INSERT INTO User (user_id,firstname, lastname,email, usercred_id) VALUES (1,'Curious','George','george@test.com',2);
INSERT INTO User (user_id,firstname, lastname,email, usercred_id) VALUES (2,'Allen','Rench','allen@test.com',1);
INSERT INTO User (user_id,firstname, lastname,email, usercred_id) VALUES (3,'Jane','Doe','jane@test.com',3);
INSERT INTO User (user_id,firstname, lastname,email, usercred_id) VALUES (4,'Jake','Smith','jake@test.com',4);


					