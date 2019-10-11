	create view DetalleOrden as 
    select o.orderNumber, o.productCode, p.productName, p.productDescription, o.quantityOrdered, o.priceEach,(o.priceEach*o.quantityOrdered) as finalprice
    from orderdetails as o
    join products as p
    using (productCode);

	create view totalPorOrden as 
    select o.orderNumber, sum(o.priceEach*o.quantityOrdered) as totalprice
    from orderdetails as o
    group by o.orderNumber;
    
    create view UpAverage as
    select p.productCode, p.productName
    from products as p
    where p.buyPrice > (
		select avg(buyPrice)
        from products
    );
    
    create view LowThanAverage as
    select p.productCode, p.productName
    from products as p
    where p.buyPrice < (
		select avg(buyPrice)
        from products
    );
    
    create view OfficeEmployee as
    select o.officecode, o.city, e.employeenumber, e.lastname, e.firstname
    from offices as o
    join employees as e
    using (officecode)
    order by o.officecode, e.employeenumber;
    
    create view NonPayments as
    select c.*
    from customers as c
    left join payments as p
    using (customerNumber)
    where p.customerNumber is null;
    
    create view AllOrders as
    select o.orderNumber, c.customerNumber 
    from orders as o
    join customers as c
    using (customerNumber);
    
    create view CustomerOrderProduct as 
    select c.customerNumber, c.customerName, o.orderNumber, o.orderDate, ord.productCode, ord.quantityOrdered, ord.priceEach, p.productName
    from customers as c
    join orders as o
    using (customerNumber)
    join orderdetails as ord
    using (orderNumber)
    join products as p
    using (productCode)
    group by c.customerNumber, o.orderNumber;
    
    create view quanProd as 
    select p.productLine, count(p.productCode)
    from products as p
    group by p.productCode;
    
    create view OfficeEmployeeCustom as
    select 
    from offices as o
    join employees as e
    using (officeCode)
    join customers as c
    on c.salesRep
    group by;
    