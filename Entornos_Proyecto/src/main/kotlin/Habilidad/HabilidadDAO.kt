package Habilidad

interface HabilidadDAO {
    fun todosLosCampos(): List<Habilidad>
    fun insertarLista(c:ArrayList<Habilidad>):ArrayList<Habilidad>

    fun insertarFila(habilidad: Habilidad): Boolean

    fun recibirDescripcion(nombreHabilidad: String): String?
}