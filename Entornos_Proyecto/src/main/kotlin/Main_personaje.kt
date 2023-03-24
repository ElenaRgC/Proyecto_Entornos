import Personaje.PersonajeDAOImpl
import Personaje.PersonajeFichero

fun main() {
    val PersonajeDAO = PersonajeDAOImpl()
    val PersonajeFichero = PersonajeFichero()

    val personajes = PersonajeDAO.todosLosPersonajes()
    println("Lista de personajes:")
    personajes.forEach { println(it) }
    println(personajes)

}