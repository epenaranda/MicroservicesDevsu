create database IF NOT EXISTS microservices;
use microservices; 

-- Crear la tabla Persona
CREATE TABLE IF NOT EXISTS Persona (
    id VARCHAR(36) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    genero CHAR(1) NOT NULL CHECK (genero IN ('M', 'F')),
    edad INT NOT NULL CHECK (edad >= 0 AND edad <= 100),
    identificacion VARCHAR(20) UNIQUE NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(20) NOT NULL
);

-- Crear la tabla Cliente que hereda de Persona
CREATE TABLE IF NOT EXISTS Cliente (
    id VARCHAR(36) PRIMARY KEY,
    contrasena VARCHAR(255) NOT NULL,
    estado VARCHAR(20) NOT NULL CHECK (estado IN ('True', 'False')),
    FOREIGN KEY (id) REFERENCES Persona(id)
     ON DELETE CASCADE
     ON UPDATE CASCADE
);

-- Crear la tabla Cuenta
CREATE TABLE IF NOT EXISTS Cuenta (
    numero_cuenta VARCHAR(36) PRIMARY KEY,
    id_cliente VARCHAR(36) NOT NULL,
    tipo_cuenta VARCHAR(50) NOT NULL,
    saldo_inicial DECIMAL(10, 2) NOT NULL CHECK (saldo_inicial >= 0),
    estado VARCHAR(20) NOT NULL CHECK (estado IN ('True', 'False')),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id)
    ON DELETE CASCADE
     ON UPDATE CASCADE
);

-- Crear la tabla Movimiento
CREATE TABLE IF NOT EXISTS Movimiento (
    id_movimiento VARCHAR(36) PRIMARY KEY,
    numero_cuenta VARCHAR(36) NOT NULL,
    fecha DATE NOT NULL CHECK (fecha >= '1900-01-01'),
    tipo_movimiento VARCHAR(50) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL CHECK (valor > 0),
    saldo DECIMAL(10, 2) NOT NULL CHECK (saldo >= 0),
    FOREIGN KEY (numero_cuenta) REFERENCES Cuenta(numero_cuenta)
    ON DELETE CASCADE
     ON UPDATE CASCADE
);
