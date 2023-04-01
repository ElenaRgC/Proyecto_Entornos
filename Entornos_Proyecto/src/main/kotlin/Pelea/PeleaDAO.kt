package Pelea

interface PeleaDAO {
    fun todosLosCampos(): List<Pelea>
    fun insertarLista(c:ArrayList<Pelea>):ArrayList<Pelea>
    fun insertarFila(pelea: Pelea): Boolean
    fun borrarFila(nombre: String): Boolean
}
