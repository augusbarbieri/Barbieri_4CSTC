
-- 1) Crear una funcion que devuelva la cantidad de ordenes con x estado en el rango de
-- dos fechas (orderDate). La función recibe por parámetro las fechas desde/hasta y el estado.

DELIMITER &&
    
    CREATE FUNCTION	CantidadPorEstado(desde DATETIME, hasta DATETIME, estado VARCHAR(15))
		RETURNS INT
		DETERMINISTIC 
    
    BEGIN
    
		DECLARE cantidad INT DEFAULT 0;
        
			SELECT COUNT(*) INTO cantidad
            FROM orders
            WHERE status = estado AND
            (orderDate BETWEEN desde AND hasta);
        
        RETURN (cantidad);
    
    END &&
    
DELIMITER;

-- 2) Cree una function que recibe por parametro dos fechas de envio (shippedDate) desde/hasta y
-- devuelve la cantidad de ordenes entregadas

DELIMITER&&

	CREATE FUNCTION OrdenesPorFecha(desde DATETIME, hasta DATETIME)
		RETURNS INT
        DETERMINISTIC
    
    BEGIN
    
		DECLARE cantidad INT;
        
        SELECT COUNT(*) INTO cantidad
        FROM orders
        WHERE shippedDate BETWEEN desde AND hasta;
    
		RETURN (cantidad);
    
    END&&

DELIMITER;

-- 3) Escriba una function que reciba un nro de cliente y devuelva la ciudad a la que corresponde el
-- empleado que lo atiende.

DELIMITER &&

	CREATE FUNCTION CiudadDelEmpleado(numero INT)
		RETURNS VARCHAR(50)
        DETERMINISTIC
	
    BEGIN
    
		DECLARE ciudad VARCHAR(50);
        
        SELECT o.city INTO ciudad
        FROM offices as o
        JOIN employees as e
        USING (officeCode)
        JOIN customers as c
        ON e.employeeNumber = c.salesRepEmployeeNumber
        WHERE c.customerNumber;
    
		RETURN (ciudad);
    
    END&&

DELIMITER;

-- 4) Crear una function una productline y devuelva la cantidad de productos existentes en esa línea
-- de producto.

DELIMITER &&

	CREATE FUNCTION CantidadPorLinea(pdLine VARCHAR(50))
		RETURNS INT
        DETERMINISTIC
	
    BEGIN
    
		DECLARE cantidad INT DEFAULT 0;
        
        SELECT COUNT(*) INTO cantidad
        FROM productlines as pls
        JOIN products as pts
        USING (productLine)
        WHERE pls.productLine = pdLine;
    
		RETURN (cantidad);
    
    END&&

DELIMITER;

-- 5) Crear una SF que reciba un officeCode y devuelva la cantidad de clientes que tiene la oficina.

DELIMITER &&

	CREATE FUNCTION ClientesDeOficina(oficina VARCHAR(10))
		RETURNS INT
        DETERMINISTIC
	
    BEGIN
    
		DECLARE cantidad INT DEFAULT 0;
	
			SELECT COUNT (c.customerNumber) INTO cantidad
            FROM employees as e
			JOIN customers as c
            ON e.employeeNumber = c.salesRepEmployeeNumber
            WHERE e.officeCode = oficina;
    
		RETURN (cantidad);
    
    END&&

DELIMITER;

-- 6) Crear una SF que reciba un officeCode y devuelva la cantidad de ordenes que se hicieron en esa
-- oficina.

DELIMITER &&

	CREATE FUNCTION CantidadOrdenesOficina(oficina VARCHAR(10))
		RETURNS INT
        DETERMINISTIC
	
    BEGIN
    
		DECLARE cantidad INT DEFAULT 0;
	
			SELECT COUNT (o.orderNumber) INTO cantidad
            FROM employees as e
			JOIN customers as c
            ON e.employeeNumber = c.salesRepEmployeeNumber
            JOIN orders as o
            ON o.customerNumber = c.customerNumber
            WHERE e.officeCode = oficina;
    
		RETURN (cantidad);
    
    END&&

DELIMITER;

-- 7) Crear una SF que reciba un NRO DE ORDEN y un NRO DE PRODUCTO y devuelva el beneficio obtenido
-- con ese producto. El beneficio debe calcularse como (priceEach – buyPrice).

DELIMITER &&

	CREATE FUNCTION CalcularBeneficio(nro_orden INT(11), nro_producto VARCHAR(15))
		RETURNS INT
        DETERMINISTIC
	
    BEGIN
    
		DECLARE beneficio INT DEFAULT 0;
	
			SELECT COUNT (od.priceEach - p.buyPrice) INTO beneficio
            FROM orderdetails as od
            JOIN products as p
            ON od.productCode = p.productCode
            WHERE od.productCode = nro_producto
            AND od.orderNumber = nro_orden;
    
		RETURN (beneficio);
    
    END&&

DELIMITER;

-- 8) Crear una SF que reciba un orderNumber y si el mismo esta en estado cancelado devuelva -1
-- sino 0.

DELIMITER&&

CREATE FUNCTION ValorPorEstado(num_orden INT(11))
		RETURNS INT
        DETERMINISTIC
	
    BEGIN
    
		DECLARE valor INT DEFAULT 0;
        DECLARE devolver INT DEFAULT 0;
	
			SELECT * INTO valor
            FROM orders
            WHERE orderNumber = num_orden AND
            status = 'Cancelled';
            
            IF valor > 0 THEN
				SET devolver = -1;
            ELSE
				SET	devolver = 0;
            END IF;
    
		RETURN (devolver);
    
    END&&

DELIMITER;

-- 9) Crear una SF que devuelva la fecha de la primer orden hecha por ese cliente. Recibe el nro de
-- cliente.

DELIMITER&&

CREATE FUNCTION FechaPrimeraOrden(num_cliente INT(11))
		RETURNS DATE
        DETERMINISTIC
	
    BEGIN
    
		DECLARE primera DATE DEFAULT 0;
	
			SELECT MIN(orderDate) INTO primera
            FROM orders
            WHERE customerNumber = num_cliente;
    
		RETURN (primera);
    
    END&&

DELIMITER;

-- 10) La columna MSRP en la tabla de productos significa manufacturer&#39;s suggested retail price o sea
-- que hace referencia al precio de venta sugerido por el fabricante. Realice una SF que reciba un
-- código de producto y devuelva el porcentaje de veces que el producto se vendio por debajo de
-- dicho precio.

DELIMITER&&

CREATE FUNCTION PorcentajePrecioBajo(cod_producto VARCHAR(15))
	RETURNS INT
        DETERMINISTIC
	
    BEGIN
		DECLARE porcentaje INT DEFAULT 0;
	
		SELECT (SUM(CASE WHEN o.priceEach < p.MSRP THEN 1 ELSE 0 END) / COUNT(o.*)) * 100 INTO porcentaje
		FROM products as p
		JOIN orderdetails as o
		ON p.productCode = o.productCode
		WHERE p.productCode = cod_producto;
    
		RETURN (porcentaje);
    
    END&&

DELIMITER;

-- 11) Crear una SF que reciba una orderNumber y devuelva la cantidad de días transcurridos entre la
-- OrderDate y la shippedDate.

DELIMITER&&

CREATE FUNCTION DiasTranscurridos(num_orden INT(11))
	RETURNS INT
        DETERMINISTIC
	
    BEGIN
		DECLARE dias INT DEFAULT 0;
	
		SELECT TIMESTAMPDIFF(day,orderDate,shippedDate) INTO dias
		FROM orders
		WHERE orderNumber = num_orden;
    
		RETURN (dias);
    
    END&&

DELIMITER;

-- 12) Cree una SF que reciba un código de producto y devuelva la ultima fecha en la que fue pedido el
-- mismo.

DELIMITER&&

CREATE FUNCTION FechaUltimoPedido(num_product VARCHAR(15))
	RETURNS DATETIME
        DETERMINISTIC
	
    BEGIN
		DECLARE fecha DATETIME DEFAULT 0;
	
		SELECT MAX(o.orderDate) INTO fecha
		FROM orderdetails as od
		JOIN orders as o
		ON od.orderNumber = o.orderNumber
		WHERE od.productCode = num_product;
    
		RETURN (fecha);
    
    END&&

DELIMITER;

-- 13) Cree una SF que reciba dos fechas DESDE / HASTA y un código de producto. Si el producto fue
-- ordenado en alguna orden entre esas fechas que devuelva el mayor precio. Si el producto no
-- fue ordenado en esas fechas que devuelva 0.

DELIMITER&&

CREATE FUNCTION PrecioMayorEntreProductos(num_product VARCHAR(15), desde DATE, hasta DATE)
	RETURNS INT
        DETERMINISTIC
	
    BEGIN
		DECLARE precio INT DEFAULT 0;
	
		SELECT MAX(od.priceEach) INTO precio
		FROM orderdetails as od
		JOIN orders as o
		ON od.orderNumber = o.orderNumber
		WHERE od.productCode = num_product
		AND od.orderDate BETWEEN desde AND hasta;
    
		RETURN (precio);
    
    END&&

DELIMITER;

-- 14) Cree una SF que reciba el numero de empleado y devuelva la cantidad de clientes que atiende.

DELIMITER&&

CREATE FUNCTION ClientesQueAtiende(num_empleado INT(11))
	RETURNS INT
        DETERMINISTIC
	
    BEGIN
		DECLARE cantidad INT DEFAULT 0;
	
		SELECT COUNT(customerNumber) INTO cantidad
		FROM customers
		WHERE salesRepEmployeeNumber = num_empleado;

		RETURN (cantidad);
    
    END&&

DELIMITER;

-- 15) Cree una SF que reciba un nro de empleado y devuelva el apellido del empleado al que reporta.

DELIMITER&&

CREATE FUNCTION ApellidoJefe(num_empleado INT(11))
	RETURNS VARCHAR
        DETERMINISTIC
	
    BEGIN
		DECLARE surname VARCHAR(50);
	
		SELECT lastName INTO surname
		FROM employees
		WHERE employeeNumber = (
			SELECT reportsTo
			FROM employees
			WHERE employeeNumber = num_empleado;
		); 

		RETURN (surname);
    
    END&&

DELIMITER;
