package Pelea

import Clases.ConexionBD
import Clases.Constantes
import Clases.Implementacion
import java.sql.PreparedStatement
import java.sql.SQLException

class PeleaDAOImpl: PeleaDAO, Implementacion(){
    private val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
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

    override fun insertarFila(pelea: Pelea): Boolean {
        var result: Int? = null
        var ps: PreparedStatement? = null
        try {
            conexion.conectar()
            val query = "INSERT INTO habilidad (nombrePP, nombreJJ) VALUES (?, ?,)"
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
        return result == 1
    }

    override fun borrarFila(nombre: String): Boolean {
        conexion.conectar()
        val query = "DELETE FROM pelea WHERE nom_personaje = ? OR nom_jefe = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, nombre)
        ps?.setString(2, nombre)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

}