class Constantes {
    companion object {
        val url="jdbc:mysql://localhost/"
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
        val daño= "daño"
        val nombreP= "nombreP"

        val ficheroHabilidad="Habilidad.txt"

        // JEFE
        val jefe_sql_select = "SELECT * FROM jefe"
        val jefe_sql_insert = "INSERT INTO jefe (nombreJ,nivelJ,vida,dificultad,descripcionJ) VALUES (?, ?,?,?,?)"
        val nombreJ="nombreJ"
        val nivelJ= "nivelJ"
        val vida= "vida"
        val dificultad= "dificultad"
        val descripcionJ= "descripcionJ"

        val ficheroJefe="Jefe.txt"

        // PERSONAJE
        val personaje_sql_select = "SELECT * FROM personaje"
        val personaje_sql_insert = "INSERT INTO personaje (nombreP,nivelP,clase,descripcion) VALUES (?, ?,?,?)"
        val nombrePPP="nombrePPP"
        val nivelP= "nivelP"
        val clase= "clase"
        val descripcionP= "descripcionP"

        val ficheroPersonaje="Personaje.txt"

        // PELEA --> foraneas???????????????
        val pelea_sql_select = "SELECT * FROM pelea"
        val pelea_sql_insert = "INSERT INTO pelea (nombrePP,nombreJJ,fecha) VALUES (?, ?,?)"
        val nombrePP="nombrePP"
        val nombreJJ="nombreJJ"
        val fecha= "fecha"


        val ficheroPelea="Pelea.txt"


    }
}