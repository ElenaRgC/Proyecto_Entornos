package Jefe

import ConexionBD
import Constantes
import Jefe.Jefe
import java.sql.PreparedStatement

class JefeDAOImpl:JefeDAO {

    private val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    override fun todosLosJefes(): List<Jefe> {
        conexion.conectar()
        val query = Constantes.jefe_sql_select
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val jefe = ArrayList<Jefe>()
        while (rs?.next() == true) {
            val jefee = Jefe(rs.getInt(Constantes.nivelJ), rs.getString(Constantes.nombreJ), rs.getInt(Constantes.vida), rs.getString(Constantes.dificultad),rs.getString(Constantes.descripcionJ))
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

}