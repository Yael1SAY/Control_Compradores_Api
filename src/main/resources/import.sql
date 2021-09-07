INSERT INTO `compradores`(id_comprador, clave, password, nombre, apellido_paterno, apellido_materno, estatus) VALUES (null, 'C01', '$2a$10$tI3vMKw5UVx8lXRINhBT3eSQNv2KLvwnQ5IvRUcXHalypfSnNbpZm', 'Miguel ', 'Juarez', null, true);
INSERT INTO `compradores`(id_comprador, clave, password, nombre, apellido_paterno, apellido_materno, estatus) VALUES (null, 'C02', '$2a$10$UJN0qKdVJnDWrEWSWlv27uYvsimKe.81IUVcI6NxA9dx1FmDZ.tpi', 'Cristina ', 'Huitron', null, true);
INSERT INTO `compradores`(id_comprador, clave, password, nombre, apellido_paterno, apellido_materno, estatus) VALUES (null, 'C03', '$2a$10$q.Ln7Np8KOab0A4zrqpxfOb8GWaYagP.KdEUSYJGmvNAupUb21Fny', 'Esmeralda', 'Reyes', 'Sanchez', true);
INSERT INTO `compradores`(id_comprador, clave, password, nombre, apellido_paterno, apellido_materno, estatus) VALUES (null, 'C04', '$2a$10$wouqDwFmc.dTLKEf1XBRfe8Xq7QgyhT09mmBFzZvdG8bbzBSF6TV2', 'Meliton', 'Garcia', null, true);
INSERT INTO `compradores`(id_comprador, clave, password, nombre, apellido_paterno, apellido_materno, estatus) VALUES (null, 'C08', '$2a$10$h1ixDJOJzLfQIjb2UMt0euOCc32HLQ.vjyH81NZY4gSxgB6zpsqa.', 'Leticia', 'Gonzales', 'R', true);
INSERT INTO `compradores`(id_comprador, clave, password, nombre, apellido_paterno, apellido_materno, estatus) VALUES (null, 'C09', '$2a$10$DL5pVAf1cTzq1o1m9ef5buq/NHb67Hy/jy4ACdIwknzMsvupMwptW', 'Ivan', 'Perez', 'Quezada', true);
INSERT INTO `compradores`(id_comprador, clave, password, nombre, apellido_paterno, apellido_materno, estatus) VALUES (null, 'C11', '$2a$10$PuVz.svP/Z4GpD7gR0O5vubUzcXVD9nZLlmwg5J3URsaE8GYSEAXS', 'Adriana', 'Franco', 'Paredes', true);
INSERT INTO `compradores`(id_comprador, clave, password, nombre, apellido_paterno, apellido_materno, estatus) VALUES (null, 'C14', '$2a$10$yBhmR8zFHm28R4NjOhUNXuB1r5XzUPUtER924MmsivtaRp6ZL58ZC', 'Lucero', 'Cadena', null, true);
INSERT INTO `compradores`(id_comprador, clave, password, nombre, apellido_paterno, apellido_materno, estatus) VALUES (null, 'C15', '$2a$10$w.zntTWHg6Equ93vMTHs6.XrSRIkTA4SPda8Lp5BmX/iuOXX.T29q', 'Adalberto', 'Galvan', 'Cruz', true);

Insert into roles (nombre_rol) values ("ROLE_USER");
Insert into roles (nombre_rol) values ("ROLE_ADMIN");

Insert into compradores_roles(id_comprador, id_rol) values (1,1);
Insert into compradores_roles(id_comprador, id_rol) values (1,2);
Insert into compradores_roles(id_comprador, id_rol) values (2,1);
Insert into compradores_roles(id_comprador, id_rol) values (3,1);
Insert into compradores_roles(id_comprador, id_rol) values (4,1);
Insert into compradores_roles(id_comprador, id_rol) values (5,1);
Insert into compradores_roles(id_comprador, id_rol) values (6,1);
Insert into compradores_roles(id_comprador, id_rol) values (7,1);
Insert into compradores_roles(id_comprador, id_rol) values (8,1);
Insert into compradores_roles(id_comprador, id_rol) values (9,1);

INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'ENERO', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '2');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'FEBRERO', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '2');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'MARZO', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '2');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'ABRIL', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '2');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'MAYO', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '2');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'JUNIO', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '2');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'JULIO', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '2');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'AGOSTO', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '2');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'SEPTIEMBRE', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '2');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'OCTUBRE', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '2');

INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'ENERO', '2020', '90', 2, '95', '2', '0', '0', true, true, '4', true, '2');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'FEBRERO', '2020', '90', 2, '95', '2', '0', '0', true, true, '4', true, '2');

INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'ENERO', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '3');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'FEBRERO', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '3');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'MARZO', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '3');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'ABRIL', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '3');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'MAYO', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '3');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'JUNIO', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '3');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'JULIO', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '3');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'AGOSTO', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '3');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'SEPTIEMBRE', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '3');
INSERT INTO `servicio_comprador`(id_servicio, mes, anio, solicitud_pedido,dias_sp,orden_compra,dias_oc,criterio,discrecional,ahorro,captura_en_tiempo,total,estatus,id_comprador)VALUES (null, 'OCTUBRE', '2021', '90', 2, '95', '2', '0', '0', true, true, '4', true, '3');