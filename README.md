# Índice

## 1. Miembros del equipo
- [Patricia](https://github.com/patrimj)
- [Marina](https://github.com/demon-for-arcangel)
- [Ian](https://github.com/Hellrayser)
- [Elena](https://github.com/ElenaRgC)

## 2. Descripción de la base de datos
- Explicación de la temática de la base de datos.
- Lista de las tablas.
- Diagrama Entidad-Relación.
- Esquema relacional.

La temática de esta base de datos se enfoca en el videojuego Diablo IV, un juego de rol y acción en el que los jugadores pueden crear y personalizar sus personajes para explorar un mundo oscuro y peligroso lleno de monstruos y enemigos. En este juego, los jugadores pueden adquirir habilidades y armas para mejorar sus personajes y enfrentarse a jefes y enemigos más poderosos.

La base de datos está diseñada para almacenar información sobre diferentes aspectos del juego que pueden ser modificados por el jugador. 

Las tablas incluidas son:

- La tabla "Pelea" almacena información sobre las diferentes peleas que se llevan a cabo en el juego, incluyendo el nombre del personaje y el nombre del jefe al que dicho personaje se va a enfrentar.

- La tabla "Personaje" almacena información sobre los personajes del jugador, incluyendo su nombre, nivel, clase y una breve descripción de sus capacidades.

- La tabla "Jefe" almacena información sobre los jefes del juego, incluyendo su nombre, nivel de dificultad, carga de vida, tipo de dificultad y una breve descripción de sus destrezas.

- La tabla "Habilidad" almacena información sobre las habilidades que los personajes pueden adquirir y mejorar a medida que avanzan en el juego. Esto incluye el nombre de la habilidad, el nivel de poder, el elemento necesario para adquirirla, una breve descripción,  su efecto en la pelea y el nombre del personaje que emplea esa habilidad.

En resumen, la base de datos de Diablo IV está diseñada para ayudar a los jugadores a realizar modificaciones y personalizar sus personajes y habilidades en el juego, así como para almacenar información sobre las diferentes peleas y jefes a los que se enfrentan.


## 3. Descripción general del programa en Kotlin

• OBJETIVO Y FUNCIONALIDADES DEL PROGRAMA.
Nuestro programa permite a jugadores de Diablo IV registrar en una base de datos sus personajes, habilidades, enemigos principales y qué personajes se han enfrentado a ellos.
Cuando ejecuten el programa se les mostrará la lista de las tablas existentes y se les permitirá elegir con cuál quieren trabajar. Una vez elegida una tabla de las presentadas, podrán ver, añadir, modificar o eliminar datos de las mismas.

• CLASES E INTERFACES:
- Constantes: contiene los valores que no van a cambiar a lo largo del programa y vamos a usar con frecuencia, como los valores de acceso a la base de datos o los campos de las tablas. Permiten centralizar las constantes para poder cambiarlas en todo el proyecto a la vez si es necesario.
- ConexionBD: permite conectar a la base de datos MySQL que definamos, así como crear las queries y lanzarlas desde otras funciones que llamen a un objeto de esta clase.
- Fila: clase padre del resto de filas, que permite usar en una mismo objeto funciones de diferentes clases.
- Personaje, habilidad, jefe y pelea. Estas clases heredan de la clase Fila, y tienen como parámetros los campos que existen en las tablas de la base de datos con las que comparten nombre.
- Implementación: clase padre de las DAO implementadas, al igual que la clase Fila permite usar funciones del mismo nombre y clases distintas con el mismo objeto.
- Interfaces DAO: permiten definir las funciones que emplearemos para realizar las consultas SQL como plantilla, evitando errores y creando un punto central en el que realizar modificaciones si la tabla cambia su estructura.
- Clases DAO Implementadas: implementan las interfaces de DAO siguiendo la estructura de métodos indicada, conteniendo el código que permite conectar a la base de datos y ejecutar las consultas deseadas.

...MÁS DOCUMENTADO EN LA ENTREGA

## 4. Documentación técnica
- Conexión con la base de datos mediante JDBC.
- Diagrama (o índice o cómo sea) de los parámetros y funciones de cada clase.
- Explicación de las funciones más importantes.
  - Conexión a la base de datos.
  - Añadir filas.
  - Modificar campos.
  - Borrar filas.
  - Menús.

## 5. Documentación del cliente
- Explicación de cómo utilizar el programa.
- Ejemplos de uso del programa.

## 6. Rama de refactorización

## 7. Rama de documentación

## 8. Rama de pruebas unitarias
