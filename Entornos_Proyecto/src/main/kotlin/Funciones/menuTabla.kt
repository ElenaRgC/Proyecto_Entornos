package Funciones

import Clases.Fila
import Clases.Implementacion
import Habilidad.HabilidadDAOImpl
import Jefe.JefeDAOImpl
import Pelea.PeleaDAOImpl
import Personaje.PersonajeDAOImpl

fun menuTabla(nombreTabla: String): Implementacion {
    var objetoUsuario = Implementacion()
    var fila = listOf<Fila>()

    when (nombreTabla) {
        "habilidad" -> {
            objetoUsuario = HabilidadDAOImpl()
            fila = objetoUsuario.todosLosCampos()
        }

        "jefe" -> {
            objetoUsuario = JefeDAOImpl()
            fila = objetoUsuario.todosLosCampos()
        }

        "pelea" -> {
            objetoUsuario = PeleaDAOImpl()
            fila = objetoUsuario.todosLosCampos()
        }

        "personaje" -> {
            objetoUsuario = PersonajeDAOImpl()
            fila = objetoUsuario.todosLosCampos()
        }

        else -> println("Seleccione una tabla de la lista anterior.")
    }

    println("Lista de $nombreTabla:")
    fila.forEach { println(it) }
    println()

    return objetoUsuario

}