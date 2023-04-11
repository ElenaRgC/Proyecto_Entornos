package Funciones

import Clases.Fila
import Clases.Implementacion
import Habilidad.HabilidadDAOImpl
import Jefe.JefeDAOImpl
import Pelea.PeleaDAOImpl
import Personaje.PersonajeDAOImpl

/**
 * Menu tabla
 *
 * @param nombreTabla El nombre de la tabla seleccionada por el usuario.
 * @return La instancia de la clase Implementación que se corresponde con la tabla seleccionada.
 */
//es una función que permite al usuario seleccionar una tabla de la base de datos y devolverle las diferentes funciones que se encuentran en la clase Implementacion
fun menuTabla(nombreTabla: String): Implementacion {
    var objetoUsuario = Implementacion()
    var fila = listOf<Fila>()

    do {
        var continuar = true
        when (nombreTabla) {
            "habilidad" -> {
                objetoUsuario = HabilidadDAOImpl()
                fila = objetoUsuario.todosLosCampos()
                continuar = false
            }

            "jefe" -> {
                objetoUsuario = JefeDAOImpl()
                fila = objetoUsuario.todosLosCampos()
                continuar = false
            }

            "pelea" -> {
                objetoUsuario = PeleaDAOImpl()
                fila = objetoUsuario.todosLosCampos()
                continuar = false
            }

            "personaje" -> {
                objetoUsuario = PersonajeDAOImpl()
                fila = objetoUsuario.todosLosCampos()
                continuar = false
            }

            else -> println("Seleccione una tabla de la lista anterior.")
        }
    } while (continuar)

    println("Lista de $nombreTabla:")
    fila.forEach { println(it) }
    println()

    return objetoUsuario

}