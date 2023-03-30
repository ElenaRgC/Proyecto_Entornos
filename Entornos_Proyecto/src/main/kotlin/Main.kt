import Habilidad.*
import Jefe.*
import Pelea.*
import Personaje.*
import java.sql.SQLException

fun main(args: Array<String>) {
    val HabilidadDAO = HabilidadDAOImpl()
    val HabilidadFichero = HabilidadFichero()

    val JefeDAO = JefeDAOImpl()
    val JefeFichero = JefeFichero()

    val PeleaDAO = PeleaDAOImpl()
    val PeleaFichero = PeleaFichero()

    val PersonajeDAO = PersonajeDAOImpl()
    val PersonajeFichero = PersonajeFichero()

    val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)


    conexion.conectar()
    try {
        println("En nuestra base de datos se almacenan las siguientes tablas:")
        val nombreTablas = conexion.devolverTablas()

        for (tabla in nombreTablas) {
            if(!tabla.startsWith("pma__"))
            println(tabla)
        }

    } catch (e: SQLException) {
        println(e.message)
    } finally {
        conexion.desconectar()
    }

    do {
        println("¿Con qué tabla deseas trabajar?")
        var tablaUsuario = readln().trim().lowercase()
        val objetoUsuario = menuTabla(tablaUsuario)

        var opcionUsuario = mostrarMenuOpciones(tablaUsuario)

        ejecutarOpcionMenu(tablaUsuario, opcionUsuario, objetoUsuario)
    } while (opcionUsuario != "5")

}

fun menuTabla(nombreTabla: String): Any {
    var objetoUsuario = Any()

    when (nombreTabla) {
        "habilidad" -> {
            objetoUsuario = HabilidadDAOImpl()
            var habilidad = objetoUsuario.todosLasHabilidades()
            println("Lista de habilidades:")
            habilidad.forEach { println(it) }
            println()
        }

        "jefe" -> {
            objetoUsuario = JefeDAOImpl()
            var jefe = objetoUsuario.todosLosJefes()
            println("Lista de jefes:")
            jefe.forEach { println(it) }
            println()
        }

        "pelea" -> {
            objetoUsuario = PeleaDAOImpl()
            var pelea = objetoUsuario.todosLasPeleas()
            println("Lista de peleas:")
            pelea.forEach { println(it) }
            println()
        }

        "personaje" -> {
            objetoUsuario = PersonajeDAOImpl()
            var personaje = objetoUsuario.todosLosPersonajes()
            println("Lista de personajes:")
            personaje.forEach { println(it) }
            println()
        }

        else -> println("Seleccione una tabla de la lista anterior.")
    }

    return objetoUsuario

}

fun mostrarMenuOpciones(nombreTabla: String): String {
    print("¿Qué quieres hacer con la tabla ${nombreTabla.uppercase()}?")
    println(" (Introduzca la palabra indicada en mayúsculas o su número correspondiente.)")
    println("1. ANADIR un/a $nombreTabla nuevo/a.")
    println("2. BORRAR una fila.")
    println("3. MODIFICAR un campo.")
    println("\n O también:")
    println("4. CAMBIAR a otra tabla.")
    println("5. SALIR del programa.")

    return readln().trim().lowercase()
}

fun ejecutarOpcionMenu(nombreTabla: String, eleccion: String, objeto: Any) {
    when (eleccion) {
        "anadir", "1" -> {

        }

        "borrar", "2" -> {
            println("Introduce el nombre del/de la $nombreTabla que quieres borrar.")
            var nombreElemento = readln().trim().lowercase()
            if (objeto.borrarFila(nombreElemento)) {
                println("$nombreElemento se ha borrado correctamente de la tabla $nombreTabla.")
            } else {
                println("No ha podido eliminarse $nombreElemento de la tabla $nombreTabla.")
            }
        }

        "modificar", "3" -> {

        }

        "cambiar", "4" -> {

        }

        "salir", "5" -> {
            println("Saliendo del programa.")
        }

        else -> println("Seleccione una opción de la lista anterior.")
    }
}



