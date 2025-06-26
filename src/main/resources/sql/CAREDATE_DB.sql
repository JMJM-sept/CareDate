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
-- Table `caredate`.`direccionClin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`direccionClin` ;

CREATE TABLE IF NOT EXISTS `caredate`.`direccionClin` (
  `idDireccionClin` INT NOT NULL AUTO_INCREMENT,
  `calleC` VARCHAR(120) NOT NULL,
  `numeroC` INT NOT NULL,
  `coloniaC` VARCHAR(120) NOT NULL,
  `cpC` INT NOT NULL,
  `alcaldiaC` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`idDireccionClin`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `caredate`.`clinica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`clinica` ;

CREATE TABLE IF NOT EXISTS `caredate`.`clinica` (
  `idClinica` INT NOT NULL AUTO_INCREMENT,
  `idDireccionClin` INT NOT NULL,
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
-- Table `caredate`.`direccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`direccion` ;

CREATE TABLE IF NOT EXISTS `caredate`.`direccion` (
  `idDireccion` INT NOT NULL AUTO_INCREMENT,
  `calle` VARCHAR(100) NOT NULL,
  `numero` INT NOT NULL,
  `cp` INT NOT NULL,
  `alcaldía` VARCHAR(40) NOT NULL,
  `colonia` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`idDireccion`),
  CONSTRAINT `idColonia`
    FOREIGN KEY ()
    REFERENCES `caredate`.`colonia` ())
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `caredate`.`paciente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`paciente` ;

CREATE TABLE IF NOT EXISTS `caredate`.`paciente` (
  `idPersona` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NOT NULL,
  `aPaterno` VARCHAR(20) NOT NULL,
  `aMaterno` VARCHAR(20) NOT NULL,
  `curp` VARCHAR(18) NOT NULL,
  `fechaNac` DATE NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  `emailPaciente` VARCHAR(55) NOT NULL,
  PRIMARY KEY (`idPersona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `caredate`.`tipoUsuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`tipoUsuario` ;

CREATE TABLE IF NOT EXISTS `caredate`.`tipoUsuario` (
  `idTipoUsuario` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idTipoUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `caredate`.`medico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`medico` ;

CREATE TABLE IF NOT EXISTS `caredate`.`medico` (
  `idMedico` INT NOT NULL AUTO_INCREMENT,
  `nombreM` VARCHAR(20) NOT NULL,
  `aPaternoM` VARCHAR(20) NOT NULL,
  `aMaternoM` VARCHAR(20) NOT NULL,
  `curpM` VARCHAR(18) NOT NULL,
  `fechaNacM` DATE NOT NULL,
  `sexoM` CHAR(1) NOT NULL,
  `emailMedico` VARCHAR(55) NOT NULL,
  PRIMARY KEY (`idMedico`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idmedico_UNIQUE` ON `caredate`.`medico` (`idMedico` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `caredate`.`personaUsr`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`personaUsr` ;

CREATE TABLE IF NOT EXISTS `caredate`.`personaUsr` (
  `idPerUsr` INT NOT NULL AUTO_INCREMENT,
  `idPersona` INT NOT NULL,
  `idTipoUsuario` INT NOT NULL,
  `idMedico` INT NOT NULL,
  PRIMARY KEY (`idPerUsr`),
  CONSTRAINT `personausr_ibfk_1`
    FOREIGN KEY (`idPersona`)
    REFERENCES `caredate`.`paciente` (`idPersona`),
  CONSTRAINT `personausr_ibfk_2`
    FOREIGN KEY (`idTipoUsuario`)
    REFERENCES `caredate`.`tipoUsuario` (`idTipoUsuario`),
  CONSTRAINT `idMedico`
    FOREIGN KEY (`idMedico`)
    REFERENCES `caredate`.`medico` (`idMedico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `idPersona` ON `caredate`.`personaUsr` (`idPersona` ASC) VISIBLE;

CREATE INDEX `idTipoUsuario` ON `caredate`.`personaUsr` (`idTipoUsuario` ASC) VISIBLE;

CREATE INDEX `idMedico_idx` ON `caredate`.`personaUsr` (`idMedico` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `caredate`.`relDirPer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`relDirPer` ;

CREATE TABLE IF NOT EXISTS `caredate`.`relDirPer` (
  `idRel` INT NOT NULL AUTO_INCREMENT,
  `idDireccion` INT NOT NULL,
  `idPersona` INT NOT NULL,
  PRIMARY KEY (`idRel`),
  CONSTRAINT `reldirper_ibfk_1`
    FOREIGN KEY (`idDireccion`)
    REFERENCES `caredate`.`direccion` (`idDireccion`),
  CONSTRAINT `reldirper_ibfk_2`
    FOREIGN KEY (`idPersona`)
    REFERENCES `caredate`.`paciente` (`idPersona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `idDireccion` ON `caredate`.`relDirPer` (`idDireccion` ASC) VISIBLE;

CREATE INDEX `idPersona` ON `caredate`.`relDirPer` (`idPersona` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `caredate`.`relPacCli`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`relPacCli` ;

CREATE TABLE IF NOT EXISTS `caredate`.`relPacCli` (
  `idRelPC` INT NOT NULL AUTO_INCREMENT,
  `idPersona` INT NOT NULL,
  `idClinica` INT NOT NULL,
  PRIMARY KEY (`idRelPC`),
  CONSTRAINT `relpercli_ibfk_1`
    FOREIGN KEY (`idPersona`)
    REFERENCES `caredate`.`paciente` (`idPersona`),
  CONSTRAINT `relpercli_ibfk_2`
    FOREIGN KEY (`idClinica`)
    REFERENCES `caredate`.`clinica` (`idClinica`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `idPersona` ON `caredate`.`relPacCli` (`idPersona` ASC) VISIBLE;

CREATE INDEX `idClinica` ON `caredate`.`relPacCli` (`idClinica` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `caredate`.`datosPaciente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`datosPaciente` ;

CREATE TABLE IF NOT EXISTS `caredate`.`datosPaciente` (
  `alergias` VARCHAR(120) NOT NULL,
  `medicamentos` VARCHAR(120) NOT NULL,
  `cirugiasPrevias` VARCHAR(120) NOT NULL,
  `idDatosMedicos` INT NOT NULL AUTO_INCREMENT,
  `tipoSangre` VARCHAR(120) NOT NULL,
  `enfermedadesCronicas` VARCHAR(120) NOT NULL,
  `idPersona` INT NOT NULL,
  PRIMARY KEY (`idDatosMedicos`),
  CONSTRAINT `idPersona`
    FOREIGN KEY (`idPersona`)
    REFERENCES `caredate`.`paciente` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `idPersona_idx` ON `caredate`.`datosPaciente` (`idPersona` ASC) VISIBLE;

CREATE UNIQUE INDEX `idDatosMedicos_UNIQUE` ON `caredate`.`datosPaciente` (`idDatosMedicos` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `caredate`.`direccionMed`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`direccionMed` ;

CREATE TABLE IF NOT EXISTS `caredate`.`direccionMed` (
  `idDireccionMed` INT NOT NULL AUTO_INCREMENT,
  `alcaldiaMed` VARCHAR(120) NOT NULL,
  `coloniaMed` VARCHAR(120) NOT NULL,
  `calleMed` VARCHAR(120) NOT NULL,
  `numeroMed` INT NOT NULL,
  `cpMed` INT NOT NULL,
  PRIMARY KEY (`idDireccionMed`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idDireccionMed_UNIQUE` ON `caredate`.`direccionMed` (`idDireccionMed` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `caredate`.`relMedClin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`relMedClin` ;

CREATE TABLE IF NOT EXISTS `caredate`.`relMedClin` (
  `idMedClin` INT NOT NULL AUTO_INCREMENT,
  `idMedico` INT NOT NULL,
  `idDireccionClin` INT NOT NULL,
  PRIMARY KEY (`idMedClin`),
  CONSTRAINT `idMedico`
    FOREIGN KEY (`idMedico`)
    REFERENCES `caredate`.`medico` (`idMedico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idDireccionClin`
    FOREIGN KEY (`idDireccionClin`)
    REFERENCES `caredate`.`direccionClin` (`idDireccionClin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `idMedico_idx` ON `caredate`.`relMedClin` (`idMedico` ASC) VISIBLE;

CREATE INDEX `idDireccionClin_idx` ON `caredate`.`relMedClin` (`idDireccionClin` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `caredate`.`relMedDir`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`relMedDir` ;

CREATE TABLE IF NOT EXISTS `caredate`.`relMedDir` (
  `idMedDir` VARCHAR(45) NOT NULL,
  `idMedico` INT NOT NULL,
  `idDireccionMed` INT NOT NULL,
  PRIMARY KEY (`idMedDir`),
  CONSTRAINT `idMedico`
    FOREIGN KEY (`idMedico`)
    REFERENCES `caredate`.`medico` (`idMedico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idDireccionMed`
    FOREIGN KEY (`idDireccionMed`)
    REFERENCES `caredate`.`direccionMed` (`idDireccionMed`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `idMedico_idx` ON `caredate`.`relMedDir` (`idMedico` ASC) VISIBLE;

CREATE INDEX `idDireccionMed_idx` ON `caredate`.`relMedDir` (`idDireccionMed` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `caredate`.`relPacMed`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`relPacMed` ;

CREATE TABLE IF NOT EXISTS `caredate`.`relPacMed` (
  `idPacMed` INT NOT NULL AUTO_INCREMENT,
  `idMedico` INT NOT NULL,
  `idPersona` INT NOT NULL,
  PRIMARY KEY (`idPacMed`),
  CONSTRAINT `idMedico`
    FOREIGN KEY (`idMedico`)
    REFERENCES `caredate`.`medico` (`idMedico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idPersona`
    FOREIGN KEY (`idPersona`)
    REFERENCES `caredate`.`paciente` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idPacMed_UNIQUE` ON `caredate`.`relPacMed` (`idPacMed` ASC) VISIBLE;

CREATE INDEX `idMedico_idx` ON `caredate`.`relPacMed` (`idMedico` ASC) VISIBLE;

CREATE INDEX `idPersona_idx` ON `caredate`.`relPacMed` (`idPersona` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `caredate`.`gestionCitas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caredate`.`gestionCitas` ;

CREATE TABLE IF NOT EXISTS `caredate`.`gestionCitas` (
  `idGestionCitas` INT NOT NULL AUTO_INCREMENT,
  `diaCita` DATE NOT NULL,
  `horarioCita` TIME NOT NULL,
  `motivoGeneral` VARCHAR(120) NOT NULL,
  `notasMed` VARCHAR(120) NOT NULL,
  `idPacMed` INT NOT NULL,
  PRIMARY KEY (`idGestionCitas`),
  CONSTRAINT `idPacMed`
    FOREIGN KEY (`idPacMed`)
    REFERENCES `caredate`.`relPacMed` (`idPacMed`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idGestionCitas_UNIQUE` ON `caredate`.`gestionCitas` (`idGestionCitas` ASC) VISIBLE;

CREATE INDEX `idPacMed_idx` ON `caredate`.`gestionCitas` (`idPacMed` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
