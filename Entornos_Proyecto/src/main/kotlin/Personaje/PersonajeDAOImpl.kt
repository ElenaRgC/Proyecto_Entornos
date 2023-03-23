package Personaje
import ConexionBD
import java.sql.PreparedStatement

class PersonajeDAOImpl:PersonajeDAO {
    private val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    override fun todosLosPersonajes(): List<Personaje> {
        conexion.conectar()
        val query = Constantes.personaje_sql_select
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val personaje = ArrayList<Personaje>()
        while (rs?.next() == true) {
            val perso = Personaje(rs.getInt(Constantes.nivelP), rs.getString(Constantes.nombrePPP), rs.getString(Constantes.clase),rs.getString(Constantes.descripcionP))
            personaje.add(perso)
        }
        st?.close()
        conexion.desconectar()
        return personaje
    }
    override fun insertarLista(c:ArrayList<Personaje>):ArrayList<Personaje>{
        conexion.conectar()
        var result:Int?=null
        var ps: PreparedStatement? = null
        var listaNoInsertados = ArrayList<Personaje>()

        val query = Constantes.personaje_sql_insert
        ps = conexion.getPreparedStatement(query)
        for (i in c){
            try {
                ps?.setString(1, i.nombrePPP)
                ps?.setInt(2, i.nivelP)
                ps?.setString(3, i.clase)
                ps?.setString(4, i.descripcionP)

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