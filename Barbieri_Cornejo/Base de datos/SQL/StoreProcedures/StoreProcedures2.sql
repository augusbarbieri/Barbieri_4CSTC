-- 1) Crear un SP que utilice un cursor para recorrer la tabla de offices y que genere una lista con las
-- ciudades en las cuales hay oficinas. La lista tendrá que devolverse en un parámetro de salida
-- VARCHAR(4000) que contenga todas las ciudades separadas por coma. getCiudadesOffices()

-- LISTO
/*
	DELIMITER &&
    
		CREATE PROCEDURE getCiudadesOffices(OUT listaCiudades VARCHAR(4000))
		BEGIN
            
			-- declaro variable del handler
			DECLARE fin INT DEFAULT 0;

			DECLARE ciudad varchar(100) DEFAULT "";
			
			-- declaro cursor
			DEClARE ciudades CURSOR FOR 
			SELECT DISTINCT city
			FROM offices;

			 -- declaro NOT FOUND handler
			DECLARE CONTINUE HANDLER 
			FOR NOT FOUND SET fin = 1;

			OPEN ciudades;
			set listaCiudades = " ";
				obtenerCiudades: LOOP
 
 					FETCH ciudades INTO ciudad;
 
 					IF fin = 1 THEN 
						LEAVE obtenerCiudades;
					END IF;
 
 					-- creo la lista
					SET listaCiudades = CONCAT(ciudad,",",listaCiudades);
 
 				END LOOP obtenerCiudades;
 
 			CLOSE ciudades;

        	END &&
        
	DELIMITER;
    
*/
	

-- 2) Agregue una tabla llamada CancelledOrders con el mismo diseño que la tabla de Orders. Crear un SP
-- que recorra la tabla de orders y que cuente la cantidad de ordenes en estado cancelled. El
-- procedimiento debe insertar una fila en la tabla CancelledOrders por cada orden cancelada y tiene que
-- devolver la cantidad de ordenes canceladas. insertCancelledOrders()

    DROP TABLE IF EXISTS `CancelledOrders`;

	CREATE TABLE `CancelledOrders` (
	  `numero` int(11) NOT NULL,
	  `fecha` date NOT NULL,
	  `fechaRequerida` date NOT NULL,
	  `fechaShipp` date DEFAULT NULL,
	  `estado` varchar(15) NOT NULL,
	  `comentario` text,
	  `numeroCliente` int(11) NOT NULL,
	  PRIMARY KEY (`numero`),
	  KEY `numeroCliente` (`numeroCliente`),
	  CONSTRAINT `CancelledOrderds_ibfk_1` FOREIGN KEY (`numeroCliente`) REFERENCES `customers` (`customerNumber`)
	) ENGINE=InnoDB DEFAULT CHARSET=latin1;	
/*
    DELIMITER &&
    
		CREATE PROCEDURE insertCancelledOrders()
		BEGIN
            
			-- declaro variable del handler
			DECLARE fin INT DEFAULT 0;			

			DECLARE numero int(11);
			DECLARE fecha date;
			DECLARE fechaRequerida date;
			DECLARE fechaShipp date;
			DECLARE estado varchar(15);
			DECLARE comentario text;
			DECLARE numeroCliente int(11);

			-- declaro cursor
			DEClARE ordenes_canceladas CURSOR FOR 
			SELECT COUNT orderNumber FROM orders
            WHERE status = "cancelled";

			 -- declaro NOT FOUND handler
			DECLARE CONTINUE HANDLER 
			FOR NOT FOUND SET fin = 1;

			OPEN ordenes_canceladas;
 
				cancelados: LOOP
 
 					FETCH ordenes_canceladas INTO numero,fecha,fechaRequerida,fechaShipp,estado,comentario,numeroCliente;
 
 					IF fin = 1 THEN 
						LEAVE cancelados;
					END IF;
                    
 					-- realizo el insert
                    insert into CancelledOrders (numero,fecha,fechaRequerida,fechaShipp,estado,comentario,numeroCliente) values (numero,fecha,fechaRequerida,fechaShipp,estado,comentario,numeroCliente); 
                    
 				END LOOP cancelados;
 
 			CLOSE ordenes_canceladas;
        
        	END &&
        
	DELIMITER;
*/

-- 3) Realizar un SP que reciba el customerNumber y para todas las ordenes de ese customerNumber, si el
-- campo comments esta vacio que lo complete con el siguiente comentario: El total de la orden es   Y
-- el total de la orden tendrá que calcularlo el procedimiento sumando todos los productos incluidos en la
-- orden de la tabla OrderDetails. alterCommentOrder()

	DELIMITER &&
    
		CREATE PROCEDURE alterCommentOrder(IN num int)
		BEGIN
            
			-- declaro variable del handler
			DECLARE fin INT DEFAULT 0;
            DECLARE mensaje VARCHAR(100) DEFAULT  '';

			-- declaro cursor
			DEClARE cursorOrder CURSOR FOR 
			SELECT orderNumber,comments
            FROM orders
            WHERE customerNumber = num
            AND comments IS NULL;
			
			 -- declaro NOT FOUND handler
			DECLARE CONTINUE HANDLER 
			FOR NOT FOUND SET fin = 1;

			OPEN orders_cursor;
 
				ordenes: LOOP
 
 					FETCH orders_cursor INTO numOrder;
 
 					IF fin = 1 THEN 
						LEAVE orders_cursor;
					END IF;
 
 					-- creo la lista
					SET email_list = CONCAT(v_email,";",email_list);
 
 				END LOOP ordenes;
 
 			CLOSE orders_cursor;
        
		END &&
        
	DELIMITER;
    
    
    
    
    
    
    
    
    
    
    
    












