package Habilidad

import Clases.ConexionBD
import Clases.Constantes
import Clases.Implementacion
import java.sql.PreparedStatement
import java.sql.SQLException

/**
 * Habilidad dao impl
 *
 * Implementación de la interfaz HabilidadDAO que interactúa con la base de datos.
 *
 * @constructor Crea una nueva instancia de la clase
 */
class HabilidadDAOImpl: HabilidadDAO, Implementacion() {
    private val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)

    /**
     * Todos los campos
     *
     * Devuelve una lista de todas las habilidades en la base de datos.
     *
     * @return una lista de habilidades
     */
    override fun todosLosCampos(): List<Habilidad> {
        conexion.conectar()
        val query = Constantes.habilidad_sql_select
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val habilidad = ArrayList<Habilidad>()
        while (rs?.next() == true) {
            val habilidd = Habilidad(rs.getInt(Constantes.nivel), rs.getString(Constantes.nombre), rs.getString(
                Constantes.elemento), rs.getString(Constantes.descripcion),rs.getInt(Constantes.dano),rs.getString(
                Constantes.nombreP))
            habilidad.add(habilidd)
        }
        st?.close()
        conexion.desconectar()
        return habilidad
    }

    /**
     * Insertar fila
     *
     * Insertar una habilidad en la base de datos.
     *
     * @param habilidad la habilidad a insertar
     * @return true si la inserción fue exitosa, false de lo contrario.
     */
    override fun insertarFila(habilidad: Habilidad): Boolean {
        var result: Int? = null
        var ps: PreparedStatement? = null
        try {
            conexion.conectar()
            val query = "INSERT INTO habilidad (nombre, nivel, elemento, descripcion, dano, nom_personaje) VALUES (?, ?, ?, ?, ?, ?)"
            ps = conexion.getPreparedStatement(query)
            ps?.setString(1, habilidad.nombre)
            ps?.setInt(2, habilidad.nivel)
            ps?.setString(3, habilidad.elemento)
            ps?.setString(4, habilidad.descripcion)
            ps?.setInt(5, habilidad.dano)
            ps?.setString(6, habilidad.nombreP)
            result = ps?.executeUpdate()
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            ps?.close()
            conexion.desconectar()
        }
        return result == 1
    }

    /**
     * Recibir descripcion
     *
     * Devuelve la descripción de una habilidad según su nombre.
     *
     * @param nombreHabilidad el nombre de la habilidad.
     * @return la descripción de la habilidad o null si no se encuentra la habilidad.
     */
    override fun recibirDescripcion(nombreHabilidad: String): String? {
        var result: String? = null
        var ps: PreparedStatement? = null
        try {
            conexion.conectar()
            val query = "SELECT descripcion FROM habilidad WHERE nombre = ?"
            ps = conexion.getPreparedStatement(query)
            ps?.setString(1, nombreHabilidad)
            val rs = ps?.executeQuery()
            if (rs?.next() == true) {
                result = rs?.getString("descripcion")
            }
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            ps?.close()
            conexion.desconectar()
        }
        return result
    }

    override fun borrarFila(nombre: String): Boolean {
        conexion.conectar()
        val query = "DELETE FROM habilidad WHERE nombre = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, nombre)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun modificarCampo(nombre: String, nombreCampo: String, nuevoValorCampo: String): Boolean {
        var result: Int? = null
        var ps: PreparedStatement? = null
        try {
            conexion.conectar()
            val query = "UPDATE personaje SET $nombreCampo = ? WHERE LOWER(nombre) = ?"
            ps = conexion.getPreparedStatement(query)
            if (nombreCampo == "nivel" || nombreCampo == "dano") {
                ps?.setInt(1, nuevoValorCampo.toInt())
            } else {
                ps?.setString(1, nuevoValorCampo)
            }
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