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
-- Table `mydb`.`categoria_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`categoria_usuario` (
  `idcategoria_usuario` INT(11) NOT NULL,
  `categoria_nombre` VARCHAR(45) NULL DEFAULT NULL,
  `almacenamiento` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`idcategoria_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `idusuario` INT(11) NOT NULL AUTO_INCREMENT,
  `mail` VARCHAR(45) NULL DEFAULT NULL,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `apellido` VARCHAR(45) NULL DEFAULT NULL,
  `almacenamiento_utilizado` DECIMAL(10,2) NULL DEFAULT NULL,
  `categoria_usuario_idcategoria_usuario` INT(11) NOT NULL,
  PRIMARY KEY (`idusuario`),
  INDEX `fk_usuario_categoria_usuario1_idx` (`categoria_usuario_idcategoria_usuario` ASC),
  CONSTRAINT `fk_usuario_categoria_usuario1`
    FOREIGN KEY (`categoria_usuario_idcategoria_usuario`)
    REFERENCES `mydb`.`categoria_usuario` (`idcategoria_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`carpeta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`carpeta` (
  `idcarpeta` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL DEFAULT NULL,
  `link` VARCHAR(45) NULL DEFAULT NULL,
  `borrado` TINYINT(4) NULL DEFAULT NULL,
  `carpeta_idcarpeta` INT(11) NULL DEFAULT NULL,
  `usuario_idusuario` INT(11) NOT NULL,
  PRIMARY KEY (`idcarpeta`),
  INDEX `fk_carpeta_carpeta1_idx` (`carpeta_idcarpeta` ASC),
  INDEX `fk_carpeta_usuario1_idx` (`usuario_idusuario` ASC),
  CONSTRAINT `fk_carpeta_carpeta1`
    FOREIGN KEY (`carpeta_idcarpeta`)
    REFERENCES `mydb`.`carpeta` (`idcarpeta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_carpeta_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `mydb`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`archivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`archivo` (
  `idarchivo` INT(11) NOT NULL AUTO_INCREMENT,
  `contenido` VARCHAR(500) NULL DEFAULT NULL,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `peso` DECIMAL(10,2) NULL DEFAULT NULL,
  `link` VARCHAR(45) NULL DEFAULT NULL,
  `borrado` TINYINT(4) NULL DEFAULT NULL,
  `carpeta_idcarpeta` INT(11) NOT NULL,
  PRIMARY KEY (`idarchivo`),
  INDEX `fk_archivo_carpeta1_idx` (`carpeta_idcarpeta` ASC),
  CONSTRAINT `fk_archivo_carpeta1`
    FOREIGN KEY (`carpeta_idcarpeta`)
    REFERENCES `mydb`.`carpeta` (`idcarpeta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`auditoria_archivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`auditoria_archivo` (
  `idauditoria_archivo` INT(11) NOT NULL AUTO_INCREMENT,
  `idarchivo` INT(11) NULL,
  `contenido` VARCHAR(500) NULL DEFAULT NULL,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `borrado` TINYINT(4) NULL DEFAULT NULL,
  `peso` DECIMAL(10,2) NULL DEFAULT NULL,
  `carpeta_idcarpeta` INT(11) NULL DEFAULT NULL,
  `fecha` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`idauditoria_archivo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`modo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`modo` (
  `idmodo` INT(11) NOT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idmodo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`compartir_archivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`compartir_archivo` (
  `archivo_idarchivo` INT(11) NOT NULL,
  `usuario_idusuario` INT(11) NOT NULL,
  `modo_idmodo` INT(11) NOT NULL,
  PRIMARY KEY (`archivo_idarchivo`, `usuario_idusuario`),
  INDEX `fk_archivo_has_usuario_usuario1_idx` (`usuario_idusuario` ASC),
  INDEX `fk_archivo_has_usuario_archivo_idx` (`archivo_idarchivo` ASC),
  INDEX `fk_compartir_archivo_modo1_idx` (`modo_idmodo` ASC),
  CONSTRAINT `fk_archivo_has_usuario_archivo`
    FOREIGN KEY (`archivo_idarchivo`)
    REFERENCES `mydb`.`archivo` (`idarchivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_archivo_has_usuario_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `mydb`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compartir_archivo_modo1`
    FOREIGN KEY (`modo_idmodo`)
    REFERENCES `mydb`.`modo` (`idmodo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`compartir_carpeta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`compartir_carpeta` (
  `carpeta_idcarpeta` INT(11) NOT NULL,
  `usuario_idusuario` INT(11) NOT NULL,
  `modo_idmodo` INT(11) NOT NULL,
  PRIMARY KEY (`carpeta_idcarpeta`, `usuario_idusuario`),
  INDEX `fk_carpeta_has_usuario_usuario1_idx` (`usuario_idusuario` ASC),
  INDEX `fk_carpeta_has_usuario_carpeta1_idx` (`carpeta_idcarpeta` ASC),
  INDEX `fk_compartir_carpeta_modo1_idx` (`modo_idmodo` ASC),
  CONSTRAINT `fk_carpeta_has_usuario_carpeta1`
    FOREIGN KEY (`carpeta_idcarpeta`)
    REFERENCES `mydb`.`carpeta` (`idcarpeta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_carpeta_has_usuario_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `mydb`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compartir_carpeta_modo1`
    FOREIGN KEY (`modo_idmodo`)
    REFERENCES `mydb`.`modo` (`idmodo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`invitacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`invitacion` (
  `idinvitacion` INT(11) NOT NULL AUTO_INCREMENT,
  `mail_invitado` VARCHAR(45) NULL DEFAULT NULL,
  `usuario_invitador` INT(11) NOT NULL,
  PRIMARY KEY (`idinvitacion`),
  INDEX `fk_invitacion_usuario1_idx` (`usuario_invitador` ASC),
  CONSTRAINT `fk_invitacion_usuario1`
    FOREIGN KEY (`usuario_invitador`)
    REFERENCES `mydb`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`almacenamiento_extra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`almacenamiento_extra` (
  `usuario_idusuario` INT(11) NOT NULL,
  `extra` DECIMAL(10,2) NULL,
  INDEX `fk_almacenamiento_extra_usuario1_idx` (`usuario_idusuario` ASC),
  CONSTRAINT `fk_almacenamiento_extra_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `mydb`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- FUNCIONES
-- -----------------------------------------------------
-- function compartir_archivo
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `compartir_archivo`(archivo int, modo int, usuarioDueno int, usuarioCompartido int) RETURNS varchar(50) CHARSET utf8
BEGIN
	declare resp varchar(50);
    declare dueno int;
    select carpeta.usuario_idusuario into dueno from carpeta
		join archivo on carpeta.idcarpeta = archivo.carpeta_idcarpeta
			where archivo.idarchivo = archivo;
    if(usuarioDueno = dueno) then
		set resp = "Se compartio con exito!";
		insert into compartir_archivo values(archivo,usuarioCompartido,modo);
    else
		set resp = "no tienes permisos para hacer eso";
	end if;
RETURN resp;
END$$

DELIMITER ;
-- -----------------------------------------------------
-- function obtener_almacenamiento_disponible
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `obtener_almacenamiento_disponible`(usuariox int) RETURNS decimal(10,2)
BEGIN
	declare resp decimal(10,2);
    declare categoria int;
    declare espacioExtra decimal(10,2);
    
    select categoria_usuario_idcategoria_usuario into categoria from usuario where idusuario = usuariox;
	
    select almacenamiento into resp from categoria_usuario where idcategoria_usuario = categoria;
    
    if categoria = 0 then
		select extra into espacioExtra from almacenamiento_extra where usuario_idusuario = usuariox;
        set resp = resp + espacioExtra;
	end if;
RETURN resp;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- function cambiar_categoria
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `cambiar_categoria`(categoria int,usuariox int) RETURNS varchar(100) CHARSET utf8
BEGIN
	declare resp varchar(100);
    declare catActual int;
    declare almacenamientoUtilizado decimal(10,2);
    declare almacenamientoLimite decimal(10,2);
    
    select almacenamiento_utilizado into almacenamientoUtilizado from usuario where idusuario = usuariox;
    select categoria_usuario_idcategoria_usuario into catActual from usuario where idusuario = usuariox;
    select almacenamiento into almacenamientoLimite from categoria_usuario where idcategoria_usuario = categoria;
    
    if categoria = catActual then
		set resp = "La categoria a la que se desea cambiar es a la que pertenece acutalmente";
	elseif categoria > catActual then
		update usuario set categoria_usuario_idcategoria_usuario = categoria where idusuario = usuariox;
        set resp = "Su categoria se cambio con exito!";
	elseif categoria <catActual then
		if (almacenamientoUtilizado<=almacenamientoLimite) then
			update usuario set categoria_usuario_idcategoria_usuario = categoria where idusuario = usuariox;
            set resp = "Su categoria se cambio con exito!";
		else 
			set resp = "Su categoria no se pudo cambiar porque su almacenamiento acutal excede con el almacenamiento limite de la nueva categoria";
		end if;
	end if;
    
RETURN resp;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- function tiene_acceso
-- -----------------------------------------------------

DELIMITER $$

CREATE  FUNCTION `tiene_acceso`(archivo int,usuariox int) RETURNS tinyint(1)
BEGIN
	declare resp tinyint(1);
    declare carpeta int;
    
    select carpeta_idcarpeta into carpeta from archivo where idarchivo = archivo; 
	if (select usuario_idusuario from carpeta where idcarpeta = carpeta) = usuariox then
		set resp = 0;
	elseif(select usuario_idusuario from compartir_archivo where archivo_idarchivo = archivo and usuario_idusuario = usuariox and modo_idmodo = 0) then
		set resp = 0;
	elseif(select usuario_idusuario from compartir_carpeta where carpeta_idcarpeta = carpeta and usuario_idusuario = usuariox and modo_idmodo = 0) then
		set resp = 0;
	else
		set resp = 1;
	end if;
RETURN resp;
END$$

DELIMITER ;
-- -----------------------------------------------------
-- function modificar_archivo
-- -----------------------------------------------------

DELIMITER $$

CREATE  FUNCTION `modificar_archivo`(archivo int,usuariox int,nombrex varchar(45),actualizacion varchar(500),pesox decimal(10,2)) RETURNS varchar(70)
BEGIN
	declare resp varchar(70);
    declare usuarioDueno int;
    declare espacioDisponible decimal(10,2);
    declare espacioUsado decimal(10,2);
    select usuario_idusuario into usuarioDueno from carpeta where idcarpeta = (select carpeta_idcarpeta from archivo where idarchivo = archivo);
    select obtener_almacenamiento_disponible(usuarioDueno) into espacioDisponible;
    set espacioUsado = ((select almacenamiento_utilizado from usuario where idusuario = usuarioDueno)+pesox);
    if (( select tiene_acceso(archivo,usuariox)) = 0) then
		if(espacioUsado<=espacioDisponible) then 
            set resp = "Archivo modificado";
			update archivo set nombre = nombrex ,contenido = actualizacion, peso = pesox where idarchivo = archivo;
		else
			set resp = "no se puede modificar porque no tiene espacio";
		end if;
	else
		set resp = "No tienes permisos para modificar este archivo";
    end if;
RETURN resp;
END$$

DELIMITER ;

-- PROCEDIMIENTOS
-- -----------------------------------------------------
-- procedure agregar_archivo
-- -----------------------------------------------------
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `agregar_archivo`(in usuario int,in carpeta int, in contenido varchar(500),in nombre varchar(45),in peso decimal(10,2),in link varchar(45),inout resp varchar(50))
BEGIN
	declare usuarioDueno int;
    declare espacioDisponible decimal(10,2);
    declare espacioUsado decimal(10,2);
    select usuario_idusuario into usuarioDueno from carpeta where idcarpeta = carpeta;
    select obtener_almacenamiento_disponible(usuarioDueno) into espacioDisponible;
    set espacioUsado = ((select almacenamiento_utilizado from usuario where idusuario = usuarioDueno)+peso);
	if ((usuarioDueno = usuario) or (select usuario_idusuario from compartir_carpeta where usuario_idusuario = usuario and carpeta_idcarpeta = carpeta)) then
        if(espacioUsado<=espacioDisponible) then
			set resp = "El archivo se creo con exito";
            insert into archivo values(null,contenido,nombre,peso,link,0,carpeta);
		else 
			set resp = "No se puedo crear el archivo, no hay espacio";
		end if;
	else 
		set resp = "No tienes permisos para hacer esto";
    end if;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- procedure obtener_nivel_carpeta
-- -----------------------------------------------------
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_nivel_carpeta`(in carpeta int, inout nivel int)
BEGIN
	declare carpetaSuper int default null;
    select carpeta_idcarpeta into carpetaSuper from carpeta where idcarpeta = carpeta;
	if (select carpetaSuper) then
		set nivel = nivel + 1;
        call obtener_nivel_carpeta(carpetaSuper,nivel);
	end if;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- procedure agregar_carpeta
-- -----------------------------------------------------

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `agregar_carpeta`(in usuario int,in carpeta int, in nombre varchar(45),in link varchar(45),inout resp varchar(50))
BEGIN
	declare usuarioDueno int;
    declare nivel int default 1;
   
    select usuario_idusuario into usuarioDueno from carpeta where idcarpeta = carpeta;
    
	if ((usuarioDueno = usuario) or (select usuario_idusuario from compartir_carpeta where usuario_idusuario = usuario and carpeta_idcarpeta = carpeta)) then
        call obtener_nivel_carpeta(carpeta,nivel);
        if(nivel<4) then
			set resp = "La carpeta se creo con exito";
            insert into carpeta values(null,nombre,link,0,carpeta,usuario);
		else 
			set resp = "No se puede crear la carpeta, supera el nivel 4";
		end if;
	else 
		set resp = "No tienes permisos para hacer esto";
    end if;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- procedure compartir_carpeta
-- -----------------------------------------------------
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `compartir_carpeta`(in carpeta int,in modo int,in usuarioDueno int,in usuarioCompartido int,inout resp varchar(50))
BEGIN
    declare dueno int;
    DECLARE fin INT DEFAULT 0;
	DECLARE id int DEFAULT null;
    
    -- declaro cursor
	DECLARE identificacion CURSOR FOR
	SELECT  idcarpeta
	FROM carpeta
	WHERE  carpeta_idcarpeta = carpeta;
    -- declaro NOT FOUND handler
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;
    
    select usuario_idusuario into dueno from carpeta where idcarpeta = carpeta;
    if(usuarioDueno = dueno) then
		if(select carpeta_idcarpeta from carpeta where idcarpeta = carpeta) then 
			set resp = "se compartio con exito!";
			insert into compartir_carpeta values(carpeta,usuarioCompartido,modo);
            
            OPEN identificacion;
				obtenerID: LOOP
 
 					FETCH identificacion INTO id;
 
 					IF (fin = 1) THEN 
						LEAVE obtenerID;
					END IF;
 
 					call compartir_carpeta(id,modo,usuarioDueno, usuarioCompartido, @j);
                    
 				END LOOP obtenerID;
 
 			CLOSE identificacion;
	
		else
			set resp = "No se puede compartir la carpeta raiz";
		end if;
	else
		set resp = "no tienes permisos para hacer eso";
	end if;
END$$
DELIMITER ;
-- -----------------------------------------------------
-- procedure eliminar_archivo
-- -----------------------------------------------------
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_archivo`(in archivo int,in usuario int,inout resp varchar(70))
BEGIN
    if((select tiene_acceso(archivo,usuario)) = 0) then
		if((select borrado from archivo where idarchivo = archivo)=0) then 
			set resp = "se elimino con exito!";
            update archivo set borrado = 1 where idarchivo = archivo;
		else
			set resp = "El archivo ya estaba eliminado";
		end if;
	else
		set resp = "no tienes permisos para hacer eso";
	end if;
END$$
DELIMITER ;
-- -----------------------------------------------------
-- procedure eliminar_carpeta
-- -----------------------------------------------------
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_carpeta`(in carpeta int,in usuario int,inout resp varchar(70))
BEGIN
	declare usuarioDueno int;
    DECLARE fin INT DEFAULT 0;
	DECLARE id int DEFAULT null;
    
    -- declaro cursor
	DECLARE identificacion CURSOR FOR
	SELECT  idcarpeta
	FROM carpeta
	WHERE  carpeta_idcarpeta = carpeta;
    -- declaro NOT FOUND handler
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;
    
    select usuario_idusuario into usuarioDueno from carpeta where idcarpeta = carpeta;
    
	if ((usuarioDueno = usuario) or (select usuario_idusuario from compartir_carpeta where usuario_idusuario = usuario and carpeta_idcarpeta = carpeta)) then
		if(select carpeta_idcarpeta from carpeta where idcarpeta = carpeta) then
			if((select borrado from carpeta where idcarpeta = carpeta)=0) then 
				update carpeta set borrado = 1 where idcarpeta = carpeta;
				set resp = "se elimino con exito!";
				
				OPEN identificacion;
				obtenerID: LOOP
 
 					FETCH identificacion INTO id;
 
 					IF (fin = 1) THEN 
						LEAVE obtenerID;
					END IF;
 
 					if((select borrado from carpeta where idcarpeta = id) = 0) then
						call eliminar_carpeta(id,usuario,@resp);
					end if;
                    
 				END LOOP obtenerID;
 
				CLOSE identificacion;
	
			else
				set resp = "la carpeta ya estaba eliminada";
			end if;
		else
			set resp = "no se puede eliminar la carpeta raiz";
		end if;
	else
		set resp = "no tienes permisos para hacer eso";
	end if;
END$$
DELIMITER ;
-- -----------------------------------------------------
-- procedure recuperar_archivo
-- -----------------------------------------------------
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `recuperar_archivo`(in archivo int, in usuario int, inout resp varchar(70))
BEGIN
	declare carpeta int;
    select carpeta_idcarpeta into carpeta from archivo where idarchivo = archivo;
    
	if ((select tiene_acceso(archivo,usuario)) = 0) then
		if((select borrado from carpeta where idcarpeta = carpeta)=0) then
			update archivo set borrado = 0 where idarchivo = archivo;
            set resp = "se recupero con exito";
		else
			set resp = "no se puede recuperar el archivo porque la carpeta esta borrada";
        end if;
	else
		set resp = "no tienes acceso para hacer eso";
    end if;

END$$
DELIMITER ;
-- -----------------------------------------------------
-- procedure recuperar_carpeta
-- -----------------------------------------------------
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `recuperar_carpeta`(in carpeta int, in usuario int, inout resp varchar(70))
BEGIN
    declare carpetaSuper int;
    declare usuarioDueno int;
    DECLARE fin INT DEFAULT 0;
	DECLARE id int DEFAULT null;
    
    -- declaro cursor
	DECLARE identificacion CURSOR FOR
	SELECT  idcarpeta
	FROM carpeta
	WHERE  carpeta_idcarpeta = carpeta;
    -- declaro NOT FOUND handler
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;
    
    select carpeta_idcarpeta into carpetaSuper from carpeta where idcarpeta = carpeta;
    select usuario_idusuario into usuarioDueno from carpeta where idcarpeta = carpeta;
    
    
    
	if ((usuarioDueno = usuario) or (select usuario_idusuario from compartir_carpeta where usuario_idusuario = usuario and carpeta_idcarpeta = carpeta)) then
		if((select borrado from carpeta where idcarpeta = carpetaSuper)=0) then
			update carpeta set borrado = 0 where idcarpeta = carpeta;
            set resp = "se recupero con exito";
            OPEN identificacion;
				obtenerID: LOOP
 
 					FETCH identificacion INTO id;
 
 					IF (fin = 1) THEN 
						LEAVE obtenerID;
					END IF;
 
 					if((select borrado from carpeta where idcarpeta = id) = 1) then
						call recuperar_carpeta(id,usuario,@resp);
					end if;
                    
 				END LOOP obtenerID;
 
 			CLOSE identificacion;
		else
			set resp = "no se puede recuperar la carpeta porque la carpeta en la que se encuentra esta borrada";
        end if;
	else
		set resp = "no tienes acceso para hacer eso";
    end if;

END$$
DELIMITER ;
-- -----------------------------------------------------
-- procedure recuperar_version_archivo
-- -----------------------------------------------------
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `recuperar_version_archivo`(in version int,in archivo int, in usuario int, inout resp varchar(70))
BEGIN
    declare contenidox varchar(500);
    declare nombrex varchar(45);
    declare pesox decimal(10,2);
	
	DECLARE fin INT DEFAULT 0;
	DECLARE id int DEFAULT 0;
    declare iteracion int default 1;
    
    -- declaro cursor
	DECLARE identificacion CURSOR FOR
	SELECT  idauditoria_archivo
	FROM auditoria_archivo
	WHERE idarchivo = archivo order by fecha desc;
    -- declaro NOT FOUND handler
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;
    
	if ((version>0) and (version<5)) then
		case version
        when 1 then
			if ((select count(*) from auditoria_archivo where idarchivo = archivo)<0) then
				set resp = "no existe la version que se pide";
			end if;
		when 2 then
			if ((select count(*) from auditoria_archivo where idarchivo = archivo)<1) then
				set resp = "no existe la version que se pide";
			end if;
		when 3 then
			if ((select count(*) from auditoria_archivo where idarchivo = archivo)<2) then
				set resp = "no existe la version que se pide";
			end if;
		when 4 then
			if ((select count(*) from auditoria_archivo where idarchivo = archivo)<3) then
				set resp = "no existe la version que se pide";
			end if;
		end case; 
        
        OPEN identificacion;
				obtenerID: LOOP
 
 					FETCH identificacion INTO id;
 
 					IF (fin = 1) THEN 
						LEAVE obtenerID;
					END IF;
 
 					if (iteracion = version) then
						select contenido,nombre,peso into contenidox,nombrex,pesox from auditoria_archivo where idauditoria_archivo = id;
                        update archivo set contenido = contenidox, nombre = nombrex, peso = pesox where idarchivo = archivo;
                        set resp = "se recupero con exito";
					end if;
                    set iteracion = iteracion + 1;
 
 				END LOOP obtenerID;
 
 			CLOSE identificacion;
	
	else
		set resp = "solo se puede recuperar hasta la version 4";
	end if;

END$$
DELIMITER ;

-- TRIGGERS
-- -----------------------------------------------------
-- trigger chequear_mail
-- -----------------------------------------------------

DELIMITER $$

CREATE  trigger `chequear_mail` after insert on usuario
	for each row
BEGIN
	declare invitador int default null;
    declare espacio decimal(10,2) default null;
    select usuario_invitador into invitador from invitacion where mail_invitado = NEW.mail;
    
	insert into almacenamiento_extra (usuario_idusuario,extra) values(new.idusuario,0.00);
    insert into carpeta (nombre,borrado,usuario_idusuario) VALUES ("MI CARPETA",0,new.idusuario);
	
	if ((select categoria_usuario_idcategoria_usuario from usuario where idusuario = invitador) = 0) then
		select extra into espacio from almacenamiento_extra where usuario_idusuario = invitador;
        set espacio = espacio + 0.5;
		if ( espacio <= 16) then
			update almacenamiento_extra set extra = (extra + 0.5) where usuario_idusuario = invitador;
		end if;
	end if;
END$$

DELIMITER ;
-- -----------------------------------------------------
-- trigger aumentar_almacenamiento_utilizado
-- -----------------------------------------------------

DELIMITER $$

CREATE  trigger `aumentar_almacenamiento_utilizado` after insert on archivo
	for each row
BEGIN
	declare usuarioDueno int;
    select carpeta.usuario_idusuario into usuarioDueno from carpeta where idcarpeta = new.carpeta_idcarpeta;
    update usuario set almacenamiento_utilizado = (almacenamiento_utilizado + new.peso) where idusuario = usuarioDueno;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- trigger auditoria_archivo
-- -----------------------------------------------------

DELIMITER $$

CREATE  trigger `auditoria_archivo` after update on archivo
	for each row
BEGIN
	declare dueno int;
    declare diferencia decimal(10,2);
    select usuario_idusuario into dueno from carpeta where idcarpeta = old.carpeta_idcarpeta;
    
    insert into auditoria_archivo
		set  idarchivo = old.idarchivo,
        contenido = old.contenido,
        nombre = old.nombre,
        borrado = old.borrado,
        peso = old.peso,
        carpeta_idcarpeta = old.carpeta_idcarpeta,
        fecha = now();
	
    if(old.borrado <> new.borrado) then
		if(new.borrado = 1) then
			update usuario set almacenamiento_utilizado = (almacenamiento_utilizado - old.peso) where idusuario = dueno;
        elseif(new.borrado = 0) then
			update usuario set almacenamiento_utilizado = (almacenamiento_utilizado + old.peso) where idusuario = dueno;
        end if;
	end if;
	if(old.peso <> new.peso) then
		if(old.peso<new.peso) then
			set diferencia = (new.peso - old.peso);
			update usuario set almacenamiento_utilizado = (almacenamiento_utilizado + diferencia) where idusuario = dueno;
		else
			set diferencia = (old.peso - new.peso);
			update usuario set almacenamiento_utilizado = (almacenamiento_utilizado - diferencia) where idusuario = dueno;
		end if;
	end if;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- trigger estado_de_carpeta
-- -----------------------------------------------------
DELIMITER $$

CREATE TRIGGER estado_de_carpeta
	AFTER UPDATE ON carpeta
    FOR EACH ROW
BEGIN
	
    -- declaro variable del handler
	DECLARE fin INT DEFAULT 0;

	DECLARE id int DEFAULT 0;
    
    -- declaro cursor
	DECLARE identificacion CURSOR FOR
	SELECT DISTINCT idarchivo
	FROM archivo
	WHERE carpeta_idcarpeta = NEW.idcarpeta;
    -- declaro NOT FOUND handler
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;
	
    
    IF(OLD.borrado <> NEW.borrado) THEN
			
			OPEN identificacion;
				obtenerID: LOOP
 
 					FETCH identificacion INTO id;
 
 					IF (fin = 1) THEN 
						LEAVE obtenerID;
					END IF;
 
 					-- chequeo si el NEW.borrado es 1 o 0, y despues ingreso el id(archivo) en el procedure
						IF (NEW.borrado = 1) THEN
							call eliminar_archivo(id,new.usuario_idusuario,@msg);
                        ELSEIF (NEW.borrado = 0) THEN
							call recuperar_archivo(id,new.usuario_idusuario,@msg);
                        END IF;
 
 				END LOOP obtenerID;
 
 			CLOSE identificacion;
      
    END IF;
    
END $$

DELIMITER ;

select * from archivo;
delete from compartir_carpeta where carpeta_idcarpeta = 4;
--  inserts
INSERT INTO `categoria_usuario` (`idcategoria_usuario`,`categoria_nombre`, `almacenamiento`) VALUES
	(0,"Free",2.50),
	(1,"Pro",1000.00),
	(2,"Business",5000.00);
INSERT INTO `modo` (`idmodo`,`descripcion`) VALUES
	(0,"escritura"),
	(1,"lectura");

-- pruebas
INSERT INTO `usuario` ( `mail` , `nombre` , `apellido` , `almacenamiento_utilizado`,`categoria_usuario_idcategoria_usuario`) VALUES
	("profesor.informatica@gmai.com","Carlos","Perez",0.00,0);

insert into invitacion (mail_invitado,usuario_invitador) values("profesor2.informatica@gmai.com",1);

INSERT INTO `usuario` ( `mail` , `nombre` , `apellido` , `almacenamiento_utilizado`,`categoria_usuario_idcategoria_usuario`) VALUES
	("profesor2.informatica@gmai.com","Joaquin","Fernandez",0.00,1);

call agregar_carpeta(1,5,"ej1","www.throwInABox.com/5c/triggers/ej1",@resp);
select @resp;

call agregar_archivo(1,1,'Este es un texto','Derivadas ',0.08,'www.throwInABox.com/5c/doc',@resp);
select @resp;

call compartir_carpeta(1,0,1,2,@resp);
select @resp;

call eliminar_archivo(1,1,@resp);
select @resp;

call eliminar_carpeta(4,1,@resp);
select @resp;

call obtener_nivel_carpeta(1,@nivel);
select @nivel;

call recuperar_carpeta(4,1,@resp);
select @resp;

call recuperar_archivo(1,1,@resp);
select @resp;

call recuperar_version_archivo(1,1,1,@resp);
select @resp;

select cambiar_categoria(0,1);

select compartir_archivo(1,0,1,2);

select modificar_archivo(1,1,"Homero","Esto es una actualizacion",0.09);

select obtener_almacenamiento_disponible(1);

select tiene_acceso(1,1);


SET @@session.max_sp_recursion_depth = 10; 
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
