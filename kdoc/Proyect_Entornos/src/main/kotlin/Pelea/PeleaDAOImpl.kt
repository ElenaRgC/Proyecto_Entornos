package Pelea

import Clases.ConexionBD
import Clases.Constantes
import Clases.Implementacion
import java.sql.PreparedStatement
import java.sql.SQLException

/**
 * Pelea dao impl
 *
 * @constructor Crea uan instancia de la clase PeleaDAOImpl
 */
class PeleaDAOImpl: PeleaDAO, Implementacion(){
    private val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)

    /**
     * Todos los campos
     *
     * @return una lista de objetos Pelea que contiene los datos obtenidos de la tabla pelea.
     */
    override fun todosLosCampos(): List<Pelea> {
        conexion.conectar()
        val query = Constantes.pelea_sql_select
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val pelea = ArrayList<Pelea>()
        while (rs?.next() == true) {
            val pelee = Pelea(rs.getString(Constantes.nombrePP), rs.getString(Constantes.nombreJJ))
            pelea.add(pelee)
        }
        st?.close()
        conexion.desconectar()
        return pelea
    }

    /**
     * Insertar fila
     *
     * @param pelea un objeto Pelea que contiene los datos a insertar en la tabla pelea.
     * @return true si la inserción fue exitosa, false en caso contrario.
     */
    override fun insertarFila(pelea: Pelea): Boolean {
        var result: Int? = null
        var ps: PreparedStatement? = null
        try {
            conexion.conectar()
            val query = "INSERT INTO habilidad (nombrePP, nombreJJ) VALUES (?, ?)"
            ps = conexion.getPreparedStatement(query)
            ps?.setString(1, pelea.nombrePP)
            ps?.setString(2, pelea.nombreJJ)
            result = ps?.executeUpdate()
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            ps?.close()
            conexion.desconectar()
        }
        return result != null && result > 0
    }

    /**
     * Borrar fila
     *
     * @param nombre un String que contiene el nombre del personaje o jefe a borrar de la tabla pelea.
     * @return true si el borrado fue exitoso, false en caso contrario.
     */
    override fun borrarFila(nombre: String): Boolean {
        conexion.conectar()
        val query = "DELETE FROM pelea WHERE (nom_personaje = ? OR nom_jefe = ?)"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, nombre)
        ps?.setString(2, nombre)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    /**
     * Modificar campo
     *
     * @param nombre un String que contiene el nombre del personaje o jefe a modificar.
     * @param nombreCampo un String que contiene el nombre del campo a modificar.
     * @param nuevoValorCampo un String que contiene el nuevo valor del campo a modificar.
     * @return true si la modificación fue exitosa, false en caso contrario.
     */
    override fun modificarCampo(nombre: String, nombreCampo: String, nuevoValorCampo: String): Boolean {
        var result: Int? = null
        var ps: PreparedStatement? = null
        try {
            conexion.conectar()
            val query = "UPDATE personaje SET $nombreCampo = ? WHERE (LOWER(nom_personaje) = ? OR LOWER(nom_jefe) = ?)"
            ps = conexion.getPreparedStatement(query)
            ps?.setString(1, nuevoValorCampo)
            ps?.setString(2, nombre)
            result = ps?.executeUpdate()
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            ps?.close()
            conexion.desconectar()
        }
        return result == 1
    }

}