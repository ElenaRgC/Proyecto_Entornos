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
        "habilidad" -> {objetoUsuario = HabilidadDAOImpl()}
        "jefe" -> {objetoUsuario = JefeDAOImpl()}
        "pelea" -> {objetoUsuario = PeleaDAOImpl()}
        "personaje" -> {objetoUsuario = PersonajeDAOImpl()}
        else -> println("Seleccione una tabla de la lista anterior.")
    }

    objetoUsuario.todasLasHabilidades()

    println("¿Qué quieres hacer con la tabla $tablaUsuario?")
    println("Introduzca la palabra indicada en mayúsculas.")
    println("ANADIR un/a $tablaUsuario nuevo/a.")
    println("BORRAR una fila.")

}



