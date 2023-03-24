import Jefe.JefeDAOImpl
import Jefe.JefeFichero

val JefeDAO = JefeDAOImpl()
val JefeFichero = Jefe.JefeFichero()
fun main() {
    val JefeDAO = JefeDAOImpl()
    val JefeFichero = Jefe.JefeFichero()

    val jefe = JefeDAO.todosLosJefes()
    println("Lista de jefes:")
    jefe.forEach { println(it) }
    println(jefe)

}