import Pelea.PeleaDAOImpl
import Pelea.PeleaFichero

val PeleaDAO = PeleaDAOImpl()
val PeleaFichero = PeleaFichero()

fun main() {
    val PeleaDAO = PeleaDAOImpl()
    val PeleaFichero = PeleaFichero()

    val pelea = PeleaDAO.todosLasPeleas()
    println("Lista de peleas:")
    pelea.forEach { println(it) }
    println(pelea)

}