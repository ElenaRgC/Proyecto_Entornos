package Pelea

interface PeleaDAO {
    fun todosLosCampos(): List<Pelea>
    fun insertarFila(pelea: Pelea): Boolean
    fun borrarFila(nombre: String): Boolean
    fun modificarCampo(nombre: String, nombreCampo: String, nuevoValorCampo: String): Boolean
}
