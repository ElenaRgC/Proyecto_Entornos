package Personaje

interface PersonajeDAO {
    fun todosLosCampos(): List<Personaje>
    fun insertarLista(c:ArrayList<Personaje>):ArrayList<Personaje>
    fun insertarFila(personaje: Personaje): Boolean
    fun borrarFila(nombre: String): Boolean
    fun recibirDescripcion(nombrePersonaje: String): String?
}