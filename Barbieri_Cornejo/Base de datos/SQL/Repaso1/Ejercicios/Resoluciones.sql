-- 1) Funciona

select  pedidos.id_pedido, pedidos.descripcion, pedidos.fecha_compra, pedidos.fecha_entrega, detallepedido.codigo_producto
	from pedidos 
		join detallepedido 
			on pedidos.id_pedido = detallepedido.id_pedido
				where pedidos.id_cliente = 1;
                
                
-- 2) Funciona

select clientes.id_cliente, clientes.nombre, clientes.apellido, pedidos.id_pedido, pedidos.descripcion
	from clientes 
		join pedidos
			on clientes.id_cliente = pedidos.id_cliente;
            
            
-- 3) Funciona

select clientes.id_cliente, clientes.nombre, clientes.apellido, pedidos.id_pedido, pedidos.descripcion, detallepedido.codigo_producto, detallepedido.cantidad
	from clientes
		join pedidos
			on clientes.id_cliente = pedidos.id_cliente
				join detallepedido 
					on pedidos.id_pedido = detallepedido.id_pedido;
                    
                    
-- 4) Funciona

select clientes.id_cliente, clientes.nombre, clientes.apellido
	from clientes
		left join pedidos
			on clientes.id_cliente = pedidos.id_cliente
				where pedidos.id_cliente is null;

-- 5) Funciona

select id_cliente, nombre, apellido
	from clientes
		where id_cliente not in(select id_cliente
					from pedidos);		
				
                
-- 6) Funciona

select pedidos.descuento, detallepedido.id_pedido, detallepedido.codigo_producto, detallepedido.cantidad
	from pedidos
		join detallepedido
			on pedidos.id_pedido = detallepedido.id_pedido
				where pedidos.descuento = 0.05;

 
-- 7) Funciona

select id_pedido, descripcion, fecha_compra, fecha_entrega, descuento
	from pedidos
		where (select MAX(descuento)
					from pedidos)= descuento;


-- 8) Funciona

select id_pedido, descripcion, fecha_compra, fecha_entrega, descuento
	from pedidos
		where (select MIN(descuento)
					from pedidos)= descuento;


-- 9) Funciona

select clientes.id_cliente, clientes.nombre, clientes.apellido
	from clientes
		join pedidos
			on clientes.id_cliente = pedidos.id_cliente;


-- 10) No Funciona


-- 11) Funciona

select id_pedido  
	from detallepedido
		where cantidad > 3;
	

-- 12) Funciona

select TIMESTAMPDIFF(day,fecha_compra,fecha_entrega), id_pedido
	from pedidos;
    
-- 13) Funciona

select id_cliente, nombre, apellido, fecha_alta, TIMESTAMPDIFF(year,fecha_alta,NOW())
	from clientes
		where TIMESTAMPDIFF(year,fecha_alta,NOW())>10;
		

-- 14) Funciona

select pedidos.id_pedido, productos.precio
	from pedidos
		join detallepedido
			on pedidos.id_pedido=detallepedido.id_pedido
				join productos
					on detallepedido.codigo_producto=productos.codigo;


-- 15) Listar los pedidos cuyo monto supere los $ 3500

select pedidos.id_pedido, productos.precio
	from pedidos
		join detallepedido
			on pedidos.id_pedido=detallepedido.id_pedido
				join productos
					on detallepedido.codigo_producto=productos.codigo
						where precio>3500;










































