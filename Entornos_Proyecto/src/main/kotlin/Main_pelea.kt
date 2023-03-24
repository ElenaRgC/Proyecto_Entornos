import Habilidad.Habilidad
import Pelea.Pelea
import Pelea.PeleaDAOImpl
import Pelea.PeleaFichero

fun main() {
    val PeleaDAO = PeleaDAOImpl()
    val PeleaFichero = PeleaFichero()

    val pelea = PeleaDAO.todosLasPeleas()
    println("Lista de peleas:")
    pelea.forEach { println(it) }
    println(pelea)

    val nuevaPelea = Pelea("Nazeebo", "Valla")
    if (PeleaDAO.insertarPelea(nuevaPelea)) {
        println("Se insertó correctamente la pelea ${nuevaPelea.nombrePP}")
    } else {
        println("No se pudo insertar la pelea ${nuevaPelea.nombreJJ}")
    }
}