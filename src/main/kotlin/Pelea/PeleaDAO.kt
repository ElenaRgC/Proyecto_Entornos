package Pelea

/**
 * Pelea d a o
 *
 * @constructor Create empty Pelea d a o
 */
interface PeleaDAO {
    /**
     * Todos los campos
     *
     * @return
     */
    fun todosLosCampos(): List<Pelea>

    /**
     * Insertar fila
     *
     * @param pelea
     * @return
     */
    fun insertarFila(pelea: Pelea): Boolean

    /**
     * Borrar fila
     *
     * @param nombre
     * @return
     */
    fun borrarFila(nombre: String): Boolean

    /**
     * Modificar campo
     *
     * @param nombre
     * @param nombreCampo
     * @param nuevoValorCampo
     * @return
     */
    fun modificarCampo(nombre: String, nombreCampo: String, nuevoValorCampo: String): Boolean
}
