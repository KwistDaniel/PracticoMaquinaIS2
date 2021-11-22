# PracticoMaquinaIS2

Practico de Maquina de la materia Ingenieria de Software 2 realizado por Kwist Daniel, Gauna Dario y Burger Tobias.
Universidad Nacional de San Luis

## Caso de Estudio

La tienda de materiales para la construcción Daquino Mosaicos desea mantener información sobre los clientes, empleados, proveedores, ventas, repartos y stock de mercancía. 
De los clientes físicos se interesa conocer su DNI, nombre y apellido, su dirección, fecha de nacimiento, teléfono, email y su condición ante IVA y CUIT según sea necesario.
De los clientes que sean empresas se interesa conocer la situación ante IVA, CUIT, nombre, dirección, teléfono y email.
De los empleados se interesa conocer su DNI, nombre y apellido, su dirección, fecha de nacimiento, teléfono, email, su tipo (vendedor o repartidor) y su fecha de incorporación a la empresa.
De las ventas se mantiene registro del cliente, el vendedor, qué mercancías y cantidades, el monto de venta total, el porcentaje descuento si posee y el monto final. En una venta, además, se puede bonificar un producto o un combo de productos, por lo que debería ser posible cambiar el monto final de una venta antes de generarla mediante un descuento de porcentaje o monto fijo. 
También, se interesa conocer la dirección de envío, ya que puede ser distinta a la dirección del cliente.
La mercancía se divide en:
Cerámicos (por caja),
Porcelanatos (por caja),
Sanitarios,
Griferías,
Bachas,
Vanitorys,
Varios (distintos artículos varios y repuestos).
De estas se mantiene su código, nombre, descripción, precio y cantidad, color, y de cerámicos y porcelanatos, la medida (ancho y alto) y los metros cuadrados de la caja.
Además, interesa saber de cada ceramico y porcelanato, su nivel de calidad (primera (mejor), segunda o tercera(peor). Esta calidad significa un precio distinto) y su partida (ya que dos ceramicos o porcelanatos de mismas caracteristicas pero de distinta partida no son iguales luego de ser fabricados), ya que se pueden tener en stock la cantidad que necesita en cliente pero ser de distintas partidas, y por lo tanto no interesarle al cliente ya que son distintos.
De los repartos se interesa conocer los artículos y cantidades, día y hora, el repartidor, y a que dirección se debe enviar.
También se interesa conocer quiénes son los proveedores y también la información sobre los pedidos.
De los proveedores se mantienen los datos del representante: su nombre, teléfono, mail y qué categorías de mercancía provee.
De cada pedido se desea conocer qué mercancías y sus cantidades que se proveen y quien fue el proveedor.

Se requiere además que:
El sistema operativo donde debe ejecutarse es Windows.


## Objetivo

Este sistema se propone la mejora contínua del rendimiento de nuestra empresa, procurando satisfacer mejor las necesidades de nuestros clientes.

## MySQL

Datos de conexion a la DB:

```bash
url = jdbc:mariadb://dvnikst.duckdns.org:3306/is2-daquino-gk
user = user1
password = 951753
```



[ayuda](http://makeareadme.com)
