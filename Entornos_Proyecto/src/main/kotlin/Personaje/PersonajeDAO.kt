package Personaje

interface PersonajeDAO {
    fun todosLosPersonajes(): List<Personaje>
    fun insertarLista(c:ArrayList<Personaje>):ArrayList<Personaje>

    fun insertarPersonaje(personaje: Personaje): Boolean

    fun recibirDescripcion(nombrePersonaje: String): String?
}