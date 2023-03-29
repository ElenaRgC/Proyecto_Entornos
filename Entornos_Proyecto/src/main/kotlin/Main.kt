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

    println("¿Con qué tabla deseas trabajar?")
    val tablaUsuario = readln().trim().lowercase()
    var objetoUsuario = Any()

    when (tablaUsuario) {
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
            pelea.forEach {println(it)}
            println()
        }
        "personaje" -> {
            objetoUsuario = PersonajeDAOImpl()
            var personaje = objetoUsuario.todosLosPersonajes()
            println("Lista de personajes:")
            personaje.forEach {println(it)}
            println()
        }
        else -> println("Seleccione una tabla de la lista anterior.")
    }

    print("¿Qué quieres hacer con la tabla ${tablaUsuario.uppercase()}?")
    println(" (Introduzca la palabra indicada en mayúsculas o su número correspondiente.)")
    println("1. ANADIR un/a $tablaUsuario nuevo/a.")
    println("2. BORRAR una fila.")
    println("3. MODIFICAR un campo.")
    println("\n O también:")
    println("CAMBIAR a otra tabla.")
    println("SALIR del programa.")

    var opcionUsuario = readln().trim().lowercase()

    when (opcionUsuario) {
        "anadir", "1" -> {}
        "borrar", "2" -> {}
        "modificar", "3" -> {}
        "cambiar" -> {}
        "salir" -> {}
        else -> println("Seleccione una opción de la lista anterior.")
    }

}



