# BibliotecaGSON

Aplicación de consola en Java que gestiona una biblioteca de películas nominadas al oscar o ganadoras de oscar usando un fichero JSON como almacenamiento persistente.

---

## ¿Qué hace el programa?

Permite gestionar películas desde la consola: crear, listar, modificar, eliminar y buscar basado en los requisitos de la tarea. Todos los datos se guardan automáticamente en el archivo `peliculas.json` y se mantienen entre ejecuciones.

La clase película tiene: **ID, título, director, año, si es ganadora de oscar y categoría**.

---

## Requisitos

- Java 25 o superior
- Maven

---

## Instalación y uso

**1. Clona el repositorio**
```
git clone https://github.com/NatalyIpiales/BibliotecaGSON.git
```

**2. Entra en la carpeta del proyecto**
```
cd BibliotecaGSON
```

**3. Compila el proyecto con Maven**
```
mvn compile
```

**4. Ejecuta el programa**
```
Ejecutar `Main.java`.
```

---

## Menú principal

```
=== BIBLIOTECA DE PELÍCULAS ===
1. Listar todas
2. Añadir película
3. Modificar película
4. Eliminar película
5. Buscar por ID
0. Salir
```

Escribe el número de la opción y sigue las instrucciones en pantalla. Los cambios se guardan solos en `peliculas.json`.

---

## Tecnologías

- Java
- Maven
- [Gson](https://github.com/google/gson)

---

## Autores

- [Gabye80](https://github.com/Gabye80)
- [NatalyIpiales](https://github.com/NatalyIpiales)
