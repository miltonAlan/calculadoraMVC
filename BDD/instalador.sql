-- instalador de estructuras y datos iniciales

create schema if not exists `tienda` default character set utf8 ;
use `tienda` ;

-- drop table if exists producto;
drop table if exists pedido;
drop table if exists usuario;


-- -----------------------------------------------------
-- table `producto`
-- -----------------------------------------------------
-- create table producto (
--   `id` int not null auto_increment,
--   `codigo` varchar(45) not null,
--   `nombre` varchar(45) not null,
--   `precio` int not null,
--   primary key (`id`))
-- engine = innodb;


-- -----------------------------------------------------
-- table `pedido`
-- -----------------------------------------------------
create table pedido (
  `id` int not null auto_increment,
  `codigo` varchar(45) not null,
  `cantidad` int not null,
  `descripcion` varchar(45) not null,
  `precio_unitario` int not null,
  `precio_final` int not null,
  primary key (`id`))
engine = innodb;


-- -----------------------------------------------------
-- table `producto`
-- -----------------------------------------------------
create table  usuario (
  `id` int not null auto_increment,
  `nombre` varchar(45) not null,
  `apellido` varchar(45) not null,
  `usuario` varchar(45) not null,
  `clave` varchar(45) not null,
  `rol` varchar(45) not null,
  primary key (`id`))
engine = innodb;

-- -----------------------------------------------------
-- table `producto`
-- -----------------------------------------------------

-- insert into producto ( codigo,    nombre,                   precio)
--             values   ('a11',     'mouse ergonomico',         10); 
-- insert into producto ( codigo,    nombre,                   precio)
--             values   ('a12',     'teclado ergonomico',        8); 
-- insert into producto ( codigo,    nombre,                   precio)
--             values   ('a13',     'monitor lcd',              100); 
-- insert into producto ( codigo,    nombre,                   precio)
--             values   ('a14',     'disco duro'       ,         50); 



-- -----------------------------------------------------
-- table `pedido`
-- -----------------------------------------------------
insert into pedido ( codigo,    cantidad,     precio_unitario,    descripcion,                    precio_final)
            values ('a11',      50,           10,                'compra de 10 teclados',         500); 
insert into pedido ( codigo,    cantidad,     precio_unitario,    descripcion,                    precio_final)
            values ('a12',      2,            100,                'compra de 2 monitores',        200); 
insert into pedido ( codigo,    cantidad,     precio_unitario,    descripcion,                    precio_final)
            values ('a13',      1,            8,                  'compra de un cpu',             8); 
insert into pedido ( codigo,    cantidad,     precio_unitario,    descripcion,                    precio_final)
            values ('a14',      1000,         8000,               'compra de 1000 camaras',       8000000); 
insert into pedido ( codigo,    cantidad,     precio_unitario,    descripcion,                    precio_final)
            values ('a15',      4,            400,                'compra de 4 telefonos',        1600); 
insert into pedido ( codigo,    cantidad,     precio_unitario,    descripcion,                    precio_final)
            values ('a16',      800,          66,                 'compra de 800 discos duros',   52800); 


-- -----------------------------------------------------
-- table `usuario`
-- -----------------------------------------------------
insert into usuario (nombre,      apellido,     usuario,      clave,        rol)
            values  ('milton',    'paucar',     'mpaucar',    'admuser',    'adm');
insert into usuario (nombre,      apellido,     usuario,      clave,        rol)
            values  ('adrian',    'nario',     'elbana',      'saluteee',   'usr');
