import Personaje.Personaje
import Personaje.PersonajeDAOImpl
import Personaje.PersonajeFichero

fun main() {
    val PersonajeDAO = PersonajeDAOImpl()
    val PersonajeFichero = PersonajeFichero()

    val personajes = PersonajeDAO.todosLosCampos()
    println("Lista de personajes:")
    personajes.forEach { println(it) }
    println(personajes)

    val nuevoPersonaje = Personaje("Elena",87,"Maga","La señora del fuego")
    if (PersonajeDAO.insertarFila(nuevoPersonaje)) {
        println("Se insertó correctamente el nuevo personaje ${nuevoPersonaje.nombrePPP}")
    } else {
        println("No se pudo insertar la categoria ${nuevoPersonaje.nombrePPP}")
    }

}


