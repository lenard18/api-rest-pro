-- Usuarios de prueba (contraseña: Admin123! y User123!)
INSERT INTO users (nombre, email, password, rol) VALUES
  ('Leonardo Gómez', 'admin@demo.com', '$2a$10$N.zmdr9zkoa05nK9RiqZYO8rr4jzJiMlmBRKzXhj7DU2iGIGMFBKi', 'ADMIN'),
  ('María López',    'user@demo.com',  '$2a$10$8K1p/a0dR1PExNjyQbS2xOmNixMKPJvKqsLBJu5f9tBm0c0r7AQia', 'USER');

-- Productos de ejemplo
INSERT INTO productos (nombre, descripcion, precio, stock, categoria) VALUES
  ('Laptop Dell XPS',      'Laptop profesional 16GB RAM, 512GB SSD', 3200000, 10, 'ELECTRONICA'),
  ('Mouse Logitech MX',    'Mouse inalámbrico ergonómico',            180000,  50, 'ACCESORIOS'),
  ('Monitor Samsung 27"',  'Monitor Full HD IPS 144Hz',               850000,  15, 'ELECTRONICA'),
  ('Teclado Mecánico',     'Teclado mecánico RGB switches Blue',      250000,  30, 'ACCESORIOS'),
  ('Silla Ergonómica',     'Silla de oficina con soporte lumbar',    1200000,   8, 'MOBILIARIO'),
  ('Webcam Logitech C920', 'Webcam HD 1080p para videollamadas',     320000,  20, 'ACCESORIOS');
