# ECI-SportLife_juan-murcia_parcial2
### juan sebastian murcia yanquen

#### 1. Descripción del proyecto

SportLife es una aplicación web tipo MVP que permite a los usuarios:

Registrarse
Consultar productos
Agregar productos al carrito
Realizar pagos

El sistema está basado en una arquitectura REST utilizando Spring Boot.

2. Tecnologías utilizadas
Java 17
Spring Boot
Spring Web
Spring Data JPA
H2 Database (temporal)
MongoDB (pendiente integración)
Swagger / OpenAPI
Maven
Git / GitHub
3. Arquitectura

Se implementa el patrón MVC:

Controller → maneja peticiones HTTP
Service → lógica de negocio
Repository → acceso a datos
Model → entidades
DTO → entrada/salida
4. Funcionalidades implementadas
Usuarios
Registro de usuario
Productos
Crear producto
Listar productos
Buscar por categoría
Buscar por nombre
Consultar por ID

#### 5. Matriz de trazabilidad
ID	Funcionalidad	Prioridad	Depende de
F01	Registro usuario	Alta	-
F02	Listar productos	Alta	-
F03	Crear producto	Alta	-
F04	Buscar productos	Media	F02

#### 6. Endpoints
🔹 Registro de usuario

POST /api/users/register

Idempotente: ❌ No
Descripción: crea un usuario

Request

{
  "name": "sebastian",
  "email": "sebastian@email.com",
  "password": "123456"
}

Response

{
  "id": 1,
  "name": "sebastian",
  "email": "sebastian@email.com",
  "message": "Usuario registrado exitosamente"
}

Códigos

201 Created
400 Bad Request
409 Conflict
🔹 Crear producto

POST /api/products

Idempotente: ❌ No

Request

{
  "name": "Tenis",
  "category": "running",
  "price": 200000,
  "stock": 10,
  "status": "ACTIVE"
}
🔹 Listar productos

GET /api/products

Idempotente: ✔ Sí
🔹 Buscar por categoría

GET /api/products?category=running

🔹 Buscar por nombre

GET /api/products?name=tenis

🔹 Consultar producto por ID

GET /api/products/{id}

#### 7. Validaciones implementadas
Usuario
Nombre obligatorio
Email válido
Email único
Contraseña obligatoria
Producto
Nombre obligatorio
Categoría obligatoria
Precio > 0
Stock >= 0
Estado obligatorio
8. Manejo de errores

Se implementa un manejador global:

Ejemplo:

{
  "message": "El correo ya se encuentra registrado"
}

#### 9. Base de datos
Relacional (H2)
users
products
No relacional (MongoDB)

Pendiente implementación para:

auditoría de pagos
logs
10. Seguridad

Se implementa Spring Security con:

control de endpoints
desactivación de CSRF para pruebas
acceso libre a Swagger
11. Swagger

Disponible en:

http://localhost:8080/swagger-ui/index.html
12. Pruebas

Se realizaron pruebas usando:

Swagger
H2 Console
