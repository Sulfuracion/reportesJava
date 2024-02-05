-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS clase;

-- Seleccionar la base de datos
USE clase;

-- Crear la tabla "alumno"
CREATE TABLE IF NOT EXISTS alumno (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Matricula VARCHAR(20) NOT NULL,
    Nombre VARCHAR(100) NOT NULL,
    Sexo ENUM('Masculino', 'Femenino') NOT NULL,
    Email VARCHAR(100),
    Activo BOOLEAN NOT NULL
);

-- Ejemplo de cómo insertar datos en la tabla
INSERT INTO alumno (Matricula, Nombre, Sexo, Email, Activo)
VALUES
    ('2022001', 'Juan Perez', 'Masculino', 'juan@example.com', true),
    ('2022002', 'Maria Rodriguez', 'Femenino', 'maria@example.com', false);
