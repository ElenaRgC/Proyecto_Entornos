package Funciones

import Clases.ConexionBD
import Clases.Constantes
import java.sql.SQLException

fun imprimirTablas() { // esta función sirve para mostrar en la consola los nombres de las tablas que están almacenadas en la base de datos a la que se conecta el programa.
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
}