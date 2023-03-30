package Jefe

interface JefeDAO {
    fun todosLosCampos(): List<Jefe>
    fun insertarLista(c:ArrayList<Jefe>):ArrayList<Jefe>
    fun insertarFila(jefe: Jefe): Boolean
    fun recibirDescripcion(nombreJefe: String): String?
}