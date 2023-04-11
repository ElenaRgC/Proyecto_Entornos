import Funciones.*

/**
 * Main
 *
 */
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