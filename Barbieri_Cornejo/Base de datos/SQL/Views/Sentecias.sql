-- 1) Funciona

Create VIEW DetalleOrden AS(
Select p.productCode, p.productName, p.productDescription, o.quantityOrdered, o.priceEach, p.buyPrice
	from products as p
		join orderdetails as o
			using (productCode));

select *
from DetalleOrden;



-- 2) Funciona

Create VIEW totalPorOrden AS(
	Select orderNumber, priceEach * quantityOrdered AS total
		from orderdetails
			group by orderNumber);

select *
from totalPorOrden;


-- 3) Funciona

Create VIEW PreciosGrandes AS(
	select productName, buyPrice
		from products
			where buyPrice > (select AVG(buyPrice)
									from products));

Select *
from PreciosGrandes;


-- 4) Funciona

Create VIEW PreciosChicos AS(
	select productName, buyPrice
		from products
			where buyPrice < (select AVG(buyPrice)
									from products));

Select *
from PreciosChicos;


-- 5) Funciona

Create VIEW OficinaInfo AS(
	Select O.officeCode, O.city, E.employeeNumber, E.firstName, E. lastName    
		from offices AS O
			join employees As E
				Using (officeCode)
					order by O.officeCode, E.employeeNumber);

Select *
from OficinaInfo;


-- 6) Sentencia bien escrita pero no refleja sin pagos

Create VIEW SinPago AS(
	Select C.customerName, C.customerNumber, P.amount
		from customers AS C
			join payments AS P
				Using (customerNumber)
					where P.amount = '0');


Select* 
from SinPago;

-- 7) No funciona

Create VIEW TotalOrdenes AS(
	Select orders.orderNumber, customers.customerNumber, customers.customerName
		from orders 
			join customers 
				Using (custumerNumber));

Select *
from TotalOrdenes;


-- 8) No funciona

Create VIEW ClienteInfo AS(
	select C.cutomerNumber, C.cutomerName, O.orders, O.orderDate, Orderd.productCode, Orderd.quantityOrdered,
	Orderd.priceEach, P.productName
		from Customers AS C
			join orders AS O Using (customerNumber)
            join orderdetails AS Orderd Using (orderNumber)
            join products AS P Using (productCode));


select *
from ClienteInfo;


-- 10) Cree una vista que muestre la cantidad de productos que se cuentan por cada linea de producto 

create VIEW CantidadProducts AS(
	Select 


);























