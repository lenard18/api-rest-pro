# API REST Pro 🚀

API REST profesional construida con **Spring Boot 3**, autenticación **JWT**, documentación interactiva con **Swagger/OpenAPI** y lista para ejecutar con **Docker**.

Desarrollada por **Leonardo Gómez** como proyecto de portafolio.

---

## 🛠️ Tecnologías

| Tecnología | Versión | Uso |
|---|---|---|
| Java | 21 | Lenguaje |
| Spring Boot | 3.3 | Framework principal |
| Spring Security | 6 | Autenticación y autorización |
| JWT (jjwt) | 0.12.5 | Tokens de acceso |
| Spring Data JPA | 3.3 | Acceso a datos |
| H2 Database | - | Base de datos en memoria |
| Springdoc OpenAPI | 2.5 | Documentación Swagger |
| Lombok | - | Reducción de código boilerplate |
| Docker | - | Contenedorización |

---

## 🚀 Cómo ejecutar

### Opción 1 — Maven (local)
```bash
mvn spring-boot:run
```

### Opción 2 — Docker
```bash
docker-compose up --build
```

La API estará disponible en: `http://localhost:8080`

---

## 📖 Documentación Swagger

Una vez ejecutada la API, abre en tu navegador:

```
http://localhost:8080/swagger-ui.html
```

Desde ahí puedes probar **todos los endpoints** sin necesidad de Postman.

---

## 🔐 Autenticación

### Usuarios de prueba precargados

| Email | Contraseña | Rol |
|---|---|---|
| `admin@demo.com` | `Admin123!` | ADMIN |
| `user@demo.com` | `User123!` | USER |

### Flujo de autenticación

1. **Registro** → `POST /api/auth/register`
2. **Login** → `POST /api/auth/login` → recibes el `token`
3. **Usar token** → En Swagger haz clic en `Authorize 🔒` y pega: `Bearer <tu-token>`

---

## 📌 Endpoints principales

### Auth (público)
| Método | Ruta | Descripción |
|---|---|---|
| POST | `/api/auth/register` | Registrar nuevo usuario |
| POST | `/api/auth/login` | Iniciar sesión |

### Productos (requiere token)
| Método | Ruta | Descripción | Rol requerido |
|---|---|---|---|
| GET | `/api/productos` | Listar todos | USER / ADMIN |
| GET | `/api/productos/{id}` | Obtener por ID | USER / ADMIN |
| GET | `/api/productos/categoria/{cat}` | Filtrar por categoría | USER / ADMIN |
| GET | `/api/productos/buscar?q=laptop` | Buscar por nombre | USER / ADMIN |
| POST | `/api/productos` | Crear producto | **ADMIN** |
| PUT | `/api/productos/{id}` | Actualizar producto | **ADMIN** |
| DELETE | `/api/productos/{id}` | Eliminar producto | **ADMIN** |

### Admin (solo ADMIN)
| Método | Ruta | Descripción |
|---|---|---|
| GET | `/api/admin/usuarios` | Listar todos los usuarios |
| GET | `/api/admin/stats` | Estadísticas del sistema |

---

## 🗂️ Estructura del proyecto

```
src/main/java/com/leonardo/api/
├── config/
│   ├── SecurityConfig.java       # Configuración Spring Security
│   ├── SwaggerConfig.java        # Configuración OpenAPI
│   └── GlobalExceptionHandler.java # Manejo global de errores
├── controller/
│   ├── AuthController.java       # Endpoints de autenticación
│   ├── ProductoController.java   # CRUD de productos
│   └── AdminController.java      # Endpoints de admin
├── dto/
│   ├── AuthRequest.java
│   ├── RegisterRequest.java
│   └── AuthResponse.java
├── entity/
│   ├── User.java                 # Entidad usuario con roles
│   └── Producto.java             # Entidad producto
├── repository/
│   ├── UserRepository.java
│   └── ProductoRepository.java
├── security/
│   ├── JwtService.java           # Generación y validación de tokens
│   └── JwtAuthFilter.java        # Filtro JWT en cada request
└── service/
    ├── AuthService.java          # Lógica de registro y login
    └── ProductoService.java      # Lógica de negocio de productos
```

---

## 👨‍💻 Autor

**Leonardo José Gómez López**
- GitHub: [@lenard18](https://github.com/lenard18)
- LinkedIn: [Leonardo Gómez](https://www.linkedin.com/in/leonardo-jose-gomez-lopez-ba5aaa204/)
- Email: lg358356@gmail.com
