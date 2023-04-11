package Clases

import java.sql.*

/**
 * Clase que se encarga de realizar la conexión y desconexión a una base de datos utilizando JDBC.
 * Contiene métodos para obtener un Statement y un PreparedStatement y para devolver la lista de nombres de las tablas almacenadas en la base de datos.
 *
 * @param url la URL de la base de datos
 * @param user el nombre de usuario para conectarse a la base de datos.
 * @param password la contraseña del usuario para poder conectarse a la base de datos.
 * @constructor Crea una nueva instancia de la clase ConexionBD utilizando los parámetros necesarios para la conexión.
 */
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

    /**
     * Conectar
     * Realiza la conexión a la base de datos.
     */
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

    /**
     * Desconectar
     * Cierra la conexión a la base de datos.
     */
    fun desconectar() {
        try {
            conn?.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    /**
     * Get statement
     *
     * Obtiene un Statement para realizar consultas a la base de datos
     *
     * @return un objeto Statement
     */
    fun getStatement(): Statement? {
        return conn?.createStatement()
    }

    /**
     * Get prepared statement
     *
     * Obtiene un PreparedStatement para realizar consultas parametrizadas a la base de datos.
     *
     * @param sql la consulta SQL parametrizada
     * @return un objeto PreparedStatement
     */
    fun getPreparedStatement(sql: String): PreparedStatement? {
        return conn?.prepareStatement(sql)
    }

    /**
     * Devolver tablas
     *
     * Devuelve la lista de nombres de las tablas almacenadas en la base de datos.
     *
     * @return una lista de cadenas que contiene los nombres de las tablas.
     */
    fun devolverTablas(): ArrayList<String> { // la función devuelve la lista de nombres de las tablas almacenadas en la base de datos. Y es utilizada por imprimirTablas() para obtener los nombres de las tablas almacenadas en la base de datos y devolverlos como una lista de cadenas.
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