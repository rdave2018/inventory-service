START TRANSACTION;

DELETE FROM inventory;

insert into inventory(id, product_code, available_quantity) VALUES
(1, 'P001', 25),
(2, 'P002', 32),
(3, 'P003', 50);

-- 5. commit changes    
COMMIT;