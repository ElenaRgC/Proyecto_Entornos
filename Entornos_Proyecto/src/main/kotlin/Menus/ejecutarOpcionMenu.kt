package Menus

import Clases.Implementacion

fun ejecutarOpcionMenu(nombreTabla: String, eleccion: String, implementacion: Implementacion): String {

    var nuevaEleccion = ""

    when (eleccion) {
        "anadir", "1" -> {
            println("Introduce el valor de cada campo: ")

        }

        "borrar", "2" -> {
            println("Introduce el nombre del/de la $nombreTabla que quieres borrar.")
            var nombreElemento = readln().trim().lowercase()
            if (implementacion.borrarFila(nombreElemento)) {
                println("$nombreElemento se ha borrado correctamente de la tabla $nombreTabla.")
            } else {
                println("No ha podido eliminarse $nombreElemento de la tabla $nombreTabla.")
            }
        }

        "modificar", "3" -> {
            println("De que fila vas a modificar un campo?")

            println("Que campo quieres modificar?")

            println("Introduce el nuevo valor del campo:")
        }

        "cambiar", "4" -> {
            nuevaEleccion = "4"
        }

        "salir", "5" -> {
            nuevaEleccion = "5"
            println("Saliendo del programa.")
        }

        else -> println("Seleccione una opción de la lista anterior.")
    }

    return nuevaEleccion

}