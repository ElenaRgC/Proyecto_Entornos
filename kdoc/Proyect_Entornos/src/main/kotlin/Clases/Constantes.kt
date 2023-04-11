package Clases

/**
 * Constantes
 *
 * Clase que almacena las constantes utilizadas en la aplicación
 * @constructor Create empty Constantes
 */
class Constantes {
    companion object {
        val url="jdbc:mysql://localhost/diablo"
        val user="root"
        val password=""
        val forname="com.mysql.cj.jdbc.Driver"

        // HABILIDAD
        val habilidad_sql_select = "SELECT * FROM habilidad"
        val habilidad_sql_insert = "INSERT INTO habilidad (nombre,nivel,elemento,descripcion,daño,personaje) VALUES (?, ?,?,?,?,?)"
        val nombre="nombre"
        val nivel= "nivel"
        val elemento= "elemento"
        val descripcion= "descripcion"
        val dano= "dano"
        val nombreP= "nom_personaje"

        val ficheroHabilidad="Habilidad.txt"

        // JEFE
        val jefe_sql_select = "SELECT * FROM jefe"
        val jefe_sql_insert = "INSERT INTO jefe (nombreJ,nivelJ,vida,dificultad,descripcionJ) VALUES (?, ?,?,?,?)"
        val nombreJ="nombre"
        val nivelJ= "nivel"
        val vida= "vida"
        val dificultad= "dificultad"
        val descripcionJ= "descripcion"

        val ficheroJefe="Jefe.txt"

        // PERSONAJE
        val personaje_sql_select = "SELECT * FROM personaje"
        val personaje_sql_insert = "INSERT INTO personaje (nombreP,nivelP,clase,descripcion) VALUES (?, ?,?,?)"
        val nombrePPP="nombre"
        val nivelP= "nivel"
        val clase= "clase"
        val descripcionP= "descripcion"

        val ficheroPersonaje="Personaje.txt"

        // PELEA --> foraneas???????????????
        val pelea_sql_select = "SELECT * FROM pelea"
        val pelea_sql_insert = "INSERT INTO pelea (nombrePP,nombreJJ,fecha) VALUES (?, ?,?)"
        val nombrePP="nom_personaje"
        val nombreJJ="nom_jefe"
        val fecha= "fecha"


    }
}