package Funciones

import Clases.ConexionBD
import Clases.Constantes
import java.sql.PreparedStatement

/**
 * Obtener columnas
 *
 * Función para obtener el nombre de las columnas de una tabla en una base de datos.
 *
 * @param nombreTabla El nombre de la tabla de la que se queiren obtener las columnas.
 * @return Una lista de strings con los nombres de las columnas.
 */
fun obtenerColumnas(nombreTabla: String): List<String> {
    val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    val columnas = mutableListOf<String>()
    val query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ?;"
    var ps: PreparedStatement? = null

    conexion.conectar()
    ps = conexion.getPreparedStatement(query)
    ps?.setString(1, nombreTabla)
    val resultado = ps?.executeQuery()
    while (resultado?.next() == true) {
        columnas.add(resultado.getString("COLUMN_NAME"))
    }
    ps?.close()
    conexion.desconectar()
    return columnas
}
