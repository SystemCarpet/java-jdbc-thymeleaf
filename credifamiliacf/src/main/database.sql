CREATE TABLE ciudad (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre_ciudad VARCHAR(50) NOT NULL
);

CREATE TABLE clientes (
  numero_documento INT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  apellido VARCHAR(50) NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  ciudad_id INT NOT NULL,
  correo_electronico VARCHAR(50) NOT NULL,
  telefono VARCHAR(10),
  ocupacion VARCHAR(50),
  viable BOOL NOT NULL,
  FOREIGN KEY (ciudad_id) REFERENCES ciudad(id)

);

