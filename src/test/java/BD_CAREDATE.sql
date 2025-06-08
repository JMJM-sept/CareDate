create database caredate;

use caredate;

create table persona (
idPersona int primary key,
nombre varchar(20),
aPaterno varchar(20),
aMaterno varchar(20),
curp varchar(18),
fechaNac date,
sexo char(1)
);
alter table persona add column idDireccion int,
 add constraint foreign key (idDireccion)
 references direccion(idDireccion);
 
show tables;
select * from persona;


create table direccion (
idDireccion int primary key,
calle varchar(40),
numero int(10),
colonia varchar(40),
cp int(5),
municipio varchar(20),
estado varchar(20)
);

select * from direccion;

create table catalogoContacto (
idContacto int primary key,
tipoContacto varchar(25)
);

create table relCtoPer (
idRel int primary key,
descr varchar(30),
idPersona int,
		foreign key (idPersona) references persona(idPersona),
idContacto int,
		foreign key (idContacto) references catalogoContacto(idContacto)
);

create table tipoUsuario (
idTipoUsuario int primary key,
usuario varchar(15)
);

create table personaUsr (
idPerUsr int primary key,
idPersona int,
		foreign key (idPersona) references persona(idPersona),
idTipoUsuario int,
		foreign key (idTipoUsuario) references tipoUsuario(idTipoUsuario)
);

create table cedulaMed (
idCedMed int primary key,
idPersona int,
		foreign key (idPersona) references persona(idPersona),
cedula int(10)
);

create table relDirPer (
idRel int primary key,
idDireccion int,
		foreign key (idDireccion) references direccion(idDireccion),
idPersona int,
		foreign key (idPersona) references persona(idPersona)
);

show tables;

create table direccionClin (
idDireccionClin int primary key,
calleC varchar(40),
numeroC int(10),
coloniaC varchar(40),
cpC int(5),
municipioC varchar(20),
estadoC varchar(20)
);

create table clinica (
idClinica int primary key,
idDireccionClin int,
		foreign key (idDireccionClin) references direccionClin(idDireccionClin)
);

create table consultorio (
idConsultorio int primary key,
noConsultorio int(3),
idClinica int,
		foreign key (idClinica) references clinica(idClinica)
);

create table relPerCli (
idRelPC int primary key,
idPersona int,
		foreign key (idPersona) references persona(idPersona),
idClinica int,
		foreign key (idClinica) references clinica(idClinica)
);

