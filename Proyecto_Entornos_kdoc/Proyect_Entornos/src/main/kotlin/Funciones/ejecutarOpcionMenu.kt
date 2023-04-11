package Funciones

import Clases.Implementacion
import java.sql.SQLException

/**
 * Ejecutar opcion menu
 *
 * Ejecuta la opción de menú elegida por el usuario en una tabla específica.
 *
 * @param nombreTabla El nombre de la tabla en la que se va a operar.
 * @param eleccion La opción de menú seleccionada por el usuario.
 * @param implementacion La implementación de la tabla que se va a utilizar.
 * @return La nueva opción de menú seleccionada por el usuario
 */
// esta función se encarga de ejecutar la opción de menú elegida por el usuario en una tabla específica.
fun ejecutarOpcionMenu(nombreTabla: String, eleccion: String, implementacion: Implementacion): String {

    var nuevaEleccion = ""
    var filaVacia = seleccionarTipoFila(nombreTabla)
    val columnas = obtenerColumnas(nombreTabla)

    when (eleccion) {
        "anadir", "1" -> {
            println("Introduce el valor de cada campo: ")
            val valores = ArrayList<Implementacion>()
            var fila = filaVacia
            var i = 0

            for (columna in columnas) {
                print("Introduce el valor para la columna $columna: ")
                var campoUsuario = readln().trim().lowercase()
                introducirCampoEnFila(fila, i, campoUsuario)
                i++
            }

            println(fila)
            println(implementacion)

            try {
                implementacion.insertarFila(fila)
                println("La fila se ha añadido correctamente.")
            } catch(e: SQLException) {
                println(e.message)
                println("No se ha podido añadir la fila.")
            }
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
            implementacion.todosLosCampos()
            println("Di su clave principal, normalmente el nombre.")
            var clavePrincipal = readln().trim().lowercase()

            println("Estos son los campos de $nombreTabla")
            for (columna in columnas) {
                print(columna + ", ")
            }
            println("que campo quieres modificar?")
            var nombreCampo = readln().trim().lowercase()

            println("Introduce el nuevo valor del campo:")
            var valorCampo = readln().trim().lowercase()

            try {
                implementacion.modificarCampo(clavePrincipal, nombreCampo, valorCampo)
                println("El campo se ha modificado correctamente.")
            } catch (e: Exception) {
                println(e.message)
                println("No ha sido posible modificar el campo.")
            }
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