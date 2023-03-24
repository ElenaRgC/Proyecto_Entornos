package Habilidad

import ConexionBD
import Constantes
import java.sql.PreparedStatement
import java.sql.SQLException

class HabilidadDAOImpl: HabilidadDAO{
    private val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    override fun todosLasHabilidades(): List<Habilidad> {
        conexion.conectar()
        val query = Constantes.habilidad_sql_select
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val habilidad = ArrayList<Habilidad>()
        while (rs?.next() == true) {
            val habilidd = Habilidad(rs.getInt(Constantes.nivel), rs.getString(Constantes.nombre), rs.getString(Constantes.elemento), rs.getString(Constantes.descripcion),rs.getInt(Constantes.dano),rs.getString(Constantes.nombreP))
            habilidad.add(habilidd)
        }
        st?.close()
        conexion.desconectar()
        return habilidad
    }
    override fun insertarLista(c:ArrayList<Habilidad>):ArrayList<Habilidad>{
        conexion.conectar()
        var result:Int?=null
        var ps: PreparedStatement? = null
        var listaNoInsertados = ArrayList<Habilidad>()

        val query = Constantes.habilidad_sql_insert
        ps = conexion.getPreparedStatement(query)
        for (i in c){
            try {
                ps?.setString(1, i.nombre)
                ps?.setInt(2, i.nivel)
                ps?.setString(3, i.elemento)
                ps?.setString(4, i.descripcion)
                ps?.setInt(5, i.dano)
                ps?.setString(6, i.nombreP)
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

    override fun insertarHabilidad(habilidad: Habilidad): Boolean {
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

    override fun recibirDescripcion(nombreHabilidad: String): String? {
        var result: String? = null
        var ps: PreparedStatement? = null
        try {
            conexion.conectar()
            val query = "SELECT descripcion FROM habilidad WHERE nombre = $nombreHabilidad"
            val st = conexion.getStatement()
            val rs = st?.executeQuery(query)
            result = rs?.getString(Constantes.descripcion)
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            ps?.close()
            conexion.desconectar()
        }
        return result
    }
}