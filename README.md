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
