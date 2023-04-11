package Personaje
import Clases.ConexionBD
import Clases.Constantes
import Clases.Implementacion
import java.sql.PreparedStatement
import java.sql.SQLException

/**
 * Personaje dao impl
 *
 * @constructor Create empty Personaje dao impl
 */
class PersonajeDAOImpl:PersonajeDAO, Implementacion() {
    private val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    override fun todosLosCampos(): List<Personaje> {
        conexion.conectar()
        val query = Constantes.personaje_sql_select
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val personaje = ArrayList<Personaje>()
        while (rs?.next() == true) {
            val perso = Personaje(rs.getString(Constantes.nombrePPP),rs.getInt(Constantes.nivelP),  rs.getString(Constantes.clase),rs.getString(Constantes.descripcionP))
            personaje.add(perso)
        }
        st?.close()
        conexion.desconectar()
        return personaje
    }

    override fun insertarFila(personaje: Personaje): Boolean {
        var result: Int? = null
        var ps: PreparedStatement? = null
        try {
            conexion.conectar()
            val query = "INSERT INTO personaje (nombre, nivel, clase, descripcion) VALUES (?, ?, ?, ?)"
            ps = conexion.getPreparedStatement(query)
            ps?.setString(1, personaje.nombrePPP)
            ps?.setInt(2, personaje.nivelP)
            ps?.setString(3, personaje.clase)
            ps?.setString(4, personaje.descripcionP)
            result = ps?.executeUpdate()
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            ps?.close()
            conexion.desconectar()
        }
        return result == 1
    }

    override fun recibirDescripcion(nombrePersonaje: String): String? {
        var result: String? = null
        var ps: PreparedStatement? = null
        try {
            conexion.conectar()
            val query = "SELECT descripcion FROM personaje WHERE nombre = ?"
            ps = conexion.getPreparedStatement(query)
            ps?.setString(1, nombrePersonaje)
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

    override fun modificarCampo(nombrePersonaje: String, nombreCampo: String, nuevoValorCampo: String): Boolean {
        var result: Int? = null
        var ps: PreparedStatement? = null
        try {
            conexion.conectar()
            val query = "UPDATE personaje SET $nombreCampo = ? WHERE LOWER(nombre) = ?"
            ps = conexion.getPreparedStatement(query)

            if (nombreCampo == "nivel" ) {
                ps?.setInt(1, nuevoValorCampo.toInt())
            } else {
                ps?.setString(1, nuevoValorCampo)
            }

            ps?.setString(2, nombrePersonaje)

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
