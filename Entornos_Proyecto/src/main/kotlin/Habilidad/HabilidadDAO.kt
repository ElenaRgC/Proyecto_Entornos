package Habilidad

interface HabilidadDAO {
    fun todosLosCampos(): List<Habilidad>
    fun insertarFila(habilidad: Habilidad): Boolean
    fun recibirDescripcion(nombreHabilidad: String): String?
    fun borrarFila(nombre: String): Boolean
    fun modificarCampo(nombre: String, nombreCampo: String, nuevoValorCampo: String): Boolean
}