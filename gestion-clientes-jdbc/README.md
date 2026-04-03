# Gestion de Clientes con Java, JDBC y MySQL

Aplicacion de consola desarrollada en Java para gestionar clientes mediante operaciones CRUD, utilizando JDBC para conectarse a una base de datos MySQL.

## Objetivo del proyecto

Este proyecto fue construido para fortalecer fundamentos clave de backend con Java:

- programacion orientada a objetos
- operaciones CRUD
- integracion con bases de datos relacionales
- uso de JDBC con `PreparedStatement` y `ResultSet`
- manejo seguro de recursos con `try-with-resources`
- organizacion basica por paquetes

## Tecnologias utilizadas

- Java 17
- JDBC
- MySQL
- Maven
- IntelliJ IDEA

## Funcionalidades

- Registrar clientes
- Listar clientes almacenados
- Buscar clientes por ID
- Actualizar informacion de clientes
- Eliminar clientes
- Navegar las operaciones desde un menu por consola
- Validar entradas numericas para evitar errores en ejecucion

## Estructura del proyecto

```text
src/main/java/com/sebastian/gestionclientes
├── config
│   └── ConexionDB.java
├── dao
│   └── ClienteDAO.java
├── model
│   └── Cliente.java
└── Main.java
```

## Base de datos

Nombre de la base de datos:

```sql
portafolio_java_clientes
```

Tabla principal:

```sql
CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    correo VARCHAR(150) NOT NULL UNIQUE,
    telefono VARCHAR(20),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## Como ejecutar el proyecto

1. Crear la base de datos y la tabla `clientes` en MySQL.
2. Configurar usuario y contrasena en `ConexionDB.java`.
3. Ejecutar el proyecto desde IntelliJ o con Maven.
4. Usar el menu de consola para probar las operaciones CRUD.

## Aprendizajes aplicados

- Modelado de una entidad Java a partir de una tabla SQL
- Uso de `PreparedStatement` para consultas parametrizadas
- Lectura de resultados con `ResultSet`
- Reutilizacion de logica de mapeo en el DAO
- Manejo automatico de conexiones con `try-with-resources`
- Separacion basica de responsabilidades entre modelo, configuracion, acceso a datos y menu

## Mejoras futuras

- Separar interfaz e implementacion del DAO
- Agregar validaciones mas fuertes para correo y campos vacios
- Externalizar credenciales con variables de entorno o archivo de configuracion
- Migrar la aplicacion a una API REST con Spring Boot

## Autor

Sebastian Ramirez
