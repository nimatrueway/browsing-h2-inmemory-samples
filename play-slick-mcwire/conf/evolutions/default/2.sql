# --- !Ups

INSERT INTO "Users" VALUES (1, 'nima', '#mypassword#');
INSERT INTO "Users" VALUES (2, 'amir', '#anotherpassword#');

INSERT INTO "LoginLogs" VALUES (1, 1, '2017-01-01 00:00:00');
INSERT INTO "LoginLogs" VALUES (2, 1, '2017-01-02 00:00:00');
INSERT INTO "LoginLogs" VALUES (3, 1, '2017-01-03 00:00:00');
INSERT INTO "LoginLogs" VALUES (4, 1, '2017-01-04 00:00:00');
INSERT INTO "LoginLogs" VALUES (5, 1, '2017-01-05 00:00:00');

# --- !Downs

DELETE FROM "Users" WHERE "username" in ('nima', 'amir');

DELETE FROM "LoginLogs" WHERE "user_id" = 1;