# altioracorp-prueba-tecnica

Este proyecto es una prueba técnica para AltioraCorp, construido utilizando Spring Boot y una base de datos PostgreSQL.
Utiliza Docker para la gestión de contenedores y se puede ejecutar usando Docker Compose.

## Requisitos

Para ejecutar este proyecto en tu máquina local, necesitas tener instalado:

- Docker
- Docker Compose

## Ejecución

Sigue estos pasos para ejecutar el proyecto:

1. Clona el repositorio desde GitHub:

   ```bash
   git clone https://github.com/Fernando473/altioracorp-prueba-tecnica.git
2. Navega al directorio del proyecto

   ```bash
   cd altioracorp-prueba-tecnica
3. Ejecuta Docker Compose para construir y levantar los contenedores:

   ```bash
    docker-compose up --build
4. Una vez que los contenedores estén en ejecución, la aplicación estará disponible en:
    ```bash
    http://localhost:8080

## Notas Adicionales

- Asegúrate de tener los puertos necesarios abiertos y sin conflictos en tu máquina local para ejecutar Docker Compose
  sin problemas.
- Puedes modificar la configuración de la base de datos en el archivo `application.properties`  en `src/main/resources`
  según sea necesario (por ejemplo, ajustar las credenciales de conexión). Por defecto al
  ejecutar `docker compose up --build` se crea una base de datos y se conecta a la aplicación