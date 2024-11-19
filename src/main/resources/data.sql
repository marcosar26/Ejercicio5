-- Insertar clientes
INSERT INTO Cliente (id, nombre, apellido, correo, telefono, pais_origen)
VALUES (1, 'Juan', 'Perez', 'juan.perez@example.com', 123456789, 'España'),
       (2, 'Maria', 'Gomez', 'maria.gomez@example.com', 987654321, 'México'),
       (3, 'Carlos', 'Rodriguez', 'carlos.rodriguez@example.com', 555123456, 'Argentina'),
       (4, 'Ana', 'Lopez', 'ana.lopez@example.com', 444987654, 'Colombia'),
       (5, 'Luis', 'Martinez', 'luis.martinez@example.com', 333678901, 'Chile');

-- Insertar habitaciones
INSERT INTO Habitacion (id, numero, tipo, capacidad, precio, disponible)
VALUES (1, 101, 'Simple', 1, 50.0, TRUE),
       (2, 102, 'Doble', 2, 75.0, TRUE),
       (3, 103, 'Suite', 3, 120.0, TRUE),
       (4, 104, 'Deluxe', 2, 100.0, TRUE),
       (5, 105, 'Presidencial', 5, 300.0, TRUE);
