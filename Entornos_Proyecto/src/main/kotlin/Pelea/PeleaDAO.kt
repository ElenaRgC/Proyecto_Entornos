package Pelea


interface PeleaDAO {
    fun todosLasPeleas(): List<Pelea>
    fun insertarLista(c:ArrayList<Pelea>):ArrayList<Pelea>
}