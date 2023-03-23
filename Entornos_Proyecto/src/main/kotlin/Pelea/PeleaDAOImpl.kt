package Pelea

import ConexionBD
import Constantes
import java.sql.PreparedStatement

class PeleaDAOImpl: PeleaDAO{
    private val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    override fun todosLasPeleas(): List<Pelea> {
        conexion.conectar()
        val query = Constantes.pelea_sql_select
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val pelea = ArrayList<Pelea>()
        while (rs?.next() == true) {
            val pelee = Pelea(rs.getInt(Constantes.nombrePP), rs.getString(Constantes.nombreJJ), rs.getString(Constantes.fecha))
            pelea.add(pelee)
        }
        st?.close()
        conexion.desconectar()
        return pelea
    }
    override fun insertarLista(c:ArrayList<Pelea>):ArrayList<Pelea>{
        conexion.conectar()
        var result:Int?=null
        var ps: PreparedStatement? = null
        var listaNoInsertados = ArrayList<Pelea>()

        val query = Constantes.pelea_sql_insert
        ps = conexion.getPreparedStatement(query)
        for (i in c){
            try {
                ps?.setString(1, i.nombrePP)
                ps?.setString(2, i.nombreJJ)
                ps?.setInt(3, i.fecha)

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