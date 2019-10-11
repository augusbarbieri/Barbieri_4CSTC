-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

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
  `idcategoria_usuario` INT NOT NULL,
  `categoria_nombre` VARCHAR(45) NULL,
  `almacenamiento` INT NULL,
  PRIMARY KEY (`idcategoria_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `almacenamiento_utilizado` INT NULL,
  `categoria_usuario_idcategoria_usuario` INT NOT NULL,
  PRIMARY KEY (`idusuario`),
  INDEX `fk_usuario_categoria_usuario1_idx` (`categoria_usuario_idcategoria_usuario` ASC),
  CONSTRAINT `fk_usuario_categoria_usuario1`
    FOREIGN KEY (`categoria_usuario_idcategoria_usuario`)
    REFERENCES `mydb`.`categoria_usuario` (`idcategoria_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`carpeta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`carpeta` (
  `idcarpeta` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL,
  `peso` INT NULL,
  `link` VARCHAR(45) NULL,
  `carpeta_idcarpeta` INT NULL,
  PRIMARY KEY (`idcarpeta`),
  INDEX `fk_carpeta_carpeta1_idx` (`carpeta_idcarpeta` ASC) ,
  CONSTRAINT `fk_carpeta_carpeta1`
    FOREIGN KEY (`carpeta_idcarpeta`)
    REFERENCES `mydb`.`carpeta` (`idcarpeta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`archivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`archivo` (
  `idarchivo` INT NOT NULL AUTO_INCREMENT,
  `contenido` VARCHAR(500) NULL,
  `nombre` VARCHAR(45) NULL,
  `peso` INT NULL,
  `link` VARCHAR(45) NULL,
  PRIMARY KEY (`idarchivo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`auditoria_archivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`auditoria_archivo` (
  `idauditoria_archivo` INT NOT NULL AUTO_INCREMENT,
  `contenido` VARCHAR(500) NULL,
  `nombre` VARCHAR(45) NULL,
  `peso` INT NULL,
  `fecha` DATETIME NULL,
  PRIMARY KEY (`idauditoria_archivo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`auditoria_carpeta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`auditoria_carpeta` (
  `idauditoria_carpeta` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `peso` INT NULL,
  `carpeta_padre` INT NULL,
  `fecha` DATETIME NULL,
  PRIMARY KEY (`idauditoria_carpeta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`modo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`modo` (
  `idmodo` INT NOT NULL,
  `modo` VARCHAR(45) NULL,
  PRIMARY KEY (`idmodo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`compartir_archivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`compartir_archivo` (
  `archivo_idarchivo` INT NOT NULL,
  `usuario_idusuario` INT NOT NULL,
  `modo_idmodo` INT NOT NULL,
  PRIMARY KEY (`archivo_idarchivo`, `usuario_idusuario`),
  INDEX `fk_archivo_has_usuario_usuario1_idx` (`usuario_idusuario` ASC) ,
  INDEX `fk_archivo_has_usuario_archivo_idx` (`archivo_idarchivo` ASC) ,
  INDEX `fk_compartir_archivo_modo1_idx` (`modo_idmodo` ASC) ,
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
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`compartir_carpeta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`compartir_carpeta` (
  `carpeta_idcarpeta` INT NOT NULL,
  `usuario_idusuario` INT NOT NULL,
  `modo_idmodo` INT NOT NULL,
  PRIMARY KEY (`carpeta_idcarpeta`, `usuario_idusuario`),
  INDEX `fk_carpeta_has_usuario_usuario1_idx` (`usuario_idusuario` ASC) ,
  INDEX `fk_carpeta_has_usuario_carpeta1_idx` (`carpeta_idcarpeta` ASC) ,
  INDEX `fk_compartir_carpeta_modo1_idx` (`modo_idmodo` ASC) ,
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
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;