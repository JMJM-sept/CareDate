-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema caredate
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `caredate` ;

-- -----------------------------------------------------
-- Schema caredate
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `caredate` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `caredate` ;

-- -----------------------------------------------------
-- Table `caredate`.`catalogoContacto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`catalogoContacto` ;

CREATE TABLE IF NOT EXISTS `caredate`.`catalogoContacto` (
  `idContacto` INT NOT NULL,
  `tipoContacto` VARCHAR(25) NULL DEFAULT NULL,
  PRIMARY KEY (`idContacto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `caredate`.`persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`persona` ;

CREATE TABLE IF NOT EXISTS `caredate`.`persona` (
  `idPersona` INT NOT NULL,
  `nombre` VARCHAR(20) NULL DEFAULT NULL,
  `aPaterno` VARCHAR(20) NULL DEFAULT NULL,
  `aMaterno` VARCHAR(20) NULL DEFAULT NULL,
  `curp` VARCHAR(18) NULL DEFAULT NULL,
  `fechaNac` DATE NULL DEFAULT NULL,
  `sexo` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`idPersona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `caredate`.`cedulaMed`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`cedulaMed` ;

CREATE TABLE IF NOT EXISTS `caredate`.`cedulaMed` (
  `idCedMed` INT NOT NULL,
  `idPersona` INT NULL DEFAULT NULL,
  `cedula` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idCedMed`),
  CONSTRAINT `cedulamed_ibfk_1`
    FOREIGN KEY (`idPersona`)
    REFERENCES `caredate`.`persona` (`idPersona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `idPersona` ON `caredate`.`cedulaMed` (`idPersona` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `caredate`.`direccionClin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`direccionClin` ;

CREATE TABLE IF NOT EXISTS `caredate`.`direccionClin` (
  `idDireccionClin` INT NOT NULL,
  `calleC` VARCHAR(40) NULL DEFAULT NULL,
  `numeroC` INT NULL DEFAULT NULL,
  `coloniaC` VARCHAR(40) NULL DEFAULT NULL,
  `cpC` INT NULL DEFAULT NULL,
  `municipioC` VARCHAR(20) NULL DEFAULT NULL,
  `estadoC` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`idDireccionClin`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `caredate`.`clinica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`clinica` ;

CREATE TABLE IF NOT EXISTS `caredate`.`clinica` (
  `idClinica` INT NOT NULL,
  `idDireccionClin` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idClinica`),
  CONSTRAINT `clinica_ibfk_1`
    FOREIGN KEY (`idDireccionClin`)
    REFERENCES `caredate`.`direccionClin` (`idDireccionClin`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `idDireccionClin` ON `caredate`.`clinica` (`idDireccionClin` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `caredate`.`estado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`estado` ;

CREATE TABLE IF NOT EXISTS `caredate`.`estado` (
  `idEstado` INT NOT NULL,
  `nombre` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`idEstado`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `caredate`.`municipio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`municipio` ;

CREATE TABLE IF NOT EXISTS `caredate`.`municipio` (
  `idMunicipio` INT NOT NULL,
  `nombre` VARCHAR(30) NULL DEFAULT NULL,
  `idEstado` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idMunicipio`),
  CONSTRAINT `municipio_ibfk_1`
    FOREIGN KEY (`idEstado`)
    REFERENCES `caredate`.`estado` (`idEstado`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `idEstado` ON `caredate`.`municipio` (`idEstado` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `caredate`.`colonia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`colonia` ;

CREATE TABLE IF NOT EXISTS `caredate`.`colonia` (
  `idColonia` INT NOT NULL,
  `nombre` VARCHAR(30) NULL DEFAULT NULL,
  `idMunicipio` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idColonia`),
  CONSTRAINT `colonia_ibfk_1`
    FOREIGN KEY (`idMunicipio`)
    REFERENCES `caredate`.`municipio` (`idMunicipio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `idMunicipio` ON `caredate`.`colonia` (`idMunicipio` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `caredate`.`consultorio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`consultorio` ;

CREATE TABLE IF NOT EXISTS `caredate`.`consultorio` (
  `idConsultorio` INT NOT NULL,
  `noConsultorio` INT NULL DEFAULT NULL,
  `idClinica` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idConsultorio`),
  CONSTRAINT `consultorio_ibfk_1`
    FOREIGN KEY (`idClinica`)
    REFERENCES `caredate`.`clinica` (`idClinica`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `idClinica` ON `caredate`.`consultorio` (`idClinica` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `caredate`.`direccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`direccion` ;

CREATE TABLE IF NOT EXISTS `caredate`.`direccion` (
  `idDireccion` INT NOT NULL AUTO_INCREMENT,
  `calle` VARCHAR(100) NOT NULL,
  `numero` INT NOT NULL,
  `cp` INT NOT NULL,
  `estado` VARCHAR(40) NOT NULL,
  `municipio` VARCHAR(40) NOT NULL,
  `colonia` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`idDireccion`),
  CONSTRAINT `idColonia`
    FOREIGN KEY ()
    REFERENCES `caredate`.`colonia` ())
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `caredate`.`tipoUsuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`tipoUsuario` ;

CREATE TABLE IF NOT EXISTS `caredate`.`tipoUsuario` (
  `idTipoUsuario` INT NOT NULL,
  `usuario` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`idTipoUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `caredate`.`personaUsr`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`personaUsr` ;

CREATE TABLE IF NOT EXISTS `caredate`.`personaUsr` (
  `idPerUsr` INT NOT NULL,
  `idPersona` INT NULL DEFAULT NULL,
  `idTipoUsuario` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idPerUsr`),
  CONSTRAINT `personausr_ibfk_1`
    FOREIGN KEY (`idPersona`)
    REFERENCES `caredate`.`persona` (`idPersona`),
  CONSTRAINT `personausr_ibfk_2`
    FOREIGN KEY (`idTipoUsuario`)
    REFERENCES `caredate`.`tipoUsuario` (`idTipoUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `idPersona` ON `caredate`.`personaUsr` (`idPersona` ASC) VISIBLE;

CREATE INDEX `idTipoUsuario` ON `caredate`.`personaUsr` (`idTipoUsuario` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `caredate`.`relCtoPer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`relCtoPer` ;

CREATE TABLE IF NOT EXISTS `caredate`.`relCtoPer` (
  `idRel` INT NOT NULL,
  `descr` VARCHAR(30) NULL DEFAULT NULL,
  `idPersona` INT NULL DEFAULT NULL,
  `idContacto` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idRel`),
  CONSTRAINT `relctoper_ibfk_1`
    FOREIGN KEY (`idPersona`)
    REFERENCES `caredate`.`persona` (`idPersona`),
  CONSTRAINT `relctoper_ibfk_2`
    FOREIGN KEY (`idContacto`)
    REFERENCES `caredate`.`catalogoContacto` (`idContacto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `idPersona` ON `caredate`.`relCtoPer` (`idPersona` ASC) VISIBLE;

CREATE INDEX `idContacto` ON `caredate`.`relCtoPer` (`idContacto` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `caredate`.`relDirPer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`relDirPer` ;

CREATE TABLE IF NOT EXISTS `caredate`.`relDirPer` (
  `idRel` INT NOT NULL,
  `idDireccion` INT NULL DEFAULT NULL,
  `idPersona` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idRel`),
  CONSTRAINT `reldirper_ibfk_1`
    FOREIGN KEY (`idDireccion`)
    REFERENCES `caredate`.`direccion` (`idDireccion`),
  CONSTRAINT `reldirper_ibfk_2`
    FOREIGN KEY (`idPersona`)
    REFERENCES `caredate`.`persona` (`idPersona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `idDireccion` ON `caredate`.`relDirPer` (`idDireccion` ASC) VISIBLE;

CREATE INDEX `idPersona` ON `caredate`.`relDirPer` (`idPersona` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `caredate`.`relPerCli`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`relPerCli` ;

CREATE TABLE IF NOT EXISTS `caredate`.`relPerCli` (
  `idRelPC` INT NOT NULL,
  `idPersona` INT NULL DEFAULT NULL,
  `idClinica` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idRelPC`),
  CONSTRAINT `relpercli_ibfk_1`
    FOREIGN KEY (`idPersona`)
    REFERENCES `caredate`.`persona` (`idPersona`),
  CONSTRAINT `relpercli_ibfk_2`
    FOREIGN KEY (`idClinica`)
    REFERENCES `caredate`.`clinica` (`idClinica`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `idPersona` ON `caredate`.`relPerCli` (`idPersona` ASC) VISIBLE;

CREATE INDEX `idClinica` ON `caredate`.`relPerCli` (`idClinica` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
