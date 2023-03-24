package Pelea

import ConexionBD
import Constantes
import Habilidad.Habilidad
import java.sql.PreparedStatement
import java.sql.SQLException

class PeleaDAOImpl: PeleaDAO{
    private val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    override fun todosLasPeleas(): List<Pelea> {
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
    override fun insertarPelea(pelea: Pelea): Boolean {
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

}