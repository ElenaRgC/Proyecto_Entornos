import Clases.ConexionBD
import Clases.Constantes
import Habilidad.*
import Jefe.*
import Menus.ejecutarOpcionMenu
import Menus.menuTabla
import Menus.mostrarMenuOpciones
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
    } while (opcionUsuario != "5" && opcionUsuario != "salir")

}




