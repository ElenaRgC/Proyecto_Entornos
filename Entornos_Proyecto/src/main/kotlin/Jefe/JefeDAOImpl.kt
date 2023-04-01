package Jefe

import Clases.ConexionBD
import Clases.Constantes
import Clases.Implementacion
import java.sql.PreparedStatement
import java.sql.SQLException

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
    override fun insertarLista(c:ArrayList<Jefe>):ArrayList<Jefe>{
        conexion.conectar()
        var result:Int?=null
        var ps: PreparedStatement? = null
        var listaNoInsertados = ArrayList<Jefe>()

        val query = Constantes.jefe_sql_insert
        ps = conexion.getPreparedStatement(query)
        for (i in c){
            try {
                ps?.setInt(1, i.nivelJ)
                ps?.setString(2, i.nombreJ)
                ps?.setInt(3, i.vida)
                ps?.setString(4, i.dificultad)
                ps?.setString(5, i.descripcionJ)

                result = ps?.executeUpdate()
            }catch (e:Exception){
                //println("no Se puede insertar ${i.codigo}")
                listaNoInsertados.add(i)
            }
        }
        ps?.close()
        conexion.desconectar()
        return listaNoInsertados
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
}