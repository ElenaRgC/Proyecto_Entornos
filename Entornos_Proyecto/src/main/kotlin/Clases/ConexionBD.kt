package Clases

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

    fun devolverTablas(): ArrayList<String> {
        var tablas = ArrayList<String>()
        val meta = conn?.metaData
        val tiposTabla = arrayOf("TABLE")

        val result = meta?.getTables(null, null, null, tiposTabla)

        while (result?.next() == true) {
            val nombreTabla = result.getString("TABLE_NAME")
            tablas.add(nombreTabla)
        }

        return tablas
    }
}