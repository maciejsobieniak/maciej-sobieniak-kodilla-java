INSERT INTO POSTS (USER_ID, BODY) VALUES
(3, "Hello everyone! I'm Stephanie, excited to join this forum.");

COMMIT;

UPDATE POSTS
SET BODY = "To Delete"
WHERE ID = 7;

COMMIT;
SELECT * FROM POSTS;

DELETE
FROM POSTS
WHERE ID = 7;

COMMIT;