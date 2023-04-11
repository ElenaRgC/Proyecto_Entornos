package Jefe

import Clases.ConexionBD
import Clases.Constantes
import Clases.Implementacion
import java.sql.PreparedStatement
import java.sql.SQLException

/**
 * Jefe d a o impl
 *
 * @constructor Create empty Jefe d a o impl
 */
class JefeDAOImpl:JefeDAO, Implementacion() {

    private val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    override fun todosLosCampos(): List<Jefe> {
        conexion.conectar()
        val query = Constantes.jefe_sql_select
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val jefe = ArrayList<Jefe>()
        while (rs?.next() == true) {
            val jefee = Jefe(rs.getInt(Constantes.nivelJ), rs.getString(Constantes.nombreJ), rs.getInt(Constantes.vida), rs.getString(
                Constantes.dificultad),rs.getString(Constantes.descripcionJ))
            jefe.add(jefee)
        }
        st?.close()
        conexion.desconectar()
        return jefe
    }

    override fun insertarFila(jefe: Jefe): Boolean {
        var result: Int? = null
        var ps: PreparedStatement? = null
        try {
            conexion.conectar()
            val query = "INSERT INTO jefe (nombre, nivel, vida, dificultad, descripcion) VALUES (?, ?, ?, ?, ?)"
            ps = conexion.getPreparedStatement(query)
            ps?.setString(1, jefe.nombreJ)
            ps?.setInt(2, jefe.nivelJ)
            ps?.setInt(3, jefe.vida)
            ps?.setString(4, jefe.dificultad)
            ps?.setString(5, jefe.descripcionJ)

            result = ps?.executeUpdate()
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            ps?.close()
            conexion.desconectar()
        }
        return result == 1
    }

    override fun recibirDescripcion(nombreJefe: String): String? {
        var result: String? = null
        var ps: PreparedStatement? = null
        try {
            conexion.conectar()
            val query = "SELECT descripcion FROM jefe WHERE nombre = ?"
            ps = conexion.getPreparedStatement(query)
            ps?.setString(1, nombreJefe)
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
        val query = "DELETE FROM jefe WHERE nombre = ?"
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

            if (nombreCampo == "nivel" || nombreCampo == "vida") {
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