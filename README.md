# API REST — Gestión de Docentes y Estudiantes

![Java](https://img.shields.io/badge/Java-17-blue?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.5-brightgreen?logo=springboot)
![H2](https://img.shields.io/badge/H2-Database-blue)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI%203-green?logo=swagger)

API REST para la gestión de **docentes** y **estudiantes**, construida con Spring Boot 4, Spring Data JPA y base de datos H2 en memoria. Incluye documentación interactiva con Swagger UI.

## Integrantes

| Nombre | 
|---|
| Jose Luis Rubio |
| Sebastian Sosa |

---

## Tabla de contenido

- [Tecnologías](#tecnologías)
- [Requisitos previos](#requisitos-previos)
- [Instalación](#instalación)
- [Configuración](#configuración)
- [Ejecución](#ejecución)
- [Documentación API](#documentación-api)
- [Endpoints](#endpoints)
- [Reglas de negocio](#reglas-de-negocio)
- [Códigos de respuesta](#códigos-de-respuesta)
- [Estructura del proyecto](#estructura-del-proyecto)

---

## Tecnologías

| Tecnología | Versión |
|---|---|
| Java | 17 |
| Spring Boot | 4.0.5 |
| Spring Data JPA | Incluido en Boot |
| H2 Database | En memoria (runtime) |
| Springdoc OpenAPI | 2.8.9 |

---

## Requisitos previos

- [Java 17+](https://adoptium.net/)
- Maven (incluido via `mvnw`)

> No requiere base de datos externa. H2 se crea automáticamente en memoria al iniciar.

---

## Instalación

**1. Clonar el repositorio**

```bash
git clone <url-del-repositorio>
cd G01-APOO-26-1-feature-cmedina
```

**2. No se requiere configuración de base de datos**

Las tablas se crean automáticamente desde las clases `@Entity` al iniciar la aplicación.

---

## Configuración

El archivo de configuración está en [`tutoria03/src/main/resources/application.properties`](tutoria03/src/main/resources/application.properties).

```properties
spring.datasource.url=jdbc:h2:mem:grupo01
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
server.port=8089
```

> No requiere instalación de base de datos. Los datos se almacenan en memoria y se reinician con cada arranque.

---

## Ejecución

```bash
cd tutoria03
./mvnw spring-boot:run
```

Servidor disponible en: `http://localhost:8089`

---

## Documentación API

Swagger UI disponible en:

```
http://localhost:8089/swagger-ui/index.html
```

Desde Swagger puedes probar todos los endpoints directamente en el navegador sin necesidad de Postman.

---

## Endpoints

### Docentes — `/docentes`

| Método | URL | Descripción | Respuesta |
|--------|-----|-------------|-----------|
| `GET` | `/docentes` | Listar todos los docentes | `200 OK` |
| `GET` | `/docentes/{id}` | Obtener docente por ID | `200 OK` |
| `POST` | `/docentes` | Crear un docente | `201 Created` |
| `PUT` | `/docentes/{id}` | Actualizar docente por ID | `200 OK` |
| `DELETE` | `/docentes/{id}` | Eliminar docente por ID | `204 No Content` |

**Body — POST / PUT**

```json
{
  "numeroDocumento": "123456789",
  "tipoDocumento": "CC",
  "nombres": "Juan Carlos",
  "apellidos": "García López",
  "correo": "jgarcia@universidad.edu.co",
  "especialidad": "Programación Orientada a Objetos",
  "activo": true
}
```

> Tipos de documento válidos: `CC` · `TI` · `CE` · `Pasaporte`

---

### Estudiantes — `/estudiantes`

| Método | URL | Descripción | Respuesta |
|--------|-----|-------------|-----------|
| `GET` | `/estudiantes` | Listar todos los estudiantes | `200 OK` |
| `GET` | `/estudiantes/{id}` | Obtener estudiante por ID | `200 OK` |
| `POST` | `/estudiantes` | Crear un estudiante | `200 OK` |
| `PUT` | `/estudiantes/{id}` | Actualizar estudiante | `200 OK` |
| `DELETE` | `/estudiantes/{id}` | Eliminar estudiante | `204 No Content` |

---

## Reglas de negocio

- No se puede registrar un docente con el mismo `tipoDocumento` y `numeroDocumento` — retorna `409 Conflict`.
- Para actualizar o eliminar un docente, debe existir previamente (verificado por ID) — retorna `404 Not Found` si no existe.

---

## Códigos de respuesta

| Código | Significado |
|--------|-------------|
| `200 OK` | Operación exitosa |
| `201 Created` | Recurso creado |
| `204 No Content` | Eliminado correctamente |
| `404 Not Found` | Recurso no encontrado |
| `409 Conflict` | Documento duplicado |

---

## Estructura del proyecto

```
tutoria03/
└── src/main/java/com/example/tutoria03/
    ├── controllers/
    │   ├── DocenteController.java
    │   └── EstudianteController.java
    ├── exceptions/
    │   ├── DocenteDuplicadoException.java
    │   ├── DocenteNoEncontradoException.java
    │   └── GlobalExceptionHandler.java
    ├── models/
    │   ├── Docente.java
    │   └── Estudiante.java
    ├── repositories/
    │   ├── IDocenteRepository.java
    │   └── IEstudianteRepository.java
    ├── services/
    │   ├── DocenteService.java
    │   └── EstudianteService.java
    └── Tutoria03Application.java
```
