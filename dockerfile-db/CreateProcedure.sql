DELIMITER //

CREATE procedure zdarova()

BEGIN

   DECLARE i INT;
   DECLARE j INT;

   START TRANSACTION;
   SET i = 0;
    SET j = 1000000;

   label1: WHILE i <= j DO
     INSERT INTO shots(x, y, r, currTime, execTime, result) VALUES (0, 0, 1, CURDATE(), 10, 'MISS');
     SET i = i + 1;
END WHILE label1;

   COMMIT;

END; //

DELIMITER ;