-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Almacen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Almacen` (
  `Numero` INT NOT NULL,
  `Responsable` VARCHAR(45) NULL,
  PRIMARY KEY (`Numero`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Articulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Articulo` (
  `Codigo_Articulo` INT NOT NULL,
  `Descripcion` VARCHAR(45) NULL,
  `Precio` INT NULL,
  PRIMARY KEY (`Codigo_Articulo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Material` (
  `Codigo_Material` INT NOT NULL,
  `Descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`Codigo_Material`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Proveedor` (
  `Codigo_Proveedor` INT NOT NULL,
  `Nombre` VARCHAR(45) NULL,
  `Domicilio` VARCHAR(45) NULL,
  `Ciudad` VARCHAR(45) NULL,
  PRIMARY KEY (`Codigo_Proveedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Compuesto_por`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Compuesto_por` (
  `Articulo_Codigo_Articulo` INT NOT NULL,
  `Material_Codigo_Material` INT NOT NULL,
  PRIMARY KEY (`Articulo_Codigo_Articulo`, `Material_Codigo_Material`),
  INDEX `fk_Articulo_has_Material_Material1_idx` (`Material_Codigo_Material` ASC),
  INDEX `fk_Articulo_has_Material_Articulo_idx` (`Articulo_Codigo_Articulo` ASC),
  CONSTRAINT `fk_Articulo_has_Material_Articulo`
    FOREIGN KEY (`Articulo_Codigo_Articulo`)
    REFERENCES `mydb`.`Articulo` (`Codigo_Articulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Articulo_has_Material_Material1`
    FOREIGN KEY (`Material_Codigo_Material`)
    REFERENCES `mydb`.`Material` (`Codigo_Material`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Provisto_por`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Provisto_por` (
  `Material_Codigo_Material` INT NOT NULL,
  `Proveedor_Codigo_Proveedor` INT NOT NULL,
  PRIMARY KEY (`Material_Codigo_Material`, `Proveedor_Codigo_Proveedor`),
  INDEX `fk_Material_has_Proveedor_Proveedor1_idx` (`Proveedor_Codigo_Proveedor` ASC),
  INDEX `fk_Material_has_Proveedor_Material1_idx` (`Material_Codigo_Material` ASC),
  CONSTRAINT `fk_Material_has_Proveedor_Material1`
    FOREIGN KEY (`Material_Codigo_Material`)
    REFERENCES `mydb`.`Material` (`Codigo_Material`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Material_has_Proveedor_Proveedor1`
    FOREIGN KEY (`Proveedor_Codigo_Proveedor`)
    REFERENCES `mydb`.`Proveedor` (`Codigo_Proveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tiene`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Tiene` (
  `Almacen_Numero` INT NOT NULL,
  `Articulo_Codigo_Articulo` INT NOT NULL,
  `Material_Codigo_Material` INT NOT NULL,
  PRIMARY KEY (`Almacen_Numero`, `Articulo_Codigo_Articulo`, `Material_Codigo_Material`),
  INDEX `fk_Almacen_has_Articulo_Articulo1_idx` (`Articulo_Codigo_Articulo` ASC),
  INDEX `fk_Almacen_has_Articulo_Almacen1_idx` (`Almacen_Numero` ASC),
  INDEX `fk_Tiene_Material1_idx` (`Material_Codigo_Material` ASC),
  CONSTRAINT `fk_Almacen_has_Articulo_Almacen1`
    FOREIGN KEY (`Almacen_Numero`)
    REFERENCES `mydb`.`Almacen` (`Numero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Almacen_has_Articulo_Articulo1`
    FOREIGN KEY (`Articulo_Codigo_Articulo`)
    REFERENCES `mydb`.`Articulo` (`Codigo_Articulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tiene_Material1`
    FOREIGN KEY (`Material_Codigo_Material`)
    REFERENCES `mydb`.`Material` (`Codigo_Material`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- Datos

Insert into Proveedor
	values	(1,'Peter Parker','Olazabal','La Plata'),
			(2,'Felicia Hartley','Triunvirato','C.A.B.A'),
            (3,'Haward Stark','Constituyentes','Entre Rios'),
            (4,'Valu Gottelli','Congreso','Rosario'),
            (5,'Lopez','Mitre','Mendoza');

Insert into Material
	values	(1,'AAA-AAA'),
			(2,'BBB-BBB'),
            (3,'CCC-CCC'),
            (4,'DDD-DDD'),
            (5,'EEE-EEE'),
            (6,'ZZZ-ZZZ'),
            (7,'KKK-KKK'),
            (8,'WWW-WWW'),
            (9,'QQQ-QQQ'),
            (10,'TTT-TTT');

Insert into Almacen
	values	(1,'Spider-Man'),
			(2,'Iron-Man'),
            (3,'Capitan America'),
            (4,'Pablo Escobar'),
            (5,'El Chapo'),
            (6,'San Martin'),
            (7,'Stan Lee'),
            (8,'Steve Ditko'),
            (9,'Facundo Gamba'),
            (10,'El chino Mingo');
            
Insert into Articulo
	values	(1,'QQQ-QQQ','1.000'),
			(2,'WWW-WWW','2.000'),
            (3,'EEE-EEE','3.000'),
            (4,'RRR-RRR','4.000'),
            (5,'TTT-TTT','5.000'),
            (6,'YYY-YYY','6.000'),
            (7,'UUU-UUU','7.000'),
            (8,'III-III','8.000'),
            (9,'OOO-OOO','9.000'),
            (10,'PPP-PPP','10.000');
            
insert into Provisto_por
	values	(1,1),
			(2,1),
            (3,2),
            (4,2),
            (5,3),
            (6,3),
            (7,4),
            (8,4),
            (9,5),
            (10,5);
            
insert into Compuesto_por
	values	(1,1),
			(2,1),
            (3,2),
            (4,2),
            (5,3),
            (6,3),
            (7,4),
            (8,4),
            (9,5),
            (10,5);
           
            
    

-- Ejercicios

-- 1) Funciona

Select *
	from Proveedor
		 where Ciudad='La Plata';


-- 2) No funciona no se porque

Select Material.Codigo_Material, Material.Descripcion, Proveedor.Codigo_Proveedor, Proveedor.Nombre
	from Material
		join Provisto_por
			on Material.Codigo_Material = Provisto_por.Material_Codigo_Material
				join Proveedor
					on Provisto_por.Proveedor_Codigo_Proveedor = Proveedor.Codigo_Proveedor
						where Proveedor.Ciudad = "Rosario";
 

-- 3) Hallar códigos y descripciones de los artículos compuestos por al menos un material provisto por el proveedor Lopez.
	
select Articulo.Codigo_Articulo ,Articulo.Descripcion, Articulo.Precio
from Articulo
join Compuesto_por
on Compuesto_por.Articulo_Codigo_Articulo = Articulo.Codigo_Articulo
where exists ();
having count() ; 

 -- 9) 

select distinct Codigo_Proveedor
from Proveedor
join Provisto_por
on Proveedor.Codigo_Proveedor = Provisto_por.Proveedor_Codigo_Proveedor
join Material
on Material.Codigo_Material = Provisto_por.Material_Codigo_Material
join Compuesto_por
on Material.Codigo_Material = Compuesto_por.Material_Codigo_Material
where Compuesto_por.Articulo_Codigo_Articulo
= (
select Codigo_Articulo
from Articulo
);

 

