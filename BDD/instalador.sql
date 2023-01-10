-- instalador de estructuras y datos iniciales

CREATE SCHEMA IF NOT EXISTS `tienda` DEFAULT CHARACTER SET utf8 ;
USE `tienda` ;

DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS pedido;
DROP TABLE IF EXISTS usuario;


-- -----------------------------------------------------
-- Table `producto`
-- -----------------------------------------------------
CREATE TABLE producto (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `precio` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `producto`
-- -----------------------------------------------------
CREATE TABLE pedido (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo_producto` VARCHAR(45) NOT NULL,
  `cantidad` int NOT NULL,
  `precio` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `producto`
-- -----------------------------------------------------
CREATE TABLE  usuario (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `producto`
-- -----------------------------------------------------

INSERT INTO producto ( codigo,    nombre,                   precio)
            VALUES   ('A11',     'Mouse ergonomico',         10); 
INSERT INTO producto ( codigo,    nombre,                   precio)
            VALUES   ('A12',     'Teclado ergonomico',        8); 
INSERT INTO producto ( codigo,    nombre,                   precio)
            VALUES   ('A13',     'Monitor LCD',              100); 
INSERT INTO producto ( codigo,    nombre,                   precio)
            VALUES   ('A14',     'Disco duro'       ,         50); 



-- -----------------------------------------------------
-- Table `pedido`
-- -----------------------------------------------------
INSERT INTO pedido ( codigo_producto,    cantidad,     precio)
            VALUES ('A11',               50,           500) 
INSERT INTO pedido ( codigo_producto,    cantidad,     precio)
            VALUES ('A11',               2,            100) 
INSERT INTO pedido ( codigo_producto,    cantidad,     precio)
            VALUES ('A12',               1,            8) 
INSERT INTO pedido ( codigo_producto,    cantidad,     precio)
            VALUES ('A12',               1000,         8000) 
INSERT INTO pedido ( codigo_producto,    cantidad,     precio)
            VALUES ('A13',               4,            400) 
INSERT INTO pedido ( codigo_producto,    cantidad,     precio)
            VALUES ('A13',               800,          80000) 
INSERT INTO pedido ( codigo_producto,    cantidad,     precio)
            VALUES ('A14',               50,           2500) 
INSERT INTO pedido ( codigo_producto,    cantidad,     precio)
            VALUES ('A14',               3,            150) 


-- -----------------------------------------------------
-- Table `usuario`
-- -----------------------------------------------------
INSERT INTO usuario (nombre,      apellido,     usuario,      clave,        rol)
            values  ('Milton',    'Paucar',     'mpaucar',    'admuser',    'ADM')
INSERT INTO usuario (nombre,      apellido,     usuario,      clave,        rol)
            values  ('Adrian',    'Nario',     'elbana',      'saluteee',   'USR')
