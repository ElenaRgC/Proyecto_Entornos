import java.sql.*

class ConexionBD {
    var url = Constantes.url
    var user = Constantes.user
    var password = Constantes.password
    val connection = DriverManager.getConnection(url, user, password)

    var conn: Connection? = null

    constructor(ur:String,us:String,pa:String){
        this.url=ur
        this.user=us
        this.password=pa
    }
    fun conectar() {
        try {
            Class.forName(Constantes.forname)
            conn = DriverManager.getConnection(url, user, password)
        } catch (e: SQLException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }
    fun desconectar() {
        try {
            conn?.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }
    fun getStatement(): Statement? {
        return conn?.createStatement()
    }

    fun getPreparedStatement(sql: String): PreparedStatement? {
        return conn?.prepareStatement(sql)
    }
}