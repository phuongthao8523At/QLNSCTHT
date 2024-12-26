DELIMITER //
DROP TRIGGER IF EXISTS employee_aru//
CREATE TRIGGER employee_aru
    AFTER UPDATE
    ON employee
    FOR EACH ROW
BEGIN
    IF OLD.isDeleted = 0 AND NEW.isDeleted = 1 THEN
        UPDATE contract
        SET isDeleted = 1
        WHERE employeeId = OLD.id;
    END IF;
end //
