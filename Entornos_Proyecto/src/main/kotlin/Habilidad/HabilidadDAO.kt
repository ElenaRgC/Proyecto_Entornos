package Habilidad

interface HabilidadDAO {
    fun todosLosCampos(): List<Habilidad>
    fun insertarLista(c:ArrayList<Habilidad>):ArrayList<Habilidad>
    fun insertarCampo(habilidad: Habilidad): Boolean
    fun recibirDescripcion(nombreHabilidad: String): String?
    fun borrarFila(nombre: String): Boolean
}