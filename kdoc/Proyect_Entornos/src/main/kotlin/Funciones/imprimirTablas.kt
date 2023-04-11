package Funciones

import Clases.ConexionBD
import Clases.Constantes
import java.sql.SQLException

/**
 * Imprimir tablas
 *
 * Imprime los nombres de las tablas almacenadas en la base de datos a la que se conecta el programa.
 * La función se encarga de crear una instancia de la clase ConexionBD con las credenciales de acceso a la base de datos y establecer una conexión.
 * LLama al método devolverTablas() de la instancia de ConexionBD para obtener una lista con los nombres de las tablas almacenadas en la base de datos.
 * La función filtra las tablas cuyo nombre comienza con "pma__" y, para el resto de tablas, imprime el nombre por la consola.
 * @throws SQLException si ocurre un error al acceder a la base de datos.
 */
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