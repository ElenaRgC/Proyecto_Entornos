package Jefe

interface JefeDAO {
    fun todosLosCampos(): List<Jefe>
    fun insertarFila(jefe: Jefe): Boolean
    fun recibirDescripcion(nombreJefe: String): String?
    fun borrarFila(nombre: String): Boolean
}