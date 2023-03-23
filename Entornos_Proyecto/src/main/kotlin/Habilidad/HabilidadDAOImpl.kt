package Habilidad

import ConexionBD
import Constantes
import java.sql.PreparedStatement

class HabilidadDAOImpl: HabilidadDAO{
    private val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    override fun todosLasHabilidades(): List<Habilidad> {
        conexion.conectar()
        val query = Constantes.habilidad_sql_select
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val habilidad = ArrayList<Habilidad>()
        while (rs?.next() == true) {
            val habilidd = Habilidad(rs.getInt(Constantes.nivel), rs.getString(Constantes.nombre), rs.getString(Constantes.elemento), rs.getString(Constantes.descripcion),rs.getString(Constantes.daño),rs.getString(Constantes.nombreP))
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
                ps?.setInt(1, i.nivel)
                ps?.setString(2, i.nombre)
                ps?.setString(3, i.elemento)
                ps?.setString(4, i.descripcion)
                ps?.setString(5, i.daño)
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
}