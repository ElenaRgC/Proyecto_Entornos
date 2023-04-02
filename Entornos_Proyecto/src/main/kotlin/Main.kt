import Clases.ConexionBD
import Clases.Constantes
import Funciones.ejecutarOpcionMenu
import Funciones.imprimirTablas
import Funciones.menuTabla
import Funciones.mostrarMenuOpciones
import java.sql.SQLException

fun main() {

    do {
        imprimirTablas()
        println("¿Con qué tabla deseas trabajar?")
        var tablaUsuario = readln().trim().lowercase()
        val objetoUsuario = menuTabla(tablaUsuario)
        var opcionUsuario = mostrarMenuOpciones(tablaUsuario)

        ejecutarOpcionMenu(tablaUsuario, opcionUsuario, objetoUsuario)
    } while (opcionUsuario != "5" && opcionUsuario != "salir")

}




