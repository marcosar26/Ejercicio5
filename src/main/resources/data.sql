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

-- Insertar reservas para el cliente 1
INSERT INTO Reserva (id, cliente_id, habitacion_id, fecha_checkin, fecha_checkout)
VALUES (1, 1, 1, '2024-06-01 14:00:00', '2024-06-05 12:00:00'),
       (2, 1, 2, '2024-07-01 14:00:00', '2024-07-05 12:00:00'),
       (3, 1, 3, '2024-08-01 14:00:00', '2024-08-05 12:00:00');

-- Insertar reservas para el cliente 2
INSERT INTO Reserva (id, cliente_id, habitacion_id, fecha_checkin, fecha_checkout)
VALUES (4, 2, 4, '2024-06-10 14:00:00', '2024-06-15 12:00:00'),
       (5, 2, 5, '2024-07-10 14:00:00', '2024-07-15 12:00:00');

-- Insertar reservas para el cliente 5
INSERT INTO Reserva (id, cliente_id, habitacion_id, fecha_checkin, fecha_checkout)
VALUES (6, 5, 1, '2024-09-01 14:00:00', '2024-09-05 12:00:00'),
       (7, 5, 2, '2024-10-01 14:00:00', '2024-10-05 12:00:00'),
       (8, 5, 3, '2024-11-01 14:00:00', '2024-11-05 12:00:00'),
       (9, 5, 4, '2024-12-01 14:00:00', '2024-12-05 12:00:00');